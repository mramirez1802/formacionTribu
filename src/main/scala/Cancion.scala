import java.text.Normalizer

object cancion extends App {

  def readFile(fileName: String): Iterator[String]= io.Source.fromFile(fileName).getLines

  val ds: Array[Array[String]] = readFile("src/main/scala/Resourses/cancion.txt")
    .map(_.split(" ")).toArray



/*

  val list = ds.flatMap(
    row => row.map(
      cell=> {
        cell.replace("?", "").
     replace("é", "e")
        .replace("á", "a")
          .replace("í", "i")
          .replace("¿", "")
          .replace("ó", "o")
          .replace("!", "")
          .replace("-", "")
          .replace("(", "")
          .replace(")", "")
          .replace(",", "")
          .replace("'", "")

      }
    )

    )
  */
val list = ds
  .flatMap(
    row => row.map(
      cell => {
        Normalizer.normalize(cell, Normalizer.Form.NFD)
          .replaceAll("[^A-Za-z0-9]", "")
          .toLowerCase
      })
  )
  .groupBy(_.map(x=>x))



  val newlist = list.foreach( numPalabras => println (numPalabras._1,(numPalabras._2.length)))

 // println(newlist)


  val max = list.maxBy(maximo => maximo._2.length)
  println(max._1,max._2.length)




}
