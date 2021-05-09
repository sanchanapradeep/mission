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
import scala.collection.mutable.Map

object TripleSum {

  // Complete the triplets function below.
  def triplets(a: Array[Int], b: Array[Int], c: Array[Int]): Long = {
    var as = a.distinct.sorted
    var bs = b.distinct.sorted
    var cs = c.distinct.sorted
    var d=0L
    var k =0
    while(k < bs.length){
      val x = findBeforeCount(cs,bs(k)).toLong
      if(x !=0){
        d += x * findBeforeCount(as,bs(k)).toLong
      }
      k +=1
    }
    d
  }
  def findBeforeCount(a: Array[Int],number:Int):Int ={

    var index = java.util.Arrays.binarySearch(a,number)
    if (index < 0) index =  -2-index
    index +1
  }
/*
  def triplets(a: Array[Int], b: Array[Int], c: Array[Int]): Long = {
    var as = a.sorted.toSet
    var bs = b.sorted.toSet
    var cs = c.sorted.toSet
    var d=0L
    var bcc =0
    var bac =0
    for (k <- bs ) {
      bac = 0
      for ( j<-as ) {
        if( k >= j) {
          bac += 1
        }
      }
      if(bac!=0){
        bcc = 0
        for ( j<-cs ) {
          if( k >= j) {
            bcc += 1
          }
        }
        d += bcc * bac
      }
    }
    d
  }
*/

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

//    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val lenaLenbLenc = stdin.readLine.split(" ")

    val lena = lenaLenbLenc(0).trim.toInt

    val lenb = lenaLenbLenc(1).trim.toInt

    val lenc = lenaLenbLenc(2).trim.toInt

    val arra = stdin.readLine.split(" ").map(_.trim.toInt)

    val arrb = stdin.readLine.split(" ").map(_.trim.toInt)

    val arrc = stdin.readLine.split(" ").map(_.trim.toInt)
    val ans = triplets(arra, arrb, arrc)

    println(ans)

    //printWriter.close()
  }
}
