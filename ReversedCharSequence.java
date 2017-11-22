public class ReversedCharSequence implements CharSequence{
    private String RevSeq;
    public ReversedCharSequence(String Seq){
	RevSeq = "";
	for(int counter = 0; counter < Seq.length(); counter++){
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
	String Sub = new ReversedCharSequence(RevSeq.substring(start, end));
	return Sub;
    }
}
	    
	
