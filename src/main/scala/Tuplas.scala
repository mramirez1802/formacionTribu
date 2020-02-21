object Tuplas {

  def main(args: Array[String]): Unit = {
    val planets = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
      ("Mars", 227.9), ("Jupiter", 778.3))
    planets.foreach {
      case ("Earth", distance) =>
        println(s"Our planet is $distance million kilometers from the sun")
      case _ =>
    }

    var states = scala.collection.mutable.Map[String, String]()

    states += ("AZ" -> "Arizona")

    states foreach { case (key, value) => println(key + "-->" + value) }

    states.foreach(x => {

      println(x._1 + "-->" + x._2)
    })

  }

}
