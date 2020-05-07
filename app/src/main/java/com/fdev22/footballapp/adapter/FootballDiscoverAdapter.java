package com.fdev22.footballapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fdev22.footballapp.R;
import com.fdev22.footballapp.model.football.FootballDiscoverTeamsItem;
import com.fdev22.footballapp.view.activity.DetailActivity;

import java.util.ArrayList;

public class FootballDiscoverAdapter extends RecyclerView.Adapter<FootballDiscoverAdapter.ViewHolder> {

    private ArrayList<FootballDiscoverTeamsItem> footballDiscoverSportsItems = new ArrayList<>();
    private Context context;

    private static String SMALL_IMAGE = "/preview";

    public FootballDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<FootballDiscoverTeamsItem> items) {
        footballDiscoverSportsItems.clear();
        footballDiscoverSportsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FootballDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull FootballDiscoverAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(footballDiscoverSportsItems.get(position)
                .getStrTeamBadge() + SMALL_IMAGE)
                .into(holder.ivThumb);

        holder.tvTitle.setText(footballDiscoverSportsItems.get(position).getStrTeam());
        holder.tvStadium.setText(footballDiscoverSportsItems.get(position).getIntFormedYear());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                String deskripsi = footballDiscoverSportsItems.get(position).getStrDescriptionEN();
                intent.putExtra("deskripsi", deskripsi);

                String nama = footballDiscoverSportsItems.get(position).getStrTeam();
                intent.putExtra("nama", nama);

                String logo = footballDiscoverSportsItems.get(position).getStrTeamBadge();
                intent.putExtra("logo", logo);

                String stadium = footballDiscoverSportsItems.get(position).getStrStadium();
                intent.putExtra("stadium", stadium);

                String kapasitas = footballDiscoverSportsItems.get(position).getIntStadiumCapacity();
                intent.putExtra("kapasitas", kapasitas);

                String web = footballDiscoverSportsItems.get(position).getStrWebsite();
                intent.putExtra("web", web);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return footballDiscoverSportsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        TextView tvTitle, tvStadium;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_title);
            tvStadium = itemView.findViewById(R.id.itemlist_tv_stadium);
        }
    }
}
