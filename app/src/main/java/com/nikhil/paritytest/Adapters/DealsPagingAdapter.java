package com.nikhil.paritytest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nikhil.paritytest.R;
import com.nikhil.paritytest.Utils.ViewUtils;
import com.nikhil.paritytest.networks.Response.DealResponse;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DealsPagingAdapter extends PagedListAdapter<DealResponse.Datum,DealsPagingAdapter.Viewholder> {



    private Context context;
     public DealsPagingAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rev_item_deals,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        DealResponse.Datum datum = getItem(position);

        Glide.with(context).load(datum.image).into(holder.imgThumb);
        holder.likes.setText(String.valueOf(datum.voteCount));
        holder.comments.setText(String.valueOf(datum.commentsCount));
        holder.time.setText(ViewUtils.getDate(datum.createdAt,"dd-MMM-yyyy"));
        holder.title.setText(String.valueOf(datum.title));

    }

    // To check object are same or not
    private static DiffUtil.ItemCallback<DealResponse.Datum> DIFF_CALLBACK = new DiffUtil.ItemCallback<DealResponse.Datum>() {
        @Override
        public boolean areItemsTheSame(@NonNull DealResponse.Datum oldItem, @NonNull DealResponse.Datum newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DealResponse.Datum oldItem, @NonNull DealResponse.Datum newItem) {
            return false;
        }
    };


    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imgThumb;
        TextView likes,comments,time,title;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imgThumb = itemView.findViewById(R.id.rev_item_img_thumb);
            likes = itemView.findViewById(R.id.txt_rev_deals_like);
            comments = itemView.findViewById(R.id.txt_rev_deals_comment);
            time = itemView.findViewById(R.id.txt_rev_deals_time);
            title = itemView.findViewById(R.id.txt_rev_deals_title);

        }
    }
}
