import TeaCollection.Tea;
import TeaCollection.TeaDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;


public class Testing {

    @Test
    public void doesSaveFileExist() { //Kolla om sparfilen för teerna finns
        File file = new File("./src/TeaCollection/tesorter.txt");
        if (file.exists()) {
            System.out.println("Savefile for Teas exist");
            Assertions.assertTrue(true);
        } else {
            System.out.println("Savefile for Teas doesnt exist");
            Assertions.fail();
        }
    }

    @Test
    public void doesGnomedExist(){ //Kolla om ljudfilen för gnomed.wav finns
        File file = new File ("./src/TeaCollection/gnomed.wav");
        if (file.exists()) {
            System.out.println("Gnomed.wav for easteregg exist");
            Assertions.assertTrue(true);
        } else {
            System.out.println("Gnomed.wav for easteregg doesent exist");
            Assertions.fail();
        }
    }

    @Test
    public void testFakeTeaConstructor() { //Kolla om konstruktorn funkar
        try {
            new Tea("fake", "tea", "testing");
        } catch (Exception e) {
            System.out.println("Theres something wrong with the Tea constructor");
            Assertions.fail(e.getMessage());
            Assertions.fail();
        }
        System.out.println("Tea constructor works on 3 parimiters");
        Assertions.assertTrue(true);
    }

    @Test
    public void doesTeaExist(){//Kollar om tefilen innehåller något (kommer faila om program aldrig körts)
        TeaDatabase visaAllaTeer = new TeaDatabase();
        if (visaAllaTeer.getAllTeas().size() != 0){
            System.out.println("Tea savefile is not empty");
            Assertions.assertTrue(true);
        }
        else {
            System.out.println("Tea savefile is empty");
            Assertions.fail();
        }
    }

    @Test
    public void doesSecretFileExist() { //Kollar om sparfilen för alla "skämt" finns
        File file = new File("./src/TeaCollection/secret.txt");
        if (file.exists()) {
            System.out.println("Savefile for Secret exist");
            Assertions.assertTrue(true);
        }
        else {
            System.out.println("Savefile for Secret doesnt exist");
            Assertions.fail();
        }
    }
}
