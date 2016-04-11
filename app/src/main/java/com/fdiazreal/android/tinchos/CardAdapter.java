package com.fdiazreal.android.tinchos;

import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<SentAudio> elements;

    public CardAdapter(List<SentAudio> elements) {
        this.elements = elements;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected ImageButton playButton;
        protected ImageButton shareButton;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.playButton = (ImageButton) itemView.findViewById(R.id.card_play);
            this.shareButton = (ImageButton) itemView.findViewById(R.id.card_share);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardLayout = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        return new ViewHolder(cardLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SentAudio element = elements.get(position);

        final MediaPlayer mediaPlayer = MediaPlayer.create(holder.playButton.getContext(), element.getAudio());

        holder.title.setText(element.getTitle());
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
