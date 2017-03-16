import java.util.List;

/**
 * <p>
 * This execution entry point class handles parsing and executing commands from the input
 * file.
 * </p>
 */

	public class Main {

	/**
	 * <p>
	 * Execution entry point.
	 *</p>
	 */
	public static void main(String[] args) {
		
		FileParser newParser = new FileParser(args[0]);
		newParser.open();
		List<String> list;
		list = newParser.parseNextLine(" ");
		Alphabet alphabet = new Alphabet(list.get(0));
		list = newParser.parseNextLine("[\\(\\)]+");
		Plugboard plugboard = new Plugboard(alphabet);
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).length() >= 2){
				plugboard.addPlug(list.get(i).charAt(0), list.get(i).charAt(1));
			}
		}
		list = newParser.parseNextLine(" ");
		char refType = list.get(0).charAt(0);
		int[] rotorType = new int[4];
		int numberOfRotors = list.size() - 1;
		for (int i = 0; i < list.size() - 1; ++i) {
			rotorType[i] = Integer.parseInt(list.get(i + 1));
		}
		list = newParser.parseNextLine(" ");
		int[] ringPosition = new int[4];
		for (int i = 0; i < list.get(0).length(); ++i) {
			ringPosition[i] = list.get(0).charAt(i) - 'A';
		}	
		list = newParser.parseNextLine(" ");
		int[] rotorsPosition = new int[4];
		for (int i = 0; i < list.get(0).length(); ++i) {
			rotorsPosition[i] = list.get(0).charAt(i) - 'A';
		}
		CollectionOfRotors rotors = new CollectionOfRotors(alphabet);
		for (int i = numberOfRotors - 1; i >= 0; --i) {
			rotors.addRotors(new Rotor(rotorType[i], ringPosition[i], rotorsPosition[i], alphabet));
		}
		list = newParser.parseNextLine(" ");
		String operation;
		if (list.get(0).equals("C")) {
			operation = "criptare";
		}
		else {
			operation = "decriptare";
		}
		Enigma enigma = new Enigma(alphabet, refType, plugboard, rotors);
		while ((list = newParser.parseNextLine(" ")) != null) {
			String text = list.get(0);
			if (operation.equals("criptare")) {
				for (int i = 0; i < text.length(); ++i) {
					System.out.print(enigma.convertLetter(text.charAt(i)));
				}
			}
			else {
				for (int i = 0; i < text.length(); ++i) {
					System.out.print(enigma.revertLetter(text.charAt(i)));
				}	
			}
		}
		newParser.close();
	}
}
