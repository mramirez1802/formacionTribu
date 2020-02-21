object Jueves extends App {
  var col = io.Source.fromFile("src/main/resource/cancion.txt")
    .getLines()
    .flatMap(_.split("[\\s*]")
      .map(_.replaceAll("(?i)[^a-zá|é|í|ó|ú\\s]","")))
    .toList
    .groupBy(word => word)
    .mapValues(_.size)
    .toSeq
    .sortBy(_._2)
    .reverse

  println(col(0))
  println(col)


}