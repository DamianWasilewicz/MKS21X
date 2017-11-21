public class OrderedSuperArray extends SuperArray{
  //constructor creates an empty list;
  public OrderedSuperArray(){
    super();
  }
  // creates an empty list of size startingCapacity;
  public OrderedSuperArray(int startingCapacity){
    super(startingCapacity);
  }
  // creates a list with the elemnts from array;
  public OrderedSuperArray(String[] array){
    super(array.length);
    for(int counter = 0; counter < array.length; counter++){
      add(array[counter]);
    }
  }
  // doesn't make sense in the context of the class, calls proper add;
  public void add(int index, String element){
    add(element);
  }
  // not appropriate for the class, results in error message;
  public String set(int index, String value){
    throw new UnsupportedOperationException();
  }
  //proper add; adds value into ordered spot in list;
  public boolean add(String value){
    super.add(findIndexBinary(value), value);
    return true;
  }
  // finds proper index for element in ordered list;
  private int findIndexBinary(String value){
    int first = 0;
    int last = size();
    while(size() != 0 && last != first){
      if(get(first + ((last - first)/2)).compareTo(value) < 0){
        if(last - first > 1){
          first+= ((last - first)/2);
        }
        else{
          first++;
        }
      }
      else{
        if(last - first > 1){
          last = last - ((last - first) / 2);
        }
        else {
          last--;
        }
      }
    }
    return last;
    }
    //Finds the index of the first instance of a value, using the binary method;
    //of searching also used in the previous method;
public int indexOfBinary(String value){
       	int first = 0;
        int last = size();
	while (first != last) {
	    if (get((first + last)/2).compareTo(value) > 0){
		last = (first + last) / 2;
	    }
	    else if (get((first + last)/2).equals(value)){
		if (first == 0 ||
    !(get((first + last) / 2 - 1).equals(value))){
		    return (first + last) / 2;
		}
		last = (first + last) / 2;
		first = (first + last) / 2 - 1;
	    }
	    else {
		first = (first + last) / 2 + 1;
	    }
	}
	if (get(first) != value){
	    return -1;
	}
	return first;
}
//searches for the index of the last occurence of the value;
//using the binary search method;
public int lastIndexOfBinary(String value){
	int first = indexOfBinary(value);
  int last = size();
	while (first != last){
	    if (get((first + last)/2).compareTo(value) > 0){
	 last = (first + last) / 2;
	 }
	   else if (get((first + last)/2).equals(value)){
		if (first == size() - 1 ||
    !(get((first + last) / 2 + 1).equals(value))){
		  return (first + last) / 2;
		}
		last = (first + last) / 2;
		first = (first + last) / 2 - 1;
	    }
	    else {
		first = (first + last) / 2 + 1;
	    }
	}
	if (get(first) != value){
	    return -1;
	}
	return first;
    }
  }
