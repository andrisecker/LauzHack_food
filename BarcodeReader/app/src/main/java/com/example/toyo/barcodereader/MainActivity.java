package com.example.toyo.barcodereader;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.vidinoti.android.vdarsdk.json.parser.ParseException;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// credits to https://android-coffee.com/tutorial-how-to-create-barcode-reader-app-in-android-studio-1-4/

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private TextView text, footprintvalue;
    private ImageView lauzhack, openfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openfood = (ImageView)findViewById(R.id.openfood);
        lauzhack = (ImageView)findViewById(R.id.lauzhack);
        text = (TextView)findViewById(R.id.text);
        footprintvalue = (TextView)findViewById(R.id.footprintvalue);

        lauzhack.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId()==R.id.lauzhack){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();

            Map<String, String> dict = new HashMap<>();
            dict.put("7610095004000", "3.4");
            dict.put("5449000000286", "0.5");
            dict.put("3254380008430", "0.1");
            displayFootprint(dict, scanContent);

        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void displayFootprint(Map<String, String> dict, String barcode){
        for (Map.Entry<String, String> entry : dict.entrySet()){
            if(entry.getKey().equals(barcode)){
                text.setText("The ecological footprint of your product is");
                footprintvalue.setText(entry.getValue() + " kg CO2 emission");
            }
        }

    }
}
