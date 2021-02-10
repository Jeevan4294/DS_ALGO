package my.preparation.skiena;

import java.util.*; 
  
public class Chapter4 { 
    // A utility function to get maximum value in arr[] 
    static int getMax(int arr[]) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < arr.length; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. (e.g. 300 is represented by 100)
    static void countSort(int arr[], int exp) 
    { 
        int output[] = new int[arr.length]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 
  
        for (i = 0; i < arr.length; i++) 
        	System.out.print(count[i]+" ");
        System.out.println(" ...1...");

        // Store count of occurrences in count[] 
        for (i = 0; i < arr.length; i++) 
            count[ (arr[i]/exp)%10 ]++; 

        for (i = 0; i < arr.length; i++) 
        	System.out.print(count[i]+" ");
        System.out.println(" ...2...");

        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        for (i = 0; i < arr.length; i++) 
        	System.out.print(count[i]+" ");
        System.out.println(" ...3...");

        // Build the output array 
        for (i = arr.length - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
            for (int j = 0; j < arr.length; j++) {
            	System.out.print(count[j]+" ");
            }
            System.out.println("--------------");
            for (int j = 0; j < arr.length; j++) {
        		System.out.print(output[j]+" ");        		
            }

            System.out.println(" ......");
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to current digit 
        for (i = 0; i < arr.length; i++) {
        	System.out.print(output[i]+" ");
            arr[i] = output[i]; 
        }
        System.out.println();
    } 
  
    // The main function to that sorts array arr[] using 
    // Radix Sort 
    static void radixsort(int arr[]) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, exp); 
    } 
  
    // A utility function to print an array 
    static void print(int arr[]) 
    { 
        for (int i=0; i < arr.length; i++) 
            System.out.print(arr[i]+" "); 
    } 
  
  
    /*Driver function to check for above function*/
    public static void main (String[] args) 
    { 
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
        radixsort(arr); 
        print(arr); 
    } 
}
