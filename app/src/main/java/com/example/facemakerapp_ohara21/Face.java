package com.example.facemakerapp_ohara21;
/**
 * @description: Face Class - creates a face
 * @author: Nick Ohara
 * @version: 9/6/20 Part A implementation
 */

import java.util.Random;

public class Face {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    Random rand = new Random();
    public Face(int skin, int eye, int hairC, int hairS){
        randomize();
    }

    public void randomize(){
        skinColor = rand.nextInt(256);
        eyeColor = rand.nextInt(256);
        hairColor = rand.nextInt(256);
        hairStyle = rand.nextInt(3);
    }
}
