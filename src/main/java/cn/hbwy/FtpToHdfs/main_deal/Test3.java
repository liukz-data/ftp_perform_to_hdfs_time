package cn.hbwy.FtpToHdfs.main_deal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test3 {
    public static void main(String[] args) {
        SimpleDateFormat sdate= new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date d=sdate.parse("201810251000");
            GregorianCalendar gc=new GregorianCalendar();
            gc.setTime(d);
            gc.add(12,-15);
            System.out.println(sdate.format(gc.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
