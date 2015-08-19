package com.example.sdm.xsztw_scenery.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sdm.xsztw_scenery.R;
import com.example.sdm.xsztw_scenery.model.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sdm on 2015/8/18.
 */
public class MyGridViewAdapter extends ArrayAdapter {
    int mResource;
    public MyGridViewAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Image image = (Image) getItem(position);
        ViewHolder viewHolder ;
        if(convertView ==null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResource, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_Image);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_imageTitle);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(getContext()).load(image.getUrl())
                .resize(425,600)
                .centerCrop().into(viewHolder.imageView);
        viewHolder.textView.setText(image.getTitle());
        return convertView;
    }

    class ViewHolder{
        private ImageView imageView;
        private TextView textView;
    }
}
