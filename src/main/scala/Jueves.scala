import java.text.Normalizer


object Jueves extends App {


  def readFile(fileName: String): Iterator[String] = io.Source.fromFile(fileName).getLines

  val ds: Array[Array[String]] = readFile("/home/genzo/out.txt")
    .map(_.split(" "))
    .toArray
  /*
    val list = ds.flatMap(row => {
      row.map(cell => {
        cell.toInt * 2
      })
    })*/


  ds
    .flatMap(
      row => row.map(
        cell => {
          Normalizer.normalize(cell, Normalizer.Form.NFD)
            .replaceAll("[^A-Za-z0-9]", "")
            .toLowerCase
        })
    )
    .groupBy(_.length)
    .map(
      tuple => {
        (tuple._1, tuple._2.length)
      }
    )

  println(
    ds
      .flatMap(
        row => row.map(
          cell => {
            Normalizer.normalize(cell, Normalizer.Form.NFD)
              .replaceAll("[^A-Za-z0-9]", "")
              .toLowerCase
          })
      )
      .groupBy(word => {
        word
      })
      .map(
        tuple => {
          (tuple._1, tuple._2.length)
        }
      ).filter(
      _._1.length > 3
    ).maxBy(_._2)
  )

    ds
      .flatMap(
        row => row.map(
          cell => {
            (
              Normalizer.normalize(cell, Normalizer.Form.NFD)
                .replaceAll("[^A-Za-z0-9]", "")
                .toLowerCase, 1
            )
          })
      )
      .groupBy(_._1)
      .map(
        kv => (
          kv._1, kv._2.map(_._2).reduce(_ + _)
        )
      )
      .filter(
        _._1.length > 3
      ).toSeq
      .sortBy(_._2)
    .foreach(println(_))


}