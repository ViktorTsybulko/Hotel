package com.company;

import java.util.Objects;

public class Request extends Thread {
    String  surname;
    int     time;
    Hotel   hotel;

    public Request(String surname, int time, Hotel hotel) {
        this.surname = surname;
        this.time = time;
        this.hotel = hotel;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return time == request.time &&
                Objects.equals(surname, request.surname) &&
                Objects.equals(hotel, request.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, time);
    }

    @Override
    public String toString() {
        return "Request{" +
                "surname='" + surname + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            if (hotel.residents.size() < hotel.CAPACITY) {
                if (!hotel.queue.isEmpty() && hotel.queue.peek().equals(this)) {
                    hotel.queue.poll();
                    System.out.println(surname + "\tWas removed from a queue");
                }
                hotel.residents.add(surname);
                System.out.println(surname + "\tWas success settle for a\t" + time);
                try {
                    synchronized (this) {
                        this.wait(time);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hotel.residents.remove(surname);
                hotel.clientIsEvict();
                System.out.println(surname + "\tWas success evict");
                return;
            } else {
                if (hotel.queue.isEmpty() || !hotel.queue.peek().equals(this)) {
                    hotel.queue.add(this);
                    System.out.println(surname + "\twas added to queue");
                }
                try {
                    synchronized (this) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}