import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object countingSwaps {

  // Complete the countInversions function below.
  def countInversions(a: Array[Int]): Long = {
    var b = new Array[Int](a.length)
    return mergeSort(a, b, 0, a.length-1)
  }
  def mergeSort(a:Array[Int],b:Array[Int], l:Int, r:Int):Long = {
    var c=0L
    if(l < r) {
      var mid = (l+r)/2
      c += mergeSort(a,b,l,mid)
      c+= mergeSort(a,b,mid+1,r)
      c+= merge(a,b,l,mid,r)
    }
    c
  }
  def merge(a:Array[Int],b: Array[Int],l:Int,mid:Int,r:Int):Long ={
    var i =l
    var j = mid +1
    var k = l
    var c =0L
    while(i<=mid && j<=r){
      if(a(i) <= a(j)){
        b(k) = a(i)
        i+=1
      } else {
        b(k) = a(j)
        j+=1
        c += (mid-i+1)
      }
      k+=1
    }
    while(i<=mid){
      b(k)=a(i)
      i +=1
      k +=1
    }
    while(j<=r){
      b(k)=a(j)
      j +=1
      k +=1
    }
    for(cp <-l until r+1){
      a(cp) = b(cp)
    }
    c

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val arr = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = countInversions(arr)

      println(result)
    }

   // printWriter.close()
  }
}
