/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ipc2.sandbox;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 *
 * @author ReimerGhost <rchamale10@gmail.com>
 */
public class testing {

    public static void main(String[] args) throws IOException {
        
        try (Reader reader = new InputStreamReader(testing.class.getResourceAsStream("Server1.json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            Person p = gson.fromJson(reader, Person.class);
            System.out.println(p);
        }
    }
}
