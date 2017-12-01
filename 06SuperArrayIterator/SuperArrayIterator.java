import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  int current;
  SuperArray array;
  public SuperArrayIterator(SuperArray array){
    this.array = array;
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
    return array.get(current - 1);
  }
  public boolean hasNext(){
    return current <= array.size();
  }
}
