
fizzBuzz("Fizz", "Buzz", 15)

//iteration 3
def fizzBuzz(str1: String, str2: String, intA: Int) = {
  var a = 0
  for (a <- 1 to intA) {

    if (a % 5 == 0 && a % 3 == 0)
    {
      println(str1 + str2)
    }
    else if (a % 3 == 0)
    {
      println(str1)
    }
    else if (a % 5 == 0)
    {
      println(str2)
    }
    else (println(a))
  }
}

