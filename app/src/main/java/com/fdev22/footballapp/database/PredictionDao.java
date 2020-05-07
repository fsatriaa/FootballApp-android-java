package com.fdev22.footballapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PredictionDao {

    @Insert
    long insertPrediction(PredictionModel predictionModel);

    @Delete
    int deletePrediction(PredictionModel predictionModel);

    @Query("SELECT * FROM data_prediction")
    List<PredictionModel> getPrediction();
}
