package cn.hbwy.FtpToHdfs.hdfsdeal;


import cn.hbwy.FtpToHdfs.log_util.Log4jUtil;
import cn.hbwy.FtpToHdfs.threadpool.MiddleStatus;
import cn.hbwy.FtpToHdfs.threadpool.ThreadPool;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class CopyFile {
    private String zip_outPath = "/root/temp/extra_out/out";
    private String finalPath = "/root/temp/final/out1";

    public CopyFile() {
    }

    public void copyCsvFile(String zip_outPath, final String finalPath,final String region,final String confPath){
        ArrayList<File> files = new FindCsv().getFiles(zip_outPath);
        MiddleStatus.setNumFiles(files.size());
        final Logger logger = Log4jUtil.getLogger(confPath,CopyFile.class);
        try {
            File d1=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM/" +region);
            if(!d1.exists()){
                d1.mkdirs();
            }
            File f1=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM/" +region+"/reduce_error.csv");
            f1.createNewFile();
            File d2=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB/" +region);
            if(!d2.exists()){
                d2.mkdirs();
            }
            File f2=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB/" +region+"/reduce_error.csv");
            f2.createNewFile();
            File d3=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM/" +region);
            if(!d3.exists()){
                d3.mkdirs();
            }
            File f3=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM/" +region+"/reduce_error.csv");
            f3.createNewFile();
            File d4=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM/" +region);
            if(!d4.exists()){
                d4.mkdirs();
            }
            File f4=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM/" +region+"/reduce_error.csv");
            f4.createNewFile();
            File d5 =new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM/" +region);
            if(!d5.exists()){
                d5.mkdirs();
            }
            File f5=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM/" +region+"/reduce_error.csv");
            f5.createNewFile();
            /*File d6=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_ENB_TDD_V2.9/" +region);
            if(!d6.exists()){
                d6.mkdirs();
            }
            File f6=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_ENB_TDD_V2.9/" +region+"/reduce_error.csv");
            f6.createNewFile();*/
        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
        }

        ExecutorService executorService = ThreadPool.getThreadPool();
        for (final File file : files) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    String fileName = file.getName();
                    if (fileName.matches("ODM-.*_V2.6.0_.*")) {
                       // System.out.println(file.length()+":"+finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM/" +region+"/"+ file.getName());
                        logger.info(file.length()+":"+file.getAbsolutePath());
                        System.out.println(file.length()+":"+file.getAbsolutePath());
                        try {
                            File f=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM/" +region+"/"+ file.getName());
                            if(!f.exists()){
                                f.createNewFile();
                            }

                            FileUtils.copyFile(file, new FileOutputStream(f));
                            int i= MiddleStatus.getNowFiles();
                            MiddleStatus.setNowFiles(i+1);
                        } catch (IOException e) {
                            logger.error(e);
                            e.printStackTrace();
                        }

                    } else if (fileName.matches("ODM-.*_V2.7.0.*")) {
                        try {
                                  File f=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB/" +region+"/"+ file.getName());

                            if(!f.exists()){
                                f.createNewFile();
                            }
                            logger.info(file.length()+":"+file.getAbsolutePath());
                           //System.out.println(file.length()+":"+(finalPath + "/ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB_FDD_CORBA_PM/" +region+"/"+ file.getName()));
                            System.out.println(file.length()+":"+file.getAbsolutePath());

                            FileUtils.copyFile(file, new FileOutputStream(f));
                            int i= MiddleStatus.getNowFiles();
                            MiddleStatus.setNowFiles(i+1);
                        } catch (IOException e) {
                            logger.error(e);
                            e.printStackTrace();
                        }
                    } else if (fileName.matches("ODM-.*_V2.9.*")) {

                        try {
                           File f=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM/" +region+"/"+ file.getName());

                            if(!f.exists()){
                                f.createNewFile();
                            }
                            logger.info(file.length()+":"+file.getAbsolutePath());
                         // System.out.println(file.length()+":"+finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM/" +region+"/"+ file.getName());
                            System.out.println(file.length()+":"+file.getAbsolutePath());

                            FileUtils.copyFile(file, new FileOutputStream(f));
                            int i= MiddleStatus.getNowFiles();
                            MiddleStatus.setNowFiles(i+1);
                        } catch (IOException e) {
                            logger.error(e);
                            e.printStackTrace();
                        }
                    } else if (fileName.matches("ODM-.*_FDD_V3.0_.*")) {

                        try {
                            File f=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM/" +region+"/"+ file.getName());

                            if(!f.exists()){
                                f.createNewFile();
                            }
                            logger.info(file.length()+":"+file.getAbsolutePath());
                           //System.out.println(file.length()+":"+(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM/" +region+"/"+ file.getName()));
                            System.out.println(file.length()+":"+file.getAbsolutePath());

                            FileUtils.copyFile(file, new FileOutputStream(f));
                            int i= MiddleStatus.getNowFiles();
                            MiddleStatus.setNowFiles(i+1);
                        } catch (IOException e) {
                            logger.error(e);
                            e.printStackTrace();
                        }
                    }  else if (fileName.matches("ODM-.*_TDD_V3.0_.*")) {

                        try {
                             File f=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM/" +region+"/"+ file.getName());
                            if(!f.exists()){
                                f.createNewFile();
                            }
                            logger.info(file.length()+":"+file.getAbsolutePath());
                            //System.out.println(file.length()+":"+(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM/" +region+"/"+ file.getName()));
                            System.out.println(file.length()+":"+file.getAbsolutePath());

                            FileUtils.copyFile(file, new FileOutputStream(f));
                            int i= MiddleStatus.getNowFiles();
                            MiddleStatus.setNowFiles(i+1);
                        } catch (IOException e) {
                            logger.error(e);
                            e.printStackTrace();
                        }
                    }/*else if (fileName.contains("ODM-A.WL.PM.FILE_WL_LTE_ENB_TDD_V2.9")) {

                        try {
                            File f=new File(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_ENB_TDD_V2.9/" +region+"/"+ file.getName());
                              if(!f.exists()){
                                f.createNewFile();
                            }
                            logger.info(file.length()+":"+file.getAbsolutePath());
                           // System.out.println(file.length()+":"+(finalPath + "/ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM/" +region+"/"+ file.getName()));
                            System.out.println(file.length()+":"+file.getAbsolutePath());

                            FileUtils.copyFile(file,new FileOutputStream(f) );
                            int i= MiddleStatus.getNowFiles();
                            MiddleStatus.setNowFiles(i+1);
                        } catch (IOException e) {
                            logger.error(e);
                            e.printStackTrace();
                        }

                    }*/ else {
                        logger.info(file.length()+":"+file.getAbsolutePath());
                        //System.out.println(file.length()+":"+file.getName());
                        int i= MiddleStatus.getNowFiles();
                        MiddleStatus.setNowFiles(i+1);
                        System.out.println("else:"+file.length()+":"+file.getAbsolutePath());
                    }
                }
            });

        }
    }
}
