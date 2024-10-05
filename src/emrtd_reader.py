import pyemrtd

class eMRTDReader:
    """
    A class to handle eMRTD data reading.
    """

    def __init__(self, nfc_reader):
        self.nfc_reader = nfc_reader

    def read_emrtd_data(self):
        """
        Read and parse eMRTD data from the NFC reader.
        """
        try:
            tag = self.nfc_reader.read()
            if tag is None:
                print("No tag found.")
                return None

            emrtd_data = pyemrtd.parse(tag)
            return emrtd_data
        except Exception as e:
            print(f"Error reading eMRTD data: {e}")
            return None
