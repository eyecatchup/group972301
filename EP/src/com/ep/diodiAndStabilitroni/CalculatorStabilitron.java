package com.ep.diodiAndStabilitroni;

public class CalculatorStabilitron {
	private StabilizatorNapr mStab = new StabilizatorNapr();
	private Given mGiven;
	private Stabilitron stabilitron;

	public CalculatorStabilitron(Given given, Stabilitron stabilitron) {
		mGiven = given;
		this.stabilitron = stabilitron;

		mStab.setCoefStabliz(given.getTok());
		calcAmplitPuls();
		calcSoprGosResistora();
		calcRabTokStabilitrona();
		calcTokGosResistora(); 
		calcSoprNagruzki(); 
		calcPostNaprNaWhodeStabilt();
		calcTemperUhod();

	}

	private void calcTemperUhod() {
		mStab.setTemperUhod(stabilitron.getTemperCoef() * stabilitron.getNapr()
				* 50 / 100);

	}

	private void calcPostNaprNaWhodeStabilt() {
		mStab.setPostNagrNaWhodeStabilizatora(mStab.getTokGosResistora()
				* mStab.getSoprotGosResis() + mGiven.getNaprWihodnoe());

	}

	private void calcSoprNagruzki() {
		mStab.setSoprNagr(mGiven.getNaprWihodnoe() / mGiven.getTok());

	}

	private void calcTokGosResistora() {
		mStab.setTokGosResistora(mStab.getRabTokStabilitrona()
				+ mGiven.getTok());

	}

	private void calcRabTokStabilitrona() {
		mStab.setRabTokStabilitrona((stabilitron.getTokMax() - stabilitron
				.getTokMin() - mGiven.getTok()) / 2);

	}

	private void calcSoprGosResistora() {
		mStab.setSoprotGosResis(stabilitron.getSopr() * mStab.getCoefStabiliz());

	}

	private void calcAmplitPuls() {
		mStab.setAmplitudePuls(mStab.getCoefStabiliz()
				* mGiven.getDeltaNaprWihodnoe());

	}

	public StabilizatorNapr getStabilitron() {
		return mStab;
	}
	
	public Object[][] getData(){
		Object[][] mData = new Object[1][11];
		mData[0][0] = "Hello";
		mData[0][1] = mStab.getPostNagrNaWhodeStabilizatora();
		mData[0][2] = mStab.getAmplitudePuls();
		mData[0][3] = mGiven.getNaprWihodnoe();
		mData[0][4] = mStab.getTemperUhod();
		mData[0][5] = mGiven.getDeltaNaprWihodnoe();
		mData[0][6] = mStab.getRabTokStabilitrona();
		mData[0][7] = mStab.getTokGosResistora();
		mData[0][8] = mStab.getCoefStabiliz();
		mData[0][9] = mStab.getSoprNagruzki();
		mData[0][10] = mStab.getSoprotGosResis();
		
		return mData;
	}

}
