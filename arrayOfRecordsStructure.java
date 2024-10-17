import java.util.*;

public class arrayOfRecordsStructure {

    // Method for creating an integer array that is of size n specified by user input
    public static int[] createAnArray(int n){
        int [] arr = new int[n];
        return arr;
    }

    // Method for adding elements to integer array
    public static void addElements(int[] arr){
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<arr.length; i++){
            // Prompt the user for each element to add to array
            System.out.print("Enter element "+(i+1)+": ");
            int userInput = scan.nextInt();
            arr[i] = userInput;
        }
    }

    // Method to print out each index of the integer array
    public static void printArrayContent(int[] arr){
        for(int i=0; i<arr.length; i++){
            // Loop through the array and print each element
            System.out.println("Array element "+(i+1)+": "+arr[i]);
        }
    }

    // Method to remove user-specified value from integer array
    public static int [] removeArrayElement(int[] arr){
        Scanner scan = new Scanner(System.in);
        // Prompt user to enter the value they would like to remove from the array
        System.out.print("Enter the value you want to remove: ");
        int value = scan.nextInt();
        // Use a boolean flag to track when an element has been removed
        boolean flag = false;
        // Create a new array with the size being one less than
        // the original array
        int [] newArr = new int[arr.length-1];

        for(int i=0; i<arr.length; i++){
            /* If the value is not found, no value has been deleted, and
             we are still not at the end of the array,
             set the value in the new array to be the same
             as the value in the previous array */
            if(arr[i] != value && i< newArr.length && !flag){
                newArr[i] = arr[i];
            }
            /* If the value is not found at this position, and we have
               reached the end of the array, then subtract one position
               to access the end of the smaller, new array.
               Then update its value.
             */
            else if(arr[i]!=value && i> newArr.length){
                newArr[i-1] = arr[i];
            }
            /* If the value needing deletion is found,
               skip over it and add the next element to the
               new array. Then flag a value as having been
               deleted.
             */
            else if(arr[i]==value && i< newArr.length){
                newArr[i] = arr[i+1];
                flag=true;
            }
            /* If the value is not found, we are not at the end of the array,
               and a deletion HAS occurred, the new array will be
               equal to the original value's next position
             */
            else if(arr[i] != value && i< newArr.length && flag){
                newArr[i] = arr[i+1];
            }
        }
        // Then return the array after the deletion has completed
        return newArr;
    }

    public static void searchArray(int [] arr){
        Scanner scan = new Scanner(System.in);
        // Prompt user for the value to search for
        System.out.print("Enter the value you want to search for: ");
        int input = scan.nextInt();
        // Initialize counter variable outside of loop to use
        // in identifying position
        int counter = 0;
        // Initialize boolean flag variable to use when value is found
        boolean flag=false;
        // Loop through the array and search for value
        for(int i=0; i<arr.length; i++){
            if(arr[i] == input){
                // If found, set flag to true
                // And set counter the position where value was found
                flag=true;
                counter=i;
            }
        }

        // Then, if the value was found, return its position
        // if the value is not found, simply inform the user
        if(flag){
            System.out.println("The value has been found at position "+counter);
        }
        else{
            System.out.println("The value is not in the array.");
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Let the user specify the size of the array
        System.out.print("Please enter size of array: ");
        int size = scan.nextInt();
        // Use method to create the array based on size specified above
        int [] newAr = createAnArray(size);
        // Now use method to prompt user to enter values of the array
        addElements(newAr);
        // Use boolean flag to update in the case that a user wants to exit the program
        boolean flag = true;
        // Display the menu as long as the user does not want to exit
        while(flag){
            System.out.println("Please choose an option below.");
            System.out.println("------------------------------");
            System.out.println("1) Print array content");
            System.out.println("2) Remove element from array");
            System.out.println("3) Search for an element in the array");
            System.out.println("4) EXIT");
            System.out.print("Enter option HERE: ");
            int userInput = scan.nextInt();

            if(userInput==4){
                flag=false;
                System.out.println("Goodbye!");
            }
            else if(userInput==1){
                System.out.println("Printing array content:");
                printArrayContent(newAr);
            }
            else if(userInput==2){
                newAr = removeArrayElement(newAr);
            }
            else if(userInput==3){
                searchArray(newAr);
            }
            else{
                System.out.println("Invalid input.");
            }
        }
    }
}
