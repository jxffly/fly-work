package com.hadoop.join;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TextIntComparator extends WritableComparator {
	private static final Log LOG = LogFactory.getLog(TextIntComparator.class);
		public TextIntComparator(){
			super(DefineModel.class,true);
		}
 
		@Override
		public int compare(WritableComparable a, WritableComparable b) {
			LOG.info(new StringBuilder("调用组内排序函数"));
			DefineModel m1=(DefineModel)a;
			DefineModel m2=(DefineModel)b;
			if(!m1.getTextKey().equals(m2.getTextKey())){
				return m1.getTextKey().compareTo(m2.getTextKey());
			}
			else if(m1.getIntValue()!=m2.getIntValue()){
				return m1.getIntValue()-m2.getIntValue();
			}else {
				return m1.getSecondValue().compareTo(m2.getSecondValue());
			}
			
		}
		
}
