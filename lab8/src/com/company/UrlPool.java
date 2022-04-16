package com.company;

import java.util.LinkedList;

public class UrlPool {
    LinkedList<UrlDepthPair> findLink;
    LinkedList<UrlDepthPair> viewedLink;
    int maxDepth;
    int cWait;

    public UrlPool(int maxDepth) {
        this.maxDepth = maxDepth;
        this.findLink = new LinkedList();
        this.viewedLink = new LinkedList();
        this.cWait = 0;
    }

    public synchronized UrlDepthPair getPair() {
        for(; this.findLink.size() == 0; --this.cWait) {
            ++this.cWait;

            try {
                this.wait();
            } catch (InterruptedException var2) {
                System.out.println("Ignoring InterruptedException");
            }
        }

        UrlDepthPair nextPair = (UrlDepthPair)this.findLink.removeFirst();
        return nextPair;
    }

    public synchronized void addPair(UrlDepthPair pair) {
        if (UrlDepthPair.check(this.viewedLink, pair)) {
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

    public LinkedList<UrlDepthPair> getResult() {
        return this.viewedLink;
    }
}
