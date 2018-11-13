package cn.hbwy.FtpToHdfs.sparkdeal.FileToHive

import java.text.SimpleDateFormat
import java.util.Date

object TestScala {

  def main(args: Array[String]): Unit = {
    var d=new Date()
    val a=d.getTime
    var sim =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    Thread.sleep(1000)
    var d1=new Date()
    val b=d1.getTime;
    println(sim.format(a)+":"+sim.format(b))

  }
}
