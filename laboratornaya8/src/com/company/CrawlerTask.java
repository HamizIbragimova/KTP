package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class CrawlerTask implements Runnable {
    URLPool urlPool;
    public static final String URL_PREFIX = "http:";

    public CrawlerTask(URLPool pool) {
        this.urlPool = pool;
    }

    public static void request(PrintWriter out, URLDepthPair pair) {
        out.println("GET " + pair.getPath() + " HTTP/1.1");
        out.println("Host: " + pair.getHost());
        out.println("Connection: close");
        out.println();
        out.flush();
    }

    public static void buildNewUrl(String str, int depth, URLPool pool) {
        try {
            int end_of_link = str.indexOf("\"", str.indexOf("http:"));
            if (end_of_link == -1 || str.indexOf("'", str.indexOf("http:")) != -1 && str.indexOf("'", str.indexOf("http:")) < end_of_link) {
                end_of_link = str.indexOf("'", str.indexOf("http:"));
            }

            if (end_of_link == -1 || str.indexOf("<", str.indexOf("http:")) - 1 != -1 && str.indexOf("<", str.indexOf("http:")) - 1 < end_of_link) {
                end_of_link = str.indexOf("<", str.indexOf("http:")) - 1;
            }

            String currentLink = str.substring(str.indexOf("http:"), end_of_link);
            pool.addPair(new URLDepthPair(currentLink, depth + 1));
        } catch (StringIndexOutOfBoundsException var5) {
        }

    }

    public void run() {
        while(true) {
            URLDepthPair currentPair = this.urlPool.getPair();

            try {
                Socket my_socket = new Socket(currentPair.getHost(), 80);
                my_socket.setSoTimeout(1000);

                try {
                    PrintWriter out = new PrintWriter(my_socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
                    request(out, currentPair);

                    String line;
                    while((line = in.readLine()) != null) {
                        if (line.indexOf("http:") != -1) {
                            buildNewUrl(line, currentPair.getDepth(), this.urlPool);
                        }
                    }

                    my_socket.close();
                } catch (SocketTimeoutException var6) {
                    my_socket.close();
                }
            } catch (IOException var7) {
            }
        }
    }
}

