package com.knoldus

class Queue {
  def enqueue(list: List[Int],enter:Int):List[Int]={
    list:+enter
  }
def dequeue(list:List[Int]):List[Int]=
{
list.tail
}
}
object Queue {
  def main(args: Array[String]): Unit = {


    val queueObject = new Queue
    println(queueObject.enqueue(List(1, 2), 8))

    println(queueObject.dequeue(List(1, 3, 5, 9)))
  }
}

