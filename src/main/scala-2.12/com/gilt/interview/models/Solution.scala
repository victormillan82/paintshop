package com.gilt.interview.models

import scala.collection.mutable.ListBuffer

case class Solution(colors: List[String] = Nil, totalColors: Int = 0) {

  /***
    * Check if a possible solution is compatible with the preferences of all the customers
    * @param customers
    * @return
    */
  def incompatible(customers: List[Map[Int, String]]) : Boolean = {
    try{
      if (solutionWithoutPlaceHolders){
        customers.foreach { customer =>
          {
            var counter = 0
            customer.foreach(x => if (colors(x._1  - 1) == x._2) counter += 1)

            //enforce the application to return incompatibilities in at least one customer
            if (counter == 0) throw new Exception
          }
        }
        false
      }
      else {
        true
      }
    }
    catch {
      case e: Exception => true
    }
  }

  /***
    * Generate List of children for each possible solution. Each result will have the GLOSSY and MATTE output by default
    * in the generation time
    * @return
    */
  def children: List[Solution] = {
    val exit = new ListBuffer[List[String]]()

    for(i <- 0 until totalColors) {
      val tempExitGlossy = new Array[String](totalColors)
      val tempExitMatte = new Array[String](totalColors)
      if (colors(i) == ColorEnum.PLACEHOLDER)
        for (j <- 0 until totalColors){
          if (i == j) {
            tempExitGlossy(j) = ColorEnum.GLOSSY
            tempExitMatte(j) = ColorEnum.MATTE
          }
          else if (colors(j) != ColorEnum.PLACEHOLDER){
            tempExitGlossy(j) = colors(j)
            tempExitMatte(j) = colors(j)
          }
          else {
            tempExitGlossy(j) = ColorEnum.PLACEHOLDER
            tempExitMatte(j) = ColorEnum.PLACEHOLDER
          }
        }
      exit += tempExitGlossy.toList
      exit += tempExitMatte.toList
    }

    exit.map(new Solution(_, totalColors)).toList
  }

  /***
    * Check if the possible solution contains placeholders
    * @return
    */
  def solutionWithoutPlaceHolders : Boolean = !colors.contains("*")

  /***
    * override the definition of toString to show the possible solution as string sepated by blank spaces
    * @return
    */
  override def toString: String = colors.mkString(" ")
}
