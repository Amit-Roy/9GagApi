package com.pikle6.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikle6 on 7/9/2015.
 * class to hold all the comment data
 */
public class Comment {
    private String handle;
    private String comment;
    private String avatarUrl;
    private long votes;
    private List<Comment> replies;

    public Comment(String handle, String comment, String avatarUrl, long votes) {
        this.handle = handle;
        this.comment = comment;
        this.avatarUrl = avatarUrl;
        this.votes = votes;
        replies = new LinkedList<Comment>();
    }

    public void addReply(Comment reply) {
        this.replies.add(reply);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "handle='" + handle + '\'' +
                ", comment='" + comment + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", votes=" + votes +
                ", replies=" + replies +
                '}';
    }

    @JsonProperty
    public String getHandle() {
        return handle;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    @JsonProperty
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty
    public long getVotes() {
        return votes;
    }

    @JsonProperty
    public List<Comment> getReplies() {
        return replies;
    }
}
