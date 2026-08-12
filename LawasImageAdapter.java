package com.example.lawasevents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LawasImageAdapter
        extends RecyclerView.Adapter<LawasImageAdapter.LawasImageViewHolder> {

    private final ArrayList<Integer> images;

    public LawasImageAdapter(ArrayList<Integer> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public LawasImageViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lawas_image, parent, false);

        return new LawasImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull LawasImageViewHolder holder,
            int position) {

        holder.imageView.setImageResource(
                images.get(position)
        );
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class LawasImageViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imageView;

        public LawasImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(
                    R.id.imgLawas
            );
        }
    }
}
```
