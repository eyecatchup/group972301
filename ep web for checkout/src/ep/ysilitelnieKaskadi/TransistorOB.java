package ep.ysilitelnieKaskadi;

public class TransistorOB {
    private double h21min = 40;
    private double h21max = 100;
    private double h21A = 0;//calc
    private double h11a = 1333.3;//const
    private double h21a = 5;
    private double fn = 20;//const
    private double fv = 20000;//const
    private double Ck = 0.000000000005;
    private double Ca = 0.000000000005;
    
    public TransistorOB(double _h21min,
            double _h21max,
            double _h21a){
        h21min = _h21min;        
        h21max = _h21max;
        h21a = _h21a;
        h21A = Math.sqrt(h21min * h21max);
    }

    public TransistorOB() {
        h21A = Math.sqrt(h21min * h21max);
    }
    
    public double getH21min(){
        return h21min;
    }
    
    public double getH21max(){
        return h21max;
    }
    
    public double getH21a(){
        return h21a;
    }
    
    public double getH11a(){
        return h11a;
    }
    
    public double getH21A(){
        return h21A;
    }
    
    public double getFn(){
        return fn;
    }
    
    public double getFv(){
        return fv;
    }
    
    public double getCa(){
        return Ca;
    }
    
    public double getCk(){
        return Ck;
    }
    
    public Object[] getData(){
    	Object[] data = new Object[5];
    	data[0] = getH21min();
        data[1] = getH21max();
        data[2] = getH21a();
        data[3] = getCa();
        data[4] = getCk();
    	return data;
    }
}