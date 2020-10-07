package com.example.facemakerapp_ohara21;
/**
 * @description: Main Class
 * Model, View, Controller (MVC) with other classes
 * @author: Nick Ohara
 * @version: 10/6/20 Part B implementation
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //instance variables for various widgets used in interface
    private String[] hairstyles = {"Bowl Cut", "Mohawk", "Clown"};
    private RadioGroup radioFaceGroup;
    private Button randomFaceButton;
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private TextView redValueText;
    private TextView greenValueText;
    private TextView blueValueText;
    private ArrayAdapter<String> hairstyleAdapter;
    private Spinner hairstyleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        Face faceView = findViewById(R.id.surfaceView);

        /**
         * External Citation
         * Date: 10 September 2020
         * Problem: Wanted to learn how to display the progress of seek bar
         * Resource: Professor Nuxoll
         * Solution: used code to make a Listener class
         */
        //finds the ID for each text view and seek bar
        redSeek = findViewById(R.id.red_seekBar);
        redValueText = findViewById(R.id.red_val);
        greenSeek = findViewById(R.id.green_seekBar);
        greenValueText = findViewById(R.id.green_val);
        blueSeek = findViewById(R.id.blue_seekBar);
        blueValueText = findViewById(R.id.blue_val);
        radioFaceGroup = findViewById(R.id.facial_feature);
        randomFaceButton = findViewById(R.id.random_face_button);

        /**
         * External Citation
         * Date: 6 September 2020
         * Problem: Did not know how to populate the spinner widget
         * Resource: Professor Nuxoll, CS301 Spinner Example
         * Solution: Used Professor Nuxoll's code as a template to populate the hairstyle spinner
         */
        hairstyleAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, hairstyles);
        hairstyleSpinner = findViewById(R.id.hairstyle_spinner);
        hairstyleSpinner.setAdapter(hairstyleAdapter);

        //assigns a listener to the surfaceView, spinner, and each seekBar and text view
        Listener eventListener = new Listener(faceView, hairstyleSpinner,
                redSeek, greenSeek, blueSeek, redValueText, blueValueText, greenValueText);

        //assigns listeners
        redSeek.setOnSeekBarChangeListener(eventListener);
        blueSeek.setOnSeekBarChangeListener(eventListener);
        greenSeek.setOnSeekBarChangeListener(eventListener);
        radioFaceGroup.setOnCheckedChangeListener(eventListener);
        randomFaceButton.setOnClickListener(eventListener);
        hairstyleSpinner.setOnItemSelectedListener(eventListener);
    }
}