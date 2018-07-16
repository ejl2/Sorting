import java.util.*;
import java.util.Scanner;

public class Sorting {

  public static void main(String[] args) {

    Vector<Integer> numbers = new Vector<Integer>();
    Scanner in = new Scanner(System.in);

    while (true) {
      try {
        String next = in.next();

        if (next.equals("end")) {
          break;
        }

        numbers.add(Integer.parseInt(next));
      } catch(Exception ex) {
      }
    }
    System.out.println(numbers);
    in.nextLine();

    while (true) {
      try {
          System.out.println("Select a sorting algorithm");
          String algorithm = in.nextLine();
          if (algorithm.equalsIgnoreCase("bubble sort")) {
            bubbleSort(numbers);
            System.out.println(numbers);
            break;
          } else if(algorithm.equalsIgnoreCase("selection sort")) {
            selectionSort(numbers);
            System.out.println(numbers);
            break;
          } else if(algorithm.equalsIgnoreCase("insertion sort")) {
            insertionSort(numbers);
            System.out.println(numbers);
            break;
          }
      } catch (Exception ex) {
      System.out.println("invalid input");
      }
    }



  }

  public static void bubbleSort(Vector<Integer> nums){
    System.out.println("This algorithm has a time complexity of O(n^2)");
    for (int i = 0; i < nums.size()-1; i++) {
      for (int j = 0; j < nums.size()-i-1; j++) {
        if (nums.get(j+1) < nums.get(j)) {
          Integer temp = nums.get(j+1);
          nums.set(j+1,nums.get(j));
          nums.set(j,temp);
        }
      }
    }
  }

  public static void selectionSort(Vector<Integer> nums) {
    System.out.println("This algorithm has a time complexity of O(n^2)");
    for (int i = 0; i < nums.size()-2; i++) {
      int minIndex = i;
      for (int j = i+1; j < nums.size(); j++) {
        if (nums.get(j) < nums.get(minIndex)) {
          minIndex = j;
        }
      }
      Integer temp = nums.get(minIndex);
      nums.set(minIndex, nums.get(i));
      nums.set(i, temp);
    }
  }

  public static void insertionSort(Vector<Integer> nums) {
    System.out.println("This algorithm has a time complexity of O(n^2)");
    for (int  i = 1; i < nums.size(); i++) {
      Integer cur = nums.get(i);
      int j = i-1;
      while (j >= 0 && nums.get(j) > cur) {
        nums.set(j+1, nums.get(j));
        j = j - 1;
      }
      nums.set(j+1, cur);
    }
  }
}
