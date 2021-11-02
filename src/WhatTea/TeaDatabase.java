package WhatTea;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeaDatabase {

//Skapa ny Te fil i txt

    public void StorageExists() {
        File StorageFile = new File("./src/WhatTea/tesorter.txt");
        if (!StorageFile.exists()){ //Detta behövs bara för att skapa ny fil om fil inte finns. Finns risk för overwrite om denna är på 24/7
            try{
                StorageFile.createNewFile();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    //Läs in alla teer från Txt filen
    public ArrayList<Tea> GetAllTeas() {
        ArrayList <Tea> TeaBox= new ArrayList<Tea>();
        try{
            FileInputStream in = new FileInputStream("./src/WhatTea/tesorter.txt");
            ObjectInputStream inOBJ = new ObjectInputStream(in);
            TeaBox = (ArrayList<Tea>) inOBJ.readObject();

        }
        catch (Exception e){
            e.getStackTrace();

        }


        return TeaBox;

    }


    //Spara Te i txt filen
    public void StoreAllTeas(ArrayList <Tea> TeaBox ){
        File file = new File("./src/WhatTea/tesorter.txt");
        try {
            //ev formatering med C: istället för ./ (C:\Users\nikos7\Desktop\ob)
            FileOutputStream fileOut = new FileOutputStream("./src/WhatTea/tesorter.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
            objectOutputStream.writeObject(TeaBox);
            objectOutputStream.close();
            System.out.println("\nThe Tea is saved");

        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("\nCould not save Tea");
        }

    }

    public void NyttTe(){ //Lägg till te
        Scanner newScanner = new Scanner(System.in);
        //String userInput = newScanner.nextLine();
        TeaDatabase spara = new TeaDatabase();

        System.out.println("Du valde 1");
        System.out.println("Vad ska teet heta?");
        String newTeaName = newScanner.nextLine();
        System.out.println("Vad är det för te?");
        String newTeaDescription = newScanner.nextLine();
        System.out.println("Vad är koktiden?");
        String newTeaCookTime = newScanner.nextLine();
        Tea New = new Tea(newTeaName, newTeaDescription, newTeaCookTime);
        TeaDatabase Save = new TeaDatabase();
        ArrayList<Tea> TeaSaver = Save.GetAllTeas();
        TeaSaver.add(New);
        StoreAllTeas(TeaSaver);



    }
    public void TaBortTe(){ //Ta bort te från listan
        ArrayList<Tea> TeaLoader = GetAllTeas();
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Är du säker på att ta bort te? Y/N");
        String userInput = newScanner.nextLine();
        if (userInput.equalsIgnoreCase("Y")) {
            for (int i = 0; i < TeaLoader.size(); i++) {
                System.out.println("\n Number " + (i) + "\n|Name:| " + TeaLoader.get(i).Name + " " + "\n|Description:| " + TeaLoader.get(i).Description + " " + "\n|Cooktime:| " + TeaLoader.get(i).CookTime + "\n");
            }
            System.out.println("Vilken till du ta bort? Skriv nummer");
            System.out.print("\n> ");
            int taBortInput = Integer.parseInt(newScanner.nextLine());
            TeaLoader.remove(taBortInput);
            StoreAllTeas(TeaLoader);
        }
        else {
            System.out.println("Ångrat, återvänder\n");
        }
    }
    public void RandomTe(){ //Ta fram ett random te från listan
        ArrayList<Tea> TeaLoader = GetAllTeas();
        TeaLoader.contains(TeaLoader.size());
        int NumberSize = TeaLoader.size();
        Random TeaRandom = new Random();
        int upperbound = NumberSize;
        int int_random = TeaRandom.nextInt(upperbound);
        System.out.println("\n|Name:| " + TeaLoader.get(int_random).Name + " " + "\n|Description:| " + TeaLoader.get(int_random).Description + " " + "\n|Cooktime:| " + TeaLoader.get(int_random).CookTime + "\n");


    }
    public void VisaAllaTeer (){
        ArrayList<Tea> TeaLoader = GetAllTeas();
        TeaLoader.contains(TeaLoader.size());

        for (int i = 0; i < TeaLoader.size(); i++) {
            System.out.println("\n|Name:| " + TeaLoader.get(i).Name + " " + "\n|Description:| " + TeaLoader.get(i).Description + " " + "\n|Cooktime:| " + TeaLoader.get(i).CookTime + "\n");
        }
    }


    public void Filler(){ //Filler för aesthetics
        Scanner newScanner = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("Press enter to continue");
        System.out.println("--------------");
        System.out.print("\n>");
        String ignoreInput = newScanner.nextLine();
        System.out.println("\n\n\n\n\n\n\n");



    }
}
