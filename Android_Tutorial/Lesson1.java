package com.example.androidlesson1;

// Create a new android studio project with Empty Activity
// Copy the code below
// Go to your own MainActivity.java and
// paste it over the existing code BELOW the package statement ***
// ***Sep 2019

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

//TODO 1.1 Put in some images in the drawables folder
//TODO 1.2 Go to activity_main.xml and modify the layout

public class MainActivity extends AppCompatActivity {

    //TODO 1.2 Instance variables are declared for you, please import the libraries
    ArrayList<Integer> images;
    Button charaButton, charaButton2;
    ImageView charaImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1.3 Instantiate An ArrayList object
        images = new ArrayList<>();
        //TODO 1.4 Add the image IDs to the ArrayList
        images.add(R.drawable.nickwilde);
        images.add(R.drawable.ashketchum);
        images.add(R.drawable.bartsimpson);
        images.add(R.drawable.yoda);
        images.add(R.drawable.snorlax);
        images.add(R.drawable.edogawaconan);
        images.add(R.drawable.nemo);
        images.add(R.drawable.judyhopps);
        //TODO 1.5 Get references to the charaButton and charaImage widgets using findViewById
        charaImage = findViewById(R.id.charaImage);
        charaButton = findViewById(R.id.charaButton);
        charaButton2 = findViewById(R.id.charaButton2);
        //TODO 1.6 For charaButton, invoke the setOnClickListener method
        //TODO 1.7 Create an anonymous class which implements View.OnClickListener interface
        //TODO 1.8 Within onClick, write code to randomly select an image ID from the ArrayList and display it in the ImageView
        charaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int index = random.nextInt(images.size()); // random image in array list
                int imageID = images.get(index); // extract image id
                charaImage.setImageResource(imageID);
                Log.i("Admin","Random Button Pressed"); // Logger "INFO" level
            }
        });
        //TODO 1.9 [On your own] Create another button, which when clicked, will cause one image to always be displayed
        charaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charaImage.setImageResource(R.drawable.tompaper);
                Log.i("Admin","Meme Button Pressed");
            }
        });
    }
}
