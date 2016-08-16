package ru.pocket.catmain;

public class MyFirstJar {
  public static void main(String[] args) {
        hello("world");
    hello("user");
    hello("Anna");

    double len = 5;
    System.out.println("Площадь квадрата со стороной"+ len + "=" + area(len));

    double a = 4;
    double b = 8;
    System.out.println("Площадь прямоугольника со сторонами"+ a +"и"+ b +"=" + area(a, b));

  }

  public static void hello(String someword) {

    System.out.println("Hello," + someword + "!");
  }

  public static double area(double l) {
    return l * l;

  }
  public static double area(double a, double b){
    return a * b;
  }


}