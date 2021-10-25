package WhatTea;
import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Scanner;
public class TeMeny {

    public void TeaInteraction(TeaDatabase SparaTe){
        boolean running = true;
        while(running) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("1. Lägg till te \r\n2. Ta bort te.\r\n3. Random te\r\n4. Visa alla teer\r\nQuit");
            System.out.print("\n> ");
            // 2. Läs in kommando från användaren
            String input = userInput.nextLine();
             if (input.equalsIgnoreCase("1")) {
                 ArrayList<Tea> TeaSaver = SparaTe.GetAllTeas();
                System.out.println("Du valde 1");
                 System.out.println("Vad ska teet heta?");
                 String newTeaName = userInput.nextLine();
                 System.out.println("Vad är det för te?");
                 String newTeaDescription = userInput.nextLine();
                 System.out.println("Vad är koktiden?");
                 String newTeaCookTime = userInput.nextLine();
                 Tea New = new Tea(newTeaName, newTeaDescription, newTeaCookTime);
                 TeaSaver.add(New);
                 SparaTe.StoreAllTeas(TeaSaver);


                }
            else if (input.equalsIgnoreCase("2")) { //Ta bort te
                System.out.println("Du valde 2");
            }
             else if (input.equalsIgnoreCase("3")) { //Random te
                 System.out.println("Du valde 3");
             }
             else if (input.equalsIgnoreCase("4")) { //Visa alla teer
                 System.out.println("Du valde 4");
                 System.out.println(SparaTe.GetAllTeas());

             }
             else if(input.equalsIgnoreCase("quit")) {
                running = false;
             }
        }

    }




}
