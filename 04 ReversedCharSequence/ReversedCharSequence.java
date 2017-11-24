public class ReversedCharSequence implements CharSequence{

    private String RevSeq;
    public ReversedCharSequence(String Seq){
	RevSeq = "";
	for(int counter = Seq.length() - 1; counter > -1; counter--){
	    RevSeq+= Seq.charAt(counter);
	}
    }
    public char charAt(int index){
	return RevSeq.charAt(index);
    }
    public int length(){
	return RevSeq.length();
    }
    public CharSequence subSequence(int start, int end){
	ReversedCharSequence SubFirst = new ReversedCharSequence(RevSeq.substring(start, end));
  String SubMiddle = "";
  for(int counter = 0; counter < SubFirst.length(); counter++){
    SubMiddle+= SubFirst.charAt(counter);
  }
  ReversedCharSequence SubFinal = new ReversedCharSequence(SubMiddle);
	return SubFinal;
    }
    public String toString(){
      String answer = "";
      for (int counter = 0; counter < RevSeq.length(); counter++){
        answer+= RevSeq.charAt(counter);
      }
      return answer;
    }
}
