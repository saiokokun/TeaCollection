package WhatTea;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeMeny {

    public Object TeaInteraction(TeaDatabase SparaTe){
        boolean running = true;
        while(running) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("1. Lägg till te \r\n2. Ta bort te.\r\n3. Random te\r\n4. Visa alla teer\r\nTo quit, write \"quit\"");
            System.out.print("\n> ");
            // 2. Läs in kommando från användaren
            String input = userInput.nextLine();
             if (input.equalsIgnoreCase("1")) {
                System.out.println("Du valde 1");
                 System.out.println("Vad ska teet heta?");
                 String newTeaName = userInput.nextLine();
                 System.out.println("Vad är det för te?");
                 String newTeaDescription = userInput.nextLine();
                 System.out.println("Vad är koktiden?");
                 String newTeaCookTime = userInput.nextLine();
                 Tea New = new Tea(newTeaName, newTeaDescription, newTeaCookTime);
                 TeaDatabase Save = new TeaDatabase();
                 ArrayList<Tea> TeaSaver = Save.GetAllTeas();
                 TeaSaver.add(New);
                 SparaTe.StoreAllTeas(TeaSaver);
                }
            else if (input.equalsIgnoreCase("2")) { //Ta bort te
                System.out.println("Du valde 2");
                 ArrayList<Tea> TeaLoader = SparaTe.GetAllTeas();
                 System.out.println("Är du säker på att ta bort te? Y/N");
                 String userInputSure = userInput.nextLine();
                 if (userInputSure.equalsIgnoreCase("Y")) {
                     for (int i = 0; i < TeaLoader.size(); i++) {
                         System.out.println("\n Number " + (i) + "\n|Name:| " + TeaLoader.get(i).Name + " " + "\n|Description:| " + TeaLoader.get(i).Description + " " + "\n|Cooktime:| " + TeaLoader.get(i).CookTime + "\n");
                     }
                     System.out.println("Vilken till du ta bort? Skriv nummer");
                     System.out.print("\n> ");
                     int taBortInput = Integer.parseInt(userInput.nextLine());
                     TeaLoader.remove(taBortInput);
                     SparaTe.StoreAllTeas(TeaLoader);
                 }
                 else {
                     System.out.println("Ångrat, återvänder\n");
                 }
            }
             else if (input.equalsIgnoreCase("3")) { //Random te
                 System.out.println("Du valde 3");
                 ArrayList<Tea> TeaLoader = SparaTe.GetAllTeas();
                 TeaLoader.contains(TeaLoader.size());
                 int NumberSize = TeaLoader.size();
                 Random TeaRandom = new Random();
                 int upperbound = NumberSize;
                 int int_random = TeaRandom.nextInt(upperbound);
                 System.out.println("\n|Name:| " + TeaLoader.get(int_random).Name + " " + "\n|Description:| " + TeaLoader.get(int_random).Description + " " + "\n|Cooktime:| " + TeaLoader.get(int_random).CookTime + "\n");
             }
             else if (input.equalsIgnoreCase("4")) { //Visa alla teer
                 System.out.println("Du valde 4");
                 //System.out.println(SparaTe.GetAllTeas());
                 ArrayList<Tea> TeaLoader = SparaTe.GetAllTeas();
                 TeaLoader.contains(TeaLoader.size());

                 for (int i = 0; i < TeaLoader.size(); i++) {
                     System.out.println("\n|Name:| " + TeaLoader.get(i).Name + " " + "\n|Description:| " + TeaLoader.get(i).Description + " " + "\n|Cooktime:| " + TeaLoader.get(i).CookTime + "\n");
                 }
             }
             else if(input.equalsIgnoreCase("quit")) {
                 return input;
             }
        }
        return null;
    }
}
