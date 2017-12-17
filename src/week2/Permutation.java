package week2;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 12/8/17
 * Time: 5:44 PM
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);


        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
