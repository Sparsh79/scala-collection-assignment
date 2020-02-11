package com.knoldus

class TimeExtractor {

  def apply(dd: Int, mm: Int, yyyy: Int, HH: Int, MM: Int, SS: Int): String = {
    dd + "-" + mm + "-" + yyyy +  " " + HH + ":" + MM + ":" + SS
  }


  def unapply(timeWithDate: String): Option[String] = {
    val parts = timeWithDate split ":"
    if (parts.length == 3) Some(parts(0)) else None
  }
}
object Time{
  def main(args: Array[String]): Unit = {
    val obj = new TimeExtractor
    //println(obj.apply(12,12,2020,12,55,30))
    println(obj.unapply("12-12-2020 12:55:30"))
  }
}