package com.example.final_syfler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_PIC_REQUEST = 1112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_camera = (Button) findViewById(R.id.button_camera);
        button_camera.setOnClickListener(button_ClickForCamera);

        SeekBar SeekBar_Size = findViewById(R.id.seekBar_size);
        SeekBar_Size.setOnSeekBarChangeListener(seekBarChangeListener);


    }

    public View.OnClickListener button_ClickForCamera = new View.OnClickListener() {
        public void onClick(View view) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
        }
    };
    public SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            EditText MainTextSize = findViewById(R.id.edit_text_input);
            MainTextSize.setTextSize(seekBar.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }


    };
}