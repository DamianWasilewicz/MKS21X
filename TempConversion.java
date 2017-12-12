public class TempConversion{
  public static double CtoF(double temp){
    double answer =((temp * 9)/5) + 32;
    return answer;
  }
  public static double FtoC(double temp){
    double answer = ((temp - 32) * 5)/9;
    return answer;
  }
  public static void main(String[] args){
    System.out.println(TempConversion.CtoF(0));
    System.out.println(TempConversion.CtoF(80));
    System.out.println(TempConversion.FtoC(0));
    System.out.println(TempConversion.FtoC(85));
  }
}
