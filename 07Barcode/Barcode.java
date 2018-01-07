import java.util.*;
public class Barcode implements Comparable<Barcode>{
  public static void main(String[] args){
    String[]badBarcodes = {"|||:::||:::||:::||:::||:::||:::",
      "|||:::||:::||:::||:::||:::||:::||||",
      "|||:::||:::||:::||:::||:::||::::",
      ":||:::||:::||:::||:::||:::||:::|",
      "||:|::||z::|:|::||::f:::|||:|::|",
      "|:::||||:::a::||||::::::||::||:|",
      "|||:::||:::||:::||:::||::::::|||"    };
  Barcode test = new Barcode("084518");
   Barcode.toZip(badBarcodes[6]);
}
  //This will be the Field Variable for Barcode,
  //taking in the Zip number as a String
  private String Zip;
  //Constructor for the class;
  public Barcode(String Zip){
    //calls function that checks if Zip is in correct form
    CheckIfZip(Zip);
    //sets field method to parameter
    this.Zip = Zip;
    }
    public static void CheckIfZip(String Zip){
      try{
        //checks to see if everything within Zip is a number;
    Integer.parseInt(Zip);
      }
        catch(NumberFormatException e){
          throw new IllegalArgumentException();
        }
        //verifies the length of the input Zip
          if(Zip.length() != 5){
        throw new IllegalArgumentException();
      }
    }
    public String getCode(){
      // returns code of a barcode
      return toCode(Zip);
    }
    public String getZip(){
      //returns Zip of barcode
      return Zip;
    }
    public String toString(){
      //prints barcode in form "code(with checksum code)" + "zip"
      return this.getCode() + " " + "(" + getZip() + ")";
     }
     public int compareTo(Barcode Other){
       //compares two barcodes and returns a negative number if smaller,
       //positive if greater, and zero if equal
       return getZip().compareTo(Other.getZip());
     }
     public boolean equals(Barcode Other){
       //checks to see if two codes are equal
       return getCode().equals(Other.getCode());
     }
    public static String convertToSymbol(char number){
      //converts number char into equivalent symbol
      String[] database = new String[10];
      database[0] = "||:::";
      database[1] = ":::||";
      database[2] = "::|:|";
      database[3] = "::||:";
      database[4] = ":|::|";
      database[5] = ":|:|:";
      database[6] = ":||::";
      database[7] = "|:::|";
      database[8] = "|::|:";
      database[9] = "|:|::";
      int newnumber = number - 48;
      return database[newnumber];
    }
    public static String convertToSymbol(int number){
      //converts int number into symbol
      String[] database = new String[10];
      database[0] = "||:::";
      database[1] = ":::||";
      database[2] = "::|:|";
      database[3] = "::||:";
      database[4] = ":|::|";
      database[5] = ":|:|:";
      database[6] = ":||::";
      database[7] = "|:::|";
      database[8] = "|::|:";
      database[9] = "|:|::";
      return database[number];
    }
    public static int convertToNumber(String Symbol){
      //converts symbol into number form
      if(Symbol.equals("||:::")){
        return 0;
      }if(Symbol.equals(":::||")){
        return 1;
      }if(Symbol.equals("::|:|")){
        return 2;
      }if(Symbol.equals("::||:")){
        return 3;
      }if(Symbol.equals(":|::|")){
        return 4;
      }if(Symbol.equals(":|:|:")){
        return 5;
      }if(Symbol.equals(":||::")){
        return 6;
      }if(Symbol.equals("|:::|")){
        return 7;
      }if(Symbol.equals("|::|:")){
        return 8;
      }if(Symbol.equals("|:|::")){
        return 9;
      }
      throw new IllegalArgumentException();
    }
  public static String toCode(String Zip){
    //takes entire zip string and returns equivalent code,
    //including symbol of checksum
    String answer = "|";
   CheckIfZip(Zip);
  for(int counter = 0; counter < Zip.length(); counter++){
    answer+= convertToSymbol(Zip.charAt(counter));
  }
  answer+= "" + convertToSymbol(getCheckSum(Zip)) + "|";
  return answer;
  }
  public static int getCheckSum(String Zip){
    //returns checksum numerical value;
    int sum = 0;
    for(int counter = 0; counter < 5; counter++){
      sum+= Integer.parseInt(Zip.charAt(counter)+"");
    }
    return sum % 10;
  }
  public static boolean CheckSum(String code){
    //verifies that checksum of a code is correct;
   return((convertToNumber(code.substring(1,6)) +
   convertToNumber(code.substring(6,11)) +
   convertToNumber(code.substring(11,16)) +
   convertToNumber(code.substring(16,21)) +
   convertToNumber(code.substring(21,26))) % 10 == convertToNumber(code.substring(26,31)));

  }
  public static boolean checkInput(String code){
    if(code.length() != 32){
      return false;
    }
    if(code.charAt(0) != '|' ||
    code.charAt(code.length()-1) != '|'){
      return false;
    }
    return true;
  }
 public static boolean CodeChecker(String code){
   //verifies to see that inputted code is in correct format
   for(int counter = 0; counter < code.length(); counter++){
     if(code.charAt(counter) != ':' && code.charAt(counter) != '|'){
       return false;
     }
   }
   return true;
 }
 public static String toZip(String code){
   //returns Zip version of inputted code;
          if (!CodeChecker(code)){
            throw new IllegalArgumentException();
          }
          if (!checkInput(code)){
            throw new IllegalArgumentException();
          }
          if (!CheckSum(code)){
            throw new IllegalArgumentException();
          }
        String answer = "";
        answer+=
        convertToNumber(code.substring(1,6)) + "" +
        convertToNumber(code.substring(6,11)) + "" +
        convertToNumber(code.substring(11,16)) + "" +
        convertToNumber(code.substring(16,21)) + "" +
        convertToNumber(code.substring(21,26));
            return answer;
          }
}
