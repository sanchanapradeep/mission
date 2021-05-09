import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._


object Notif_count {

  // Complete the activityNotifications function below.
    def activityNotifications(expenditure: Array[Int], d: Int): Int = {
      var notif =0
      var current = 0
      var counting_sort_l:Array[Int] = new Array[Int](201)
      var end = d
      for(i<-0 until end)
        counting_sort_l(expenditure(i)) += 1
      var med_pos =0
      if(d % 2 == 0){
        med_pos = d/2
      } else {
        med_pos = d/2+1
      }
      var med =0f
      while(end< expenditure.length){
        //Cal med
        med = medi(counting_sort_l, d, med_pos)
        if(expenditure(end) >= 2*med){
          notif +=1
        }
        counting_sort_l(expenditure(end-d)) -= 1
        counting_sort_l(expenditure(end)) += 1
        end +=1
      }
      notif
    }

  def medi(sm:Array[Int],d:Int, med_pos:Int):Float = {
    var c =0
    var l=0
    while(c<med_pos){
      c += sm(l)
      l +=1
    }
    var r=l
    l -=1
    if(c > med_pos || d % 2 != 0) return l
    else {
      while(sm(r) ==0){
        r +=1
      }
      return (l+r)/2.0f
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nd = stdin.readLine.split(" ")

    val n = nd(0).trim.toInt

    val d = nd(1).trim.toInt

    val expenditure = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = activityNotifications(expenditure, d)

    println(result)

  }
}
