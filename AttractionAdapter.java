package com.example.lawaseventia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {
    private ArrayList<Integer> images;
    private ArrayList<String> names;

    public AttractionAdapter(
            ArrayList<Integer> images,
            ArrayList<String> names) {

        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_attraction,
                        parent,
                        false
                );
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {

        holder.imgAttraction.setImageResource(
                images.get(position)
        );

        holder.txtAttractionName.setText(
                names.get(position)
        );
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAttraction;
        TextView txtAttractionName;

        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAttraction = itemView.findViewById(R.id.imgAttraction);
            txtAttractionName = itemView.findViewById(R.id.txtAttractionName);
        }
    }
}
