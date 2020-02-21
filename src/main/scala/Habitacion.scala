object Habitacion extends  App {
  val archCsv = io.Source.fromFile("src/main/Resouses/RealEstate.csv")
  for (linea <- archCsv.getLines) {
    val cols = linea.split(",")
    if (cols(3) == "4" | cols(3) == "5") print("Familiar ")
    else if (cols(3) == "3") print("Grande ")
    else if (cols(3) == "2") print("mediano ")
    else if (cols(3) == "1") print("pequeño ")
  }
}
