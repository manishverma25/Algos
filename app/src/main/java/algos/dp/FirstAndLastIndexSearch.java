package algos.dp;

public class FirstAndLastIndexSearch {

    public static void main(String s[]) {

        int arr[] = {5,7,7,8,9};
        int key = 7;
        int Sindex = findFirstPos(arr,key,0,arr.length-1);
        int Lindex = findLastPos(arr,key,0,arr.length-1);
        System.out.println("find first index "+Sindex+" , last "+first(arr,0,arr.length-1,key,7));
    }

    public static int first(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid -1), x, n);
        }
        return -1;
    }

    static int findLastPos(int arr[], int key, int start, int end) {
        int index = -1;
        while (start <= end) {
            if (start == end) {
                if (arr[start] == key) {
                    return start;
                } else {
                    return -1;
                }
            }
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                if (mid < end && arr[mid + 1]  >key)
                    return mid;
            }
            if (arr[mid] <= key) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
            return   findLastPos(arr,key,start,end);
        }
        return index;

    }

    static int findFirstPos(int arr[], int key, int start, int end) {
        int index = -1;


        while (start <= end) {
            if (start == end) {
                if (arr[start] == key) {
                    return start;
                } else {
                    return -1;
                }
            }

            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                if ( mid == 0|| mid > 0 && arr[mid - 1] < key)
                    return mid;
            }
            if (arr[mid] < key) {
                start = mid+1;
            } else {
                end = mid - 1;
            }

          return   findFirstPos(arr,key,start,end);

        }

        return index;

    }


}
