package com.example.naman_dy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MoveActivity extends AppCompatActivity {

    private Button mBtnBookIn, mBtnMbs, mBtnFrd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        mBtnBookIn = findViewById(R.id.btn_bookIn);
        mBtnBookIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentB = new Intent(getApplicationContext(),BookInActivity.class);
                startActivity(intentB);
            }
        });
        mBtnFrd = findViewById(R.id.btn_Frd);
        mBtnFrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FriendsActivity.class);
                startActivity(intent);
            }
        });

        mBtnMbs = findViewById(R.id.btn_Mbs);
        mBtnMbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MyBooksActivity.class);
                startActivity(intent);
            }
        });



}
}