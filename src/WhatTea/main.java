package WhatTea;

import java.io.IOException;
import java.util.ArrayList;
//ladda alla classer
public class main {
        public static void main(String[] args) {
            TeaDatabase tag = new TeaDatabase();
            //tag.toString();
            tag.Storageexists();
            //Om filen är tom
            ArrayList<Tea> TeaSaver = new ArrayList<Tea>();
            Tea GronTe = new Tea("Grön te", "1 min");
            Tea SvartTe = new Tea("Svart", "2min");
            TeaSaver.add(GronTe);
            TeaSaver.add(SvartTe);
            tag.StoreAllTeas(TeaSaver);
            ArrayList<Tea> GetAllTeas = tag.GetAllTeas();

        }
}
