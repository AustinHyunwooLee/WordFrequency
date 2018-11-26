package wordfrequency;

import java.util.ArrayList;

/**
 * Data structure for storing the word frequency and a list of the word number
 * and line number that the word appear.
 * @author austinlee
 */
public class Words {

    private int frequency;
    private ArrayList<Integer> wordNumber = new ArrayList<>();
    private ArrayList<Integer> lineNumber = new ArrayList<>();
    
    public Words(int frequency, int wordNumber, int lineNumber){
        this.frequency = frequency;
        this.wordNumber.add(wordNumber);
        this.lineNumber.add(lineNumber);
    }
    
    public void setWordNumber(int wordNumber){
        this.wordNumber.add(wordNumber);
    }
    
    public void setLineNumber(int lineNumber){
        this.lineNumber.add(lineNumber);
    }    
    
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }
        
    public void incrementFrequency(){
        this.frequency++;
    }

    public void decrementFrequency(){
        this.frequency--;
    }
    
    public ArrayList<Integer> getWordNumber(){
        return this.wordNumber;
    }
    
    public ArrayList<Integer> getLineNumber(){
        return this.lineNumber;
    }
    
    public int getFrequency(){
        return this.frequency;
    }
    
}
