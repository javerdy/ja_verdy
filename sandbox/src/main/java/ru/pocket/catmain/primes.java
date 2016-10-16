package ru.pocket.catmain;

/**
 * Created by Goblik on 10.09.2016.
 */
public class primes {

  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }
  public static boolean isPrimeFast(int n) {
    for (int i = 2; i < n/2; i++) {
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }

  public static boolean isPrimeFast2(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) {
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }
  public static boolean isWhilePrime(int n) {
    int i = 2;
    while (i < n && n % i !=0) {
      i++;
    }
    return i ==n;
  }
  public static boolean isPrime(long n) {
    for (long i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }

}

