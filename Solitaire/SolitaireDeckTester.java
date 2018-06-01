/**
 * @author Camera Finn
 */
public class SolitaireDeckTester {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {
		if ( true ) {
			// constructor - deck of size 26
			// start state: n/a
			// input: 26
			// expected output: SolitaireDeck object {1 2 3 4 5 6 7 8 9 10 11 12 13
			// 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 27B}

			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 27B") ) {
					System.out
					    .println("constructor - deck size 26 and cards in ascending order: PASSED");
				} else {
					System.out
					    .println("constructor - deck size 26 and cards in ascending order: FAILED");
				}
			}
			// constructor - deck of size 3
			// start state: n/a
			// input: 3
			// expected output: SolitaireDeck object {1 2 3 4A 4B}

			{
				SolitaireDeck testDeck = new SolitaireDeck(3);
				// System.out.println(testDeck.toString());
				if ( testDeck.toString().equals("1 2 3 4A 4B") ) {
					System.out.println("constructor - deck with size 3: PASSED");
				} else {
					System.out.println("constructor - deck with size 3: FAILED");
				}
			}

			// Test getDeckSize()
			// getDeckSize() - deck with size 26
			// start state: SolitaireDeck object with deck size of 26 and cards in
			// ascending order
			// input: n/a
			// expected output: 26

			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.getDeckSize());
				if ( testDeck.getDeckSize() == 26 ) {
					System.out.println("getDeckSize() - size 26: PASSED");
				} else {
					System.out.println("getDeckSize() - size 26: FAILED");
				}
			}

			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test getTopCard()
			// getTopCard() - after a the top card is moved to second from the bottom
			// of the deck
			// start state: SolitaireDeck object with cards {2 3 4 5 6 7 8 9 10 11 12
			// 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 1 27B}
			// input: n/a
			// expected output: 2

			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				testDeck.countCut(1);
				if ( testDeck.getTopCard().getValue() == 2 ) {
					System.out.println("getTopCard() - top card = 2: PASSED");
				} else {
					System.out.println("getTopCard() - top card = 2: FAILED");
				}
			}

			

			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test getBottomCard()
			// getBottomCard() - joker B is the bottom card
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order
			// input: n/a
			// expected output: 27B

			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.getBottomCard());
				if ( testDeck.getBottomCard().toString().equals("27B") ) {
					System.out.println("getBottomCard() - bottom card = 27B: PASSED");
				} else {
					System.out.println("getBottomCard() - bottom card = 27B: FAILED");
				}

			}

			
			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test getNthCard(n)
			// getNthCard(n) - 5th card is being called
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order
			// input: 5
			// expected output: 6

			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.getNthCard(5));
				if ( testDeck.getNthCard(5).toString().equals("6") ) {
					System.out.println("getNthCard() - Nth card = 6: PASSED");
				} else {
					System.out.println("getNthCard() - Nth card = 6: FAILED");
				}
			}

			// getNthCard(n) - top card in the deck
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order
			// input: 0
			// expected output: 1

			{
				SolitaireDeck testDeck = new SolitaireDeck(26); //
				// System.out.println(testDeck.getNthCard(0));
				if ( testDeck.getNthCard(0).toString().equals("1") ) {
					System.out.println("getNthCard(n) - top card: PASSED");
				} else {
					System.out.println("getNthCard(n) - top card: FAILED");
				}
			}

			// getNthCard(n) - 26th card in the deck from the top
			// start state: SolitaireDeck object with deck size 26 and cards in
			// ascending order
			// input: 26
			// expected output: 27A

			{
				SolitaireDeck testDeck = new SolitaireDeck(26); //
				// System.out.println(testDeck.getNthCard(26));
				if ( testDeck.getNthCard(26).toString().equals("27A") ) {
					System.out.println("getNthCard(n) - Nth card = 27A: PASSED");
				} else {
					System.out.println("getNthCard(n) - Nth card = 27A: FAILED");
				}
			}

			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test swapJokerA()
			// swapJokerA() - joker A card is at the bottom of deck
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order, with joker A card at bottom of deck
			// input: n/a
			// expected output: SolitaireDeck object {1 2 3 4 5 6 7 8 9 10 11 12 13 14
			// 15 16 17 18 19 20 21 22 23 24 25 26 27B 27A}

			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.toString());
				testDeck.swapJokerA();
				testDeck.swapJokerA();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("1 27A 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27B") ) {
					System.out.println("swapJokerA - jokerA at bottom: PASSED");
				} else {
					System.out.println("swapJokerA - second at bottom: FAILED");
				}
			}

			// swapJokerA() - joker A card as the top card in the deck
			// start state: SolitaireDeck object with cards in order {27A 1 23 25 27B
			// 2
			// 22 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 26 8 3 24 6 4}
			// input: n/a
			// expected output: SolitaireDeck object {1 27A 23 25 27B 2 22 10 11 12 13
			// 14 15 16 17 18 19 20 21 7 5 9 26 8 3 24 6 4}

			{
				SolitaireCard[] cards = new SolitaireCard[28];
				cards[0] = new SolitaireCard(27,'A');
				cards[1] = new SolitaireCard(1);
				cards[2] = new SolitaireCard(23);
				cards[3] = new SolitaireCard(25);
				cards[4] = new SolitaireCard(27,'B');
				cards[5] = new SolitaireCard(2);
				cards[6] = new SolitaireCard(22);
				cards[7] = new SolitaireCard(10);
				cards[8] = new SolitaireCard(11);
				cards[9] = new SolitaireCard(12);
				cards[10] = new SolitaireCard(13);
				cards[11] = new SolitaireCard(14);
				cards[12] = new SolitaireCard(15);
				cards[13] = new SolitaireCard(16);
				cards[14] = new SolitaireCard(17);
				cards[15] = new SolitaireCard(18);
				cards[16] = new SolitaireCard(19);
				cards[17] = new SolitaireCard(20);
				cards[18] = new SolitaireCard(21);
				cards[19] = new SolitaireCard(7);
				cards[20] = new SolitaireCard(5);
				cards[21] = new SolitaireCard(9);
				cards[22] = new SolitaireCard(26);
				cards[23] = new SolitaireCard(8);
				cards[24] = new SolitaireCard(3);
				cards[25] = new SolitaireCard(24);
				cards[26] = new SolitaireCard(6);
				cards[27] = new SolitaireCard(4);
				SolitaireDeck testDeck = new SolitaireDeck(cards,26);
				// System.out.println(testDeck.toString());

				testDeck.swapJokerA();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("1 27A 23 25 27B 2 22 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 26 8 3 24 6 4") ) {
					System.out.println("swapJokerA, jokerA at top of bottom: PASSED");
				} else {
					System.out.println("swapJokerA, jokerA at top of bottom: FAILED");
				}
			}

			// swapJokerA() - joker A card is not at the end of deck
			// start state: SolitaireDeck object with cards in order {1 23 25 27B 2 22
			// 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 27A 26 8 3 24 6 4}
			// input: n/a
			// expected output: SolitaireDeck object with cards {1 23 25 27B 2 22 10
			// 11
			// 12 13 14 15 16 17 18 19 20 21 7 5 9 26 27A 8 3 24 6 4}

			{
				SolitaireCard[] cards = new SolitaireCard[28];
				cards[0] = new SolitaireCard(1);
				cards[1] = new SolitaireCard(23);
				cards[2] = new SolitaireCard(25);
				cards[3] = new SolitaireCard(27,'B');
				cards[4] = new SolitaireCard(2);
				cards[5] = new SolitaireCard(22);
				cards[6] = new SolitaireCard(10);
				cards[7] = new SolitaireCard(11);
				cards[8] = new SolitaireCard(12);
				cards[9] = new SolitaireCard(13);
				cards[10] = new SolitaireCard(14);
				cards[11] = new SolitaireCard(15);
				cards[12] = new SolitaireCard(16);
				cards[13] = new SolitaireCard(17);
				cards[14] = new SolitaireCard(18);
				cards[15] = new SolitaireCard(19);
				cards[16] = new SolitaireCard(20);
				cards[17] = new SolitaireCard(21);
				cards[18] = new SolitaireCard(7);
				cards[19] = new SolitaireCard(5);
				cards[20] = new SolitaireCard(9);
				cards[21] = new SolitaireCard(27,'A');
				cards[22] = new SolitaireCard(26);
				cards[23] = new SolitaireCard(8);
				cards[24] = new SolitaireCard(3);
				cards[25] = new SolitaireCard(24);
				cards[26] = new SolitaireCard(6);
				cards[27] = new SolitaireCard(4);

				SolitaireDeck testDeck = new SolitaireDeck(cards,26);
				// System.out.println(testDeck.toString());
				testDeck.swapJokerA();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("1 23 25 27B 2 22 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 26 27A 8 3 24 6 4") ) {
					System.out.println("swapJokerA, jokerA not an end card: PASSED");
				} else {
					System.out.println("swapJokerA, jokerA is not an end card: FAILED");
				}
			}

			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test swapJokerB()
			// swapJokerB() - joker B card is not top or bottom card of deck
			// start state: SolitaireDeck with cards in order {1 23 25 27B 2 22 10 11
			// 12
			// 13 14 15 16 17 18 19 20 21 7 5 9 26 27A 8 3 24 6 4}
			// input: n/a
			// expected output: SolitaireDeck with cards {1 23 25 2 22 27B 10 11 12 13
			// 14 15 16 17 18 19 20 21 7 5 9 26 27A 8 3 24 6 4}

			{
				SolitaireCard[] cards = new SolitaireCard[28];
				cards[0] = new SolitaireCard(1);
				cards[1] = new SolitaireCard(23);
				cards[2] = new SolitaireCard(25);
				cards[3] = new SolitaireCard(27,'B');
				cards[4] = new SolitaireCard(2);
				cards[5] = new SolitaireCard(22);
				cards[6] = new SolitaireCard(10);
				cards[7] = new SolitaireCard(11);
				cards[8] = new SolitaireCard(12);
				cards[9] = new SolitaireCard(13);
				cards[10] = new SolitaireCard(14);
				cards[11] = new SolitaireCard(15);
				cards[12] = new SolitaireCard(16);
				cards[13] = new SolitaireCard(17);
				cards[14] = new SolitaireCard(18);
				cards[15] = new SolitaireCard(19);
				cards[16] = new SolitaireCard(20);
				cards[17] = new SolitaireCard(21);
				cards[18] = new SolitaireCard(7);
				cards[19] = new SolitaireCard(5);
				cards[20] = new SolitaireCard(9);
				cards[21] = new SolitaireCard(26);
				cards[22] = new SolitaireCard(27,'A');
				cards[23] = new SolitaireCard(8);
				cards[24] = new SolitaireCard(3);
				cards[25] = new SolitaireCard(24);
				cards[26] = new SolitaireCard(6);
				cards[27] = new SolitaireCard(4);
				SolitaireDeck testDeck = new SolitaireDeck(cards,26);
				// System.out.println(testDeck.toString());
				testDeck.swapJokerB();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("1 23 25 2 22 27B 10 11 12 13 14 15 16 17 18 19 20 21 7 5 9 26 27A 8 3 24 6 4") ) {
					System.out
					    .println("swapJokerB - joker B is not top or bottom card: PASSED");
				} else {
					System.out
					    .println("swapJokerB - joker B is not top or bottom card: FAILED");
				}
			}

			// swapJokerB() - joker B card is second card from the bottom of deck
			// start state: SolitaireDeck object with cards in order {7A 2 4 10 18 5
			// 7B 12}
			// input: n/a
			// expected output: SolitaireDeck object {7A 6B 2 4 10 18 5 12}
			{
				SolitaireCard[] cards = new SolitaireCard[8];
				cards[0] = new SolitaireCard(7,'A');
				cards[1] = new SolitaireCard(2);
				cards[2] = new SolitaireCard(4);
				cards[3] = new SolitaireCard(10);
				cards[4] = new SolitaireCard(18);
				cards[5] = new SolitaireCard(5);
				cards[6] = new SolitaireCard(7,'B');
				cards[7] = new SolitaireCard(12);
				SolitaireDeck testDeck = new SolitaireDeck(cards,6);
				// System.out.println(testDeck.toString());

				testDeck.swapJokerB();
				// System.out.println(testDeck.toString());

				if ( testDeck.toString().equals("7A 7B 2 4 10 18 5 12") ) {
					System.out.println("swapJokerB - jokerB second from bottom: PASSED");
				} else {
					System.out.println("swapJokerB - jokerB second from bottom: FAILED");
				}
			}

			// swapJokerB() - joker B card is the bottom card in the deck
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order
			// input: n/a
			// expected output: SolitaireDeck object {1 2 27B 3 4 5 6 7 8 9 10 11 12
			// 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A}
			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.toString());

				testDeck.swapJokerB();
				// System.out.println(testDeck.toString());

				if ( testDeck.toString()
				    .equals("1 2 27B 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A") ) {
					System.out.println("swapJokerB - jokerB at bottom of deck: PASSED");
				} else {
					System.out.println("swapJokerB - jokerB at bottom of deck: FAILED");
				}
			}

			// swapJokerB() - joker B card is the top card in the deck
			// start state: SolitaireDeck object {7B, 7A, 4, 10, 18, 5, 11, 12}
			// input: n/a
			// expected output: SolitaireDeck object {7A 4 7B 10 18 5 11 12}
			{
				SolitaireCard[] cards = new SolitaireCard[8];
				cards[0] = new SolitaireCard(7,'B');
				cards[1] = new SolitaireCard(7,'A');
				cards[2] = new SolitaireCard(4);
				cards[3] = new SolitaireCard(10);
				cards[4] = new SolitaireCard(18);
				cards[5] = new SolitaireCard(5);
				cards[6] = new SolitaireCard(11);
				cards[7] = new SolitaireCard(12);
				SolitaireDeck testDeck = new SolitaireDeck(cards,6);
				// System.out.println(testDeck.toString());

				testDeck.swapJokerB();
				// System.out.println(testDeck.toString());

				if ( testDeck.toString().equals("7A 4 7B 10 18 5 11 12") ) {
					System.out.println("swapJokerB - jokerB is at top: PASSED");
				} else {
					System.out.println("swapJokerB - jokerB is at top: FAILED");
				}
			}

			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test tripleCut()
			// tripleCut() - bottom card of deck is a joker card
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order, with jokers at bottom of deck
			// input: n/a
			// expected output: SolitaireDeck object {27A, 27B, 1, 2, 3, 4, 5, 6, 7,
			// 8,
			// 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26}
			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.toString());
				testDeck.tripleCut();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("27A 27B 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26") ) {
					System.out
					    .println("tripoleCut() - bottom card is a joker card: PASSED");
				} else {
					System.out.println("tripleCut - bottom card is a joker card: FAILED");
				}
			}
			// tripleCut() - top and bottom cards are both joker cards
			// start state: Solitaire object {7A, 1, 2, 3, 4, 5, 6, 7B}
			// input: n/a
			// expected output: Solitaire object {7A, 1, 2, 3, 4, 5, 6, 7B}
			{
				SolitaireCard[] cards = new SolitaireCard[8];
				cards[0] = new SolitaireCard(7,'A');
				cards[1] = new SolitaireCard(1);
				cards[2] = new SolitaireCard(2);
				cards[3] = new SolitaireCard(3);
				cards[4] = new SolitaireCard(4);
				cards[5] = new SolitaireCard(5);
				cards[6] = new SolitaireCard(6);
				cards[7] = new SolitaireCard(7,'B');

				SolitaireDeck testDeck = new SolitaireDeck(cards,6);
				// System.out.println(testDeck.toString());
				testDeck.tripleCut();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString().equals("7A 1 2 3 4 5 6 7B") ) {
					System.out
					    .println("tripleCut() - joker card on both ends of deck: PASSED");
				} else {
					System.out
					    .println("tripleCut() - joker card on both ends of deck: FAILED");
				}

			}

			// tripleCut() - top card is a joker card
			// start state: SolitaireDeck object {7A, 1, 2, 3, 7B, 5, 6, 4}
			// input: n/a
			// expected output: SolitaireDeck object {5, 6, 4, 7A, 1, 2, 3, 7B}
			{
				SolitaireCard[] cards = new SolitaireCard[8];
				cards[0] = new SolitaireCard(7,'A');
				cards[1] = new SolitaireCard(1);
				cards[2] = new SolitaireCard(2);
				cards[3] = new SolitaireCard(3);
				cards[4] = new SolitaireCard(7,'B');
				cards[5] = new SolitaireCard(5);
				cards[6] = new SolitaireCard(6);
				cards[7] = new SolitaireCard(4);

				SolitaireDeck testDeck = new SolitaireDeck(cards,6);
				// System.out.println(testDeck.toString());
				testDeck.tripleCut();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString().equals("5 6 4 7A 1 2 3 7B") ) {
					System.out
					    .println("tripleCut() - joker card on both ends of deck: PASSED");
				} else {
					System.out
					    .println("tripleCut() - joker card on both ends of deck: FAILED");
				}

			}

			// tripleCut() - joker cards are not next eachother, and not on ends
			// start state: SolitaireDeck object {1, 2, 9B, 3, 4, 5, 9A, 6, 7, 8}
			// input: n/a
			// expected output:SolitaireDeck object with cards in order {6 7 8 9B 3 4
			// 5
			// 9A 1 2}
			{
				SolitaireCard[] cards = new SolitaireCard[10];
				cards[0] = new SolitaireCard(1);
				cards[1] = new SolitaireCard(2);
				cards[2] = new SolitaireCard(9,'B');
				cards[3] = new SolitaireCard(3);
				cards[4] = new SolitaireCard(4);
				cards[5] = new SolitaireCard(5);
				cards[6] = new SolitaireCard(9,'A');
				cards[7] = new SolitaireCard(6);
				cards[8] = new SolitaireCard(7);
				cards[9] = new SolitaireCard(8);

				SolitaireDeck testDeck = new SolitaireDeck(cards,8);
				// System.out.println(testDeck.toString());
				testDeck.tripleCut();
				// System.out.println(testDeck.toString());
				if ( testDeck.toString().equals("6 7 8 9B 3 4 5 9A 1 2") ) {
					System.out
					    .println("tripleCut() - jokers are not next each other, and not on eith end of the deck: PASSED");
				} else {
					System.out
					    .println("tripleCut() - jokers are not next each other, and not on either end of the deck: FAILED");
				}

			}

			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Test countCut(n)
			// countCut(n) - move the top five cards in the deck on top of bottom card
			// in deck
			// start state: SolitaireDeck object with size 26 with cards in ascending
			// order
			// input: 5
			// expected output: SolitaireDeck object with cards in the order {6 7 8 9
			// 10
			// 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 1 2 3 4 5 27B}
			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				// System.out.println(testDeck.toString());
				testDeck.countCut(5);
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 1 2 3 4 5 27B") ) {
					System.out.println("countCut(5): PASSED");
				} else {
					System.out.println("countCut(5): FAILED");

				}
			}
			// countCut(n) - move top card to second from bottom card in deck
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order
			// input: 1
			// expected output: SolitaireDeck object with cards in the order {2 3 4 5
			// 6
			// 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 1 27B}
			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				testDeck.countCut(1);
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27A 1 27B") ) {
					System.out.println("countCut(1): PASSED");
				} else {
					System.out.println("countCut(1): FAILED");

				}
			}
			// countCut(n) - move the top 26 cards to second from bottom card in deck
			// start state: SolitaireDeck object with size 26 and cards in ascending
			// order
			// input: 26
			// expected output: SolitaireDeck object with cards in the order {27A 1 2
			// 3 4 5
			// 6
			// 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27B}
			{
				SolitaireDeck testDeck = new SolitaireDeck(26);
				testDeck.countCut(26);
				// System.out.println(testDeck.toString());
				if ( testDeck.toString()
				    .equals("27A 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27B") ) {
					System.out.println("countCut(26): PASSED");
				} else {
					System.out.println("countCut(26): FAILED");

				}
			}
		}
	}
}
