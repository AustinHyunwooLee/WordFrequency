package wordfrequency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/**
 * This program will count the word frequency from a text document.  Displays
 * the total word count as well as the word number and line number each word
 * appear on.
 * @author austinlee
 * 11/24/18
 */
public class WordFrequency {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args[0] == null){
            System.out.println("Invalid argument.");
            System.exit(1);
        }
        Text test = new Text(args[0]);
        System.out.println(test.toString());
        System.out.printf("Word count: %d\n", test.getWordCount());
    }
}
