package com.example.it_schoolandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyNewsAdapter extends ArrayAdapter<MyNews> {
    public MyNewsAdapter(Context context, MyNews[] arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final MyNews news = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }
        ((TextView) convertView.findViewById(R.id.news_title)).setText(news.title);
        ((TextView) convertView.findViewById(R.id.news_content)).setText(news.content);

        ((ImageView) convertView.findViewById(R.id.news_image)).setImageResource(news.image);

        Button like = convertView.findViewById(R.id.like);
        like.setOnClickListener(view -> {
            if (!news.liked) {
                news.liked = true;
                //like.getBackground().setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_ATOP);
                like.getBackground().setTint(R.color.red);
                like.setText("\uD83D\uDC4D" + " 1");
            } else {
                news.liked = false;
                //like.getBackground().setColorFilter(Color.parseColor("E0E0E0"), PorterDuff.Mode.SRC_ATOP);
                like.getBackground().setTint(R.color.grey_E);
                like.setText("\uD83D\uDC4D");
            }
        });

        Button comment = convertView.findViewById(R.id.comment);
        comment.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), CommentActivity.class);
            getContext().startActivity(intent);
        });

        Button share = convertView.findViewById(R.id.share);
        share.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Sharing is not availible now",Toast.LENGTH_SHORT).show();
        });
        return convertView;
    }
}
