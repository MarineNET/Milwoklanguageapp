package com.viktorkhon.milwoklanguageapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor Khon on 7/5/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokWord = (TextView) convertView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getMiwokTranslation());

        TextView englishWord = (TextView) convertView.findViewById(R.id.english_text_view);
        englishWord.setText(currentWord.getDefaultTranslation());

        return convertView;
    }
}
