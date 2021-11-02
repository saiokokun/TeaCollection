package WhatTea;
import java.util.Scanner;

public class TeMeny {

    public void TeaInteraction(TeaDatabase SparaTe){
        boolean running = true;
        while(running) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("1. Lägg till te \r\n2. Ta bort te.\r\n3. Random te\r\n4. Visa alla teer\r\nTo quit, write \"quit\"");
            System.out.print("\n> ");
            // 2. Läs in kommando från användaren
            String input = userInput.nextLine();
             if (input.equalsIgnoreCase("1")) {
                 TeaDatabase sparaTe = new TeaDatabase();
                 sparaTe.NyttTe();
                 sparaTe.Filler();
                }

            else if (input.equalsIgnoreCase("2")) { //Ta bort te
                System.out.println("Du valde 2");
                TeaDatabase taBortTe = new TeaDatabase();
                taBortTe.TaBortTe();
                taBortTe.Filler();

            }

             else if (input.equalsIgnoreCase("3")) { //Random te
                 System.out.println("Du valde 3");
                 TeaDatabase randomTe = new TeaDatabase();
                 randomTe.RandomTe();
                 randomTe.Filler();
             }

             else if (input.equalsIgnoreCase("4")) { //Visa alla teer
                 System.out.println("Du valde 4");
                 TeaDatabase visaAllaTeer = new TeaDatabase();
                 visaAllaTeer.VisaAllaTeer();
                 visaAllaTeer.Filler();
             }
             else if(input.equalsIgnoreCase("quit")) {
                 running = false;
             }

        }
        //return;
    }
}
