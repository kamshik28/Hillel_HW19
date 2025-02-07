package org.example;
import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Генерує числа від 0 до 99
        }

        System.out.println("Початковий масив: " + Arrays.toString(array));

        mergeSort(array);
        System.out.println("Відсортований масив: " + Arrays.toString(array));


        int target = array[random.nextInt(size)];
        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Елемент " + target + " знайдено на позиції " + index);
        } else {
            System.out.println("Елемент " + target + " не знайдено");
        }
    }
}

