package com.example.naman_dy2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    //데이터를 생성하기 위해서
    ArrayList<BookVO> array;
    String apiURL="https://openapi.naver.com/v1/search/book.json?";
    String query="안드로이드";
    int start=1;

    RecyclerView list;
    BookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("도서 검색");

        list=findViewById(R.id.list);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        list.setLayoutManager(manager);

        //생성
        array=new ArrayList<BookVO>();

        //생성
        new BookThread().execute();



        final EditText edtsearch=findViewById(R.id.edtsearch);
        edtsearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                start = 1;
                array.clear();
                if(BookInActivity.BResult != null){

                    String redtsearch = "";
                    Bundle extras = getIntent().getExtras();
                    redtsearch = extras.getString("edtsearch");
                    edtsearch.setText(redtsearch);

                    query = edtsearch.getText().toString();
                    new BookThread().execute();
                    return false;
                }
                else {
                    query = edtsearch.getText().toString();
                    new BookThread().execute();
                    return false;
                }
            }
        });
        FloatingActionButton btnmore=findViewById(R.id.btnmore);
        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start += 10;
                new BookThread().execute();
            }
        });
    }
    //BackThread 생성
    class BookThread extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {
            return NaverAPI.main(apiURL,query,start);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println("결과.........."+s);
            try {
                JSONArray jArray=new JSONObject(s).getJSONArray("items");
                for(int i=0; i<jArray.length(); i++){
                    JSONObject obj=jArray.getJSONObject(i);
                    BookVO vo=new BookVO();
                    vo.setAuthor(obj.getString("author"));
                    vo.setImage(obj.getString("image"));
                    vo.setPrice(obj.getInt("price"));
                    vo.setDescription(obj.getString("description"));
                    vo.setLink(obj.getString("link"));
                    vo.setTitle(obj.getString("title"));
                    array.add(vo);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter=new BookAdapter(array,BookActivity.this);
            list.setAdapter(adapter);
            list.scrollToPosition(start);
        }
    }
}