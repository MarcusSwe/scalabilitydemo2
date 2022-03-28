package me;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Node implements Runnable {

    //sparar nummret för att senare vid ett annat tillfälle räkna ut den..
    private List<Integer> numbersToEvaluate;

    private ReentrantLock lock;
    private String name;
    private Thread thread;

    public Node(String name){
        this.numbersToEvaluate = new ArrayList<>();
        this.lock = new ReentrantLock();
        this.name = name;
    }

    public void start(){
        this.thread = new Thread(this);
        this.thread.start();

    }

    @Override
    public void run(){

        while(true) {

           Integer num = pop();

           if(num != null){
               boolean isPrime = Util.isPrime(num);
               System.out.println("(" + name + ") " + num + (isPrime ? " is a prime number." : " is not a prime number."));
               System.out.println(Thread.currentThread().getId());
           }

        }

    }

    //----- nedan är låst för att göra thread safe..

    public void push(int num){
        lock.lock();
        numbersToEvaluate.add(num);
        lock.unlock();
    }


    //-------- fungerar som en liten kö..
    private Integer pop(){
        lock.lock();
        if (numbersToEvaluate.isEmpty()) {
            lock.unlock();
            return null;
        }

        Integer num = numbersToEvaluate.get(0);
        numbersToEvaluate.remove(0);
        lock.unlock();
        return num;

    }


}
