import org.junit.jupiter.api.Test;

import java.io.*;

public class IOStreamTest {

    @Test
    public void readBufferInMemory() throws IOException {

        byte[] buffer = "hello".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);

        int number;
        char character;

        while ((number = inputStream.read())!=-1){
            character = (char) number;
            System.out.printf("%c:%d%n",character,number);
        }

        inputStream.close();
    }

    @Test
    public void readBinary() throws IOException {
        String imageFile = "/Users/will/Documents/Others/TestData/Grainstack at Sunset.jpeg";
        FileInputStream fileInputStream = new FileInputStream(imageFile);

        byte[] buffer = new byte[10];
        while (fileInputStream.read(buffer)!=-1){
            for (byte b: buffer)
                System.out.print(b);
        }

        fileInputStream.close();
        //Sometimes, byte can not be converted to char because they have different ranges.
    }

    @Test
    public void readFile() throws IOException {
        //
        String readingTextFile = "/Users/will/Documents/Others/TestData/TextReadingTest.txt";
        FileInputStream fileInputStream =  new FileInputStream(readingTextFile);
        int number;
        char character;

        while ((number = fileInputStream.read())!=-1){
            character = (char) number;
            System.out.printf("%c:%d%n",character,number);
        }

        fileInputStream.close();
    }

    @Test
    public void readFileByBuffer() throws IOException {
        String readingTextFile = "/Users/will/Documents/Others/TestData/TextReadingTest.txt";
        FileInputStream fileInputStream =  new FileInputStream(readingTextFile);

        byte[] buffer = new byte[10];
        while (fileInputStream.read(buffer)!=-1){
            for (byte b: buffer)
                System.out.printf("%c%n",b);
        }

        fileInputStream.close();
    }

    public void writeCharacter(){}

    public void writeBinary(){}

    public void writeFile(){}

}
