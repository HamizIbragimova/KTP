package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
public class URLDepthPair {
    public static final String URL_PREFIX = "http://";
    public String URL;
    public int depth;

    public URLDepthPair(String URL, int depth) {
        this.URL = URL;
        this.depth = depth;
    }

    public String getHost() throws MalformedURLException {
        URL host = new URL(this.URL);
        return host.getHost();
    }

    public String getPath() throws MalformedURLException {
        URL path = new URL(this.URL);
        return path.getPath();
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
