package prasad.research.java.split.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // REFERENCE:
    // https://javabeat.net/java-split-merge-files/

    public static void main(String[] args) {
        //split();
        merge();
    }

    private static void split() {
        File inputFile = new File("pdf.zip");
        FileInputStream inputStream;
        String newFileName;
        FileOutputStream filePart;
        int fileSize = (int) inputFile.length();
        int nChunks = 0, read = 0, readLength = 50_000;
        byte[] byteChunkPart;
        try {
            inputStream = new FileInputStream(inputFile);
            while (fileSize > 0) {
                if (fileSize <= 50_000) {
                    readLength = fileSize;
                }
                byteChunkPart = new byte[readLength];
                read = inputStream.read(byteChunkPart, 0, readLength);
                fileSize -= read;
                assert (read == byteChunkPart.length);
                nChunks++;
                newFileName = "pdf.zip" + ".part"
                        + Integer.toString(nChunks - 1);
                filePart = new FileOutputStream(new File(newFileName));
                filePart.write(byteChunkPart);
                filePart.flush();
                filePart.close();
                byteChunkPart = null;
                filePart = null;
            }
            inputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void merge() {
        File ofile = new File("pdf2.zip");
        FileOutputStream fos;
        FileInputStream fis;
        byte[] fileBytes;
        int bytesRead = 0;
        List<File> list = new ArrayList<File>();
        list.add(new File("pdf.zip"+".part0"));
        list.add(new File("pdf.zip"+".part1"));
        list.add(new File("pdf.zip"+".part2"));
        try {
            fos = new FileOutputStream(ofile,true);
            for (File file : list) {
                fis = new FileInputStream(file);
                fileBytes = new byte[(int) file.length()];
                bytesRead = fis.read(fileBytes, 0,(int)  file.length());
                assert(bytesRead == fileBytes.length);
                assert(bytesRead == (int) file.length());
                fos.write(fileBytes);
                fos.flush();
                fileBytes = null;
                fis.close();
                fis = null;
            }
            fos.close();
            fos = null;
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
