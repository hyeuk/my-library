package com.example.naman_dy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendsActivity extends AppCompatActivity {

    public void onClickAdd(View view) {
        Intent intent = new Intent(getApplicationContext(), FriendsAddActivity.class);
        startActivity(intent);
    }

    public void onClickMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);


        ListView listView = findViewById(R.id.friend_list);

        ArrayList<HashMap<String,String>> listData = new ArrayList<>();
        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), listData, R.layout.list_layout_thing,
                new String[] {"name","books"}, new int[] {R.id.textName, R.id.textBooks});

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name", "김철수");
        hashMap.put("books", "1Q84");
        listData.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "나영희");
        hashMap.put("books", "어린왕자");
        listData.add(hashMap);

        listView.setAdapter(simpleAdapter);

    }
}