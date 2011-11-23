package com.ep.ysilitelnieKaskadi.screen.result;

public class Transistor {
    private double h21a = 63;
    private double h11a = 1333.3;
    private double h21af = 5;
    
    public Transistor(double _h21a,
            double _h11a,
            double _h21af){
        h21a = _h21a;        
        h21af = _h21af;
    }
    
    public double getH21a(){
        return h21a;
    }
    
    public double getH11a(){
        return h11a;
    }
    
    public double getH21af(){
        return h21af;
    }
}