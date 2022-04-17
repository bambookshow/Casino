package com.jeen.casino;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class casinoApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Спасибо, что запустили игру Казино!");

        System.out.println("Введите свой возраст:");
        Integer age = Integer.valueOf(scan.nextLine());

        if ((age >= 18) && (age <= 90)) {
            System.out.println("Отлично! Теперь введите свое имя:");
            String name = scan.nextLine();

            System.out.println("Приятно познакомиться, " + name + "!");

            System.out.println("Осталось немного, введите пол в формате: мужчина/женщина");
            String gender = scan.nextLine();
            String m = "мужчина";
            String w = "женщина";
            if (gender.equalsIgnoreCase(m) | gender.equalsIgnoreCase(w)) {
                System.out.println("Введите количество соперников от 2 до 5");
                Integer enemies = Integer.valueOf(scan.nextLine());


                System.out.println("Добро пожаловать за игровой стол, " + name + ".\nВаши соперники:");

                if ((enemies <= 1) && (enemies >= 6)) {
                    System.out.println("Введено неверное количество соперников");
                } else {
// путь к файлу соперников, если в корне проекта
                    File file = new File("enemies.txt");
                    Scanner scanFile = new Scanner(file);
                    String scanEnemies = scanFile.nextLine();
                    String[] arrEnemies = scanEnemies.split(" - ");

                    List<String> listEnemies = Arrays.asList(arrEnemies);
                    Collections.shuffle(listEnemies);
                    ArrayList<String> newEnemies = new ArrayList<>();
                    int i = 0;
                    while (i < enemies) {
                        newEnemies.add(arrEnemies[i]);
                        System.out.println(arrEnemies[i]);
                        i++;
                    }
                    
                    Random random = new Random();
                    System.out.println("\nПриступим к игре. Нажмите Enter, чтобы выкинуть число");
                    scan.nextLine();
                    int userRound1 = (int) Math.round(Math.random() * 100);
                    System.out.println("Ваш результат первого раунда: " + userRound1);

                    System.out.println("\nТеперь нажмите Enter, чтобы Ваши соперники сделали ходы");
                    scan.nextLine();
                    ArrayList<Integer> enemNumbRound1 = new ArrayList<>();
                    int j = 0;
                    while (j < enemies) {
                        enemNumbRound1.add((int) Math.round(Math.random() * 100));
                        System.out.println(newEnemies.get(j) + " выкинул(а) в первом раунде: " + enemNumbRound1.get(j));
                        j++;
                    }

                    System.out.println("\nДля продолжения нажмите Enter");
                    scan.nextLine();

                    System.out.println("Отлично! Второй раунд.\nНажмите Enter, чтобы снова выкинуть число");
                    scan.nextLine();
                    int userRound2 = (int) Math.round(Math.random() * 100);
                    System.out.println("Ваш результат второго раунда: " + userRound2);

                    ArrayList<Integer> enemNumbRound2 = new ArrayList<>();
                    int g = 0;
                    while (g < enemies) {
                        enemNumbRound2.add((int) Math.round(Math.random() * 100));
                        System.out.println(newEnemies.get(g) + " выкинул(а) во втором раунде: " + enemNumbRound2.get(g));
                        g++;
                    }

                    System.out.println("\nДля продолжения нажмите Enter");
                    scan.nextLine();

                    System.out.println("Итак, последний, третий раунд!\nНажмите Enter, чтобы снова выкинуть число");
                    scan.nextLine();
                    int userRound3 = (int) Math.round(Math.random() * 100);
                    System.out.println("Ваш результат третьего раунда: " + userRound2);

                    ArrayList<Integer> enemNumbRound3 = new ArrayList<>();
                    int h = 0;
                    while (h < enemies) {
                        enemNumbRound3.add((int) Math.round(Math.random() * 100));
                        System.out.println(newEnemies.get(h) + " выкинул(а) в третьем раунде: " + enemNumbRound3.get(h));
                        h++;
                    }

                    System.out.println("\nПора определить победителя!\nНажмите Enter");
                    scan.nextLine();

                    int summUserRound = userRound1 + userRound2 + userRound3;
                    System.out.println("Ваш результат за три раунда: " + userRound1 + " + " + userRound2 + " + " + userRound3 + " = " + summUserRound + "\n");

                    ArrayList<Integer> summEnemRound = new ArrayList<>();
                    int p = 0;
                    while (p < enemies) {
                        summEnemRound.add(p, enemNumbRound1.get(p) + enemNumbRound2.get(p) + enemNumbRound3.get(p));
                        System.out.println(newEnemies.get(p) + " выкинул(а) за три раунда: " + enemNumbRound1.get(p) + " + " + enemNumbRound2.get(p) + " + " + enemNumbRound3.get(p) + " = " + summEnemRound.get(p));
                        p++;
                    }

                    int maxIndex = 0;
                    int maxValue = summEnemRound.get(maxIndex);
                    for (int o = 1; o < enemies; o++) {
                        if (summEnemRound.get(o) > maxValue) {
                            maxValue = summEnemRound.get(o);
                            maxIndex = o;
                        }
                    }

                    if (summUserRound > summEnemRound.get(maxIndex)) {
                        System.out.println("\nПОЗДРАВЛЯЕМ," + name + ", ВЫ ПОБЕДИЛИ!!!");
                    } else {
                        System.out.println("\nПОЭТОМУ ПОБЕДИТЕЛЕМ СТАНОВИТСЯ " + newEnemies.get(maxIndex) + "\nС результотом: " + summEnemRound.get(maxIndex));
                    }
                    }
            } else {
                System.out.println("Неверно введен пол");
            }
        } else {
            if (age <= 18) {
                System.out.println("К сожалению, в игру можно играть только с 18 лет");
                System.out.println("Возвращайтесь к нам взрослым, и мы поделимся с Вами бухлом и шл*хами :)))");
            }
            if (age >= 90) {
                System.out.println("К сожалению, Вы староваты для этого дерьма");
                System.out.println("Как Вы вообще включили игру??? Оо");
            }
        }
    }
}
