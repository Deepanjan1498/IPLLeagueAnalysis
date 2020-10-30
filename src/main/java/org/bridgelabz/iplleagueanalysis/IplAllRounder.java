package org.bridgelabz.iplleagueanalysis;

public class IplAllRounder {
	public String name;
	public int battingRuns;
	public double battingAverage;
	public double bowlingAverage;
	public int wickets;
	public IplAllRounder(String name, int battingRuns, double battingAverage, double bowlingAverage, int wickets) {
		super();
		this.name = name;
		this.battingRuns = battingRuns;
		this.battingAverage = battingAverage;
		this.bowlingAverage = bowlingAverage;
		this.wickets = wickets;
	}
	@Override
	public String toString() {
		return "IplAllRounder [name=" + name + ", battingRuns=" + battingRuns + ", battingAverage=" + battingAverage
				+ ", bowlingAverage=" + bowlingAverage + ", wickets=" + wickets + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBattingRuns() {
		return battingRuns;
	}
	public void setBattingRuns(int battingRuns) {
		this.battingRuns = battingRuns;
	}
	public double getbattingAverage() {
		return battingAverage;
	}
	public void setbattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public double getbowlingAverage() {
		return bowlingAverage;
	}
	public void setbowlingAverage(double bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

}
