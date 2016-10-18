package ru.pocket.catmain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Goblik on 16.10.2016.
 */
public class Primes  {
  @Test(enabled = false)
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
  @Test(enabled = false)
  public void testPrimefast(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }
  @Test(enabled = false)
  public void testPrimefastq(){
    Assert.assertTrue(Primes.isPrimeFast2(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testnonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }
  @Test(enabled = false)
  public void testPrimelong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
}
