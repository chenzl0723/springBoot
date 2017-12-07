package com.chenzl.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by chenzl on 2017/12/7.
 */

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
