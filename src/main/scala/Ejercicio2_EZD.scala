object Ejercicio2_EZD extends App {
  val col = io.Source.fromFile("src/main/resource/Realestate.csv")
    .getLines()
    .map(_.split(",")(3))
    .filter(_.matches("[0-9]"))
    .map(x =>{
      if(x.equals("1")){
        "chico"
      }else if(x.equals("2")){
        "mediano"
      }else if(x.equals("3")){
        "grande"
      }else if(x.equals("4")){
        "familiar"
      }else{
        x
      }
    })

  println(col.toList)
}



