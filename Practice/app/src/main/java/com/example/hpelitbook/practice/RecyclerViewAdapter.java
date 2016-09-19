package com.example.hpelitbook.practice;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP ElitBook on 9/17/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Data> dataList;
    public static final int WithoutImage=1,WithImage=0;

    RecyclerViewAdapter(List<Data> list){
        this.dataList=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case WithImage:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview1,parent,false);
                ImageViewHolder imageViewHolder=new ImageViewHolder(view);
                return imageViewHolder;

            case WithoutImage:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2,parent,false);
                WithoutImageViewHolder withoutImageViewHolder=new WithoutImageViewHolder(view);
                return withoutImageViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (dataList.get(position).viewtype){
            case WithImage:
                ((ImageViewHolder) holder).imageView.setImageResource(dataList.get(position).photo);
                ((ImageViewHolder) holder).title.setText(dataList.get(position).title);
                ((ImageViewHolder) holder).about.setText(dataList.get(position).about);
                break;
            case WithoutImage:
                ((WithoutImageViewHolder) holder).title.setText(dataList.get(position).title);
                ((WithoutImageViewHolder) holder).about.setText(dataList.get(position).about);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).viewtype == WithImage) {
            return WithImage;}
        return WithoutImage;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,about;
        CardView cardView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView) itemView.findViewById(R.id.cardview1);
            imageView =(ImageView) itemView.findViewById(R.id.photo);
            title=(TextView) itemView.findViewById(R.id.title);
            about=(TextView) itemView.findViewById(R.id.about);}
    }

    public class WithoutImageViewHolder extends RecyclerView.ViewHolder{
        TextView title,about;
        CardView cardView;

        public WithoutImageViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView) itemView.findViewById(R.id.cardview2);
            title=(TextView) itemView.findViewById(R.id.title);
            about=(TextView) itemView.findViewById(R.id.about);}
    }

    public void setFilter(List<Data> FilteredDataList) {
        dataList = FilteredDataList;
        notifyDataSetChanged();
    }
}
