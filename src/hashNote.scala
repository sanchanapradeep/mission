import scala.collection.mutable
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

object hashNote {
  def checkMagazine(magazine: Array[String], note: Array[String]) {
    var a:HashMap[String,Int]= new mutable.HashMap[String,Int]()

    for(e <- magazine) {
      if(a.contains(e)){
        var c = a(e)
        a(e) = c+1
      } else {
        a(e) = 1
      }

    }
    for(v <- note){
      if(!a.contains(v)){
        print("No")
        return
      } else {
        var c = a(v)
        if(c == 1)
          a.remove(v)
        else
          a(v) = c-1
      }
    }
    print("Yes")



  }
  def twoStrings(s1: String, s2: String): String = {
    var a:HashSet[Char]= new HashSet[Char]()

    a.addAll(s1.toCharArray)
    for(v <- s2){
      if(a.contains(v)){
       // print("Yes")
        return "Yes"
      }
    }
    //print("No")
    "No"



  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val mn = stdin.readLine.split(" ")

    val m = mn(0).trim.toInt

    val n = mn(1).trim.toInt

    val magazine = stdin.readLine.split(" ")

    val note = stdin.readLine.split(" ")
    checkMagazine(magazine, note)
  }



}
