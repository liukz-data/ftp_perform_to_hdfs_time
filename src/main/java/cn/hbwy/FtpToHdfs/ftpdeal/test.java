package cn.hbwy.FtpToHdfs.ftpdeal;

import org.apache.commons.net.ftp.FTPClient;

public class test {
    public static void main(String[] args) throws Exception {
       /* FTPClientConfigure ftpClientConfigure = new FTPClientConfigure();
        ftpClientConfigure.setClientTimeout(300);
        ftpClientConfigure.setHost("192.168.43.5");
        ftpClientConfigure.setPort(21);
        ftpClientConfigure.setPassiveMode("true");
        ftpClientConfigure.setUsername("test1");
        ftpClientConfigure.setPassword("test1");
        ftpClientConfigure.setWorkPath("/home/test1/in_zip1");
        FtpClientFactory fct =  new FtpClientFactory(ftpClientConfigure);
        FTPClientPool fp = new FTPClientPool(fct);
        FTPClient ftpClient = fp.borrowObject();
        String[] ln = ftpClient.listNames();
        System.out.println(ln.length);*/
      String a = new FtpToDisk().regionMinus15("201811120800");
        System.out.println(a.substring(0,8));
    }
}
