package ranking;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product>{

	@Override
	public int compare(Product arg0, Product arg1) {
		return -Integer.compare(arg0.getRating(), arg1.getRating());
	}

}
