package com.mmstq.progressbargifdialog;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private ProgressBarGIFDialog.Builder progressBarGIFDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarGIFDialog= new ProgressBarGIFDialog.Builder(MainActivity.this);
                progressBarGIFDialog.setCancelable(false)
                        .setTitleColor(R.color.colorPrimary)
                        .setLoadingGifID(R.drawable.loading)
                        .setDoneGifID(R.drawable.done)
                        .setDoneTitle("Good Blyat")
                        .setLoadingTitle("Loading Your Content...").build();
                stop();
            }
        });
    }
    private void stop(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBarGIFDialog.clear();
            }
        },6000);
    }
}
