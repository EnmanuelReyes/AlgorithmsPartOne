package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 12/4/17
 * Time: 8:39 AM
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first = null;
    private Node last = null;
    private int size;

    public Deque() {
    }                  // construct an empty deque

    public boolean isEmpty() {
        return first == null || last == null;
    }                 // is the deque empty?

    public int size() {
        return size;
    }  // return the number of items on the deque

    public void addFirst(Item item) { // add the item to the front
        validateAdd(item);
        size++;
        Node node = new Node();
        node.setNext(first);
        node.setItem(item);
        if (first != null)
            first.setPrev(node);
        first = node;
        if (last == null) last = first;

    }

    public void addLast(Item item) { // add the item to the end
        validateAdd(item);
        size++;
        Node node = new Node();
        node.setItem(item);
        if (last != null) {
            last.setNext(node);
            node.setPrev(last);
        }
        last = node;
        if (first == null) first = last;

    }

    public Item removeFirst() { // remove and return the item from the front
        validateRemove();
        size--;
        Item item = this.first.getItem();
        this.first = this.first.getNext();
        return item;
    }

    public Item removeLast() { // remove and return the item from the end
        validateRemove();
        size--;
        Item item = this.last.getItem();
        this.last = this.last.getPrev();
        if (this.last != null)
            this.last.setNext(null);
        return item;
    }

    private void validateAdd(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
    }


    private void validateRemove() {
        if (isEmpty())
            throw new NoSuchElementException();
    }


    public Iterator<Item> iterator() {
        return new DequeIterator();
    }         // return an iterator over items in order from front to end


    private class Node {
        private Item item;
        private Node next;
        private Node prev;


        public Item getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setItem(Item i) {
            this.item = i;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public void setPrev(Node p) {
            this.prev = p;
        }
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.getItem();
            current = current.getNext();
            return item;
        }
    }


    public static void main(String[] args) { // unit testing (optional)
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.removeLast();
    }
}