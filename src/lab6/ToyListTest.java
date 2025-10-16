package lab6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToyListTest {

    private Toy<String> lego;
    private Toy<String> barbie;
    private Toy<String> hotWheels;
    private ToyList<String> toyList;

    @BeforeEach
    void setUp() {
        lego = new Toy<>("LEGO Star Wars", 1500, "10+");
        barbie = new Toy<>("Barbie", 700, "5+");
        hotWheels = new Toy<>("Hot Wheels", 250, "6+");
        toyList = new ToyList<>();
    }

    @Test
    void testEmptyConstructor() {
        ToyList<String> list = new ToyList<>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testSingleToyConstructor() {
        ToyList<String> list = new ToyList<>(lego);
        assertEquals(1, list.size());
        assertEquals(lego, list.get(0));
    }

    @Test
    void testCollectionConstructor() {
        ToyList<String> list = new ToyList<>(Arrays.asList(lego, barbie));
        assertEquals(2, list.size());
        assertEquals(lego, list.get(0));
        assertEquals(barbie, list.get(1));
    }

    @Test
    void testEnsureCapacity() {
        for (int i = 0; i < 20; i++) {
            toyList.add(new Toy<>("Toy" + i, i * 10, "0+"));
        }

        assertEquals(20, toyList.size());
        assertDoesNotThrow(() -> toyList.add(new Toy<>("Extra", 100, "0+")));
    }

    @Test
    void testCheckIndex() {
        toyList.add(lego);
        toyList.add(barbie);

        assertThrows(IndexOutOfBoundsException.class, () -> toyList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> toyList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> toyList.set(5, hotWheels));
        assertThrows(IndexOutOfBoundsException.class, () -> toyList.remove(3));
    }

    @Test
    void testAddAndGetSize() {
        assertTrue(toyList.add(lego));
        assertTrue(toyList.add(barbie));
        assertEquals(2, toyList.size());
        assertEquals(lego, toyList.get(0));
        assertEquals(barbie, toyList.get(1));
    }

    @Test
    void testIsEmpty() {
        assertTrue(toyList.isEmpty());
        toyList.add(lego);
        assertFalse(toyList.isEmpty());
    }

    @Test
    void testSet() {
        toyList.add(lego);
        Toy<String> old = toyList.set(0, barbie);
        assertEquals(lego, old);
        assertEquals(barbie, toyList.get(0));
    }

    @Test
    void testAddAtIndex() {
        toyList.add(lego);
        toyList.add(barbie);
        toyList.add(1, hotWheels);
        assertEquals(hotWheels, toyList.get(1));
        assertEquals(3, toyList.size());
    }

    @Test
    void testRemoveByIndex() {
        toyList.add(lego);
        toyList.add(barbie);
        Toy<String> removed = toyList.remove(0);
        assertEquals(lego, removed);
        assertEquals(1, toyList.size());
        assertEquals(barbie, toyList.get(0));
    }

    @Test
    void testRemoveByObject() {
        toyList.add(lego);
        toyList.add(barbie);
        assertTrue(toyList.remove(barbie));
        assertFalse(toyList.remove(hotWheels));
        assertEquals(1, toyList.size());
    }

    @Test
    void testClear() {
        toyList.add(lego);
        toyList.add(barbie);
        toyList.clear();
        assertEquals(0, toyList.size());
        assertTrue(toyList.isEmpty());
    }

    @Test
    void testContainsAndIndexOf() {
        toyList.add(lego);
        toyList.add(barbie);
        assertTrue(toyList.contains(barbie));
        assertEquals(1, toyList.indexOf(barbie));
        assertEquals(-1, toyList.indexOf(hotWheels));
    }

    @Test
    void testLastIndexOf() {
        toyList.add(lego);
        toyList.add(barbie);
        toyList.add(lego);
        assertEquals(2, toyList.lastIndexOf(lego));
    }


    @Test
    void testToArray() {
        toyList.add(lego);
        toyList.add(barbie);
        Object[] array = toyList.toArray();
        assertArrayEquals(new Object[]{lego, barbie}, array);

        Toy<String>[] arr = new Toy[2];
        Toy<String>[] result = toyList.toArray(arr);
        assertArrayEquals(new Toy[]{lego, barbie}, result);

        Toy<String>[] small = new Toy[1];
        Toy<String>[] newResult = toyList.toArray(small);
        assertArrayEquals(new Toy[]{lego, barbie}, newResult);
    }

    @Test
    void testToArrayWithSufficientArray() {
        toyList.add(lego);
        Toy<String>[] arr = new Toy[1];
        Toy<String>[] result = toyList.toArray(arr);
        assertEquals(1, result.length);
        assertEquals(lego, result[0]);
        assertSame(arr, result);
    }

    @Test
    void testToArrayWithSmallerArray() {
        toyList.add(lego);
        Toy<String>[] small = new Toy[0];
        Toy<String>[] result = toyList.toArray(small);
        assertEquals(1, result.length);
        assertEquals(lego, result[0]);
        assertInstanceOf(Toy[].class, result);
    }

    @Test
    void testContainsAll() {
        toyList.addAll(Arrays.asList(lego, barbie));
        assertTrue(toyList.containsAll(Arrays.asList(lego)));
        assertFalse(toyList.containsAll(Arrays.asList(hotWheels)));
    }

    @Test
    void testAddAll() {
        assertTrue(toyList.addAll(Arrays.asList(lego, barbie)));
        assertEquals(2, toyList.size());

        ToyList<String> other = new ToyList<>();
        other.addAll(Arrays.asList(lego, barbie));
        assertEquals(2, other.size());
    }

    @Test
    void testAddAllAtIndex() {
        toyList.add(lego);
        toyList.add(barbie);
        assertTrue(toyList.addAll(1, Collections.singletonList(hotWheels)));
        assertEquals(hotWheels, toyList.get(1));
    }

    @Test
    void testRemoveAll() {
        toyList.addAll(Arrays.asList(lego, barbie, hotWheels));
        assertTrue(toyList.removeAll(Arrays.asList(barbie, hotWheels)));
        assertEquals(1, toyList.size());
        assertEquals(lego, toyList.get(0));
    }

    @Test
    void testRetainAll() {
        toyList.addAll(Arrays.asList(lego, barbie, hotWheels));
        assertTrue(toyList.retainAll(Arrays.asList(lego, hotWheels)));
        assertEquals(2, toyList.size());
        assertFalse(toyList.contains(barbie));
    }

    @Test
    void testToString() {
        toyList.addAll(Arrays.asList(lego, barbie));
        String expected = "[" + lego + ", " + barbie + "]";
        assertEquals(expected, toyList.toString());
    }

    @Test
    void testListIteratorNoArgs() {
        assertThrows(UnsupportedOperationException.class, toyList::listIterator);
    }

    @Test
    void testListIteratorWithIndex() {
        assertThrows(UnsupportedOperationException.class, () -> toyList.listIterator(0));
    }

    @Test
    void testSubList() {
        assertThrows(UnsupportedOperationException.class, () -> toyList.subList(0, 1));
    }
}
