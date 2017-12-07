import java.util.*;
public class Driver{
  public static void main(String[] args){
    int[] test = new int[15];
    for(int i = 0 ; i < test.length; i++){
            test[i] =(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(test));
        Sorts.selectionSort(test);
        System.out.println(Arrays.toString(test));
  }
}
