package net.runelite.client.plugins.chattranslation;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class Translator
{
	private static final String BASE_URL = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=";
	private static final String SOURCE = "auto";
	private static final String CENT_URL = "&tl=";
	private static final String LAST_URL = "&dt=t&q=";

	private String incomingUrlBase;
	private String outgoingUrlBase;

	void setInLang(Languages lang)
	{
		incomingUrlBase = BASE_URL + SOURCE + CENT_URL + lang.toShortString() + LAST_URL;
	}
	void setOutLang(Languages lang)
	{
		outgoingUrlBase = BASE_URL + SOURCE + CENT_URL + lang.toShortString() + LAST_URL;
	}

	String translateIncoming(String message) throws IOException
	{
		final String url = incomingUrlBase + URLEncoder.encode(message, "UTF-8");
		return translate(new URL(url));
	}

	String translateOutgoing(String message) throws IOException
	{
		final String url = outgoingUrlBase + URLEncoder.encode(message, "UTF-8");
		return translate(new URL(url));
	}

	public String translate(URL url) throws IOException
	{
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
		{
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}

			return parseResult(response.toString());
		}
		catch (IOException e)
		{
			throw e;
		}
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
