import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class holds a "dictionary" word list, stores the words in the word list in
 * sorted order Also creates an array list of words having specific prefix(s)
 * 
 * @author Camera Finn
 */

public class Lexicon {
	private ArrayList<String> wordList_; // instance variable: the word list
	private ArrayList<String> matchWords_; // instance variable: the list of
											// words
											// from file in alphabetical order
	private ArrayList<String> alist_, blist_, clist_, dlist_, elist_, flist_, glist_, hlist_, ilist_, jlist_, klist_,
			llist_, mlist_, nlist_, olist_, plist_, qlist_, rlist_, slist_, tlist_, ulist_, vlist_, wlist_, xlist_,
			ylist_, zlist_;
	// array list for each letter of the alphabet (sub-lists that get combined
	// to
	// make up the matchWords_ list)

	/**
	 * initializes the word list and the sub-lists to be empty
	 */
	public Lexicon() {
		wordList_ = new ArrayList<String>(); // initializes the set to be empty
		alist_ = new ArrayList<String>();
		blist_ = new ArrayList<String>();
		clist_ = new ArrayList<String>();
		dlist_ = new ArrayList<String>();
		elist_ = new ArrayList<String>();
		flist_ = new ArrayList<String>();
		glist_ = new ArrayList<String>();
		hlist_ = new ArrayList<String>();
		ilist_ = new ArrayList<String>();
		jlist_ = new ArrayList<String>();
		klist_ = new ArrayList<String>();
		llist_ = new ArrayList<String>();
		mlist_ = new ArrayList<String>();
		nlist_ = new ArrayList<String>();
		olist_ = new ArrayList<String>();
		plist_ = new ArrayList<String>();
		qlist_ = new ArrayList<String>();
		rlist_ = new ArrayList<String>();
		slist_ = new ArrayList<String>();
		tlist_ = new ArrayList<String>();
		ulist_ = new ArrayList<String>();
		vlist_ = new ArrayList<String>();
		wlist_ = new ArrayList<String>();
		xlist_ = new ArrayList<String>();
		ylist_ = new ArrayList<String>();
		zlist_ = new ArrayList<String>();
	}

	/**
	 * Checks the first letter of the word being add to decide which sublist to
	 * add the word to
	 * 
	 * @param wordAdd
	 */
	public void add(String wordAdd) {
		String word = wordAdd.toLowerCase();
		if (word.charAt(0) == 'a') {
			addHelp(wordAdd, alist_);
			
		} else if (word.charAt(0) == 'b') {
			addHelp(wordAdd, blist_);
			
		} else if (word.charAt(0) == 'c') {
			addHelp(wordAdd, clist_);
			
		} else if (word.charAt(0) == 'd') {
			addHelp(wordAdd, dlist_);
			
		} else if (word.charAt(0) == 'e') {
			addHelp(wordAdd, elist_);

		} else if (word.charAt(0) == 'f') {
			addHelp(wordAdd, flist_);

		} else if (word.charAt(0) == 'g') {
			addHelp(wordAdd, glist_);

		} else if (word.charAt(0) == 'h') {
			addHelp(wordAdd, hlist_);

		} else if (word.charAt(0) == 'i') {
			addHelp(wordAdd, ilist_);

		} else if (word.charAt(0) == 'j') {
			addHelp(wordAdd, jlist_);

		} else if (word.charAt(0) == 'k') {
			addHelp(wordAdd, klist_);

		} else if (word.charAt(0) == 'l') {
			addHelp(wordAdd, llist_);

		} else if (word.charAt(0) == 'm') {
			addHelp(wordAdd, mlist_);

		} else if (word.charAt(0) == 'n') {
			addHelp(wordAdd, nlist_);

		} else if (word.charAt(0) == 'o') {
			addHelp(word, olist_);

		} else if (word.charAt(0) == 'p') {
			addHelp(wordAdd, plist_);

		} else if (word.charAt(0) == 'q') {
			addHelp(wordAdd, qlist_);

		} else if (word.charAt(0) == 'r') {
			addHelp(wordAdd, rlist_);

		} else if (word.charAt(0) == 's') {
			addHelp(wordAdd, slist_);

		} else if (word.charAt(0) == 't') {
			addHelp(wordAdd, tlist_);

		} else if (word.charAt(0) == 'u') {
			addHelp(wordAdd, ulist_);

		} else if (word.charAt(0) == 'v') {
			addHelp(wordAdd, vlist_);

		} else if (word.charAt(0) == 'w') {
			addHelp(wordAdd, wlist_);

		} else if (word.charAt(0) == 'x') {
			addHelp(wordAdd, xlist_);

		} else if (word.charAt(0) == 'y') {
			addHelp(wordAdd, ylist_);

		} else if (word.charAt(0) == 'z') {
			addHelp(wordAdd, zlist_);
		}
	}

	/**
	 * Helper method for the add method. Goes through all of the words in the
	 * file and adds them alphabetically to the sub-list for the corresponding
	 * letter that the word starts with
	 * 
	 * @param word
	 *            - the string that is being added to the set
	 */
	private void addHelp(String word, ArrayList<String> list) {
		if (list.size() == 0) { // adding the first word to list
			list.add(word);
		} else {
			String word2 = word.toUpperCase();
			char[] newWord = word2.toCharArray();
			for (int i = 0; i < list.size(); i++) {
				int count = 0;
				String listWord = list.get(i).toUpperCase();
				char[] currentWord = listWord.toCharArray();
				int min = Math.min(list.get(i).length(), word.length());

				for (int w = 0; w < min; w++) {
					if (newWord[w] < currentWord[w]) {
						if (!list.contains(word)) {
							list.add(i, word);
							i = list.size();
							break;
						}
					} else if (newWord[w] > currentWord[w]) {
						break;
					} else if (newWord[w] == currentWord[w]) {
						count += 1;
					}
				}
				if (count == min && min == word.length()) {
					if (!list.contains(word)) {
						list.add(i, word);
						break;
					}
				}
			}
		}
		if (!list.contains(word)) {
			list.add(word);
		}
	}

	/**
	 * Combines all of the sub string array lists (string array list for each
	 * letter of the alphabet) into one array list
	 */
	private void combine() {
		wordList_.addAll(alist_);
		wordList_.addAll(blist_);
		wordList_.addAll(clist_);
		wordList_.addAll(dlist_);
		wordList_.addAll(elist_);
		wordList_.addAll(flist_);
		wordList_.addAll(glist_);
		wordList_.addAll(hlist_);
		wordList_.addAll(ilist_);
		wordList_.addAll(jlist_);
		wordList_.addAll(klist_);
		wordList_.addAll(llist_);
		wordList_.addAll(mlist_);
		wordList_.addAll(nlist_);
		wordList_.addAll(olist_);
		wordList_.addAll(plist_);
		wordList_.addAll(qlist_);
		wordList_.addAll(rlist_);
		wordList_.addAll(slist_);
		wordList_.addAll(tlist_);
		wordList_.addAll(ulist_);
		wordList_.addAll(vlist_);
		wordList_.addAll(wlist_);
		wordList_.addAll(xlist_);
		wordList_.addAll(ylist_);
		wordList_.addAll(zlist_);
	}

	/**
	 * Takes a filename as a parameter, reads the file, and adds the words in
	 * that file
	 * 
	 * @param filename
	 *            - a string
	 * @Pre-condition: the file is accessible to the program
	 * @throws FileNotFoundException
	 */
	public void load(String filename) throws FileNotFoundException {
		try {
			Scanner read = new Scanner(new File(filename));
			while (read.hasNext()) {
				add(read.next());
			}
			combine();
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Can't be Found");
		}
	}

	/**
	 * Empties the the word list and all of the sub lists
	 */
	public void clear() {
		wordList_.clear();
		alist_.clear();
		blist_.clear();
		clist_.clear();
		dlist_.clear();
		elist_.clear();
		flist_.clear();
		glist_.clear();
		hlist_.clear();
		ilist_.clear();
		jlist_.clear();
		klist_.clear();
		llist_.clear();
		mlist_.clear();
		nlist_.clear();
		olist_.clear();
		plist_.clear();
		qlist_.clear();
		rlist_.clear();
		slist_.clear();
		tlist_.clear();
		ulist_.clear();
		vlist_.clear();
		wlist_.clear();
		xlist_.clear();
		ylist_.clear();
		zlist_.clear();
		assert wordList_.isEmpty() && alist_.isEmpty() && blist_.isEmpty() && clist_.isEmpty() && dlist_.isEmpty()
				&& elist_.isEmpty() && flist_.isEmpty() && glist_.isEmpty() && hlist_.isEmpty() && ilist_.isEmpty()
				&& jlist_.isEmpty() && klist_.isEmpty() && llist_.isEmpty() && mlist_.isEmpty() && nlist_.isEmpty()
				&& olist_.isEmpty() && plist_.isEmpty() && qlist_.isEmpty() && rlist_.isEmpty() && slist_.isEmpty()
				&& tlist_.isEmpty() && ulist_.isEmpty() && vlist_.isEmpty() && wlist_.isEmpty() && xlist_.isEmpty()
				&& ylist_.isEmpty() && zlist_.isEmpty();
	}

	/**
	 * Tests to see if there is a word in the word list that begins with
	 * indicated prefix - using the binarySearch method
	 * 
	 * @param prefix
	 * @return true if there is word in the word list that has the indicated
	 *         prefix, false otherwise
	 */
	public boolean isPrefix(String prefix) {
		if (binarySearch(prefix) < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Does the binary searching for a word with the indicated prefix in the
	 * list of words
	 * 
	 * @param prefix
	 *            - string of interest
	 * @param start
	 *            - starting index of word list range
	 * @param stop
	 *            - ending index of word list range
	 * @return the index value of the word that does have the prefix of
	 *         interest, if there is not a word in the list with the indicated
	 *         prefix, -1 is returned
	 */
	private int binarySearch(String prefix) {

		int stop = wordList_.size() - 1;
		int start = 0;
		int middle = 0;
		while (stop >= start) {
			middle = (stop + start) / 2;
			String word = wordList_.get(middle).toLowerCase();
			if (prefix.length() <= word.length()) {
				if (prefix.compareTo(word.substring(0, prefix.length())) < 0) {
					// if the prefix is closer to the beginning of the alphabet
					// than the word being compared
					stop = middle - 1;
				} else if (prefix.compareTo(word.substring(0, prefix.length())) > 0) {
					// if the prefix is closer to the end of the alphabet than
					// the word being compared
					start = middle + 1;
				} else if (prefix.compareTo(word.substring(0, prefix.length())) == 0) {
					// if the word has that prefix
					return middle;
				}
			} else {
				if (prefix.charAt(0) > wordList_.get(middle).toLowerCase().charAt(0)) {
					start++;
				} else {
					stop--;
				}
			}
		}
		return -1;
	}

	/**
	 * Creates array list of the words that start with the indicated prefix
	 * 
	 * @param prefix
	 * @return an empty array list or an array list containing the all of the
	 *         words in the word list that have the given prefix
	 */

	public ArrayList<String> findWords(String prefix) {
		matchWords_ = new ArrayList<String>();
		if (isPrefix(prefix)) {
			int start = binarySearch(prefix);
			for (int i = start; i < 0 && wordList_.get(i).toLowerCase().startsWith(prefix); i--) {
				matchWords_.add(0, wordList_.get(i));
			}
			for (int i = start; i < wordList_.size() && wordList_.get(i).toLowerCase().startsWith(prefix); i++) {
				matchWords_.add(wordList_.get(i));
			}
		}
		return matchWords_;
	}

	/**
	 * Prints out each word in the word list
	 */
	public void print() {
		for (int i = 0; i < wordList_.size(); i++) {
			System.out.println(wordList_.get(i));
		}
		System.out.println(wordList_.size());
	}
}