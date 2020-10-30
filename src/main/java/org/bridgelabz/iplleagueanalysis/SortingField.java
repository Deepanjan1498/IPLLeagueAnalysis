package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingField {
	
	
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	static Map<Field, Comparator> sortBowlingFieldComparator = new HashMap<>();
	static Map<Field, Comparator> sortAllRounderFieldComparator = new HashMap<>();
	
	public enum Field{
		MAXIMUM_RUNS,AVERAGE,STRIKE_RATE, FOUR_AND_SIX,STRIKE_RATE_AND_FOUR_AND_SIX,
		STRIKE_RATE_AND_AVERAGE,MAXIMUM_RUNS_WITH_BEST_AVERAGE,BOWLING_AVERAGE,
		BOWLING_STRIKE_RATE,BOWLING_ECONOMY,BEST_STRIKE_RATE_WITH_5W_AND_4W,
		BEST_STRIKE_RATE_WITH_AVERAGE,MAXIMUM_WICKETS_WITH_BEST_BOWLING_AVERAGE,
		BEST_BATTING_AND_BOWLING_AVERAGE,BEST_ALL_ROUNDER,MAXIMUM_HUNDREDS_AND_BEST_AVERAGE,
		ZERO_HUNDRED_AND_FIFTY_WITH_BEST_AVERAGE
	}
	public static Comparator getComparatorField(Field field) 
	{
		  Comparator<IplBatsman> iplMaximumRunsComparator = Comparator.comparing(census->census.runs);
		  Comparator<IplBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      Comparator<IplBatsman> iplHundredComparator = Comparator.comparing(census -> census.hundreds);
	      Comparator<IplBatsman> iplStrikeRateComparator = Comparator.comparing(census->census.strikeRate);
	      sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator);
          sortFieldComparator.put(Field.FOUR_AND_SIX,new SortingBatsmanFieldComparator());	     
	      sortFieldComparator.put(Field.STRIKE_RATE_AND_FOUR_AND_SIX, new SortingBatsmanFieldComparator().thenComparing(iplStrikeRateComparator));
          sortFieldComparator.put(Field.STRIKE_RATE_AND_AVERAGE, iplAverageComparator.thenComparing(iplStrikeRateComparator));
          sortFieldComparator.put(Field.MAXIMUM_RUNS_WITH_BEST_AVERAGE,(iplMaximumRunsComparator).thenComparing(iplAverageComparator));
          sortFieldComparator.put(Field.MAXIMUM_HUNDREDS_AND_BEST_AVERAGE,(iplHundredComparator.reversed()).thenComparing(iplAverageComparator.reversed()));
          sortFieldComparator.put(Field.ZERO_HUNDRED_AND_FIFTY_WITH_BEST_AVERAGE,iplAverageComparator.reversed());
          Comparator<IplBatsman> FieldComparator = sortFieldComparator.get(field);
	        return FieldComparator;
	}
	public static Comparator getBowlingComparatorField(Field field) {
		// TODO Auto-generated method stub
		sortBowlingFieldComparator.put(Field.BOWLING_AVERAGE,new SortingBowlerAverageComparator());
		sortBowlingFieldComparator.put(Field.BOWLING_STRIKE_RATE,new SortingBowlerStrikeRateComparator());
		Comparator<IplBowler> wicketComparator=Comparator.comparing(census->census.wickets);
		Comparator<IplBowler> economyComparator=Comparator.comparing(census->census.economy);
	    sortBowlingFieldComparator.put(Field.BOWLING_ECONOMY,economyComparator);
	    Comparator<IplBowler> fourAndFiveWicket=Comparator.comparing(census->(census.fourWicket*4+census.fiveWicket*5));
	    Comparator<IplBowler> bestStrikeRateWith4wAnd5w=fourAndFiveWicket.reversed().thenComparing(new SortingBowlerStrikeRateComparator());
	    sortBowlingFieldComparator.put(Field.BEST_STRIKE_RATE_WITH_5W_AND_4W,bestStrikeRateWith4wAnd5w);
	    Comparator<IplBowler> bestAverageWithStrikeRate=new SortingBowlerAverageComparator().thenComparing(new SortingBowlerStrikeRateComparator());
	    sortBowlingFieldComparator.put(Field.BEST_STRIKE_RATE_WITH_AVERAGE,bestAverageWithStrikeRate);
	    Comparator<IplBowler> maximumWicketsWithBestAverage=wicketComparator.reversed().thenComparing(new SortingBowlerAverageComparator());
	    sortBowlingFieldComparator.put(Field.MAXIMUM_WICKETS_WITH_BEST_BOWLING_AVERAGE,maximumWicketsWithBestAverage);
	    Comparator<IplBowler> bowlerFieldComparator = sortBowlingFieldComparator.get(field);
		return bowlerFieldComparator;
	}
	public static Comparator getAllRounderComparatorField(Field field) {
	
		Comparator<IplAllRounder> battingAverageComparator=Comparator.comparing(census->census.battingAverage);
	    Comparator<IplAllRounder> bowlingAverageComparator=Comparator.comparing(census->census.bowlingAverage);;
	    Comparator<IplAllRounder> battingRunsComparator=Comparator.comparing(census->census.battingRuns);
	    Comparator<IplAllRounder> wicketsComparator=Comparator.comparing(census->census.wickets);
	    Comparator<IplAllRounder> bothAverageComparator=battingAverageComparator.reversed().thenComparing(bowlingAverageComparator);
	    Comparator<IplAllRounder> bestAllRounderComparator=battingRunsComparator.reversed().thenComparing(wicketsComparator.reversed());
	    sortAllRounderFieldComparator.put(Field.BEST_BATTING_AND_BOWLING_AVERAGE,bothAverageComparator);
	    sortAllRounderFieldComparator.put(Field.BEST_ALL_ROUNDER,bestAllRounderComparator);
	    Comparator<IplAllRounder> allRounderFieldComparator = sortAllRounderFieldComparator.get(field);
        return allRounderFieldComparator; 
	}
	
}
