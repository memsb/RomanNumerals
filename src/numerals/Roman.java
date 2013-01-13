package numerals;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Roman implements Value {
	
	private String numerals;	
	private Hashtable<Character, Integer> values = new Hashtable<Character, Integer>();
	private List<Integer> decimals;	

	public Roman(String numerals){
		this.numerals = numerals.toUpperCase();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);
	}
	
	public int intValue(){
		decimals = new ArrayList<Integer>();
		for( int i = 0; i < numerals.length(); i++ ){
			char numeral = numerals.charAt(i);
			int decimal = getNumeralValue(numeral);
			negatePreceedingLowerDecimals(decimal);
			decimals.add(decimal);
		}		
		return sum();
	}

	public String romanValue() {
		return numerals;
	}
	
	public Value plus(Value other){
		return new Sum(this, other);
	}
	
	protected int getNumeralValue(char numeral){		
		if( values.containsKey(numeral) ){
			return values.get(numeral);
		}
		return 0;
	}
	
	protected void negatePreceedingLowerDecimals(int current){
		try{
			int lastPos = decimals.size() - 1;
			Integer last = decimals.get(lastPos);
			if( current > last.intValue() ){
				int negated = - last.intValue();
				replaceDecimal(lastPos, negated);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
	}
	
	protected void replaceDecimal(int pos, int newValue){
		decimals.remove(pos);
		decimals.add( newValue );
	}
	
	protected int sum(){
		int total = 0;
		for( int i = 0; i < decimals.size(); i++ ){
			total += decimals.get(i).intValue();
		}
		return total;
	}
	
	public boolean equals(Object obj){
		Value other = (Value) obj;
		return other.intValue() == intValue();
	}

	public int hashcode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString(){
		return "Roman " + String.valueOf(intValue());
	}
}
