package WhatTea;
import java.util.ArrayList;
import java.util.Scanner;
public class TeMeny {

    public void LaggTillTe(TeaDatabase SparaTe){
        boolean running = true;
        while(running) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("1. Lägg till te \r\n2. Ta bort te.\r\n3. Random te\r\n4. Visa alla teer");
            System.out.print("\n> ");
            // 2. Läs in kommando från användaren
            String input = userInput.nextLine();
             if (input.equalsIgnoreCase("1")) {
                 ArrayList<Tea> TeaSaver = SparaTe.GetAllTeas();
                System.out.println("Du valde 1");
                 System.out.println("Vad ska teet heta?");
                 String newTeaName = userInput.nextLine();
                 System.out.println("Vad är koktiden?");
                 String newTeaDescription = userInput.nextLine();
                 Tea New = new Tea(newTeaName, newTeaDescription);
                 TeaSaver.add(New);
                 SparaTe.StoreAllTeas(TeaSaver);


                }
            else if (input.equalsIgnoreCase("2")) {
                System.out.println("Du valde 2");
            }
             else if (input.equalsIgnoreCase("3")) {
                 System.out.println("Du valde 3");
             }
             else if (input.equalsIgnoreCase("4")) {
                 System.out.println("Du valde 4");
                 System.out.println(SparaTe.GetAllTeas());

             }
             else if(input.equalsIgnoreCase("quit")) {
                running = false;
             }
        }

    }




}
