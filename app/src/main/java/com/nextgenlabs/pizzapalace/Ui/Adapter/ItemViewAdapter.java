package com.nextgenlabs.pizzapalace.Ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.nextgenlabs.pizzapalace.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    public ItemViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_a_home_upper_view, parent, false);
            holder = new UpperViewHolder(view);
        }
        else if(viewType == 1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_a_item_lowe_products_reviews, parent, false);
            holder = new lowerViewHolder(view);
        }
        assert holder != null;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpperViewHolder){

        }
        else if (holder instanceof lowerViewHolder){
            ((lowerViewHolder) holder).reviewHeading.setText("Reviews");
            ((lowerViewHolder) holder).reviewsViewHolder.setAdapter(new ReviewRVAdapter(context));
            ((lowerViewHolder) holder).reviewsViewHolder.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class UpperViewHolder extends RecyclerView.ViewHolder {
        Button backBtn,accountBtn;
        TextView productHeading,productDescription;
        ImageView itemImage;
        Button smallSizeBtn,mediumSizeBtn,largeSizeBtn;
        Button addItem,subItem;
        TextView itemCount;

        public UpperViewHolder(@NonNull View itemView) {
            super(itemView);
            backBtn = itemView.findViewById(R.id.aItem_backButton);
            accountBtn = itemView.findViewById(R.id.aItem_cartBtn);
            productHeading = itemView.findViewById(R.id.aItem_ProductName);
            productDescription = itemView.findViewById(R.id.aItem_productDetails);
            itemImage = itemView.findViewById(R.id.aItem_ProductImage);
            smallSizeBtn = itemView.findViewById(R.id.aItem_small);
            mediumSizeBtn = itemView.findViewById(R.id.aItem_Medium);
            largeSizeBtn = itemView.findViewById(R.id.aItem_Large);
            addItem = itemView.findViewById(R.id.aItemAddButton);
            subItem = itemView.findViewById(R.id.aItemSubButton);
            itemCount = itemView.findViewById(R.id.aItemItemCount);

        }
    }
    public static class lowerViewHolder extends RecyclerView.ViewHolder {
        TextView reviewHeading;
        RecyclerView reviewsViewHolder;
        public lowerViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewHeading = itemView.findViewById(R.id.aItem_reviews);
            reviewsViewHolder = itemView.findViewById(R.id.aItem_reviews_recyclerViewHolder);
        }
    }
}
