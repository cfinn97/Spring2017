/**
 * @author Camera Finn
 */

public class SolitaireDeck {
	private DoubleListNode head_; // instance variable for the head of the
	// circular doubly-linked list
	// contains the list of nodes
	// nodes contains the cards; cards = its
	// element
	private int deckSize_; // instance variable for deck size

	private boolean checkContents () {
		// check the contents of the deck (the deck contains cards 1..decksize plus
		// joker A and joker B
		boolean result = false;
		int value = 1;
		for ( DoubleListNode current = head_, next = head_.getNext() ; next != head_
		    && current.getCard() != next.getCard() ; current =
		        current.getNext(), next = next.getNext() ) {
			value++;
		}

		if ( value == deckSize_ + 2 ) {
			result = true;
		} else {
			return false;
		}
		return result;
	}

	private boolean checkStructure () {
		// check the linked list structure (i.e. that for every node a, the previous
		// of a's next and the next of a's previous are a)
		boolean result = false;

		DoubleListNode card = head_;
		DoubleListNode prevCard = head_.getPrev();
		DoubleListNode nextCard = head_.getNext();

		for ( int i = 0 ; i < deckSize_ + 2 ; i++ ) {
			if ( prevCard.getNext() == nextCard.getPrev()
			    && prevCard.getNext() == card ) {
				result = true;
			} else {
				return false;
			}
			prevCard = prevCard.getNext();
			card = card.getNext();
			nextCard = nextCard.getNext();
		}

		return result;
	}

	/**
	 * constructor: initializes the "deck" (node list)
	 * Pre-conditions: the array
	 * of SolitaireCards is not empty deckSize >= 3
	 * 
	 * @param dsize
	 *          the deck size
	 */

	/**
	 * deck constructor for testing
	 */
	SolitaireDeck ( SolitaireCard[] cards, int deckSize ) {
		assert cards.length == deckSize + 2;
		assert deckSize >= 3;
		assert cards != null;
		deckSize_ = deckSize;
		int i = 0;
		head_ = new DoubleListNode(cards[i]);
		// System.out.print(head_.getCard() + " ");

		i = i + 1;
		DoubleListNode current = new DoubleListNode(cards[i]);
		i = i + 1;
		DoubleListNode previous = head_;
		head_.setNext(current);
		current.setPrev(head_);
		// System.out.print(current.getCard() + " ");

		for ( ; i < cards.length - 2 ; i++ ) {
			current.setNext(new DoubleListNode(cards[i]));
			previous = current;
			current = current.getNext();
			current.setPrev(previous);
			// System.out.print(current.getCard() + " ");
		}
		current.setNext(head_);
		current.setNext(new DoubleListNode(cards[i]));
		previous = current;
		current = current.getNext();
		// System.out.print(current.getCard() + " ");

		current.setPrev(previous);
		current.setNext(new DoubleListNode(cards[i + 1]));
		previous = current;
		current = current.getNext();
		// System.out.println(current.getCard());

		current.setNext(head_);
		current.setPrev(previous);
		head_.setPrev(current);

		assert checkStructure() == true && checkContents() == true;
	}

	/**
	 * Post-conditions: initializes a SolitaireDeck object with deckSize + 2 cards
	 * none of the cards are have the same value for a card c, the following
	 * card's previous pointer points to card c and the card before card c has
	 * their next pointer pointing to card c
	 */

	
	/**
	 * @param dsize
	 *  Pre-condition: deck size: dsize is greater than or equal to 3
	 */
	public SolitaireDeck ( int dsize ) {
		assert dsize >= 3 : "too small deck size";
		deckSize_ = dsize;
		head_ = new DoubleListNode(new SolitaireCard(1));
		DoubleListNode current = new DoubleListNode(new SolitaireCard(2));
		// System.out.print(head_.getCard() + " ");
		// System.out.print(current.getCard() + " ");

		DoubleListNode previous = head_;
		head_.setNext(current);

		for ( int i = 2, j = 3 ; i < deckSize_ ; i++, j++ ) {
			current.setPrev(previous);
			current.setNext(new DoubleListNode(new SolitaireCard(j)));
			previous = current;
			current = current.getNext();
			// System.out.print(current.getCard() + " ");
		}
		current.setPrev(previous);
		current.setNext(new DoubleListNode(new SolitaireCard(deckSize_ + 1,'A')));
		// makes joker A
		previous = current;
		current = current.getNext();
		// System.out.print(current.getCard() + " ");

		current.setPrev(previous);
		current.setNext(new DoubleListNode(new SolitaireCard(deckSize_ + 1,'B')));
		previous = current;
		current = current.getNext();
		// System.out.print(current.getCard() + " ");

		current.setNext(head_);
		current.setPrev(previous);
		head_.setPrev(current);

		assert checkStructure() == true && checkContents() == true;
	}

	/**
	 * Post-condition: initializes a SolitaireDeck object with deckSize + 2 cards
	 * none of the cards are have the same value for a card c, the following
	 * card's previous pointer points to card c and the card before card c has
	 * their next pointer pointing to card c
	 */

	/**
	 * @return the deck size
	 */
	public int getDeckSize () {
		return deckSize_;
	}

	/**
	 * @return top card in the deck
	 */
	public SolitaireCard getTopCard () {
		DoubleListNode top = head_;
		return top.getCard();
	}

	/**
	 * @return returns the bottom card
	 */
	public SolitaireCard getBottomCard () {
		DoubleListNode current = head_;
		for ( int i = 1 ; i < getDeckSize() + 2 ; i++ ) {
			current = current.getNext();
		}
		return current.getCard();
	}

	/**
	 * @param n
	 *          the nth card/node from the top
	 *          n = 0 is the top card in the deck
	 * @return the nth node, which stores the card
	 */
	public SolitaireCard getNthCard ( int n ) {
		DoubleListNode current = head_;
		if ( n <= deckSize_ + 1 && n > 0 ) {
			for ( int i = 0 ; i < n ; i++ ) {
				current = current.getNext();
			}
		}
		return current.getCard();
	}

	/**
	 * @return solitaire deck cards with joker A shifted down one place, unless
	 *         its at the bottom, then shifts joker A to second card in deck
	 */
	public void swapJokerA () {
		SolitaireCard jokerA = new SolitaireCard(deckSize_ + 1,'A');
		DoubleListNode jokerCard = head_;
		int i = 1;
		for ( ; !jokerCard.getCard().toString().equals(jokerA.toString()) ; ) {
			jokerCard = jokerCard.getNext();
			i++;
		}
		// if joker is not the bottom card
		if ( i != deckSize_ + 2 ) {
			DoubleListNode switchCard = jokerCard.getNext();
			// card switching with jokerA card
			DoubleListNode leftNode = jokerCard.getPrev();
			// card before joker card
			DoubleListNode rightNode = jokerCard.getNext().getNext();
			// card next to the card being switched
			jokerCard.setPrev(switchCard);
			jokerCard.setNext(rightNode);
			switchCard.setNext(jokerCard);
			switchCard.setPrev(leftNode);
			leftNode.setNext(switchCard);
			rightNode.setPrev(jokerCard);

			if ( i == 1 ) { // joker is top card then head_ changes
				head_ = switchCard;
			}

		} else { // if joker is at the bottom of the deck
			jokerCard.setNext(head_.getNext());
			head_.setPrev(jokerCard.getPrev());
			head_.setNext(jokerCard);
			jokerCard.setPrev(head_);
		}
		assert checkStructure() == true && checkContents() == true;
	}

	/**
	 * Post-condition: returns the deck with joker A shifted down one place no
	 * cards have the same value the previous pointer of a card points to the card
	 * succeeding it and the previous pointer of the following card points to the
	 * card before it
	 */

	/*
	 * jokerB is moved down 2 cards in the deck if jokerB is last or next-to-last
	 * card, do same as with did jokerA the top card is ignored in the counting
	 */

	public void swapJokerB () {
		SolitaireCard jokerB = new SolitaireCard(deckSize_ + 1,'B');
		DoubleListNode jokerCard = head_;
		int i = 1;
		for ( ; !jokerCard.getCard().toString()
		    .equals(jokerB.toString()) ; jokerCard = jokerCard.getNext() ) {
			i++;
		}
		// System.out.println(i);

		if ( i == deckSize_ + 1 ) { // if jokerB is next to the bottom
			// System.out.println("hi");

			DoubleListNode leftCard = jokerCard.getPrev(); // card before jokerB
			DoubleListNode bottomCard = jokerCard.getNext(); // bottom card
			DoubleListNode rightCard = jokerCard.getNext().getNext().getNext();
			// second card in deck

			leftCard.setNext(bottomCard);
			bottomCard.setPrev(leftCard);
			head_.setNext(jokerCard);
			rightCard.setPrev(jokerCard);
			jokerCard.setPrev(head_);
			jokerCard.setNext(rightCard);

		} else if ( i == deckSize_ + 2 ) { // if jokerB is at the bottom
			// joker card becomes 3rd card in deckk
			DoubleListNode newBottom = jokerCard.getPrev();
			DoubleListNode secondCard = jokerCard.getNext().getNext();
			DoubleListNode new4Card = jokerCard.getNext().getNext().getNext();

			head_.setPrev(newBottom);
			secondCard.setNext(jokerCard);
			new4Card.setPrev(jokerCard);
			jokerCard.setNext(new4Card);
			jokerCard.setPrev(secondCard);
			newBottom.setNext(head_);

		} else { // if jokerB is not at or next to the bottom

			DoubleListNode leftCard = jokerCard.getPrev();
			// first card to the left of jokerB
			DoubleListNode firstSwitch = jokerCard.getNext();
			// first card to switch in deck
			DoubleListNode secondSwitch = firstSwitch.getNext();
			// second card to switch in deck
			DoubleListNode rightCard = secondSwitch.getNext();
			// card right to the cards being switch in deck

			leftCard.setNext(firstSwitch);
			firstSwitch.setPrev(leftCard);
			secondSwitch.setNext(jokerCard);
			rightCard.setPrev(jokerCard);
			jokerCard.setNext(rightCard);
			jokerCard.setPrev(secondSwitch);

			if ( i == 1 ) { // if jokerB is the top card
				head_ = firstSwitch;
			}
		}
		assert checkStructure() == true && checkContents() == true;

	}

	/**
	 * Post-conditions: returns the deck with joker B shifted down 2 positions in
	 * the deck no cards have the same value the previous pointer of a card points
	 * to the card succeeding it and the previous pointer of the following card
	 * points to the card before it
	 */

	/*
	 * takes the cards above the first joker card and the cards below the second
	 * joker card and swaps them
	 */
	public void tripleCut () {
		DoubleListNode joker1 = head_;
		DoubleListNode topCard = head_; // top card in deck
		DoubleListNode bottomCard = head_;

		for ( int i = 1 ; i < getDeckSize() + 2 ; i++ ) { // find the bottom card in
			// deck
			bottomCard = bottomCard.getNext();
		}

		for ( ; !joker1.getCard().isJoker() ; joker1 = joker1.getNext() ) {}
		// System.out.println(joker1.getCard().toString());

		DoubleListNode leftJoker1 = joker1.getPrev();
		// last card before 1st joker
		// System.out.println(leftJoker1.getCard().toString());

		DoubleListNode joker2 = joker1.getNext();
		// System.out.println(joker2.getCard().toString());

		for ( ; !joker2.getCard().isJoker() ; joker2 = joker2.getNext() ) {}
		DoubleListNode newTopCard = joker2.getNext(); // first card after 2nd
		// joker
		if ( getBottomCard().isJoker() ) { // bottom card is a joker
			head_ = joker1;
			// System.out.println(getBottomCard());
		} else if ( getTopCard().isJoker() ) { // if top card is a joker
			// if top card is a joker1
			head_ = newTopCard;
		} else if ( getTopCard().isJoker() && getBottomCard().isJoker() ) {
			// if both ends are jokers, then do nothing
		} else {
			/*
			 * bottomCard moves to in front of 1st joker card: bottomCard <--> joker1
			 * topCard moves next to 2nd joker: joker2 <--> topCard leftJoker1 (card
			 * to the 1st joker card left) becomes the new bottom card newTopCard
			 * (card next to 2nd joker) becomes new top card leftJoker1 <-->
			 * newTopCard
			 */
			bottomCard.setNext(joker1); // redirect bottom card's next pointer
			// to 1st joker card
			joker1.setPrev(bottomCard); // redirect previous pointer of 1st
			// joker to bottom card
			newTopCard.setPrev(leftJoker1); // redirect previous pointer of the
			// new top card to the card before
			// the 1st joker
			leftJoker1.setNext(newTopCard); // redirect the next pointer of the
			// card left of the 1st joker to the
			// new top card
			topCard.setPrev(joker2); // redirect previous pointer of top card to
			// 2nd joker
			joker2.setNext(topCard); // redirect the 2nd joker's next pointer to
			// the top card
			head_ = newTopCard; // set head to the new top card in deck
		}
		assert checkStructure() == true && checkContents() == true;
	}

	/**
	 * Post-conditions: cards in front of the first joker and the cards after the
	 * second joker are swapped head_ is re-set deck has new bottom card no cards
	 * have the same value the previous pointer of a card points to the card
	 * succeeding it and the previous pointer of the following card points to the
	 * card before it
	 */

	/**
	 * countCut(n) method
	 * 
	 * @param n
	 *          counts n cards, starting with 1 as the top card and cuts the deck
	 *          after the nth card the last card is removed the n cards counted
	 *          from the beginning are moved to the bottom of the deck last card
	 *          that was isolated from deck is put back at the bottom of the deck
	 *          
	 * Pre-condition n >= 1
	 *          
	 * @return deck with cards in front of first joker and cards after second
	 *         joker swapped
	 */
	public void countCut ( int n ) {
		assert (n >= 1);
		DoubleListNode current = head_;
		DoubleListNode tail = head_.getPrev(); // last card that is to be isolated
		DoubleListNode tail2 = head_.getPrev().getPrev();
		for ( int i = 1 ; i < n ; i++ ) {
			current = current.getNext();
		} // counts down to the nth card

		// redirect the ends of the card sections that were moved: the "new"
		// head, second from bottom card, and the previous head cards
		DoubleListNode newHead = current.getNext();
		head_.setPrev(tail2);
		tail2.setNext(head_);

		current.setNext(tail);
		tail.setPrev(current);

		head_ = newHead;
		head_.setPrev(tail);
		tail.setNext(head_);
		assert checkStructure() == true && checkContents() == true;
	}

	/**
	 * Post-conditions: the first n cards are moved towards the bottom of the
	 * deck; right above the bottom card no cards have the same value the previous
	 * pointer of a card points to the card succeeding it and the previous pointer
	 * of the following card points to the card before it
	 */

	/**
	 * Builds a string representation of the deck by converting each card in the deck to string
	 * 
	 * @return string representation of deck
	 */
	public String toString () {
		String stringDeck = "";
		DoubleListNode current = head_;
		for ( int i = 1 ; i < getDeckSize() + 2 ; i++ ) {
			String value = current.getCard().toString();
			current = current.getNext();
			stringDeck = stringDeck + value + " ";
		}
		stringDeck = stringDeck + current.getCard().toString();
		// System.out.println(stringDeck);
		return stringDeck;
	}
}
