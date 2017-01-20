package com.example.s1.beautyandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.s1.beautyandroid.R;
import com.example.s1.beautyandroid.pojo.StoreMembership;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by s1 on 1/18/2017.
 */

public class StoreMembershipAdapter extends ArrayAdapter<StoreMembership> {

    List<StoreMembership> storeMembershipList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public StoreMembershipAdapter(Context context, List<StoreMembership> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        storeMembershipList = objects;
    }

    @Override
    public StoreMembership getItem(int position) {
        return storeMembershipList.get(position);
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

        StoreMembership item = getItem(position);

        // vh.textViewTitle.setText(item.getTitle());
        // vh.textViewContent.setText(item.getContent());
        Picasso.with(context).load(item.getCardimage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        // public final TextView textViewTitle;
        // public final TextView textViewContent;

        private ViewHolder(RelativeLayout rootView, ImageView imageView) {
            this.rootView = rootView;
            this.imageView = imageView;
            // this.textViewTitle = textViewTitle;
            // this.textViewContent = textViewContent;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            // TextView textViewTitle = (TextView) rootView.findViewById(R.id.textViewTitle);
            // TextView textViewContent = (TextView) rootView.findViewById(R.id.textViewContent);
            return new ViewHolder(rootView, imageView);
        }
    }
}
