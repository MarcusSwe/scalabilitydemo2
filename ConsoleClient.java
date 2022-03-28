package me;

import java.util.Scanner;

public class ConsoleClient implements Runnable{

    private Scanner scanner;
    private Thread thread;

    public ConsoleClient(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){

        while (true){
            int num = scanner.nextInt();

            //samma sak som att skicka request till en proxy..skicka vidare till våran proxy..
            NodeManager.INSTANCE.push(num);

        }


    }

}

/* ----- eget test --- UTAN TRÅD på consoleclient -----------
public class ConsoleClient {

    private Scanner scanner;
    private Thread thread;

    public ConsoleClient(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){
     //   this.thread = new Thread(this);
       // this.thread.start();

        while (true){
            int num = scanner.nextInt();

            //samma sak som att skicka request till en proxy..skicka vidare till våran proxy..
            NodeManager.INSTANCE.push(num);

        }

    }


    /*
    @Override
    public void run(){

        while (true){
            int num = scanner.nextInt();

            //samma sak som att skicka request till en proxy..skicka vidare till våran proxy..
            NodeManager.INSTANCE.push(num);

        }


    }*/




//}
