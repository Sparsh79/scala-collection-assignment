package com.knoldus

object LastElement{
  def main(args: Array[String]): Unit = {
    val numbers = List(1,2,3,4,5)
    val last_element = numbers(numbers.length-1)
    println("last element is " +last_element)
  }
}
