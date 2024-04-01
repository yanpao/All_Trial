import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HadoopTest {

    private static HDFSSettings hdfsSettings;

    @BeforeAll
    public static void initialize(){
        hdfsSettings = new HDFSSettings();
    }

    @Test
    public void getRootDirectorInfo() throws IOException {
        FileReading fileReading = new FileReading(hdfsSettings.fileSystem);
        fileReading.readRootDirector();
    }

    @Test
    public void readOrdinaryFiles() throws IOException {
        FileReading fileReading = new FileReading(hdfsSettings.fileSystem);
        fileReading.readOrdinaryFileToMemory("/hadoop install.txt",80);
    }

    @Test
    public void readZipFileToMemory() throws IOException {
        FileReading fileReading = new FileReading(hdfsSettings.fileSystem);
        fileReading.readZipFileToMemory("/hadoop install.txt.zip");
    }

    @Test
    public void readZipFileToMemory2() throws IOException {
        FileReading fileReading = new FileReading(hdfsSettings.fileSystem);
        fileReading.readZipFileToMemory("/Archive.zip");
    }

    @Test
    public void uploadFromLocal() throws IOException {
        FileUploading fileUploading = new FileUploading(hdfsSettings.fileSystem);
        String localFilePath = "/Users/will/Desktop/hadoop install.txt.zip";
        fileUploading.uploadFromLocal(localFilePath);
    }

    @Test
    public void uploadFromStream() throws IOException {
        FileUploading fileUploading = new FileUploading(hdfsSettings.fileSystem);
        String localFilePath = "/Users/will/Desktop/hadoop install.txt.zip";
        fileUploading.uploadFromStream(localFilePath);
    }

    @Test
    public void appendToText() throws IOException {
        String fsFile = "/test/testAppend.txt";
        String content = "%nthis is the content for appending";
        FileUploading fileUploading = new FileUploading(hdfsSettings.fileSystem);

        fileUploading.appendToText(fsFile,content);
    }

}
