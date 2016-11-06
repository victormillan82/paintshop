package com.gilt.interview.algorithms

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * Created by victor.millan on 06/11/2016.
  */
trait BackTracking {

  // Because we are going to consider the results as a tree of solutions, we will imagine each branch as each solution
  // containing at least one placeholder and leaves the solutions without placeholders. We will do the analysis only in
  // the leaves
  type Node

  // definition of helper trait Result to evaluate possible solutions
  trait Exit

  // Possible solutions
  case object NotValid extends Exit
  case object Valid extends Exit

  // This scenario will evalutate recursively its children. This is the scenario when we have a placeholder
  case class PossibleValid(children: List[Node]) extends Exit

  def root: Node

  def check(node: Node) : Exit

  val possibleSolutionsExit = new ListBuffer[Node]
  /***
    * Recursive method for backtracking implementation. Inspired by
    * https://www.cis.upenn.edu/~matuszek/cit594-2012/Pages/backtracking.html
    *
    * Pseudo code:
    *
    * boolean solve(Node n) {
    * if n is a leaf node {
    *    if the leaf is a goal node, return true
    *    else return false
    *  } else {
    *    for each child c of n {
    *        if solve(c) succeeds, return true
    *    }
    *    return false
    *  }
    * }
    *
    * In this scenario we will get and Scala Option value
    *
    * @param possibleSolutions
    * @return
    */
  @tailrec
  final def solve(possibleSolutions: List[Node] = List(root)) : Option[Node] = possibleSolutions match {
    case possibleSolution :: tail => {
      check(possibleSolution) match {
        case Valid => {
          possibleSolutionsExit += possibleSolution
          solve(tail)
        }
        case NotValid => {
          solve(tail)
        }
        case PossibleValid(children) => {
          solve(children ::: tail)
        }
      }
    }
    case Nil => None
  }

}

