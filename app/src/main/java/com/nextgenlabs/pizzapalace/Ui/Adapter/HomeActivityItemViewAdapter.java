package com.nextgenlabs.pizzapalace.Ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nextgenlabs.pizzapalace.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivityItemViewAdapter extends RecyclerView.Adapter<HomeActivityItemViewAdapter.ItemViewHolder> {
    Context context;
    String itemName;

    public HomeActivityItemViewAdapter(Context context,String itemName) {
        this.context = context;
        this.itemName = itemName;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_ahome_lower_view_frame, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemName.setText(itemName);
        holder.itemPrepTime.setText("15 minutes");
        holder.itemImageView.setImageResource(R.drawable.ic_launcher_foreground);
        holder.prepIcon.setImageResource(R.drawable.ic_baseline_alarm_on_24);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        ImageView itemImageView,prepIcon;
        TextView itemName,itemPrepTime;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.aHome_fragment_recyclerView_Content);
            itemImageView = itemView.findViewById(R.id.aHome_itemView_image);
            itemName = itemView.findViewById(R.id.aHome_itemView_itemName);
            prepIcon =itemView.findViewById(R.id.aHome_itemView_timeImage);
            itemPrepTime = itemView.findViewById(R.id.aHome_prepTime);
        }
    }
}
