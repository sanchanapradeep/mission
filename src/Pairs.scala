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
import scala.collection.mutable.{ HashMap, MultiMap, Set }

object Pairs {


  def pairs(k: Int, arr: Array[Int]): Int = {
    val hashSet = new util.HashSet[Int]

    //var hashSet =  new util.HashMap[Int,Array]()
    for(i<- 0 until arr.length) {
      hashSet.add( arr(i))
    }
    var c = 0
    for(i<- 0 until arr.length) {
      var r = k+ arr(i)
      if(hashSet.contains(r)) {
        c +=1
      }
    }
    c


  }




  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = pairs(k, arr)

    println(result)

    //printWriter.close()
  }
}
