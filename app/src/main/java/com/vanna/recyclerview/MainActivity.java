package com.vanna.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String data[] = {
            "Word 1",
            "Word 2",
            "Word 3",
            "Word 4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(defaultItemAnimator);

        MyAdapter myAdapter = new MyAdapter(data);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setViewHolderClickListener(new ViewHolderClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("MainActivity", "received position " + position);
                String word = data[position];
                goToDetail(word);
            }
        });

        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);

//        goToDetail("RUPP 2");
    }

    private void goToDetail(String word) {
        Intent intent = new Intent(getApplicationContext(), DefinitionActivity.class);
        intent.putExtra("word", word);
        startActivity(intent);
    }
}
