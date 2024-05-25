/** Angelo Leto - 2024.05.18
 * Implementation of the CVM count-distinct elements algorithm
 * https://en.wikipedia.org/wiki/Count-distinct_problem#CVM_Algorithm
 */

import scala.collection.mutable

object CountCVM {
	implicit class CvmCountOperator[T](iterable: Iterable[T]) {
		def cvmCount(whiteboardSize: Long = 100): Double = {
			val random: scala.util.Random.type = scala.util.Random

			def conjFlip(size: Int): Boolean = {
				random.nextDouble() < math.pow(0.5d, size)
			}

			val count = iterable.foldLeft((0 /*round*/ , mutable.Set[T]() /*whiteboard*/ , 0d /*estimation*/ ))((acc, e) => {
				val (round, s) = (acc._1, acc._2)
				if (conjFlip(round))
					s.add(e)
				else
					s.remove(e)
				val newRound = if (s.size.toLong.compareTo(whiteboardSize) >= 0) {
					s.foreach(removeEl => {
						if (conjFlip(1)) {
							s.remove(removeEl)
						}
					})
					round + 1
				} else {
					round
				}
				(newRound, s, s.size.toDouble / math.pow(0.5d, round.toDouble))
			})
			count._3
		}
	}
}