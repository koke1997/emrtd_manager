# emrtd_manager
eMRTD reader made in Scala

## Installation

To use this eMRTD reader, you need to install the required libraries. You can do this using `sbt`:

Add the following dependency to your `build.sbt` file:

```scala
libraryDependencies += "org.jmrtd" % "jmrtd" % "0.7.31"
```

## Using a Telephone as an NFC Reader via USB Cable

To use a telephone as an NFC reader via USB cable, follow these steps:

1. Connect your telephone to your computer using a USB cable.
2. Ensure that your telephone is in NFC reader mode.
3. Run the eMRTD reader script.

## Running the eMRTD Reader

Here is an example of how to use the `NFCReader` and `eMRTDReader` classes to read eMRTD data:

```scala
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
```

## Examples of Usage

### NFCReader

The `NFCReader` class handles NFC communication via USB cable using a telephone. Here is an example of how to use it:

```scala
import src.main.scala.NFCReader

object Main {
  def main(args: Array[String]): Unit = {
    val nfcReader = new NFCReader()
    nfcReader.connect()

    val tag = nfcReader.read()
    if (tag != null) {
      println("Tag read successfully:")
      println(tag)
    } else {
      println("Failed to read tag.")
    }

    nfcReader.disconnect()
  }
}
```

### eMRTDReader

The `eMRTDReader` class handles eMRTD data reading. Here is an example of how to use it:

```scala
import src.main.scala.NFCReader
import src.main.scala.eMRTDReader

object Main {
  def main(args: Array[String]): Unit = {
    val nfcReader = new NFCReader()
    nfcReader.connect()

    val emrtdReader = new eMRTDReader(nfcReader)
    val emrtdData = emrtdReader.readEMRTDData()
    if (emrtdData != null) {
      println("eMRTD data read successfully:")
      println(emrtdData)
    } else {
      println("Failed to read eMRTD data.")
    }

    nfcReader.disconnect()
  }
}
```
