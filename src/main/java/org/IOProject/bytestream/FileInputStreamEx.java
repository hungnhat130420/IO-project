package org.IOProject.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {
    private static final String file1 = "src/main/resources/byteStream/file1.txt";
    private static final String file2 = "src/main/resources/byteStream/file2.txt";
    private static final String fileContent = "this is the content that need to write to the file1";
    private static final String directory = "src/main/resources/byteStream/dir1";

    public static void main(String[] args) throws IOException {
        writeStringToFile();
        writeFileToFile();
        copyFileToDir();
    }

    //function to write file to file
    private static void writeFileToFile() throws IOException {
        File fileObject = new File(file1);
        File fileObject2 = new File(file2);
        FileInputStream in = new FileInputStream(fileObject);
        FileOutputStream out = new FileOutputStream(fileObject2);
        try {
            byte[] bytes = new byte[(int) fileObject.length()];
            int bytesRead;
            while((bytesRead = in.read(bytes)) != -1){
                out.write(bytes, 0, bytesRead);
            }

//            while((bytesRead = in.read(bytes)) != -1){
//                String content = new String(bytes, 0, bytesRead);
//                String toWrite = content.substring(content.lastIndexOf("content"));
//                out.write(toWrite.getBytes());
//            }
//            System.out.println("File copied successfully !!!");

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }

    //function to copy file1 to dir and delete
    private static void copyFileToDir() throws IOException {
        //source file1
        File f1 = new File(file1);
        File f2 = new File(file2);
        //destination file1
        String desFile1 = "file1.txt";
        String desFile2 = "file2.txt";
        File desf1 = new File(directory, desFile1);
        File desf2 = new File(directory, desFile2);
        File dir1 = new File(directory);

        FileInputStream in1 = new FileInputStream(f1);
        FileOutputStream out1 = new FileOutputStream(desf1);
        FileInputStream in2 = new FileInputStream(f2);
        FileOutputStream out2 = new FileOutputStream(desf2);

        if(!dir1.exists()) {
            dir1.mkdir();
        }

        //copy file1 to dir
        byte[] bytes1 = new byte[(int) f1.length()];
        int bytesRead1;
        while((bytesRead1 = in1.read(bytes1)) != -1) {
            out1.write(bytes1, 0, bytesRead1);
        }
        //copy file2 to dir
        byte[] bytes2 = new byte[(int) f2.length()];
        int bytesRead2;
        while((bytesRead2 = in2.read(bytes2)) != -1) {
            out2.write(bytes2, 0, bytesRead2);
        }
        System.out.println("File copied successfully !!!");

        // Delete file1 and file2 after copying
        in1.close();
        in2.close();
        out1.close();
        out2.close();
        if (f1.delete()) {
            System.out.println("File1 deleted successfully.");
        } else {
            System.out.println("Failed to delete file1.");
        }

        if (f2.delete()) {
            System.out.println("File2 deleted successfully.");
        } else {
            System.out.println("Failed to delete file2.");
        }
    }

    //function to write a string to file
    private static void writeStringToFile() {
        File fileObject = new File(file1);
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(fileObject);
            out = new FileOutputStream(fileObject);
            // write string to file1
            out.write(fileContent.getBytes());
            out.flush();
            // read file1 after write
            byte[] bytes = new byte[(int) fileObject.length()];
            int bytesRead;
            while ((bytesRead = in.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, bytesRead));
            }
        } catch (IOException e){
           throw new RuntimeException(e);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
