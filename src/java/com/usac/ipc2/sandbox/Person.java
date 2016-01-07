/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ipc2.sandbox;

/**
 *
 * @author ReimerGhost <rchamale10@gmail.com>
 */
public class Person {

    private String NAME;
    private String LOCATION;

    // Getters and setters are not required for this example.
    // GSON sets the fields directly using reflection.
    @Override
    public String toString() {
        return NAME + " - " + LOCATION;
    }
}
