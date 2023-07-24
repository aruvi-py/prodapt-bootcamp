package ranking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RankingOld {
	
	private static final String SEPARATOR = ", ";
	
	public static List<String> readRatingsFromFile(String filename) throws IOException {
		return Files.lines(Path.of(filename)).toList();
	}
	
	public static int extractRating(String fileLine) {
		return Integer.valueOf(fileLine.split(SEPARATOR)[1]);
	}
	
	public static int extractRatingFromRanked(String productDesc) {
		return Integer.valueOf(productDesc.split(SEPARATOR)[2]);
	}
	
	public static int extractRank(String productDesc) {
		return Integer.valueOf(productDesc.split(SEPARATOR)[0]);
	}
	
	public static String modifyRank(String productDesc, int newRank) {
		String[] splits = productDesc.split(SEPARATOR);
		return newRank + SEPARATOR + splits[1] + SEPARATOR + splits[2];
	}
	
	public static List<String> sortRatings(List<String> ratings) {
		return ratings.stream()
				.sorted(new RatingComparatorOld())
				.collect(Collectors.toList());
	}
	
	public static List<String> rankRatings(List<String> ratings) {
		List<String> sortedRatings = sortRatings(ratings);
		List<String> rankedRatings = IntStream.range(0, sortedRatings.size())
										.mapToObj(index -> (index + 1) + SEPARATOR + sortedRatings.get(index))
										.collect(Collectors.toList());
		for (int i = 1; i < rankedRatings.size(); i++) {
			int currentRating = extractRatingFromRanked(rankedRatings.get(i));
			int prevRating = extractRatingFromRanked(rankedRatings.get(i - 1));
			if (currentRating == prevRating)
				rankedRatings.set(i, modifyRank(rankedRatings.get(i), extractRank(rankedRatings.get(i - 1))));
		}
		return rankedRatings;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(rankRatings(readRatingsFromFile("ratings.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
