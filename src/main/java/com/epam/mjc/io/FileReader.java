package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file));) {
            var profile = new Profile();
            String s = null;
            s= reader.readLine();
            while (s!=null){
                if (s.contains("Name"))
                    profile.setName(s.substring(6));
                else if (s.contains("Age"))
                    profile.setAge(Integer.valueOf(s.substring(5)));
                else if (s.contains("Email"))
                    profile.setEmail(s.substring(7));
                else if (s.contains("Phone"))
                    profile.setPhone(Long.valueOf(s.substring(7)));
                s=reader.readLine();
            }
            return profile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
