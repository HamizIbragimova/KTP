package com.company;

public class Primes {
    public static void main(String[] args){
        for(int i = 2;i <100;i++) // перебирает числа от 2 до 100
            if (isPrime(i))
                System.out.println(i);
    }
    public static boolean isPrime(int n) { // функц. определяющая яв-ся аргумент простым числом
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}