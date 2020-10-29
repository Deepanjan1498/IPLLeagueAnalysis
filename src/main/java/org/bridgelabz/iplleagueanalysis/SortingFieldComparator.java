package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;

public class SortingFieldComparator implements Comparator<IplBatsman>{

	@Override
	public int compare(IplBatsman batsman1,IplBatsman batsman2) {
		// TODO Auto-generated method stub
		 return (((batsman1.sixes * 6) + (batsman1.fours * 4)) - ((batsman2.sixes * 6) + (batsman2.fours * 4)));
	}

}
