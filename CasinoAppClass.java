package com.jeen.casino;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CasinoAppClass {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Спасибо, что запустили игру Казино - Класс!");

        User user = new User();
        System.out.println("Введите свой возраст:");
        user.age = Integer.valueOf(scan.nextLine());
//        try {
//            throw new NumberFormatException();
//        } catch (NumberFormatException e) {
//            System.out.println("\nПОПРОБУЙТЕ ВВОДИТЬ ТОЛЬКО ЧИСЛА");
//        }

        if ((user.age >= 18) && (user.age <= 90)) {
            System.out.println("Отлично! Теперь введите свое имя:");
            user.name = scan.nextLine();
//            try {
//                throw new IOException();
//            } catch (IOException e){
//                System.out.println("\nПРОСИМ ПРОЩЕНИЯ. ЧТО-ТО ПОШЛО НЕ ТАК :(((");
//            }

            System.out.println("Приятно познакомиться, " + user.name + "!");

            System.out.println("Осталось немного, введите пол в формате: мужчина/женщина");
            user.gender = scan.nextLine();
            String m = "мужчина";
            String w = "женщина";
            if (user.gender.equalsIgnoreCase(m) | user.gender.equalsIgnoreCase(w)) {
                System.out.println("Введите количество соперников от 2 до 5");
                Enemies enemies = new Enemies();
                enemies.data = Integer.valueOf(scan.nextLine());
//                try {
//                    throw new IOException();
//                } catch (IOException e){
//                System.out.println("\nПОПРОБУЙТЕ ВВОДИТЬ ТОЛЬКО ЧИСЛА");
//                }

                System.out.println("Добро пожаловать за игровой стол, " + user.name + ".\nВаши соперники:");

                if ((enemies.data <= 1) && (enemies.data >= 6)) {
                    System.out.println("Введено неверное количество соперников");
                } else {
                    File file = new File("enemies.txt");
                    Scanner scanFile = null;
                    try {
                        scanFile = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        System.out.println("\nПРОСИМ ПРОЩЕНИЯ. ЧТО-ТО ПОШЛО НЕ ТАК :(((");
                    }
                    String scanEnemies = scanFile.nextLine();
                    String[] arrEnemies = scanEnemies.split(" - ");

                    List<String> listEnemies = Arrays.asList(arrEnemies);
                    Collections.shuffle(listEnemies);
                    ArrayList<String> newEnemies = new ArrayList<>();
                    int i = 0;
                    while (i < enemies.data) {
                        newEnemies.add(arrEnemies[i]);
                        System.out.println(arrEnemies[i]);
                        i++;
                    }

                    System.out.println("\nПриступим к игре. Нажмите Enter, чтобы выкинуть число");
                    scan.nextLine();
                    Random random = new Random();
                    user.numbRound1 = (int) Math.round(Math.random() * 100);
                    System.out.println("Ваш результат первого раунда: " + user.numbRound1);

                    System.out.println("\nТеперь нажмите Enter, чтобы Ваши соперники сделали ходы");
                    scan.nextLine();
                    ArrayList<Integer> enemNumbRound1 = new ArrayList<>();
                    int j = 0;
                    while (j < enemies.data) {
                        enemNumbRound1.add((int) Math.round(Math.random() * 100));
                        System.out.println(newEnemies.get(j) + " выкинул(а) в первом раунде: " + enemNumbRound1.get(j));
                        j++;
                    }

                    System.out.println("\nДля продолжения нажмите Enter");
                    scan.nextLine();

                    System.out.println("Отлично! Второй раунд.\nНажмите Enter, чтобы снова выкинуть число");
                    scan.nextLine();
                    user.numbRound2 = (int) Math.round(Math.random() * 100);
                    System.out.println("Ваш результат второго раунда: " + user.numbRound2);

                    ArrayList<Integer> enemNumbRound2 = new ArrayList<>();
                    int g = 0;
                    while (g < enemies.data) {
                        enemNumbRound2.add((int) Math.round(Math.random() * 100));
                        System.out.println(newEnemies.get(g) + " выкинул(а) во втором раунде: " + enemNumbRound2.get(g));
                        g++;
                    }

                    System.out.println("\nДля продолжения нажмите Enter");
                    scan.nextLine();

                    System.out.println("Итак, последний, третий раунд!\nНажмите Enter, чтобы снова выкинуть число");
                    scan.nextLine();
                    user.numbRound3 = (int) Math.round(Math.random() * 100);
                    System.out.println("Ваш результат третьего раунда: " + user.numbRound3);

                    ArrayList<Integer> enemNumbRound3 = new ArrayList<>();
                    int h = 0;
                    while (h < enemies.data) {
                        enemNumbRound3.add((int) Math.round(Math.random() * 100));
                        System.out.println(newEnemies.get(h) + " выкинул(а) в третьем раунде: " + enemNumbRound3.get(h));
                        h++;
                    }

                    System.out.println("\nПора определить победителя!\nНажмите Enter");
                    scan.nextLine();

                    System.out.println("Ваш результат за три раунда: " + user.numbRound1 + " + " + user.numbRound2 + " + " + user.numbRound3 + " = " + user.summNumbRound + "\n");

                    ArrayList<Integer> summEnemRound = new ArrayList<>();
                    int p = 0;
                    while (p < enemies.data) {
                        summEnemRound.add(p, enemNumbRound1.get(p) + enemNumbRound2.get(p) + enemNumbRound3.get(p));
                        System.out.println(newEnemies.get(p) + " выкинул(а) за три раунда: " + enemNumbRound1.get(p) + " + " + enemNumbRound2.get(p) + " + " + enemNumbRound3.get(p) + " = " + summEnemRound.get(p));
                        p++;
                    }

                    int maxIndex = 0;
                    int maxValue = summEnemRound.get(maxIndex);
                    for (int o = 1; o < enemies.data; o++) {
                        if (summEnemRound.get(o) > maxValue) {
                            maxValue = summEnemRound.get(o);
                            maxIndex = o;
                        }
                    }

                    if (user.summNumbRound > summEnemRound.get(maxIndex)) {
                        System.out.println("\nПОЗДРАВЛЯЕМ," + user.name + ", ВЫ ПОБЕДИЛИ!!!" + "\nС результотом: " + user.summNumbRound);
                    } else {
                        System.out.println("\nПОЭТОМУ ПОБЕДИТЕЛЕМ СТАНОВИТСЯ " + newEnemies.get(maxIndex) + "\nС результотом: " + summEnemRound.get(maxIndex));
                    }
                    }
            } else {
                System.out.println("Неверно введен пол");
            }
        } else {
            if (user.age <= 18) {
                System.out.println("К сожалению, в игру можно играть только с 18 лет");
                System.out.println("Возвращайтесь к нам взрослым, и мы поделимся с Вами бухлом и шл*хами :)))");
            }
            if (user.age >= 90) {
                System.out.println("К сожалению, Вы староваты для этого дерьма");
                System.out.println("Как Вы вообще включили игру??? Оо");
            }
        }
    }
}
