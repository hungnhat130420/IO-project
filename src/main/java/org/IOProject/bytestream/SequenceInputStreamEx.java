package org.IOProject.bytestream;

import java.io.*;

public class SequenceInputStreamEx {
    private static final String str = "This is the string that needs to be written to the file";
    private static final File dictionary = new File("src/main/resources/sequenceStream");
    private static final File file1 = new File(dictionary, "file1.txt");
    private static final File file2 = new File(dictionary, "file2.txt");
    private static final File combinedFile = new File(dictionary, "combinedFile.txt");

    public static void main(String[] args) throws IOException {
        if (!dictionary.exists()) {
            dictionary.mkdirs();  // Create directories if they do not exist
        }
        createFileIfNotExists(file1);
        createFileIfNotExists(file2);

        writeFileToCombineFile();
    }

    private static void createFileIfNotExists(File file) throws IOException {
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(str.getBytes());
            }
        }
    }

    // Function to write 2 files to combine file using sequence stream
    private static void writeFileToCombineFile() throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;

        try (FileInputStream f1 = new FileInputStream(file1);
             FileInputStream f2 = new FileInputStream(file2);
             SequenceInputStream sequenceInputStream = new SequenceInputStream(f1, f2);
             FileOutputStream combine = new FileOutputStream(combinedFile)) {

            while ((bytesRead = sequenceInputStream.read(buffer)) != -1) {
                combine.write(buffer, 0, bytesRead);
            }

            System.out.println("Files combined successfully !!!");
        }
    }
}