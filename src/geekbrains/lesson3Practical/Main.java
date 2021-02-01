package geekbrains.lesson3Practical;

import java.util.Random;
import java.util.Scanner;

public class Main {
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
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanUser = new Scanner(System.in);
        Random rndGenerator = new Random();
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
}
