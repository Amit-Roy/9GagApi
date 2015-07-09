package com.pikle6.api.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

/**
 * Created by pikle6 on 7/8/2015.
 * The only purpose of this class is to get data from url
 * and maybe perform preliminary filtering
 * comments also makes a call to the comments api using the appId
 */
public class Fetch {

    private Fetch(){}

    public static Element getRawImageData(String url)
    {
        Document doc;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").timeout(20000).get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new InvalidException("{\"code\":408,\"message\":\"Request Timed Out :(\"}");
        }
        return doc != null ? doc.getElementsByClass("badge-entry-collection").first() : null;
    }

    public static String getRawCommentData(String url)
    {
        String appId = getAppId(url);
        String commentUrl = "http://comment-cdn.9gag.com/comment?callback=comment_list&appId=" + appId + "&url=" + url + "&order=score&count=10&level=2";
        Document doc;
        try {
            doc = Jsoup.connect(commentUrl).userAgent("Mozilla").timeout(20000).ignoreContentType(true).get();
        } catch (IOException e) {
            throw new InvalidException("{\"code\":404,\"message\":\"Invalid Comment ID\"}");
        }
        if (doc != null) {
            return convertToJsonString(doc.toString().trim());
        }
        else{
            throw new InvalidException("{\"code\":404,\"message\":\"Invalid Comment ID\"}");
        }
    }

    private static String convertToJsonString(String jsonDump){
        int index1 = jsonDump.indexOf("comment_list(")+13;
        int index2 = jsonDump.indexOf(");", index1);
        return jsonDump.substring(index1, index2);
    }

    private static String getAppId(String url){
        Document doc;
        try {
            doc = Jsoup.connect(url).timeout(20000).userAgent("Mozilla").get();
        } catch (IOException e) {
            throw new InvalidException("{\"code\":408,\"message\":\"Request Timed Out :(\"}");
        }
        assert doc != null;
        for(Element scripts : doc.getElementsByTag("script"))
        {
            if(scripts.toString().contains("appId")){
                String appIdUnFormatted = scripts.toString();
                return formatAppId(appIdUnFormatted);
            }
        }
        return null;
    }

    private static String formatAppId(String appIdUnFormatted){
        int index1 = appIdUnFormatted.indexOf("appId");
        int index2 = appIdUnFormatted.indexOf(",", index1);
        appIdUnFormatted = appIdUnFormatted.substring(index1, index2);
        String[] formattedArray = appIdUnFormatted.split("'");
        return formattedArray[formattedArray.length-1];
    }
}
