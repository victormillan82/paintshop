package com.gilt.interview


import com.gilt.interview.helpers.{FileHandler, Resolver}



/**
  * Created by victor.millan on 06/11/2016.
  */
object Interview {

  def main(args: Array[String]): Unit = {
    try {
      val resolver = new Resolver(FileHandler.generateCasesFromFile(args(0)))
      resolver.solve()
      println(resolver.showMeTheResult)
    }
    catch {
      case e: Exception => println(e.getMessage)
    }
  }

}

