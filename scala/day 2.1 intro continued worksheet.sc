iterz1("working?", 3) //iteration 1

letrec("h "5) //iteration 2

fizzBuzz("Fizz", "Buzz", 15)

//Iteration 1
def iterz1(str: String, intz: Int) {
  var a = 0 //here a is the counter, <- separates pattern from generator
  for (a <- 1 to intz)
  {
    println(str)
  }
}

//Iteration 2

def letrec(str2: String, intz2: Int) =
{
  var newstr2 = ""//lets you know return will be astring
  var a = 0
  for (a <- 1 to intz2) // the point of a is to run b x number of times
  {
    newstr2 = ""
    var b = 0  // the point of b is too add to the string x times
      for (b <- 1 to intz2)
      {
        newstr2 += str2
      }
    println(newstr2)
  }
}

//iteration 3
def fizzBuzz(str1: String, str2: String, intA: Int) =
{
  var a = 0
  for (a<- 1 to intA) {
    println(a)
  }
  if(a %3 == 0)
    {
      println(str1)
    }
  if(a %5 == 0)
    {
      println(str2)
    }
  if(a %5 == 0 && a %10 == 0)
    {
      println(str1+str2)
    }
}