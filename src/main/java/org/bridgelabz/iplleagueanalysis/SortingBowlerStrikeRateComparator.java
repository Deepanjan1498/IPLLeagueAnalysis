package org.bridgelabz.iplleagueanalysis;

import java.util.Comparator;

public class SortingBowlerStrikeRateComparator implements Comparator<IplBowler> {

	@Override
	public int compare(IplBowler bowler1,IplBowler bowler2) {
		// TODO Auto-generated method stub
		if (bowler1.strikeRate==0.0) {
		return 1;
	    }
		if (bowler2.strikeRate==0.0) {
            return -1;
        }
        return (int) (bowler1.strikeRate-bowler2.strikeRate);
	   }
}
