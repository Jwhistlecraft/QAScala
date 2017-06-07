//integer swap

def numSwap (container: Any) : Any = {
  container match {
    case numSwap: List [Int] => List(numSwap(1) , numSwap(0))
    case numSwap: Array [Int] => Array(numSwap(1) , numSwap(0))
    case numSwap: Tuple2 [Int,Int] => Tuple2(numSwap ._2 , numSwap ._1)
    case _ => println("error")
  }
}
numSwap(List(3,2))
numSwap(Array(3,2))
numSwap(Tuple2(3,2))
numSwap(List(4,3,1,0))
numSwap(Tuple4(4,3,1,0))

