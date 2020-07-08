package com.numbernull;


import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static void sumAll(){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int count_t = 0;//count true
        int sum = 0;

        String arg = sc.nextLine();
        ArrayList<String> args = new ArrayList<>();

        for(String i: arg.split(" ")){
            args.add(i);
            count++;
            if(checkString(i)){
                sum += Integer.parseInt(i);
                count_t++;
            }
        }

        System.out.format("Ans is %d. Counted: %d/%d.", sum, count_t, count);
    }

    public static void main(final String[] args) {
        sumAll();
    }

}