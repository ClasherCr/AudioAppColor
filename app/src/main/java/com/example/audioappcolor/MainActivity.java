package com.example.audioappcolor;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button blackbtn,yellowbtn,redbtn,purplebtn,greenbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        blackbtn = findViewById(R.id.blackbutton);
        yellowbtn = findViewById(R.id.yellowbutton);
        redbtn = findViewById(R.id.redbutton);
        purplebtn = findViewById(R.id.purplebutton);
        greenbtn = findViewById(R.id.greenbutton);


        redbtn.setOnClickListener(this);
        blackbtn.setOnClickListener(this);
        yellowbtn.setOnClickListener(this);
        purplebtn.setOnClickListener(this);
        greenbtn.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        int clickbtnid = v.getId();

        if (clickbtnid == R.id.redbutton){
            playsound(R.raw.red);
        } else if (clickbtnid == R.id.blackbutton) {
            playsound(R.raw.black);
        } else if (clickbtnid == R.id.purplebutton) {
            playsound(R.raw.purple);
        } else if (clickbtnid == R.id.yellowbutton) {
            playsound(R.raw.yellow);
        } else if (clickbtnid == R.id.greenbutton) {
            playsound(R.raw.green);

        }


    }

    public  void playsound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}