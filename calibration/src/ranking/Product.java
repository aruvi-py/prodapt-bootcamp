package ranking;

public class Product {
	
	public static final String COMMA_SPACE = ", ";
	
	int rating;
	String name;
	int rank;
	
	public Product() {
		
	}
	
	public Product (String fileLine, String sep) {
		String[] components = fileLine.split(sep);
		rating = Integer.valueOf(components[1]);
		name = components[0];
		rank = -1;
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
	
	public Product setRank (int newRank){
		rank = newRank;
		Product temp = new Product();
		temp.name = name;
		temp.rank = rank;
		temp.rating = rating;
		return temp;
	}
	
	@Override
	public String toString() {
		return rank + COMMA_SPACE + name + COMMA_SPACE + rating;
	}

}
