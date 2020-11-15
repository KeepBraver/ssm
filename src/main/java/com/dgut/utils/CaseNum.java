package com.dgut.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseNum {
	public static String creatCaseNum() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}
}
