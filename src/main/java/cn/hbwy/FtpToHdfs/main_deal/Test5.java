package cn.hbwy.FtpToHdfs.main_deal;

import cn.hbwy.FtpToHdfs.threadpool.MiddleStatus;

public class Test5 {
    public static void main(String[] args) {
        int c_2=0;
        while(1!=2){
            //logger.info("NOW NUMFILES:"+MiddleStatus.getNowFiles()+"---------------------------------------------------------------------");
            try {
                Thread.sleep(500)
                ;
                if(c_2==7){
                    System.out.println(c_2);
                    break;
                }
                c_2++;
            } catch (InterruptedException e) {
               // logger.info(e);
                e.printStackTrace();
            }
        }
    }
}
