import scala.annotation.tailrec

object Ejercicio2 extends App {
  def readFile(fileName: String): Iterator[String] = io.Source.fromFile(fileName).getLines

  val ds: Array[Array[String]] = readFile("/home/genzo/RealEstate.csv").map(_.split(",")).toArray

  val finalList = ds
    .filter(
      row => {
        val cell = row(3)
        cell.matches("\\d+")
      }
    ).map(
    row => {
      row(3).toInt match {
        case 1 => "chico"
        case 2 => "mediano"
        case 3 => "grande"
        case 4 => "familiar"
        case _ =>
      }
    }
  )

  finalList.foreach(
    println(_)
  )

  val lambda = () => {
    5 + 4
    5.+(4)
  }

  println(lambda)

  def factorial_rec(n: Int): Int = {
    if (n == 0)
      1
    else
      n * factorial_rec(n - 1)
  }


  def factorial_tail(n: Int): Int = {

    def iter(x: Int, result: Int): Int = {
      if (x == 1)
        result
      else
        iter(x - 1, result * x)
    }

    iter(n, 1)
  }


  println(factorial_rec(300))
  println(factorial_tail(300))


  def potencia(num: Long, m: Long): Long = {
    if (m == 0)
      1
    else
      num * potencia(num, m - 1)
  }

  println(potencia(8, 500))

  def potenciaTail(num: Long, m: Long): Long = {
    def aux(num: Long, m: Long, acc: Long): Long = {
      if (m == 0)
        acc
      else
        aux(num, m - 1, acc * num)
    }

    aux(num, m, 1)
  }

  println(potenciaTail(8, 500))

}


abstract class Example {
  def metodo1(n: Int)

  def metodo2(x: String)
}

abstract class Example4 {
  def metodo4(n: Int):Int
  def metodo4(x:Int, y:String):Int
}

trait Electrico {
  def impactTrueno: String = {
    "rayos"
  }
}

class Example5(nombre:String){
}


class Pokemon(example:Example5) extends Example with Electrico {

  override def metodo1(n: Int): Unit = {

  }

  override def metodo2(x: String): Unit = {
    super.impactTrueno
  }

  new Pokemon(example = new Example5("Pikachu"))
}



