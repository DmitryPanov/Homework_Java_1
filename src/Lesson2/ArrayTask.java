package Lesson2;

import java.util.Arrays;
import java.util.Random;

public class ArrayTask {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(changeArr(array1)));

        int[] array2 = new int[8];
        System.out.println(Arrays.toString(generateArray(array2)));

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(findNumbersLess6(array3)));

        int[][] array4 = new int[8][8];
        multiArrayChangeDiagonal(array4);

        int [] a =  createArray(10);
        System.out.println(Arrays.toString(a));
        System.out.println(maxNumberInArray(a));
    }

    public static int[] changeArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
        return arr;
    }

    public static int[] generateArray(int[] arr) {
        int numberArray = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numberArray;
            numberArray += 3;
        }
        return arr;
    }

    public static int[] findNumbersLess6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }

    public static void multiArrayChangeDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || (i + j) == arr.length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] createArray(int i) {
        int[] arr = new int[i];
        Random rand = new Random();
        for (int j = 0; j < arr.length; j++) {
            arr[j] = rand.nextInt(100);
        }
        return arr;
    }

    public static int maxNumberInArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int minNumberInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min <= arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
