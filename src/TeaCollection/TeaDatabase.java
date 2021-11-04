package TeaCollection;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class TeaDatabase {

    public void storageExists() { //Skapa ny Te fil i txt
        File StorageFile = new File("./src/TeaCollection/tesorter.txt");
        if (!StorageFile.exists()){ //Om sparfilen för Te inte finns, skapa en ny
            try{
                StorageFile.createNewFile();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public ArrayList<Tea> getAllTeas() { //Läs in alla teer från Txt filen
        ArrayList <Tea> teaConstructorBoxes = new ArrayList<>();
            try{
            FileInputStream in = new FileInputStream("./src/TeaCollection/tesorter.txt");
            ObjectInputStream inOBJ = new ObjectInputStream(in);
            teaConstructorBoxes = (ArrayList<Tea>)inOBJ.readObject();
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return teaConstructorBoxes;
    }

    public void storeAllTeas(ArrayList <Tea> teaConstructorBoxes){ //Spara Te i txt filen
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/TeaCollection/tesorter.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
            objectOutputStream.writeObject(teaConstructorBoxes);
            objectOutputStream.close();
            System.out.println("\nThe Tea is saved");
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("\nCould not save Tea");
        }
    }

    public void nyttTe() { //Lägg till nytt te
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Du valde 1");
        System.out.println("Vad ska teet heta?");
        String newTeaName = newScanner.nextLine();
        if (newTeaName == null) {
            System.out.println("Cannot have null input, try again");
            return;
        }
        System.out.println("Vad är det för te?");
        String newTeaDescription = newScanner.nextLine();
        if (newTeaDescription == null) {
            System.out.println("Cannot have null input, try again");
            return;
        }
        System.out.println("Vad är koktiden?");
        String newTeaCookTime = newScanner.nextLine();
        if (newTeaCookTime == null) {
            System.out.println("Cannot have null input, try again");
            return;
        }
        Tea New = new Tea(newTeaName, newTeaDescription, newTeaCookTime);
        TeaDatabase Save = new TeaDatabase();
        ArrayList<Tea> teaConstructorSaver = Save.getAllTeas();
        teaConstructorSaver.add(New);
        storeAllTeas(teaConstructorSaver);
    }

    public void taBortTe(){ //Ta bort te från listan
        ArrayList<Tea> teaConstructorLoader = getAllTeas();
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Är du säker på att ta bort te? Y/N");
        String userInput = newScanner.nextLine();
        if (userInput.equalsIgnoreCase("Y")) {
            for (int i = 0; i < teaConstructorLoader.size(); i++) {
                System.out.println("\n Number " + (i) + "\n|Name:| " + teaConstructorLoader.get(i).Name + " " + "\n|Description:| " + teaConstructorLoader.get(i).Description + " " + "\n|Cooktime:| " + teaConstructorLoader.get(i).CookTime + "\n");
            }
            System.out.println("Vilken till du ta bort? Skriv nummer");
            System.out.print("\n> ");
            int taBortInput = Integer.parseInt(newScanner.nextLine());
            teaConstructorLoader.remove(taBortInput);
            storeAllTeas(teaConstructorLoader);
        }
        else {
            System.out.println("Ångrat, återvänder\n");
        }
    }

    public void randomTe(){ //Ta fram ett random te från listan
        ArrayList<Tea> teaConstructorLoader = getAllTeas();
        int NumberSize = teaConstructorLoader.size();
        Random TeaRandom = new Random();
        int int_random = TeaRandom.nextInt(NumberSize);
        System.out.println("\n|Name:| " + teaConstructorLoader.get(int_random).Name + " " + "\n|Description:| " + teaConstructorLoader.get(int_random).Description + " " + "\n|Cooktime:| " + teaConstructorLoader.get(int_random).CookTime + "\n");
    }
    public void visaAllaTeer(){//Visa alla teer som finns i en layout
        ArrayList<Tea> teaConstructorLoader = getAllTeas();
        int i= 1;
        for (Tea tea : teaConstructorLoader) {
            System.out.println("\n Number " + (i) +"\n|Name:| " + tea.Name + " " + "\n|Description:| " + tea.Description + " " + "\n|Cooktime:| " + tea.CookTime + "\n");
            i++;
        }
    }

    public static void filler(){ //Filler för aesthetics
        Scanner newScanner = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("Press enter to continue");
        System.out.println("--------------");
        System.out.print("\n>");
        newScanner.nextLine();
        System.out.println("\n\n\n\n\n\n\n");
    }
}
