import java.util.*;
public class Barcode implements Comparable<Barcode>{
  //This will be the Field Variable for Barcode
  private String Zip;
  //Constructor for the class;
  public Barcode(String Zip){
    CheckIfZip(Zip);
    this.Zip = Zip;
    }
    public static void CheckIfZip(String Zip){
      try{
    Integer.parseInt(Zip);
      }
        catch(NumberFormatException e){
          throw new IllegalArgumentException();
        }
          if(Zip.length() != 5){
        throw new IllegalArgumentException();
      }
    }
    public String getCode(){
      return toCode(Zip);
    }
    public String getZip(){
      return Zip;
    }
    public String toString(){
      return this.getCode() + " " + "(" + getZip() + ")";
     }
     public int compareTo(Barcode Other){
       return getZip().compareTo(Other.getZip());
     }
     public boolean equals(Barcode Other){
       return getCode().equals(Other.getCode());
     }
    public static String convertToSymbol(char number){
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
    String answer = "|";
   CheckIfZip(Zip);
  for(int counter = 0; counter < Zip.length(); counter++){
    answer+= convertToSymbol(Zip.charAt(counter));
  }
  answer+= "" + convertToSymbol(getCheckSum(Zip)) + "|";
  return answer;
  }
  public static int getCheckSum(String Zip){
    int sum = 0;
    for(int counter = 0; counter < 5; counter++){
      sum+= Integer.parseInt(Zip.charAt(counter)+"");
    }
    return sum % 10;
  }
  public static boolean CheckSum(String code){
   return((convertToNumber(code.substring(1,6)) +
   convertToNumber(code.substring(6,11)) +
   convertToNumber(code.substring(11,16)) +
   convertToNumber(code.substring(16,21)) +
   convertToNumber(code.substring(21,26))) % 10 == convertToNumber(code.substring(26,31)));

  }
 public static boolean CodeChecker(String code){
   if(code.length() != 32 ||
   (code.charAt(0) != '|' || code.charAt(code.length()-1) != '|')){
     return false;
   }
   for(int counter = 0; counter < code.length(); counter++){
     if(code.charAt(counter) != ':' && code.charAt(counter) != '|'){
       return false;
     }
   }
   CheckSum(code);
   return true;
 }
 public static String toZip(String code){
        CodeChecker(code);
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
