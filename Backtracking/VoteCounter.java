import java.util.Scanner;

/**
 * Asks the user for the number of blocks and the number of votes each block has
 * there are only two possible choices that the votes can go to then computes
 * and displays how often each block casts the swing vote in an election
 * 
 * @author Camera Finn
 */

public class VoteCounter {
	private static int[] block_; // array of blocks
	private static int choice1_, choice2_;
	// instance variables - stores number of votes for each of the 2 possible
	// choices
	private static int total_;
	// instance variable - total votes among all blocks

	public static void main ( String[] args ) {
		// prompt user for number of blocks and number of votes allocated to
		// each block
		// Scanner userInput = new Scanner(System.in);

		System.out.print("how many blocks? ");
		Scanner userInput = new Scanner(System.in);
		block_ = new int[userInput.nextInt()]; // number of blocks = 4
		System.out.print("enter votes for each block: ");
		for ( int i = 0 ; i < block_.length ; i++ ) {
			block_[i] = userInput.nextInt();
			total_ += block_[i];
		}
		userInput.close();
		System.out.println("\n" + "frequency of swing votes:");
		for ( int i = 0 ; i < block_.length ; i++ ) {
			System.out.println("block " + i + ": " + countCritical(block_,i));
		}
	}

	/**
	 * Determines how often the "block of interest" swings the election
	 * 
	 * @param votes
	 *          - integer array
	 * @param block
	 *          - block in question
	 * @return the total number of times (situation) that the block in interest is
	 *         a swing block
	 * @Pre-condition: block is not negative and is less than the length of the
	 *                 vote array
	 * @Post-condition: return value is a positive value
	 */
	public static int countCritical ( int[] votes, int block ) {
		if ( block >= 0 && block < votes.length ) {
			assert helper(votes,0,block) >= 0 : "cannot be negative";
			return helper(votes,0,block);
		} else {
			throw new IllegalArgumentException("block doesn't exist");
		}
	}

	/**
	 * Helper method for the countCritical method does the recursive backtracking
	 * counts the amount of situations in which the block in question is a swing
	 * block
	 * 
	 * @param block
	 *          - array of the blocks involved
	 * @param currentBlock
	 *          - the current block being addressed
	 * @param mainBlock
	 *          - the block of interest
	 * @return 1 if the block in question is a swing block in the situation
	 * @Pre-condition: the mainBlock is an existing element of the block array the
	 *                 currentBlock is not the mainBlock the block array is not
	 *                 empty
	 * @Post-condition: the value returned is a natural number
	 */
	private static int helper ( int[] block, int currentBlock, int mainBlock ) {
		if ( mainBlock > block.length && block.length != 0 ) {
			throw new IndexOutOfBoundsException("block doesn't exist");
		}
		if ( swingBlock() && choice1_ + choice2_ == total_ - block[mainBlock] ) {
			return 1;
		} else {
			int swingNum = 0; // counter for number of times mainBlock is a swingBlock
			if ( currentBlock == mainBlock ) {
				currentBlock += 1;
			}
			for ( int i = 0 ; i < 2 ; i++ ) {
				if ( i == 0 ) {
					choice1_ += block[currentBlock];
				} else {
					choice1_ -= block[currentBlock];
					choice2_ += block[currentBlock];
				}
				if ( swingBlock() ) {
					swingNum += helper(block,currentBlock + 1,mainBlock);
				}
			}
			choice2_ -= block[currentBlock];
			assert swingNum >= 0 : "invalid swing bumber";
			return swingNum;
		}
	}

	/**
	 * Determines if block in question is a swing block
	 * 
	 * @param choice1
	 * @param choice2
	 * @param blockVotes:
	 *          number of votes for the block in question
	 * @return true if the block's votes determines the winner and false otherwise
	 */
	private static boolean swingBlock () {
		if ( choice1_ > total_ / 2 || choice2_ > total_ / 2 ) {
			return false;
		} else return true;
	}
}
