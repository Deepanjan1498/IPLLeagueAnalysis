package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;

public class SortingBowlerAverageComparator implements Comparator<IplBowler> {
	@Override
	public int compare(IplBowler bowler1,IplBowler bowler2) {
		 if (bowler1.average==0.0) {
             return 1;
         }
         if (bowler2.average==0.0) {
             return -1;
         }
         return (int) (bowler1.average-bowler2.average);
	}
	
}
