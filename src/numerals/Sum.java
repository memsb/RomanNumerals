package numerals;

public class Sum implements Value {
	
	private Value augend;
	private Value addend;
	
	public Sum(Value addend, Value augend){
		this.addend = addend;
		this.augend = augend;
	}
	
	public int intValue(){
		return addend.intValue() + augend.intValue();
	}	
	
	public String romanValue() {		
		return new Decimal(intValue()).romanValue();
	}

	public Value plus(Value other) {
		return new Sum(this, other);
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
		return "Sum " + String.valueOf(intValue());
	}

}
