package numerals;

public interface Value {
	
	public Value plus(Value other);
	
	public int intValue();
	
	public String romanValue();
	
	public boolean equals(Object obj);
	
	public int hashcode();
	
	public String toString();

}
