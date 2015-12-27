package org.hadoop.temperature;

public class Temperature {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isValid(){
		try{
				Integer.parseInt(value.substring(5, value.length()));
				return true;
		}catch(Exception e){
				return false;
		}
	}
	public String getYear(){
		return value.substring(0, 4);
	}
	public int getTemp(){
		int airTemperature=9999;
		if(value.charAt(4)=='+'){
			airTemperature=Integer.parseInt(value.substring(5, value.length()));
		}else {
			airTemperature=Integer.parseInt(value.substring(4, value.length()));
		}
		return airTemperature;
	}
}
