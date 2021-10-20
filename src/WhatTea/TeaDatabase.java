package WhatTea;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
public class TeaDatabase {


//Skapa ny Te fil i txt
    public void Storageexists(){
        File Storagefile = new File("./src/WhatTea/tesorter.txt");
        if (!Storagefile.exists()){
            try{
                Storagefile.createNewFile();
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
        for (int i = 0; i < TeaBox.size(); i++) {
            System.out.println(TeaBox.get(i).Name + " " + TeaBox.get(i).Description);
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
            System.out.println("The Tea is saved");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Could not save Tea");
        }
    }

//Random number generator
    public void RandomTea() {
        RandomNumber Number = new RandomNumber();
    }
}