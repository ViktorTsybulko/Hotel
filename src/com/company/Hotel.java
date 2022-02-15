package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hotel {
    final int CAPACITY;
    ArrayList<String> residents = new ArrayList<>();
    LinkedList<Request> queue = new LinkedList<>();

    public Hotel(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public synchronized void settleClient(Request request) {
        System.out.println("Try to Settle client:\t" + request);
        request.start();
    }

    synchronized void clientIsEvict() {
        if (!queue.isEmpty()) {
            Request tmp = queue.peek();
            synchronized (tmp){
                tmp.notify();
            }
        }
    }
}
