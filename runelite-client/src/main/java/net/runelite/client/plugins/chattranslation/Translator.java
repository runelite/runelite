package net.runelite.client.plugins.chattranslation;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class Translator
{

	public String translate(String source, String target, String message) throws Exception
	{

		String url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=" + source + "&tl=" + target + "&dt=t&q=" + URLEncoder.encode(message, "UTF-8");

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null)
		{
			response.append(inputLine);
		}
		in.close();

		return parseResult(response.toString());
	}

	private String parseResult(String inputJson)
	{
		String result;
		JsonArray jsonArray = new JsonParser().parse(inputJson).getAsJsonArray();
		JsonArray jsonArray2 = jsonArray.get(0).getAsJsonArray();
		JsonArray jsonArray3 = jsonArray2.get(0).getAsJsonArray();
		result = jsonArray3.get(0).toString();

		return result.substring(1, result.length() - 1);
	}

}
