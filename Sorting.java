import java.util.*;
import java.util.Scanner;

public class Sorting {

  public static void main(String[] args) {

    Vector<Integer> numbers = new Vector<Integer>();
    Scanner in = new Scanner(System.in);
    System.out.println("Enter integer values seperated by enter to populate the vector");
    System.out.println("Type 'end' to stop entering values");

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
          } else if(algorithm.equalsIgnoreCase("merge sort")) {
            mergeSort(numbers);
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

    //each time through outer loop, biggest item moved to right-most index that has yet to be sorted
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

    //each time through outer loop, smallest item is found and switched with left-most index that has yet to be sorted
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

  public static void mergeSort(Vector<Integer> nums) {
    System.out.println("This algorithm has a time complexity of O(nlog<2>(n)), and is recursive!");
    if (nums.size() > 1) {
      mergeSort(nums, 0, nums.size()-1);
    }
  }

  public static void mergeSort(Vector<Integer> nums, int left, int right) {
    if (left < right) {
      int middle = (left + right)/2;
      //call mergeSort for first half
      mergeSort(nums,left,middle);

      //call mergeSort for second half
      mergeSort(nums,middle+1,right);

      // the two sorted vectors
      merge(nums,left,middle,right);
    }

  }

  public static void merge(Vector<Integer> nums, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;
    Vector<Integer> l = new Vector<Integer>();
    Vector<Integer> r = new Vector<Integer>();

    // copy left contents of original vector to its own temp vector
    for (int i = 0; i < n1; i++) {
      l.add(nums.get(i + left));
    }

    // copy right contents of original vector to its own temp vector
    for (int i = 0; i < n2; i++) {
      r.add(nums.get(i + 1 + middle));
    }

    int i = 0; // left sub-vector pointer
    int j = 0; // right sub-vector pointer
    int k = left; // main vector pointer

      // keep making comparisons, and adding smallest element to main vector
      // as long as both sub vectors have elements
      while (i < n1 && j < n2) {
        if (l.get(i) <= r.get(j)) {
          nums.set(k,l.get(i));
          i++;
          k++;
        } else {
          nums.set(k,r.get(j));
          j++;
          k++;
        }
      }

      // copy remaining elements into main vector
      while (i < n1) {
        nums.set(k,l.get(i));
        i++;
        k++;
      }

      // copy remaining elements into main vector
      while (j < n2) {
        nums.set(k,r.get(j));
        j++;
        k++;
      }
  }
}
