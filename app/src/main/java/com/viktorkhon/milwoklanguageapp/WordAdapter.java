package com.viktorkhon.milwoklanguageapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
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


/**
 * Created by Viktor Khon on 6/26/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokText);
        // Get the Miwok word from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.englishText);
        // Get the English word from the current Word object and
        // set this text on the english TextView
        englishTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID version_name
        ImageView imageViewID = (ImageView) listItemView.findViewById(R.id.imageView);
        // Get the image from the current Word object and
        // set this image on the image ImageView

        // Check if there is an image for this word
        if (currentWord.hasImage()) {
            // If an image is available, display it based on its ID and make it Visible
            imageViewID.setImageResource(currentWord.getImage());
            imageViewID.setVisibility(View.VISIBLE);
        } else {
            // Otherwise make a place for the image disappear completely
            imageViewID.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
                View textLayout = listItemView.findViewById(R.id.textLayout);
        // Set the background color of the text container View
                textLayout.setBackgroundResource(mColorResourceId);

        // Return the whole list item layout (containing 2 TextViews and 1 image)
        // so that it can be shown in the ListView.
        return listItemView;
    }
}
