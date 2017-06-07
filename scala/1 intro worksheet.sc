println("Hello World!") // output "Hello World!" via println method

var message: String = "Hello again, World!" //storing string as a "message" variable

println(message) //Assignment

PrintString(message) // outputs parameter string

println(returnMethod()) // return task

println(inference(true)) //inference outputs
println(inference(10.10))
println(inference("hello world, again"))
println(inference(10))

println(strings("IT WORKS!", 3)) //strings println

(strings2("ha", "llo", 'a', 'e')) //letter replacement

numz(1, 2) // operators

numz2(5, 4, true) // conditionals 1
numz2(5, 4, false)

numz3(2, 0, true) //conditionals 2
numz3(0, 2, true)
numz3(0, 0, true)
numz3(2, 2, true)

numz3(2, 0, false) //conditionals 2
numz3(0, 2, false)
numz3(0, 0, false)
numz3(2, 2, false)



//FizzBuzz


//Parameter task
def PrintString(inString: String): Unit = {

  println(inString)
}

//Return task
def returnMethod(): String = {
  "Hello world"
}

//Type inference
def inference(anInput: Any): Any = {
  anInput
}

// Strings
def strings(word: String, letter: Int): String = {
  word.substring((word.length - letter), word.length)
}

//strings 2
def strings2(word2: String, word3: String, let2: Char, let3: Char) = {
  var wordcombi = word2 + word3

  println(wordcombi.replace(let2, let3))
}

//operators
def numz(a: Int, b: Int) = {
  println(a + b)
}
// Conditionals 1
def numz2(a: Int, b: Int, bool: Boolean) = {
  if (bool == true) {
    println(a + b)
  }
  else if (bool == false) {
    println(a * b)
  }
}

//conditions 2
def numz3(a: Int, b: Int, bool2: Boolean) = {
  if (a == 0 && b == 0) {
    println(0)
  }
  if (a == 0 && b != 0) {
    println(b)
  }
  if (a != 0 && b == 0) {
    println(a)
  }

  if (bool2 == true) {
    println(a + b)
  }
  else if (bool2 == false) {
    println(a * b)
  }
}

numz3(3, 0, true) //conditionals 2
numz3(0, 2, true)
numz3(0, 0, true)
numz3(3, 2, true)

numz3(3, 0, false) //conditionals 2
numz3(0, 2, false)
numz3(0, 0, false)
numz3(3, 2, false)

