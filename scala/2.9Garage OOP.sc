import scala.collection.mutable.ArrayBuffer
//TASK 1
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

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

class Employee(var employeeID: String, var available: Boolean, var jobTitle: String,
               var firstName: String, var secondName: String,
               var age: Int, var address: String ) extends Person {

  var EmpVehArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle]


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
  var timeTaken: Double

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
          var noTyres: Int, var noDoors: Int, var fixed: Boolean, var timeTaken: Double) extends Vehicle {

  override def toString: String = {
    s"vehicleID: $vehicleID, model: $model, number of tyres:  $noTyres, number of doors:  $noDoors, fixed?: $fixed"
  }
}


class Bike(var vehicleID: Int, var model: String, var noTyres: Int, var noSeats: Int,
           var fixed: Boolean, var timeTaken: Double) extends Vehicle {

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
  var vehicleArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle] //creates vehicle array buffer


  //adding add vehicle functionality
  def addVehicle(vehicle: Vehicle): Unit = { //adding vehicle function
    vehicleArrayBuffer += vehicle

    vehicleArrayBuffer(vehicleArrayBuffer.size - 1).timeTaken = {
      var totalTime: Double = 0.0
      for (y <- 0 to vehicleArrayBuffer(vehicleArrayBuffer.size - 1).vehiclePartArrayBuffer.size - 1) {
        vehicleArrayBuffer(vehicleArrayBuffer.size - 1).vehiclePartArrayBuffer(y).broken == true match {
          case true => totalTime += vehicleArrayBuffer(vehicleArrayBuffer.size - 1).vehiclePartArrayBuffer(y).timeToFix
          case false =>
        }
      }
      totalTime
    }
  }


  def viewVehicles: Unit = { //view vehicles in garage
    vehicleArrayBuffer.foreach(a => println(a))
  }

  // adding add customer functionality
  var customerArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Customer]

  def addCustomer(customer: Customer): Unit = {
    customerArrayBuffer += customer
  }

  def viewCustomers: Unit = {
    customerArrayBuffer.foreach(a => println(a))
  }

  //adding add employee functionality
  var employeeArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Employee]

  def addEmployee(employee: Employee): Unit = {
    employeeArrayBuffer += employee
  }

  def viewEmployees: Unit = {
    employeeArrayBuffer.foreach(a => println(a))
  }

  //running the garage, employee vehicle array
  var EmpVehArrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Vehicle]


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

    vehicleArrayBuffer.foreach(vehicle => {
      outPut += (
        "Vehicle ID: " + vehicle.vehicleID
          + "\nModel: " + vehicle.model
          + "\nNumbers of Tyres" + vehicle.noTyres
          + "\nFixed?" + vehicle.fixed
        )
      vehicle match {
        case car: Car =>
          outPut += ("\nNumber of Doors: " + car.noDoors) + "\n" + "\n"
        case bike: Bike =>
          outPut += ("\nNoSeats:" + bike.noSeats) + "\n" + "\n"

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

    employeeArrayBuffer.foreach(employee => {
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
  def vFix(index: Int): Unit = {
    // Copies index (current vehicle) to a new variable so it can be incremented.
    var theIndex = index

    // Check if index equals the size of the garage's vehicle list.
    theIndex == vehicleArrayBuffer.size match {
      case true => //  end of the vehicle list.
      case false => // start/continue the loop.

        /* Causes the employee availability check to loop through all employees
           repeatedly until the switch value is changed from 0 to something else. */
        var availableSwitch = 0
        while (availableSwitch == 0) {

          /* If an available employee is matched with a vehicle, 'theval' will become false.
             If 'theval' is false, it will not bother checking the rest of the employees as
             a match has been found, and will effectively skip to the end of the loop. */
          var theval: Boolean = true

          /* Loop through all employees (this loop is repeated indefinitely while 'availableswitch'
             equals 0, i.e. no employees are available). */
          for (x <- 0 to employeeArrayBuffer.size - 1
               if (theval) == true) {

            // Checks if the current employee is available.
            employeeArrayBuffer(x).available == true match {
              case true => // If available:

                // Set current employee availability to false.
                employeeArrayBuffer(x).available = false

                // Add the current vehicle to the employee's vehicle list.
                EmpVehArrayBuffer += vehicleArrayBuffer(index)

                // Print out which employee is handling the current vehicle and the time the work started and ended.
                println("Employee " + employeeArrayBuffer(x).firstName + " " + employeeArrayBuffer(x).secondName + " is handling Vehicle " + vehicleArrayBuffer(index).vehicleID)
                println(
                  "Time Started: "
                    + (f"${
                    employeeArrayBuffer(x).EmpVehArrayBuffer.size == 1 match {
                      case true => 0.0
                      case false =>
                        employeeArrayBuffer(x).EmpVehArrayBuffer.size == 2 match {
                          case true => employeeArrayBuffer(x).EmpVehArrayBuffer(0).timeTaken
                          case false =>
                            var outTime: Double = 0.0
                            for (a <- 0 to employeeArrayBuffer.size - 2) {
                              outTime += employeeArrayBuffer(x).EmpVehArrayBuffer(a).timeTaken
                            }
                            outTime
                        }
                    }
                  }%.2f")
                    + " hours.\nTime Finished: " + (f"${
                    employeeArrayBuffer(x).EmpVehArrayBuffer.size == 1 match {
                      case true => employeeArrayBuffer(x).EmpVehArrayBuffer(0).timeTaken
                      case false =>
                        var outTimeEnd: Double = 0.0
                        for (a <- 0 to employeeArrayBuffer(x).EmpVehArrayBuffer.size - 1) {
                          outTimeEnd += employeeArrayBuffer(x).EmpVehArrayBuffer(a).timeTaken
                        }
                        outTimeEnd
                    }
                  }%.2f" + " hours.")
                )

                // Print the cost of fixing the current vehicle.
                //println(vehicleArrayBuffer(index). + "\n")

                // Call the function to make the employee work on a vehicle for a specific time.
                doTask(x)

                // Set 'theval' to false so the rest of the employees are skipped.
                theval = false

                /* The availability switch will change from 0 to 1 to prevent the entire employee
                   list check running again. */
                availableSwitch += 1

              //

              case false => // If the employee isn't available, skip to the next one.
            }
          }

        }

        // Calls the function again with the index + 1 (the index of the next Vehicle in the garage's vehicle list.)
        vFix(index + 1)
    }

  }

  // Defines the sleep function.
  def sleep(time: Long) {
    Thread.sleep(time)
  }

  // Gets the time taken for a specific employee's most recently added Vehicle to be repaired.
  // The function simulates the time taken before the employee finishes this task and becomes available again.
  def doTask(theEmp: Int): Unit = {
    val function = Future {
      sleep(employeeArrayBuffer(theEmp).EmpVehArrayBuffer.last.timeTaken.toLong)
      employeeArrayBuffer(theEmp).available = true

    }
  }
}


  //TASK 2

  //create new garage
  val garage = new Garage


  //adding vehicles
  var car1 = new Car(1, "ford", 4, 5, false, 0.0)
  var bike1 = new Bike(2, "vroom vroom", 2, 1, false, 0.0)
  var car2 = new Car(3, "mazaratti", 4, 3, false, 0.0)
  var car3 = new Car(4, "Mustang", 4, 5, false, 0.0)
  var bike2 = new Bike(5, "Honda", 2, 2, false, 0.0)
  var bike3 = new Bike(6, "Triumph", 2, 2, false, 0.0)
  var car4 = new Car(7, "mercedez", 4, 5, false, 0.0)
  var car5 = new Car(8, "Farrari", 4, 3, false, 0.0)
  var bike4 = new Car(9, "Yamaha", 2, 3, false, 0.0)
  var bike5 = new Bike(10, "GoldWing", 2, 3, false, 0.0)

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
  var part1 = new VehiclePart("Windshield", 6, 200, false)
  var part2 = new VehiclePart("exhaust", 8, 150, false)
  var part3 = new VehiclePart("piston", 12, 75, false)
  var part4 = new VehiclePart("clutch", 11, 600, false)
  var part5 = new VehiclePart("headLights", 2, 55, false)
  var part6 = new VehiclePart("breakLights", 2, 55, false)
  var part7 = new VehiclePart("rearAxel", 7, 250, false)
  var part8 = new VehiclePart("FrontAxel", 7, 250, false)
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

  garage.vFix(0)

// not managed to get a print out