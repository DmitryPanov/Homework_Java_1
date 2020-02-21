package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    static final int SIZE = 3;
    //    public final int DOTS_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static char[][] map;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int Count = 0;
//    static final int COUNT = 0;

    public static void main(String[] args) {

        gameField();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            Count++;
            if(chechWin(DOT_X)){
                System.out.println("Игрок победил!");
                break;
            }

            if (isFull(Count) == true) {
                System.out.println("Ничья!");
                break;
            }

            compTurn();
            printMap();
            Count++;
            if(chechWin(DOT_O)){
                System.out.println("Пластмассовый мир победил, макет оказался сильней!)");
                break;
            }

            if (isFull(Count) == true) {
                System.out.println("Ничья!");
                break;
            }
        }

    }

    public static void gameField() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате Y X ");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE || y > SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void compTurn() {
        int x, y;
        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

//    public static boolean isFull() {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == DOT_EMPTY) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean isFull(int Count) {
        return Count == SIZE*SIZE;
    }

    public static boolean chechWin(char symbol){
        if(map[0][0]== symbol && map[0][1]== symbol && map[0][2]== symbol ){return true;}
        if(map[1][0]== symbol && map[1][1]== symbol && map[1][2]== symbol ){return true;}
        if(map[2][0]== symbol && map[2][1]== symbol && map[2][2]== symbol ){return true;}

        if(map[0][0]== symbol && map[1][0]== symbol && map[2][0]== symbol ){return true;}
        if(map[0][1]== symbol && map[1][1]== symbol && map[2][1]== symbol ){return true;}
        if(map[0][2]== symbol && map[1][2]== symbol && map[2][2]== symbol ){return true;}

        if(map[0][0]== symbol && map[1][1]== symbol && map[2][2]== symbol ){return true;}
        if(map[0][2]== symbol && map[1][1]== symbol && map[2][0]== symbol ){return true;}
        return false;
    }

}
