
/**
 * <p>
 * Class that implements the Enigma machine
 * </p>
 */
public class Enigma implements Cryptography {
	
	private Plugboard plugboard;
	private Reflector reflector;
	private Alphabet inputAlphabet;
	private CollectionOfRotors rotors;
	
	/** 
	 *  <p>
	 * Constructor. Creates a new object of type Enigma.
	 *  </p> 
	 * @param inputAlphabet		the alphabet of the Enigma machine
	 * @param refType		the type of the Reflector
	 * @param plugboard		the plugboard of the machine
	 * @param rotors		the rotors of the machine
	 */
	public Enigma(Alphabet inputAlphabet, char refType, Plugboard plugboard, CollectionOfRotors rotors) {
		this.inputAlphabet = inputAlphabet;
		this.plugboard = plugboard;
		this.rotors = rotors;
		reflector = new Reflector(refType, inputAlphabet);
	}

	/** 
	 *  <p>
	 * Converts a letter using the Enigma machine.
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char convertLetter(char letter) {
		if (!inputAlphabet.checkLetter(letter))
			return (char) -1;
		char newLetter;
		newLetter = plugboard.convertLetter(letter);
		newLetter = rotors.convertLetter(newLetter);
		newLetter = reflector.convertLetter(newLetter);
		newLetter = rotors.revertLetter(newLetter);
		newLetter = plugboard.convertLetter(newLetter);
		return newLetter;
	}
	
	/** 
	 *  <p>
	 * Converts back a letter using the Enigma machine. 
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char revertLetter(char letter) {
		return convertLetter(letter);
	}
}
