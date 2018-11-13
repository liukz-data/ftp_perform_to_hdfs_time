package cn.hbwy.FtpToHdfs.zipdeal;

import cn.hbwy.FtpToHdfs.hdfsdeal.CopyFile;
import cn.hbwy.FtpToHdfs.log_util.Log4jUtil;
import cn.hbwy.FtpToHdfs.threadpool.MiddleStatus;
import cn.hbwy.FtpToHdfs.threadpool.ThreadPool;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.log4j.Logger;


import java.io.File;

import java.util.concurrent.ExecutorService;

public class ZipDeal {
    private String outPath="/root/temp/out";
    private String zip_outPath="/root/temp/extra_out/out";
    private String confPath="";

    public ZipDeal(String outPath, String zip_outPath,String confPath) {
        this.outPath = outPath;
        this.zip_outPath = zip_outPath;
        this.confPath=confPath;
    }

    public void unZip() throws Exception{
        File fileDIr = new File(outPath);
        File zip_fileDIr = new File(zip_outPath);
        final Logger logger = Log4jUtil.getLogger(confPath, ZipDeal.class);
        String[] fileNames=fileDIr.list();
        if(fileNames == null){
            logger.error("NO FILENAME............SYSTEM EXIT");
            System.exit(-1);
        }
        MiddleStatus.setNumFiles(fileNames.length);
        ExecutorService pool= ThreadPool.getThreadPool();

        for (String fileName:fileNames) {
           // System.out.println("UNZIP FILE:  "+fileName);
            final ZipFile zf = new ZipFile(outPath+"/"+fileName);
            if(!zip_fileDIr.exists()){
                zip_fileDIr.mkdirs();
            }
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        zf.extractAll(zip_outPath);
                       int i= MiddleStatus.getNowFiles();
                        MiddleStatus.setNowFiles(i+1);
                    } catch (ZipException e) {
                        logger.error(e);
                        e.printStackTrace();
                    }
                }
            });

        }
        /*ZipFile zf = new ZipFile("/root/temp/out/1.zip");
        zf.extractAll("/root/temp/out/test_z");
        File f = new File("/root/temp/out/test_z/test1.txt");
        System.out.println("length:"+f.length()/1024);


        BufferedInputStream bfin_1=new BufferedInputStream(new FileInputStream(f));
        BufferedInputStream bfin_2=new BufferedInputStream(new FileInputStream(f));
        arr.add(bfin_1);
        arr.add(bfin_2);
        FileOutputStream fo=new FileOutputStream("/root/temp/out/test_z/out/1.txt");
        byte[] by=new byte[1024];
        int recount=0;
        while((recount=arr.get(0).read(by))>0){
            fo.write(by,0,recount);
        }
        while((recount=arr.get(1).read(by))>0){
            fo.write(by,0,recount);
        }*/
    }

}
