
/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private class QueueIterator implements Iterator<Item> {
        private int curr;
        private Item[] shuffled;

        public QueueIterator() {
            curr = 0;
            copyArr();
            StdRandom.shuffle(shuffled);
        }

        private void copyArr() {
            shuffled = (Item[]) new Object[tail];
            for (int i = 0; i < tail; i++) {
                shuffled[i] = queueList[i];
            }
        }

        @Override
        public boolean hasNext() {
            return curr < tail;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            return shuffled[curr++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int tail;
    private Item[] queueList;

    public RandomizedQueue() {
        // construct an empty randomized queue
        tail = 0;
        queueList = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        // is the randomized queue empty?
        return tail == 0;
    }

    public int size() {
        // return the number of items on the randomized queue
        return tail;
    }

    private void resize(int newSize) {
        // given new size, resize the original array
        Item[] temp = Arrays.copyOfRange(queueList, 0, newSize);
        queueList = temp;
    }

    public void enqueue(Item item) {
        // add the item
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (tail == queueList.length) {
            this.resize(queueList.length * 2);
        }

        queueList[tail++] = item;
    }

    public Item dequeue() {
        // remove and return a random item
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (tail <= queueList.length / 4) {
            resize(queueList.length / 2);
        }

        int r = StdRandom.uniform(0, tail);
        Item temp = queueList[r];
        queueList[r] = queueList[--tail];
        // avoid loitering
        queueList[tail] = null;

        return temp;
    }

    public Item sample() {
        // return a random item (but do not remove it)
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return queueList[StdRandom.uniform(0, tail)];
    }

    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new QueueIterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(12);

        Iterator<Integer> it1 = queue.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        queue.sample();
    }
}
