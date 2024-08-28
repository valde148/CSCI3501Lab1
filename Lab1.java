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

// What is the number of lines of output as a function of n? Explain how you computed it.
// The number of lines of output is n!. This is because for each element in the array, we are swapping it with every other element in the array.

// Based on your timing results and on approximation of the number of lines printed please estimate how long your program would run for 
//n = 15 and for n = 20. Show how you have computed the estimate.
// For n=8 it was 10534 milliseconds 8! = 40320 so the constant in front of n! would be 10534/40320 = 0.2615 so for n=15 the time would
// be around 0.26*15! = 3.39*10^11 milliseconds which is 3.39*10^8 seconds, or ~944431.48 hours. 
//n=20 would be .26 * 20! = 6.33*10^17 milliseconds or 6.33*10^14 seconds or 1.75*10^12 hours which is 200,585,595 years.
//For the numbers above we used Kalvoda laptop and Armando laptop produce different numbers since Armando goes a bit faster then Kalvoda
//We also test with a graph and tried n = 9 to see if it is still growing in a steady pase and for n = 9 we got 42619 milliseconds
// so 42619/ 9! we get 0.117447 on the graph and see it is steady. 
// This is on Armando Laptop we get for n = 15 we used .11*(15)!/1000/360 = 399,567 hours or 45.61 year
//Then n = 20 it is .11(20)!/1000*360*24*365 = 84861.25 years