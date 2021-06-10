import scala.util.Random

class Monkey(var rope: Rope) extends Runnable {

    override def run(){
        // Wait 1-8 seconds to arrive the rope
        Thread.sleep(scala.util.Random.nextInt(8 * 1000))

        // Arrive to the rope
        rope.arrive()

        // Cross the rope
        rope.cross()
        Thread.sleep(10000)   // Monkey spends this time crossing the rope

        // Leave the rope
        println("Monkey " + Thread.currentThread().getName() + " crossed the rope!")
        rope.leave()
    }
}

