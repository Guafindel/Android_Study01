package com.example.guifindel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    private TextView text_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        text_01 = findViewById(R.id.text_01);

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        text_01.setText(str);

    }
}
