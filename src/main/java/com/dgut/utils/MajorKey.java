package com.dgut.utils;

import java.util.UUID;

public class MajorKey {

	public static String createPK() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
