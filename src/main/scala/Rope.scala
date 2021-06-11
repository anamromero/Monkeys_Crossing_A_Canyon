class Rope(){
    // Number of monkeys waiting to cross the rope
    var n_waiting_east: Int = 0
    var n_waiting_west: Int = 0

    // Number of monkeys crossing the rope in this moment
    var n_crossing: Int = 0

    // Direction of the monkeys crossing the rope in this moment
    var direction_now: Int = 0

    // Want to change direction in order to avoid starvation
    var change_direction: Boolean = false

    // Name of directions
    val dir_str: Array[String] = Array("east", "west")

    private def print_new_direction(){
        println("------------------------ Direction now settled to " + dir_str(direction_now) + " ------------------------")
    }

    def arrive(direction: Int){
        /* When a new monkey arrives to the rope, the number of monkeys waiting increases and the direction is changed if needed */ 
        this.synchronized {
            // Increase number of monkeys waiting
            if (direction == 0){ n_waiting_east += 1 }
            else if (direction == 1){ n_waiting_west += 1 }

            println(Thread.currentThread().getName() + " arrived and wants to go to the " + dir_str(direction) + ". \t(" + n_waiting_east + "," + n_waiting_west + ") |")

            // Direction of the rope
            if (n_crossing > 0 && direction != direction_now && !change_direction){
                change_direction = true
                println("--- Emptying rope to change direction and avoid starvation... |")
            }
            else if (n_crossing == 0 && direction_now != direction){
                direction_now = direction
                print_new_direction()
            }
        }
    }
    
    def cross(direction: Int){
        this.synchronized {
            while (direction_now != direction || (direction_now == direction && change_direction)){
                println(Thread.currentThread().getName() + " waiting for the rope to be empty.\t      |")
                wait()
                Thread.sleep(1000)  // Minimum inter-monkey spacing is 1 second
            }

            // Monkey is crossing the rope
            n_crossing += 1
            if (direction == 0){ n_waiting_east -= 1 }
            else if (direction == 1){ n_waiting_west -= 1 }

            println(Thread.currentThread().getName() + " is crossing the rope. \t\t\t(" + n_waiting_east + "," + n_waiting_west + ") | Crossing: (" + n_crossing + ")")
        }
    }

    def leave(){
        this.synchronized {
            n_crossing -= 1
            println(Thread.currentThread().getName() + " left the rope.   \t\t\t(" + n_waiting_east + "," + n_waiting_west + ") | Crossing: (" + n_crossing + ")")

            // If no monkey is crossing
            if (n_crossing == 0){

                // Change direction to requested
                if (change_direction){
                    direction_now = (direction_now + 1) % 2
                    print_new_direction()
                    change_direction = false
                }
                else if (n_waiting_east == 0 && n_waiting_west > 0){
                    direction_now = 1
                    print_new_direction()
                }
                else if (n_waiting_east > 0 && n_waiting_west == 0){
                    direction_now = 0
                    print_new_direction()
                }

                notifyAll()
            }
        }
    }

}
