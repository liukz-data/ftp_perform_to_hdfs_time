package cn.hbwy.FtpToHdfs.ftpdeal;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;


/***
 * @param
 */
public class FtpToDisk {
    private String hostname = "192.168.43.5";
    private int port = 21;
    private String userName = "test1";
    private String passwd = "test1";
    private String ftpWorkDir = "/home/test1";
    private String outPath = "/root/temp/out";
    private String region = "201809261730";

    public FtpToDisk() {
    }

    public FtpToDisk(String hostname, int port, String userName, String passwd, String ftpWorkDir, String outPath, String region) {
        this.hostname = hostname;
        this.port = port;
        this.userName = userName;
        this.passwd = passwd;
        this.ftpWorkDir = ftpWorkDir;
        this.outPath = outPath;
        this.region = region;
    }

    public void getZipFile(String matchConfPath) throws Exception {
        Properties pro = new Properties();
        FileInputStream ftpMatchFile = new FileInputStream(matchConfPath);
        pro.load(ftpMatchFile);
        String nb_v2_9 = pro.getProperty("nb_v2_9");
        String v2_6 = pro.getProperty("v2_6");
        String v2_7 = pro.getProperty("v2_7");
        String v2_9 = pro.getProperty("v2_9");
        String fdd_v3_0 = pro.getProperty("fdd_v3_0");
        String tdd_v3_0 = pro.getProperty("tdd_v3_0");
        FTPClient fc = null;
        FileOutputStream out = null;
        try {
            fc = FtpConnect.getConnect(hostname, port, userName, passwd);
            if (!fc.isConnected()) {
                Logger log = Logger.getLogger("Because FtpConnect:" + fc + "System exit");
                log.info("Info:Because FtpConnect:" + fc + "System exit");
                System.exit(-1);
            }
            // fc.enterLocalActiveMode();
            fc.setBufferSize(1024 * 1024 * 100);
            fc.changeWorkingDirectory(ftpWorkDir);
            String[] fileNames = fc.listNames();
            fc.setFileType(FTPClient.BINARY_FILE_TYPE);
            for (String fileName : fileNames) {
                // if(){}
                //InputStream in = fc.retrieveFileStream("1.txt");
                //System.out.println(fileName);
                //  String regiog_c=regionMinus15(region)+"00-"+region+"00";
                String regiog_c = region + "00-";
                //if(!fileName.matches("^tpd_eutrancell_q-ODM-.*_NB_V2.9.*\\.zip$")){
                if (!fileName.matches("^" + nb_v2_9 + "\\.zip$")) {
                    //if(fileName.matches("^tpd_eutrancell_q-ODM-A\\.WL\\.PM\\.FILE_WL_4G_V2\\.6\\.0_ENODEB_PM.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_ENB_TDD_V2.9_CSV_PM.*"+regiog_c+".*\\.zip$")){
                    //if(fileName.matches("^tpd_eutrancell_q-ODM-A\\.WL\\.PM\\.FILE_WL_4G_V2\\.6\\.0_ENODEB_PM.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-.*_V2.9.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM.*"+regiog_c+".*\\.zip$")||fileName.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM.*"+regiog_c+".*\\.zip$")){
                    if (fileName.matches("^" + v2_6 + regiog_c + ".*\\.zip$") || fileName.matches("^" + v2_7 + regiog_c + ".*\\.zip$") || fileName.matches("^" + v2_9 + regiog_c + ".*\\.zip$") || fileName.matches("^" + fdd_v3_0 + regiog_c + ".*\\.zip$") || fileName.matches("^" + tdd_v3_0 + regiog_c + ".*\\.zip$")) {
                        File file = new File(outPath + "/" + fileName);
                        File file_d = new File(outPath);
                        if (!file_d.exists()) {
                            file_d.mkdirs();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        out = new FileOutputStream(file);
                        //System.out.println("ZIP File:  "+fileName);
                        fc.retrieveFile(fileName, out);
                    }
                }
            }
        } finally {
            if (out != null) {
                out.close();
            }
            if (fc != null) {
                fc.disconnect();
            }

        }

    }


    public String regionMinus15(String region) throws Exception {

        SimpleDateFormat sdate = new SimpleDateFormat("yyyyMMddHHmm");
        String regionMinus15 = "";
        //region:201810251015
        Date d = sdate.parse(region);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        //表述减去15m
        gc.add(12, 15);
        regionMinus15 = sdate.format(gc.getTime());
        return regionMinus15;
    }

}
