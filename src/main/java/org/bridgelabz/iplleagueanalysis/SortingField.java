package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingField {
	
	
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	public enum Field{
		AVERAGE,STRIKE_RATE, FOUR_AND_SIX,STRIKE_RATE_AND_FOUR_AND_SIX,STRIKE_RATE_AND_AVERAGE
	}
	public static Comparator getComparatorField(Field field) 
	{
	      Comparator<IplBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      Comparator<IplBatsman> iplStrikeRateComparator = Comparator.comparing(census->census.strikeRate);
	      sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator);
          sortFieldComparator.put(Field.FOUR_AND_SIX,new SortingFieldComparator());	     
	      sortFieldComparator.put(Field.STRIKE_RATE_AND_FOUR_AND_SIX, new SortingFieldComparator().thenComparing(iplStrikeRateComparator));
          sortFieldComparator.put(Field.STRIKE_RATE_AND_AVERAGE, iplAverageComparator.thenComparing(iplStrikeRateComparator));
	      Comparator<IplBatsman> FieldComparator = sortFieldComparator.get(field);
	        return FieldComparator;
	}
}
