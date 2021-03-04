package com.practice.leetcode.thread.bigdata;

import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : yueqi.zhou
 * @date : 2021-03-03 22:20
 * describe :
 */
public class DownloadTask implements Runnable{

    private long lowerBound;
    private long upperBound;
    private URL requestURL;
    private Storage storage;
    private AtomicBoolean taskCanceled;

    public DownloadTask(long lowerBound, long upperBound, URL requestURL, Storage storage,AtomicBoolean taskCanceled) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.requestURL = requestURL;
        this.storage = storage;
        this.taskCanceled = taskCanceled;
    }

    @Override
    public void run() {
        if (taskCanceled.get()){
            return;
        }

        while(!taskCanceled.get()){
            System.out.println("Downloading...");
        }
    }
}
