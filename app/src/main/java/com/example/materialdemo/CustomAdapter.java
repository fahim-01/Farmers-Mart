package com.example.materialdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] pic ;
    String[] itemNames;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context,String[] itemNames,int[] pic){

        this.context=context;
        this.itemNames=itemNames;
        this.pic =pic;

    }

    @Override
    public int getCount() {
        return itemNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bazardor_list_item,parent,false);

        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewId);
        System.out.println("imageView" + imageView);
        System.out.println("pic position "+pic[position]);
        TextView textView =(TextView) convertView.findViewById(R.id.itemNameId);


        imageView.setImageResource(pic[position]);
        textView.setText(itemNames[position]);

        return convertView;
    }
}
