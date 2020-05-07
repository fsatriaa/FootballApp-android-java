package com.fdev22.footballapp.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fdev22.footballapp.model.football.FootballDiscoverResponse;
import com.fdev22.footballapp.model.football.FootballDiscoverTeamsItem;
import com.fdev22.footballapp.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<FootballDiscoverTeamsItem>> listDiscoverFootball = new MutableLiveData<>();

    public void  setFootballDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiFootball().getFootballDiscover().enqueue(new Callback<FootballDiscoverResponse>() {
            @Override
            public void onResponse(Call<FootballDiscoverResponse> call, Response<FootballDiscoverResponse> response) {
                FootballDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getTeams() != null){
                    ArrayList<FootballDiscoverTeamsItem> footballDiscoverItems = responseDiscover.getTeams();
                    listDiscoverFootball.postValue(footballDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<FootballDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<FootballDiscoverTeamsItem>> getFootballsDiscover(){
        return listDiscoverFootball;
    }
}
