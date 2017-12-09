import java.util.*;
public class Sorts{
  public static String name(){
    return "09.Wasilewicz.Damian";
  }
  public static void swap(int[] ary, int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
  public static void selectionSort(int[] data){
    for(int counter = 0; counter < data.length; counter++){
      for(int counter1 = counter; counter1 < data.length; counter1++){
        if(data[counter] > data[counter1]){
        swap(data, counter, counter1);
        }
       }
    }
  }
 public static void insertionSort(int[] data){
    for(int counter = 0; counter < data.length - 1; counter++){
      for(int counter1 = counter; counter1 > 0; counter1--){
        if(data[counter1] < data[counter1 -1]){
        swap(data, counter1 - 1, counter1);
        }
       }
    }
  }
  public static void bubbleSort(int[] data){
    for(int counter = 0; counter < data.length; counter++){
      for(int counter1 = 0; counter1 < data.length - counter - 1; counter1++){
        if(data[counter1] > data[counter1 + 1]){
        swap(data, counter1, counter1 + 1);
        }
       }
     }
  }
  public static void main(String[]artie){
       int[] randish = new int[15];
       for(int i = 0 ; i < randish.length; i++){
           randish[i] =(int)(Math.random()*100);
       }
       System.out.println(name());
       System.out.println(Arrays.toString(randish));
       bubbleSort(randish);
       System.out.println(Arrays.toString(randish));
   }
}
