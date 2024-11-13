import java.util.Arrays;

public class BinarySearchRecursive {

  public static int binarySearch(int arr[], int num) {
    Arrays.sort(arr);
    return search(arr, num, 0, arr.length - 1);

  }

  public static int search(int arr[], int target, int start, int end) {
    if (start > end)
      return -1;

      int mid = start + ((end - start) / 2);

    if (arr[mid] == target)
      return mid;

    else if (arr[mid] > target)
      return search(arr, target, start, mid - 1);
    else
      return search(arr, target, mid + 1, end);

  }

  public static void main(String[] args) {
    int[] arr = new int[] { 7, 4, 8, 2, 5, 1, 9, 3, 6 };
    System.out.println(binarySearch(arr, 5));
    System.out.println(binarySearch(arr, 3));
    System.out.println(binarySearch(arr, 0));
    System.out.println(binarySearch(arr, 100));
  }
}
