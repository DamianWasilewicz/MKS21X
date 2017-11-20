import java.util.*; //imports ArrayList, Random,
import java.io.*;//imports File and FileNotFoundException

public class WordSearch{
  private char[][] data; //2D array used in WordSearch
  private int rows;
  private int cols;
  private ArrayList<String> wordsToAdd = new ArrayList<String>();
  private ArrayList<String> wordsAdded = new ArrayList<String>();
  private Random randgen;
  private static boolean key;
  private static int seed;
  static String WhatToDo = "Your input must be in the format : java WordSearch [rows columns filename [seed [Key]]] \n If you wish to view the answer key, enter the seed and 'Key'. If you don't, leave them empty.";
  public static void main(String[] args) { //main function, allows for user interaction and instructs user on how to use class;
if (args.length < 3) {
    System.out.println(WhatToDo);
}
else {
    int rows = 0;
    int cols = 0;
    seed = (int)(Math.random()*100000);
    try {
  rows = Integer.valueOf(args[0]);
  cols = Integer.valueOf(args[1]);
    } catch (IllegalArgumentException e) {
  System.out.println(WhatToDo);
  System.exit(0);
    }
    String fileName = args[2];
    key = false;
    if (args.length >= 4) {
  try {
      seed = Integer.valueOf(args[3]);
  } catch (IllegalArgumentException e) {
      System.out.println(WhatToDo);
      System.exit(0);
  }
    }
    if (args.length == 5 && args[4].equals("key")) {
        key = true;
    }
    WordSearch wordsearch = new WordSearch(rows, cols, fileName, seed, key);
    System.out.println(wordsearch);
    wordsearch.printWordList();
}
  }
//creates a WordSearch based on the 3 mandatory and 2 optional arguments the user puts in;
//if last two are left out, seed is random and key is not displayed;
  public WordSearch(int rows, int cols, String filename, int randseed, boolean key){
    data = new char[rows][cols];
    this.rows = rows;
    this.cols = cols;
    this.seed = randseed;
    this.key = key;
    clear();
    wordsToAdd = new ArrayList<String>();
    randgen = new Random(seed);
    try{
        Scanner in = new Scanner(new File(filename));
        while(in.hasNext()){
        String upperWord = in.next().toUpperCase();
        wordsToAdd.add(upperWord);
      }
    }
    catch (FileNotFoundException e){
      	    System.out.println("File not found: " + filename);
            System.exit(1);
  	}
    if(key){
      clear();
      addAllWords();
    }
    else{
      addAllWords();
      fillRest();
    }
  }
  //toString function prints WordSearch;
  public String toString() {
  String answer = "\n";
  for (int counter = 0; counter < data.length; counter++) {
    for (int counter2 = 0; counter2 < data[counter].length; counter2++) {
  answer += data[counter][counter2] + " ";
    }
    answer += "\n";
  }
  answer += "\nThe seed you used was " + seed + ".\n";
  return answer;
  }
  //fills the remainder of the wordsearch with random letters, making the puzzle a puzze;
  private boolean fillRest(){
  String OtherChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for(int counter = 0; counter < rows; counter++){
    for(int counter2 = 0; counter2 < cols; counter2++){
      if(data[counter][counter2] == '_'){
        data[counter][counter2] = OtherChars.charAt(randgen.nextInt(OtherChars.length()));
      }
    }
  }
  return true;
}
//prints the list of words used in the wordpuzzle;
  public void printWordList() {
System.out.println(wordsAdded + "\n");
  }
  //clears the wordsearch;
  private void clear(){
    for(int counter = 0; counter < data.length; counter++){
      for(int counter2 = 0; counter2 < data[0].length; counter2++){
        data[counter][counter2] = '_';
      }
    }
  }
  //adds word at starting sport row col, direction determined by increments;
  private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
      if((rowIncrement == 0) && (colIncrement == 0)){
        return false;
      }
      try{
        int r = row;
        int c = col;
       for(int counter = 0; counter < word.length(); counter++){
         if(((data[r][c] != word.charAt(counter)) &&
         (data[r][c] != '_'))){
           return false;
         }
         if(word.charAt(counter) < 10){
           return false;
         }
         r+= rowIncrement;
         c+= colIncrement;
       }
       r = row;
       c = col;
       for(int counter = 0; counter < word.length(); counter++){
           data[r][c] = word.charAt(counter);
           r+= rowIncrement;
           c+= colIncrement;
       }
      return true;
    }
    catch(IndexOutOfBoundsException x){
         return false;
       }
     }
     //called in the constructor for the class, adds all the words from the file that it can into the puzzle;
     private boolean addAllWords(){
       for (int c = 0; c < wordsToAdd.size(); c++) {
     	    String word = wordsToAdd.get(c);
     	    boolean pause = false;
     	    int counter = 0, randomRows, randomCols, randomRInc, randomCInc;
     	    while (!pause && counter <= 300) {
     		randomRows = randgen.nextInt(rows);
     		randomCols = randgen.nextInt(cols);
     		randomCInc = randgen.nextInt(3) - 1;
     		randomRInc = randgen.nextInt(3) - 1;
     		if (addWord(randomRows, randomCols, word, randomRInc, randomCInc)) {
     		    wordsToAdd.remove(c);
     		    wordsAdded.add(word);
     		    pause = true;
     		    c -= 1;
     		}
     		counter += 1;
     	    }
     	  }
       return true;
     }
   }
