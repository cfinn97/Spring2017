
/**
 * @author Camera Finn
 */
// Identify and check preconditions for all methods. Think carefully about
// allowed parameter values for methods!
import java.util.Scanner;

public class SolitaireMain {

	public static void main ( String[] args ) {
		// prompts the user for the necessary information, invokes
		// SolitaireEncoder's encrypt or decrypt methods as needed to do the
		// actual encryption and decryption, and displays the results.

		boolean run = true;
		Scanner answer = new Scanner(System.in);
		// user's inputs should be in bold and underlined

		// 1: prompt user for pass phrase
		// prompt only at beginning, not again
		System.out.print("enter passphrase: ");
		String passphrase = answer.nextLine();
		System.out.println();

		String message = "";
		String resultMessage = "";

		while ( run ) {
			System.out.print("encrypt, decrypt, or quit? [e/d/q] ");
			String choice = answer.nextLine();
			assert choice.equals("e") || choice.equals("d") || choice.equals("q");
			if ( choice.equals("e") ) { // if answer = e
				// 2: enter/type message
				System.out.print("enter message: ");
				message = answer.nextLine();
				System.out.println();

				resultMessage = SolitaireEncoder.encrypt(message,passphrase,26);

				// 3: print encrypted message

				System.out.println("encrypted: " + resultMessage + "\n");

			} else if ( choice.equals("d") ) { // if answer is d

				// 2: enter/type encrypted message

				System.out.print("enter encrypted message: ");
				message = answer.nextLine();
				System.out.println();

				resultMessage = SolitaireEncoder.decrypt(message,passphrase,26);

				// 3: print decrypted message

				System.out.println("decrypted: " + resultMessage + "\n");

			} else if ( choice.equals("q") ) {
				// 8: encrypt, decrypt, or quit?
				// answer should be q to quit
				// quiting should end the program
				answer.close();
				run = false;
			}
		}

	}

}
