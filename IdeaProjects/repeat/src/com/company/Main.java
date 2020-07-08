package com.company;

public class Main {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length + 15];
        int i = 0;
        int j = 0;
        int r = 0;
        int key1 = 0;
        int key2 = 0;
        while( i < a1.length || j < a2.length ){
            if(a1[i] == a2[j] && key1 == 0 && key2 == 0){
                res[r] = a1[i];
                r++;
                res[r] = a2[i];
                r++;
                i++;
                j++;
            }else if(a1[i] > a2[j] && key1 == 0 && key2 == 0){
                res[r] = a2[j];
                r++;
                j++;
            }else if(a1[i] < a2[j] && key1 == 0 && key2 == 0){
                res[r] = a1[i];
                r++;
                i++;
            }else if(key1 == 0 && key2 == 1){
                res[r] = a1[i];
                r++;
                i++;
            }else if(key1 == 1 && key2 == 0){
                res[r] = a2[j];
                r++;
                j++;
            }

            if(i == a1.length - 1)
                key1 = 1;
            if(j == a2.length - 1)
                key2 = 1;

        }
        return res; // your implementation here
    }
    public static void main(String[] args) {
        int[] a1 = new int[] {21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] a2 = new int[] {10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int[] a3 = mergeArrays(a1, a2);
        for (int i : a3){
            System.out.println(i);
        }
    }
}
