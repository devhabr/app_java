package com.example.water.marketplace.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.water.marketplace.R;
import com.example.water.marketplace.fragment.branditem.CallBackLatestNews;
import com.example.water.marketplace.model.StatusBrand;

import java.util.List;

/**
 * Created by water on 29.09.2017.
 */

public class AdapterBrandList extends RecyclerView.Adapter<AdapterBrandList.ViewHolder> {

    private Context mContext;
    private List<StatusBrand.Brand> storiesList;
    public static final String NEWS_ID = "news _id";
    class ViewHolder extends  RecyclerView.ViewHolder{

        CardView cardView;
        ImageView newsImage;
        TextView newsText;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_item_brand);
            newsImage = (ImageView) itemView.findViewById(R.id.brand_image);
            newsText = (TextView) itemView.findViewById(R.id.brand_name);
        }
    }

    public AdapterBrandList(List<StatusBrand.Brand> list){
        this.storiesList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.macket_brand, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    int position = viewHolder.getAdapterPosition();
                LatestNews.StoriesBean storiesBean = storiesList.get(position);
                int id = storiesBean.getId();
                Intent intent = new Intent(mContext, ContentActivity.class);
                intent.putExtra(NEWS_ID, id);
                mContext.startActivity(intent);
                */
            }
        });
















        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StatusBrand.Brand storiesBean = storiesList.get(position);
        holder.newsText.setText(storiesBean.getName_brand());
        Glide.with(mContext).load(storiesBean.getImage_brand()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }

}