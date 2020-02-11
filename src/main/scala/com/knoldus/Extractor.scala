package com.knoldus

object URL {
  def apply (protocol: String, domain: String, path: String, params: Map[String,String]): String ={
    protocol + "://" + domain + "/" + path + "?" + params
  }
  def unapply(url: String): Option[(String, String, String, Map[String, String])] = {
    if (url.contains("://")) {
      val splitRest = url.split("://")
      val protocol = splitRest(0)
      if (splitRest(1).contains("/")) {
        val domainAll = splitRest(1).split("/")
        val domain = domainAll(0)

        if (domainAll(1).contains('?')) {
          val paramsAndPath = domainAll(1).split("\\?")
          val path = "" + paramsAndPath(0) + "/"+ paramsAndPath(1).split("/")
          val params = for (i <- paramsAndPath(1).split("&"))
            yield {
              ((i.split("=")) (0), i.split("=")(1))
            }
          Some(protocol, domain, path, params.toMap)
        }
        else {
          val path = domainAll(1)
          Some(protocol, domain, path, Map())
        }
      }
      else {
        val domain = splitRest(1)
        Some(protocol, domain, "", Map())
      }
    }
    else {
      None
    }
  }
}
object extactor {
  def main(args: Array[String]): Unit = {
    val s = "https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112"
    s match {
      case URL(protocol, domain, path, params) => print("protocol  " + protocol + " domain  " + domain + " path  " + path + " params  " + params)
    }
  }
}
