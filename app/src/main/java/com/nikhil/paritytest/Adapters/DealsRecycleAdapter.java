package com.nikhil.paritytest.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nikhil.paritytest.R;
import com.nikhil.paritytest.networks.Response.DealResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DealsRecycleAdapter extends RecyclerView.Adapter<DealsRecycleAdapter.ViewHolder> {


    private List<DealResponse.Datum> dealsList;
    private Context context;

    public DealsRecycleAdapter(Context context, List<DealResponse.Datum> dealsList){

        this.dealsList = dealsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rev_item_deals,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(dealsList.get(position).image).into(holder.imgThumb);
        holder.likes.setText(String.valueOf(dealsList.get(position).voteCount));
        holder.comments.setText(String.valueOf(dealsList.get(position).commentsCount));
        holder.time.setText(String.valueOf(dealsList.get(position).createdAt));
        holder.title.setText(String.valueOf(dealsList.get(position).title));

    }

    @Override
    public int getItemCount() {
        return dealsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgThumb;
        TextView likes,comments,time,title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgThumb = itemView.findViewById(R.id.rev_item_img_thumb);
            likes = itemView.findViewById(R.id.txt_rev_deals_like);
            comments = itemView.findViewById(R.id.txt_rev_deals_comment);
            time = itemView.findViewById(R.id.txt_rev_deals_time);
            title = itemView.findViewById(R.id.txt_rev_deals_title);

        }
    }
}
