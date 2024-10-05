import nfc
import nfc.clf

class NFCReader:
    """
    A class to handle NFC communication via USB cable using a telephone.
    """

    def __init__(self):
        self.clf = None

    def connect(self):
        """
        Connect to the NFC reader.
        """
        try:
            self.clf = nfc.ContactlessFrontend('usb')
        except Exception as e:
            print(f"Error connecting to NFC reader: {e}")
            self.clf = None

    def read(self):
        """
        Read data from the NFC reader.
        """
        if self.clf is None:
            print("NFC reader is not connected.")
            return None

        try:
            tag = self.clf.connect(rdwr={'on-connect': lambda tag: False})
            return tag
        except Exception as e:
            print(f"Error reading from NFC reader: {e}")
            return None

    def disconnect(self):
        """
        Disconnect from the NFC reader.
        """
        if self.clf is not None:
            self.clf.close()
            self.clf = None
