package cn.hbwy.FtpToHdfs.sparkdeal.FileToHive.sqlutil

import scala.collection.mutable.ArrayBuffer

object ScalaTest {
  def main(args: Array[String]): Unit = {
    val a=new ArrayBuffer[String]()
    a +="123"
    a +="234"
    a.foreach(x=>println(x))
    a.remove(0)
    a.foreach(x=>println(x))

  }

}
