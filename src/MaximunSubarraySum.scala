import java.io._
import java.math._
import java.security._
import java.text._
import java.util
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._


object MaximunSubarraySum {

  // Complete the maximumSum function below.
  def maximumSum(a: Array[Long], m: Long): Long = {
    var prefix =  Array.ofDim[Long](a.length,2)

    //var S:scala.collection.mutable.HashSet[Long] =  new scala.collection.mutable.HashSet[Long](a.length)
    //S.add(a(0) % m)
    prefix(0)(0) = a(0)
    for ( i<-1 to a.length-1  ) {
      prefix(i)(1) = i
      prefix(i)(0) = (prefix(i-1)(0) + a(i) %m) %m
    }
    var prefix1 = Array.ofDim[Long](a.length,2)
    prefix1 = prefix.sortBy(x=>(x(0),x(1)))
    var maxmodsum:Long = prefix1(a.length-1)(0)
    for ( i<-1 to a.length-1  ) {
      var di = (m - prefix1(i)(0) + prefix1(i-1)(0)) % m
      if(di > maxmodsum && prefix1(i)(1) < prefix1(i-1)(1)){
        maxmodsum = di
      }


    }
    maxmodsum
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val nm = stdin.readLine.split(" ")

      val n = nm(0).trim.toInt

      val m = nm(1).trim.toLong

      val a = stdin.readLine.split(" ").map(_.trim.toLong)
      val result = maximumSum(a, m)

      println(result)
    }

  }
}

