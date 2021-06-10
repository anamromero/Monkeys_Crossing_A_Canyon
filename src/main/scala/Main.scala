object Monkey_Scala {
    
    def main(args: Array[String]): Unit = {
        // Header for debugging
        println("---------------------------------------------------------------")
        println("Actions  \t\t\tWaiting (E/W) | Now crossing...")
        println("---------------------------------------------------------------")

        // Create rope
        val rope: Rope = new Rope()

        // Create monkeys
        for (x <- 1 to 5){
            val direction = scala.util.Random.nextInt(2)
            var monkey = new Thread(new Monkey(rope, direction))
            monkey.setName(x.toString() + "(" + direction + ")")
            monkey.start()
        }
    }
}