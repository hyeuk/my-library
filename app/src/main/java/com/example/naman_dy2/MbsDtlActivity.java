package com.example.naman_dy2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MbsDtlActivity extends AppCompatActivity {

    EditText edtbookrep;
    TextView txtbookrep;
    private EditText edtin, edtfull;
    private ProgressBar progressBar;
    private Button btnst;
    private int full, in;

    public void onClickInputA(View view) {        // 독후감을 저장하기 위한 버튼의 onClick 함수 구현입니다
        String sInput = edtbookrep.getText().toString();
        txtbookrep.append(sInput);
        edtbookrep.getText().clear();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbs_dtl);

        String title = "";
        String author = "";
        String image = "";

        Bundle extras = getIntent().getExtras();

        title = extras.getString("title");
        author = extras.getString("author");
        image = extras.getString("image");

        TextView textView1 = findViewById(R.id.mbs_tit);
        TextView textView2 = findViewById(R.id.mbs_aut);
        ImageView imageView = findViewById(R.id.mbs_img);

        Picasso.get().load(image).into(imageView);

        String str1 = title;
        String str2 = author;

        String textWithoutTag1 = str1.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        String textWithoutTag2 = str2.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

        textView1.setText(textWithoutTag1);
        textView2.setText(textWithoutTag2);

        edtbookrep = findViewById(R.id.book_report_in);
        txtbookrep = findViewById(R.id.book_report);

        edtin = findViewById(R.id.edt_in);    // 읽은 페이지 수 edittext
        edtfull = findViewById(R.id.edt_full); // 전체 페이지 수 edittext
        progressBar = findViewById(R.id.progressBar);
        btnst = findViewById(R.id.btn_st); // 계산 버튼

        btnst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                full = Integer.parseInt(edtfull.getText().toString());
                progressBar.setMax(full);     // progressbar의 max값을 full(전체 페이지 수)로 설정
                in = Integer.parseInt(edtin.getText().toString());
                progressBar.setProgress(in); // progressbar의 min값을 in(읽은 페이지 수)로 설정
            }
        });




        Button btnClear1 = findViewById(R.id.button_del);
        btnClear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtbookrep.setText("");
                edtbookrep.setText("");
            }
        });


    }
}