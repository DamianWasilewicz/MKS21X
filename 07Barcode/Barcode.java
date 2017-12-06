import java.util.*;
public class Barcode implements Comparable<Barcode>{
  //This will be the Field Varivable for Barcode
  private String Zip;
  //Constructor for the class;
  public Barcode(String Zip){
    IsZip(Zip);
    this.Zip = Zip;
    }
    public static void IsZip(String Zip){
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
    public static String Convert(char number){
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
  public static String toCode(String Zip){
    String answer = "|";
    int check = 0;
    char Char = 0;
    IsZip(Zip);
  for(int counter = 0; counter < Zip.length(); counter++){
    Char = Zip.charAt(counter);
    answer = answer + Convert(Char);
    check+= Char - 48;
  }
  answer+= "" + Convert((char)(check % 10 + 48)) + "|";
  return answer;
  }
  public static int calculateVal(String code){
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
    for(int counter = 0; counter < database.length; counter++){
      if(database[counter].equals(code)){
        return counter;
      }
    }
    return -1;
  }
 public static String toZip(String code){
      if(code.length() != 32 ||
      (code.charAt(0) != '|' || code.charAt(code.length()-1) != '|')){
        throw new IllegalArgumentException();
      }
      for(int counter = 0; counter < code.length(); counter++){
        if(code.charAt(counter) != ':' && code.charAt(counter) != '|'){
          throw new IllegalArgumentException();
        }
        }
        int num = 0;
        String CodeBit = "";
        String newBarcode = code.substring(1, code.length()-1);
        String answer = "";
        int val = 0;
        for(int counter = 1; counter < 6; counter++){
          CodeBit = code.substring(counter * 5, counter * 5 + 5);
          val = calculateVal(CodeBit);
              answer += "" + val;
              num += val;
              val = 0;
            }
            return answer;
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
   public boolean Equals(Barcode Other){
     return getCode().equals(Other.getCode());
   }

}
