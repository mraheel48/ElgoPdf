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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnTest;

    ArrayList<String> Category = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = findViewById(R.id.btnTest);

        Category.add("First");
        Category.add("First 1");
        Category.add("First 2");
        Category.add("First 3");
        Category.add("First 4");
        Category.add("First 5");
        Category.add("First 6");
        Category.add("First 7");
        Category.add("First 8");
        Category.add("First 9");
        Category.add("First 10");
        Category.add("First 11");
        Category.add("First 12");
        Category.add("First 13");
        Category.add("First 14");
        Category.add("First 15");
        Category.add("First 16");
        Category.add("First 17");
        Category.add("First 18");
        Category.add("First 19");
        Category.add("First 20");
        Category.add("First 21");
        Category.add("First 22");
        Category.add("First 23");
        Category.add("First 24");
        Category.add("First 25");
        Category.add("First 26");
        Category.add("First 27");
        Category.add("First 28");
        Category.add("First 29");
        Category.add("First 30");
        Category.add("First 31");
        Category.add("First 32");
        Category.add("First 33");
        Category.add("First 34");
        Category.add("First 35");
        Category.add("First 36");
        Category.add("First 37");
        Category.add("First 38");
        Category.add("First 39");

        final createPdf obj = new createPdf(MainActivity.this);

        obj.setAttribute(null, null, null, null);
        obj.setData("ElgoByte", "11/05/2019");
        obj.setTable("Test", "First", Category);
        obj.setTable("Test", "First", Category, "Second", Category);
        obj.setTable("Test", "First", Category, "Second", Category, "third", Category);
        obj.setTable("Test", "First", Category, "Second", Category,
                "third", Category, "four", Category);


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // obj.pdfTest();
                obj.createPdf();
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
