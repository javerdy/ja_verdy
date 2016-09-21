package ru.pocket.catmain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Goblik on 18.09.2016.
 */
public class Collection {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");


    for (String l : langs) {
      System.out.println("Я хочу выучить язык" + l);

/*    for(int i = 0; i < langs.length;i++){
      System.out.println("Я хочу выучить язык"+ langs[i]);*/
    }

  }
}
