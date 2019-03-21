package com.akademiakodu.Alcomat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class AlkoholCalculator {
    private String name;

    private float volume;

    public static final float THE_Density_RATTO_OF_ETHYL_ALVOHOL = 0.79F;

   public AlkoholCalculator(String name, float volume){
       this.name = name;
       this.volume = volume;
   }
   public float calculatePerMil(int quantity, int weight,boolean male){
       // Wzór Erika Widmarka
       float k = male ? 0.7f : 0.6f;
       float w = weight;
       float a = AlkoholCalculator.THE_Density_RATTO_OF_ETHYL_ALVOHOL*volume*quantity;
       return a/(k*w);
   }
}

