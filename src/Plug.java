
/**
 * <p>
 * Class that implements a plug from the plugboard
 */
public class Plug {
	
	private char firstLetter;
	private char secondLetter;
	
	/** 
	 *  <p>
	 * Default constructor
	 *  </p> 
	 */
	public Plug() {}
	
	/** 
	 *  <p>
	 * Constructor. Creates a new object of type Plugs
	 *  </p> 
	 * @param firstLetter		the first letter of a plug
	 * @param secondLetter		the second letter of a plug
	 */
	public Plug(char firstLetter, char secondLetter) {
		this.firstLetter = firstLetter;
		this.secondLetter = secondLetter;
	}
	
	/** 
	 *  <p>
	 * Checks if an input letter is equal with the first or the second letter of a plug
	 *  </p> 
	 * @param letter		a letter
	 */
	public char plugFinder(char letter) {
		if (letter == firstLetter) {
			letter = secondLetter;
		}
		else if (letter == secondLetter) {
			letter = firstLetter;
		}
		return letter;
	}
}
