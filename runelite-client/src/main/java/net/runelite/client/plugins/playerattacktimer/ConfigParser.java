package net.runelite.client.plugins.playerattacktimer;

import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;


public final class ConfigParser
{

  private static Logger logger = LoggerFactory.getLogger(ConfigParser.class);
  private ConfigParser()
  {

  }

  public static boolean parse_config(final String value)
  {
    return parse(value).isPresent();
  }

  public static Optional<HashMap<Integer, AnimationTickMapEntry>> parse(final String value) {
    if (value.isEmpty() || value.isBlank()) {
      return Optional.empty();
    }

    final Splitter NEWLINE_SPLITTER = Splitter
        .on("\n")
        .omitEmptyStrings()
        .trimResults();

    HashMap<Integer, AnimationTickMapEntry> tickMap = new HashMap<>();

    for (String line : NEWLINE_SPLITTER.split(value)) {
      String[] segments = line.split(":");
      try {
        int animation = Integer.parseInt(segments[0]);
        int delay = Integer.parseInt(segments[1]);
        tickMap.put(animation, new AnimationTickMapEntry(delay));
      } catch (Exception e) {
        logger.debug("TEST456: {}", e);
      }
    }
    return Optional.of(tickMap);
  }

}