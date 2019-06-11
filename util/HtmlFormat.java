package com.example.water.marketplace.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

/**
 * Created by water on 29.09.2017.
 */

public class HtmlFormat {
    public static String getNewContent(String htmltext){

        org.jsoup.nodes.Document doc= Jsoup.parse(htmltext);
        Elements elements=doc.getElementsByTag("img");
        for (Element element : elements) {
            if (!element.attr("class").equals("avatar"))
                element.attr("width","100%").attr("height","auto");
        }

        return doc.toString();
    }
}
