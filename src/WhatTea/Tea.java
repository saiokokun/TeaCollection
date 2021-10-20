package WhatTea;
import java.io.Serializable;

public class Tea implements Serializable {
    String Name;
    String Description;
//Basen för att skapa nya teer
    public Tea(String Name, String Description) {
        this.Name = Name;
        this.Description = Description;
    }
}
