package com.ep.ysilitelnieKaskadi;

public class Given {
    private String type;
    private double Uka0 = 6;
    private double Ik = 0.006;
    private double Eg = 0.005;
    private double Rg = 2000;
    private double Rn = 2000;
    private double Cn = 0.0000000002;
    
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
    
    public Given(){
        
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
