// Intermediate Unique Sum
def numInput(x: Int, y: Int, z: Int): Int = {
  (x,y,z) match {
    case (x,y,z) if (x == y && y == z) => (0)
    case (x,y,z) if (x != y && y == z) => (x)
    case (x,y,z) if (x != y && y != z) => (x + y + z)
    case (x,y,z) if (x != z && x == y) => (z)
    case (x,y,z) if (y != x && x == z) => (y)
  }
}
println(numInput(1, 2, 3))
println(numInput(3, 3, 3))
println(numInput(1, 1, 2))



//Too Hot

def hotInput (temperature:Int, isSummer:Boolean): Boolean = {
  (temperature, isSummer) match {
    case (temperature, isSummer) if (temperature >=60 && temperature == 100 && isSummer == true) => true
    case (temperature, isSummer) if (temperature >=60 && temperature == 100 && isSummer == false) => false
    case (temperature, isSummer) if (temperature <= 90 && temperature >= 60) => true
    case (temperature, isSummer) if (temperature < 60) => false
  }
}
println(hotInput(80, false))
println(hotInput(100, false))
println(hotInput(100, true))


//More efficient way of doing it, thanks Eliot! SHOW OFF!
def hotInput2 (temperature:Int, isSummer:Boolean): Boolean = {
  (temperature, isSummer) match {
    case (temperature, isSummer) if (temperature >= 60 && temperature <= (if (isSummer) 100 else 90)) => true
    case _ => false
  }
}
println(hotInput2(80, false))
println(hotInput2(100, false))
println(hotInput2(100, true))