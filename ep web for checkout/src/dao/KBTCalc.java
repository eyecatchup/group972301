package dao;

public class KBTCalc {
		// 	<Source data>
	 	private float Ikb0;
	    private float Uip;
	    private float Ucm;
	    private float Rn;
	    private float S;
	    private float Uvihm;
	    private float U0por;
	    private float U1por;
	    private float Cn;
	    private float h21emin;
	    private float h21emax;
	    private float Ubepor;
	    private float Ck;
	    private float Th21E;
	    // </Source data>
	    
	    KBTCalc(float Ikb0, float Uip, float Ucm, float Rn, float S, float Uvihm, float U0por,
	    		float U1por, float Cn, float h21emin, float h21emax, float Ubepor, float Ck, float Th21E)
	    {
	    	this.Ikb0 = Ikb0;
		    this.Uip = Uip;
		    this.Ucm = Ucm;
		    this.Rn = Rn;
		    this.S = S;
		    this.Uvihm = Uvihm;
		    this.U0por = U0por;
		    this.U1por = U1por;
		    this.Cn = Cn;
		    this.h21emin = h21emin;
		    this.h21emax = h21emax;
		    this.Ubepor = Ubepor;
		    this.Ck = Ck;
		    this.Th21E = Th21E;
	    }
	    // <Calculated data>
	    private float Rk;
	    private float UipEkv;
	    private float RkEkv;
	    private float U0vih;
	    private float Ikn;
	    private float Ibn;
	    private float Ibm;
	    private float h21e;
	    private float R1;
	    private float R2;
	    private float Tvkl;
	    private float TzadVikl;
	    private float Tcp;
	    private float Tvikl;
	    private float Tnpu;
	    // </Calculated data>
	    
	    public void doCalc()
	    {
	        Rk = (Uip - Uvihm) * Rn / (Uvihm + Ikb0 * Rn);
	        UipEkv = (Uip * Rn) / (Rk + Rn);
	        RkEkv = (Rk * Rn) / (Rk + Rn);

	        Ikn = (UipEkv - U0vih) / RkEkv;
	        h21e = (float) Math.sqrt(h21emin * h21emax);
	        Ibn = (UipEkv - U0vih) / (RkEkv * h21e);
	        Ibm = S * Ibn;
	        R1 = (U1por - U0por) / Ibm;
	        R2 = (Ubepor + Ucm) * R1 / (U0por - Ubepor);
	        
	        Tvkl = (float) ((1 / (2 * Math.PI * Th21E) + (Ck + Cn) * RkEkv) * Math.log((S / (S - 1))));
	        
	        float Ibobr = Ucm / R2;
	        TzadVikl = (float) (Th21E / 2 * Math.log((Ibm + Ibobr) / (Ibn + Ibobr)));
	        Tcp = (float) (Th21E * Math.log(1 + Ibn / Ibobr));
	        Tvikl = TzadVikl + Tcp;
	        Tnpu = (float) (2.3 * (Ck + Cn) * RkEkv);
	    }

		public float getIkb0() {
			return Ikb0;
		}

		public void setIkb0(float ikb0) {
			Ikb0 = ikb0;
		}

		public float getUip() {
			return Uip;
		}

		public void setUip(float uip) {
			Uip = uip;
		}

		public float getUcm() {
			return Ucm;
		}

		public void setUcm(float ucm) {
			Ucm = ucm;
		}

		public float getRn() {
			return Rn;
		}

		public void setRn(float rn) {
			Rn = rn;
		}

		public float getS() {
			return S;
		}

		public void setS(float s) {
			S = s;
		}

		public float getUvihm() {
			return Uvihm;
		}

		public void setUvihm(float uvihm) {
			Uvihm = uvihm;
		}

		public float getU0por() {
			return U0por;
		}

		public void setU0por(float u0por) {
			U0por = u0por;
		}

		public float getU1por() {
			return U1por;
		}

		public void setU1por(float u1por) {
			U1por = u1por;
		}

		public float getCn() {
			return Cn;
		}

		public void setCn(float cn) {
			Cn = cn;
		}

		public float getH21emin() {
			return h21emin;
		}

		public void setH21emin(float h21emin) {
			this.h21emin = h21emin;
		}

		public float getH21emax() {
			return h21emax;
		}

		public void setH21emax(float h21emax) {
			this.h21emax = h21emax;
		}

		public float getUbepor() {
			return Ubepor;
		}

		public void setUbepor(float ubepor) {
			Ubepor = ubepor;
		}

		public float getCk() {
			return Ck;
		}

		public void setCk(float ck) {
			Ck = ck;
		}

		public float getTh21E() {
			return Th21E;
		}

		public void setTh21E(float th21e) {
			Th21E = th21e;
		}

		public float getRk() {
			return Rk;
		}

		public void setRk(float rk) {
			Rk = rk;
		}

		public float getUipEkv() {
			return UipEkv;
		}

		public void setUipEkv(float uipEkv) {
			UipEkv = uipEkv;
		}

		public float getRkEkv() {
			return RkEkv;
		}

		public void setRkEkv(float rkEkv) {
			RkEkv = rkEkv;
		}

		public float getU0vih() {
			return U0vih;
		}

		public void setU0vih(float u0vih) {
			U0vih = u0vih;
		}

		public float getIkn() {
			return Ikn;
		}

		public void setIkn(float ikn) {
			Ikn = ikn;
		}

		public float getIbn() {
			return Ibn;
		}

		public void setIbn(float ibn) {
			Ibn = ibn;
		}

		public float getIbm() {
			return Ibm;
		}

		public void setIbm(float ibm) {
			Ibm = ibm;
		}

		public float getH21e() {
			return h21e;
		}

		public void setH21e(float h21e) {
			this.h21e = h21e;
		}

		public float getR1() {
			return R1;
		}

		public void setR1(float r1) {
			R1 = r1;
		}

		public float getR2() {
			return R2;
		}

		public void setR2(float r2) {
			R2 = r2;
		}

		public float getTvkl() {
			return Tvkl;
		}

		public void setTvkl(float tvkl) {
			Tvkl = tvkl;
		}

		public float getTzadVikl() {
			return TzadVikl;
		}

		public void setTzadVikl(float tzadVikl) {
			TzadVikl = tzadVikl;
		}

		public float getTcp() {
			return Tcp;
		}

		public void setTcp(float tcp) {
			Tcp = tcp;
		}

		public float getTvikl() {
			return Tvikl;
		}

		public void setTvikl(float tvikl) {
			Tvikl = tvikl;
		}

		public float getTnpu() {
			return Tnpu;
		}

		public void setTnpu(float tnpu) {
			Tnpu = tnpu;
		}   
}
