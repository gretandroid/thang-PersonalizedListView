package com.example.personalizedlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MainActivity extends ListActivity { // une liste embarqué dans une activité
    private String[] items = {"mot1", "mot2", "mot3", "mots4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new CustomAdapter(this, R.layout.row,R.id.label, items));
    }

    class CustomAdapter extends ArrayAdapter<String> {

        public CustomAdapter(@NonNull Context context,
                             int resource,
                             int textViewResourceId,
                             @NonNull String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            // la ligne affiché
            View view = super.getView(position, convertView, parent);

            // get icon to check and repalce if necessaire
            ImageView icon = view.findViewById(R.id.icon);

            if (items[position].length() > 4) {
                icon.setImageResource(android.R.drawable.checkbox_on_background);
            }
            else {
                icon.setImageResource(android.R.drawable.checkbox_off_background);
            }

            return view;

        }
    }
}