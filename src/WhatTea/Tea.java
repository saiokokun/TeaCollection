package WhatTea;
import java.io.Serializable;

public class Tea implements Serializable {
    String Name;
    String Description;
    String CookTime;
//Basen för att skapa nya teer
    public Tea(String Name, String Description, String CookTime) {
        this.Name = Name;
        this.Description = Description;
        this.CookTime = CookTime;
    }
}
