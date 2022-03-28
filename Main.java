package me;

public class Main {


    public static void main(String[] args) {

        // Node - sjävla enheten som räknar ut uträkningen.. blir som en server..
        // NodeManager - som hanterar noderna.. och ge ut jobbet.. funkar som en proxy.. och som en loadbalancer samtidigt..

        NodeManager.INSTANCE.start();

        new ConsoleClient().start();


    }


}
