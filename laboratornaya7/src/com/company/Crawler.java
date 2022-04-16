package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.LinkedList;

public class Crawler {
    static LinkedList<URLDepthPair> findLink = new LinkedList();
    static LinkedList<URLDepthPair> viewedLink = new LinkedList();

    public Crawler() {
    }

    public static void showResult(LinkedList<URLDepthPair> viewedLink) {
        Iterator var1 = viewedLink.iterator();

        while(var1.hasNext()) {
            URLDepthPair c = (URLDepthPair)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = c.getDepth();
            var10000.println("Depth : " + var10001 + "\tLink : " + c.getURL());
        }

    }

    public static void request(PrintWriter out, URLDepthPair pair) throws MalformedURLException {
        out.println("GET " + pair.getPath() + " HTTP/1.1");
        out.println("Host: " + pair.getHost());
        out.println("Connection: close");
        out.println();
        out.flush();
    }

    public static void Process(String pair, int maxDepth) throws IOException {
        findLink.add(new URLDepthPair(pair, 0));

        URLDepthPair currentPair;
        label63:
        for(; !findLink.isEmpty(); viewedLink.add(currentPair)) {
            currentPair = (URLDepthPair)findLink.removeFirst();
            if (currentPair.depth < maxDepth) {
                Socket my_socket = new Socket(currentPair.getHost(), 80);
                my_socket.setSoTimeout(1000);

                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
                    PrintWriter out = new PrintWriter(my_socket.getOutputStream(), true);
                    request(out, currentPair);

                    while(true) {
                        String line;
                        do {
                            do {
                                if ((line = in.readLine()) == null) {
                                    my_socket.close();
                                    continue label63;
                                }
                            } while(line.indexOf("http://") == -1);
                        } while(line.indexOf(34) == -1);

                        StringBuilder currentLink = new StringBuilder();

                        for(int i = line.indexOf("http://"); line.charAt(i) != '"' && line.charAt(i) != ' '; ++i) {
                            if (line.charAt(i) == '<') {
                                currentLink.deleteCharAt(currentLink.length() - 1);
                                break;
                            }

                            currentLink.append(line.charAt(i));
                        }

                        URLDepthPair newPair = new URLDepthPair(currentLink.toString(), currentPair.depth + 1);
                        if (URLDepthPair.check(findLink, newPair) && URLDepthPair.check(viewedLink, newPair) && !currentPair.URL.equals(newPair.URL)) {
                            findLink.add(newPair);
                        }
                    }
                } catch (SocketTimeoutException var10) {
                    my_socket.close();
                }
            }
        }

        showResult(viewedLink);
    }

    public static void main(String[] args) {
        String[] arg = new String[]{"https://natribu.org/ru", "4"};

        try {
            Process(arg[0], Integer.parseInt(arg[1]));
        } catch (IOException | NumberFormatException var3) {
            System.out.println("usage: java crawler " + arg[0] + " " + arg[1]);
        }

    }
}
