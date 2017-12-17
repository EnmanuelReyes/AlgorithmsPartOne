package week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 12/8/17
 * Time: 5:19 PM
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int size;
    private int capacity;

    public RandomizedQueue() {            // construct an empty randomized queue
        size = 0;
        capacity = 1;
        q = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }               // is the randomized queue empty?

    public int size() {
        return size;
    }                        // return the number of items on the randomized queue

    public void enqueue(Item item) {  // add the item
        if (size+1 == q.length) resize(q.length * 2);
        q[size++] = item;

    }

    public Item dequeue() {
        int i = StdRandom.uniform(size);
        Item item = q[i];
        q[i] = q[--size];
        q[size] = null;

        if (size > 0 && size == q.length / 4) resize(q.length / 2);
        return item;
    }                   // remove and return a random item

    public Item sample() {
        return q[StdRandom.uniform(size)];
    }                    // return a random item (but do not remove it)

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = q[i];
        }
        q = copy;
        this.capacity = capacity;
    }


    @Override
    public Iterator<Item> iterator() { // return an independent iterator over items in random order
        return new RandomizedIterator();
    }

    public static void main(String[] args) {
    }  // unit testing (optional)

    private class RandomizedIterator implements Iterator<Item> {

        Item[] copy;
        int current;

        public RandomizedIterator() {
            copy = Arrays.copyOf(q,size);

            StdRandom.shuffle(copy);
        }

        @Override
        public boolean hasNext() {
            return current < copy.length;
        }

        @Override
        public Item next() {
            return copy[current++];
        }
    }

}
