import scala.collection.mutable
import CountCVM._

class Naive[T] {
  private val s = mutable.Set[T]()
  def ingest(e: T): Unit = {
      s.add(e)
  }
  def count: Int = s.size
}

object Test {
  def main(args: Array[String]): Unit = {
    if(args.length < 3) {
      println("")
      println(
        """Usage: Test <m> <n> <window size>
          |where
          |<m> -> is the length of the random sequence
          |<n> -> is the max number of symbols
          |<window size> -> the window size
          |
          |Example: scala Test.scala 30000 4000 100
          |""".stripMargin)
      System.exit(0)
    }

    val m =  args(0).toInt
    val n = args(1).toInt
    val ws = args(2).toInt
    val naive = new Naive[Long]()
    val random: scala.util.Random.type = scala.util.Random
    val randSequence = LazyList continually random.nextLong(n)
    val cvmCount = randSequence.take(m).map(e => {
      naive.ingest(e)
      e
    }).cvmCount()
    println(s"""Result: exact(${naive.count}), estimation($cvmCount)""")
  }
}