import scala.util.Random

class Monkey(var rope: Rope, var direction: Int) extends Runnable {

    override def run(){
        // Wait 1-8 seconds to arrive the rope
        Thread.sleep(scala.util.Random.nextInt(8000 - 1000 + 1) + 1000)

        // Arrive to the rope
        rope.arrive(direction)

        // Cross the rope
        rope.cross(direction)
        Thread.sleep(4000)   // Monkey spends this time crossing the rope

        // Leave the rope
        rope.leave()
    }
}

