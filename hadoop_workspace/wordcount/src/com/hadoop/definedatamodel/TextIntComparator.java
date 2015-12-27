package com.hadoop.definedatamodel;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TextIntComparator extends WritableComparator {
		public TextIntComparator(){
			super(DefineModel.class,true);
		}

		@Override
		public int compare(WritableComparable a, WritableComparable b) {
			DefineModel m1=(DefineModel)a;
			DefineModel m2=(DefineModel)b;
			if(!m1.getTextKey().equals(m2.getTextKey())){
				return m1.getTextKey().compareTo(m2.getTextKey());
			}
			else{
				return m1.getIntValue()-m2.getIntValue();
			}
			
		}
		
}
