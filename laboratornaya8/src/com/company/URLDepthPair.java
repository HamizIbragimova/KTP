package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
public class URLDepthPair {
    public static final String URL_PREFIX = "http:";
    public String URL;
    private int depth;
    URL host_path;

    public URLDepthPair(String URL, int depth) {
        this.URL = URL;
        this.depth = depth;

        try {
            this.host_path = new URL(URL);
        } catch (MalformedURLException var4) {
            var4.printStackTrace();
        }

    }

    public String getHost() {
        return this.host_path.getHost();
    }

    public String getPath() {
        return this.host_path.getPath();
    }

    public int getDepth() {
        return this.depth;
    }

    public String getURL() {
        return this.URL;
    }

    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair) {
        boolean isAlready = true;
        Iterator var3 = resultLink.iterator();

        while(var3.hasNext()) {
            URLDepthPair c = (URLDepthPair)var3.next();
            if (c.getURL().equals(pair.getURL())) {
                isAlready = false;
            }
        }

        return isAlready;
    }
}
