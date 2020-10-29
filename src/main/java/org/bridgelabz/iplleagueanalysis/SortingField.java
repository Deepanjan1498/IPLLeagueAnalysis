package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingField {
	
	
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	public enum Field{
		MAXIMUM_RUNS,AVERAGE,STRIKE_RATE, FOUR_AND_SIX,STRIKE_RATE_AND_FOUR_AND_SIX,STRIKE_RATE_AND_AVERAGE,MAXIMUM_RUNS_WITH_BEST_AVERAGE
	}
	public static Comparator getComparatorField(Field field) 
	{
		Comparator<IplBatsman> iplMaximumRunsComparator = Comparator.comparing(census->census.runs);
		  Comparator<IplBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      Comparator<IplBatsman> iplStrikeRateComparator = Comparator.comparing(census->census.strikeRate);
	      sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator);
          sortFieldComparator.put(Field.FOUR_AND_SIX,new SortingFieldComparator());	     
	      sortFieldComparator.put(Field.STRIKE_RATE_AND_FOUR_AND_SIX, new SortingFieldComparator().thenComparing(iplStrikeRateComparator));
          sortFieldComparator.put(Field.STRIKE_RATE_AND_AVERAGE, iplAverageComparator.thenComparing(iplStrikeRateComparator));
          sortFieldComparator.put(Field.MAXIMUM_RUNS_WITH_BEST_AVERAGE,(iplMaximumRunsComparator).thenComparing(iplAverageComparator));
          Comparator<IplBatsman> FieldComparator = sortFieldComparator.get(field);
	        return FieldComparator;
	}
}
