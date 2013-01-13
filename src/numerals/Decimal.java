package numerals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;

public class Decimal implements Value {
	
	private int value;
	private Hashtable<Integer, String> pairs = new Hashtable<Integer, String>();
	
	public Decimal(int value){
		this.value = value;
		
		pairs.put(1, "I");
		pairs.put(4, "IV");
		pairs.put(5, "V");
		pairs.put(9, "IX");
		pairs.put(10, "X");
		pairs.put(40, "XL");
		pairs.put(50, "L");
		pairs.put(90, "XC");
		pairs.put(100, "C");
		pairs.put(400, "CD");
		pairs.put(490, "XD");
		pairs.put(500, "D");
		pairs.put(900, "CM");
		pairs.put(990, "XM");
		pairs.put(999, "IM");
		pairs.put(1000, "M");
	}
	
	public int intValue(){
		return value;
	}
	
	public String romanValue() {		
		int remaining = intValue();
		StringBuffer buf = new StringBuffer();
		while(remaining > 0){
			Iterator<Integer> iter = getValuesIterator();
			while(iter.hasNext()){
				int val = iter.next();
				if(remaining / val >= 1){					
					remaining -= val;
					String numeral = pairs.get(val);
					buf.append(numeral);
					break;
				}
			}
		}
		return buf.toString();
	}
	
	protected Iterator<Integer> getValuesIterator(){
		ArrayList<Integer> values =  new ArrayList<Integer>(pairs.keySet());
		Collections.sort(values);
		Collections.reverse(values);
		return values.iterator();
	}
	
	public Value plus(Value other) {
		return new Sum( this, other );
	}
	
	public boolean equals(Object obj){
		Value other = (Value) obj;
		return other.intValue() == intValue();
	}
	
	public int hashcode(){
		return value;
	}
	
	public String toString(){
		return "Decimal " + String.valueOf(intValue());
	}
}
