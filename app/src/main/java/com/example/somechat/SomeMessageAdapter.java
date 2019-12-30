package com.example.somechat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class SomeMessageAdapter extends ArrayAdapter<SomeMessage> {

    private List<SomeMessage> messages;
    private Activity activity;

    public SomeMessageAdapter(Activity context, int resource, List<SomeMessage> messages) {
        super(context, resource, messages);
        this.messages = messages;
        this.activity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        LayoutInflater layoutInflater = (LayoutInflater)
                activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        SomeMessage someMessage = getItem(position);
        int layoutResource = 0;
        int viewType = getItemViewType(position);

        if(viewType == 0){
            layoutResource = R.layout.my_message_item;
        }else{
            layoutResource = R.layout.your_message_item;
        }


        if(convertView != null){
            viewHolder = (ViewHolder)convertView.getTag();
        }else{
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        boolean isText = someMessage.getImageUrl() == null;
        if(isText){
            viewHolder.messageTexiView.setVisibility(View.VISIBLE);
            viewHolder.photoImageView.setVisibility(View.GONE);
            viewHolder.messageTexiView.setText(someMessage.getText());
        }else{
            viewHolder.messageTexiView.setVisibility(View.GONE);
            viewHolder.photoImageView.setVisibility(View.VISIBLE);
            Glide.with(viewHolder.photoImageView.getContext()).load(someMessage.getImageUrl())
                    .into(viewHolder.photoImageView);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {

        int flag;
        SomeMessage someMessage = messages.get(position);
        if(someMessage.isMine()){
            flag = 0;
        }else{
            flag = 1;
        }

        return flag;

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private class ViewHolder {

        private ImageView photoImageView;
        private TextView messageTexiView;

        public ViewHolder(View view){
            photoImageView = view.findViewById(R.id.photoImageView);
            messageTexiView = view.findViewById(R.id.messageTextView);
        }

    }

}
