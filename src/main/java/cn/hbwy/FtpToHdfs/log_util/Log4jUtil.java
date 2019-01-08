package cn.hbwy.FtpToHdfs.log_util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtil {
    public static Logger getLogger(String confPath, Class clazz) {
        PropertyConfigurator.configure(confPath);
        return Logger.getLogger(clazz);
    }
}
