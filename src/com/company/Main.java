package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//Task 1
        /*  Banana
        It takes an Int Array called "a" and an int called Kiwi and multiply Kiwi with a together for each "a"
        So it starts with kiwi = 1 when a[0] and then it times the new kiwi value with a[1] and so on

            Grapefruit
        It takes an int array called "a" and checks if it's the same value is the int called "grape" and if it
        is it returns the number in the array where the values were the same else it returns -1 if none of the values
        in the array matches the value of the int "grape"

            Pineapple
        It takes an int array called "a" and an int called "apple" when it checks how many times apple is equal to the
        int array and ads 1 to an int called "pear" for each time the values are the same at the end it returns now value of
        the int "pear"
         */




//Task 3

        int[] task3 = new int[4];

        task3[0] = 2;
        task3[1] = 2;
        task3[2] = 2;
        task3[3] = 5;


        System.out.println( indexOfMax(task3));

//Task 4


        for (boolean bool : sieve(11)   ) {
            System.out.println(bool);
        }

//Task 5

        System.out.println( "\n"  +  areFactors(task3 , 2));

// Task 6

        System.out.println( "\n"   + arePrimeFactors(40 , task3));


//Task 7

        letterHist("ABC");

//Task 8

        System.out.println( isAnagrams("stop" , "pots "));

    } // Main ends here
        public static int indexOfMax (int[] a) {
            int currentLargestNum = 0;
            for (int values : a) {
                if (currentLargestNum < values) {
                    currentLargestNum = values;
                }
            }
            return currentLargestNum;
        }



        public static boolean[] sieve  (int input) {
        //  with help from: https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/

            boolean[] output;
            // first of all
            if (input <= 1) {
                output = new boolean[1];
                return output;
            }
            // if the input is 2 return true
            if (input == 2) {
                output = new boolean[1];
                output[0] = true;
                return output;
            }
            output = new boolean[input - 2];
            // we check from 2 to n-1
            for (int i = 2; i < input ; i++) {
                output[i-2] = input % i != 0;
            }
        return output;
        }



        public static boolean areFactors (int[] a, int testNum ) {
            for (int arrNumbers : a) {
                if (   testNum % arrNumbers  != 0) {
                    return false;
                }
            }
            return true;
        }



        public static  boolean arePrimeFactors(int n, int[] primeFactors) {
            // First we check if they are all prime numbers

            for (int numbers : primeFactors) {
                if (!sieve(numbers)[sieve(numbers).length - 1 ]) {
                    return false;
                }
            }
            // Since a prime number cannot be a product of 2 numbers we know we have reached the bottom of the "prime factor tree."
            // : https://www.bbc.co.uk/bitesize/guides/z9hb97h/revision/4#:~:text=Prime%20factors%20are%20factors%20of,use%20a%20prime%20factor%20tree.
            // And therefore we just need to validate if the numbers are factors

            return areFactors(primeFactors, n);
        }
        public static void letterHist (String s) {
            // make it all lower case
            s = s.toLowerCase();
            // we dont use "Æ , Ø , Å" Just saying
            int[] letters = new int[25];

            for (int i = 0; i < s.length(); i++) {
               letters[ s.charAt(i) - 97] ++;
            }
            for (int i = 0; i <= 24 ; i++) {
                System.out.println( ((char) (97 + i))  +  " " + letters[i]);
            }
        }


        public static boolean isAnagrams(String s1 , String s2) {

            //Make the words lower case

            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            //Remove all the spaces

            s1 = s1.replaceAll("\\s","");
            s2 = s2.replaceAll("\\s","");

            //create arrays with the 2 words

            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();

            //sort the arrays

            Arrays.sort(s1Arr);
            Arrays.sort(s2Arr);

            //Since the arrays only contains sorted chars they can be compared
            for (int i = 0; i < s1Arr.length; i++) {

                if (s1Arr[i] != s2Arr[i]) {
                    return  false;
                }
            }
            return true;
        }
}
