/**
 * @author Camera Finn
 */

// implements the Solitaire algorithm
// has 2 static mehtods
// Both methods will need to create and key a new KeystreamGenerator using the
// specified passphrase before carrying out the encryption or decryption process
// described in "Encryption" and "Decryption"

public class SolitaireEncoder {
	// encrypt, which takes a message, the passphrase, and the deck size as
	// parameters and returns the encrypted message

	/**
	 * @param inputMessage
	 *          a String to encode
	 * @param passphrase
	 *          determines how the deck is keyed
	 * @param deckSize
	 *          integer that determines the size of the deck being used
	 *          Pre-conditions: message != null passphrase != null
	 * @return String of the encoded message
	 */
	public static String encrypt ( String message, String passphrase,
	                               int deckSize ) {
		KeystreamGenerator keyDeck = new KeystreamGenerator(deckSize);
		// String password = passphrase.replaceAll("[\\W]","").toUpperCase();
		keyDeck.key(passphrase);
		// System.out.println("\n"+passphrase);

		String codedMessage = "";
		String phrase = message.replaceAll("[\\W]","").toUpperCase();
		// System.out.println(phrase);
		char[] passphraseToChar = phrase.toCharArray();
		for ( char character : passphraseToChar ) {
			// System.out.print(character + " ");
			int sum = charToInt(character) + keyDeck.nextKeystreamValue();
			if ( sum > deckSize ) {
				sum = sum - deckSize;
			}
			char letter = intToChar(sum);
			codedMessage = codedMessage + letter;
		}
		// System.out.print(codedMessage);
		return codedMessage;
	}

	// decrypt, which takes an encrypted message, the passphrase, and the deck
	// size as parameters and returns the decrypted message

	/**
	 * @param codedMessage
	 *          String that is to be decoded
	 * @param passphrase
	 *          determines how the deck is keyed
	 * @param deckSize
	 *          integer that determined the size of the deck being used
	 *          Pre-conditions: message != null passphrase != null
	 * @return string of the message uncoded
	 */
	public static String decrypt ( String codedMessage, String passphrase,
	                               int deckSize ) {
		KeystreamGenerator keyDeck = new KeystreamGenerator(deckSize);
		String password = passphrase.replaceAll("[\\W]","").toUpperCase();
		keyDeck.key(password);
		// System.out.print(password);
		String decodedMessage = "";
		String phrase = codedMessage.replaceAll("[\\W]","").toUpperCase();
		char[] passphraseToChar = phrase.toCharArray();
		for ( char character : passphraseToChar ) {
			int difference = charToInt(character) - keyDeck.nextKeystreamValue();
			if ( difference <= 0 ) {
				difference = difference + deckSize;
			}
			char letter = intToChar(difference);
			decodedMessage = decodedMessage + letter;
		}
		return decodedMessage;
	}

	/**
	 * convert the char letter to an integer value
	 *
	 * @param letter
	 * @return the equivalent value of the parameter's letter
	 */

	public static int charToInt ( char letter ) {
		switch ( letter ) {
		case 'A':
			return 1;
		case 'B':
			return 2;
		case 'C':
			return 3;
		case 'D':
			return 4;
		case 'E':
			return 5;
		case 'F':
			return 6;
		case 'G':
			return 7;
		case 'H':
			return 8;
		case 'I':
			return 9;
		case 'J':
			return 10;
		case 'K':
			return 11;
		case 'L':
			return 12;
		case 'M':
			return 13;
		case 'N':
			return 14;
		case 'O':
			return 15;
		case 'P':
			return 16;
		case 'Q':
			return 17;
		case 'R':
			return 18;
		case 'S':
			return 19;
		case 'T':
			return 20;
		case 'U':
			return 21;
		case 'V':
			return 22;
		case 'W':
			return 23;
		case 'X':
			return 24;
		case 'Y':
			return 25;
		case 'Z':
			return 26;
		default: {
			return 0;
		}
		}
	}

	/**
	 * convert the integer to a letter/char
	 *
	 * @param value
	 * @return the char equivalent to the parameter's value
	 */
	public static char intToChar ( int value ) {
		switch ( value ) {
		case 1:
			return 'A';
		case 2:
			return 'B';
		case 3:
			return 'C';
		case 4:
			return 'D';
		case 5:
			return 'E';
		case 6:
			return 'F';
		case 7:
			return 'G';
		case 8:
			return 'H';
		case 9:
			return 'I';
		case 10:
			return 'J';
		case 11:
			return 'K';
		case 12:
			return 'L';
		case 13:
			return 'M';
		case 14:
			return 'N';
		case 15:
			return 'O';
		case 16:
			return 'P';
		case 17:
			return 'Q';
		case 18:
			return 'R';
		case 19:
			return 'S';
		case 20:
			return 'T';
		case 21:
			return 'U';
		case 22:
			return 'V';
		case 23:
			return 'W';
		case 24:
			return 'X';
		case 25:
			return 'Y';
		case 26:
			return 'Z';
		default: {
			return ' ';
		}
		}
	}

}
