public class recursion {
  //sqrt using Newton's approximation
  public static double sqrt(double n, double tolerance) {
    if (n == 0) {
      return 0;
    }
    else {
      return mySqrt(n, n/2, tolerance);
    }
  }

  public static double mySqrt(double n, double guess, double tolerance) {
    if (percentError(n, guess) < tolerance) {
      return guess;
    }
    else {
      return mySqrt(n, newGuess(n, guess), tolerance);
    }
  }

  public static double newGuess(double n, double guess) {
    return (n / guess + guess) / 2;
  }

  public static double percentError(double n, double guess) {
    return Math.abs((guess * guess - n) / n) * 100;
  }

  //nth Fibbonaci

  //Finding number of possible sums

  public static void main(String[] args) {
    System.out.println(sqrt(10, .001));
    System.out.println(sqrt(0, .001));
    System.out.println(sqrt(0.1, .001));
    System.out.println(sqrt(100, .001));
    System.out.println(sqrt(81, .001));
    System.out.println(sqrt(82, .001));
  }
}
