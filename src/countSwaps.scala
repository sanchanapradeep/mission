import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object countSwaps {

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]) {

    var res = 0
    var  count =0
    var r = q.clone()
    var tmp =0
    var index=0
    for(i<-q.length until 0 by -1 ) {
      count = 0
      //index = r.indexOf(i)
      index = position(r,i)

      while(index+1 != i && count <=2){
        //r = swap(r,index,index+1)
        tmp = r(index)
        r(index) = r(index+1)
        r(index+1) = tmp

        count += 1

        index = position(r,i)
        if(index ==0)
          count = 3
      }
      res +=count

      if(count > 2 ){
        println("Too chaotic")
        return
      }
    }
    println(res)
  }
  def swap(a:Array[Int], x: Int,y:Int): Array[Int] ={
    var tmp =0
    tmp = a(x)
    a(x) = a(y)
    a(y) = tmp
    a
  }
  def position(a:Array[Int], i:Int):Int ={
    if(a(i-1) == i)
      return i-1
    if(a(i-2) == i)
      return i-2
    if(a(i-3) == i)
      return i-3
    return 0
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val q = stdin.readLine.split(" ").map(_.trim.toInt)
      minimumBribes(q)
    }
  }
}
