/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * number of elements in bag.
     */
    private int N;
    /**
     * beginning of bag.
     */
    private Node first;

    /**
     * Class for node.
     */
    private class Node {
        /**
         * { var_description }.
         */
        private Item item;
        /**
         * { var_description }.
         */
        private Node next;
    }

    /**
      * Create an empty stack.
      */
    public Bag() {
        first = null;
        N = 0;
    }

    /**
      * Is the BAG empty?
      *
      * @return     True if empty, False otherwise.
      */
    public boolean isEmpty() {
        return first == null;
    }

    /**
      * Return the number of items in the bag.
      *
      * @return     { description_of_the_return_value }.
      */
    public int size() {
        return N;
    }

    /**
      * Add the item to the bag.
      *
      * @param      item  The item.
      */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current Node.
         */
        private Node current = first;

        public boolean hasNext()  { return current != null; }
        public void remove()  { throw new UnsupportedOperationException(); }

        /**
         * { function_description }.
         *
         * @return     { description_of_the_return_value }.
         */
        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); } {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }
}


