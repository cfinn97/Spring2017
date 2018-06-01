/**
 * @author Camera Finn
 */
public class KeystreamGeneratorTester {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {

		// TEST key() method
		// key(passPhrase) - key the deck using the pass phrase "s"
		// start state: SolitaireDeck object with size 26 in ascending order
		// input: s
		// expected output: SolitaireDeck object {21 22 23 24 25 26 27A 27B 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 1}
		{
			KeystreamGenerator testGenerator = new KeystreamGenerator(26);
			// System.out.println(testGenerator.getDeckString());
			testGenerator.key("s");
			// System.out.println(testGenerator.getDeckString());

			if ( testGenerator.getDeckString()
			    .equals("21 22 23 24 25 26 27A 27B 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 1") ) {
				System.out.println("key(s): PASSED");
			} else {
				System.out.println("key(s): FAILED");
			}
		}
		// key(passPhrase) - key the deck using the passPhrase "secret key!"
		// start state: SolitaireDeck object with size 26 in ascending order
		// input: secret key!
		// expected output: SolitaireDeck object {1 23 25 27B 2 22 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 27A 26 8 3 24 6 4}
		{
			KeystreamGenerator testGenerator = new KeystreamGenerator(26);
			// System.out.println(testGenerator.getDeckString());
			testGenerator.key("secret key!");
			// System.out.println(testGenerator.getDeckString());

			if ( testGenerator.getDeckString()
			    .equals("1 23 25 27B 2 22 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 27A 26 8 3 24 6 4") ) {
				System.out.println("key(secret key!): PASSED");
			} else {
				System.out.println("key(secret key!): FAILED");
			}
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// TEST nextKeystreamValue() - method
		// nextKeystreamValue() - with 14 as the next keystreamm value
		// start state: keyed SolitaireDeck object {1 23 25 27B 2 22 10 11 12 13 14
		// 15 16 17 18 19 20 21 7 5 9 27A 26 8 3 24 6 4}
		// input: n/a
		// expected output: 22
		{
			KeystreamGenerator testGenerator = new KeystreamGenerator(26);
			// System.out.println(testGenerator.getDeckString());

			testGenerator.key("secret key!");
			// System.out.println(testGenerator.getDeckString());

			int value = testGenerator.nextKeystreamValue();
			// System.out.println(value);
			if ( value == 22 ) {
				System.out
				    .println("nextKeystreamValue() (keyed deck to 'secret key!'): PASSED");
			} else {
				System.out
				    .println("nextKeystreamValue() (keyed deck to 'secret key!'): FAILED");
			}
		}

		// nextKeystreamValue() - the first keystream value is a joker, with the
		// official keystream value of 25 
		// start state: keyed SolitaireDeck object {12 27B 9 10 1 13 14 15 16 17 18
		// 19 20 21 22 2 25 26 5 6 7 8 3 23 27A 24 11 4}
		// input: n/a
		// expected output: 14
		{
			KeystreamGenerator testGenerator = new KeystreamGenerator(26);
			// System.out.println(testGenerator.getDeckString());

			testGenerator.key("secr!");
			testGenerator.getDeck().swapJokerA();
			// System.out.println(testGenerator.getDeckString());

			int value = testGenerator.nextKeystreamValue();
			// System.out.println(value);
			if ( value == 25 ) {
				System.out.println("nextKeystreamValue(): PASSED");
			} else {
				System.out.println("nextKeystreamValue(): FAILED");
			}
		}

	}
}
