
/**
 * <p>
 * Interface that implements the methods needed for converting a letter through
 * every component from the Enigma machine
 * </p>
 */
public interface Cryptography {
	
	public char convertLetter(char letter);
	public char revertLetter(char letter);
}
