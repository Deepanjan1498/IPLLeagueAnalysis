package org.bridgelabz.iplleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IplBowler 
{
		public IplBowler() {
		}
	 	@CsvBindByName(column = "POS")
	    public int position;

	    @CsvBindByName(column = "PLAYER")
	    public String player;

	    @CsvBindByName(column = "Mat")
	    public int matches;

	    @CsvBindByName(column = "Inns")
	    public int inning;

	    @CsvBindByName(column = "Ov")
	    public double over;

	    @CsvBindByName(column = "Runs")
	    public int runs;

	    @CsvBindByName(column = "Wkts")
	    public int wickets;

	    @CsvBindByName(column = "BBI")
	    public int bestBallingInning;

	    @CsvBindByName(column = "Avg")
	    public double average;

	    @CsvBindByName(column = "Econ")
	    public double economy;

	    @CsvBindByName(column = "SR")
	    public double strikeRate;

	    @CsvBindByName(column = "4w")
	    public int fourWicket;

	    @CsvBindByName(column = "5w")
	    public int fiveWicket;

		@Override
		public String toString() {
			return "IplBowler [position=" + position + ", player=" + player + ", matches=" + matches + ", inning="
					+ inning + ", over=" + over + ", runs=" + runs + ", wickets=" + wickets + ", bestBallingInning="
					+ bestBallingInning + ", average=" + average + ", economy=" + economy + ", strikeRate=" + strikeRate
					+ ", fourWicket=" + fourWicket + ", fiveWicket=" + fiveWicket + "]";
		}

}