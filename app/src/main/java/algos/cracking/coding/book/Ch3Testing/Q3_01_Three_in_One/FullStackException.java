package algos.cracking.coding.book.Ch3Testing.Q3_01_Three_in_One;

public class FullStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}
