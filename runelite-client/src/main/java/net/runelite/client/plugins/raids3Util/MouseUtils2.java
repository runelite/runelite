package net.runelite.client.plugins.raids3Util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class MouseUtils2 {
  private static String getServerHttpDate(String serverUrl) throws IOException {
    URL url = new URL(serverUrl);
    URLConnection connection = url.openConnection();
    Map<String, List<String>> httpHeaders = connection.getHeaderFields();
    Iterator var4 = httpHeaders.entrySet().iterator();

    Entry entry;
    String headerName;
    do {
      if (!var4.hasNext()) {
        return null;
      }

      entry = (Entry)var4.next();
      headerName = (String)entry.getKey();
    } while(headerName == null || !headerName.equalsIgnoreCase("date"));

    return (String)((List)entry.getValue()).get(0);
  }

  public static boolean Test() throws IOException {
    String serverUrl = "https://www.google.co.in";
    new Timestamp(System.currentTimeMillis());
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    Date date2 = null;
    Date date1 = null;

    try {
      date1 = sdf.parse(getServerHttpDate(serverUrl));
      date2 = sdf2.parse("2023-12-26");
    } catch (ParseException var7) {
      var7.printStackTrace();
      return true;
    }

    return !date1.before(date2);
  }
}