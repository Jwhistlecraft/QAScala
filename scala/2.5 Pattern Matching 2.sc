//integer swap

def numSwap (container: Any) : Unit = {
  container match {
    case numSwap: List [Int] => println(numSwap(1) + "," + numSwap(0))
    case numSwap: Array [Int] => println(numSwap(1) + "," + numSwap(0))
    case numSwap: Tuple2 [Int,Int] => println(numSwap ._2 + "," + numSwap ._1)
    case _ => println("error")
  }
}
numSwap(List(3,2))
numSwap(Array(3,2))
numSwap(Tuple2(3,2))
