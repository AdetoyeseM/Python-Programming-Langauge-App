package com.example.pythonproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends ArrayAdapter<String> {

String[] Tutorial;
int[] pics;
Context mContext;
    public myAdapter(@NonNull Context context, String[] TutorialHead, int[] Pics)

    {
        super(context, R.layout.listview_item);
        this.Tutorial = TutorialHead;
        this.pics = Pics;
        this.mContext = context;
    }


    @Override
    public int getCount() {
        return Tutorial.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.Pics = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.textView = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
            mViewHolder.Pics.setImageResource(pics[position]);
            mViewHolder.textView.setText(Tutorial[position]);

            return convertView;

    }

    static class ViewHolder{
        ImageView Pics;
        TextView textView;

    }

    }

