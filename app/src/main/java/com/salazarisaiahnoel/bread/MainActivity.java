package com.salazarisaiahnoel.bread;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.salazarisaiahnoel.listpack.SimpleList;
import com.salazarisaiahnoel.listpack.adapters.SimpleListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SimpleListAdapter.OnItemClickListener, SimpleListAdapter.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<String> data = new ArrayList<>();
        data.add("Sample text");
        data.add("Sample text");
        data.add("Sample text");

        RecyclerView rv = findViewById(R.id.rv);

        SimpleList simpleList = new SimpleList(this, rv, data, this, this);
        simpleList.setItemPadding(16);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleList.addItem("Sample text");
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Tap", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(int position) {
        Toast.makeText(this, "Long", Toast.LENGTH_SHORT).show();
    }
}