package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class WeirdStream {

  public static void main(String[] args) {
    Random rng = new Random(-1);
    IntStream.generate(rng::nextInt)
        .limit(1000)
        .boxed()
        .sorted((o1, o2) -> {
          int result = Integer.bitCount(o1) - Integer.bitCount(o2);
          if (result == 0) {
            result = o1 - o2;
          }
            return result;
        })
        .map(Integer::toBinaryString)
        .forEach(System.out::println);
  }
}
