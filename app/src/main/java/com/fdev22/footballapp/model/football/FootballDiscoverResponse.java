package com.fdev22.footballapp.model.football;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FootballDiscoverResponse{

	@SerializedName("teams")
	private ArrayList<FootballDiscoverTeamsItem> teams;

	public void setTeams(ArrayList<FootballDiscoverTeamsItem> teams){
		this.teams = teams;
	}

	public ArrayList<FootballDiscoverTeamsItem> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"FootballDiscoverResponse{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}