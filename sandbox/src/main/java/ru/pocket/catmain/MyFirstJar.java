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

    Point p1 = new Point();
    p1.x1 = 7;
    p1.y1 = 8;

    Point p2 = new Point();

    p2.x2 = 3;
    p2.y2 = 2;

    System.out.println("Расстояние между точками"+ "(" + p1.x1 +"," + p1.y1 + ")" + "и"+ "("+ p2.x2 +","+ p2.y2 +")" + "=" + distance(p1,p2));
  }

  public static void hello(String someword) {

    System.out.println("Hello," + someword + "!");
  }

  public static double distance (Point p1, Point p2){

    return  Math.sqrt((p2.x2-p1.x1)*(p2.x2-p1.x1)+(p2.y2-p1.y1)*(p2.y2-p1.y1));
}
}