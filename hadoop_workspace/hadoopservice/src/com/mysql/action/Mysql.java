package com.mysql.action;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hadoop.utils.ConnectTools;
import com.hadoop.utils.JSONUtil;


public class Mysql {
	public static String getData(){
		String sql="select t.id,t.letter,count,t.time FROM lettercount t JOIN (SELECT letter,MAX(time) AS time FROM lettercount group by letter) a ON t.letter=a.letter AND t.time=a.time";
		Connection conn=ConnectTools.getConnection();
		ResultSet rs=null;
		PreparedStatement st=null;
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		try {
			 st= conn.prepareStatement(sql);
			 rs=st.executeQuery(sql);
			ResultSetMetaData meta_data =  rs.getMetaData();//列名
            for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
                System.out.print(meta_data.getColumnLabel(i_col) + "   ");
            }
            while (rs.next()) {
            	HashMap<String, Object> hashmap=new HashMap<String, Object>();
                for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
                    hashmap.put(meta_data.getColumnName(i_col),rs.getString(i_col));
                }
                maplist.add(hashmap);
            }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "{\"responseData\":"+JSONUtil.toJson(maplist)+"}";
		
	}

}
