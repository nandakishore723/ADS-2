public class BoggleSolver {
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)

    TST<Integer> tst = new TST<Integer>();

    /**
     * Constructs the object.
     *
     * @param      dictionary  The dictionary
     */
    public BoggleSolver(String[] dictionary) {
        int score;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() == 0) {
                System.out.println("board is null");
            } else if (dictionary[i].length() == 2 || dictionary[i].length() == 1) {
                score = 0;
            } else if (dictionary[i].length() == 3 || dictionary[i].length() == 4) {
                score = 1;
            } else if (dictionary[i].length() == 5) {
                score = 2;
            } else if (dictionary[i].length() == 6) {
                score = 3;
            } else if (dictionary[i].length() == 7) {
                score = 5;
            } else {
                score = 11;
            }
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.

    /**
     * Gets all valid words.
     *
     * @param      board  The board
     *
     * @return     All valid words.
     */
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        return new Bag<String>();
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)

    /**
     * { function_description }.
     *
     * @param      word  The word
     *
     * @return     { description_of_the_return_value }.
     */
    public int scoreOf(String word) {
        if (tst.contains(word) == true) {
            return tst.get(word);
        } else {
            return 0;
        }
    }
}
