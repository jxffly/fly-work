package com.hadoop.join;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.WritableComparable;

public class DefineModel implements WritableComparable<DefineModel>{
	private static final Log LOG = LogFactory.getLog(DefineModel.class);
	private String TextKey;
	private int IntValue;
	private String secondValue;
	public String getTextKey() {
		return TextKey;
	}

	public void setTextKey(String textKey) {
		TextKey = textKey;
	}

	public int getIntValue() {
		return IntValue;
	}

	public void setIntValue(int intValue) {
		IntValue = intValue;
	}

	@Override
	public void readFields(DataInput datainput) throws IOException {
		// TODO Auto-generated method stub
		TextKey= datainput.readUTF();
		IntValue=datainput.readInt();
		secondValue=datainput.readUTF();
	}

	@Override
	public void write(DataOutput dataoutput) throws IOException {
		// TODO Auto-generated method stub
		dataoutput.writeUTF(TextKey);
		dataoutput.writeInt(IntValue);
		dataoutput.writeUTF(secondValue);
		
	}

	@Override
	public int compareTo(DefineModel o) {
		// TODO Auto-generated method stub
		LOG.info(new StringBuilder("调用比较函数"));
		if(!this.getTextKey().equals(o.getTextKey()))
		{
			return this.getTextKey().compareTo(o.getTextKey());
		}else if(this.getIntValue()!=o.getIntValue()){
			return this.getIntValue()-o.getIntValue();
		}else{
			return this.getSecondValue().compareTo(o.getSecondValue());
		}
		
		
	}

	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}

	public String getSecondValue() {
		return secondValue;
	}

}
