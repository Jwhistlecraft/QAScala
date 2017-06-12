abstract class Person {
  var firstName: String
  var secondName: String
  var age: Int
  var address: String

  def showPersonDetails {
    println(firstName, secondName, age, address)
   }
}

class Employee(var employeeID: Int, var firstName: String) extends Person {
  //var employeeID: Int = 0
  var jobTitle: String = ""
  //var firstName: String = ""
  var secondName: String = ""
  var age: Int = 0
  var address: String = ""

  override def toString: String = { //enables the overriding of the inputs to be able to add in new data
   s"EmployeeID $employeeID, JobTitle: $jobTitle, firstname: $firstName, SecondName: $secondName, Age: $age, Address: $address"
   }
}

class Customer() extends Person {
  var customerID: Int = 0
  var basket: Array[Any] = Array.empty
  var cost: Int = 0
  var firstName: String = ""
  var secondName: String = ""
  var age: Int = 0
  var address: String = ""

  override def toString: Any = {
   s"customerID: $customerID, Basket: $basket, Cost: $cost, firstName: $firstName, secondName: $secondName, Age: $age, Address: $address"
  }
}

abstract class Vehicle {
  var vehicleID: Int
  var model: String
  var noTyres: Int
  var fault: String

  override def toString: String = {
    s"vehicleID: $vehicleID, model: $model, number of tyres: $noTyres, fault $fault"
  }
}

class Car(vehicleId: Int) extends Vehicle {
  var vehicleID: Int = vehicleId
  var model: String = ""
  var noTyres: Int = 0
  var noDoors: Int= 0
  var fault: String = ""

  override def toString: String = {
    s"vehicleID: $vehicleID, model: $model, number of tyres:  $noTyres, number of doors:  $noDoors, fault  $fault"
  }
}

class Bike() extends Vehicle {
  var vehicleID: String = ""
  var model: String = ""
  var noTyres: Int = 0
  var fault: String =""

  override def toString: String = {
   s"vehicleID: $vehicleID, model: $model, number of tyres: $noTyres, fault $fault"
  }
}

class Garage {
  val vehicleArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle] //creates an array buffer

  def addVehicle(vehicle: Vehicle): Unit = {  //adds a vehicle of type Vehicle
    vehicleArrayBuffer += vehicle               // to the array buffer
  }

  def viewVehicles: Unit = {
    vehicleArrayBuffer.foreach(println)
  }
}

var car1 = new Car(1,ford, 4,5, faulty doodar)

var garage = new Garage
garage.addVehicle(car1)


