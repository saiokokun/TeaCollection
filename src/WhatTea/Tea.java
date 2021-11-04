package WhatTea;
import java.io.Serializable;

public class Tea implements Serializable {//Konstruktorklassen
    String Name;
    String Description;
    String CookTime;

    public Tea(String Name, String Description, String CookTime) {//Konstruktorn för att skapa nya teer
        this.Name = Name;
        this.Description = Description;
        this.CookTime = CookTime;
    }
}
