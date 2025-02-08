import org.jmrtd.PassportService
import org.jmrtd.lds.icao.MRZInfo
import javax.smartcardio._

class NFCReader {
  private var cardTerminal: CardTerminal = _
  private var card: Card = _
  private var cardChannel: CardChannel = _

  def connect(): Unit = {
    val terminalFactory = TerminalFactory.getDefault
    val terminals = terminalFactory.terminals.list
    if (terminals.isEmpty) {
      throw new Exception("No NFC terminals found")
    }
    cardTerminal = terminals.get(0)
    card = cardTerminal.connect("*")
    cardChannel = card.getBasicChannel
  }

  def connectToAndroidPhone(): Unit = {
    val terminalFactory = TerminalFactory.getDefault
    val terminals = terminalFactory.terminals.list
    if (terminals.isEmpty) {
      throw new Exception("No NFC terminals found")
    }
    cardTerminal = terminals.find(_.getName.contains("Android")).getOrElse(throw new Exception("No Android phone found"))
    card = cardTerminal.connect("*")
    cardChannel = card.getBasicChannel
    println("Connected to Android phone")
  }

  def read(): Array[Byte] = {
    val command = Array[Byte](0x00, 0xA4, 0x04, 0x0C, 0x07, 0xA0, 0x00, 0x00, 0x02, 0x47, 0x10, 0x01)
    val response = cardChannel.transmit(new CommandAPDU(command))
    if (response.getSW != 0x9000) {
      throw new Exception("Failed to read NFC tag")
    }
    response.getData
  }

  def readFromAndroidPhone(): Array[Byte] = {
    val command = Array[Byte](0x00, 0xA4, 0x04, 0x0C, 0x07, 0xA0, 0x00, 0x00, 0x02, 0x47, 0x10, 0x01)
    val response = cardChannel.transmit(new CommandAPDU(command))
    if (response.getSW != 0x9000) {
      throw new Exception("Failed to read NFC tag from Android phone")
    }
    response.getData
  }

  def disconnect(): Unit = {
    if (card != null) {
      card.disconnect(false)
    }
  }
}
