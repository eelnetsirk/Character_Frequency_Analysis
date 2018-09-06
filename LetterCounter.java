//HW1 Letter Counter
//@author Kristen Lee
//@date August 29, 2018
import java.util.*;

public class LetterCounter{
  public static int[] letter_counter;
  //declaring an array literal of the alphabets
  static char[] characters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  public int total_count = 0;
  public static void main(String[] args) {
    LetterCounter lc = new LetterCounter();
    String i = "olive is a puggly pug that has no shame. however, she is incredibly cute so frankly she gets away with whatever she likes. @https !she is currently under the working desk at the math study lounge, her eyes are * looking & much better.";
    lc.countLetter(i);
    System.out.println(lc.toString());
    System.out.println(lc.getTotalCount());
  }
  /**
  *Constructor to create letter counter object
  *@since 1.0
  **/
  public LetterCounter(){
    this.letter_counter = new int[26];//keeps track of letter frequency
  }
  /**
  *takes string input as argument and updates letter count
  *@param String input
  **/
  void countLetter(String input){
    for(char c: input.toCharArray()){
      if(this.isLowerCase(c)){
        this.letter_counter[c-97] ++;
        this.total_count ++;
      }
      else if(this.isUpperCase(c)){
        this.letter_counter[c-65] ++;
        this.total_count ++;
      }
    }
  }
  /**
  *returns the total count of valid characters in the string passed
  *@return int of total count
  */
  int getTotalCount(){
    return this.total_count;
  }
  /**
  *resets all letter counts back to zero
  */
  void reset(){
    for(int i = 0; i < 26; i++){

    }
  }
  /**
  *Determines if a character is lowercase and returns a boolean
  *@param character c
  *@return true if c is lowercase and false if c is otherwise
  **/
  boolean isLowerCase(char c){
    if (97 <= (int)c && (int)c <= (97+26)) return true;
    else return false;
  }
  /**
  *Determines if a character is uppercase and returns a boolean
  *@param character c
  *@return true if c is lowercase and false if c is otherwise
  */
  boolean isUpperCase(char c){
    if (65 <= (int)c && (int)c <= 90) return true;
    else return false;
  }
  /*
  *Prints histogram with max 60# to represent the letter frequencies
  *@returns builder
  */
  public String toString(){
    int total = 0;
    int max = 0;
    for(int i = 0; i < 26; i++){
      total += letter_counter[i];
      if(letter_counter[i] > max) max = letter_counter[i];
    }
    int increment_unit = 60/max;
    //builds string builder for printing, to be returned
    String builder = "";
    for(int i = 0; i < letter_counter.length; i++){
      builder += characters[i];
      builder += ": ";
      builder += letter_counter[i];
      int tags_to_print = letter_counter[i] * increment_unit;
      for (int j = 0; j < tags_to_print; j++){
        builder += "#";
      }
      builder += "\n";
    }
    return builder;
  }
}
