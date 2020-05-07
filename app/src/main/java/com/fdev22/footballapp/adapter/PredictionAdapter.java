package com.fdev22.footballapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fdev22.footballapp.R;
import com.fdev22.footballapp.database.AppDatabase;
import com.fdev22.footballapp.database.PredictionModel;
import com.fdev22.footballapp.view.activity.MainActivity;
import com.fdev22.footballapp.view.activity.PredictionActivity;
import com.fdev22.footballapp.view.fragment.PredictionFragment;

import java.util.ArrayList;

public class PredictionAdapter extends RecyclerView.Adapter<PredictionAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PredictionModel> predictionItems = new ArrayList<>();
    private AppDatabase appDatabase;

    public PredictionAdapter(Context context){
        this.context = context;
        appDatabase = AppDatabase.initDatabase(this.context);
    }

    public void setData(ArrayList<PredictionModel> items){
        predictionItems.clear();
        predictionItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PredictionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_prediction,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PredictionAdapter.ViewHolder holder, final int position) {
        holder.tvTeam1.setText(predictionItems.get(position).getTeam1());
        holder.tvTeam2.setText(predictionItems.get(position).getTeam2());
        holder.tvScore1.setText(predictionItems.get(position).getScore1());
        holder.tvScore2.setText(predictionItems.get(position).getScore2());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    PredictionModel predictionModel = new PredictionModel();
                    predictionModel.setTeam1(predictionItems.get(position).getTeam1());
                    predictionModel.setTeam2(predictionItems.get(position).getTeam2());
                    predictionModel.setScore1(predictionItems.get(position).getScore1());
                    predictionModel.setScore2(predictionItems.get(position).getScore2());
                    predictionModel.setId(predictionItems.get(position).getId());

                    appDatabase.predictionDao().deletePrediction(predictionModel);

                    Log.e("PredictionAdapter","data berhasil dihapus");
                    Toast.makeText(context,"Data Berhasil Dihapus",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent (v.getContext(), MainActivity.class);
                    v.getContext().startActivity(intent);

                }catch (Exception ex){
                    Log.e("PredictionAdapter","gagal menghapus , msg : "+ex.getMessage());
                    Toast.makeText(context.getApplicationContext(),"Gagal Menghapus Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return predictionItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btnDelete;
        TextView tvTeam1,tvTeam2,tvScore1,tvScore2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnDelete=itemView.findViewById(R.id.itemlist_prediction_btn_delete);

            tvTeam1=itemView.findViewById(R.id.itemlist_prediction_tv_team1);
            tvTeam2=itemView.findViewById(R.id.itemlist_prediction_tv_team2);
            tvScore1=itemView.findViewById(R.id.itemlist_prediction_tv_score1);
            tvScore2=itemView.findViewById(R.id.itemlist_prediction_tv_score2);


        }
    }
}
