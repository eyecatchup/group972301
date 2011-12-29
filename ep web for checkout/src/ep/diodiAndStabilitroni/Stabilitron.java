package ep.diodiAndStabilitroni;

public class Stabilitron {
	private String type;
	private double napr;
	private double tokMax;
	private double tokMin;
	private double sopr;
	private double temperCoef;

	public Stabilitron(double napr, double tokMax, double tokMin,
			double sopr, double temperCoef) {
		this.napr = napr;
		this.tokMax = tokMax;
		this.tokMin = tokMin;
		this.sopr = sopr;
		this.temperCoef = temperCoef;

	}

	public double getNapr() {
		return napr;
	}

	public void setNapr(double napr) {
		this.napr = napr;
	}


	public double getTokMax() {
		return tokMax;
	}

	public void setTokMax(double tokMax) {
		this.tokMax = tokMax;
	}

	public double getTokMin() {
		return tokMin;
	}

	public void setTokMin(double tokMin) {
		this.tokMin = tokMin;
	}

	public double getSopr() {
		return sopr;
	}

	public void setSopr(double sopr) {
		this.sopr = sopr;
	}

	public double getTemperCoef() {
		return temperCoef;
	}

	public void setTemperCoef(double temperCoef) {
		this.temperCoef = temperCoef;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
