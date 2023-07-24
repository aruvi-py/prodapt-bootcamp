package ranking;

import java.util.Comparator;

public class RatingComparatorOld implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		int rating0 = RankingOld.extractRating(arg0);
		int rating1 = RankingOld.extractRating(arg1);
		
		return rating0 > rating1 ? -1 : rating0 == rating1 ? 0: 1;
		
	}
	

}
