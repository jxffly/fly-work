package com.hadoop.join;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TextCompare extends WritableComparator{
	private static final Log LOG = LogFactory.getLog(TextCompare.class);
	public TextCompare(){
		super(DefineModel.class,true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		LOG.info(new StringBuilder("调用分组函数！！"));
		DefineModel m1=(DefineModel)a;
		DefineModel m2=(DefineModel)b;
		return m1.getTextKey().compareTo(m2.getTextKey());
		
	}
	
}
