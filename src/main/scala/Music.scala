object Music extends App {

  def readFile(fileName: String): Iterator[String] = io.Source.fromFile(fileName).getLines

  val ds: Array[Array[String]] = readFile("src/main/Resouses/lyrics.txt")
    .map(_.split(" "))
    .toArray


  val list = ds.flatMap(
    row => row.map(
      cell => {
        cell.replace("'", "")
          .replace(",", "")
      })
  ).groupBy(word => {
    word
  })

  list.foreach(x => println(x._1 + " tiene " + x._2.length + " repetidas"))

  println(list.maxBy(mayor => (mayor._2.length)))

  val maximo = list.maxBy(mayor => (mayor._2.length))

  println(maximo._1 + " es la palabra que mas se repite con " + maximo._2.length + " palabras")

}
