import java.util.TreeSet;
import java.util.Set;
/**
 * Class for boggle solver.
 */
public class BoggleSolver {
	/**
	 * object creation for TrieST.
	 */
	TrieST<Integer>tri = new TrieST<Integer>();

	private boolean[][] marked;

	/**
	 * Constructs the object.
	 *
	 * @param      dictionary  The dictionary.
	 */
	public BoggleSolver(final String[] dictionary) {
		int score;
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].length() == 3 || dictionary[i].length() == 4) {
				score = 1;
			} else if (dictionary[i].length() == 5) {
				score = 2;
			} else if (dictionary[i].length() == 6) {
				score = 3;
			} else if (dictionary[i].length() == 7) {
				score = 5;
			} else if (dictionary[i].length() >= 8) {
				score = 11;
			} else {
				score = 0;
			}
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.

	/**
	 * Gets all valid words.
	 *
	 * @param      board  The board.
	 *
	 * @return     All valid words.
	 */
	public Iterable<String> getAllValidWords(final BoggleBoard board) {
		if (board == null) {
			throw new IllegalArgumentException("board is null");
		}
		return new Bag<String>();
	}

	private boolean isVaildWord(final String word) {
		if (word.length() < 3) {
			return false;
		}
		return tri.contains(word);
	}

	private String appendCharacter(String ac, char c) {
		if (c == 'Q') {
			ac += "QU";
			return ac;
		} else {
			ac += c;
			return ac;
		}
	}

	/**
	 * { function_description }.
	 *
	 * @param      board   The board
	 * @param      marked  The marked
	 * @param      rows    The rows
	 * @param      cols    The cols
	 * @param      word    The word
	 */
	/*public void dfs(final BoggleBoard board, final boolean[][] marked,
	                final int rows, final int cols, final String word) {

	}*/

	/*private boolean isValidRowColumn(final int row, final int col,
	                                 final BoggleBoard board) {
	}*/

	/**
	 * { function_description }.
	 *
	 * @param      word  The word.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int scoreOf(String word) {
		if (tri.contains(word)) {
			return tri.get(word);
		}
		return 0;
	}
}
