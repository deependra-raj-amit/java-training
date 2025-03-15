package com.deependra.IoAndFileHandling;

/*
A Buffered Stream is a wrapper around another stream (Byte Stream or Character Stream) that uses an
internal buffer to store data before reading or writing. This improves performance by reducing the number
of direct I/O operations.

Why Use Buffered Streams?
-->Faster I/O Operations – Reads/writes large chunks instead of byte-by-byte or character-by-character.
-->Reduces System Load – Minimizes direct interaction with disk/network.
-->Efficient Data Transfer – Suitable for large files or network communication.
-->Enhances Performance – Works well in applications requiring fast data handling.

Key Buffered Stream Classes and Methods
    Class	                Type	            Description
    BufferedInputStream	    Byte Stream	        Improves performance of reading bytes from an input stream.
    BufferedOutputStream	Byte Stream	        Buffers data before writing bytes to an output stream.
    BufferedReader	        Character Stream	Reads text efficiently using a buffer.
    BufferedWriter	        Character Stream	Writes text efficiently using a buffer.

Common Methods:
    Method	                            Description
    read()	                            Reads one byte/character at a time.
    read(byte[] b, int off, int len)	Reads multiple bytes/characters into an array.
    write(int b)	                    Writes a single byte/character.
    write(byte[] b, int off, int len)	Writes multiple bytes/characters from an array.
    flush()	                            Forces writing of buffered data to output.
    close()	                            Closes the stream and releases resources.

*/

import java.io.*;
import java.util.Base64;

/*Banks encrypt transaction records before storing them in a file for security reasons.
Since encryption adds extra processing time, we use Buffered Streams to enhance performance by reducing
frequent I/O operations.*/

public class BufferStreamExample {
    public static void main(String[] args) {
        String transactionFile = "C:\\Users\\DEEPENDRA\\Downloads\\File handling demo file.txt";
        String transactionData = "TXN789456 | Account: 987654321 | Amount: $5000 | Status: Successful";

        // Encrypt transaction data
        String encryptedData = Base64.getEncoder().encodeToString(transactionData.getBytes());

        // Writing encrypted transaction using BufferedOutputStream
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(transactionFile))) {
            bos.write(encryptedData.getBytes());
            bos.flush();  // Ensures immediate writing of buffered data
            System.out.println("Secure transaction saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading and decrypting the transaction using BufferedInputStream
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(transactionFile))) {
            byte[] data = bis.readAllBytes();
            String decryptedData = new String(Base64.getDecoder().decode(data));
            System.out.println("\nDecrypted Transaction Details:\n" + decryptedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
