/**
 * @author Camera Finn
 */
/*
 * implements the keying and generate-next-keystream-value options
 */
public class KeystreamGenerator {
	private SolitaireDeck deck_; // instance variable for the deck to use

	/**
	 * constructor
	 * 
	 * @param size
	 *          takes the deck size and creates a new deck of that size to
	 *          initialize the instance variable "deck_"
	 */
	public KeystreamGenerator ( int size ) {
		deck_ = new SolitaireDeck(size);
	}

	KeystreamGenerator ( SolitaireDeck deck ) {
		// to control order of cards in the keyed deck being used
		deck_ = deck;
	}

	/**
	 * @param passphrase
	 *          uses the passphrase to key the deck
	 */

	public SolitaireDeck key ( String passphrase ) {
		// passphrase: secret key
		/*
		 * steps for each character in passphrase a. If character is not a letter,
		 * skip it ALL methods in SolitaireDeck b. Do a joker swap with joker A c.
		 * Do a joker swap with joker B d. Do a triple cut e. do a count cut, using
		 * the value of the card at the bottom of the deck as the number of cards to
		 * count f. Convert the current letter of the passphrase to a number A = 1,
		 * B = 2, C = 3 treat capital and lower case letters as equivalent g. Do a
		 * second count cut, using the number from the previous as the number of
		 * cards to count
		 */
		String phrase = passphrase.replaceAll("[^A-Za-z]+","").toUpperCase();
		// System.out.println(phrase);
		char[] passphraseToChar = phrase.toCharArray();
		for ( char character : passphraseToChar ) {
			// System.out.println(character);
			deck_.swapJokerA();
			deck_.swapJokerB();
			deck_.tripleCut();
			deck_.countCut(deck_.getBottomCard().getValue());
			int value = charToInt(character);
			// System.out.print(character + " ");
			// System.out.println(value);
			deck_.countCut(value);
		}
		return deck_;
	}

	/**
	 * method: generates and returns the next keystream value
	 * 
	 * @return value of nth card (if card is not a joker) = next keystream value
	 */
	public int nextKeystreamValue () {
		boolean acceptValue = false;
		int value = 0;
		while ( !acceptValue ) {
			deck_.swapJokerA();
			deck_.swapJokerB();
			deck_.tripleCut();
			deck_.countCut(deck_.getBottomCard().getValue());
			int count = deck_.getTopCard().getValue();

			if ( !deck_.getNthCard(count).isJoker() ) {
				value = deck_.getNthCard(count).getValue();
				acceptValue = true;
			} else {}
		}
		assert value != deck_.getDeckSize() + 1;
		return value;
	}

	/**
	 * Post-condition: the keystream value is not a joker (integer value is not 1
	 * plus the size of the deck)
	 */

	/**
	 * convert the char letter to an integer
	 * 
	 * @param letter
	 * @return the integer corresponding to the letter
	 */
	public static int charToInt ( char letter ) {
		switch ( letter ) {
		case 'A':
			return 1;
		case 'b':
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
		default:
			return 0;
		}
	}

	// returns the deck as a string
	String getDeckString () {
		String deckString = deck_.toString();
		return deckString;
	}

	// returns the deck of the class as to be able to manipulate it
	SolitaireDeck getDeck () {
		return deck_;
	}

}
