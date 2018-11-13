package cn.hbwy.FtpToHdfs.sparkdeal.FileToHive.sqlutil

import cn.hbwy.FtpToHdfs.sparkdeal.FileToHive.FiveDirToHive
import cn.hbwy.FtpToHdfs.sparkdeal.FileToHive.FiveDirToHive1031._
import cn.hbwy.FtpToHdfs.sparkdeal.FileToHive.log_util.Log4jUtil
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.hive.HiveContext

import scala.collection.mutable.ArrayBuffer

object SparkSql {
  def main(args: Array[String]): Unit = {
    val arrayBuffer  = args.toBuffer
    val logger = Log4jUtil.getLogger(args(0), SparkSql.getClass)
    arrayBuffer.remove(0)
    if(args.size==0){
      logger.info("ARGS IS EQUALS ZERO,SYSTEM EXIT")
      System.exit(-1)
    }
    logger.info("   Start Process  .....")
    val conf = new SparkConf().setAppName("Spark-Sql")
    val sc = new SparkContext(conf)
    val hiveContext=new HiveContext(sc)
    arrayBuffer.foreach(x=>{
      hiveContext.sql(x)
    })
    sc.stop()
    logger.info("   Stop Process  .....")
  }

}
