package net.runelite.client.plugins.regionlocker;

import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.util.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionLocker {
    private final Client client;
    private final RegionLockerConfig config;
    private final ConfigManager configManager;

    private static Map<String, RegionTypes> regions = new HashMap<>();

    public static boolean renderLockedRegions;
    private static boolean unlockReamls;
    private static boolean unlockUnderground;

    RegionLocker(Client client, RegionLockerConfig config, ConfigManager configManager) {
        this.client = client;
        this.config = config;
        this.configManager = configManager;
        readConfig();
    }

    private List<String> StringToList(String s) {
        List<String> regs;
        if (s.isEmpty())
            regs = new ArrayList<>();
        else
            regs = new ArrayList<>(Text.fromCSV(s));
        return regs;
    }

    public void readConfig() {
        renderLockedRegions = config.renderLockedRegions();
        unlockReamls = config.unlockRealms();
        unlockUnderground = config.unlockUnderground();

        regions.clear();

        String unlockedString = config.unlockedRegions();
        List<String> unlockedRegions = StringToList(unlockedString);
        setRegions(unlockedRegions, RegionTypes.UNLOCKED);

        String unlockableString = config.unlockableRegions();
        List<String> unlockableRegions = StringToList(unlockableString);
        setRegions(unlockableRegions, RegionTypes.UNLOCKABLE);
    }

    private void setRegions(List<String> regs, RegionTypes type) {
        for (String id : regs) {
            regions.put(id, type);
        }
    }

    private void setConfig() {
        List<String> unlockedRegions = new ArrayList<>();
        List<String> unlockableRegions = new ArrayList<>();

        regions.entrySet().forEach(e -> {
            if (e.getValue() == RegionTypes.UNLOCKED) unlockedRegions.add(e.getKey());
            if (e.getValue() == RegionTypes.UNLOCKABLE) unlockableRegions.add(e.getKey());
        });

        String csv = Text.toCSV(unlockedRegions);
        configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "unlockedRegions", csv);

        csv = Text.toCSV(unlockableRegions);
        configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "unlockableRegions", csv);
    }

    public void addRegion(int regionId) {
        String id = Integer.toString(regionId);
        RegionTypes type = regions.get(id);
        if (type == null)
            regions.put(id, RegionTypes.UNLOCKABLE);
        else if (type == RegionTypes.UNLOCKABLE)
            regions.put(id, RegionTypes.UNLOCKED);
        else
            regions.remove(id);
        setConfig();
    }

    public static boolean hasRegion(int regionId) {
        int y = getY(regionId);
        if (unlockReamls && y >= 4160 && y < 5952) return true;
        if (unlockUnderground && y >= 8960) return true;
        String id = Integer.toString(regionId);
        if (regions == null) return false;
        RegionTypes type = regions.get(id);
        return type == RegionTypes.UNLOCKED;
    }

    public static boolean isUnlockable(int regionId) {
        String id = Integer.toString(regionId);
        if (regions == null) return false;
        RegionTypes type = regions.get(id);
        return type == RegionTypes.UNLOCKABLE;
    }

    public static int getX(int id) {
        return ((id >> 8) << 6);
    }

    public static int getY(int id) {
        return ((id & 255) << 6);
    }
}
