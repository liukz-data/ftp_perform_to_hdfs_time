package cn.hbwy.FtpToHdfs.sparkdeal.FileToHive;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestLog4j {
    public static void main(String[] args) {
        //PropertyConfigurator.configure("G:\\Users\\lkz\\IdeaProjects\\FtpToHdfs1\\src\\main\\scala\\cn\\hbwy\\FtpToHdfs\\sparkdeal\\FileToHive\\log4j.properties");
       // PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j.properties");
       // PropertyConfigurator.configure("G:\\Users\\lkz\\IdeaProjects\\FtpToHdfs1\\src\\main\\scala\\cn\\hbwy\\FtpToHdfs\\sparkdeal\\FileToHive\\log4j.properties");
        PropertyConfigurator.configure("G:\\Users\\lkz\\IdeaProjects\\FtpToHdfs1\\src\\main\\scala\\cn\\hbwy\\FtpToHdfs\\sparkdeal\\FileToHive\\log4j.properties");

        Logger logger = Logger.getLogger(TestLog4j.class);
        System.out.println(11111);
       // throw new IndexOutOfBoundsException();
        try {
            new FileInputStream("aa");
        } catch (FileNotFoundException e) {
            logger.error(e);
            e.printStackTrace();
        }
        logger.debug("Test3-debug");
        //logger.info("Test3-info");
       // logger.warn("5555");
    }
}
