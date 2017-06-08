java.util.TimeZone.getAvailableIDs()
  .map(item =>item.split("/")) //sends data to temp array and splits any datum into items with size two because of the / and items of size 1 because of not having a split
  .filter (item => item.size > 1) // filter out all items without a size greater than 1
  .map(a => a(1)) //create new temp array taking all items from position two (due to array starting at 0)
  .grouped(50) // group all items into groups of 50
  .map(a=> a(0)) // create temp array taking all itmes in first postion
  .toArray.foreach(item => println(item)) //generate final array and print all items contained

