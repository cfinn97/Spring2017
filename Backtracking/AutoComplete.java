import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Repeatedly prompt the user for a digit string and print out the possible
 * completions for each digit string, and ends when the user enters 'q'
 * 
 * @author Camera Finn
 */
public class AutoComplete {
	private static Lexicon tester = new Lexicon();
	private static ArrayList<String> prefixList_ = new ArrayList<String>();;

	/**
	 * Finds and returns a list of all of the words in the word list that starts
	 * with the letters consistent with the digit string and the word list given
	 * to it
	 * 
	 * @param digits
	 *          - the digit string that is determines the prefixes
	 * @param lexicon
	 * @return an array list of the words whose prefix matches one of the prefixes
	 *         in the list of prefixes
	 */
	public static ArrayList<String> findMatches ( String digits,
	                                              Lexicon lexicon ) {
		ArrayList<String> matchWords = new ArrayList<String>();
		char[] digitArray = digits.toCharArray();
		ArrayList<String> prefixList =
		    matchHelper(digitArray,"",lexicon,prefixList_,0);

		for ( int i = 0 ; i < prefixList.size() ; i++ ) {

			matchWords.addAll((tester.findWords(prefixList.get(i))));
		}
		return matchWords;
	}

	/**
	 * The helper method for the findMatches method - uses recursion to generate
	 * all of the possible prefixes corresponding to the char array form of the
	 * digit string
	 * 
	 * @param digits
	 *          - a char array form of the digit array
	 * @param prefix
	 *          - the current prefix being checked
	 * @param lexicon
	 *          - the lexicon being used: determines the file containing the words
	 *          that the program is using
	 * @param prefixList
	 *          - the list of all of prefixes corresponding to the char array of
	 *          the digit string
	 * @param index
	 *          - the index of the char array
	 * @return
	 */
	private static ArrayList<String> matchHelper ( char[] digits, String prefix,
	                                               Lexicon lexicon,
	                                               ArrayList<String> prefixList,
	                                               int index ) {
		if ( prefix.length() == digits.length ) {
			if ( tester.isPrefix(prefix) ) {
				prefixList.add(prefix);
			}
			return prefixList;
		} else {
			String[] array = digitToStringArray(digits[index]);
			// generate a string array for the corresponding digit the the digit array
			String temp = prefix;
			for ( int i = 0 ; i < array.length ; i++ ) {
				prefix += array[i];
				matchHelper(digits,prefix,lexicon,prefixList,index + 1);
				prefix = temp;
			}
		}
		return prefixList;
	}

	/**
	 * Given a digit string and a word list, returns the most likely text
	 * conversion of the digit string where "most likely" is determined to be the
	 * conversion which is the prefix of the most words in the word list.
	 * 
	 * @param digits
	 * @param lexicon
	 * @return the array list for the prefix that has the most words in it
	 */
	public static ArrayList<String> findConversion ( String digits,
	                                                 Lexicon lexicon ) {
		ArrayList<String> matchWords = new ArrayList<String>();
		char[] digitArray = digits.toCharArray();

		matchHelper(digitArray,"",lexicon,prefixList_,0);
		if ( prefixList_.size() > 0 ) { // if the list of prefixes is not empty
			matchWords.addAll(tester.findWords(prefixList_.get(0)));
			// list of prefixes that the digit string makes and is in at least one
			// word in the word list
			if ( prefixList_.size() > 1 ) {
				// if there is more than 1 prefix with a list of words

				for ( int i = 1 ; i < prefixList_.size() ; i++ ) {
					ArrayList<String> wordListCompare = new ArrayList<String>();
					// create another list of words
					wordListCompare.addAll(tester.findWords(prefixList_.get(i)));
					if ( matchWords.size() < wordListCompare.size() ) {
						matchWords = wordListCompare;
					}
				}
			}
		}
		return matchWords;
	}

	/**
	 * Generates a string array for the corresponding digit
	 * 
	 * @param digit
	 *          - a char
	 * @return a string array for the corresponding digit
	 */
	private static String[] digitToStringArray ( char digit ) {
		switch ( digit ) {
		case '1':
			return new String[] { " " };
		case '2':
			return new String[] { "a", "b", "c" };
		case '3':
			return new String[] { "d", "e", "f" };
		case '4':
			return new String[] { "g", "h", "i" };
		case '5':
			return new String[] { "j", "k", "l" };
		case '6':
			return new String[] { "m", "n", "o" };
		case '7':
			return new String[] { "p", "q", "r", "s" };
		case '8':
			return new String[] { "t", "u", "v" };
		case '9':
			return new String[] { "w", "x", "y", "z" };
		default:
			return new String[] { "" };
		}
	}

	/**
	 * Loads with the word list to use repeatedly prompt the user for a digit
	 * string and print out the possible completions for each digit string (found
	 * using match-finding method) ending when the user enter q
	 * 
	 * @param args
	 */
	public static void main ( String[] args ) {

		Scanner userInput = new Scanner(System.in);
		String s = "words.txt";

		try {
			tester.load(s);
			//tester.print();
			ArrayList<String> result;
			while ( true ) {
				System.out.println("enter a digit sequence: [q to quit]");
				String choice = userInput.next();

				if ( !choice.equals("q") ) {
					//result = findMatches(choice, tester);
					result = findConversion(choice,tester);
					for ( int i = 0 ; i < result.size() ; i++ ) {
						System.out.println(result.get(i));
					}
					System.out.println(result.size());
					result.clear();
					prefixList_.clear();

				} else if ( choice.equals("q") ) {
					userInput.close();
					break;
				}
			}
		} catch ( FileNotFoundException e ) {
			System.out.println("Cannot find file");
		}
	}
}