package com.gilt.interview.helpers

import com.gilt.interview.algorithms.BackTracking
import com.gilt.interview.models.{ColorEnum, Problem, Solution}

/**
  * Created by victor.millan on 06/11/2016.
  */
class Resolver(problem: Problem) extends BackTracking {
  type Node = Solution

  def root = Solution(Array.fill(problem.numberOfColors)(ColorEnum.PLACEHOLDER).toList, problem.numberOfColors)

  def check(node: Solution) = {
    if (node.solutionWithoutPlaceHolders && node.incompatible(problem.cases)) NotValid
    else if(!node.incompatible(problem.cases)) Valid
    else PossibleValid(node.children)
  }

  def showMeTheResult: String = {
    def max(s1: Solution, s2: Solution): Solution = {
      if (s1.toString.count(_ == 'G') > s2.toString.count(_ == 'G')) s1 else s2
    }

    if(possibleSolutionsExit.isEmpty) "No solution exists"
    else possibleSolutionsExit.toList.reduceLeft(max).toString
  }
}
