package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingField {
	
	
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	public enum Field{
		AVERAGE
	}
	public static Comparator getComparatorField(Field field) 
	{
	      Comparator<IplBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      Comparator<IplBatsman> avgComparator = sortFieldComparator.get(field);
	        return avgComparator;
	}
}
