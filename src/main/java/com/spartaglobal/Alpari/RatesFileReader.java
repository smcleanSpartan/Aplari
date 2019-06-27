package com.spartaglobal.Alpari;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RatesFileReader {

    //FileReader variable.
    private FileReader ratesFile;

    public RatesFileReader(String filePath) {

        try {
            //Instance of FileReader using file path from the parameter.
            ratesFile = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FileReader getRatesFile() {
        return ratesFile;
    }
}

