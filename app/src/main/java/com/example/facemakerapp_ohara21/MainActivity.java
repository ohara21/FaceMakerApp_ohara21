package com.example.facemakerapp_ohara21;
/**
 * @description: Main Class
 * @author: Nick Ohara
 * @version: 9/6/20 Part A implementation
 */

import androidx.appcompat.app.AppCompatActivity;

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

    private String[] hairstyles = {"hairstyle1", "hairstyle2", "hairstyle3"};
    private RadioGroup radioFaceGroup;
    private RadioButton radioFaceButton;
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private TextView redValueText;
    private TextView greenValueText;
    private TextView blueValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * External Citation
         * Date: 6 September 2020
         * Problem: Wanted to learn how to display the progress of seek bar
         * Resource: https://www.youtube.com/watch?v=acRAFIn3ZJs&ab_channel=ProgrammingWizardsTV
         * Solution: followed the tutorial and used code
         */
        redSeek = findViewById(R.id.red_seekBar);
        greenSeek = findViewById(R.id.green_seekBar);
        blueSeek = findViewById(R.id.blue_seekBar);
        redValueText = findViewById(R.id.red_val);
        greenValueText = findViewById(R.id.green_val);
        blueValueText = findViewById(R.id.blue_val);

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar redSeek, int progress, boolean fromUser) {
                redValueText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar redSeek) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar redSeek) {

            }
        });

        greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar greenSeek, int progress, boolean fromUser) {
                greenValueText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar greenSeek) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar greenSeek) {

            }
        });

        blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar redSeek, int progress, boolean fromUser) {
                blueValueText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar blueSeek) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar blueSeek) {

            }
        });

        /**
         * External Citation
         * Date: 6 September 2020
         * Problem: Did not know how to populate the spinner widget
         * Resource: Professor Nuxoll, CS301 Spinner Example
         * Solution: Used Professor Nuxoll's code as a template to populate the hairstyle spinner
         */
        ArrayAdapter<String> hairstyleAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, hairstyles);
        Spinner hairstyle_spinner = findViewById(R.id.hairstyle_spinner);
        hairstyle_spinner.setAdapter(hairstyleAdapter);
    }
}