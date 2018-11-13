package cn.hbwy.FtpToHdfs.hdfsdeal;

public class CopyFile_v0 {
    private String zip_outPath="/root/temp/extra_out/out";
    private String finalPath="/root/temp/final/out1";

    public CopyFile_v0() {}

    public void copyCsvFile(String zip_outPath,final String finalPath) throws Exception{
     /*  ArrayList<File> files=new FindCsv().getFiles(zip_outPath);
        ExecutorService executorService= ThreadPool.getThreadPool();
        for(final File file:files){
           String fileName = file.getName();
            if(fileName.contains("ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM")){
                executorService.execute(new Runnable() {
                    @Override
                    public void run(){
                        try {
                            FileUtils.copyFile(file,new File(finalPath+"/tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM/"+file.getName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }else if(fileName.contains("ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB_FDD_CORBA_PM")){
                executorService.execute(new Runnable() {
                    @Override
                    public void run(){
                        try {
                            FileUtils.copyFile(file,new File(finalPath+"/tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB_FDD_CORBA_PM/"+file.getName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }else if(fileName.contains("ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM")){
                executorService.execute(new Runnable() {
                    @Override
                    public void run(){
                        try {
                            FileUtils.copyFile(file,new File(finalPath+"/tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM/"+file.getName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }else if(fileName.contains("ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM")){
                executorService.execute(new Runnable() {
                    @Override
                    public void run(){
                        try {
                            FileUtils.copyFile(file,new File(finalPath+"/tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM/"+file.getName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }else if(fileName.contains("ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM")){
                executorService.execute(new Runnable() {
                    @Override
                    public void run(){
                        try {
                            FileUtils.copyFile(file,new File(finalPath+"/tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM/"+file.getName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }else{
                System.out.println(file.getName());
            }
        }*/
    }
}
