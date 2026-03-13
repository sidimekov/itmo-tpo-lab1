package task2;

import com.github.sidimekov.task2.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2001) - 1000;
        }
        return arr;
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1,2,3,4};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReverse() {
        int[] arr = {4,3,2,1};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRandom() {
        int[] arr = {3,1,4,2};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testAllEqualElements() {
        int[] arr = {5,5,5,5};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testNegativeAndZero() {
        int[] arr = {0, -1, -3, 2};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testNullArray() {
        int[] arr = null;
        assertThrows(NullPointerException.class, () -> BubbleSort.sort(arr));
    }

    @Test
    public void testMaxMinInt() {
        int[] arr = {Integer.MAX_VALUE, 0, -1, 5, -100, Integer.MIN_VALUE, 50, -50, 1000, -1000};

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRandom100() {
        int[] arr = generateRandomArray(100);

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testAlreadySorted100() {
        int[] arr = generateRandomArray(100);
        Arrays.sort(arr);

        int[] expected = Arrays.copyOf(arr, arr.length);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReverse100() {
        int[] arr = generateRandomArray(100);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testAllEqualElements100() {
        int[] arr = new int[100];
        Arrays.fill(arr, 5);

        int[] expected = Arrays.copyOf(arr, arr.length);

        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

}