package com.mmstq.progressbargifdialog;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBarGIFDialog.Builder progressBarGIFDialog;

                //now initialise it in onCreate Method Of Your Activity

                progressBarGIFDialog = new ProgressBarGIFDialog.Builder(MainActivity.this);

                progressBarGIFDialog.setCancelable(false)

                        .setLoadingGif(R.drawable.loading) // Set Loading Gif

                        .setDoneGif(R.drawable.done) // Set Done Gif

                        .setDoneTitle("Nice Blyat") // Set Done Title

                        .setLoadingTitle("Loading...") // Set Loading Title

                        .build();
            }
        });



    }
}
