import java.util.ArrayList;

/**
 * <p>
 * Class that implements the Plugboard of the Enigma machine
 */
public class Plugboard implements Cryptography {
	
	private ArrayList<Plug> plugs;
	private Alphabet inputAlphabet;

	/** 
	 *  <p>
	 * Constructor. Creates a new object of type Plugboard.
	 *  </p> 
	 * @param inputAlphabet		the alphabet of the Enigma machine
	 */
	public Plugboard(Alphabet inputAlphabet) {
		this.inputAlphabet = inputAlphabet;
		plugs = new ArrayList<Plug>();
	}
	
	/** 
	 *  <p>
	 * Adds a plug in the Plugboard
	 *  </p> 
	 * @param firstLetter		the first letter of the plug
	 * @param secondLetter		the second letter of the plug
	 */
	public void addPlug(char firstLetter, char secondLetter) {
		Plug object = new Plug(firstLetter, secondLetter);   
		plugs.add(object);							
	}
	
	/** 
	 *  <p>
	 * Converts a letter passing through the plugboard.
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char convertLetter(char letter) {
		if (plugs.isEmpty()) {
			return letter;
		}						
		if (!inputAlphabet.checkLetter(letter))
			return (char) -1;	
		char newLetter = letter;	
		for (int i = 0; i < plugs.size(); ++i) { 										
			newLetter = plugs.get(i).plugFinder(letter);
			if (newLetter != letter) 
				break;
		}
		if (!inputAlphabet.checkLetter(newLetter))
			return (char) -1;
		return newLetter;		
	}

	/** 
	 *  <p>
	 * Converts back a letter passing through the plugboard.
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char revertLetter(char letter) {
		char newLetter = convertLetter(letter);
		return newLetter;
	}
}
