package cn.hbwy.FtpToHdfs.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);

    public ThreadPool() {
    }

    public static ExecutorService getThreadPool() {
        return executorService;
    }

}
