package ep.ysilitelnieKaskadi;

import entity.GivenOB;
import entity.OB_Transistor;

public class CalculatorOB extends OB{
    private GivenOB given;
    private OB_Transistor transistor;

    public CalculatorOB(GivenOB _given, OB_Transistor _transistor){
        given = _given;
        transistor = _transistor;
    }
    
    private double getH21A(){
  		return Math.sqrt(transistor.getH21min() * transistor.getH21max());
    }
    
    private double ll(double a, double b){
        return (a * b) / (a + b);
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
        Ib = given.getIk()/getH21A();
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
        h21b = - transistor.getH21a() / (1 + transistor.getH21a());
        h21B = - getH21A() / (1 + getH21A());
        rvh = h11b;
        Rvh = (Ra * rvh)/(Ra + rvh);
        Rb = (R1 * R2)/(R1 + R2);        
        Rvih = Rk;
        C1 = 10 / (2 * Math.PI * transistor.getFn() * (R2 + Rvh));
        C2 = 10 / (2 * Math.PI * transistor.getFn() * (Rvih + given.getRn()));
        Ca = 10 / (2 * Math.PI * transistor.getFn() * Ra);
        Cb = 10 / (2 * Math.PI * transistor.getFn() * Rb);
    }
    
    private void calcKi(){
        Ki = (h21b * Rk) / (Rk + given.getRn());
    }
    
    private void calcKu(){
        Ku = h21b * ll(Rk, given.getRn()) / ll(Ra, rvh);
    }
    
    private void calcF(){
        fn1 = 1 / (2 * Math.PI * C1* (given.getRg() + Rvh));
        fn2 = 1 / (2 * Math.PI * C2* (given.getRn() + Rvih));
        fn3 = 1 / (Cb * Rb);
        fv1 = 1 / (2 * Math.PI * ll(given.getRg(), Rvh) * (transistor.getCa() + (Math.abs(Ku) + 1) * transistor.getCk()));
        fv2 = 1 / (2 * Math.PI * ll(given.getRn(), Rvih) * given.getCn());
        fv3 = 100000000 / Math.sqrt(Math.pow(h21B / h21b, 2) - 1);
        
    }
    
    private void calcM(){
        double fvN = Math.min(fv1, Math.min(fv2, fv3));
        MvN = Math.sqrt(1 + (Math.pow(transistor.getFv()/ fvN, 2)));
        double fnN = Math.max(fn1, Math.max(fn2, fn3));
        MnN = Math.sqrt(1 + (Math.pow(fnN / transistor.getFn(), 2)));
    }
    
    public void calc(){
        calcUa();
        calcUip();
        calcRk();
        calcRa();
        calcIb();
        calcUb();
        calcId();
        calcR1();
        calcR2();
        calcC();
        calcKi();
        calcKu();
        calcF();
        calcM();
    }
}