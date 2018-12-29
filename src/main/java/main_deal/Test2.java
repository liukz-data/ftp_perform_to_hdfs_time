package main_deal;

public class Test2 {
    public static void main(String[] args) {

        String a="tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.6.0_ENODEB_PM_107406_Detail_20180926171500-20180926173000_X1537954920701037.zip";
        String b="tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB_FDD_CORBA_PM_101407_1_Detail_20180926171500-20180926173000_X1537955341333706.zip";
        String c="tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM_101406_1_Detail_20180926171500-20180926173000_X1537955460262211.zip";
        String d="tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM_810_2_Detail_20180926171500-20180926173000_X1537954980900044.zip";
        String e="tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM_810_Detail_20180926171500-20180926173000_X1537954981400083.zip";
        if(a.matches("^tpd_eutrancell_q-ODM-A\\.WL\\.PM\\.FILE_WL_4G_V2\\.6\\.0_ENODEB_PM.*"+"20180926171500-20180926173000"+".*\\.zip$")){
            System.out.println(a);
        }

        if(b.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_4G_V2.7.0_ENODEB_FDD.*"+"20180926173000"+".*\\.zip$")){
            System.out.println(b);
        }
        if(c.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_ENB_TDD_V2.9_XML_PM.*"+"20180926173000"+".*\\.zip$")){
            System.out.println(c);
        }
        if(d.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_FDD_V3.0_XML_PM.*"+"20180926173000"+".*\\.zip$")){
            System.out.println(d);
        }
        if(e.matches("^tpd_eutrancell_q-ODM-A.WL.PM.FILE_WL_LTE_COMMON_TDD_V3.0_XML_PM.*"+"20180926173000"+".*\\.zip$")){
            System.out.println(e);
        }
    }
}
