package com.pikle6.api.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pikle6 on 7/8/2015.
 * The function in this class fetch the following
 * Default - gets 10 images from the main page
 * get more - get the next 10 in sequence
 * get comments - gets the comments for a specific id
 */
public class ImageExtractor
{
    private static String HOME_URL = "http://9gag.com/";
    private static String PARAM_URL = HOME_URL + "?id=";

    public static ImagePair getImages(String param)
    {
        return extractImages(param == null?Fetch.getRawImageData(HOME_URL):Fetch.getRawImageData(PARAM_URL+param));
    }

    private static ImagePair extractImages(Element rawImageData)
    {
        List<Image> images = new ArrayList<Image>();
        for(Element article : extractArticlesFromRawImageData(rawImageData))
        {
            Element imgTag = extractImgTagFromArticle(article);
            Element postContainer = extractPostContainerFromArticle(article);
            String url = extractUrlFromPostContainer(postContainer, imgTag);
            int[] dim = getImageDimensions(url);
            images.add(new Image(
                    extractIdFromArticle(article),
                    url,
                    extractTitleFromImgTag(postContainer, imgTag),
                    extractTypeFromUrl(url),
                    dim[0],
                    dim[1]
            ));
        }
        return new ImagePair(images);
    }

    private static int[] getImageDimensions(String url){
        int[] dim = new int[2];
        if(url.equals("NOT SAFE FOR WORK")){
            dim[0] = 0; dim[1] = 0;
            return dim;
        }
        else {
            ImageInputStream in = null;
            try {
                in = ImageIO.createImageInputStream(new URL(url).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                try {
                    reader.setInput(in);
                    dim[0] = reader.getWidth(0);
                    dim[1] = reader.getHeight(0);
                    return dim;
                } catch (IOException e) {
                    dim[0] = 0; dim[1] = 0;
                    return dim;
                } finally {
                    reader.dispose();
                }
            }
            dim[0] = 0; dim[1] = 0;
            return dim;
        }
    }

    // level 1

    private static Elements extractArticlesFromRawImageData(Element rawImageData)
    {
        return rawImageData.getElementsByTag("article");
    }

    // level 2

    private static Element extractPostContainerFromArticle(Element article)
    {
        return article.getElementsByClass("post-container").first();
    }

    private static Element extractImgTagFromArticle(Element article)
    {
        return article.getElementsByClass("badge-item-img").first();
    }


    // level 3

    private static String extractIdFromArticle(Element article)
    {
        return article.attr("data-entry-id");
    }

    private static String extractTitleFromImgTag(Element postContainer, Element imgTag)
    {
        if(!isNSFW(postContainer))
        {
            return imgTag.attr("alt");
        }
        else
        {
            return "NOT SAFE FOR WORK";
        }
    }

    private static String extractUrlFromPostContainer(Element postContainer, Element imgTag) {
        if(!isNSFW(postContainer))
        {
            if (isPostContianerGif(postContainer)) {
                return postContainer.getElementsByClass("badge-animated-container-animated").first().attr("data-image");
            } else {
                return imgTag.attr("src");
            }
        }
        else
        {
            return "NOT SAFE FOR WORK";
        }
    }

    private static boolean isNSFW(Element postContainer){
        Elements divsInsidePostContainer = postContainer.getElementsByTag("div");
        for(Element div : divsInsidePostContainer)
        {
            if(div.hasClass("nsfw-post"))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isPostContianerGif(Element postContainer)
    {
        Elements divsInsidePostContainer = postContainer.getElementsByTag("div");
        for(Element div : divsInsidePostContainer)
        {
            if(div.hasClass("gif-post"))
            {
                return true;
            }
        }
        return false;
    }

    // level 4

    private static String extractTypeFromUrl(String url)
    {
        return url.substring(url.length()-3);
    }
}
