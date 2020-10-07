package com.example.facemakerapp_ohara21;
/**
 * @description: FaceModel class is the Model in this MVC design and
 * contains the characteristics of the displayed face
 * @author: Nick Ohara
 * @version: 10/6/20
 */

import java.util.Random;

public class FaceModel {
    //array that contains rgb values for each trait
    public int[] skinColor = new int[3];
    public int[] pupilColor = new int[3];
    public int[] hairColor = new int[3];
    public int hairStyle;

    //define whether hair, eyes, or skin is being edited
    //initially hair is being edited
    int trait = 0;

    //for generating random rgb values
    Random rand = new Random();

    //instance variables to edit trait colors
    int red;
    int green;
    int blue;

    /**
     * FaceModel constructor
     * creates random face upon intialization
     */
    public FaceModel(){
        randomize();
    }

    /**
     * randomly sets colors for hair, eyes, and skin
     */
    public void randomize(){
        for(int i=0; i<3; i++){
            skinColor[i] = rand.nextInt(256);
            pupilColor[i] = rand.nextInt(256);
            hairColor[i] = rand.nextInt(256);
        }
        hairStyle = rand.nextInt(3);
    }

    /**
     * setter method for model's trait that is being modified
     * @param trait
     */
    public void setTrait(int trait){
        this.trait = trait;
    }

    /**
     * getter method for the model's trait that is being modified
     * @return
     */
    public int getTrait(){
        return this.trait;
    }

    /**
     * setter method for hairstyle that should be displayed
     * @param style
     */
    public void setHairStyle(int style){
        this.hairStyle = style;
    }

    /**
     * returns the hairstyle that should be displayed
     * initially at hairstyle 0
     * @return
     */
    public int getHairStyle(){
        return this.hairStyle;
    }

    /**
     * setter method for red color depending on the trait being modified
     * @param trait
     * @param redVal
     */
    public void setRed(int trait, int redVal){
        if(trait == 0){
            hairColor[0] = redVal;
        }
        else if(trait == 1){
            pupilColor[0] = redVal;
        }
        else{
            skinColor[0] = redVal;
        }
    }

    /**
     * returns the amount of red for given trait
     * @param trait
     * @return
     */
    public int getRed(int trait){
        if(trait == 0){
            return hairColor[0];
        }
        else if(trait == 1){
            return pupilColor[0];
        }
        else{
            return skinColor[0];
        }
    }

    /**
     * setter method for green color depending on the trait being modified
     * @param trait
     * @param greenVal
     */
    public void setGreen(int trait, int greenVal){
        if(trait == 0){
            hairColor[1] = greenVal;
        }
        else if(trait == 1){
            pupilColor[1] = greenVal;
        }
        else{
            skinColor[1] = greenVal;
        }
    }

    /**
     * returns the amount of green for given trait
     * @param trait
     * @return
     */
    public int getGreen(int trait){
        if(trait == 0){
            return hairColor[1];
        }
        else if(trait == 1){
            return pupilColor[1];
        }
        else{
            return skinColor[1];
        }
    }

    /**
     * setter method for blue color depending on the trait being modified
     * @param trait
     * @param blueVal
     */
    public void setBlue(int trait, int blueVal){
        if(trait == 0){
            hairColor[2] = blueVal;
        }
        else if(trait == 1){
            pupilColor[2] = blueVal;
        }
        else{
            skinColor[2] = blueVal;
        }
    }

    /**
     * returns the amount of blue for given trait
     * @param trait
     * @return
     */
    public int getBlue(int trait){
        if(trait == 0){
            return hairColor[2];
        }
        else if(trait == 1){
            return pupilColor[2];
        }
        else{
            return skinColor[2];
        }
    }
}
