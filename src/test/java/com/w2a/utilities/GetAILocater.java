package com.w2a.utilities;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetAILocater {

	static String GEMINI_API_KEY = "AIzaSyDN_RPemNs08exx46mJNR8BH2Tp40kBIzc";


	public static String getAIEnhancedXPath(String elementDescription) throws Exception{
		OkHttpClient client = new OkHttpClient();
		String prompt = elementDescription;

		JSONObject json = new JSONObject();
		json.put("contents", new JSONArray()
				.put(new JSONObject().put("parts", new JSONArray().put(new JSONObject().put("text", prompt)))));

		RequestBody body = RequestBody.create(json.toString(), MediaType.get("application/json; charset=utf-8"));

		Request request = new Request.Builder().url(
				"https://generativelanguage.googleapis.com/v1/models/gemini-1.5:generateContent?key=" + GEMINI_API_KEY)
				.post(body).build();

		Response response = client.newCall(request).execute();
		String responseData = response.body().string();
		response.body().close();

		System.out.println("Gemini API Response:" +responseData);

		JSONObject jsonResponse =  new JSONObject(responseData);
		if(!jsonResponse.has("candidates")) {
			throw new JSONException("Invalid Gemini API response: 'candidates' key missing");
		}
		String rawPath = jsonResponse.getJSONArray("candidates").getJSONObject(0).getJSONObject("content")
				.getJSONArray("parts").getJSONObject(0).getString("text").trim();

		rawPath = rawPath.replaceAll("```xpath","").replaceAll("```","").trim();
		return rawPath;
	}


}
