
/**
 * <p>
 * Class that implements the reflector of the Enigma machine
 *</p>
 */
public class Reflector {
	
	private static String reflectorType1 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	private static String reflectorType2 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
	private char[] mapping;

	/** 
	 *  <p>
	 * Constructor. Creates a new object of type Reflector.
	 *  </p> 
	 * @param refType		the reflector's type
	 * @param inputAlphabet		the alphabet of the Enigma machine
	 */
	public Reflector(char refType, Alphabet inputAlphabet) {
		mapping = new char[26];
		changeLetters(refType, inputAlphabet);
	}
	
	/** 
	 *  <p>
	 * Creates the mapping of the reflector depending of it's type
	 *  </p> 
	 * @param refType		the type of the reflector
	 * @param inputAlphabet		the alphabet of the Enigma machine
	 */
	public void changeLetters(char refType, Alphabet inputAlphabet) {
		String reflectorString;
		if (refType == 'B') {
			reflectorString = reflectorType1;
		}
		else {
			reflectorString = reflectorType2;	
		}
		for (int i = 0; i < 26; ++i) {
			if (inputAlphabet.checkLetter((char)(i + 'A'))) {
				mapping[i] = reflectorString.charAt(i);
			}
			else {
				mapping[i] = (char) -1;
			}
		}	
	}
	
	/** 
	 *  <p>
	 * Converts a letter passing through the plugboard
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns an array containing the mapping of the plugboard.
	 */
	public char convertLetter(char letter) {
		if (letter > 'Z' || letter < 'A')
			return (char) -1;
		return mapping[letter - 'A'];
	}
}
