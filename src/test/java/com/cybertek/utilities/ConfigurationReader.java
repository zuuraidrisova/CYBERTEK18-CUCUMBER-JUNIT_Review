package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

  /*
/1- We created properties object.
//2- We got our path and store in String
//3- We need to open the file
//4- We need to load the file
//5- close.file
     */

public class ConfigurationReader {

    //  -> to be able to read from .properties type of file, we have to do some setup.
    //   -> step by step how to read from properties file:

    //we have to create an object of Properties class from Java
    //we make it private, so it is more secure
    //we make it static because we are gonna use our static variable in static block
    private static Properties properties = new Properties();

    static {//static clock runs once and before anything else

        String path = "configuration.properties";//we get the path of our properties file

        try {//we surround our FileInputStream with try catch because it throws checked exception

            //create an object of FileInputStream class, so we can pass our path
            //We need to OPEN the file in JVM memory
            FileInputStream file = new FileInputStream(path);

            //we load our file into properties object
            properties.load(file);

            //close our file we opened
            file.close();

            //catch our exceptions
        }catch (IOException exception){

            System.out.println("Properties file not found!");
        }
    }


    //our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){

        //getProperty() method comes from Java itself, from Properties class\
        return  properties.getProperty(keyWord);

    }


}
