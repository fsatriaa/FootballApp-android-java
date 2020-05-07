package com.fdev22.footballapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fdev22.footballapp.R;
import com.fdev22.footballapp.database.AppDatabase;
import com.fdev22.footballapp.database.PredictionModel;
import com.fdev22.footballapp.view.activity.PredictionActivity;

/**
 * A simple {@link Fragment} subclass.
 */

public class PredictionFragment extends Fragment {

    private AppDatabase appDatabase;
    private Button btnLihatData, btnInput;
    private EditText etTeam1, etTeam2, etScore1, etScore2;

    public PredictionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prediction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        btnLihatData = getView().findViewById(R.id.fragmentcreate_btn_lihatdata);
        btnInput = getView().findViewById(R.id.fragmentcreate_btn_input);

        etTeam1 = getView().findViewById(R.id.fragmentcreate_et_team1);
        etTeam2 = getView().findViewById(R.id.fragmentcreate_et_team2);
        etScore1 = getView().findViewById(R.id.fragmentcreate_et_score1);
        etScore2 = getView().findViewById(R.id.fragmentcreate_et_score2);

        appDatabase = AppDatabase.initDatabase(getActivity().getApplicationContext());

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PredictionModel predictionModel = new PredictionModel();


                    predictionModel.setTeam1(etTeam1.getText().toString());
                    predictionModel.setTeam2(etTeam2.getText().toString());
                    predictionModel.setScore1(etScore1.getText().toString());
                    predictionModel.setScore2(etScore2.getText().toString());

                    appDatabase.predictionDao().insertPrediction(predictionModel);

                    etTeam1.getText().clear();
                    etTeam2.getText().clear();
                    etScore1.getText().clear();
                    etScore2.getText().clear();


                    Log.e("CreateFragment", "berhasil input");
                    Toast.makeText(getActivity().getApplicationContext(), "Berhasil Input", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Log.e("CreateFragment", "gagal input , msg : " + ex.getMessage());
                    Toast.makeText(getActivity().getApplicationContext(), "Gagal Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), PredictionActivity.class);
                startActivity(intent);
            }
        });
    }
}
