package com.linkedIn.helpers.properties;

public enum PropertySource {
    EMAIL("user.properties"),
    PASSWORD("user.properties");

    public String sourceFile;

    public PropertySource[] getOptions(){
        return PropertySource.values();
    }

    PropertySource(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}
