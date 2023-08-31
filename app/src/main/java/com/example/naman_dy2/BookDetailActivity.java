package com.example.naman_dy2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import java.util.*;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {

    // 파이어베이스 데이터베이스 연동

    Button bsave;
    Button bwish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_deatil);




        String title = "";
        String author = "";
        String image = "";

        Bundle extras = getIntent().getExtras();

        title = extras.getString("title");
        author = extras.getString("author");
        image = extras.getString("image");

        TextView textView1 = findViewById(R.id.title_detail);
        TextView textView2 = findViewById(R.id.author_detail);
        ImageView imageView = findViewById(R.id.book_detail);

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

        bsave = findViewById(R.id.btn_booklist);
        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(getApplicationContext(),TolibActivity.class);
                //제목을 가져감
                intent.putExtra("title",finalTitle);
                intent.putExtra("image",finalImage);
                intent.putExtra("author",finalAuthor);

                startActivity(intent);
            }
        });

        bwish = findViewById(R.id.btn_wish);
        bwish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(getApplicationContext(),ReportActivity.class);
                startActivity(intent);
            }
        });


    }
}