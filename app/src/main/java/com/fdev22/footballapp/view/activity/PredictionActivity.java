package com.fdev22.footballapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fdev22.footballapp.R;
import com.fdev22.footballapp.adapter.PredictionAdapter;
import com.fdev22.footballapp.database.AppDatabase;
import com.fdev22.footballapp.database.PredictionModel;

import java.util.ArrayList;

public class PredictionActivity extends AppCompatActivity {

    private PredictionAdapter predictionAdapter;
    private RecyclerView rvPrediction;
    private AppDatabase appDatabase;
    private ArrayList<PredictionModel> listPrediction = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        rvPrediction = findViewById(R.id.activityprediction_rv_prediction);
        predictionAdapter = new PredictionAdapter(getApplicationContext());
        predictionAdapter.notifyDataSetChanged();

        if (appDatabase == null) {
            appDatabase = AppDatabase.initDatabase(getApplicationContext());
        }

        listPrediction.addAll(appDatabase.predictionDao().getPrediction());
        predictionAdapter.setData(listPrediction);

        rvPrediction.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvPrediction.setAdapter(predictionAdapter);

    }
}
