package task2;

import com.github.sidimekov.task2.BubbleSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testAlreadySorted() {
        int[] arr = {1,2,3,4};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4}, arr);
    }

    @Test
    public void testReverse() {
        int[] arr = {4,3,2,1};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4}, arr);
    }

    @Test
    public void testRandom() {
        int[] arr = {3,1,4,2};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testAllEqualElements() {
        int[] arr = {5,5,5,5};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{5,5,5,5}, arr);
    }

    @Test
    public void testNegativeAndZero() {
        int[] arr = {0, -1, -3, 2};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{-3, -1, 0, 2}, arr);
    }

    @Test
    public void testNullArray() {
        int[] arr = null;
        assertThrows(NullPointerException.class, () -> BubbleSort.sort(arr));
    }

    @Test
    public void testMaxMinInt() {
        int[] arr = {Integer.MAX_VALUE, 0, -1, 5, -100, Integer.MIN_VALUE, 50, -50, 1000, -1000};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, -1000, -100, -50, -1, 0, 5, 50, 1000, Integer.MAX_VALUE}, arr);
    }

    @Test
    public void testAlreadySorted10() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, arr);
    }

    @Test
    public void testReverse10() {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, arr);
    }

    @Test
    public void testRandom10() {
        int[] arr = {3,7,1,10,4,2,9,6,8,5};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, arr);
    }

    @Test
    public void testAllEqualElements10() {
        int[] arr = {5,5,5,5,5,5,5,5,5,5};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{5,5,5,5,5,5,5,5,5,5}, arr);
    }

    @Test
    public void testNegativeAndZero10() {
        int[] arr = {0, -1, -3, 2, -5, 4, -2, 1, -4, 3};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{-5,-4,-3,-2,-1,0,1,2,3,4}, arr);
    }

}
