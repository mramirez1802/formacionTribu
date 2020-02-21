object Ejer1 extends App {


  def lecturaArchivo(): Unit = {

    // val archivo = scala.io.Source.fromFile("C:/Users/w10/Downloads/RealEstate.csv") //mkString


    for (line <- scala.io.Source.fromFile("src/main/scala/Resourses/RealEstate.csv").getLines()) {
      //Resourses/RealEstate.csv
      val columnas = line.split(",")(3)


      if (columnas.matches("[0-9]")) {

        val bedrooms = columnas


        val opcion = bedrooms


        val ya = opcion match {
          case "1" => "chica"
          case "2" => "mediano"
          case "3" | "4" => "grande"
          case "5" => "Familiar"
          case _ =>
        }

        println(ya)
      }
    }


  }
  lecturaArchivo()
}


  /*
  def potencia (num: Int, m: Int):Int = {
    if(m==0)1
    else
      num*potencia(num,m-1)
  }

  def potenciaTail (num: Int, m:Int):Int ={
    def aux (num: Int, m:Int, acum:Int):Int ={
      if(m==0)acum
      else
        aux(num, m-1, acum* num)
    }
    aux(num,m,1)
  }

  println(potenciaTail(5,3))

}
*/