package geeks_for_geeks

import scala.collection.mutable.HashMap
import java.util.LinkedList

class Node(val url: String) {
  var prev: Node = null
  var next: Node = null
}

object FindLastUniqueURL extends App {
  val entry = HashMap.empty[String, Node]
  val list = new LinkedList[String]()
  var head: Node = null
  var tail: Node = null

  for (url <- io.Source.stdin.getLines()) {
    if (entry.contains(url) && entry.get(url).get != null) {
      val node = entry.get(url).get
      val next = node.next
      if (node.prev == null) {
        head = next
        if (next != null) {
          next.prev = head
        } else {
          tail = null
        }
      } else {
        node.prev.next = next
        if (next != null) {
          next.prev = node.prev
        } else {
          tail = node.prev
        }
      }
      entry.update(url, null)
    } else if (!entry.contains(url)) {
      if (tail != null) {
        tail.next = new Node(url)
        tail.next.prev = tail
        tail = tail.next
      } else {
        head = new Node(url)
        tail = head
      }
      entry.update(url, tail)
    }

    var tmp = head
    while (tmp != null) {
      print(tmp.url + " ")
      tmp = tmp.next
    }
    println()
  }
  println(tail.url)
}