package com.gilt.interview.helpers

import com.gilt.interview.models.Problem

import scala.io.Source

/**
  * Created by victor.millan on 06/11/2016.
  */
object FileHandler {

  /***
    * Process a line to convert it in a Map[Int, String] which is the expected output.
    * In case of bad composition in the file, it will trigger an exception
    * @param customerChoiceLine
    * @param numberOfColors
    * @return
    */
  private def convertCustomerChoice(customerChoiceLine: String, numberOfColors: Int): Map[Int, String] = {
    val lineToArray = customerChoiceLine.split(" ")

    var exitMap = Map.empty[Int, String]
    var matteCounter = 0
    for(i <- 0 until lineToArray.length if i % 2 != 0){

      if(lineToArray(i) != "M" && lineToArray(i) != "G")
        throw new Exception("Invalid customer selection: It must be Glossy Matte")
      if(lineToArray(i - 1).toInt > numberOfColors)
        throw new Exception("Invalid color number")

      if(lineToArray(i) == "M") matteCounter += 1

      if(matteCounter > 1) throw new Exception ("more than one matte")

      exitMap += (lineToArray(i - 1).toInt -> lineToArray(i))
    }

    exitMap
  }

  /**
    * Read the file and generates the cases to analyse
    * @param fileLocation
    * @return
    */
  def generateCasesFromFile(fileLocation: String): Problem = {
    val linesInFile = Source.fromFile(fileLocation).getLines().toArray[String]
    Problem(linesInFile(0).toInt, linesInFile.drop(1).map(convertCustomerChoice(_, linesInFile(0).toInt)).toList)
  }

}
