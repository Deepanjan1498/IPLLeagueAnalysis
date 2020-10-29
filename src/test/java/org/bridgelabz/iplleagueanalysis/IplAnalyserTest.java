package org.bridgelabz.iplleagueanalysis;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class IplAnalyserTest {
	
	public static final String BATTING_CSV_FILE = "D:\\DEEPANJAN\\PROJECTS\\IPLLeagueAnalysis\\src\\WP  DP  Data_01 IPL2019FactsheetMostRuns.csv";
	public static final String BOWLING_CSV_FILE = "D:\\DEEPANJAN\\PROJECTS\\IPLLeagueAnalysis\\src\\WP  DP  Data_02 IPL2019FactsheetMostWkts.csv";
	
	@Test
	public void givenIPL2019_BattingCSVFile_ShouldReturnCorrectRecords() throws IplAnalyserException {
        IplAnalyser iplAnalyser = new IplAnalyser();
        int battingAverage = iplAnalyser.loadCricketIPL2019BatsmanData(BATTING_CSV_FILE);
        Assert.assertEquals(101, battingAverage);
    }
	@Test
    public void givenIPL2019Data_WhenSortedForHighestBattingAverage_ShouldReturnResult() throws IplAnalyserException {
        IplAnalyser iplAnalyser = new IplAnalyser();
        iplAnalyser.loadCricketIPL2019BatsmanData( BATTING_CSV_FILE);
        String iplPlayersRecords = iplAnalyser.getSortedIPLBattingRecords(SortingField.Field.AVERAGE);
        IplBatsman[] mostAverageRuns = new Gson().fromJson(iplPlayersRecords, IplBatsman[].class);
        Assert.assertEquals("MS Dhoni", mostAverageRuns[mostAverageRuns.length-1].player);
    }
	@Test
	 public void givenIPL2019Data_WhenSortedForHighestBattingStrikeRate_ShouldReturnResult() throws IplAnalyserException {
	        IplAnalyser iplAnalyser = new IplAnalyser();
	        iplAnalyser.loadCricketIPL2019BatsmanData( BATTING_CSV_FILE);
	        String iplPlayersRecords = iplAnalyser.getSortedIPLBattingRecords(SortingField.Field.STRIKE_RATE);
	        IplBatsman[] highestStrikeRate = new Gson().fromJson(iplPlayersRecords, IplBatsman[].class);
	        Assert.assertEquals("Ishant Sharma",highestStrikeRate[highestStrikeRate.length-1].player);
	}
	@Test
	 public void givenIPL2019Data_WhenSortedForHighest4sand6s_ShouldReturnResult() throws IplAnalyserException {
	        IplAnalyser iplAnalyser = new IplAnalyser();
	        iplAnalyser.loadCricketIPL2019BatsmanData( BATTING_CSV_FILE);
	        String iplPlayersRecords = iplAnalyser.getSortedIPLBattingRecords(SortingField.Field.FOUR_AND_SIX);
	        IplBatsman[] highestFourAndSix = new Gson().fromJson(iplPlayersRecords, IplBatsman[].class);
	        Assert.assertEquals("Andre Russell",highestFourAndSix[highestFourAndSix.length-1].player);
	}
    
	@Test
	 public void givenIPL2019Data_WhenSortingForHighest4sand6sAndStrikeRates_ShouldReturnResult() throws IplAnalyserException {
	        IplAnalyser iplAnalyser = new IplAnalyser();
	        iplAnalyser.loadCricketIPL2019BatsmanData( BATTING_CSV_FILE);
	        String iplPlayersRecords = iplAnalyser.getSortedIPLBattingRecords(SortingField.Field.STRIKE_RATE_AND_FOUR_AND_SIX);
	        IplBatsman[] highestStrikeRateAndFourAndSix = new Gson().fromJson(iplPlayersRecords, IplBatsman[].class);
	        Assert.assertEquals("Andre Russell",highestStrikeRateAndFourAndSix[highestStrikeRateAndFourAndSix.length-1].player);
	}
	@Test
	 public void givenIPL2019Data_WhenSortingForHighestAverageAndStrikeRates_ShouldReturnResult() throws IplAnalyserException {
	        IplAnalyser iplAnalyser = new IplAnalyser();
	        iplAnalyser.loadCricketIPL2019BatsmanData( BATTING_CSV_FILE);
	        String iplPlayersRecords = iplAnalyser.getSortedIPLBattingRecords(SortingField.Field.STRIKE_RATE_AND_AVERAGE);
	        IplBatsman[] highestStrikeRateAndAverage = new Gson().fromJson(iplPlayersRecords, IplBatsman[].class);
	        Assert.assertEquals("MS Dhoni",highestStrikeRateAndAverage[highestStrikeRateAndAverage.length-1].player);
	}
	@Test
	 public void givenIPL2019Data_WhenSortingForMaximumRunsWithHighestAverage_ShouldReturnResult() throws IplAnalyserException {
	        IplAnalyser iplAnalyser = new IplAnalyser();
	        iplAnalyser.loadCricketIPL2019BatsmanData( BATTING_CSV_FILE);
	        String iplPlayersRecords = iplAnalyser.getSortedIPLBattingRecords(SortingField.Field.STRIKE_RATE_AND_AVERAGE);
	        IplBatsman[] maximumRunsAndBestAverage = new Gson().fromJson(iplPlayersRecords, IplBatsman[].class);
	        Assert.assertEquals("MS Dhoni",maximumRunsAndBestAverage[maximumRunsAndBestAverage.length-1].player);
	}
	@Test
    public void givenIPL2019Data_WhenSortedForHighestBowlingAverage_ShouldReturnResult() throws IplAnalyserException {
        IplAnalyser iplAnalyser = new IplAnalyser();
        iplAnalyser.loadCricketIPL2019BowlerData( BOWLING_CSV_FILE);
        String iplPlayersRecords = iplAnalyser.getSortedIPLBowlingRecords(SortingField.Field.BOWLING_AVERAGE);
        IplBowler[] highestAverageBowler = new Gson().fromJson(iplPlayersRecords, IplBowler[].class);
        Assert.assertEquals("Krishnappa Gowtham", highestAverageBowler[highestAverageBowler.length-1].player);
    }
}


