package cn.hbwy.FtpToHdfs.main_deal;

import cn.hbwy.FtpToHdfs.threadpool.ThreadPool;

public class test {
    public static void main(String[] args) {
       /* ThreadPool.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {

                    System.out.println(i);
                    long i2=(long)50;
                    try {
                        Thread.sleep(i2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });*/
        System.out.println(Runtime.getRuntime().availableProcessors());
        /*ThreadPool.getThreadPool().shutdown();*/
    }
}
