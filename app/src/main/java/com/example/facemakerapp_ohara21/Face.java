package com.example.facemakerapp_ohara21;
/**
 * @description: Face Class is the View in this MVC design and
 * draws and displays the face
 * @author: Nick Ohara
 * @version: 10/6/20 Part B implementation
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView {
    FaceModel fm = new FaceModel();
//    //array that contains rgb values for each trait
//    public int[] skinColor = new int[3];
//    public int[] pupilColor = new int[3];
//    public int[] hairColor = new int[3];
//    public int hairStyle;
//
//    //define whether hair, eyes, or skin is being edited
//    //initially hair is being edited
//    int trait = 0;
//
    //for generating random rgb values
    Random rand = new Random();

    //different paints used for traits
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint pupilPaint = new Paint();
    Paint hairPaint = new Paint();
    Paint mouthPaint = new Paint();

//    //instance variables to edit trait colors
//    int red;
//    int green;
//    int blue;

    //defining dimensions of SurfaceView
    float viewWidth;
    float viewHeight;
    float centerX;
    float centerY;

    /**
     * contructors inherited from SurfaceView class
     * also calls randomize
     * @param context
     */
    public Face(Context context) {
        super(context);
        fm.randomize();
    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        fm.randomize();
        setWillNotDraw(false);
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        fm.randomize();
    }

    /**
     * sets the paint every time the color changes
     * @param paint
     * @param color
     */
    public void setPaint(Paint paint, int[] color){
        fm.red = color[0];
        fm.green = color[1];
        fm.blue = color[2];
        paint.setColor(Color.rgb(fm.red,fm.green,fm.blue));
    }

    /**
     * draws a face on the canvas
     * @param canvas
     */
    public void drawFace(Canvas canvas){
        RectF faceRect = new RectF(centerX-350.0f,centerY-400.0f,centerX+350.0f,centerY+400.0f);
        canvas.drawArc(faceRect,0,360,true,skinPaint);
    }

    /**
     * draws different hairstyles
     * @param canvas
     */
    public void drawHair(Canvas canvas){
        RectF hairRect;
        if(fm.getHairStyle() == 0) {
            //draws the bowl haircut
            hairRect = new RectF(centerX - 350.0f, centerY - 400.0f, centerX + 350.0f, centerY - 50.0f);
            canvas.drawArc(hairRect, 180, 180, true, hairPaint);
        }
        else if(fm.getHairStyle() == 1){
            //draws the mohawk hairstyle
            hairRect = new RectF(centerX-25.0f,centerY-500.0f,centerX+25.0f,centerY-250.0f);
            canvas.drawRect(hairRect,hairPaint);
        }
        else{
            //draws the clown hairstyle
            canvas.drawCircle(centerX-300.0f,centerY-300.0f,150.0f,hairPaint);
            canvas.drawCircle(centerX+300.0f,centerY-300.0f,150.0f,hairPaint);
        }
    }

    /**
     * draws the eyes on the canvas
     * @param canvas
     */
    public void drawEyes(Canvas canvas){
        //draws the white part of the eye
        RectF leftEyeRect = new RectF(centerX-200.0f,centerY-100.0f,centerX-50.0f,centerY-25.0f);
        RectF rightEyeRect = new RectF(centerX+200.0f,centerY-100.0f,centerX+50.0f,centerY-25.0f);
        canvas.drawArc(leftEyeRect,0,360,true, eyePaint);
        canvas.drawArc(rightEyeRect,0,360,true, eyePaint);

        //draws the pupils depending on the assigned paint
        canvas.drawCircle(leftEyeRect.centerX(),leftEyeRect.centerY(),leftEyeRect.height()/2,pupilPaint);
        canvas.drawCircle(rightEyeRect.centerX(),rightEyeRect.centerY(),rightEyeRect.height()/2,pupilPaint);
    }

    /**
     * draws the mouth on the canvas
     * @param canvas
     */
    public void drawMouth(Canvas canvas){
        RectF mouthRect = new RectF(centerX-200.0f,centerY+50.0f,centerX+200.0f,centerY+250.0f);
        canvas.drawArc(mouthRect,0,180,true,mouthPaint);
    }

    /**
     * returns the model to be used in the Listener class
     * @return
     */
    public FaceModel getFaceModel(){
        return fm;
    }

    /**
     * draws the face on the SurfaceView
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas){
        //gets the dimensions of the surfaceView
        viewWidth = this.getWidth();
        viewHeight = this.getHeight();

        //sets the center of the Face
        centerX = viewWidth/2;
        centerY = viewHeight/2;

        //need to set paints in the onDraw so the paints are reset when invalidate() is called
        setPaint(skinPaint,fm.skinColor);
        setPaint(hairPaint,fm.hairColor);
        setPaint(pupilPaint,fm.pupilColor);
        eyePaint.setColor(Color.WHITE);
        mouthPaint.setColor(0xFFFFC0CB);

        //call the draw methods for each feature
        drawFace(canvas);
        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }
}
