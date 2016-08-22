/******************************************************************************
  * Implements quicksort and counts the number of compares performed based on
  * the algorithm for pivot choice
  * 
  * 
  * 
  ****************************************************************************/
import java.util.*;
import java.io.*;

public class QuickSortCmpCnt {
    
    private static long cmpCnt = 0;
    
    public static void sort(int[] a) {
        sort(a, 0, a.length-1);
    }
    
    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        
        //change the name of partition to answer the different HW questions
        int j = partition3(a, lo, hi);
        cmpCnt += hi-lo;
        /*
        for (int i = 0; i < hi; i++) {
            System.out.println(
            */
        sort(a, j+1, hi);
        sort(a, lo, j-1);   
    }
    
    
//pivot is the first element in the input array
    public static int partition(int[] a, int lo, int hi) {
        int pivot = lo;
        int i = lo+1;
        int j = lo+1;
        
        while (j <= hi) {
            if (less(a, j, pivot)) exch(a, j, i++);
            j++;
        }

        exch(a, pivot, i-1);   
        return i-1;
    }
    
    public static int partition2(int[] a, int lo, int hi) {
        exch(a, lo, hi);
        return partition(a, lo, hi);    
    }
    
    public static int partition3(int[] a, int lo, int hi) {
        int mid = lo+(hi-lo)/2;
        medianOfThree(a, lo, mid, hi);
        return partition(a, lo, hi);        
    }
    
    private static void medianOfThree(int[] a, int lo, int mid, int hi) {
        int max = Math.max(a[lo], Math.max(a[mid], a[hi]));
        int min = Math.min(a[lo], Math.min(a[mid], a[hi]));
        if(a[mid] > min && a[mid] < max)
            exch(a, mid, lo);
        else if(a[hi] > min && a[hi] < max)
            exch(a, hi, lo);
    }
    
    private static void exch(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    
    private static boolean less(int[] a, int x, int y) {
        if (a[x] < a[y]) return true;
        else return false;
    }
    
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        int[] arr = new int[10000];
        //int[] arr2 = {3, 8, 2, 4, 8, 9, 15, 1, 7, 5, 6, 12, 13, 4};
        
        Scanner in = new Scanner(new BufferedReader(new FileReader("QuickSort.txt")));
        for (int i = 0; i < 10000; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        
        //System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        //System.out.println(arr[9999]);
        
        //sort(arr);
        sort(arr);
        
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        */
        
        System.out.println(cmpCnt);
        
    }
}