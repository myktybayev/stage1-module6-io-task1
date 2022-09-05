package com.epam.mjc.io;
import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profle = null;
        try(FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            int ch = fileInputStream.read();
            StringBuilder word = new StringBuilder();
            String name ="";
            String email="";
            String age="";
            String phone="";
            while(ch != -1) {
                word.append((char) ch);
                ch = fileInputStream.read();

                if(ch=='\n'){
                    if(word.toString().contains("Name")){
                        name = word.substring(word.toString().indexOf(' ')+1);
                    }else if(word.toString().contains("Email")) {
                        email = word.substring(word.toString().indexOf(' ')+1);
                    }else if(word.toString().contains("Age")) {
                        age = word.substring(word.toString().indexOf(' ')+1);
                    }else if(word.toString().contains("Phone")) {
                        phone = word.substring(word.toString().indexOf(' ')+1);
                        profle = new Profile(name, Integer.parseInt(age), email, Long.parseLong(phone));
                    }

                    word = new StringBuilder();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return profle;
    }
}
