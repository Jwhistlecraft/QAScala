import scala.collection.mutable.ListBuffer

/**
  * Created by Administrator on 08/06/2017.
  */
object Main {

  def calc(x : String): Unit ={
    val temp : Array[String] = x.split(", ")
    var numList : ListBuffer[Int] = ListBuffer()

    for(z <- 0 to temp.size -1){
      numList+=temp(z).toInt
      println(numList(z))
    }

    for(i<-0 to numList.size -1){
      var num1 = numList(i%numList.size)
      var num2 = numList((i+1)%numList.size)
      var num3 = numList((i+2)%numList.size)

      if(num1 + num2 == num3) {
        println(num1 + " + " + num2 + " = " + num3)
      }
      if(num1 * num2 == num3) {
        println(num1 + " x " + num2 + " = " + num3)
      }
      if(num2!=0)
        if(num1 / num2 == num3) {
          println(num1 + " / " + num2 + " = " + num3)
        }
      if(num1 - num2 == num3) {
        println(num1 + " + " + num2 + " = " + num3)
      }

      *if*/ println(num1 + " " + num2 +" "+num3)
    }
    println()
  }

  def main(args : Array[String]): Unit ={
    calc("5, 3, 15")
    calc("4, 2, 8")
    calc("6, 2, 12")
    calc("6, 2, 3")
    calc("9, 12, 108")
    calc("5, 3, 15")

    calc("3, 5, 5, 3")
    calc("2, 4, 6, 3")
    calc("1, 1, 2, 3")
    calc("4, 4, 3, 4")
    calc("8, 4, 3, 6")
    calc("9, 3, 1, 7")
    calc("2, 4, 0, 2")

    println(0%numList.size + " " + (0+1)%numList.size + " " + (0+2)%numList.size)
  }
}