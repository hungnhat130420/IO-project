package org.IOProject.bytestream;

import java.io.*;

public class ByteArrayInputEx {
    private static final String file1 = "file1.txt";
    private static final String file2 = "file2.txt";
    private static final String directory = "src/main/resources/byteArrayStream";
    private static final String str = "This is string need to convert to byte array and write to file";
    public static void main(String[] args) throws IOException {
//        readStringToArray();
        writeStringToFile();
    }

    //function to read a string to byte array
    private static void readStringToArray() throws IOException {
        byte[] byteString = str.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(byteString);
        int readByte;
        byte[] readBytes = new byte[byteString.length];
        while((readByte = in.read(readBytes)) != -1){
            System.out.print((char) readByte);
        }
    }

    //function to write string to file use byte array
    private static void writeStringToFile() throws IOException{
        // create directory if not exist
        File dir = new File(directory);
        if(!dir.exists()) {
            dir.mkdir();
        }

        //create file
        File f1 = new File(directory, file1);
        File f2 = new File(directory, file2);
        FileOutputStream out1 = new FileOutputStream(f1);
        FileOutputStream out2 = new FileOutputStream(f2);

        //option 1 : use byteArrayInputStream to read bytes from string and then write to file
//        byte[] bytesString = str.getBytes();
//        ByteArrayInputStream in = new ByteArrayInputStream(bytesString);
//
//        //write to file 1
//        int readByte1;
//        while((readByte1 = in.read(bytesString)) != -1){
//            out1.write(bytesString, 0, readByte1);
//        }
//
//        //write to file 2
//        int readByte2;
//        // need to reset the stream to write to another file
//        in.reset();
//        while((readByte2 = in.read(bytesString)) != -1){
//            out2.write(bytesString, 0, readByte2);
//        }

        //option 2: use byteArrayOutputStream to convert string to byte array and then write to file
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(str.getBytes());
        byte[] bytes = out.toByteArray();
        out1.write(bytes);
        out2.write(bytes);
//        byte[] byteString = str.getBytes();


    }
}
