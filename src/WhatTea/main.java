package WhatTea;
//ladda alla classer
public class main {
        public static void main(String[] args) {
            TeaDatabase tag = new TeaDatabase();
            TeMeny load = new TeMeny();
            load.TeaInteraction(tag);
            tag.StorageExists();
        }
}
