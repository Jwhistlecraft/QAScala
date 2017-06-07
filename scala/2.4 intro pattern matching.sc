
//Patern Matching- conditionals 1

def patNumz(a: Int, b: Int, bool: Boolean): Unit = {

  bool match {
    case true => println(a + b)
    case false => println(a * b)
    case _ => println(0)
  }
}

patNumz(2, 3, false)
patNumz(2, 3, true)



//Patern Matching - conditionals 2
def numz4(a: Int, b: Int, bool2: Boolean): Int = {
  a == 0 && b == 0 match {
    case true => 0
    case false => a == 0 match {
      case true => b
      case false => b == 0 match {
        case true => a
        case false => bool2 match {
            case true => a + b
            case false => a * b
          }
        }
      }
    }

}
numz4(3, 0, true) //conditionals 2
numz4(0, 2, true)
numz4(0, 0, true)
numz4(3, 2, true)

numz4(3, 0, false) //conditionals 2
numz4(0, 2, false)
numz4(0, 0, false)
numz4(3, 2, false)


