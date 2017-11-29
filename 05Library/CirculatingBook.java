public class CirculatingBook extends LibraryBook{
  private String currentHolder, dueDate;
  public CirculatingBook(String Author, String Title, String ISBN, String callNumber){
    super(Author, Title, ISBN, callNumber);
    currentHolder = "";
    dueDate = "";
    }
    public String getcurrentHolder(){
      return currentHolder;
    }
    public String getdueDate(){
      return dueDate;
    }
    public void setcurrentHolder(String currentHolder){
      this.currentHolder = currentHolder;
    }
    public void setdueDate(String dueDate){
      this.dueDate = dueDate;
    }
    public void checkout(String patron, String due){
      currentHolder = patron;
      dueDate = due;
    }
    public void returned(){
      currentHolder = "";
      dueDate = "";
    }
    public String circulationStatus(){
      String answer = "";
      if(currentHolder.equals("") && dueDate.equals("")){
        answer+= "Book available on shelves";
      }
      else{
        answer+= "Check out by" + currentHolder + ", due " + dueDate;
      }
      return answer;
    }
    public String toString(){
     return super.toString() + ", " + currentHolder + ", " + dueDate;
    }
}
