package com.fdev22.footballapp.service;

import com.fdev22.footballapp.model.football.FootballDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballRepository {
    @GET("1/search_all_teams.php?l=English%20Premier%20League")
    Call<FootballDiscoverResponse> getFootballDiscover();
}
