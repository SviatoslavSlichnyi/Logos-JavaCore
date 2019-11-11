package specialtasks.collections.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList linkedList = new MyLinkedList();


    // Add element to linked list tests
    @Test
    public void addOneElementTest() {
        boolean add = linkedList.add(10);

        assertTrue(add);
        assertEquals(linkedList.size(), 1);
    }
    @Test public void addTwoElementsTest() {
        linkedList.add(10);
        linkedList.add(20);

        assertEquals(linkedList.size(), 2);
    }
    @Test public void addFiveElementsTest() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        assertEquals(linkedList.size(), 5);
    }



    // Get element from linked list tests
    @Test public void getOneElementTest() {
        int element = 10;
        linkedList.add(element);
        int size = linkedList.size();

        Integer stored = linkedList.get(0);

        assertEquals(element, stored.intValue());
        assertEquals(size, linkedList.size());
    }
    @Test public void getOneFormFirstPartElementTest() {
        int element = 10;
        linkedList.add(3);
        linkedList.add(element);
        linkedList.add(20);
        linkedList.add(30);

        int size = linkedList.size();

        Integer stored = linkedList.get(1);

        assertEquals(element, stored.intValue());
        assertEquals(size, linkedList.size());
    }
    @Test public void getOneFormSecondPartElementTest() {
        int element = 10;
        linkedList.add(3);
        linkedList.add(20);
        linkedList.add(element);
        linkedList.add(30);

        int size = linkedList.size();

        Integer stored = linkedList.get(2);

        assertEquals(element, stored.intValue());
        assertEquals(size, linkedList.size());
    }
    @Test public void getOneLastElementTest() {
        int element = 10;
        linkedList.add(3);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(element);

        int size = linkedList.size();

        Integer stored = linkedList.get(3);

        assertEquals(element, stored.intValue());
        assertEquals(size, linkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOneFromEmptyListTest() {

        linkedList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOneOutOfBoundTest() {
        linkedList.add(10);
        linkedList.add(20);

        linkedList.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOneByNegativeIndex() {

        linkedList.get(-1);
    }



    // Add element by position to linked list tests
    @Test public void addAsFirstInEmptyTest() {
        int element = 10;
        int index = 0;
        linkedList.add(index, element);

        assertEquals(linkedList.size(), 1);
        assertEquals(element, linkedList.get(index));
        assertEquals(linkedList.size(), 1);
    }
    @Test public void addAsFirstInNotEmptyTest() {
        int element = 10;
        int index = 0;
        linkedList.add(3);
        linkedList.add(5);
        assertEquals(linkedList.size(), 2);

        linkedList.add(index, element);

        assertEquals(linkedList.size(), 3);
        assertEquals(element, linkedList.get(index));
        assertEquals(linkedList.size(), 3);
        assertEquals(3, linkedList.get(1));
        assertEquals(5, linkedList.get(2));
    }
    @Test public void addAsLastInNotEmptyTest() {
        int element = 10;
        int index = 2;
        linkedList.add(3);
        linkedList.add(5);
        assertEquals(linkedList.size(), 2);

        linkedList.add(index, element);

        assertEquals(linkedList.size(), 3);
        assertEquals(element, linkedList.get(index));
        assertEquals(linkedList.size(), 3);
        assertEquals(3, linkedList.get(0));
        assertEquals(5, linkedList.get(1));
    }
    @Test public void addInTheMiddleInNotEmptyTest() {
        int element = 10;
        int index = 1;
        linkedList.add(3);
        linkedList.add(5);
        assertEquals(linkedList.size(), 2);

        linkedList.add(index, element);

        assertEquals(linkedList.size(), 3);
        assertEquals(element, linkedList.get(index));
        assertEquals(linkedList.size(), 3);
        assertEquals(3, linkedList.get(0));
        assertEquals(5, linkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addByIndexInEmptyOutOfBoundTest() {

        linkedList.add(1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addByIndexInNotEmptyOutOfBoundTest() {
        linkedList.add(2);
        linkedList.add(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addByIndexInNotEmptyNegativeIndexTest() {
        linkedList.add(2);
        linkedList.add(-1, 1);
    }



    // Set element at position to linked list tests
    @Test public void setAsFirstToListTest() {
        linkedList.add(10);
        linkedList.add(20);
        int size = linkedList.size();
        assertEquals(size, linkedList.size());

        Integer stored = linkedList.set(0, 7);

        assertEquals(10, stored.intValue());
        assertEquals(size, linkedList.size());
        assertEquals(7, linkedList.get(0));
    }
    @Test public void setInTheMiddleToListTest() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        int size = linkedList.size();
        assertEquals(size, linkedList.size());

        Integer stored = linkedList.set(1, 7);

        assertEquals(20, stored.intValue());
        assertEquals(size, linkedList.size());
        assertEquals(7, linkedList.get(1));
    }
    @Test public void setAsLastToListTest() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        int size = linkedList.size();
        assertEquals(size, linkedList.size());

        Integer stored = linkedList.set(2, 7);

        assertEquals(30, stored.intValue());
        assertEquals(size, linkedList.size());
        assertEquals(7, linkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setAsFirstToEmptyListTest() {
        assertEquals(0, linkedList.size());

        linkedList.set(0, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setToNotEmptyListOutOfBoundTest() {
        linkedList.add(10);
        linkedList.add(20);
        assertEquals(2, linkedList.size());

        linkedList.set(2, 1);
    }



    // Remove by index from linked list tests
    @Test public void removeFirstTest() {
        linkedList.add(10);
        linkedList.add(20);
        int size = linkedList.size();

        Integer stored = linkedList.remove(0);

        assertEquals(10, stored.intValue());
        assertEquals(size - 1, linkedList.size());
        assertEquals(20, linkedList.get(0));
    }
    @Test public void removeFromMiddleTest() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        int size = linkedList.size();

        Integer stored = linkedList.remove(1);

        assertEquals(20, stored.intValue());
        assertEquals(size - 1, linkedList.size());
        assertEquals(30, linkedList.get(1));
    }
    @Test public void removeLastTest() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        int size = linkedList.size();

        Integer stored = linkedList.remove(2);

        assertEquals(30, stored.intValue());
        assertEquals(size - 1, linkedList.size());
        assertEquals(20, linkedList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNegativeIndexTest() {
        linkedList.add(10);

        linkedList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeOutOfBoundIndexTest() {
        linkedList.add(10);

        linkedList.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLastAndAskLastTest() {
        linkedList.add(10);
        linkedList.add(20);

        linkedList.remove(1);

        linkedList.get(1);
    }



    // Clear linked list tests
    @Test public void clearEmptyListTest() {
        assertEquals(0, linkedList.size());

        linkedList.clear();

        assertEquals(0, linkedList.size());
    }
    @Test public void clearNotEmptyListTest() {
        linkedList.add(10);
        assertEquals(1, linkedList.size());

        linkedList.clear();

        assertEquals(0, linkedList.size());
    }

}