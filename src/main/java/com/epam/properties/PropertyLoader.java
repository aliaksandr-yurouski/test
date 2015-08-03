package com.epam.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Aliaksandr_Yurouski on 7/31/2015.
 */
public class PropertyLoader {

    private static Properties prop;

    public static Properties loadProperties(String pathToProps){

        prop = new Properties();
        try{
            prop.load(new FileInputStream(pathToProps));
        }catch (IOException exception){
            System.out.println("File not found: " + pathToProps);
        }
        return prop;

    }

    public static String loadPropetryByName(String propertyName){

        return prop.getProperty(propertyName);

    }

    public static void setPropertyByName(String propertyName, String propertyValue){

        prop.setProperty(propertyName, propertyValue);

    }
}