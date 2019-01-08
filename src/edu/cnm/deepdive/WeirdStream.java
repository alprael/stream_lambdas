package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class WeirdStream {

  private Random rng;

  public static void main(String[] args) {
    IntStream.generate(new IntSupplier() {
      private Random rng;

      {
        rng = new Random(-1); // Reproducible sequence.
      }

      @Override
      public int getAsInt() {
        return rng.nextInt();
      }
    })
        .limit(1000).forEach(System.out::println);

  }

  private static class RandomSupplier implements IntSupplier {

    private Random rng;

    {
      rng = new Random(-1); // Reproducible sequence.
    }

    @Override
    public int getAsInt() {
      return rng.nextInt();
    }
  }
}
