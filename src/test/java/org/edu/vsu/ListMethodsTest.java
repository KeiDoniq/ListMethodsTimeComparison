package org.edu.vsu;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListMethodsTest {
    ListMethods linkedListMethods = new ListMethods(LinkedList.class,10);
    ListMethods arrayListMethods = new ListMethods(ArrayList.class,10);
    @Test
    void addToHeadLinkedList() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(
                9,8,7,6,5,4,3,2,1,0));//,1,2,3,4,5,6,7,8,9;
        linkedListMethods.addToHead();
        assertIterableEquals(expected,linkedListMethods.list);
    }@Test
    void addToHeadArrayList() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(
                9,8,7,6,5,4,3,2,1,0));
        arrayListMethods.addToHead();
        assertIterableEquals(expected,arrayListMethods.list);
    }
    @Test
    void addToTailArrayList() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(
                0,1,2,3,4,5,6,7,8,9));
        arrayListMethods.addToTail();
        assertIterableEquals(expected,arrayListMethods.list);
    }@Test
    void addToTailLinkedList() {
        List<Integer> expected = new LinkedList<>(Arrays.asList(
                0,1,2,3,4,5,6,7,8,9));
        linkedListMethods.addToTail();
        assertIterableEquals(expected,linkedListMethods.list);
    }
    @Test
    void addByValueLinkedList() {
        List<Integer> expected = new LinkedList<>();
        for(int i = 0; i < 10; i++)
            expected.add(i);
        linkedListMethods.addByValue();
        assertIterableEquals(expected,linkedListMethods.list);
    }
    @Test
    void addByValueArrayList() {
        List<Integer> expected = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            expected.add(i);
        arrayListMethods.addByValue();
        assertIterableEquals(expected,arrayListMethods.list);
    }
    @Test
    void addToRandomArrayList() {
        arrayListMethods.addToRandom();
        for(int i = 0; i < 10; i++){
            assertTrue(arrayListMethods.list.contains(i));
        }
    }
    @Test
    void addToRandomLinkedList() {
        linkedListMethods.addToRandom();
        for(int i = 0; i < 10; i++){
            assertTrue(linkedListMethods.list.contains(i));
        }
    }
    @Test
    void deleteFromHeadLinked() {
        linkedListMethods.addByValue();
        assertEquals(10, linkedListMethods.list.size());
        linkedListMethods.deleteFromHead();
        assertEquals(0, linkedListMethods.list.size());
    }
    @Test
    void deleteFromHeadArray() {
        arrayListMethods.addByValue();
        assertEquals(10, arrayListMethods.list.size());
        arrayListMethods.deleteFromHead();
        assertEquals(0, arrayListMethods.list.size());
    }
    @Test
    void deleteFromTailLinked() {
        linkedListMethods.addByValue();
        assertEquals(10, linkedListMethods.list.size());
        linkedListMethods.deleteFromTail();
        assertEquals(0, linkedListMethods.list.size());
    }
    @Test
    void deleteFromTailArray() {
        arrayListMethods.addByValue();
        assertEquals(10, arrayListMethods.list.size());
        arrayListMethods.deleteFromTail();
        assertEquals(0, arrayListMethods.list.size());
    }
    @Test
    void deleteFromRandomArrayList() {
        arrayListMethods.addByValue();
        assertEquals(10, arrayListMethods.list.size());
        arrayListMethods.deleteFromRandom();
        assertEquals(0, arrayListMethods.list.size());
    }
    @Test
    void deleteFromRandomLinkedList() {
        linkedListMethods.addByValue();
        assertEquals(10, linkedListMethods.list.size());
        linkedListMethods.deleteFromRandom();
        assertEquals(0, linkedListMethods.list.size());
    }
    @Test
    void clearLinkedList() {
        linkedListMethods.addByValue();
        assertEquals(10, linkedListMethods.list.size());
        linkedListMethods.clear();
        assertEquals(0, linkedListMethods.list.size());
    }
    @Test
    void clearArrayList() {
        arrayListMethods.addByValue();
        assertEquals(10, arrayListMethods.list.size());
        arrayListMethods.clear();
        assertEquals(0, arrayListMethods.list.size());
    }
    private int[] arrayInAscendingOrder = {0,1,2,3,4,5,6,7,8,9};
    @Test
    void compareLess() {
        for(int i = 0; i<arrayInAscendingOrder.length-1; i++){
            assertEquals(1, ListMethods.compare(arrayInAscendingOrder[i],
                    arrayInAscendingOrder[i + 1]));
        }
    }
    @Test
    void compareGreater() {
        for(int i = arrayInAscendingOrder.length-1; i>0; i--){
            assertEquals(-1, ListMethods.compare(arrayInAscendingOrder[i],
                    arrayInAscendingOrder[i - 1]));
        }
    }
    @Test
    void compareEqual() {
        for (int elem : arrayInAscendingOrder) {
            assertEquals(0, ListMethods.compare(elem, elem));
        }
    }
}