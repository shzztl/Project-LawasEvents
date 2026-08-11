package com.example.lawasevents;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter
        extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    Context context;
    ArrayList<Event> events;

    public EventAdapter(
            Context context,
            ArrayList<Event> events) {

        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_event,
                        parent,
                        false
                );

        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull EventViewHolder holder,
            int position) {

        Event event = events.get(position);

        holder.imgEvent.setImageResource(
                event.getImageResource()
        );

        holder.imgEvent.setOnClickListener(v -> {

            Intent intent = new Intent(
                    context,
                    EventDetailsActivity.class
            );

            intent.putExtra(
                    "title",
                    event.getTitle()
            );

            intent.putExtra(
                    "date",
                    event.getDate()
            );

            intent.putExtra(
                    "venue",
                    event.getVenue()
            );

            intent.putExtra(
                    "category",
                    event.getCategory()
            );

            intent.putExtra(
                    "description",
                    event.getDescription()
            );

            intent.putExtra(
                    "image",
                    event.getImageResource()
            );

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imgEvent;

        public EventViewHolder(@NonNull View itemView) {

            super(itemView);

            imgEvent = itemView.findViewById(
                    R.id.imgEvent
            );
        }
    }
}
