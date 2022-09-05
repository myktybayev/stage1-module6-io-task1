package com.epam.mjc.io;
import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profle = null;
        try(FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            int ch = fileInputStream.read();
            String word = "", name ="", email="", age="", phone="";
            while(ch != -1) {
                word = word + ""+(char)ch;
                ch = fileInputStream.read();

                if(ch=='\n'){
                    if(word.contains("Name")){
                        name = word.substring(word.indexOf(' ')+1);
                    }else if(word.contains("Email")) {
                        email = word.substring(word.indexOf(' ')+1);
                    }else if(word.contains("Age")) {
                        age = word.substring(word.indexOf(' ')+1);
                    }else if(word.contains("Phone")) {
                        phone = word.substring(word.indexOf(' ')+1);
                        profle = new Profile(name, Integer.parseInt(age), email, Long.parseLong(phone));
                    }

                    word = "";
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }

        return profle;
    }
}
