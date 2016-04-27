package com.example.landonbedell.massimo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by branden on 26/04/16.
 */
public class CameraView extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);

    }

    public void cheese(View view){
        Intent i = new Intent(getBaseContext(), OrderView.class);
        startActivity(i);
    }
}
