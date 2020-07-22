package com.nextgenlabs.pizzapalace.Ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.nextgenlabs.pizzapalace.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public ReviewRVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_a_item_review_recycler_view, parent, false);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReviewHolder){
            ((ReviewHolder) holder).reviewerImage.setImageResource(R.drawable.ic_baseline_alarm_on_24);
            ((ReviewHolder) holder).reviewerName.setText("Carrie Rogers");
            ((ReviewHolder) holder).review.setText(R.string.sample_review);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ReviewHolder extends RecyclerView.ViewHolder {
        ImageView reviewerImage;
        TextView reviewerName,review;
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            reviewerImage = itemView.findViewById(R.id.aItem_ReviewerImage);
            reviewerName = itemView.findViewById(R.id.aItem_ReviewerName);
            review = itemView.findViewById(R.id.aItem_review);
        }
    }

    public static class AddReviewClass extends RecyclerView.ViewHolder {
        ImageView profileImage;
        EditText addReview;
        Button submitReview;
        public AddReviewClass(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.aItem_reviewProfileImage);
            addReview = itemView.findViewById(R.id.aItem_reviewEdit);
            submitReview = itemView.findViewById(R.id.button);

        }
    }
}
