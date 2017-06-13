// Person, employee and customer classes

abstract class Person {
  var firstName: String
  var secondName: String
  var age: Int
  var address: String

  def showPersonDetails {
    println(firstName, secondName, age, address)
   }
}


class Employee(var employeeID: String,var jobTitle: String,
               var firstName: String, var secondName: String,
               var age: Int, var address: String ) extends Person {

override def toString: String = { //enables the overriding of the inputs to be able to add in new data
  s"EmployeeID $employeeID, JobTitle: $jobTitle, firstname: $firstName, SecondName: $secondName, Age: $age, Address: $address"
   }
}


class Customer( var customerID: Int, var cost: Int, var firstName: String,
                var secondName: String, var age: Int, var address: String) extends Person {

  override def toString: String = {
   s"customerID: $customerID, Cost £: $cost, firstName: $firstName, secondName: $secondName, Age: $age, Address: $address"
  }
}


//  Vehicle, car and bike classes

abstract class Vehicle {
  var vehicleID: Int
  var model: String
  var noTyres: Int
  var fault: String
  var fixed: Boolean

  def showVehicleDetails {
    println("vehicleID:" +vehicleID, "model:" +model, "number of tyres:" +noTyres, "fault:" +fault, "Is Fixed:" +fixed)
  }
}


class Car(var vehicleID: Int, var model: String,
          var noTyres: Int, var noDoors: Int,
          var fault: String, var fixed: Boolean) extends Vehicle {

  override def toString: String = {
    s"vehicleID: $vehicleID, model: $model, number of tyres:  $noTyres, number of doors:  $noDoors, fault:  $fault, fixed?: $fixed"
  }
}


class Bike(var vehicleID: Int, var model: String, var noTyres: Int, var noSeats: Int,
           var fault: String, var fixed: Boolean) extends Vehicle {

  override def toString: String = {
   s"vehicleID: $vehicleID, model: $model, number of tyres: $noTyres, number of seats: $noSeats, fault: $fault, fixed?: $fixed"
  }
}



// Garage class for all section 2 functionality

class Garage {
  var vehicleArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle] //creates vehicle array buffer

  def addVehicle(vehicle: Vehicle): Unit = { //adding vehicle function
    vehicleArrayBuffer += vehicle
  }

  def viewVehicles: Unit = { //view vehicles in garage
    vehicleArrayBuffer.foreach(println)
  }


  var customerArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Customer] //creates customer array buffer

  def addCustomer(customer: Customer): Unit = { //adding customer function
    customerArrayBuffer += customer
  }

  def viewCustomers: Unit = { //view customers function
    customerArrayBuffer.foreach(println)
  }


  var employeeArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Employee] //creates employee array buffer

  def addEmployee(employee: Employee): Unit = { //adding employee function
    employeeArrayBuffer += employee
  }

  def viewEmployees: Unit = { //view employees function
    employeeArrayBuffer.foreach(println)
  }


  // adding vehicle removal functionality by ID and class

  def removeVehicleByID(ID: Int): Unit = { //removing by ID function
    vehicleArrayBuffer = vehicleArrayBuffer.filter(x => !(x.vehicleID == ID))
  }

  def removeVehicleByType(automobile: String): Unit = { //removing by class function
    automobile match {
      case "Car" => vehicleArrayBuffer = vehicleArrayBuffer.filter(x => x.isInstanceOf[Bike])
      case "Bike" => vehicleArrayBuffer = vehicleArrayBuffer.filter(x => x.isInstanceOf[Car])
    }
  }

  // fixing vehicles functionality

  def setFixed(inID: String) {
    for (x <- 0 to vehicleArrayBuffer.size - 1) {
      inID.equals(vehicleArrayBuffer(x).vehicleID) match {
        case true => vehicleArrayBuffer(x).fixed = true
        case false =>
      }
    }
  }

  // calculating bills functionality

  def calculatingBills(hours: Double, labourCharge: Double, partCost: Double): Double = {
    var calculation: Double = (hours * labourCharge) + partCost
    calculation
  }

  //Outputting contents of Garage

  override def toString: String = {
    var outPut: String = ""
    for (x <- 0 to vehicleArrayBuffer.size - 1) {           //starts ticker through array values
      outPut += (
        "Vehicle ID: " + vehicleArrayBuffer(x).vehicleID
          + "\nModel: " + vehicleArrayBuffer(x).model
          + "\nNumbers of Tyres" + vehicleArrayBuffer(x).noTyres
          + "\nFault" + vehicleArrayBuffer(x).fault
          + "\nFixed?" + vehicleArrayBuffer(x).fixed
        )
      vehicleArrayBuffer(x).getClass.toString.substring(6) match {
        case "Car" =>
          outPut += ("\nNumber of Doors: " + vehicleArrayBuffer(x).asInstanceOf[Car].noDoors)
        case "Bike" =>
          outPut += ("\nNoSeats:" + vehicleArrayBuffer(x).asInstanceOf[Bike].noSeats)
      }
    }

    for (y <- 0 to vehicleArrayBuffer.size - 1) {
      outPut += (
        "customer ID: " + customerArrayBuffer(y).customerID
          + "\ncost: " + customerArrayBuffer(y).cost
          + "\nFirst name" + customerArrayBuffer(y).firstName
          + "\nSecond name" + customerArrayBuffer(y).secondName
          + "\nAge" + customerArrayBuffer(y).age
          + "\nAddress" + customerArrayBuffer(y).address
        )
    }

    for (z <- 0 to employeeArrayBuffer.size - 1) {
      outPut += (
        "Employee ID: " + employeeArrayBuffer(z).employeeID
          + "\nFirst name" + employeeArrayBuffer(z).firstName
          + "\nSecond name" + employeeArrayBuffer(z).secondName
          + "\nAge" + employeeArrayBuffer(z).age
          + "\nAddress" + employeeArrayBuffer(z).address
        )
    }
    outPut
  }

// Opening and closing the Garage

def GarageOpening(openClose: Boolean) : String = {
  true => println("garage is open")
  false => println("garage is closed")
  }
}

val garage = new Garage


var car1 = new Car(1, "ford", 4, 5, "faulty doodar", false)
var bike1 = new Bike(2, "vroom vroom", 0, 1, "no tyres", false)


garage.addVehicle(car1)
garage.addVehicle(bike1)
garage.viewVehicles

var customer1 = new Customer(1, 30000, "Jack", "Whistlecraft", 30, "The Heart, Manchester")
var customer2 = new Customer(2, 20, "Robin", "Watkins", 25, "Somewhere else, not in Manchester")

garage.addCustomer(customer1)
garage.addCustomer(customer2)
garage.viewCustomers

var employee1 = new Employee("e1", "greese monkey", "James", "Galager", 22, "Manchestar mate")

garage.addEmployee(employee1)
garage.viewEmployees

//garage.removeVehicleByID(1)
//garage.viewVehicles

//garage.removeVehicleByType("Bike")
//garage.viewVehicles

println(garage.toString)

