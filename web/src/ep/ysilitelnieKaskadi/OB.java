package ep.ysilitelnieKaskadi;

public class OB {
    protected double Ua = 0;//show
    protected double Uip = 0;//show
    protected double Rk = 0;//show
    protected double Ra = 0;//show
    protected double Ib = 0;//show
    protected double Ub = 0;//show
    protected double Id = 0;//show
    protected double R1 = 0;//show
    protected double R2 = 0;//show
    
    protected double h21b = 0;
    protected double h21B = 0;
    protected double rvh = 0;
    protected double Rvh = 0;//show
    protected double Rb = 0;//show
    protected double Rvih = 0;//show
    protected double C1 = 0;//show
    protected double C2 = 0;//show
    protected double Ca = 0;//show
    protected double Cb = 0;//show
    
    protected double Ki = 0;//show
    protected double Ku = 0;//show
    
    protected double fn1 = 0;//show
    protected double fn2 = 0;//show
    protected double fn3 = 0;//show
    protected double fv1 = 0;//show
    protected double fv2 = 0;//show
    protected double fv3 = 0;//show
    
    protected double MvN = 0;//show
    protected double MnN = 0;//show
    
    public double getUa(){
        return Ua;
    }
    
    public double getUip(){
        return Uip;
    }
    
    public double getRk(){
        return Rk;
    }
    
    public double getRa(){
        return Ra;
    }
    
    public double getIb(){
        return Ib;
    }
    
    public double getUb(){
        return Ub;
    }
    
    public double getId(){
        return Id;
    }
    
    public double getR1(){
        return R1;
    }
    
    public double getR2(){
        return R2;
    }
    
    public double getC1(){
        return C1;
    }
    
    public double getC2(){
        return C2;
    }   
    
    public double getCa(){
        return Ca;
    }
    
    public double getCb(){
        return Cb;
    }
    
    public double getRvh(){
        return Rvh;
    }
    
    public double getRb(){
        return Rb;
    }
    
    public double getRvih(){
        return Rvih;
    }
    
    public double getKi(){
        return Ki;
    }
    
    public double getKu(){
        return Ku;
    }
    
    public double getFn1(){
        return fn1;
    }
    
    public double getFn2(){
        return fn2;
    }
    
    public double getFn3(){
        return fn3;
    }
    
    public double getFv1(){
        return fv1;
    }
    
    public double getFv2(){
        return fv2;
    }
    
    public double getFv3(){
        return fv3;
    }
    
    public double getMvN(){
        return MvN;
    }
    
    public double getMnN(){
        return MnN;
    }
    
    public void show(){
        System.out.printf("Ua: %f\n",getUa());
        System.out.printf("Uio: %f\n",getUip());
        System.out.printf("Rk: %f\n",getRk());
        System.out.printf("Ra: %f\n",getRa());
        System.out.printf("Ib: %f\n",getIb());
        System.out.printf("Ub: %f\n",getUb());
        System.out.printf("Id: %f\n",getId());
        System.out.printf("R1: %f\n",getR1());
        System.out.printf("R2: %f\n",getR2());
        System.out.printf("C1: %f\n",getC1());
        System.out.printf("C2: %f\n",getC2());
        System.out.printf("Ca: %f\n",getCa());
        System.out.printf("Cb: %f\n",getCb());
        System.out.printf("Rvh: %f\n",getRvh());
        System.out.printf("Rb: %f\n",getRb());
        System.out.printf("Rvih: %f\n",getRvih());
        System.out.printf("Ki: %f\n",getKi());
        System.out.printf("Ku: %f\n",getKu());
        System.out.printf("Fn1: %f\n",getFn1());
        System.out.printf("Fn2: %f\n",getFn2());
        System.out.printf("Fn3: %f\n",getFn3());
        System.out.printf("Fv1: %f\n",getFv1());
        System.out.printf("Fv2: %f\n",getFv2());
        System.out.printf("Fv3: %f\n",getFv3());
        System.out.printf("MvN: %f\n",getMvN());
        System.out.printf("MnN: %f\n",getMnN());
        System.out.printf("h21b: %f\n",h21b);
        System.out.printf("h21B: %f\n",h21B);
    }
}