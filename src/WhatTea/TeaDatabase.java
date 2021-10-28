package WhatTea;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
public class TeaDatabase {
//public interface DontForget{
   // void StorageExists();
    //void GetAllTeas();
    //void StoreAllTeas();
//}
TeMeny Read = new TeMeny();
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

//Random number generator
    public void RandomTea() {
        RandomNumber Number = new RandomNumber();
    }
}