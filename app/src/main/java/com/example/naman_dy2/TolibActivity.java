package com.example.naman_dy2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.naman_dy2.BarcodeActivity;
import com.example.naman_dy2.Capture;
import com.example.naman_dy2.R;
import com.example.naman_dy2.ResultActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.squareup.picasso.Picasso;

public class TolibActivity extends AppCompatActivity {

    Button bmbs;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolib);

        String title = "";
        String author = "";
        String image = "";

        Bundle extras = getIntent().getExtras();

        title = extras.getString("title");
        author = extras.getString("author");
        image = extras.getString("image");

        TextView textView1 = findViewById(R.id.book_title);
        TextView textView2 = findViewById(R.id.book_author);
        ImageView imageView = findViewById(R.id.book_image);

        Picasso.get().load(image).into(imageView);

        String str1 = title;
        String str2 = author;

        String textWithoutTag1 = str1.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        String textWithoutTag2 = str2.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

        textView1.setText(textWithoutTag1);
        textView2.setText(textWithoutTag2);

        String finalTitle = title;
        String finalAuthor = author;
        String finalImage = image;


        bmbs = findViewById(R.id.btn_mybooks);
        bmbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(),MyBooksActivity.class);
                //제목을 가져감
                intent.putExtra("title",finalTitle);
                intent.putExtra("image",finalImage);
                intent.putExtra("author",finalAuthor);

                startActivity(intent);
            }
        });




    }
}