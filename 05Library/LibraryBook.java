public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String Author, String Title, String ISBN, String callNumber){
	super(Author, Title, ISBN);
	this.callNumber = callNumber;
    }
    public String getcallNumber(){
	return callNumber;
    }
    public void setcallNumber(String callNumber){
	this.callNumber = callNumber;
    }
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    public int compareTo(LibraryBook other){
	return this.getcallNumber().compareTo(other.getcallNumber());
    }
    public String toString(){
	return super.toString() + ", " + callNumber + ", " + circulationStatus();
    }
}
