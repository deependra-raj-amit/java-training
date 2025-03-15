package com.deependra.IoAndFileHandling;

/*
Character Streams in Java are used for handling text data by reading and writing character-based files.
Unlike Byte Streams, which process raw bytes, Character Streams use Unicode encoding to properly handle
characters, making them ideal for working with text files, XML, JSON, and user input.

Key Points
-->Works with text-based data (.txt, .csv, .xml, .json).
-->Uses Unicode encoding to support multiple languages.
-->Uses Reader for input and Writer for output.
-->Efficient for handling human-readable files.
-->Includes Buffered Streams for better performance.

Common Methods
    Method	                Description
    read()	                Reads a single character (returns -1 if end of file).
    read(char[] buffer)	    Reads multiple characters into an array.
    write(int ch)	        Writes a single character.
    write(char[] buffer)	Writes an array of characters.
    flush()	                Forces data to be written immediately.
    close()	                Closes the stream to free resources.

*/



import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamHandling {
    public static void main(String[] args) {
        String statementFile = "C:\\Users\\DEEPENDRA\\Downloads\\File handling demo file.txt";

        // Writing bank statement details
        try (FileWriter fw = new FileWriter(statementFile)) {
            fw.write("Bank Statement for Account: 12345\n");
            fw.write("----------------------------------\n");
            fw.write("Date      | Transaction | Amount\n");
            fw.write("01-03-25  | Credit      | 5000\n");
            fw.write("02-03-25  | Debit       | 1500\n");
            fw.write("Balance: 3500\n");
            fw.flush();
            System.out.println("Bank Statement Generated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
