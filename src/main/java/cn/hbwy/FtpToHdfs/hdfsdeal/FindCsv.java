package cn.hbwy.FtpToHdfs.hdfsdeal;

import java.io.File;
import java.util.ArrayList;

public class FindCsv {
    private String zip_outPath="/root/temp/extra_out/out";
    private ArrayList<File> files_l=new ArrayList<File>();

    public FindCsv() {
    }
    public ArrayList getFiles(String zip_outPath){
        findCsv(zip_outPath);
        return files_l;
    }
    public void findCsv(String dir){
        File file=new File(dir);
        File[] files=file.listFiles();
        for(File file_r:files){
            if(file_r.isDirectory()) {
                findCsv(file_r.getAbsolutePath());
            }else{
                String fileName=file_r.getName();
                //System.out.println(fileName);
                //will add regular
                if(fileName.endsWith(".csv")){
                    files_l.add(file_r);;
                }
            }
        }
    }
}
