package com.ep.ysilitelnieKaskadi.screen.result;

public class CalculatorOB extends OB{
    private Given given;
    private Transistor transistor;
    
    public CalculatorOB(Given _given, Transistor _transistor){
        given = _given;
        transistor = _transistor;
    }
    
    private void calcUa(){
        Ua = given.getUka0() * 0.2;
    }
    
    private void calcUip(){
        Uip = 2 * given.getUka0() + Ua;
    }
    
    private void calcRk(){
        Rk = (Uip - given.getUka0() - Ua)/given.getIk();
    }
    
    private void calcRa(){
        Ra = Ua/given.getIk();
    }
    
    private void calcIb(){
        Ib = given.getIk()/transistor.getH21a();
    }
    
    private void calcUb(){
        Ub = 0.6 + Ua;
    }
    
    private void calcId(){
        Id = Ib * 10;
    }
    
    private void calcR1(){
        R1 = (Uip - Ub)/(Id + Ib);
    }
    
    private void calcR2(){
        R2 = Ub/Id;
    }
    
    private void calcC(){
        double h11b = transistor.getH11a() / (1 + transistor.getH21a());
        double h21b = - transistor.getH21a() / (1 + transistor.getH21a());
        double rvh = h11b;
        double Rvh = (Ra * rvh)/(Ra + rvh);
        double Rb = (R1 * R2)/(R1 + R2);        
        double Rvih = Rk;
    }
}
