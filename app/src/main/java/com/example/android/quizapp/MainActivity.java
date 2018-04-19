package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submit(View view) {

        // count the student score
        int score ;

        EditText editTextQ1_a = (EditText) findViewById(R.id.q1_a_answer_editText);
        // Check if the entered text match the correct answer for Q1-a, if yes increase score by one
        if (editTextQ1_a.getText().toString().trim().equalsIgnoreCase("identification")) {
            score = 1;
        } else {
            score = 0;
        }

        EditText editTextQ1_b = (EditText) findViewById(R.id.q1_b_answer_editText);
        // Check if the entered text match the correct answer for Q1-b, if yes increase score by one
        if (editTextQ1_b.getText().toString().trim().equalsIgnoreCase("hacker")) {
            score++;
        }

        RadioButton dacRadioButton = (RadioButton) findViewById(R.id.dac_radio_button);
        // Check if the correct answer for Q2-a was chosen, if yes increase score by one
        if (dacRadioButton.isChecked()) {
            score++;
        }

        RadioButton trustedCenterRadioButton = (RadioButton) findViewById(R.id.trusted_center_radio_button);
        // Check if the correct answer for Q2-b was chosen, if yes increase score by one
        if (trustedCenterRadioButton.isChecked()) {
            score++;
        }

        CheckBox strictAccessCheckBox = (CheckBox) findViewById(R.id.strict_access_controls_checkBox);
        CheckBox hashingCheckBox = (CheckBox) findViewById(R.id.hashing_checkBox);
        CheckBox authenticationCheckBox = (CheckBox) findViewById(R.id.authentication_checkBox);
        CheckBox authorizationCheckBox = (CheckBox) findViewById(R.id.authorization_checkBox);

        // Check if the correct answer for Q2-c was checked and no more than 2 checked checkBoxes, if yes increase the score by one
        if (strictAccessCheckBox.isChecked() && hashingCheckBox.isChecked() && !authorizationCheckBox.isChecked() && !authenticationCheckBox.isChecked()) {
            score++;
        }


        Toast.makeText(this, "Your score is " + score + " out of 5", Toast.LENGTH_SHORT).show();
    }
}
