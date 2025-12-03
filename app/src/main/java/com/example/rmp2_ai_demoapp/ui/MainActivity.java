package com.example.rmp2_ai_demoapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

        initZodiacSpinner();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = genderGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Выберите пол", Toast.LENGTH_SHORT).show();
                    return;
                }
                String gender = ((RadioButton) findViewById(selectedId)).getText().toString();
                String zodiac = zodiacSpinner.getSelectedItem().toString();

                resultText.setText("\uD83D\uDCAD Думаю над подарком...");

                sendRequestToAi(gender, zodiac);
            }
        });
    }

    private void sendRequestToAi(String gender, String zodiac){

    }

    private void initZodiacSpinner() {
        String[] zodiacSigns = {
                "Овен", "Телец", "Близнецы", "Рак",
                "Лев", "Дева", "Весы", "Скорпион",
                "Стрелец", "Козерог", "Водолей", "Рыбы"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                zodiacSigns
        );
        zodiacSpinner.setAdapter(adapter);
    }
}