package com.Graduate.Tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class SystemTime {
		
	public Timestamp SqlTime() {
		java.util.Date uDate;
		SimpleDateFormat simpleDateFormat;
		String time;
		Timestamp timestamp = null;
		try {
			uDate = new java.util.Date();
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time = simpleDateFormat.format(uDate);
			//System.out.println("time"+time);
			uDate = simpleDateFormat.parse(time);
			//System.out.println("uDate"+uDate);
			//System.out.println("uDate.getTime()"+uDate.getTime());
			timestamp = new Timestamp(uDate.getTime());
			//System.out.println("sDate"+timestamp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timestamp;
	}
}
