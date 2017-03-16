
/**
 * <p>
 * Class that implements the alphabet for the Enigma machine
 * </p>
 */
public class Alphabet {
	
	private char[] inputAlphabet;
	
	/**
	 * <p>
	 * Constructor. Creates a new object of type Alphabet
	 *  </p>   
	 */
	public Alphabet(String inputAlphabet) {
		this.inputAlphabet = inputAlphabet.toCharArray();
	}
		
	/** 
	 *  <p>
	 * Checks if a letter is contained by the alphabet
	 *  </p> 
	 * @param letter		a letter
	 * @return	Returns true if the letter is in the alphabet, and false otherwise
	 */
	public boolean checkLetter(char letter) {
		for (int i = 0; i < inputAlphabet.length; ++i) {
			if (letter == inputAlphabet[i]) 
				return true;	
		}
		return false;
	}
}
