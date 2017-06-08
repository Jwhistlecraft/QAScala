//iterations 4

//hi hi hi
def hihihi(str: String, count:Int):Unit = {
  if (count!= 0)
  {
    hihihi(str, count-1)
    println(str)
  }
}
hihihi("hi",3)

//hhhh square
def hsquare(str: String, inB: Int, count:Int):Unit = {
  var hList = str*inB
  println(hList)
  if (count!= 0) {
  hsquare(str, inB, count-1)
  }
}
hsquare("h",4,4)


//fizzbuzz in recursive
def fizzbuzz(inB:Int,upperBound:Int): Unit ={
  if (inB<=upperBound){
    (inB%3, inB%5) match {
      case (0, 0) => println("fizzbuzz")
      case (0, _) => println("fizz")
      case (_, 0) => println("buzz")
      case _      => println(inB)
    }
      fizzbuzz(inB+1,upperBound)
    }
}
fizzbuzz(1,15)