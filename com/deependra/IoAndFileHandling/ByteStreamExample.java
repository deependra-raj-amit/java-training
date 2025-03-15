package com.deependra.IoAndFileHandling;

/*
Byte Streams in Java are used to perform input and output operations on binary data such as images, audio
files, and PDFs. They read/write data in the form of bytes (8-bit units) and are part of the java.io package.

Key Points
-->Handles binary files (images, videos, audio, PDFs).
-->Operates at byte level (not character level).
-->Uses InputStream for reading and OutputStream for writing.
-->Can be buffered for better performance.
-->Does not handle character encoding, making it ideal for raw data.

Common Methods
    Method	            Description
    read()	            Reads a single byte (returns -1 if end of file).
    read(byte[] b)	    Reads multiple bytes into an array.
    write(int b)	    Writes a single byte.
    write(byte[] b)	    Writes an array of bytes.
    close()	            Closes the stream to free resources.
*/

import java.io.FileInputStream;
import java.io.IOException;

/*When a user inserts an ATM card, the banking system reads the encrypted card data (binary format) from the
chip or magnetic strip. Byte Streams are used to process this data efficiently.*/

public class ByteStreamExample {
    public static void main(String[] args) {
        String atmCardDataFile = "bank_server/atm_card_data.bin";

        // Reading encrypted ATM card data
        try (FileInputStream fis = new FileInputStream(atmCardDataFile)) {
            byte[] buffer = new byte[16]; // Reading 16 bytes at a time (typical card block size)
            int bytesRead;

            System.out.print("🔍 ATM Card Data Read (Hex): ");
            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.printf("%02X ", buffer[i]); // Display in hexadecimal format
                }
            }
            System.out.println("\n✅ ATM Card Authentication Successful!");
        } catch (IOException e) {
            System.err.println("❌ Error reading ATM Card Data: " + e.getMessage());
        }
    }
}
