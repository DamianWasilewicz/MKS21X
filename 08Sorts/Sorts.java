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
        int where = 0;
        for(int counter = 0; counter<data.length; counter++){
          int min = data[counter];
          for(int counter1 = counter; counter1<data.length; counter1++){
            if (data[counter1] < min){
              min = data[counter1];
              where = counter1;
            }
            data[where] = data[counter];
            data[counter] = min;
          }
        }
      }
  public static void insertionSort(int[] data){
  for(int counter = 0; counter<data.length - 1; counter++){
    for(int counter1 = counter + 1; counter1 > 0; counter1--){
      if(data[counter1] < data[counter1 -1]){
        swap(data, counter1 - 1, counter1);
      }
    }
  }
      }
    }
