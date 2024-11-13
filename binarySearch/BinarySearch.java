import java.util.Arrays;

public class BinarySearch {
  public static int search(int arr[], int num) {
    Arrays.sort(arr);

    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      int mid = start + ((end - start) / 2);

      if (arr[mid] == num)
        return mid;

      else if (arr[mid] > num)
        end = mid - 1;
      else
        start = mid + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 7, 4, 8, 2, 5, 1, 9, 3, 6 };
    System.out.println(search(arr, 5));
    System.out.println(search(arr, 3));
    System.out.println(search(arr, 0));
    System.out.println(search(arr, 100));
  }
}
