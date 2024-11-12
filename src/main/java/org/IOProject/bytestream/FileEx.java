package org.IOProject.bytestream;

import java.io.File;
import java.io.IOException;

public class FileEx {
    public static void main(String[] args) {
        File file1 = new File("src/main/resources/byteStream/file1.txt");
        try {
            //create new file with File object
            file1.createNewFile();
            // println with new feature

            System.out.println(String.format("File created: %s -- exists: %s", file1.getName(), file1.exists()));
            System.out.println(String.format("Absolute path : %s -- Path : %s -- Canonical path: %s", file1.getAbsoluteFile(), file1.getPath(), file1.getCanonicalPath()));
        } catch (IOException e){
            e.getMessage();
        }

        //create directory
        File dir1 = new File("src/main/resources/byteStream/dir1");
        dir1.mkdir();
        if (dir1.exists()){
            System.out.printf("Directory created: %s -- exists: %s%n", dir1.getName(), dir1.exists());
        }


    }
}
