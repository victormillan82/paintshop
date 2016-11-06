package com.gilt.interview.helpers

import org.scalatest.FunSuite

import scala.io.Source

/**
  * Created by victor.millan on 06/11/2016.
  */
class ResolverTest extends FunSuite {
  test("Testing different Inputs: 1"){
    val test1 = new Resolver(FileHandler.generateCasesFromFile(getClass.getResource(s"/valid_input01.txt").getPath))
    test1.solve()
    val outPut1 = Source.fromFile(getClass.getResource("/expected_output01.txt").getPath).getLines().toArray
    assert(test1.showMeTheResult == outPut1(0))
  }

  test("Testing different Inputs: 2"){
    val test1 = new Resolver(FileHandler.generateCasesFromFile(getClass.getResource(s"/valid_input02.txt").getPath))
    test1.solve()
    val outPut1 = Source.fromFile(getClass.getResource("/expected_output02.txt").getPath).getLines().toArray
    assert(test1.showMeTheResult == outPut1(0))
  }

  test("Testing different Inputs: 3"){
    val test1 = new Resolver(FileHandler.generateCasesFromFile(getClass.getResource(s"/valid_input03.txt").getPath))
    test1.solve()
    val outPut1 = Source.fromFile(getClass.getResource("/expected_output03.txt").getPath).getLines().toArray
    assert(test1.showMeTheResult == outPut1(0))
  }



  test("Testing different Inputs: 4"){
    val test1 = new Resolver(FileHandler.generateCasesFromFile(getClass.getResource(s"/valid_input05.txt").getPath))
    test1.solve()
    val outPut1 = Source.fromFile(getClass.getResource("/expected_output05.txt").getPath).getLines().toArray
    assert(test1.showMeTheResult == outPut1(0))
  }
}
