package com.ntu.api.domain.listCreate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Writer {
    public void write(File file, ArrayList list){
        try{
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()){
                parent.mkdirs();
            }
            try(FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(list);
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
