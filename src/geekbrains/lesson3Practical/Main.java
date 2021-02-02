package geekbrains.lesson3Practical;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rndGenerator = new Random();
    static Scanner scanUser = new Scanner(System.in);

    public static void main(String[] args) {

        Task1();
        Task2();

    }

    /***
     * Задание 1.
     *
     * Написать программу, которая загадывает случайное число от 0 до 9
     * и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
     * чем загаданное, или меньше.
     * После победы или проигрыша выводится запрос – «Повторить игру еще раз?
     * 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     *
     */
    private static void Task1() {

        int guessingNumber = 0;

        do {

            // Загадываем число.
            int resultNumber = rndGenerator.nextInt(10);

            System.out.printf("\nЗагадано число от 0 до 9.\nПопробуйте угадать, у Вас 3 попытки.\n");

            // Реализация 3-х попыток.
            for (int i = 0; i < 3; i++) {

                System.out.printf("Введите число: ");
                guessingNumber = scanUser.nextInt();

                // Обработка выигрыша.
                if (guessingNumber == resultNumber) {
                    System.out.printf("==============================\n");
                    System.out.printf("\tВы выиграли!\n\tКонец игры.\n");
                    System.out.printf("==============================\n");
                    break;
                }

                // Меньше.
                if (guessingNumber > resultNumber)  {
                    System.out.printf("Меньше!\n");
                    continue;
                }
                // Больше.
                System.out.printf("Больше!\n");
            }

            System.out.printf("\nПопробуете ещё раз?\n(1 - да / 0 - нет)  ");

        } while (scanUser.nextInt() != 0);
    }

    /**
     * Задание 2.
     *
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     */
    private static void Task2() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                        "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                        "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                        "pumpkin", "potato"};

        int lengthTestArray = words.length;
        int indexOfResultWord = rndGenerator.nextInt(lengthTestArray);

        String resultWord = words[indexOfResultWord];
        String userAnswer;

        System.out.printf("Было загадано слово из представленных ниже. Отгадайте его.\n");
        OutputWordsArrayToConsole(words);

        do {

            // Ввод варианта пользователя.
            System.out.printf("Ваш ответ (выход - q): ");
            userAnswer = scanUser.nextLine();

            // Обработка выигрыша.
            if (userAnswer.equals(resultWord))   {
                System.out.printf("==============================\n");
                System.out.printf("\tВы выиграли!\n\tКонец игры.\n");
                System.out.printf("==============================\n");
                break;
            }

            // Обработка, вывод посимвольных совпадений + маска.
            CheckWords(userAnswer, resultWord);

            System.out.println();
            System.out.printf("Попробуйте ещё раз...\n");

            OutputWordsArrayToConsole(words);

        }   while(!userAnswer.equals("q"));

    }

    /**
     * Вывод содержимого массива из Задания 2 на консоль.
     */
    private static void OutputWordsArrayToConsole (String[] words)  {

        int j = 0;

        System.out.println();

        for (String str : words)    {

            System.out.printf("%s, ", str);
            j++;

            // Формирование переносов после каждого 5-го элемента.
            if ((j % 5) == 0)   {
                System.out.printf("\n");
            }
        }
        System.out.println();
    }

    /**
     * Посимвольное сравнение параметра userWord по отношению resultWord.
     * Совпадающие символы - выводятся в консоль.
     * Остальные символы маскируются '#'.
     * Всего - 15 позиций символов.
     */
    private static void CheckWords (String userWord, String resultWord)    {

        // Длина замаскированного "слова".
        final int maskedCharsCount = 15;

        // Маркер на начальный символ.
        int markerBeginWord = 0;

        // Формирование 15-символьной маски.
        for (int i = 0; i < maskedCharsCount; i++)    {

            if (userWord.charAt(markerBeginWord) == resultWord.charAt(markerBeginWord)) {
                // Вывод совпадающего символа.
                System.out.printf("%c", userWord.charAt(markerBeginWord));
                // Сдвиг маркера на 1.
                markerBeginWord++;
                continue;

            } else {
                System.out.printf("#");
            }
        }

        System.out.printf("\n");

    }
}
