package lesson8_tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    static int SIZE = 3;
    static int DOT_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '*';
    static char map[][];

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int Count = 0;
    public static boolean gameOver = false;
    public static String winnerName = "...";


    public static void go() {
        gameOver = true;
        printMap();
        Count++;

        if (chechWin2(DOT_X)) {
            System.out.println("Игрок победил!");
            winnerName = "Игрок победил!";
            new Conclusion(winnerName);

            return;
        }

        if (isFull(Count) == true) {

            System.out.println("Ничья!");
            winnerName = "Ничья!";
            new Conclusion(winnerName);
            return;
        }

        compTurn();
        printMap();

        Count++;

        if (chechWin2(DOT_O)) {
            System.out.println("Пластмассовый мир победил, макет оказался сильней!)");
            winnerName = "<html><center>Пластмассовый мир победил, макет оказался сильней!)</html></center>";
            new Conclusion(winnerName);
            return;
        }

        if (isFull(Count) == true) {
            System.out.println("Ничья!");
            winnerName = "Ничья!";
            new Conclusion(winnerName);
            return;
        }
        gameOver = false;
    }

    public static void doMap() {
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

//    public static void humanTurn() {
//        int x, y;
//        do {
//            System.out.println("Введите координаты в формате Y X (ряд, столбец)");
//            y = scanner.nextInt() - 1;
//            x = scanner.nextInt() - 1;
//        } while (!isCellValid(y, x));
//        map[y][x] = DOT_X;
//    }

    public static void setHumanXY(int y,int x){
        if (isCellValid(y,x)){
            map[y][x]=DOT_X;
            go();
        }
    }


    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void compTurn() {
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (chechWin2(DOT_O)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (chechWin2(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }


//        public static boolean isFull() {
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
        return Count == SIZE * SIZE;
    }

//    public static boolean chechWin(char symbol) {
//
//        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) {
//            return true;
//        }
//        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) {
//            return true;
//        }
//        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) {
//            return true;
//        }
//        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) {
//            return true;
//        }
//        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) {
//            return true;
//        }
//        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) {
//            return true;
//        }
//        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) {
//            return true;
//        }
//        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) {
//            return true;
//        }
//        return false;
//    }

    public static boolean chechWin2(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j]==symbol) {
                    if (tryLine(i, j, symbol)) {
                        return true;
                    }
                    if (tryColumn(i, j, symbol)) {
                        return true;
                    }
                    if (tryDiagonalDown(i, j, symbol)) {
                        return true;
                    }
                    if (tryDiagonalUp(i, j, symbol)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean tryLine(int y, int x, char symbol) {
        int count = 0;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
                return false;
            }
            if (map[y][x] == symbol) {
                count++;
            }
            x++;
            if (count == DOT_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static boolean tryColumn(int y, int x, char symbol) {
        int count = 0;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
                return false;
            }
            if (map[y][x] == symbol) {
                count++;
            }
            y++;
            if (count == DOT_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static boolean tryDiagonalDown(int y, int x, char symbol) {
        int count = 0;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
                return false;
            }

            if (map[y][x] == symbol) {
                count++;
            }
            y++;
            x++;
            if (count == DOT_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static boolean tryDiagonalUp(int y, int x, char symbol) {
        int count = 0;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
                return false;
            }
            if (map[y][x] == symbol) {
                count++;
            }
            x++;
            y--;
            if (count == DOT_TO_WIN) {
                return true;
            }
        }
        return false;
    }
}
