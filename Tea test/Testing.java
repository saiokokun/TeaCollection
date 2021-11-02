import WhatTea.Tea;
import WhatTea.TeaDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Testing {
    @Test public void TestStoreAllTeas(){
        TeaDatabase testing = new TeaDatabase();
        ArrayList <Tea> teaArray = testing.GetAllTeas();
        for (Tea tea : teaArray){
            Assertions.assertNotNull(tea);
        }

    }


}
