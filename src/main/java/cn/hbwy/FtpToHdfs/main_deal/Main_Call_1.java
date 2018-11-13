package java.cn.hbwy.FtpToHdfs.main_deal;

import cn.hbwy.FtpToHdfs.ftpdeal.FtpToDisk;
import cn.hbwy.FtpToHdfs.hdfsdeal.CopyFile;
import cn.hbwy.FtpToHdfs.threadpool.MiddleStatus;
import cn.hbwy.FtpToHdfs.threadpool.ThreadPool;
import cn.hbwy.FtpToHdfs.zipdeal.ZipDeal;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * //FtpToDisk ftpToDisk = new FtpToDisk("192.168.43.5",21,"test1","test1","/home/test1/in_zip","/root/temp/out1","20180926173000");
 * // ZipDeal zipDeal = new ZipDeal("/root/temp/out1","/root/temp/extra_out/out1");
 * //copyFile.copyCsvFile("/root/temp/extra_out/out1","/root/temp/final/out3");
 *params:10.261.3.192 21 ftpuser bjxh6Yz+ /opt/ftpuser/zhjk_15kpi /home/vsftpd/hbwy/zip 201810241730 /home/vsftpd/hbwy/extra/201809261730 /home/vsftpd/hbwy/final/
 */
public class Main_Call_1 {
   /* public static void main(String[] args) throws Exception{
        //FtpToDisk ftpToDisk = new FtpToDisk("192.168.43.5",21,"test1","test1","/home/test1/in_zip","/root/temp/out1","20180926173000");
        FtpToDisk ftpToDisk = new FtpToDisk("192.168.43.5",21,"test1","test1","/home/test1/in_zip","/root/temp/out1","20180926173000");
        ftpToDisk.getZipFile();
        // ZipDeal zipDeal = new ZipDeal("/root/temp/out1","/root/temp/extra_out/out1");
       *//* ZipDeal zipDeal = new ZipDeal(args[5],args[7]);
        zipDeal.unZip();
        CopyFile copyFile = new CopyFile();
        //copyFile.copyCsvFile("/root/temp/extra_out/out1","/root/temp/final/out3");
        copyFile.copyCsvFile(args[7],args[8]);
        ThreadPool.getThreadPool().shutdown();*//*
    }*/

    public static void main(String[] args) throws Exception{
        System.out.println(getTime()+"   Start Progess......");
        //FtpToDisk ftpToDisk = new FtpToDisk("192.168.43.5",21,"test1","test1","/home/test1/in_zip","/root/temp/out1","201809261730");
        /*FtpToDisk ftpToDisk = new FtpToDisk(args[0],Integer.parseInt(args[1]),args[2],args[3],args[4],args[5]+"/"+args[6],args[6]);
        ftpToDisk.getZipFile();
        System.out.println("Work Path:"+args[4]);
        System.out.println("Zip Path:"+args[5]+"/"+args[6]);*/
        System.out.println(getTime()+"   ZIP Complete......");
       // ZipDeal zipDeal = new ZipDeal("/root/temp/out1","/root/temp/extra_out/out1");
        System.out.println(getTime()+"   UNZIP Start Progess......");
        ZipDeal zipDeal = new ZipDeal("C:\\Users\\lkz\\Desktop\\河北项目\\1001之前\\0926数据\\test","H:\\out\\extra\\201809261730","");
        zipDeal.unZip();
       // System.out.println("Extract Path:"+args[7]+"/"+args[6]);
        System.out.println(getTime()+"   UNZIP Complete......");
        System.out.println(getTime()+"   CopyCsv Start Progess......");
        CopyFile copyFile = new CopyFile();
        //copyFile.copyCsvFile("/root/temp/extra_out/out1","/root/temp/final/out3");
        while(MiddleStatus.getNowFiles()!=MiddleStatus.getNumFiles()){
            Thread.sleep(1000);
        }
        copyFile.copyCsvFile("H:\\out\\extra\\201809261730","H:\\out\\final\\201809261730","201809261730","");
        System.out.println(getTime()+"   CopyCsv Complete......");
        ThreadPool.getThreadPool().shutdown();
        System.out.println(getTime()+"   Stop Progess......");
    }
    public static String getTime(){
        Date d=new Date();
        Long a=d.getTime();
        SimpleDateFormat sim =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sim.format(a);
    }
}
