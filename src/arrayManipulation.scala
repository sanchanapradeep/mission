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
import scala.collection.mutable.HashMap
import scala.collection.mutable.MultiMap
import scala.collection.mutable.Set


object arrayManipulation {

  // Complete the arrayManipulation function below.
  def arrayManipulation1(n: Int, queries: Array[Array[Int]]): Long = {
    var a = new Array[Long](n)
    for (e <- queries ) {
      for ( i<-e(0)-1 until e(1) ) {
        a(i) += e(2)
      }
      for ( j<-a  ) {
        print(j)

      }
      println()

    }
    a.max


  }
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {

    var sorted = queries.sortBy(_(1))
    var a = Array.ofDim[Long](sorted.length,sorted.length)
    for ( i<-0 until sorted.length ) {
      a(i)(i) = sorted(i)(2)
    }
    for (i<-0 until sorted.length ) {
      for(j<-0 until i) {
        if(sorted(i)(0) <= sorted(j)(1) && sorted(i)(1) >= sorted(j)(0)){
          a(i)(j) = a(i-1)(j) + sorted(i)(2)
        } else {
          a(i)(j) = a(i-1)(j)
        }

      }
    }
    var i =0
    print( "         ")

    for ( i<-0 until sorted.length ) {
      print("("+ sorted(i)(0)+","+sorted(i)(1)+")" + "    ")
      //print( "    ")

    }
    for ( e <- a ) {
      print("("+ sorted(i)(0)+","+sorted(i)(1)+")"+ "+" + sorted(i)(2) )
      print( "    ")
      for ( e1 <- e ) {
        print(e1 +"    ")

      }
      println()
      i+=1
    }
    a(sorted.length-1).max


  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val queries = Array.ofDim[Int](m, 3)

    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = arrayManipulation(n, queries)

    println(result)

    //printWriter.close()
  }
}

