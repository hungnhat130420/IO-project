package org.IOProject.bytestream;

import java.io.*;

public class PipedStreamEx {
    private static final String str = "This is the string need to write to the file";
    private static final File dictionary = new File("src/main/resources/pipedStream");
    private static final File file1 = new File(dictionary, "file1.txt");
    private static final File file2 = new File(dictionary, "file2.txt");
    public static void main(String[] args) throws IOException, InterruptedException {
        readStringToFile();
    }
    private static void readStringToFile() throws IOException, InterruptedException {
        //create directory if not exist
        if(!dictionary.exists()) {
            dictionary.mkdir();
        }
        // write string to 2 files use piped stream
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        //write string use thread and pipedoutputstream
        Thread writeThread = new Thread(()-> {
            try {
                out.write(str.getBytes());
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // use 2 threads to write str to file
        Thread readThread = new Thread(()-> {
            try (FileOutputStream fileOut1 = new FileOutputStream(file1);
                 FileOutputStream fileOut2 = new FileOutputStream(file2)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fileOut1.write(buffer, 0, bytesRead);
                    fileOut2.write(buffer, 0, bytesRead);
                }
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //start threads
        writeThread.start();
        readThread.start();

        writeThread.join();
        readThread.join();
        System.out.println("File copied successfully !!!");
    }
}
