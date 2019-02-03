import java.util.ArrayList;

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

  private static double mySqrt(double n, double guess, double tolerance) {
    if (percentError(n, guess) < tolerance) {
      return guess;
    }
    else {
      return mySqrt(n, newGuess(n, guess), tolerance);
    }
  }

  private static double newGuess(double n, double guess) {
    return (n / guess + guess) / 2;
  }

  private static double percentError(double n, double guess) {
    return Math.abs((guess * guess - n) / n) * 100;
  }

  //nth Fibbonaci
  public static int fib(int n){
    if (n < 2) {
      return n;
    }
    else {
      return fibHelper(n, 0, 1, 2);
    }
  }

  private static int fibHelper(int n, int first, int second, int counter) {
    if (counter == n) {
      return first + second;
    }
    else {
      return fibHelper(n, second, first+second, counter+1);
    }
  }

  //Finding number of possible sums
  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> L = new ArrayList<Integer>();
    return makeList(n, 0, L);
  }

  public static ArrayList<Integer> makeList(int n, int sum, ArrayList<Integer> L) {
    if (n == 0) {
      L.add(sum);
      return L;
    } else {
      return makeList(n-1, sum+n, makeList(n-1, sum, L));
    }
  }

  public static void main(String[] args) {

    System.out.println(makeAllSums(-3));
    System.out.println(makeAllSums(1));
    System.out.println(makeAllSums(2));
    System.out.println(makeAllSums(0));


    /*
    System.out.println(sqrt(10, .001));
    System.out.println(sqrt(0, .001));
    System.out.println(sqrt(0.1, .001));
    System.out.println(sqrt(100, .001));
    System.out.println(sqrt(81, .001));
    System.out.println(sqrt(82, .001));
    System.out.println(fib(0));
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(5));
    */
  }
}
