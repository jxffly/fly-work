package com.hadoop.defineworldcount;

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
	}

	@Override
	public void write(DataOutput dataoutput) throws IOException {
		// TODO Auto-generated method stub
		dataoutput.writeUTF(TextKey);
		dataoutput.writeInt(IntValue);
		
	}

	@Override
	public int compareTo(DefineModel o) {
		// TODO Auto-generated method stub
		LOG.info(new StringBuilder("调用比较函数"));
		return o.getIntValue()-this.getIntValue();
		
	}

}
