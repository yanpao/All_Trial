import org.apache.commons.io.FilenameUtils;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileUploading {

    private final FileSystem fileSystem;
    public FileUploading(FileSystem fileSystem){
        this.fileSystem=fileSystem;
    }

    //Upload from local
    public void uploadFromLocal(String localFilePath) throws IOException {

        fileSystem.copyFromLocalFile(new Path(localFilePath),
                new Path("/test/"+ FilenameUtils.getName(localFilePath)));
    }

    //Upload from stream
    public void uploadFromStream(String localFilePath) throws IOException {
        FSDataOutputStream fsDataOutputStream = fileSystem.create(
                new Path("/test/"+ FilenameUtils.getName(localFilePath)),
                false,1024);

        FileInputStream inputStream = new FileInputStream(localFilePath);
        byte[] buffer = new byte[1024];

        while (inputStream.read(buffer)>0){
            fsDataOutputStream.write(buffer);
        }
        fsDataOutputStream.flush();
        fsDataOutputStream.close();
        inputStream.close();
    }

    //append file
    public void appendToText(String fsFile, String content) throws IOException {

        FSDataOutputStream outputStream = fileSystem.append(new Path(fsFile),1024);

        outputStream.write(content.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();

    }

}
