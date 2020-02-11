package com.knoldus

import scala.util.matching.Regex

class EmailExtractor {
  val EMAIL: Regex = """(^[A-Za-z0-9][A-Za-z0-9.]*)@((?:[A-Za-z0-9]+\.)+[A-Za-z]{2,63}$)""".r
}

object Extractor {
  def main(args: Array[String]): Unit = {
    val obj = new EmailExtractor()
    val email = "sparsh@gmail.com"
    email match {
      case obj.EMAIL(user, domain) =>
        println(s"user :: $user")
        println(s"domain :: $domain")
      case _ => println("invalid")
    }
  }
}
