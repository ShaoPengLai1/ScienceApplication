package com.wd.tech;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.tech.bean.ProductBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProductBean.Result> mList;
    private Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        mList=new ArrayList<>();
    }

    public void setmList(List<ProductBean.Result> lists) {
        mList.clear();
        if (lists!=null){
            mList.addAll(lists);
        }
        notifyDataSetChanged();
    }
    public void addmList(List<ProductBean.Result> lists) {
        if (lists!=null){
            mList.addAll(lists);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_show,viewGroup,false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ShowViewHolder holder= (ShowViewHolder) viewHolder;
        String[] split = mList.get(0).getThumbnail().split("\\|");
        Glide.with(mContext).load(split[0]).into(holder.icon);
        holder.tv.setText(mList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    static class ShowViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView tv;
        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);
            icon=itemView.findViewById(R.id.icon);
            tv=itemView.findViewById(R.id.tv_txt);
        }
    }
}
