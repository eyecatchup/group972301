package com.ep.diodiAndStabilitroni;

public class CalculatorStabilitron {
	private StabilizatorNapr mStab = new StabilizatorNapr();
	private Given mGiven;
	private Stabilitron stabilitron;

	public CalculatorStabilitron(Given given, Stabilitron stabilitron) {
		mGiven = given;
		this.stabilitron = stabilitron;

		mStab.setCoefStabliz(given.getTok());
		calcAmplitPuls();//+
		calcSoprGosResistora();//+
		calcRabTokStabilitrona();
		calcTokGosResistora(); // +
		calcSoprNagruzki(); //+
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

}
