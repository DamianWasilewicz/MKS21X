import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  int current;
  String[] data;
  public SuperArrayIterator(String[] data){
    this.data = data;
    int current = 0;
  }
  public void remove(){
    throw new UnsupportedOperationException();
  }
  public String next(){
    if(hasNext()){
      current++;
    }else{
      System.exit(0);
    }
    return data[current - 1];
  }
  public boolean hasNext(){
    return current <= data.length;
  }
}
