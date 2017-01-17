package com.example.s1.beautyandroid.adapter;

/**
 * Created by s1 on 1/16/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.s1.beautyandroid.R;
import com.example.s1.beautyandroid.pojo.Media;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MediaAdapter extends ArrayAdapter<Media> {

    List<Media> mediaList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MediaAdapter(Context context, List<Media> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        mediaList = objects;
    }

    @Override
    public Media getItem(int position) {
        return mediaList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.media_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Media item = getItem(position);

        vh.textViewTitle.setText(item.getTitle());
        vh.textViewContent.setText(item.getContent());
        Picasso.with(context).load(item.getThumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewTitle;
        public final TextView textViewContent;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewTitle, TextView textViewContent) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewTitle = textViewTitle;
            this.textViewContent = textViewContent;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewTitle = (TextView) rootView.findViewById(R.id.textViewTitle);
            TextView textViewContent = (TextView) rootView.findViewById(R.id.textViewContent);
            return new ViewHolder(rootView, imageView, textViewTitle, textViewContent);
        }
    }
}
