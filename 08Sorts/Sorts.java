public class Sorts{
  public static String name(){
    return "09.Wasilewicz.Damian";
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
  }
