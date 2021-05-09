import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object basketball {

  // Complete the breakingRecords function below.
  def breakingRecords(scores: Array[Int]): Array[Int] = {
    var res = new Array[Int](2)
    var mx = scores(0)
    var mi = scores(0)
    for (e <- scores){
      if(mx < e){
        mx = e
        res(0) +=1
      }
      if(mi > e){
        mi = e
        res(1) +=1
      }
    }
    res
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val scores = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = breakingRecords(scores)

    println(result.mkString(" "))

  }
}
