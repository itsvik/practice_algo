package array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNumber {

    public static void main(String[] args) {

        Arrays.stream(nextGreaterElementStack(new int[]{4,7,9,2,8,2,6})).sequential().forEach(System.out::println);
    }

    private static int[] nextGreaterArray(int[] arr){
        int[] nextG = new int[arr.length];
        nextG[arr.length -1] = -1;
        for (int i = 0; i < arr.length -1; i++) {
            int j = i;
            while(arr[i] >= arr[j] && j < arr.length -1)
                j++;
            if(j == arr.length -1 && arr[i] < arr[j])
                nextG[i] = arr[j];
            else if(j == arr.length -1)
                nextG[i] = -1;
            else
                nextG[i] = arr[j];
        }
        return nextG;
    }

    private static int[] nextGreaterElementStack(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
//          Pop until stack peek is less than the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty())  // No greater element on right
                res[i] = -1;
            else
                res[i] = stack.peek(); // Top element of stack is greater element
            stack.push(arr[i]); // push current element to stack
            // { Now we have current element and greater elements in stack}
        }
        return res;
    }
}
