package cn.hbwy.FtpToHdfs.threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MiddleStatus {
    private static int numFiles=0;
    private static volatile int nowNum=0;
    private static Lock lock=new ReentrantLock();
    public static void setNowFiles(int sumOne){
        lock.lock();
       try {
              MiddleStatus.nowNum = sumOne;
       }finally {
           lock.unlock();
       }

    }
    public static void setNumFiles(int numFiles){
       MiddleStatus.numFiles=numFiles;
    }
    public static int getNumFiles(){
            return MiddleStatus.numFiles;
   }
    public static int getNowFiles(){
        lock.lock();
        try {
            return MiddleStatus.nowNum;
        }finally {
            lock.unlock();
        }
    }
}
