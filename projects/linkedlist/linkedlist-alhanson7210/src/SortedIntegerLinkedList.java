import java.util.LinkedList;

/**
 * @author UxDeveloperxU
 * @version 1.0
 * A LinkedList of Integers that is always maintained in strict increasing numeric order
 */
public class SortedIntegerLinkedList {
    private LinkedList<Integer> integers = new LinkedList<>();

    /**
     * Command line arguments are not used
     * @param args unused
     */
    public static void main(String[] args) {
        SortedIntegerLinkedList sortedIntegerLinkedList = new SortedIntegerLinkedList();
        try {
            sortedIntegerLinkedList.add(null);
        } catch (IllegalArgumentException e) {
            System.out.print("You attempted to add null! " + e.getMessage() + ".\n");
        }
        System.out.println("Testing adding null.");

        System.out.println("Added: " + sortedIntegerLinkedList.add(126));
        System.out.println("Added: " + sortedIntegerLinkedList.add(12));
        System.out.println("Added: " + sortedIntegerLinkedList.add(34));
        System.out.println("Added: " + sortedIntegerLinkedList.add(196));
        System.out.println("Added: " + sortedIntegerLinkedList.add(12));
        System.out.println("Added: " + sortedIntegerLinkedList.add(50));
        System.out.println("Added: " + sortedIntegerLinkedList.add(200));
        System.out.println("Added: " + sortedIntegerLinkedList.add(2));

        System.out.print("Sorted LinkedList: ");
        System.out.println(sortedIntegerLinkedList.toString());
        System.out.print("Getting index 4: ");
        System.out.println(sortedIntegerLinkedList.get(4));
        System.out.print("Getting index 2: ");
        System.out.println(sortedIntegerLinkedList.get(2));
        System.out.print("Size of sorted list: ");
        System.out.println(sortedIntegerLinkedList.size());
        System.out.print("Index of element 12: ");
        System.out.println(sortedIntegerLinkedList.indexOf(12));
        System.out.print("Last index of element 12: ");
        System.out.println(sortedIntegerLinkedList.lastIndexOf(12));
        System.out.println("Removed element 12: " + sortedIntegerLinkedList.remove(12));
        System.out.println(sortedIntegerLinkedList.toString());
    }

    /**
     * Adds the element in sorted order into the LinkedList
     * @param element integer to add
     * @return -integer that has been successfully added
     * @throws IllegalArgumentException The element can not be null
     */
    private int add(Integer element) throws IllegalArgumentException {
        //special cases
        if (element == null) {
            integers.remove(null);
            throw new IllegalArgumentException("The element can not be null");
        }

        if (integers.size() == 0) {
            integers.add(element);
            return element;
        }

        if (integers.size() == 1) {
            if (integers.get(0) < element) {
                integers.set(1,element);
                return element;
            }
            else {
                integers.add(0,element);
                return element;
            }
        }

        if (integers.contains(element)) {
            integers.add(integers.indexOf(element),element);
            return element;
        }

        if (element > integers.getLast()) {
            integers.add(element);
            return element;
        }

        if (element < integers.getFirst()) {
            integers.offerFirst(element);
            return element;
        }
        //normal sorting
        int count = 0;
        while (count < integers.size()) {
            int temp = count + 1;
            if (temp != integers.size()) {
                if (element > integers.get(count) && element < integers.get(temp)) {
                    integers.add(temp,element);
                    return element;
                }
                else {
                    count++;
                }
            }
        }
        return element;
    }

    /**
     * Get the value at the specified index
     * @param index -index of the search element
     * @return specific element at a given index
     * @throws IndexOutOfBoundsException similar to java.util.LinkedList.get
     */
    private Integer get(int index) throws IndexOutOfBoundsException {
        return integers.get(index);
    }

    /**
     * Get the index of the specified element
     * @param element search element
     * @return - index of the search element
     */
    private int indexOf(Integer element) {
        return integers.indexOf(element);
    }

    /**
     * Get the index of the specified element last occurrence
     * @param element search element
     * @return index of the search element reverse indexing
     */
    private int lastIndexOf(Integer element) {
        return integers.lastIndexOf(element);
    }

    /**
     * Remove a given element
     * @param element search element
     * @return boolean of the removed element's status
     */
    private boolean remove(Integer element) {
        if (integers.contains(element)){
            integers.remove(element);
            return true;
        }
        return false;
    }

    /**
     * Size of the sorted list
     * @return number of elements in the list
     */
    private int size() {
        return integers.size();
    }

    /**
     * Sorted array of integers initially used for testing
     * @return fixed array of sorted integers
     */
    private Integer[] getIntegers() {
        return integers.toArray(new Integer[0]);
    }

    /**
     * String representing the class and linked list
     * @return formatted string of the class and linked list
     */
 @Override
    public String toString() {
        return String.format("(%s) %s.", this.getClass().getSimpleName(), integers);
    }
}