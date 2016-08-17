package ru.pocket.catmain;

public class MyFirstJar {
  public static void main(String[] args) {
        hello("world");
    hello("user");
    hello("Anna");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной"+ s.l + "=" + s.area());

    Rectangle f = new Rectangle(4, 8);
    System.out.println("Площадь прямоугольника со сторонами"+ f.a +"и"+ f.b +"=" + f.area());

    Point p1 = new Point(7,8);

    Point p2 = new Point(3,2);


    System.out.println("Расстояние между точками"+ "(" + p1.x +"," + p1.y + ")" + "и"+ "("+ p2.x +","+ p2.y +")" + "=" + p1.distance(p2));
  }

  public static void hello(String someword) {

    System.out.println("Hello," + someword + "!");
  }


}