import src.main.scala.NFCReader
import src.main.scala.eMRTDReader

object Main {
  def main(args: Array[String]): Unit = {
    // Initialize the NFC reader
    val nfcReader = new NFCReader()
    nfcReader.connect()

    // Initialize the eMRTD reader
    val emrtdReader = new eMRTDReader(nfcReader)

    // Read eMRTD data
    val emrtdData = emrtdReader.readEMRTDData()
    if (emrtdData != null) {
      println("eMRTD data read successfully:")
      println(emrtdData)
    } else {
      println("Failed to read eMRTD data.")
    }

    // Disconnect the NFC reader
    nfcReader.disconnect()
  }
}
