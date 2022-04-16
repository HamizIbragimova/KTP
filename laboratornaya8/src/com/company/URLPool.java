package com.company;
import java.util.LinkedList;

public class URLPool {

    LinkedList<URLDepthPair> findLink;
    LinkedList<URLDepthPair> viewedLink;
    int maxDepth;
    int cWait;

    public URLPool(int maxDepth) {
        this.maxDepth = maxDepth;
        this.findLink = new LinkedList();
        this.viewedLink = new LinkedList();
        this.cWait = 0;
    }

    public synchronized URLDepthPair getPair() {
        for(; this.findLink.size() == 0; --this.cWait) {
            ++this.cWait;

            try {
                this.wait();
            } catch (InterruptedException var2) {
                System.out.println("Ignoring InterruptedException");
            }
        }

        URLDepthPair nextPair = (URLDepthPair)this.findLink.removeFirst();
        return nextPair;
    }

    public synchronized void addPair(URLDepthPair pair) {
        if (URLDepthPair.check(this.viewedLink, pair)) {
            this.viewedLink.add(pair);
            if (pair.getDepth() < this.maxDepth) {
                this.findLink.add(pair);
                this.notify();
            }
        }

    }

    public synchronized int getWait() {
        return this.cWait;
    }

    public LinkedList<URLDepthPair> getResult() {
        return this.viewedLink;
    }

}
