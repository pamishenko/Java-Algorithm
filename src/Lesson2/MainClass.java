package Lesson2;

import java.lang.reflect.Array;
import java.util.Random;

import static java.util.Arrays.sort;

public class MainClass {
    public static void main(String[] args) {

        int[] array = new int[1000];
        fill(array);
        sortBubble(array);
        ptintArray(array);
        System.out.println("----------------------------");
        array = deleteItem(array,2);
        array = addItem(array,3456);
        ptintArray(array);
        System.out.println(searchStupid(array,3456));


    }
    public static void fill(int[] a){ //Заполнить массив
        Random random = new Random();
        for (int i = 0; i< a.length; i++){
            a[i] = random.nextInt();
        }
    }

    public static int[] deleteItem(int[] arr, int i) {
        int[] tempArray = new int[arr.length-1];
        if (i == 0){
            System.arraycopy(arr,1,tempArray,0,arr.length-1);
        }else {
            System.arraycopy(arr,0,tempArray,0,i);
            System.arraycopy(arr,i+1,tempArray,i,arr.length-1-i);
        }
        arr = tempArray;
        return arr;


    }

    public static int[] addItem(int[] arr, int adding){
        int[] tempArray = new int[arr.length+1];
        System.arraycopy(arr,0,tempArray,0,arr.length);
        tempArray[arr.length] = adding;
        arr = tempArray;
        return arr;
    }

    public static void ptintArray(int[] a) {  //Вывести содержимое на экран
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static int searchStupid(int[] arr, int s){
        for (int i = 0; i < arr.length;i++){
         if (arr[i] == s) return i;
        } return -1;
    }

    public static int[] sortBubble(int[] arr){
        int out, in;
        for (out = arr.length - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    change(arr, in, in + 1);
                }
            }
        }return arr;
    }

    private static void change(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }




}
