package com.spartaglobal.Alpari;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RatesFileReader {

    private FileReader ratesFile;

    public RatesFileReader(String filePath){

        try {
            ratesFile = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FileReader getRatesfile() {
        return ratesFile;
    }
}
