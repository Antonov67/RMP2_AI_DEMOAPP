package com.example.rmp2_ai_demoapp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rmp2_ai_demoapp.R;

public class MainActivity extends AppCompatActivity {

    private RadioGroup genderGroup;
    private TextView resultText;
    private Button sendButton;
    private Spinner zodiacSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        genderGroup = findViewById(R.id.genderGroup);
        resultText = findViewById(R.id.resultText);
        sendButton = findViewById(R.id.sendButton);
        zodiacSpinner = findViewById(R.id.zodiacSpinner);
    }
}