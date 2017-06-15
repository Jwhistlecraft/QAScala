import scala.collection.mutable.ListBuffer
//TASK 1



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

class Employee(var employeeID: String,available: Boolean, var jobTitle: String,
               var firstName: String, var secondName: String,
               var age: Int, var address: String ) extends Person {

override def toString: String = {                //enables the overriding of the inputs to be able to add in new data
  s"EmployeeID $employeeID, Available? $available, JobTitle: $jobTitle, firstname: $firstName, SecondName: $secondName, Age: $age, Address: $address"
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
  var fixed: Boolean

  var vehiclePartArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[VehiclePart]

  def addVehiclePart(vehiclePart: VehiclePart): Unit = {
    vehiclePartArrayBuffer += vehiclePart
    val isItBroken = scala.util.Random
    isItBroken.nextInt(2)
    match {
      case 1 => vehiclePartArrayBuffer(vehiclePartArrayBuffer.size - 1).broken = true
      case 0 => vehiclePartArrayBuffer(vehiclePartArrayBuffer.size - 1).broken = false

    }
  }
  def viewVehicleParts: Unit = {
    vehiclePartArrayBuffer.foreach(a=>println(a))
  }

  def showVehicleDetails {
    println("vehicleID:" +vehicleID, "model:" +model, "number of tyres:" +noTyres, "Is Fixed:" +fixed)
  }
}


class Car(var vehicleID: Int, var model: String,
          var noTyres: Int, var noDoors: Int, var fixed: Boolean) extends Vehicle {

  override def toString: String = {
    s"vehicleID: $vehicleID, model: $model, number of tyres:  $noTyres, number of doors:  $noDoors, fixed?: $fixed"
  }
}


class Bike(var vehicleID: Int, var model: String, var noTyres: Int, var noSeats: Int,
           var fixed: Boolean) extends Vehicle {

  override def toString: String = {
   s"vehicleID: $vehicleID, model: $model, number of tyres: $noTyres, number of seats: $noSeats, fixed?: $fixed"
  }
}

//vehicle part class
class VehiclePart (var partName: String, var timeToFix: Double, var cost: Double, var broken: Boolean){

  override def toString: String = {
    s"partName: $partName, time to fix: $timeToFix cost: $cost, broken: $broken"
  }
}



// Garage class for all section 2 functionality

class Garage {
  var vehicleArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle]               //creates vehicle array buffer


  //adding add vehicle functionality
  def addVehicle(vehicle: Vehicle): Unit = {                                                   //adding vehicle function
    vehicleArrayBuffer += vehicle


  }

  def viewVehicles: Unit = {                                                                  //view vehicles in garage
    vehicleArrayBuffer.foreach(a=>println(a))
  }

// adding add customer functionality
  var customerArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Customer]

  def addCustomer(customer: Customer): Unit = {
    customerArrayBuffer += customer
  }

  def viewCustomers: Unit = {
    customerArrayBuffer.foreach(a=>println(a))
  }

//adding add employee functionality
  var employeeArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Employee]

  def addEmployee(employee: Employee): Unit = {
    employeeArrayBuffer += employee
  }

  def viewEmployees: Unit = {
    employeeArrayBuffer.foreach(a=>println(a))
  }




  // adding vehicle removal functionality by ID and class

  def removeVehicleByID(ID: Int): Unit = {                                               //removing by ID function
    vehicleArrayBuffer = vehicleArrayBuffer.filter(x => !(x.vehicleID == ID))
  }

  def removeVehicleByType(automobile: String): Unit = {                                  //removing by class function
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

    vehicleArrayBuffer.foreach (vehicle => {
      outPut += (
        "Vehicle ID: " + vehicle.vehicleID
          + "\nModel: " + vehicle.model
          + "\nNumbers of Tyres" + vehicle.noTyres
          + "\nFixed?" + vehicle.fixed
                  )
      vehicle match {
        case car: Car =>
          outPut += ("\nNumber of Doors: " + car.noDoors)+ "\n" + "\n"
        case bike: Bike =>
          outPut += ("\nNoSeats:" + bike.noSeats)+ "\n" + "\n"

        }
      }
    )

    customerArrayBuffer.foreach(customer => {
      outPut += (
        "customer ID: " + customer.customerID
          + "\ncost: " + customer.cost
          + "\nFirst name" + customer.firstName
          + "\nSecond name" + customer.secondName
          + "\nAge" + customer.age
          + "\nAddress" + customer.address
          + "\n"
          + "\n"
        )
      }
    )

    employeeArrayBuffer.foreach (employee => {
      outPut += (
        "Employee ID: " + employee.employeeID

          + "\nFirst name" + employee.firstName
          + "\nSecond name" + employee.secondName
          + "\nAge" + employee.age
          + "\nAddress" + employee.address
          + "\n"
          + "\n"
        )
      }
    )
    outPut
  }


  // Opening and closing the Garage

  def GarageOpening(openClose: Boolean): Unit = {
    openClose match {
      case true => println("garage is open")
      case false => println("garage is closed")
      }
  }

  //RUNNING THE GARAGE

  //Open the garage
  GarageOpening(true)

  //create list of all vehicles and there faults
 def workLoad= vehicleArrayBuffer
  //check availability of employees and assign vehicle to available staff

  //repeat so all staff are occupied and repeat until all work is complete

  //close garage
 GarageOpening(false)
  // print when a vehicle was attending and by whom

  // print out how much each repair cost and total cost

}


//TASK 2

//create new garage
val garage = new Garage


//adding vehicles
var car1 = new Car(1, "ford", 4, 5, false)
var bike1 = new Bike(2, "vroom vroom", 2, 1, false)
var car2 = new Car(3, "mazaratti", 4, 3, false)
var car3 = new Car(4,"Mustang", 4, 5, false)
var bike2 = new Bike(5, "Honda", 2, 2, false)
var bike3 = new Bike(6, "Triumph", 2, 2,false)
var car4 = new Car(7, "mercedez", 4, 5, false)
var car5 = new Car(8, "Farrari", 4, 3, false)
var bike4 = new Car(9, "Yamaha", 2, 3, false)
var bike5 = new Bike(10, "GoldWing", 2, 3, false)

garage.addVehicle(car1)
garage.addVehicle(bike1)
garage.addVehicle(car2)
garage.viewVehicles


//adding customers
var customer1 = new Customer(1, 30000, "Jack", "Whistlecraft", 30, "The Heart, Manchester")
var customer2 = new Customer(2, 20, "Robin", "Watkins", 25, "Somewhere else, not in Manchester")
var customer3 = new Customer(3, 500, "Esti", "Squinkica", 30, "Way too far away!")

garage.addCustomer(customer1)
garage.addCustomer(customer2)
garage.addCustomer(customer3)
garage.viewCustomers


//adding employees
var employee1 = new Employee("e1", true, "long jobs", "Spider", "Man", 22, "Manchestar")
var employee2 = new Employee("e2", true, "medium jobs", "Bat", "Man", 86, "Gothom")
var employee3 = new Employee("e3", true, "short jobs", "Super", "Man", 1000, "Whole world")

garage.addEmployee(employee1)
garage.viewEmployees


//removing vehicles
//garage.removeVehicleByID(1)
//garage.viewVehicles

//garage.removeVehicleByType("Bike")
//garage.viewVehicles

//print garage contents
println(garage.toString)

//opening or closing garage
//garage.GarageOpening(true)

//TASK 3

//adding parts to my garage
var part1 = new VehiclePart("Windshield",6,200,false)
var part2 = new VehiclePart("exhaust",8, 150, false )
var part3 = new VehiclePart("piston", 12, 75, false )
var part4 = new VehiclePart("clutch", 11, 600, false)
var part5 = new VehiclePart("headLights", 2, 55,false)
var part6 = new VehiclePart("breakLights",2, 55,false)
var part7 = new VehiclePart("rearAxel",7, 250, false)
var part8 = new VehiclePart("FrontAxel",7, 250, false)
var part9 = new VehiclePart("gasket", 9, 175, false)
var part10 = new VehiclePart("fuelLine", 4, 85, false)

car1.addVehiclePart(part1)
car1.addVehiclePart(part2)
car1.addVehiclePart(part3)
car1.addVehiclePart(part4)
car1.addVehiclePart(part5)
car1.addVehiclePart(part6)
car1.addVehiclePart(part7)
car1.addVehiclePart(part8)
car1.addVehiclePart(part9)
car1.addVehiclePart(part10)

car1.viewVehicleParts

car2.addVehiclePart(part1)
car2.addVehiclePart(part2)
car2.addVehiclePart(part3)
car2.addVehiclePart(part4)
car2.addVehiclePart(part5)
car2.addVehiclePart(part6)
car2.addVehiclePart(part7)
car2.addVehiclePart(part8)
car2.addVehiclePart(part9)
car2.addVehiclePart(part10)

car2.viewVehicleParts

car3.addVehiclePart(part1)
car3.addVehiclePart(part2)
car3.addVehiclePart(part3)
car3.addVehiclePart(part4)
car3.addVehiclePart(part5)
car3.addVehiclePart(part6)
car3.addVehiclePart(part7)
car3.addVehiclePart(part8)
car3.addVehiclePart(part9)
car3.addVehiclePart(part10)

car3.viewVehicleParts

car4.addVehiclePart(part1)
car4.addVehiclePart(part2)
car4.addVehiclePart(part3)
car4.addVehiclePart(part4)
car4.addVehiclePart(part5)
car4.addVehiclePart(part6)
car4.addVehiclePart(part7)
car4.addVehiclePart(part8)
car4.addVehiclePart(part9)
car4.addVehiclePart(part10)

car4.viewVehicleParts

car5.addVehiclePart(part1)
car5.addVehiclePart(part2)
car5.addVehiclePart(part3)
car5.addVehiclePart(part4)
car5.addVehiclePart(part5)
car5.addVehiclePart(part6)
car5.addVehiclePart(part7)
car5.addVehiclePart(part8)
car5.addVehiclePart(part9)
car5.addVehiclePart(part10)

car5.viewVehicleParts

bike1.addVehiclePart(part1)
bike1.addVehiclePart(part2)
bike1.addVehiclePart(part3)
bike1.addVehiclePart(part4)
bike1.addVehiclePart(part5)
bike1.addVehiclePart(part6)
bike1.addVehiclePart(part7)
bike1.addVehiclePart(part8)
bike1.addVehiclePart(part9)
bike1.addVehiclePart(part10)

bike1.viewVehicleParts

bike2.addVehiclePart(part1)
bike2.addVehiclePart(part2)
bike2.addVehiclePart(part3)
bike2.addVehiclePart(part4)
bike2.addVehiclePart(part5)
bike2.addVehiclePart(part6)
bike2.addVehiclePart(part7)
bike2.addVehiclePart(part8)
bike2.addVehiclePart(part9)
bike2.addVehiclePart(part10)

bike2.viewVehicleParts

bike3.addVehiclePart(part1)
bike3.addVehiclePart(part2)
bike3.addVehiclePart(part3)
bike3.addVehiclePart(part4)
bike3.addVehiclePart(part5)
bike3.addVehiclePart(part6)
bike3.addVehiclePart(part7)
bike3.addVehiclePart(part8)
bike3.addVehiclePart(part9)
bike3.addVehiclePart(part10)

bike3.viewVehicleParts

bike4.addVehiclePart(part1)
bike4.addVehiclePart(part2)
bike4.addVehiclePart(part3)
bike4.addVehiclePart(part4)
bike4.addVehiclePart(part5)
bike4.addVehiclePart(part6)
bike4.addVehiclePart(part7)
bike4.addVehiclePart(part8)
bike4.addVehiclePart(part9)
bike4.addVehiclePart(part10)

bike4.viewVehicleParts

bike5.addVehiclePart(part1)
bike5.addVehiclePart(part2)
bike5.addVehiclePart(part3)
bike5.addVehiclePart(part4)
bike5.addVehiclePart(part5)
bike5.addVehiclePart(part6)
bike5.addVehiclePart(part7)
bike5.addVehiclePart(part8)
bike5.addVehiclePart(part9)
bike5.addVehiclePart(part10)

bike5.viewVehicleParts




