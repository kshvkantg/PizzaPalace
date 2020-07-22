package com.nextgenlabs.pizzapalace.Ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nextgenlabs.pizzapalace.R;
import com.nextgenlabs.pizzapalace.Ui.Adapter.ItemViewAdapter;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        RecyclerView recyclerView = findViewById(R.id.aItem_main_recyclerViewHolder);
        recyclerView.setAdapter(new ItemViewAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}