import java.util.*;
public class Sorts{
  //returns name in format class.lastname.firstname;
  public static String name(){
    return "09.Wasilewicz.Damian";
  }
  //basic method used to swap two values in an array;
  public static void swap(int[] ary, int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
  //sort that works by going through data and finding the subsequently smallest value and swapping it
  //towards the front of the array;
  public static void selectionSort(int[] data){
    for(int counter = 0; counter < data.length; counter++){
      for(int counter1 = counter; counter1 < data.length; counter1++){
        if(data[counter] > data[counter1]){
        swap(data, counter, counter1);
        }
       }
    }
  }
  //sort that goes through array and swaps every out of place data element back into it's proper place;
 public static void insertionSort(int[] data){
    for(int counter = 0; counter < data.length; counter++){
      for(int counter1 = counter; counter1 > 0; counter1--){
        if(data[counter1] < data[counter1 -1]){
        swap(data, counter1 - 1, counter1);
        }
       }
    }
  }
  //sort that compares every two consecutive data elements and swaps them if necessary, leading the largest value to the end,
  //stopping one more short of the end of the array every loop;
  public static void bubbleSort(int[] data){
    for(int counter = 0; counter < data.length; counter++){
      for(int counter1 = 0; counter1 < data.length - counter - 1; counter1++){
        if(data[counter1] > data[counter1 + 1]){
        swap(data, counter1, counter1 + 1);
        }
       }
     }
  }
  //used for testing;
  public static void main(String[]artie){
       int[] randish = new int[15];
       for(int i = 0 ; i < randish.length; i++){
           randish[i] = 15;
       }
       System.out.println(name());
       System.out.println(Arrays.toString(randish));
       selectionSort(randish);
       System.out.println(Arrays.toString(randish));
   }
}
