package TeaCollection;
import java.util.Scanner;


public class TeMeny {

    public void teaInteraction(){ //Interaktionsmeny för de olika alternativen
        boolean running = true;
        while(running) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("1. Lägg till te \r\n2. Ta bort te.\r\n3. Random te\r\n4. Visa alla teer\r\nTo quit, write \"quit\"");
            System.out.print("\n> ");
            String input = userInput.nextLine();//Läs in kommando från användaren

             if (input.equalsIgnoreCase("1")) { //Lägg till ett nytt te
                 TeaDatabase sparaTe = new TeaDatabase();
                 sparaTe.nyttTe();
                 TeaDatabase.filler();
             }

            else if (input.equalsIgnoreCase("2")) { //Ta bort te
                System.out.println("Du valde 2");
                TeaDatabase taBortTe = new TeaDatabase();
                taBortTe.taBortTe();
                TeaDatabase.filler();
            }

             else if (input.equalsIgnoreCase("3")) { //Random te
                 System.out.println("Du valde 3");
                 TeaDatabase randomTe = new TeaDatabase();
                 randomTe.randomTe();
                 TeaDatabase.filler();
             }

             else if (input.equalsIgnoreCase("4")) { //Visa alla teer
                 System.out.println("Du valde 4");
                 TeaDatabase visaAllaTeer = new TeaDatabase();
                 visaAllaTeer.visaAllaTeer();
                 TeaDatabase.filler();
             }

             else if (input.equalsIgnoreCase("Easteregg")) { //Secret....shhhhh
                 EasterEgg randomSkamt = new EasterEgg();
                 randomSkamt.randomSkamt();
                 randomSkamt.sound();
                 TeaDatabase.filler();
             }

             else if(input.equalsIgnoreCase("quit")) { //stoppar applikationen
                 running = false;
             }
             else {
                 System.out.println("Please provide a valid input from the chooses given");
             }
        }
    }
}
