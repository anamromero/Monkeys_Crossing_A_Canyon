class Rope(){
    // Number of monkeys waiting to cross the rope
    var n_waiting: Int = 0
    var monkey_crossing = false

    def arrive(){
        this.synchronized{
            n_waiting += 1
            println("Monkey " + Thread.currentThread().getName() + " arrived the rope. " + n_waiting + " monkeys waiting.")
        }
    }
    
    def cross(){
        this.synchronized{
            n_waiting -= 1
            println("Monkey " + Thread.currentThread().getName() + " is crossing the rope. " + n_waiting + " monkeys waiting.")
        }
    }

    def leave(){
        println("Monkey " + Thread.currentThread().getName() + " left the rope. " + n_waiting + " monkeys waiting.")
    }

}
