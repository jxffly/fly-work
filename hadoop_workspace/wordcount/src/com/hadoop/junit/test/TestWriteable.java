package com.hadoop.junit.test;

import static org.junit.Assert.*;

import org.apache.hadoop.io.Text;
import org.junit.Test;

public class TestWriteable {

	@Test
	public void test() {
		Text t=new Text("hadoop");
		assertEquals(t.getLength(), 6);
	}

}
