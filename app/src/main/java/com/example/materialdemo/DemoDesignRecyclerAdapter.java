package com.example.materialdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DemoDesignRecyclerAdapter extends RecyclerView.Adapter<DemoDesignRecyclerAdapter.ViewHolder> {

    List<String> listItem;

    public DemoDesignRecyclerAdapter(List<String> listItem) {
        this.listItem = listItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_raw, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = listItem.get(position);
        holder.myTextView.setText(item);




    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView myTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.list_item);
        }
    }
}