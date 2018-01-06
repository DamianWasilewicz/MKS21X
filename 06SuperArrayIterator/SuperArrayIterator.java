import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  //int used for keeping track of what iterator is up to in array;
  private int current;
  //SuperArray being fed into iterator;
  private SuperArray ITarray;
  //creates Iterator;
  // constructs new iterator (SuperArrayIterator);
  public SuperArrayIterator(SuperArray array){
   ITarray = array;
  }
  //returns next item in array, exits if there is no next value;
  public String next(){
    if(!hasNext()){
     System.exit(0);
    }
    return ITarray.get(current++);
  }
  //checks to see if there is more to iterate through;
  public boolean hasNext(){
    return current < ITarray.size();
  }
  //unsupported operation, returns exception;
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
