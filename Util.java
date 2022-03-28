package me;

public class Util {

    //static för ska bara finnas en av den..

    public static boolean isPrime(int num) {

        boolean flag = false;

        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        return !flag;

    }

}
