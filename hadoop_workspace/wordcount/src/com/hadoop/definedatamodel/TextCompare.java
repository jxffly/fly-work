package com.hadoop.definedatamodel;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TextCompare extends WritableComparator{
	public TextCompare(){
		super(DefineModel.class,true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		DefineModel m1=(DefineModel)a;
		DefineModel m2=(DefineModel)b;
		return m1.getTextKey().compareTo(m2.getTextKey());
		
	}
	
}
