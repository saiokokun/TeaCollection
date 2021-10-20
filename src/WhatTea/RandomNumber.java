package WhatTea;
import java.util.Random;

public class RandomNumber {
    public int GetNum()
    {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 4
        int RandomNum = rand.nextInt(4);


        // Print random integers
        System.out.println("Random Integers: " + RandomNum);
        return RandomNum;


    }
}
