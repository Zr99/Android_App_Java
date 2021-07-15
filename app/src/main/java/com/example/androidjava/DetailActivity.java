package com.example.androidjava;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    /**
     * OnCreate: this method is called as part of the Android Lifecycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        
        //Create the intent and position
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        // Create a string array for titles and Set the title with the text and correct position
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        TextView title = (TextView)findViewById(R.id.detail_activity_textview_title);
        title.setText(titles[position]);

        //Create a string arrays and set the contents with correct text and correct position
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        TextView content = (TextView)findViewById(R.id.detail_activity_textview_content);
        content.setText(contents[position]);

        // Create a variable for the banner (An array)
        String[] banners = getResources().getStringArray(R.array.string_array_banners);
        int id = getResources().getIdentifier(banners[position], "drawable", getPackageName());
        //Put the image at the right place
        ImageView imageView = (ImageView)findViewById(R.id.detail_activity_imageview_banner);
        imageView.setImageDrawable(getDrawable(id));

    }

    /**
     * onCreateOptionsMenu: this method will inflate (make visible) the share button in the actionbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detail_menu, menu);
        return true;
    }

    /**
     * onOptionsItemSelected: this method handles a click event on menu items (i.e. your share button)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share:
                //Create an intent and set the action and the type
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                Intent intentPos = getIntent();
                int position = intentPos.getIntExtra("position", -1);
                // Get the title and contents
                String[] title = getResources().getStringArray(R.array.string_array_titles);
                String[] content = getResources().getStringArray(R.array.string_array_content);

                //Format well the output
                String text = title[position] + "\n\n" + content[position];
                intent.putExtra(intent.EXTRA_TEXT, text);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
