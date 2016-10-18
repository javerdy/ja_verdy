package ru.pocket.catmain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Goblik on 16.10.2016.
 */
public class Primes {
  @Test
  public void testPrime(){
    Assert.assertTrue(primes.isPrime(Integer.MAX_VALUE));
  }
  @Test
  public void testPrimefast(){
    Assert.assertTrue(primes.isPrimeFast(Integer.MAX_VALUE));
  }
  @Test
  public void testPrimefastq(){
    Assert.assertTrue(primes.isPrimeFast2(Integer.MAX_VALUE));
  }

  @Test
  public void testnonPrime(){
    Assert.assertFalse(primes.isPrime(Integer.MAX_VALUE-2));
  }
  @Test(enabled = false)
  public void testPrimelong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(primes.isPrime(n));
  }
}
