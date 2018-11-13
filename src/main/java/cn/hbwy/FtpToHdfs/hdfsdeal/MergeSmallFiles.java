package cn.hbwy.FtpToHdfs.hdfsdeal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

//2018 10 24 :warn no complete
public class MergeSmallFiles {

    private String zip_outPath="/root/temp/extra_out/out";
    public void mergeSmallFiles() throws Exception{

        ArrayList<String> filePaths = new FindCsv().getFiles(zip_outPath);
        //10m 24 d ;I should merge file
        FileOutputStream fo=new FileOutputStream("/root/temp/out/test_z/out/1.txt");
        int i=1;
        for(String filePath:filePaths){
            File f = new File("/root/temp/out/test_z/test1.txt");
            System.out.println("length:"+f.length()/1024);
            BufferedInputStream bfin_1=new BufferedInputStream(new FileInputStream(f));
            if(i==8){
                fo=new FileOutputStream(filePath);
                i=0;
            }
            byte[] by=new byte[1024];
            int recount=0;
            while((recount=bfin_1.read(by))>0){
                fo.write(by,0,recount);
            }
        }

    }
}
