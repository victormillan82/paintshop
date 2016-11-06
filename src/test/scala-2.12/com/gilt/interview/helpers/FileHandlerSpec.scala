package com.gilt.interview.helpers

import org.scalatest.FunSuite

/**
  * Created by victor.millan on 06/11/2016.
  */
class FileHandlerSpec extends FunSuite {
  test("Read different sources: VALID") {
    for(i<-1 to 5 if i != 4){
      assert(FileHandler.generateCasesFromFile(getClass.getResource(s"/valid_input0$i.txt").getPath).cases.nonEmpty)
    }
  }

  test("Read different sources: INVALID") {
    for(i<-1 to 4 if i != 4){
      try {
        FileHandler.generateCasesFromFile(getClass.getResource(s"/invalid_input0$i.txt").getPath)
        assert(false)
      } catch {
        case e: Exception => assert(true)
      }
    }
  }
}
