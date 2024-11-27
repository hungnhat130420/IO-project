package org.IOProject.characterstream;

import java.io.*;
import java.util.Arrays;

public class FileReaderEx {
    private static final String str = "This is the string that needs to be written to the file";
    private static final File DICTIONARY = new File("src/main/resources/fileReader");
    private static final File FILE1 = new File(DICTIONARY, "file1.txt");

//    public static void main(String[] args) {
//            try (CharArrayWriter charArrayWriter = new CharArrayWriter()) {
//                charArrayWriter.write("Hello, World");
//                charArrayWriter.write("CharArrayWriter Example");
//
//                // Chuyển mảng ký tự thành chuỗi và hiển thị
//                System.out.println(charArrayWriter.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//    }
//    public static void main(String[] args) throws IOException {
//        writeStringToFile();
//        readStringFromVariable();
//    }

    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            long longValue = dis.readLong();

            System.out.println("Int: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Long: " + longValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeStringToFile() throws IOException {
        // Create directory if it does not exist
        if (!DICTIONARY.exists()) {
            DICTIONARY.mkdir();
        }
        if (!FILE1.exists()) {
            FILE1.createNewFile();

        }
        try (FileWriter writer = new FileWriter(FILE1)) {
            writer.write(str);
        }
    }

    private static void readStringFromVariable() {
        // Use StringReader to read the string
        try (StringReader reader = new StringReader(str)) {
            int readChar;
            while ((readChar = reader.read()) != -1) {
                System.out.print((char) readChar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}