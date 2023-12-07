package com.litigiven.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

     /*
    In this class, we will be creating the re-usable logic to read from configuration.properties file
     */

    // 1. we will create an object of the Properties Class.
    // and we make it 'private' so that we limit access to the object,
    // and 'static' so that it is created and loaded before everything else.
    private static Properties properties = new Properties();

    static {



        try {
            // 2. we will open the file in the Java memory using the FileInputStream Class.
            FileInputStream file = new FileInputStream("Configuration.properties");
            // 3. We will load the file into the properties object with getProperties() method into which we pass the key in order to get the value from the file.
            properties.load(file);
            //Close the file in the memory.
            file.close();

        } catch (IOException e) {

            e.printStackTrace();

            System.out.println("File not found with given Path!!!");


        }
    }

    // 4. We will finally use the properties object to read the data from the file.
    // I will create a utility method that will use the object to read
    public static String getTheProperty(String keyword) {

        return properties.getProperty(keyword);

    }


}
