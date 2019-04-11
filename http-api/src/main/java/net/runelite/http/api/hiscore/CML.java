package net.runelite.http.api.hiscore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CML extends TrackerClient
{
    private static final String API_BASE_URL = "https://www.crystalmathlabs.com/tracker/api.php?";

    /**
     * Cached datapoints to prevent redundant CML requests.
     */
    private Map<String, Map<Datapoint.TimePeriod, Datapoint>> datapoints = new HashMap<>();

    /**
     * Not implemented yet but could remove the need for the CML plugin.
     */
    @Override
    public void update(String playerName) throws Exception
    {
        throw new UnsupportedOperationException();

//        int returnCode = Integer.parseInt(fetch("type=update&player=" + playerName));
//        switch (returnCode)
//        {
//            case 1: // Success!
//            case 5: // This player has been updated within the last 30 seconds.
//                break;
//            case 2: // Player not on RuneScape hiscores.
//            case 3: // Negative XP gain detected.
//            case 4: // Unknown error.
//            case 6: // The player name was invalid.
//                throw new Exception("idk");
//        }
    }

    private int lastCheck(String playerName) throws Exception
    {
        playerName = formatName(playerName);
        int lastCheck = Integer.parseInt(fetch("type=lastcheck&player=" + playerName));
        return lastCheck;
    }

    @Override
    public Datapoint track(String playerName, Datapoint.TimePeriod tp) throws Exception
    {
        playerName = formatName(playerName);
        if (datapoints.containsKey(playerName) && datapoints.get(playerName).containsKey(tp))
        {
            return datapoints.get(playerName).get(tp);
        }

        String resp = fetch("type=trackehp&player=" + playerName + "&time=" +
                (tp == Datapoint.TimePeriod.DAY ? "1d" : tp == Datapoint.TimePeriod.MONTH ? "31d" : "1w"));
        Queue<String> progressData = new LinkedList<>(Arrays.asList(resp.split(" ")));
        Datapoint.Builder builder = new Datapoint.Builder(tp);

        progressData.poll(); // Time
        for (int i = 0; i < HiscoreSkill.values().length - 9; i++)
        {
            String[] progress = progressData.remove().split(",");
            int xpGained = -1;
            int ranksGained = -1;
            int xp = -1;
            int rank = -1;
            double ehpGained = -1;

            if (progress.length == 5)
            {
                // Skill
                xpGained = (int) Double.parseDouble(progress[0]);
                ehpGained = Double.parseDouble(progress[4]);
            } else
            {
                // EHP (Not implemented yet)
            }
            builder.addProgression(HiscoreSkill.values()[i], new Progression(xpGained, ehpGained));
        }

        Datapoint dp = builder.build();
        datapoints.computeIfAbsent(playerName, k -> new HashMap<>());
        datapoints.get(playerName).put(tp, dp);
        return builder.build();
    }

    /**
     * Potential problems with CML without API key:
     * <ul>
     *   <li>HTTP 500</li>
     *   <li>"-4" response</li>
     * </ul>
     */
    private String fetch(String uri) throws Exception
    {
        URL url = new URL(API_BASE_URL + uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                builder.append(line).append(" ");
            }
        }

        String resp = builder.toString().substring(1); // Remove initial space
        if (resp.equalsIgnoreCase("-4"))
            throw new Exception();
        return resp;
    }

    @Override
    public void release()
    {
        datapoints.clear();
    }

    private String formatName(String playerName)
    {
        return playerName.replaceAll(" ", "_");
    }
}
