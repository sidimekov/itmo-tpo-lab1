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
}
