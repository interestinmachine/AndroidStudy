package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initFruit() {
        for (int i = 0; i < 4; i++) {
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Orange", R.drawable.orange_pic));
            fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
            fruitList.add(new Fruit("Pear", R.drawable.pear_pic));
            fruitList.add(new Fruit("Grape", R.drawable.grape_pic));
            fruitList.add(new Fruit("Pineapple", R.drawable.pineapple_pic));
            fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_pic));
            fruitList.add(new Fruit("Cherry", R.drawable.cherry_pic));
            fruitList.add(new Fruit("Mango", R.drawable.mango_pic));
        }
    }
}