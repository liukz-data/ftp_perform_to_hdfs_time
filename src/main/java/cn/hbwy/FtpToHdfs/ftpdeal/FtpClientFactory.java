package cn.hbwy.FtpToHdfs.ftpdeal;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool.PoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * FTPClient工厂类，通过FTPClient工厂提供FTPClient实例的创建和销毁
 *
 * @author heaven
 */
public class FtpClientFactory implements PoolableObjectFactory {
    private static Logger logger = LoggerFactory.getLogger("file");
    private FTPClientConfigure config;

    //给工厂传入一个参数对象，方便配置FTPClient的相关参数
    public FtpClientFactory(FTPClientConfigure config) {
        this.config = config;
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.PoolableObjectFactory#makeObject()
     */
    public FTPClient makeObject() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(config.getClientTimeout());
        ftpClient.connect(config.getHost(), config.getPort());
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            logger.warn("FTPServer refused connection");
            return null;
        }
        boolean result = ftpClient.login(config.getUsername(), config.getPassword());
        if (!result) {
            throw new Exception("ftpClient登陆失败! userName:" + config.getUsername() + " ; password:" + config.getPassword());
        }
        //ftpClient.setFileType(config.getTransferFileType());
        ftpClient.setBufferSize(1024 * 1024);
        ftpClient.changeWorkingDirectory(config.getWorkPath());
        //ftpClient.setControlEncoding(config.getEncoding());
        if (config.getPassiveMode().equals("true")) {
            ftpClient.enterLocalPassiveMode();
        }

        return ftpClient;
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.PoolableObjectFactory#destroyObject(java.lang.Object)
     */
    public void destroyObject(Object o) throws Exception {
        FTPClient ftpClient = (FTPClient) o;
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                ftpClient.logout();
            }
        } finally {
            // 注意,一定要在finally代码中断开连接，否则会导致占用ftp连接情况
            try {
                ftpClient.disconnect();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.PoolableObjectFactory#validateObject(java.lang.Object)
     */
    public boolean validateObject(Object o) {
        FTPClient ftpClient = (FTPClient) o;
        try {
            return ftpClient.sendNoOp();
        } catch (IOException e) {
            throw new RuntimeException("Failed to validate client: " + e, e);
        }
    }

    public void activateObject(Object o) throws Exception {
    }

    public void passivateObject(Object o) throws Exception {

    }
}
