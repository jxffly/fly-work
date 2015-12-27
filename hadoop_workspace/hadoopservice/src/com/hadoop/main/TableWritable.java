package com.hadoop.main;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class TableWritable implements Writable,DBWritable{
	private String letter;
	private long count;
	private long time;
	 public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public TableWritable() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readFields(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		this.letter=rs.getString("letter");
		this.count=rs.getLong("count");
		this.time=rs.getLong("time");
		
	}

	@Override
	public void write(PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(1, this.letter);
		ps.setLong(2, this.count);
		ps.setLong(3, this.time);
		
	}

	public TableWritable(String letter, long count,long time) {
		this.letter = letter;
		this.count = count;
		this.time=time;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.letter=in.readUTF();
		this.count=in.readLong();
		this.time=in.readLong();
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(this.letter);
		out.writeLong(this.count);
		out.writeLong(this.time);
		
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
