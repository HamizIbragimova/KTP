package com.company;

public class Palindrome {
    public static void main (String[] args){
        for (int i=0; i<args.length; i++) {
            String s = args[i];
        }
        divideString("madam racecar apple kayak song moon");
    }
  public static String reverseString(String s) {
      String res = ""; // объявляем переменную
      for (int length =  s.length()-1; length>=0; length--)  // метод возвращающий длину строки
          res += s.charAt(length) ; //  символ по индексу
          return res; //возвращает слово при вызове функции
      }
    public static void divideString(String s) {//разделяет строку на слова и проверяет каждое слово на палиндром
        String res = ""; // объявляем переменную
        for (int i = 0; i <= s.length()-1; i++) {//записывает слово пока не найдет пробел, когда находит вызывает палиндром обнуляя переменную со словом

            if (s.charAt(i) == ' ') {//если встретил пробле запускает проверку на палиндром
                System.out.println(isPalindrome(res));
                res = "";
                continue;
            }else if(i == s.length()-1) {//если конец строки тоже запускает проверку на палиндром
                res += s.charAt(i);
                System.out.println(isPalindrome(res));
                continue;
            }

            res += s.charAt(i);
        }
    }
  public static boolean isPalindrome (String s) { // метод, переворачивающий слово
      String res = reverseString(s);
      boolean reverse_s = s.equals(res); //проверяет значения равенства
      System.out.println(s);//выводим переданную строку
      return reverse_s;// возвращает условие
  }
}
