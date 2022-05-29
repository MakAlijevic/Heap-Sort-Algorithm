package ibu.edu;

public class BinaryHeap<Item extends Comparable<Item>> {

    public Item[] pq = (Item[]) new Comparable[2];
    public int length = 0;

    /* Insert a new element into the priority queue */
    public void insert(Item data) {
        if (pq.length == length + 1) {
            resize(2 * pq.length);
        }
        pq[++length] = data;
        swim(length);
    }

    /* Node promotion:
     * swim up a node to its correct position */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    /* Remove the maximum (max. priority) item  */
    public Item delMax() {
        Item max = pq[1];
        swap(1, length--);
        pq[length + 1] = null;

        if (length > 0 && length == pq.length / 4) {
            resize(pq.length / 2);
        }

        sink(1);
        return max;
    }

    /* Node demotion:
     * sink down a node to its correct position */
    private void sink(int k) {
        while (2*k <= length) {
            int j = 2 * k;
            if (j < length && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    /* Create a new internal array with a given capacity */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Comparable[capacity];
        for (int i = 1; i <= length; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    /* Check which of the two elements is smaller */
    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    /* Swap the array elements at provided indexes */
    private void swap(int a, int b) {
        Item temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

}
