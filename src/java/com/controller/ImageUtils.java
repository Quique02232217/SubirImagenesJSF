/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author User
 */
public class ImageUtils {

 public static void copyFile(String fileName, InputStream in,String path) {
           try {  
               
            //String path=System.getProperty(fileName); 
                //URL is = ClassLoader.getSystemResource();
                // write the inputStream to a FileOutputStream
              // URL is = ClassLoader.getSystemResource("hombre.jpeg");
               System.out.println(path); 
               OutputStream out = new FileOutputStream(path + fileName);
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }


}
