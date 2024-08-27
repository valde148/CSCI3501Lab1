import java.util.Arrays;
import java.util.Scanner;
public class Lab1 {

    public static void main(String[]args){
        int i;
        int n;
        Scanner scnr = new Scanner(System.in);
        n = scnr.nextInt();
        int N[] = new int[n];
        for (i = 0; i < n ; i++){
            N[i]=i+1;
        }
        System.out.println(Arrays.toString(N));
            
        }
    }
    
