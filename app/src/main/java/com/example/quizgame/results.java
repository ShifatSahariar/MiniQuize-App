package com.example.quizgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class results extends AppCompatActivity {
    MyReceiver brodcastreceiver = new MyReceiver();
    private static final String TAG = "game";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        final Button startnewBtn = findViewById(R.id.startnewquizbtn);
        final Button quit = findViewById(R.id.quit);
        final Button sharebtn = findViewById(R.id.sharebtn);
        final TextView correctanswer=findViewById(R.id.correctanswers);
        final TextView incorrectanswer=findViewById(R.id.incorrectanswers);
        LinearLayout makePhoto=findViewById(R.id.linear1);
        ImageView replacePhotoTest =findViewById(R.id.congratulationicon);



        final int getcorrectanswers =getIntent().getIntExtra("correct",0);
        final int getincorrectanswers =getIntent().getIntExtra("incorrect",0);

        correctanswer.setText("Amazing you had "+getcorrectanswers +" correct");

        //incorrectanswer.setText(String.valueOf(getincorrectanswers));
        incorrectanswer.setText("You also got "+getincorrectanswers +" wrong");

        startnewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(results.this,game.class));
                finish();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                //Bitmap image = getBitmapFromView(makePhoto);
                //String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), image,"Score", null);
                //Uri bitmapUri = Uri.parse(bitmapPath);
                //shareImageUri(saveImageExternal(image));

                intent.putExtra(Intent.EXTRA_TEXT, correctanswer.getText());
                intent.setType("text/plain");
                //intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                //intent.setType("image/png");
                startActivity(intent);




            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(brodcastreceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity( new Intent(results.this,game.class));
        finish();
    }
    /*
    private void shareImageandText(Bitmap bitmap) {
        Uri uri = getmageToShare(bitmap);
        Intent intent = new Intent(Intent.ACTION_SEND);

        // putting uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM, uri);

        // adding text to share
        intent.putExtra(Intent.EXTRA_TEXT, "Sharing Image");

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

        // setting type to image
        intent.setType("image/png");

        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"));
    }


    private Uri getmageToShare(Bitmap bitmap) {
        File imagefolder = new File(getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "shared_image.png");
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(this, "com.anni.shareimage.fileprovider", file);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }
    */
    private Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }   else{
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }







}