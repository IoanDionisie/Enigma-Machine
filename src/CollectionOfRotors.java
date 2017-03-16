import java.util.ArrayList;

/**
 * <p>
 * Class that implements the Rotors of the Enigma machine
 * </p>
 */
public class CollectionOfRotors implements Cryptography {
	
	private ArrayList<Rotor> list;
	
	/** 
	 *  <p>
	 * Constructor. Creates a CollectionOfRotors object
	 *  </p> 
	 */
	public CollectionOfRotors(Alphabet inputAlphabet) {
		list = new ArrayList<Rotor>();
	}
	
	/** 
	 *  <p>
	 * Adds a new rotor in ArrayList<Rotor>
	 *  </p> 
	 * @param rotor		object of type Rotor
	 */
	public void addRotors(Rotor rotor) {
		list.add(rotor);
	}
	
	/** 
	 *  <p>
	 * Converts an input letter that passes trough the ArrayList<Rotor>
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char convertLetter(char letter) {
		Rotor currentRotor;
		boolean rotated = false;
		char newLetter = letter;
		for (int i = 0; i < list.size(); ++i) {	
			rotated = false;
			currentRotor = list.get(i);
			if (i == 0) {
				currentRotor.rotate();
				currentRotor.setHasRotated(true);
			}		
			if (currentRotor.getShouldRotate()) {
				currentRotor.rotate();
				currentRotor.setShouldRotate(false);
			}		
			if (currentRotor.afterNotch() && currentRotor.getHasRotated() && i != list.size() - 1) {
				list.get(i + 1).rotate();
				list.get(i + 1).setHasRotated(true);
			}			
			newLetter = currentRotor.convertLetter(newLetter);	
			if (currentRotor.getHasRotated() == true && i != 0) {
				currentRotor.setHasRotated(false);
				rotated = true;
			}	
			if (currentRotor.isNotch() && i != 0 && rotated) {
				currentRotor.setShouldRotate(true);
				currentRotor.setHasRotated(true);
			}
		}
		return newLetter;
	}
	
	/** 
	 *  <p>
	 * Converts the letter back, from the reflector to the plugboard, through the ArrayList<Rotor>
	 *  </p> 
	 * @param letter		a letter
	 * @return Returns the converted letter.
	 */
	@Override
	public char revertLetter(char letter) {
		Rotor currentRotor;
		char newLetter = letter;
		for (int i = list.size() - 1; i >= 0; --i) {
			currentRotor = list.get(i);
			newLetter = currentRotor.revertLetter(newLetter);
		}
		return newLetter;
	}
}

