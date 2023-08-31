package com.example.naman_dy2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    EditText edtbookrep;
    TextView txtbookrep;

    public void onClickInputA(View view) {        // 독후감을 저장하기 위한 버튼의 onClick 함수 구현입니다
        String sInput = edtbookrep.getText().toString();
        txtbookrep.append(sInput);
        edtbookrep.getText().clear();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        edtbookrep = findViewById(R.id.book_report_in);
        txtbookrep = findViewById(R.id.book_report);

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