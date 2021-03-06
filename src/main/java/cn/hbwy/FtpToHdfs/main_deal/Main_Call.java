package cn.hbwy.FtpToHdfs.main_deal;

import cn.hbwy.FtpToHdfs.ftpdeal.FtpToDisk;
import cn.hbwy.FtpToHdfs.hdfsdeal.CopyFile;
import cn.hbwy.FtpToHdfs.log_util.Log4jUtil;
import cn.hbwy.FtpToHdfs.threadpool.MiddleStatus;
import cn.hbwy.FtpToHdfs.threadpool.ThreadPool;
import cn.hbwy.FtpToHdfs.zipdeal.ZipDeal;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *主程序入口
 * 参数示例：params:10.261.3.192 21 ftpuser bjxh6Yz+ /opt/ftpuser/zhjk_15kpi /home/vsftpd/hbwy/zip 201810241730 /home/vsftpd/hbwy/extra/201809261730 /home/vsftpd/hbwy/final/
 */
public class Main_Call {
    public static void main(String[] args) {
        Logger logger = Log4jUtil.getLogger(args[9], Main_Call.class);
        logger.info("   Start Progess......");
        //下载
        FtpToDisk ftpToDisk = new FtpToDisk(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4], args[5] + "/" + args[6], args[6]);
        try {
            ftpToDisk.getZipFile(args[10]);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        logger.info("   Work Path:" + args[4]);
        logger.info("   Zip Path:" + args[5] + "/" + args[6]);
        logger.info("   ZIP Complete......");
        logger.info("   UNZIP Start Progess......");
        //解压
        ZipDeal zipDeal = new ZipDeal(args[5] + "/" + args[6], args[7] + "/" + args[6], args[9]);
        try {
            zipDeal.unZip();
        } catch (Exception e) {
            logger.info(e);
            e.printStackTrace();
        }
        logger.info("   Extract Path:" + args[7] + "/" + args[6]);
        logger.info("   UNZIP Complete......");
        logger.info("   CopyCsv Start Progess......");
        //放入结果文件夹
        CopyFile copyFile = new CopyFile();
       int c_1 = 0;
        while (MiddleStatus.getNowFiles() != MiddleStatus.getNumFiles()) {
            try {

                Thread.sleep(500);
                if (c_1 == 7) {
                    break;
                }
                c_1++;
            } catch (InterruptedException e) {
                logger.info(e);
                e.printStackTrace();
            }
        }
        MiddleStatus.setNowFiles(0);
        try {

            copyFile.copyCsvFile(args[7] + "/" + args[6], args[8], args[6], args[9]);
        } catch (Exception e) {
            logger.info(e);
            e.printStackTrace();
        }
        logger.info("TOTAL NUMFILES:" + MiddleStatus.getNumFiles() + "----------------------------------");
        int c_2 = 0;
        while (MiddleStatus.getNowFiles() != MiddleStatus.getNumFiles()) {
            logger.info("NOW NUMFILES:" + MiddleStatus.getNowFiles() + "---------------------------------------------------------------------");
            try {
                Thread.sleep(500);
                if (c_2 == 7) {
                    break;
                }
                c_2++;
            } catch (InterruptedException e) {
                logger.info(e);
                e.printStackTrace();
            }
        }
        logger.info("NOW NUMFILES:" + MiddleStatus.getNowFiles() + "---------------------------------------------------------------------");
        logger.info("   CopyCsv Complete......");
        ThreadPool.getThreadPool().shutdown();
        logger.info("   Stop Progess......");
    }

    public static String getTime() {
        Date d = new Date();
        Long a = d.getTime();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sim.format(a);
    }
}
