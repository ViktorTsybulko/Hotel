package com.company;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Hotel hotel = new Hotel(3);

        for (int i = 1; i < 10; i++) {
            hotel.settleClient(new Request("" + i, random.nextInt(14000) + 1000, hotel));
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}