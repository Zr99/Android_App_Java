package com.example.androidjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    /**
     * OnCreate: this method is called as part of the Android Lifecycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Create a string array
        String[] item = getResources().getStringArray(R.array.string_array_titles);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, item);
        ListView listView = (ListView)findViewById(R.id.listview_uow);
        listView.setAdapter(arrayAdapter);

        // create a listener
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(onItemClickListener);

    }
}
