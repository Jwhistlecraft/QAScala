def checkhandL21(handtot: Int) : Boolean = handtot match {
  case x if handtot > 21 => false //hand is over 21, bust
  case x if handtot <= 21 => true // hand is fine
  case _ => printf("Error, "+handtot+" is invalid, appologies\n")// $d brings in the handtot, only works with printf
    false

}

def comparehands(hand1:Int, hand2:Int) : Int = {

  val difference: Int = hand1 - hand2 //caluculate difference based on subtraction,  +number 1 won, -number 2 won

  difference match{
    case x if difference < 0 => hand2 //hand two was larger
    case x if difference > 0 => hand1 //hand one was larger
    case x if difference == 0 => 0 // both hands have same value
    case _ => printf("something went wrong, appologies\n");0
  }

}
//check for winning hand
def checkforwinner(hand1: Int, hand2: Int) : Int = {

  val check21hand1 : Boolean = checkhandL21(hand1)//(hand1) because function has parameter
  val check21hand2 : Boolean = checkhandL21(hand2)


  val x : Int = 0 //here to get the match to work, enquire
  x match
  {
    case x if check21hand1 && check21hand2 => comparehands(hand1, hand2)
    case x if !check21hand1 && check21hand2 => hand2 //in an if statment, exclamaition points signifiy false Boolean values
    case x if check21hand1 && !check21hand2 => hand1
    case x if !check21hand1 && !check21hand2 => 0
    case _ => println("something went wrong");0
  }
}


println("hand 1: 18, hand 2 :21, winning hand: " +checkforwinner(18,21))// test for hand 2 winning
println("hand 1: 21, hand 2 :18, winning hand: " +checkforwinner(21,18))// test for hand 1 winning
println("hand 1: 18, hand 2 :18, winning hand: " +checkforwinner(18,18))// test for hand 1 winning