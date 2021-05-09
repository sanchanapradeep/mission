import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import math._
import scala.math.BigDecimal
import scala.util.control.Breaks._

object minTimeReq {

  // Complete the minTime function below.
  def minTime(machines: Array[Long], goal: Long): Long = {
    var ms = machines.sorted
    var st = 1L
    var et:Long = ms(0) * goal
    var mid =0L
    var count:Long = 0
    while(st != et){
      count =0
      mid = (st+et)/2
      for (m <- ms)
        count += (mid / m).toInt
      if(count >= goal){
        et = mid
      } else {
        st = mid+1
      }
    }
    st
  }


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

//    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nGoal = stdin.readLine.split(" ")

    val n = nGoal(0).trim.toInt

    val goal = nGoal(1).trim.toLong

    val machines = stdin.readLine.split(" ").map(_.trim.toLong)
    val ans = minTime(machines, goal)

    println(ans)

    //printWriter.close()
  }
}

