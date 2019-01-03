package com.ntu.api.domain.listCreate;

import java.io.*;
import java.util.ArrayList;

public class Writer {
    public void write(File file, ArrayList list){
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(list);
            oos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
