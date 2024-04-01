import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileReading {

    private final FileSystem fileSystem;
    public FileReading(FileSystem fileSystem){
        this.fileSystem=fileSystem;
    }

    public void readRootDirector() throws IOException {
        RemoteIterator<LocatedFileStatus> iterator =
            fileSystem.listFiles(new Path("/"),true);
        while (iterator.hasNext()){
            LocatedFileStatus status = iterator.next();
            System.out.println(status.getPath().toString());
        }
    }

    public void readOrdinaryFileToMemory(String filePath, int bufferSize) throws IOException {
        Path path = new Path(filePath);
        FSDataInputStream dataInputStream = null;
        try{
            if (bufferSize>0) {
                dataInputStream = fileSystem.open(path, bufferSize);
                ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
                dataInputStream.read(byteBuffer);

                for (byte b: byteBuffer.array())
                    System.out.printf("%c",b);
            }
            else {
                dataInputStream = fileSystem.open(path);
            }
        }catch (IOException e){

        }finally {
            assert dataInputStream != null;
            dataInputStream.close();
        }
    }

    public void readZipFileToMemory(String filePath) throws IOException {
        Path path = new Path(filePath);
        ZipInputStream zipInputStream = new ZipInputStream(fileSystem.open(path));
        ZipEntry zipEntry = null;

        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            String entryName = zipEntry.getName();
            System.out.printf("%s%n",entryName);
            if(!entryName.startsWith("__")){
                byte[] buffer = new byte[80];
                zipInputStream.read(buffer);
                for (byte b: buffer)
                    System.out.printf("%c",b);
            }
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
    }



}
