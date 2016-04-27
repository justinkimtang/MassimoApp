package com.example.landonbedell.massimo;
import java.util.ArrayList;
public interface Recommender {
    public ArrayList<Ratable> getRecommendation(ArrayList<Ratable> recommendations);
}

