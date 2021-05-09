import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object MaxToys {

  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {
    var a = prices.sorted
    var b =0
    var c =0
    for (i<-0 until a.length-1){
      b += a(i)
      c +=1
      if(b>=k){
        return c-1
      }
    }
    return c
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    println(result)

  }
}
