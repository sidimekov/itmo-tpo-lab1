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
}
