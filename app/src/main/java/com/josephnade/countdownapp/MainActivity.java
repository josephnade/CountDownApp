package com.josephnade.countdownapp;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

    }

    public void countDown(View view){
        int seconds;
        if (!editText.getText().toString().matches("")){
            seconds = Integer.parseInt(editText.getText().toString());
            new CountDownTimer(seconds * 1000, 1000L){

                @Override
                public void onTick(long l) {
                    int number = (int) (l / 1000L);
                    textView.setText("Left: " + (number + 1));
                }
                //
                @Override
                public void onFinish() {
                    textView.setText("Left: 0");
                    Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_LONG).show();
                    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.alert);
                    mediaPlayer.start();
                }
            }.start();
        }else{
            Toast.makeText(MainActivity.this, "Enter a number!", Toast.LENGTH_LONG).show();
        }


    }
}