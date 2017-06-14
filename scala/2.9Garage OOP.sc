//Task 1



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


class VehiclePart (var partName: String, var cost: Double, var broken:Boolean){

  override def toString: String = {
    s"partName: $partName, cost: $cost, broken: $broken"
  }
}



// Garage class for all section 2 functionality

class Garage {
  var vehicleArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle] //creates vehicle array buffer

  def addVehicle(vehicle: Vehicle): Unit = {                                         //adding vehicle function
    vehicleArrayBuffer += vehicle
  }

  def viewVehicles: Unit = {                                                       //view vehicles in garage
    vehicleArrayBuffer.foreach(println)
  }


  var customerArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Customer] //creates customer array buffer

  def addCustomer(customer: Customer): Unit = {                                   //adding customer function
    customerArrayBuffer += customer
  }

  def viewCustomers: Unit = {                                                      //view customers function
    customerArrayBuffer.foreach(println)
  }


  var employeeArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Employee] //creates employee array buffer

  def addEmployee(employee: Employee): Unit = {                                    //adding employee function
    employeeArrayBuffer += employee
  }

  def viewEmployees: Unit = {                                                      //view employees function
    employeeArrayBuffer.foreach(println)
  }



  var vehiclePartArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[VehiclePart] //creates employee array buffer

  def add(vehiclePart: VehiclePart): Unit = {                                    //adding employee function
    vehiclePartArrayBuffer += vehiclePart
  }

  def veiwVehicleParts: Unit = { //view employees function
    vehiclePartArrayBuffer.foreach(println)
  }

  // adding vehicle removal functionality by ID and class

  def removeVehicleByID(ID: Int): Unit = {                 //removing by ID function
    vehicleArrayBuffer = vehicleArrayBuffer.filter(x => !(x.vehicleID == ID))
  }

  def removeVehicleByType(automobile: String): Unit = {    //removing by class function
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
          + "\nFault" + vehicle.fault
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
    (openClose) match {
      case true => println("garage is open")
      case false => println("garage is closed")
      //case _ => println("woops")
    }
  }
}

//Task 2

//create new garage
val garage = new Garage


//adding vehicles
var car1 = new Car(1, "ford", 4, 5, "faulty doodar", false)
var bike1 = new Bike(2, "vroom vroom", 0, 1, "no tyres", false)
var car2 = new Car(3, "mazaratti", 4, 2, "too fast", false)

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
var employee1 = new Employee("e1", "greese monkey", "James", "Galager", 22, "Manchestar mate")

garage.addEmployee(employee1)
garage.viewEmployees


//removing vehicles
garage.removeVehicleByID(1)
garage.viewVehicles

garage.removeVehicleByType("Bike")
garage.viewVehicles

//print garage contents
println(garage.toString)

//opening or closing vehicle
garage.GarageOpening(true)


//Task 3


//adding parts to my garage
var part1 = new VehiclePart("Windshield",200, false)
var part2 = new VehiclePart("exhaust", 150, false)
var part3 = new VehiclePart("piston", 75, false)
var part4 = new VehiclePart("clutch", 600, false)
var part5 = new VehiclePart("headLights", 55, false)
var part6 = new VehiclePart("breakLights", 55, false)
var part7 = new VehiclePart("rearAxel", 250, false)
var part8 = new VehiclePart("FrontAxel", 250, false)
var part9 = new VehiclePart("gasket", 175, false)
var part10 = new VehiclePart("fuelLine", 85, false)

garage.addVehiclePart(part1)

