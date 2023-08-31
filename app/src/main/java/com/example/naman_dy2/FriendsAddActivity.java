package com.example.naman_dy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendsAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_add);

        Intent intent = getIntent();

        ListView listView = findViewById(R.id.recommend_list);

        ArrayList<HashMap<String,String>> listData = new ArrayList<>();
        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), listData, R.layout.list_layout_thing,
                new String[] {"name","books"}, new int[] {R.id.textName, R.id.textBooks});

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name", "김미영");
        hashMap.put("books", "모모");
        listData.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "이민지");
        hashMap.put("books", "멋진 신세계");
        listData.add(hashMap);

        listView.setAdapter(simpleAdapter);

    }
}