import java.util.Arrays;
import java.util.Scanner;
/*
 * Lab 1: Permutations
 * Tristan Kalvoda & Armando Valdez
 */

public class Lab1 {

    public static void main(String[]args){
        int i;
        int n;
        Scanner scnr = new Scanner(System.in);
        n = scnr.nextInt();
        long startTime = System.currentTimeMillis();
        int N[] = new int[n];
        for (i = 0; i < n ; i++){
            N[i]=i+1;
        }

        permute(N,0);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time: " + totalTime + " milliseconds");
    }

    // helper function to print an array
    private static void print (int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void permute(int[] array, int currindex) {
        int l = array.length;

        // base case
        // if we are at the last index, print the array
        if (currindex == l) {
            print(array);
            return;
        }

        // recursive case
        /*  Swap the element at currindex with the element at index i, 
            then permute the rest of the array in order to get the permutation
             of the subarray starting at index currindex + 1 */
         
        for (int i = currindex; i < l; i++) {
            swap (array, currindex, i); 
            permute(array, currindex + 1);
            swap (array, currindex, i);
        }
    }

    // helper function to swap two elements in an array
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}