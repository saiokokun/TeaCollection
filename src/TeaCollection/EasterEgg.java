package TeaCollection;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


class Skamt implements Serializable {
    String Name;
    //Constructor för att skapa nya "skämt"
    public Skamt(String Name) {
        this.Name = Name;
    }
}

public class EasterEgg {
    public void skamtExists() { //Skapa ny secretfil i txt om den inte finns
        File StorageFile = new File("./src/TeaCollection/secret.txt");
        if (!StorageFile.exists()){//Om sparfilen för skämt inte finns, skapa en ny
            try{
                StorageFile.createNewFile();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public ArrayList<Skamt> getAllSkamt() { //Läs in alla skämt från Txt filen
        ArrayList <Skamt> skamtConstructorBoxes = new ArrayList<>();
        try{
            FileInputStream in = new FileInputStream("./src/TeaCollection/secret.txt");
            ObjectInputStream inOBJ = new ObjectInputStream(in);
            skamtConstructorBoxes = (ArrayList<Skamt>) inOBJ.readObject();
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return skamtConstructorBoxes;
    }

    public void storeAllSkamt(ArrayList <Skamt> skamtConstructorBoxes){ //Spara skämt i txt filen, om tillkallat
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/TeaCollection/secret.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
            objectOutputStream.writeObject(skamtConstructorBoxes);
            objectOutputStream.close();
            System.out.println("\nThe Skämt is saved");
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("\nCould not save Skämt");
        }
    }

    public void nyttSkamt(){ //Lägg till skämt, om tillkallat
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Du valde 1");
        System.out.println("Vad är skämtet?");
        String newSkamtName = newScanner.nextLine();
        if (newSkamtName == null) {
            System.out.println("Cannot have null input, try again");
            return;
        }
        Skamt New = new Skamt(newSkamtName);
        EasterEgg Save = new EasterEgg();
        ArrayList<Skamt> skamtConstructorSaver = Save.getAllSkamt();
        skamtConstructorSaver.add(New);
        storeAllSkamt(skamtConstructorSaver);
    }

    public void randomSkamt(){ //Ta fram ett random skämt från txt filen
        ArrayList<Skamt> skamtConstructorLoader = getAllSkamt();
        int NumberSize = skamtConstructorLoader.size();
        Random SkamtRandom = new Random();
        int int_random = SkamtRandom.nextInt(NumberSize);
        System.out.println(skamtConstructorLoader.get(int_random).Name );
    }

    public void visaAllaSkamt(){ //Visar alla skämt tillgängliga, om tillkallat
        ArrayList<Skamt> skamtConstructorLoader = getAllSkamt();
        for (Skamt skamt : skamtConstructorLoader) {
            System.out.println(skamt.Name);
        }
    }

    public void sound() { //Spela gnomed.wav
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResource("gnomed.wav")));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}