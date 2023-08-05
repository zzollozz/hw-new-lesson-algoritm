package ru.hw;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Random random = new Random();


        for (Integer i = 0; i < 10; i++) {
            tree.add(random.nextInt(100));
        }
    }
}