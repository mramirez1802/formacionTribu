import java.text.Normalizer

object flatMap extends App {
val filename="resources/file.txt"

  def readFile(): Map[String, Int] ={
    val counter = scala.io.Source.fromFile(filename)
      .getLines
      .flatMap(_.split("\\W"))
      .foldLeft(Map.empty[String, Int]){
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }
    return counter
  }

  def printContent(counter : Map[String, Int]): Unit = {
    for ((k,v) <- counter) printf("%s : %d\n", k, v)
  }

    val archivo = flatMap.readFile()
    flatMap.printContent(archivo)

}
