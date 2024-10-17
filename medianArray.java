import java.util.Scanner;

public class medianArray {
    // Method to return the median as a double if the array is of even size
    public static double getMedianEven(int[] arr){
        double avg = 0.0;
        int size = arr.length;
        // The median is computed as the average of the middle position and the one before it
        avg = (double)(arr[size/2]+arr[(size/2)-1])/2;
        return avg;
    }

    // Method that returns the middle position if the array is of odd size
    public static int getMedianOdd(int [] arr){
        return arr[arr.length/2];
    }

    // Menu to allow user to enter the size of the sorted array
    // and add elements to it to determine the median
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.print("Please enter the size of the *sorted* array or enter '0' to quit: ");
            int arrSize = scan.nextInt();
            if(arrSize==0){
                flag=false;
                break;
            }
            int [] newArray = new int[arrSize];
            for(int i=0; i<arrSize; i++){
                System.out.print("Please enter *sorted* element "+(i+1)+ ": ");
                int element = scan.nextInt();
                newArray[i] = element;
            }
            if(arrSize%2==0){
                System.out.println("The median is "+getMedianEven(newArray));
            }
            else{
                System.out.println("The median is "+getMedianOdd(newArray));
            }
        }

    }
}

