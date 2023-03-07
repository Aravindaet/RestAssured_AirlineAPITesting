package com.RestAssured.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utility {

	public Object getKey(JSONArray array, String key) {
		Object value = null;
		for (int i = 0; i < array.length(); i++) {
			JSONObject item = array.getJSONObject(i);
			if (item.keySet().contains(key)) {
				value = item.get(key);
				break;
			}
		}

		return value;
	}

}
