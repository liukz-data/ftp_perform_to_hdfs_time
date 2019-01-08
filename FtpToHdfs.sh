#!/bin/bash
#date:20181031
#Author:liukz
#------------------------------------------------

LANG=en_US.UTF-8
export LANG

#klist  -kt   /root/yyxt.keytab
#kinit -kt   /root/yyxt.keytab   yyxt@BCHKDC

source /etc/profile

date_m=`date -d "-50 minutes" +%Y%m%d%H%M`
date_H=${date_m:0:10}

date1=${date_m:0:8}
H1=${date_m:8:2}
m1=${date_m:10:2}

#if [[ $m1 -ge '00' && $m1 -lt '15' ]]
#then
#  date_m=$date_H'00'
#elif [[ $m1 -ge '15' && $m1 -lt '30' ]]
#then
#  date_m=$date_H'15'
#elif [[ $m1 -ge '30' && $m1 -lt '45' ]]
#then
#  date_m=$date_H'30'
#elif [[ $m1 -ge '45' ]]
#then
#  date_m=$date_H'45'
#fi
#
if [[ $# -gt 0 ]]
then
  date_m=${1}
fi

echo 'PARTITION:   '$date_m

startTime=`date +%Y-%m-%d\ %H:%M:%S`
echo  $date_m startTime -- $startTime >> /segment1/logs/perform_index/FtpToHdfs_s.log
#下载、解压、文件的入库准备
java -jar /usr/local/program/perform_index/FtpToHdfs.jar 10.216.3.192 21 ftpuser bjxh6Yz+ /opt/ftpuser/zhjk_15kpi /ftp/vsftpd/hbwy/zip $date_m /ftp/vsftpd/hbwy/extra  /ftp/vsftpd/hbwy/final /usr/local/program/perform_index/log_conf/log4j.properties /usr/local/program/perform_index/log_conf/ftpload.properties
#入宽表、中间表、min结果表
spark-submit --master local[12]  --class cn.hbwy.FtpToHdfs.sparkdeal.FileToHive.FiveDirToHive1031 --name FiveDirToHive1031  /usr/local/program/perform_index/FtpToHdfs.jar $date_m /usr/local/program/perform_index/log_conf/log4j.properties

finishTime=`date +%Y-%m-%d\ %H:%M:%S`
echo $date_m  finishTime -- $finishTime >> /segment1/logs/perform_index/FtpToHdfs_s.log


# 性能报表15min
startTime=`date +%Y-%m-%d\ %H:%M:%S`
echo  $date_m startTime_report -- $startTime >> /segment1/logs/perform_index/FtpToHdfs_s.log

hive -hiveconf date_m=${date_m} -hiveconf date_d=${date1} -f /usr/local/program/perform_index/sql_script/lte_capacity_index_monitoring_fiftheen_min.sql

finishTime=`date +%Y-%m-%d\ %H:%M:%S`
echo $date_m  finishTime_report -- $finishTime >> /segment1/logs/perform_index/FtpToHdfs_s.log

#15分钟的性能报表生成压缩文件并上传FTP
/usr/local/program/kpi_to_ftp/fifteen_min_kpi_to_ftp.sh ${date_m}