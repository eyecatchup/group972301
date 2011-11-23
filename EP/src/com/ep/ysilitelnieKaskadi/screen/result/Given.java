package com.ep.ysilitelnieKaskadi.screen.result;

public class Given {
    private String type;
    private double Uka0;
    private double Ik;
    private double Eg;
    private double Rg;
    private double Rn;
    private double Cn;
    
    public Given(String _type,
            double _Uka0,
            double _Ik,
            double _Eg,
            double _Rg,
            double _Rn,
            double _Cn){
        type = _type;
        Uka0 = _Uka0;
        Ik = _Ik;
        Eg = _Eg;
        Rg = _Rg;
        Rn = _Rn;
        Cn = _Cn;
    }
    
    public String getType(){
        return type;
    }
    
    public double getUka0(){
        return Uka0;
    }
    
    public double getIk(){
        return Ik;
    }
    
    public double getEg(){
        return Eg;
    }
    
    public double getRg(){
        return Rg;
    }
    
    public double getRn(){
        return Rn;
    }
    
    public double getCn(){
        return Cn;
    }
}