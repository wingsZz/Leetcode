package com.practice.leetcode.thread.bigdata;

import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : yueqi.zhou
 * @date : 2021-03-03 22:10
 * describe :
 */
public class BigFileDownloader {
    protected URL requestUrl;
    protected long fileSize;

    protected Storage storage;
    private AtomicBoolean taskCanceled = new AtomicBoolean(false);

    public BigFileDownloader(String url) throws Exception {
        requestUrl = new URL(url);
        fileSize = 100;
        String fileName = url.substring(url.lastIndexOf('/' + 1));
        storage = new Storage(fileSize, fileName);

    }

    public void download(int taskCount, long reportInterval) {
        long chunkSizePerThread = fileSize / taskCount;
        long lowerBound = 0;
        long upperBound = 0;

        DownloadTask task;
        for (int i = 0; i < taskCount; i++) {
            lowerBound = i * chunkSizePerThread;
            if (i == taskCount - 1) {
                upperBound = fileSize;
            } else {
                upperBound = lowerBound + chunkSizePerThread - 1;
            }

            task = new DownloadTask(lowerBound, upperBound, requestUrl, storage, taskCanceled);
            dispatchWork(task, i);
        }


    }

    private void dispatchWork(DownloadTask task, int workIndex) {
        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    cancelDownload();
                }
            }
        });
        workerThread.setName("downloader-" + workIndex);
        workerThread.start();
    }

    private void reportProgress() {

    }

    private void doCleanup() {

    }

    private void cancelDownload() {
        if (taskCanceled.compareAndSet(false, true)) {
            doCleanup();
        }
    }
}
