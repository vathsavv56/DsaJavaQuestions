package Arrays;

import java.util.Arrays;

public class ArrayCrudTest {

    public static void main(String[] args) {
        testAdd();
        testAddAtIndex();
        testAddAtIndexException();
        testAddStart();
        testGet();
        testUpdate();
        testIsSorted();
        testLsearch();
        testBsearch();
        testIsPalindrome();
        testReverse();
        testIndex();
        testCount();
        testExtend();
        testIn();
        testCreateRandomArray();
        System.out.println("All manual tests passed!");
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Expected " + expected + " but got " + actual);
        }
    }

    private static void assertEquals(String expected, String actual) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new RuntimeException("Expected " + expected + " but got " + actual);
        }
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new RuntimeException("Expected true but got false");
        }
    }

    private static void assertFalse(boolean condition) {
        if (condition) {
            throw new RuntimeException("Expected false but got true");
        }
    }

    public static void testAdd() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        assertEquals(10, arrayCrud.get(0));
        assertEquals(20, arrayCrud.get(1));
    }

    public static void testAddAtIndex() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        try {
            arrayCrud.add(15, 1);
        } catch (Exception e) {
            throw new RuntimeException("Did not expect exception: " + e.getMessage());
        }
        assertEquals(15, arrayCrud.get(1));
    }

    public static void testAddAtIndexException() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        boolean thrown = false;
        try {
            arrayCrud.add(15, 10);
        } catch (Exception e) {
            thrown = true;
            assertEquals("Index Exceeds length of array", e.getMessage());
        }
        assertTrue(thrown);
    }

    public static void testAddStart() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.addStart(5);
        assertEquals(5, arrayCrud.get(0));
    }

    public static void testGet() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(100);
        assertEquals(100, arrayCrud.get(0));
    }

    public static void testUpdate() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.update(50, 0);
        assertEquals(50, arrayCrud.get(0));
    }

    public static void testIsSorted() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        arrayCrud.add(30);
        assertTrue(arrayCrud.isSorted());

        ArrayCrud arrayCrudUnsorted = new ArrayCrud(5);
        arrayCrudUnsorted.add(30);
        arrayCrudUnsorted.add(10);
        assertFalse(arrayCrudUnsorted.isSorted());
    }

    public static void testLsearch() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        arrayCrud.add(30);
        assertEquals(1, arrayCrud.lsearch(20));
        assertEquals(-1, arrayCrud.lsearch(100));
    }

    public static void testBsearch() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        arrayCrud.add(30);
        assertEquals(1, arrayCrud.bsearch(20));
    }

    public static void testIsPalindrome() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        arrayCrud.add(10);
        assertTrue(arrayCrud.isPalindrome());
    }

    public static void testReverse() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        arrayCrud.add(30);
        arrayCrud.reverse();
        assertEquals(10, arrayCrud.get(4));
    }

    public static void testIndex() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(20);
        assertEquals(1, arrayCrud.index(20));
    }

    public static void testCount() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        arrayCrud.add(10);
        arrayCrud.add(20);
        assertEquals(2, arrayCrud.count(10));
    }

    public static void testExtend() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(10);
        int[] result = arrayCrud.extend(new int[]{20, 30});
        assertEquals(10, result[0]);
        assertEquals(20, result[5]);
    }

    public static void testIn() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        arrayCrud.add(15);
        arrayCrud.add(25);
        assertTrue(arrayCrud.in(15));
        assertFalse(arrayCrud.in(100));
    }

    public static void testCreateRandomArray() {
        ArrayCrud arrayCrud = new ArrayCrud(5);
        int[] randomArr = arrayCrud.createRandomArray(10);
        assertEquals(10, randomArr.length);
    }
}
