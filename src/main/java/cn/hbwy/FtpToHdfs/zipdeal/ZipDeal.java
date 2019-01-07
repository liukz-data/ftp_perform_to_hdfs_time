package cn.hbwy.FtpToHdfs.zipdeal;

import cn.hbwy.FtpToHdfs.log_util.Log4jUtil;
import cn.hbwy.FtpToHdfs.threadpool.MiddleStatus;
import cn.hbwy.FtpToHdfs.threadpool.ThreadPool;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.ExecutorService;

public class ZipDeal {
    private String outPath = "/root/temp/out";
    private String zip_outPath = "/root/temp/extra_out/out";
    private String confPath = "";

    public ZipDeal(String outPath, String zip_outPath, String confPath) {
        this.outPath = outPath;
        this.zip_outPath = zip_outPath;
        this.confPath = confPath;
    }

    public void unZip() throws Exception {
        File fileDIr = new File(outPath);
        File zip_fileDIr = new File(zip_outPath);
        final Logger logger = Log4jUtil.getLogger(confPath, ZipDeal.class);
        String[] fileNames = fileDIr.list();
        if (fileNames == null) {
            logger.error("NO FILENAME............SYSTEM EXIT");
            System.exit(-1);
        }
        MiddleStatus.setNumFiles(fileNames.length);
        ExecutorService pool = ThreadPool.getThreadPool();

        for (String fileName : fileNames) {
            // System.out.println("UNZIP FILE:  "+fileName);
            final ZipFile zf = new ZipFile(outPath + "/" + fileName);
            if (!zip_fileDIr.exists()) {
                zip_fileDIr.mkdirs();
            }
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        zf.extractAll(zip_outPath);
                        int i = MiddleStatus.getNowFiles();
                        MiddleStatus.setNowFiles(i + 1);
                    } catch (ZipException e) {
                        logger.error(e);
                        e.printStackTrace();
                    }
                }
            });

        }

    }

}
