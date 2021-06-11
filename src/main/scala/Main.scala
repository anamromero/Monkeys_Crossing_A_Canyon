object Monkey_Scala {

    // Name of directions
    val dir_str: Array[String] = Array("east", "west")

    def main(args: Array[String]): Unit = {

        try {
            // Get number of monkeys from arguments
            val n_monkeys: Int = Integer.parseInt(args(0).trim)

            // Header for debugging
            println("-------------------------------------------------------------------------------")
            println("Actions  \t\t\t\t\tWaiting (E/W) | Now crossing...")
            println("-------------------------------------------------------------------------------")

            // Create rope
            val rope: Rope = new Rope()

            // Create monkeys
            println("Waiting for " + n_monkeys + " monkeys to arrive to the rope...\t\t      |")
            for (x <- 1 to n_monkeys){
                val direction = scala.util.Random.nextInt(2)

                try {
                    var monkey = new Thread(new Monkey(rope, direction))
                    monkey.setName("Monkey " + x.toString() + " (" + dir_str(direction) + ")")
                    monkey.start()
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                }
            }

        } catch {
            case e: Exception => println("ERROR. Please, insert the number of monkeys as an argument.")
        }

        
    }
}
