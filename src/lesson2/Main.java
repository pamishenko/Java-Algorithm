package lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {


//        MyArrayList<String> myArrayList = new MyArrayList<>();
//        for (int i = 0; i < 20000; i++){
//            String item = "";
//            double itemsLength = Math.random()*3+2;
//            for (int j = 0; j < itemsLength; j++) item += (char)(new Random().nextInt(26) + 'a');
//            myArrayList.add(item);
//        }


        /**
         * Немогу понять, почему выскакивает ошибка, если копасити вручную указать
         * Пример: MyArrayList<Integer> myArrayList = new MyArrayList<>(100);
         */


        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10000; i++){
            myArrayList.add(new Random().nextInt(100));
        }



        System.out.println(myArrayList);

        System.out.println(myArrayList.bubbleSort(Comparator.naturalOrder()));
        System.out.println(myArrayList.insertionSort());
        System.out.println(myArrayList.selectionSort());

        System.out.println(myArrayList);
    }

}
