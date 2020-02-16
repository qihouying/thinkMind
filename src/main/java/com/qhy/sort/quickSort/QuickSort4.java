package com.qhy.sort.quickSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author dream
 * @Date 2020/2/16 5:06 PM
 * @Description []   Topics: []  companies: []
 */
public class QuickSort4 <T extends Comparable<? super T>> {

    public int partition(T[] nums, int low, int high) {
        T pivotKey = nums[low];

        while (low < high) {
            while (low < high && (nums[high]).compareTo(pivotKey) >= 0) {
                --high;
            }
            nums[low] = nums[high];
            while (low < high && (nums[low]).compareTo(pivotKey) <= 0) {
                ++low;
            }
            nums[high] = nums[low];
        }

        nums[low] = pivotKey;
        return low;
    }

    public void quickSort(T[] nums, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(nums, low, high);
            quickSort(nums, low, pivotLoc-1);
            quickSort(nums, pivotLoc+1, high);
        }
    }

    public  boolean checkInValid(T[]  nums) {
        if (null == nums || nums.length == 0)
            return true;
        return false;
    }


    public void sort(T[] nums) {
        if (checkInValid(nums))
            return;
        quickSort(nums, 0, nums.length-1);
    }

    public void print(T[] nums, QuickSort4 quickSort) {
        System.out.println("Before quickSort nums is: " + Arrays.toString(nums));
        quickSort.sort(nums);
        System.out.println("After quickSort nums is: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {

        QuickSort4 quickSort = new QuickSort4();

        //Input how to optimize？
        Integer[] numsInt = new Integer[4];
        int i = 0;
        while(i<4) {
            System.out.println("please input int number");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int x = sc.nextInt();
                numsInt[i++] = x;
            } else {
                System.out.println("input error, please input again");
            }
        }
        quickSort.print(numsInt, quickSort);

        Long[] numsLong = new Long[4];
        i = 0;
        while(i<4) {
            System.out.println("please input long number");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLong()) {
                long x = sc.nextLong();
                numsLong[i++] = x;
            } else {
                System.out.println("input error, please input again");
            }
        }
        quickSort.print(numsLong, quickSort);

        Double[] numsDouble = new Double[4];
        i = 0;
        while(i<4) {
            System.out.println("please input Double number");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextDouble()) {
                double x = sc.nextDouble();
                numsDouble[i++] = x;
            } else {
                System.out.println("input error, please input again");
            }
        }
        quickSort.print(numsDouble, quickSort);

        Float[] numsFloat = new Float[4];
        i = 0;
        while(i<4) {
            System.out.println("please input Float number");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextFloat()) {
                float x = sc.nextFloat();
                numsFloat[i++] = x;
            } else {
                System.out.println("input error, please input again");
            }
        }
        quickSort.print(numsFloat, quickSort);
    }


   /***************************Input optimize*********************************************
    public Object[] input(String type, int count) {
        Object[] nums;
        switch (type) {
            case "int":
                nums = new Integer[count];
                break;
            case "long":
                nums = new Long[count];
                break;
            case "double":
                nums = new Double[count];
                break;
            case "float":
                nums = new Float[count];
                break;
            default:
                nums = new Object[count];
                break;
        }
        int i = 0;
        while(i<count) {
            System.out.println("please input " + type + " number");
            Scanner sc = new Scanner(System.in);
            if (checkType(type, sc)) {
                nums[i++] = getInput(type, sc);
            } else {
                System.out.println("input error, please input again");
            }
        }
        return nums;
    }

    public boolean checkType(String type, Scanner sc) {
        switch (type) {
            case "int":
                return sc.hasNextInt();
            case "long":
                return sc.hasNextLong();
            case "double":
                return sc.hasNextDouble();
            case "float":
                return sc.hasNextFloat();
            default:
                return false;
        }
    }

    public Object getInput(String type, Scanner sc) {
        switch (type) {
            case "int":
                return sc.nextInt();
            case "long":
                return sc.nextLong();
            case "double":
                return sc.nextDouble();
            case "float":
                return sc.nextFloat();
            default:
                return null;
        }
    }
    **/
}
