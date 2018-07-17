package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;


    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word numberWord = getItem(position);

        // Find the Layout containing the text
        View textLayout = listItemView.findViewById(R.id.text_layout);

        // Set background color in that layout
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textLayout.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok translation from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(numberWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the default translation from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(numberWord.getDefaultTranslation());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.word_icon);

        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView if it contains one else hide the text view
        if(numberWord.hasImage()) {
            iconView.setImageResource(numberWord.getImageResourceId());
        } else {
            iconView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
