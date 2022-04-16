package com.company;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;

public class Crawler {
    public Crawler() {
    }

    public static void showResult(LinkedList<URLDepthPair> resultLink) {
        Iterator var1 = resultLink.iterator();

        while(var1.hasNext()) {
            URLDepthPair c = (URLDepthPair)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = c.getDepth();
            var10000.println("Depth :" + var10001 + "\tLink :" + c.getURL());
        }

    }

    public static boolean checkDigit(String line) {
        boolean isDigit = true;

        for(int i = 0; i < line.length() && isDigit; ++i) {
            isDigit = Character.isDigit(line.charAt(i));
        }

        return isDigit;
    }

    public static void main(String[] args) {
        args = new String[]{"https://natribu.org/ru", "10", "10"};
        if (args.length == 3 && checkDigit(args[1]) && checkDigit(args[2])) {
            String lineUrl = args[0];
            int numThreads = Integer.parseInt(args[2]);
            URLPool pool = new URLPool(Integer.parseInt(args[1]));
            pool.addPair(new URLDepthPair(lineUrl, 0));

            for(int i = 0; i < numThreads; ++i) {
                CrawlerTask c = new CrawlerTask(pool);
                Thread t = new Thread(c);
                t.start();
            }

            while(pool.getWait() != numThreads) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException var8) {
                    System.out.println("Ignoring  InterruptedException");
                }
            }

            try {
                showResult(pool.getResult());
            } catch (NullPointerException var7) {
                System.out.println("Not Link");
            }

            System.exit(0);
        } else {
            System.out.println("usage: java Crawler <URL> <maximum_depth> <num_threads> or second/third not digit");
        }

    }
}
