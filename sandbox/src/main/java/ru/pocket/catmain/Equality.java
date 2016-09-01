package ru.pocket.catmain;

/**
 * Created by Goblik on 01.09.2016.
 */
public class Equality {

  public static void main(String[] arg){
    String s1 = "firefox";
    String s2 = new String (s1);

    System.out.println(s1==s2);
    System.out.println(s1.equals(s2));

  }
}
