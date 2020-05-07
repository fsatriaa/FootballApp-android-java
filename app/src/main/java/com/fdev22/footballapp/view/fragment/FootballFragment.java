package com.fdev22.footballapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.fdev22.footballapp.R;
import com.fdev22.footballapp.adapter.FootballDiscoverAdapter;
import com.fdev22.footballapp.model.football.FootballDiscoverTeamsItem;
import com.fdev22.footballapp.view.viewmodel.FootballViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FootballFragment extends Fragment {

    private FootballDiscoverAdapter footballDiscoverAdapter;
    private RecyclerView rvFootballDiscover;
    private FootballViewModel footballViewModel;

    public FootballFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_football, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        footballDiscoverAdapter = new FootballDiscoverAdapter(getContext());
        footballDiscoverAdapter.notifyDataSetChanged();

        rvFootballDiscover=view.findViewById(R.id.fragmentfootball_rv);
        rvFootballDiscover.setLayoutManager(new GridLayoutManager(getContext(),2));

        footballViewModel = new ViewModelProvider(this).get(FootballViewModel.class);
        footballViewModel.setFootballDiscover();
        footballViewModel.getFootballsDiscover().observe(this,getFootballDiscover);

        rvFootballDiscover.setAdapter(footballDiscoverAdapter);
    }

    private Observer<ArrayList<FootballDiscoverTeamsItem>> getFootballDiscover = new Observer<ArrayList<FootballDiscoverTeamsItem>>() {
        @Override
        public void onChanged(ArrayList<FootballDiscoverTeamsItem> footballDiscoverTeamsItems) {
            if (footballDiscoverTeamsItems != null){
                footballDiscoverAdapter.setData(footballDiscoverTeamsItems);
            }
        }
    };
}
