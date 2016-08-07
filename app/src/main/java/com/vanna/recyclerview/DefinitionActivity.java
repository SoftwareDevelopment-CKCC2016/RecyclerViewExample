package com.vanna.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DefinitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        String word = getIntent().getStringExtra("word");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(word);

    }
}
