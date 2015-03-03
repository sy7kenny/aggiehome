package smaGson;

public class MeasurementObj{
	private double pv=0;
	private double batCur=0;
	public MeasurementObj(float pv, float batCur){
		this.pv = pv;
		this.batCur = batCur;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv2) {
		this.pv = pv2;
	}
	public double getBatCur() {
		return batCur;
	}
	public void setBatCur(double batCur) {
		this.batCur = batCur;
	}
	
	
}