package wordfrequency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class will place the words from a text document into a hash table
 * where each key is the word and the value is the word frequency.
 * @author austinlee
 */
public class Text {
    private Hashtable<String, Words> hash = new Hashtable<>();
    private String path;
    private int wordCount = 1;
    public Text(String path) throws IOException{
        this.path = path;
        wordCount();
    }
    
    public void wordCount() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, word;
        Scanner cin;
        int counter = 1, lineNumber = 1;
        while((line = br.readLine()) != null){
            System.out.printf("Line number %d: %s\n", lineNumber, line);
            cin = new Scanner(line);
            while(cin.hasNext()){
                word = cin.next();
                Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
                Matcher match = pt.matcher(word);
                while(match.find()){
                    String s = match.group();
                    word = word.replaceAll("\\" + s, "");
                }
                if(!hash.containsKey(word)){
                    hash.put(word, new Words(1, wordCount++, lineNumber));
                } else {
                    Words temp = hash.get(word);
                    temp.incrementFrequency();
                    temp.setWordNumber(wordCount);
                    temp.setLineNumber(lineNumber);
                }
            }
            lineNumber++;
        }
        br.close();
    }
    
    public int getWordCount(){
        return this.wordCount;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Set<String> keys = hash.keySet();
        for(String key : keys){
            Words word = hash.get(key);
            sb.append(String.format("Word: %-15s Count: %-2d Line Number: %-15s WordNumber: %-15s\n", key, word.getFrequency(), arrayListString(word.getLineNumber()), arrayListString(word.getWordNumber())));
        }
        return sb.toString();
    }
    
    public String arrayListString(ArrayList<Integer> alist){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alist.size(); i++){
            if(i == 0) sb.append('[');
            else sb.append(", ");
            sb.append(alist.get(i));
        }
        sb.append(']');
        return sb.toString();
    }
    
}
