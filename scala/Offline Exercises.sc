//Task 1

def doubleChar(str: String, inB: Int):Unit = {

  var dCList = str*inB
  println(dCList)

  //  var a = 0
  //  for(a <- to dCList.size)
  //  var matchChar = go through the string and match the index's of same char's,
  //  done by matching index position of a char with the index position of the char plus string.size
  //  this process would be repeated as many times ad
  //  send these matched chars to a new string
  //  print new string
}
doubleChar("the",2)


//Task 2
def sandwich(fillings: String) Unit = {

  def findJam = fillings.indexOf('j', 'a', 'm')                //find out the index values of jam in the string
  def jamFound = (lowest index, middle index, highest index)   //put the index values into sequence

  def removeJam =sandwich.filter(x => !x.is[jamFound])          //filter all chars which don't correspond to the jamFound index sequence
  println(removeJam)
}

//Task 3

// before I carryout my match section I need to reorganise my parameters so that they are in ascending order
// I could possibly do this by sending my parameters to an arraybuffer and then using a command put them in ascending order
// returning the new sequence

def differenceInts(small:Int, medium: Int, large: Int): Boolean = {
  (small, medium, large) match {
    case (small, medium, large) if medium - small == large - medium => true
    case (small, medium, large) if medium - small != large - medium => false
  }
}
 differenceInts(2,4,6)
 differenceInts(4,6,2)
 differenceInts(4,6,3)

//Task 4

// 0,1,1,2,3,5,8
// a,b,c,
// a+b=c
//
//                 0 1   1    2
// print string of a,b,a+b=n,b+n=n2,
//

//Task 5

def numberOfEars(bunnyNumber:String, totalEars: Int )

//for each new bunny add 2 to total ears.

//task 6

def nTwice(word: String, length: Int) {

  var wordCut = trim(word)                 //here I need to define the size of the trim, not sure how
  def leaveEnds = word.filter(x => x.is[wordCut])          //filter all chars which don't correspond to the jamFound index sequence
  println(leaveEnds)
}

//Task 7

def endsInLy = .endsWith(Ly)

//Ran out of time due to misunderstanding course length