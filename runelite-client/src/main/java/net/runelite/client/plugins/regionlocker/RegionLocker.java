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

        String blacklistedString = config.blacklistedRegions();
        List<String> blacklistedRegions = StringToList(blacklistedString);
        setRegions(blacklistedRegions, RegionTypes.BLACKLISTED);
    }

    private void setRegions(List<String> regs, RegionTypes type) {
        for (String id : regs) {
            regions.put(id, type);
        }
    }

    private void setConfig() {
        List<String> unlockedRegions = new ArrayList<>();
        List<String> unlockableRegions = new ArrayList<>();
        List<String> blacklistedRegions = new ArrayList<>();

        regions.entrySet().forEach(e -> {
            if (e.getValue() == RegionTypes.UNLOCKED) unlockedRegions.add(e.getKey());
            if (e.getValue() == RegionTypes.UNLOCKABLE) unlockableRegions.add(e.getKey());
            if (e.getValue() == RegionTypes.BLACKLISTED) blacklistedRegions.add(e.getKey());
        });

        String csv = Text.toCSV(unlockedRegions);
        configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "unlockedRegions", csv);

        csv = Text.toCSV(unlockableRegions);
        configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "unlockableRegions", csv);

        csv = Text.toCSV(blacklistedRegions);
        configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "blacklistedRegions", csv);
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

    public void blockRegion(int regionId) {
        String id = Integer.toString(regionId);
        RegionTypes type = regions.get(id);
        if (type != RegionTypes.BLACKLISTED)
            if (type == null) regions.put(id, RegionTypes.BLACKLISTED);
            else regions.replace(id, RegionTypes.BLACKLISTED);
        else
            regions.remove(id);
        setConfig();
    }

    public static RegionTypes getType(int regionId) {
        String id = Integer.toString(regionId);
        int y = getY(regionId);
        if (unlockReamls && y >= 4160 && y < 5952) return RegionTypes.UNLOCKED;
        if (unlockUnderground && y >= 8960) return RegionTypes.UNLOCKED;
        if (regions == null) return null;
        return regions.get(id);
    }

    public static boolean hasRegion(int regionId) {
        RegionTypes type = getType(regionId);
        if (type == null) return false;
        return type == RegionTypes.UNLOCKED;
    }

    public static boolean isUnlockable(int regionId) {
        RegionTypes type = getType(regionId);
        if (type == null) return false;
        return type == RegionTypes.UNLOCKABLE;
    }

    public static boolean isBlacklisted(int regionId) {
        RegionTypes type = getType(regionId);
        if (type == null) return false;
        return type == RegionTypes.BLACKLISTED;
    }


    public static int getX(int id) {
        return ((id >> 8) << 6);
    }

    public static int getY(int id) {
        return ((id & 255) << 6);
    }
}
