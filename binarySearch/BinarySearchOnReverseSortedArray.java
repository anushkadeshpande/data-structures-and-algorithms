public class BinarySearchOnReverseSortedArray {
    public static int search(int arr[], int num) {
    int start = arr.length - 1;
    int end = 0;

    while (start > end) {
      int mid = start + ((end - start) / 2);

      if (arr[mid] == num)
        return mid;

      else if (arr[mid] > num)
        end = mid + 1;
      else
        start = mid - 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println(search(arr, 5));
    System.out.println(search(arr, 3));
    System.out.println(search(arr, 0));
    System.out.println(search(arr, 100));
  }
}
