package com.pikle6.api.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pikle6 on 7/9/2015.
 * using 9gags comment api
 */
public class CommentExtractor {
    public static List<Comment> getComments(String id){
        return extractComments(Fetch.getRawCommentData("http://9gag.com/gag/" + id));
    }

    private static List<Comment> extractComments(String jsonString){
        JSONParser parser = new JSONParser();
        JSONObject obj;
        try {
            obj = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            throw new InvalidException("{\"code\":500,\"message\":\"Sorry but the JSON data returned from the api is invalid\"}");
        }
        assert obj != null;
        JSONObject payload = (JSONObject) obj.get("payload");
        JSONArray commentsJson = (JSONArray) payload.get("comments");
        return extractCommentsFromJson(commentsJson);
    }

    private static List<Comment> extractCommentsFromJson(JSONArray commentsJson) {
        List<Comment> comments = new ArrayList<Comment>();
        for (Object aCommentsJson : commentsJson) {
            JSONObject commentJson = (JSONObject) aCommentsJson;
            Comment root = extractCommentFromJsonObject(commentJson);
            JSONArray children = (JSONArray) commentJson.get("children");
            for (Object aChildren : children) {
                JSONObject childJson = (JSONObject) aChildren;
                Comment child = extractCommentFromJsonObject(childJson);
                root.addReply(child);
            }
            comments.add(root);
        }
        return comments;
    }

    private static Comment extractCommentFromJsonObject(JSONObject comment){
        JSONObject user = (JSONObject) comment.get("user");
        return new Comment(
                (String) user.get("displayName"),
                (String) comment.get("text"),
                (String) user.get("avatarUrl"),
                (Long) comment.get("likeCount")
        );
    }
}
