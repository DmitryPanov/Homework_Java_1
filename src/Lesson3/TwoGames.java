package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class TwoGames {
    public static String answer = "";
    public static String str = "";

    public static void main(String[] args) {
        chechAnswer(thinkNumber(10));
        resumeGame();

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String str = words[thinkNumber(words.length)];
//        System.out.println(str);//Вывод слова для проверки
        equal2Words(str);


    }

    static void equal2Words(String str) {
        while (!str.equals(answer)) {
            Scanner scan = new Scanner(System.in);
            System.out.printf("%s%n", "Попробуйте отгадать слово: ");
            answer = scan.nextLine();
            checkWord(checkLength(str, answer), str, answer);
        }
        System.out.println("Вы отгадали слово");
    }

    public static int checkLength(String s, String s1) {//Сравнивает длину слов
        if (s.length() >= s1.length()) {
            return s1.length();
        } else {
            return s.length();
        }
    }

    public static void checkWord(int len, String first, String second) {
        if (first.equals(second)) {
            return;
        }
        for (int i = 0; i < len; i++) {
            if (first.charAt(i) == second.charAt(i)) {
                System.out.print(first.charAt(i));
            } else {
                System.out.print("#");
            }
        }
        for (int i = 0; i <= 15 - len; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public static void chechAnswer(int answer) {
        int Count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Угадайте число от 0 до 9.У Вас есть 3 попытки.");
        do {
            int attempt = scan.nextInt();
            if (attempt == answer) {
                System.out.println("Правильный ответ!");
                break;
            } else if (attempt < answer) {
                System.out.println("Введенный ответ меньше чем загаданное число");
            } else {
                System.out.println("Введенный ответ больше чем загаданное число");
            }
            Count++;
            if (Count == 3) {
                System.out.println("Правильный ответ " + answer);
            }
        } while (Count < 3);
    }

    static void resumeGame() {
        Scanner scan = new Scanner(System.in);
        int playAgain;
        do {
            System.out.println("Продолжить? Если да введите 1 , для выхода введите 0");
            playAgain = scan.nextInt();
            if (playAgain == 1) {
                chechAnswer(thinkNumber(10));
            } else if (playAgain == 0) {
                System.out.println("Спасибо за игру");
                return;
            }
        } while (playAgain != 0 || playAgain != 1);
    }

    static int thinkNumber(int i) {
        Random rand = new Random();
        int answer = rand.nextInt(i);
//        System.out.println(answer);
        return answer;
    }
}
