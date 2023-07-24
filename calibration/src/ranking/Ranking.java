package ranking;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ranking {
	public static List<Product> sorted(List<Product> products) {
		return products.stream()
				.sorted((p1, p2) -> -Integer.compare(p1.getRating(), p2.getRating()))
				.collect(Collectors.toList());
		/*
		 * Same as writing
		 * return products.stream()
		 * 				.sorted(new ProductComparator())
		 * 				.collect(Collectors.toList());
		 */
	}
	
	public static List<Product> ranked(List<Product> products) {
		List<Product> sortedProducts = sorted(products);
		for (int i = 0; i < sortedProducts.size(); i++)
			sortedProducts.get(i).setRank(i + 1);
		for (int i = 1; i < sortedProducts.size(); i++) {
			if (sortedProducts.get(i).getRating() == sortedProducts.get(i-1).getRating())
				sortedProducts.get(i).setRank(sortedProducts.get(i-1).getRank());
		}
		return sortedProducts;
	}
	
	public static void main(String[] args) {
		Product product1 = new Product("Product1, 85", ", ");
		Product product2 = new Product("Product2, 50", ", ");
		Product product3 = new Product("Product3, 85", ", ");
		Product product4 = new Product("Product4, 23", ", ");
		Product[] prods = {product1, product2, product3, product4};
		List<Product> products = ranked(Arrays.asList(prods));
		products = products.stream().map(p -> p.setRank(-1)).collect(Collectors.toList());
		System.out.println(products);
	}
}
