/**
  * Created by Administrator on 05/06/2017.
  */

object Main {
  //main method
  def main(args: Array[String]) = {

    println("Hello World!") // output "Hello World!" via println method

    var message: String = "Hello again, World!" //storing string as a "message" variable

    println(message) //Assignment

    PrintString(message) // outputs parameter string

    println(returnMethod())// return task

    println(inference())
  }

  //function outside of my main method (Parameter task)
  def PrintString(inString: String) = {

    println(inString)
  }

  //function outside of my main method (Return task)
  def returnMethod(): String ={
    "Hello world"
  }
  //Type inference
  def inference (AnInput: Any): Any =
  {
    return(AnInput)
  }
  
}

