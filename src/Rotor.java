
/**
 * <p>
 * Class that implements a rotor of the Enigma machine
 * </p>
 */
public class Rotor implements Cryptography {
	 
	private static String[] rotorTypes = {
		"EKMFLGDQVZNTOWYHXUSPAIBRCJ",
		"AJDKSIRUXBLHWTMCQGZNPYFVOE",
		"BDFHJLCPRTXVZNYEIWGAKMUSQO",
		"ESOVPZJAYQUIRHXLNFTGKDCMWB",
		"VZBRGITYUPSDNHLXAWMJQOFECK",
		"JPGVOUMFYQBENHZRDKASXLICTW",
		"NZJHGRCXMYSWBOUFAIVLPEKQDT",
		"FKQHTLXOCBJSPDZRAMEWNIUYGV"
	};
	
	private char[] mapping;
	private char[] reverseMapping;
	private int currPosition;
	private char[] notch;
	private int ringPosition;
	Alphabet inputAlphabet;
	private boolean hasRotated;
	private boolean shouldRotate;
	private static final char[] notchArray[] = {{'Q'}, {'E'}, {'V'}, {'J'}, {'Z'},
												{'Z', 'M'}, {'Z', 'M'}, {'Z', 'M'}};
	
	/** 
	 *  <p>
	 * Constructor. Creates a new object of type Rotor.
	 *  </p> 
	 * @param type		rotor's type
	 * @param ringPosition		the initial position of the ring
	 * @param initialPosition		the initial position of the rotor
	 * @param inputAlphabet		the alphabet of the Enigma machine
	 */
	public Rotor(int type, int ringPosition, int initialPosition, Alphabet inputAlphabet) {
		mapping = new char[26];
		reverseMapping = new char[26];
		this.inputAlphabet = inputAlphabet;
		setRotorType(type);
		this.notch = notchArray[type - 1];
		this.currPosition = initialPosition;
		this.ringPosition = ringPosition;
		hasRotated = false;
		shouldRotate = false;
	}
	
	/** 
	 *  <p>
	 * Checks if the rotor's position is on notch.
	 *  </p> 
	 * @return Returns true if the position is on notch, and false otherwise.
	 */
	public boolean isNotch() {
		for (int i = 0; i < notch.length; ++i) 
			if (currPosition == (notch[i] - 'A'))
				return true;
		return false;
	}
	
	/** 
	 *  <p>
	 * Checks if the rotor's position is after the notch.
	 *  </p> 
	 * @return Returns true is the position is after the notch, and false otherwise.
	 */
	public boolean afterNotch() {
		for (int i = 0; i < notch.length; ++i) 
			if ((currPosition + 25) % 26 == ( notch[i] - 'A'))
				return true;
		return false;
	}
	
	/** 
	 *  <p>
	 * Converts a letter passing through a rotor.
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char convertLetter(char letter) {
		if (!inputAlphabet.checkLetter(letter)) 
			return (char) -1;
		char newLetter;
		newLetter = (char) ((letter - 'A' - ringPosition + currPosition + 26) % 26);
		newLetter = mapping[newLetter];
		newLetter = (char) ((newLetter - 'A' + ringPosition - currPosition + 26) % 26 + 'A');
		return newLetter;
	}
	
	/** 
	 *  <p>
	 * Converts the letter back, from the reflector to the plugboard, through a rotor
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char revertLetter(char letter) {
		if (!inputAlphabet.checkLetter(letter))
			return (char) -1;
		char newLetter;
		newLetter = (char) ((letter - 'A' - ringPosition + currPosition + 26) % 26);
		newLetter = reverseMapping[newLetter];
		newLetter = (char) ((newLetter - 'A' + ringPosition - currPosition + 26) % 26 + 'A');
		return newLetter;
	}
	
	/** 
	 *  <p>
	 * Set the type of a rotor of Enigma's machine, and populates the mapping and reverseMapping with elements 
	 *  </p> 
	 * @param rotorType		a number from 1 to 8
	 */
	public void setRotorType(int rotorType) {
		String rotorAlph = rotorTypes[rotorType - 1];
		for (int i = 0; i < 26; ++i) {
			if (inputAlphabet.checkLetter(rotorAlph.charAt(i))) {
				 mapping[i] = rotorAlph.charAt(i);
				 reverseMapping[rotorAlph.charAt(i) - 'A'] = (char) (i + 'A'); 
			}
		}
	}
	
	/** 
	 *  <p>
	 *	Rotates the rotor with one position
	 *  </p> 
	 */
	public void rotate() {
		currPosition = (currPosition + 1) % 26;
	}
	
	/** 
	 *  <p>
	 *	Getter for hasRotated 
	 *  </p> 
	 * @return Returns true if has rotated is true, and false otherwise.
	 */
	public boolean getHasRotated() {
		return hasRotated;
	}

	/** 
	 *  <p>
	 * Setter for hasRotated
	 *  </p> 
	 * @param value		true or false
	 */
	public void setHasRotated(boolean value) {
		hasRotated = value;
	}
	
	/** 
	 *  <p>
	 * Getter for shouldRotate
	 *  </p> 
	 * @return Returns true if shouldRotate is true, and false otherwise
	 */
	public boolean getShouldRotate() {
		return shouldRotate;
	}
	
	/** 
	 *  <p>
	 * Setter for shouldRotate
	 *  </p> 
	 * @param value		true or false
	 */
	public void setShouldRotate(boolean value) {
		shouldRotate = value;
		
	}
}
