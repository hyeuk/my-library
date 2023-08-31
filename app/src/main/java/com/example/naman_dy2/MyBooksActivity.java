package com.example.naman_dy2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyBooksActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books);

        String title = "";
        String author = "";
        String image = "";

        Bundle extras = getIntent().getExtras();

        title = extras.getString("title");
        author = extras.getString("author");
        image = extras.getString("image");

        TextView textView1 = findViewById(R.id.txt_tit);
        TextView textView2 = findViewById(R.id.txt_aut);
        ImageView imageView = findViewById(R.id.img_cover);

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


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(getApplicationContext(),MbsDtlActivity.class);
                //제목을 가져감
                intent.putExtra("title",finalTitle);
                intent.putExtra("image",finalImage);
                intent.putExtra("author",finalAuthor);

                startActivity(intent);
            }
        });

    }
}