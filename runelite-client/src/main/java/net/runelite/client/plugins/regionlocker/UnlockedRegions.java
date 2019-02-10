package net.runelite.client.plugins.regionlocker;

import com.google.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.util.Text;
import org.apache.commons.csv.CSVParser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnlockedRegions {
    private final Client client;
    private final RegionLockerConfig config;

    @Getter
    private static List<String> regions;

    public static boolean renderLockedRegions;

    UnlockedRegions(Client client, RegionLockerConfig config) {
        this.client = client;
        this.config = config;

        readRegions();
    }

    public void readRegions() {
        renderLockedRegions = config.renderLockedRegions();
        String s = config.unlockedRegions();
        List<String> regs;
        if (s.isEmpty())
            regs = Collections.emptyList();
        else
            regs = Text.fromCSV(config.unlockedRegions());
        setRegions(regs);
    }

    private void setRegions(List<String> regs) {
        regions = regs;
    }

    public static boolean hasRegion(int regionId) {
        String id = Integer.toString(regionId);
        if (regions == null) return false;
        return regions.contains(id);
    }
}
