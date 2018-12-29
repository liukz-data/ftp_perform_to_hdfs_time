package cn.hbwy.FtpToHdfs.test;

import java.io.FileInputStream;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        Properties pro =   new Properties();
        FileInputStream fi= new FileInputStream("G:/Users/lkz/IdeaProjects/FtpToHdfs1/src/main/java/cn/hbwy/FtpToHdfs/test/test.properties");
        pro.load(fi);
        String aa=pro.getProperty("aa");
        String fileName="tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB_CORBA_PM_104401_Detail_20180926171500-20180926173000_X1537955581226744.zip";
        System.out.println(aa);
       // if(!fileName.matches("^tpd_eutrancell_q-ODM-.*_NB_V2.9.*\\.zip$")){
        if(fileName.matches(aa)){
            System.out.println("可以匹配");
        }
    }
}
