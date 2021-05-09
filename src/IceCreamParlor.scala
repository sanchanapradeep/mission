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

object IceCreamParlor {

  // Complete the whatFlavors function below.
  def whatFlavors(cost: Array[Int], money: Int) {
    val hashMap = new HashMap[Int, Set[Int]] with MultiMap[Int, Int]

    //var hashMap =  new util.HashMap[Int,Array]()
    for(i<- 0 until cost.length) {
      hashMap.addBinding( cost(i), i+1)
    }

    for(i<- 0 until cost.length-1) {
      var r = money - cost(i)
      if(hashMap.getOrElse(r,-1) != -1) {
        var re = hashMap.get(r).get
          if(re.size >= 2){
            var re = hashMap.get(r).get
            //println((i+1) + " " +(re(0)))
            println((i+1) + " " +(re.toList.sorted.apply(1)))
            return
          } else if (r != cost(i)){
            println((i+1) + " " +(re.toList.apply(0)))
            return

          }
        }
    }
  }



  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val money = stdin.readLine.trim.toInt

      val n = stdin.readLine.trim.toInt

      val cost = stdin.readLine.split(" ").map(_.trim.toInt)
      whatFlavors(cost, money)
    }
  }
}
