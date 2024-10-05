# pymrtd
eMRTD reader made in python

## Installation

To use this eMRTD reader, you need to install the required libraries. You can do this using `pip`:

```sh
pip install nfcpy
```

## Using a Telephone as an NFC Reader via USB Cable

To use a telephone as an NFC reader via USB cable, follow these steps:

1. Connect your telephone to your computer using a USB cable.
2. Ensure that your telephone is in NFC reader mode.
3. Run the eMRTD reader script.

## Running the eMRTD Reader

Here is an example of how to use the `NFCReader` and `eMRTDReader` classes to read eMRTD data:

```python
from src.nfc_reader import NFCReader
from src.emrtd_reader import eMRTDReader

# Initialize the NFC reader
nfc_reader = NFCReader()
nfc_reader.connect()

# Initialize the eMRTD reader
emrtd_reader = eMRTDReader(nfc_reader)

# Read eMRTD data
emrtd_data = emrtd_reader.read_emrtd_data()
if emrtd_data:
    print("eMRTD data read successfully:")
    print(emrtd_data)
else:
    print("Failed to read eMRTD data.")

# Disconnect the NFC reader
nfc_reader.disconnect()
```

## Examples of Usage

### NFCReader

The `NFCReader` class handles NFC communication via USB cable using a telephone. Here is an example of how to use it:

```python
from src.nfc_reader import NFCReader

nfc_reader = NFCReader()
nfc_reader.connect()

tag = nfc_reader.read()
if tag:
    print("Tag read successfully:")
    print(tag)
else:
    print("Failed to read tag.")

nfc_reader.disconnect()
```

### eMRTDReader

The `eMRTDReader` class handles eMRTD data reading. Here is an example of how to use it:

```python
from src.nfc_reader import NFCReader
from src.emrtd_reader import eMRTDReader

nfc_reader = NFCReader()
nfc_reader.connect()

emrtd_reader = eMRTDReader(nfc_reader)
emrtd_data = emrtd_reader.read_emrtd_data()
if emrtd_data:
    print("eMRTD data read successfully:")
    print(emrtd_data)
else:
    print("Failed to read eMRTD data.")

nfc_reader.disconnect()
```
