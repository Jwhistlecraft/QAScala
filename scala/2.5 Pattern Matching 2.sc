//integer swap

def numSwap (container: Any) : Any = {
  container match {
    case List(x,y,restOfValue @_*) => List(y,x) :+ restOfValue
    case Array(x,y,restOfValue @_*) => Array(y,x) :+ restOfValue
    case Tuple2(_1,_2) => Tuple2(_2,_1)
    //case Tuple => var unPackTup = println((._2, ._1,) :+ restofValue @_*)
    case _ => println("error")
  }
}

numSwap(List(3,2,4,4,4,5,6,7,7,8,89,9,0))
numSwap(List(3,2))
numSwap(Array(3,2))
numSwap(Tuple2(3,2))
numSwap(List(4,3,1,0))
numSwap(Array(4,3,2,1))
//numSwap(Tuple4((4,3,1,0))


