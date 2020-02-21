import scala.annotation.tailrec

object Ejemplos {

  def factorial_rec(n: Int): Int =
    if (n == 0) 1 else n * factorial_rec(n - 1)

  def factorial_tail(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 1) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

  def main(args: Array[String]): Unit = {
    println(
      factorial_rec(3), factorial_tail(3)
    )

  }

}
