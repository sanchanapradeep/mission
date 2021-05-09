import SwapNodes.Node

import scala.collection.mutable

object SwapNodes {

  class Node(var index: Int, var depth: Int, var left: Node, var right: Node) {
    this.index  = index
    this.depth = depth
    this.left = left
    this.right = right
  }


  def swapInOrder(cur: Node, depth: Int, k: Int): Unit = {
    if (cur == null) return
    swapInOrder(cur.left, depth + 1, k)
    //System.out.print("cur.index: " + cur.index);
    swapInOrder(cur.right, depth + 1, k)
    if (depth >= k && depth % k == 0) {
      val tmp = cur.left
      cur.left = cur.right
      cur.right = tmp
    }
  }

/*
  def swapNodes(indexes: Array[Array[Int]], queries: Array[Int]): Array[Array[Int]] = {
    val numOfNodes = indexes.length
    val numOfQueries = queries.length
    val result =  Array.ofDim(numOfQueries, 2)
    val root = new Node(1, 1, null, null)
    var cur = root
    val nodes = new scala.collection.mutable.LinkedHashSet[Node]
    nodes.add(cur)
    var N = 0 // = numOfNodes;
    while (N < numOfNodes) {
      //cur = nodes.poll
      val leftData = indexes(N)(0)
      val rightData = indexes(N)(1)
      //System.out.println("left,right: " + leftData + " " + rightData + " cur: " + cur );
      cur.left = if (leftData == -(1)) null
      else new Node(leftData, cur.depth + 1, null, null)
      cur.right = if (rightData == -(1)) null
      else new Node(rightData, cur.depth + 1, null, null)
//      if (cur.left != null && (cur.left.index ne -1)) nodes.add(cur.left)
//      if (cur.right != null && (cur.right.index ne -1)) nodes.add(cur.right)
      N += 1
    }
    //TODO: till here we have formed the tree, [not checked yet]
    var i = 0
    while (i < numOfQueries) {
      swapInOrder(root, 1, queries(i))
//      val res = new util.ArrayList[_]
//      printInOrder(root, res)
//      result(i) = res.stream.mapToInt((r: Integer) => r).toArray

      {
        i += 1; i - 1
      }
    }
    result
  }
*/

  def inorder(root: Node): Unit = {
    if (root == null) return
    inorder(root.left)
//    System.out.print(root.data + " ")
    inorder(root.right)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val indexes = Array.ofDim[Int](n, 2)

    for (indexesRowItr <- 0 until n) {
      indexes(indexesRowItr) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val queriesCount = stdin.readLine.trim.toInt

    val queries = Array.ofDim[Int](queriesCount)

    for (queriesItr <- 0 until queriesCount) {
      val queriesItem = stdin.readLine.trim.toInt
      queries(queriesItr) = queriesItem}

 //   val result = swapNodes(indexes, queries)

    //println(result.map(_.mkString(" ")).mkString("\n"))

    //printWriter.close()
  }

}