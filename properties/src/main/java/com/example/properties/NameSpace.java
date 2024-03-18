package com.example.properties;

public class NameSpace {

    private String name;

    //private List<StorageProperties> storageProperties = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public List<StorageProperties> getStorageProperties() {
//        return storageProperties;
//    }
//
//    public void setStorageProperties(List<StorageProperties> storageProperties) {
//        this.storageProperties = storageProperties;
//    }

    private StorageProperties storage;

    public StorageProperties getStorageProperties() {
        return storage;
    }

    public void setStorageProperties(StorageProperties storageProperties) {
        this.storage = storageProperties;
    }

    public interface StorageProperties{
        String getStoreName();
    }
}
