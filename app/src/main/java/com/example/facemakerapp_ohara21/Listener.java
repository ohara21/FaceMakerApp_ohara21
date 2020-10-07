package com.example.facemakerapp_ohara21;
/**
 * @description: Listener class is the Controller in this MVC design
 * and implements necessary listener interfaces
 * @author: Nick Ohara
 * @version: 10/6/20
 */

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * External Citation
 * Date: 10 September 2020
 * Problem: Wanted to learn how to display the progress of seek bar
 * Resource: Professor Nuxoll
 * Solution: used code to make a Listener class
 */
public class Listener implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener,
        Button.OnClickListener, AdapterView.OnItemSelectedListener{

    //declares View and Model for MVC design
    private Face fView;
    private FaceModel fModel;

    //to be updated as things change
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private Spinner hairstyleSpinner;

    //text view for displaying the progress of each seek bar
    private TextView redValueText = null;
    private TextView blueValueText = null;
    private TextView greenValueText = null;

    /**constructs listener for three seek bars, random face button, spinner, and radio button
     * @param view - necessary for MVC design
     * @param hairstyleSpinner - necessary for updating spinner
     * @param redSeek - necessary for updating seekBar
     * @param greenSeek - necessary for updating seekBar
     * @param blueSeek - necessary for updating seekBar
     * @param redText - necessary for updating textView
     * @param blueText - necessary for updating textView
     * @param greenText - necessary for updating textView
     */
    public Listener(Face view, Spinner hairstyleSpinner, SeekBar redSeek, SeekBar greenSeek, SeekBar blueSeek,
                    TextView redText, TextView blueText, TextView greenText){
        fView = view;
        this.hairstyleSpinner = hairstyleSpinner;
        this.redSeek = redSeek;
        this.greenSeek = greenSeek;
        this.blueSeek = blueSeek;
        fModel = fView.getFaceModel();
        this.redValueText = redText;
        this.blueValueText = blueText;
        this.greenValueText = greenText;
    }

    /**
     * sets the RGB textViews depending on the current model's trait
     * @param trait
     */
    public void setText(int trait) {
        redValueText.setText(String.valueOf(fModel.getRed(trait)));
        greenValueText.setText(String.valueOf(fModel.getGreen(trait)));
        blueValueText.setText(String.valueOf(fModel.getBlue(trait)));
    }

    /**
     * External Citation
     * Date: 10/6/20
     * Problem: how to set spinner selection
     * Resource: https://stackoverflow.com/questions/11072576/set-selected-item-of-spinner-programmatically
     * Solution: found the correct method
     *
     * updates all seekBars and spinner
     */
    public void setAllProgress(){
        redSeek.setProgress(fModel.getRed(fModel.getTrait()));
        greenSeek.setProgress(fModel.getGreen(fModel.getTrait()));
        blueSeek.setProgress(fModel.getBlue(fModel.getTrait()));
        hairstyleSpinner.setSelection(fModel.getHairStyle());
    }

    /**
     * External Citation
     * Date: 10 September 2020
     * Problem: how to handle different seek bars in
     *  the same Listener class
     * Resource: https://stackoverflow.com/questions/25905086/multiple-buttons-onclicklistener-android/25905313
     * Solution: used a switch statement and compared IDs to assign accordingly
     *
     * listens to changes in seekBars and updates the red color depending
     * on the reported trait (hair, eyes, or skin)
     * also updates all progress bars and textViews
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch(seekBar.getId()) {
            case R.id.red_seekBar:
                fModel.setRed(fModel.getTrait(),progress);
                setAllProgress();
                setText(fModel.getTrait());
                fView.invalidate();
                break;
            case R.id.green_seekBar:
                fModel.setGreen(fModel.getTrait(),progress);
                setAllProgress();
                setText(fModel.getTrait());
                fView.invalidate();
                break;
            case R.id.blue_seekBar:
                fModel.setBlue(fModel.getTrait(),progress);
                setAllProgress();
                setText(fModel.getTrait());
                fView.invalidate();
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //don't need this event handled
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //don't need this event handled
    }


    /**
     * External Citation
     * Date: 6 October 2020
     * Problem: how to tell which RadioButton is checked
     * Source: https://stackoverflow.com/questions/8323778/how-to-set-onclicklistener-on-a-radiobutton-in-android
     * Solution: used the code
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch(checkedId) {
            case R.id.hairButton:
                fModel.setTrait(0);
                setAllProgress();
                setText(0);
                break;
            case R.id.eyesButton:
                fModel.setTrait(1);
                setAllProgress();
                setText(1);
                break;
            case R.id.skinButton:
                fModel.setTrait(2);
                setAllProgress();
                setText(2);
                break;
            default:
                break;
        }
    }

    /**
     * responds to the random face buttom by calling the randomize method
     * also updates the seekBars and textViews
     * @param view
     */
    @Override
    public void onClick(View view) {
        fModel.randomize();
        setAllProgress();
        setText(fModel.getTrait());
        fView.invalidate();
    }

    /**
     * External Citation
     * Date: 6 October 2020
     * Problem: how to apply listener to spinner
     * Source: https://stackoverflow.com/questions/1337424/android-spinner-get-the-selected-item-change-event
     * Solution: used the code
     *
     * sets the model hairstyle depending on the choice in the spinner
     * also updates all seekBars and textViews
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        fModel.setHairStyle(position);
        setAllProgress();
        setText(fModel.getTrait());
        fView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //don't need this event handled
    }
}
