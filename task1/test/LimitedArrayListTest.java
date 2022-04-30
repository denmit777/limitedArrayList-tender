package homework8.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LimitedArrayListTest {

    private LimitedArrayList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LimitedArrayList<>(3);
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testAddPositive() throws OverflowingListException {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test(expected = OverflowingListException.class)
    public void testAddNegative_IfNotEnoughPlaceInList() throws OverflowingListException {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        assertEquals(3, list.size());
        list.add(4);
        assertEquals(4, list.size());
    }

    @Test
    public void testIsEmptyPositive() {
        boolean actual = list.isEmpty();

        assertTrue(actual);
    }

    @Test
    public void testIsEmptyNegative() throws OverflowingListException {
        list.add(1);

        boolean actual = list.isEmpty();

        assertFalse(actual);
    }

    @Test
    public void testIsEmptyNegative_IfAddedNull() throws OverflowingListException {
        list.add(null);

        boolean actual = list.isEmpty();

        assertFalse(actual);
    }

    @Test
    public void testContainsPositive() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        Integer element = 3;

        boolean actual = list.contains(element);

        assertTrue(actual);
    }

    @Test
    public void testContainsNegative() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        Integer element = 5;

        boolean actual = list.contains(element);

        assertFalse(actual);
    }

    @Test
    public void testGetPositive() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        int index = 0;

        int expected = 2;

        int actual = list.get(index);

        assertEquals(expected, actual);
    }

    @Test(expected = OverflowingListException.class)
    public void testGetNegative_IfIndexIsMoreThanSize() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        int index = 5;

        list.get(index);
    }

    @Test(expected = OverflowingListException.class)
    public void testGetNegative_IfIndexIsLessThanZero() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        int index = -1;

        list.get(index);
    }

    @Test
    public void testSetPositive() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        int index_0 = 0;
        Integer element_0 = -15;
        int index_1 = 1;
        Integer element_1 = 0;

        list.set(index_0, element_0);
        assertEquals(-15, list.set(index_0, element_0));

        list.set(index_1, element_1);
        assertEquals(0, list.set(index_1, element_1));
    }

    @Test(expected = OverflowingListException.class)
    public void testSetNegative_IfIndexIsMoreThanSize() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        int index = 4;
        Integer element = -15;

        list.set(index, element);
    }

    @Test(expected = OverflowingListException.class)
    public void testSetNegative_IfIndexIsLessThanZero() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        int index = -1;
        Integer element = -15;

        list.set(index, element);
    }

    @Test
    public void testIndexOfPositive() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        Integer element = 2;

        int expected = 0;

        int actual = list.indexOf(element);

        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOfPositive_IfElemIsNull() throws OverflowingListException {
        list.add(null);

        int expected = 0;

        int actual = list.indexOf(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOfNegative_IfNoSuchElement() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        Integer element = 5;

        int expected = -1;

        int actual = list.indexOf(element);

        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOfPositive() throws OverflowingListException {
        list.add(2);
        list.add(2);
        list.add(4);
        Integer element = 2;

        int expected = 1;

        int actual = list.lastIndexOf(element);

        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOfPositive_IfElemIsNull() throws OverflowingListException {
        list.add(null);
        list.add(1);

        int expected = 0;

        int actual = list.indexOf(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOfNegative_IfNoSuchElement() throws OverflowingListException {
        list.add(2);
        list.add(3);
        list.add(4);
        Integer element = 5;

        int expected = -1;

        int actual = list.indexOf(element);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetArrWithoutRemovedElementPositive() throws OverflowingListException {
        list.add(1);
        list.add(2);
        list.add(3);
        int index = 1;

        Object[] expected = new Integer[]{1, 3};

        Object[] actual = list.getArrWithoutRemovedElement(index);

        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetArrWithoutRemovedElementNegative_IfListIsEmpty() throws OverflowingListException {

        int index = 1;

        list.getArrWithoutRemovedElement(index);
    }

    @Test
    public void testRemovePositive() throws OverflowingListException {
        list.add(1);
        list.add(2);
        list.add(3);
        int index = 0;

        Integer expected = 1;

        Integer actual = list.remove(index);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNegative_IfIndexIsLessThanZero() throws OverflowingListException {

        int index = -1;

        list.getArrWithoutRemovedElement(index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNegative_IfIndexIsMoreThanSize() throws OverflowingListException {

        int index = 4;

        list.getArrWithoutRemovedElement(index);
    }
}