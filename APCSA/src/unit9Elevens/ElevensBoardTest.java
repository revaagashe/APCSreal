package unit9Elevens;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoardTest extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	public ElevensBoardTest() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		System.out.println("Reva Agashe \nPeriod 4\n3/28/18\nComputer 35");

	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		/*if (selectedCards.size() == 2){
			if (containsPairSum11(selectedCards)){
				return true;
			}
			if (containsDoubleFace(selectedCards)){
				return true;
			}
		}
		else if (selectedCards.size() == 3){
			if (containsJQK(selectedCards)){
				return true;
			}
			if (containsTripleSum11(selectedCards)){
				return true;
			}
		}

		return false;*/

	if (containsTripleSum11(selectedCards)){
		return true;
	}



	 if (containsDoubleFace(selectedCards)){
		 return true;
	 }



		
		
		return false;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {

		
		 if (containsTripleSum11(cardIndexes()))
			return true;

		else if (containsDoubleFace(cardIndexes()))
			return true;
		
		
		return false;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}


	/**
	 * Deal cards to this board to start the game.
	 */


	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	/*private boolean containsPairSum11(List<Integer> selectedCards) {
		if (selectedCards.size() == 2){
			for (int x : selectedCards){
				for (int y : selectedCards){
					if (cards[x].pointValue() + cards[y].pointValue() == 11){
						return true;
					}
				}
			}	
		}
		return false;
	}*/
	private boolean containsTripleSum11(List<Integer> selectedCards) {

		 if (selectedCards.size() == 3){
			if (selectedCards.get(0) + selectedCards.get(1) + selectedCards.get(2) == 11){
				return true;
			}
			 
			 /*for (int x : selectedCards){
				for (int y : selectedCards){
					for (int z : selectedCards){
					
							if (cards[x].pointValue() + cards[y].pointValue() + cards[z].pointValue()== 11){
								return true;
							}		
						
	
					}

				}
			}
		}*/
			 
			 
		
		 }
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	/*private boolean containsJQK(List<Integer> selectedCards) {
		for (int x : selectedCards){
			for (int y : selectedCards){
				for (int z : selectedCards){
					if (cards[x].pointValue() + cards[y].pointValue() + cards[z].pointValue() == 0){
						return true;
					}	
				}

			}
		}
		
		return false;}*/
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	
	
	private boolean containsDoubleFace(List<Integer> selectedCards) {
		
			for (int x : selectedCards){
				for (int y : selectedCards){
					if (cardAt(x).rank() == cardAt(y).rank()){
						if ((cardAt(x).rank() == "jack" )){
							return true;

						}
						else if (cardAt(x).rank() == "queen"){
							return true;
						}
						else if (cardAt(x).rank() == "king")
							return true;
					}
					return false;
				}
				
		}
			return false;

		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}
	public static void printCards(ElevensBoardTest board){
		List<Integer> cardIndexes=  board.cardIndexes();
		for (Integer x: cardIndexes){
			System.out.println(board.cardAt(x));
		}
	}
}
