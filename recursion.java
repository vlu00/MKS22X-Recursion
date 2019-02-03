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
    if (percentError(n, guess) < tolerance) { //if percent error is small enough
      return guess;
    }
    else {
      return mySqrt(n, newGuess(n, guess), tolerance); //otherwise make another guess
    }
  }

  private static double newGuess(double n, double guess) { //generates new guess
    return (n / guess + guess) / 2;
  }

  private static double percentError(double n, double guess) { //finds percent error from actual sqrt
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

  private static int fibHelper(int n, int first, int second, int counter) { //first is n-2 and second is n-1
    if (counter == n) {
      return first + second; //return the sum of the previous 2
    }
    else {
      return fibHelper(n, second, first+second, counter+1); //continue with the pattern
    }
  }

  //Finding number of possible sums
  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> L = new ArrayList<Integer>();
    return makeList(n, 0, L);
  }

  public static ArrayList<Integer> makeList(int n, int sum, ArrayList<Integer> L) {
    if (n == 0) { //no numbers left to add
      L.add(sum); //add partial sum to list
      return L;
    } else if (n > 0){ //n is positive
      return makeList(n-1, sum+n, makeList(n-1, sum, L)); //Building list based off first (list where did not add number)
    } else { //n is negative
      return makeList(n+1, sum+n, makeList(n+1, sum, L));
    }
  }
}
