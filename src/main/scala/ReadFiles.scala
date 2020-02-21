import scala.io.Source

object ReadFiles extends App{

    val filename = "resources/RealEstate.csv"

    //Se crea una lista
    val lines = Source.fromFile(filename).getLines().map(_.split(",")).toArray

    //Se aplica el filtro
    val datos = lines.filter(row => {
      row(3).matches("\\d+")
    }
    ).map(
      row => {
        row(3).toInt match {
          case 1 => "chico"
          case 2 => "mediano"
          case 3 => "grande"
          case 4 => "familiar"
          case _ => ""
        }
      }
    )


    //Se muestra la salida
    for (element <- datos) {
      println(element)
    }


}
