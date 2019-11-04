package com.example.elgopdf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pdfcreator.createPdf;

public class MainActivity extends AppCompatActivity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = findViewById(R.id.btnTest);

        final createPdf obj = new createPdf(MainActivity.this);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obj.pdfTest();
            }
        });

        //obj.pdf();
        //obj.act = MainActivity.this;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        /*if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            Log.d("Allow", "createPdf: ");

        } else {

            if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_DENIED) {


                //if the SKD < 23
                if (Build.VERSION.SDK_INT >= 23) {

                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED) {

                        //ask for permission!
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                    }

                }

            }

        }*/


    }


}
