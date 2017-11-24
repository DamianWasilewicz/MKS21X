public class Driver{
  public static void main (String[] args){
    ReversedCharSequence Test = new ReversedCharSequence("Oh Hello There");
    System.out.println(Test);
    System.out.println(Test.length());
    System.out.println(Test.charAt(4));
    System.out.println(Test.subSequence(0, 4));
  }
}
