object Monkey_Scala {
    
    def main(args: Array[String]): Unit = {

        // Create rope
        val rope: Rope = new Rope()

        // Create monkeys
        for (x <- 1 to 5){
            var monkey = new Thread(new Monkey(rope))
            monkey.setName(x.toString())
            monkey.start()
        }
    }
}