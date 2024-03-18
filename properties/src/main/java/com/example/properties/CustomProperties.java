package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = CustomProperties.DATA_STORAGE)
public class CustomProperties {

    public static final String DATA_STORAGE = "tjh.storage";

//    private List<NameSpace> nameSpaces = new ArrayList<>();
//
//    public List<NameSpace> getNameSpaces() {
//        return nameSpaces;
//    }
//
//    public void setNameSpaces(List<NameSpace> nameSpaces) {
//        this.nameSpaces = nameSpaces;
//    }

    private NameSpace nameSpace;

    public NameSpace getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(NameSpace nameSpace) {
        this.nameSpace = nameSpace;
    }
}
