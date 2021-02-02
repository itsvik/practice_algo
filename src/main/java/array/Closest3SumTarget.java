package array;

import java.util.Arrays;

class Closest3SumTarget {
    public static void main(String... a) {


        int[] nums = {-1,2,1,-4};
        System.out.println(closestSum(nums, 1));
    }

    public static int closestSum(int[] arr, int target){
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            int x = i+1, y = arr.length -1;
            while(x < y){
                int sum = arr[i] + arr[x] + arr[y];
                if(target - sum == 0){
                    return target;
                }
                if(sum > 0 && Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                } else if(sum < 0 && Math.abs(Math.abs(target) - Math.abs(sum)) < Math.abs(Math.abs(target) - Math.abs(closestSum))){
                    closestSum = sum;
                }

                if(sum > target){
                    y--;
                } else {
                    x++;
                }
            }
        }
        return closestSum;
    }
}