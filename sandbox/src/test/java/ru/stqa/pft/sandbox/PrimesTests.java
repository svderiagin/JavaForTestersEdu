package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {

    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testPrimesLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test
    public void testNoPrime() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }


}
