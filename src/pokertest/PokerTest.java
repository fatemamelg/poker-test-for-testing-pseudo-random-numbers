/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertest;

import java.util.*;

/**
 *
 * @author Fatema
 */
public class PokerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) {
        // TODO code application logic here
        //Random rand = new Random();
        int[] genNumbers = new int[1000];
        int[] cases = new int[7];
        int[] counter = new int[10];
        ArrayList<Integer> list = new ArrayList<>();
        long seed = 3;

        double start = System.currentTimeMillis();

        for (int i = 0; i < genNumbers.length; i++) {

            genNumbers[i] = (int) genPseudoRand(seed);
            seed =  genPseudoRand(seed);

            // Study the generated numbers
            while(list.isEmpty() == false){
                list.remove(list.get(list.size() - 1));
            }
            for (int j = 0; j < counter.length; j++) {
                counter[j] = 0;
            }

            int g = genNumbers[i];
            for (int n = 0; n < 5; n++) {

                int d = g % 10;
                g /= 10;
                counter[d]++;

            }

            for (int m = 0; m < counter.length; m++) {
                if (counter[m] != 0) {
                    list.add(counter[m]);
                }
            }

            /**
             * All different case[0]
             * One Pair case[1]
             * Two Pairs case[2]
             * Three of a kind case[3]
             * Full House case[4]
             * Four of a kind case[5]
             * Five of a kind case[6]++
             */
            switch (list.size()) {
                case 1:
                    cases[6]++;
                    break;
                case 2:
                    if (list.get(0) == 3 || list.get(0) == 2) {
                        cases[4]++;
                    } else {
                        cases[5]++;
                    }
                    break;

                case 3:
                    if (list.get(0) == 2 || list.get(1) == 2) {
                        cases[2]++;
                    } else {
                        cases[3]++;
                    }
                    break;

                case 4:
                    cases[1]++;
                    break;
                case 5:
                    cases[0]++;
                    break;

            }
        }

        double end = System.currentTimeMillis();

        System.out.println("Generated Numbers Array : ");
        for (int i = 0; i < genNumbers.length; i++) {
            System.out.print(genNumbers[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < cases.length; i++){
            System.out.print(cases[i] + " ");
        }

        System.out.println();
        System.out.println("The program execution time : " + (end - start));

    }

    public static long genPseudoRand(long seed){
        //long seed = 1;
        int a = 1664525;
        long c = 1013904223;
        long m = (long)Math.pow(2, 32);
        seed = (a * seed + c) % m;
        String s = "";
        s += seed;

        s = s.substring(1, 6);
        int num = Integer.parseInt(s);
        return num;
    }

}
