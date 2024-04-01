import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;

public class HDFSSettings {

    public FileSystem fileSystem;

    public HDFSSettings(){
        Configuration conf = new Configuration();
        conf.set("dfs.client.use.datanode.hostname","true");
        System.setProperty("HADOOP_USER_NAME","root");

        URI uri = URI.create("hdfs://192.168.1.13:9000");

        try{
            fileSystem = FileSystem.get(uri,conf,"root");
        }catch (IOException | InterruptedException exception){
            throw new RuntimeException(exception);
        }
    }

}
