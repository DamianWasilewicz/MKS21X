public class ReferenceBook extends LibraryBook{
  private String collection;
  public ReferenceBook(String Author, String Title, String ISBN, String callNumber, String collection){
    super(Author, Title, ISBN, callNumber);
    this.collection = collection;
  }
  public String getCollection(){
    return collection;
  }
  public void setCollection(String collection){
    this.collection = collection;
  }
  public void checkout(String patron, String due){
    System.out.println("cannot check out a reference book");
  }
  public void returned(){
    System.out.println("reference book could not have been checked out- return is impossible");
  }
  public String circulationStatus(){
    String answer = "Non-circulating reference book";
    return answer;
  }
  public String toString(){
    return super.toString() + ", " + collection;
  }
}
