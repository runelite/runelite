package net.runelite.client.plugins.oddsoverlay;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

@Slf4j
@PluginDescriptor(
        name = "Odds Overlay",
        description = "Displays information about your current stake",
        tags = {"odds", "staking", "loudpacks", "stake"},
        enabledByDefault = true
)
public class OddsPlugin extends Plugin {

    @Getter
    private final Map<Skill, Integer> theirSkillMap = new LinkedHashMap<>();

    private final Map<String, HiscoreResult> scoreMap = new HashMap<>();

    @Getter
    private HiscoreResult result;

    @Getter
    private double meleeOdds;

    @Getter
    private double rangedOdds;

    @Inject
    HiscoreClient hiscoreClient;
    @Inject
    private Client client;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private OddsOverlay oddsOverlay;

    private static final String CHALLENGE = "Challenge";
    private static final String KICK_OPTION = "Kick";
    private static final ImmutableList<String> BEFORE_OPTIONS = ImmutableList.of("Add friend", "Remove friend", KICK_OPTION);
    private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message");

    private static String sanitize(String lookup) {
        return lookup.replace('\u00A0', ' ');
    }

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(oddsOverlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(oddsOverlay);
        theirSkillMap.clear();
        scoreMap.clear();
    }

    @Subscribe
    public void onChatMessage(ChatMessage event) {
        if (event.getType() == ChatMessageType.DUEL) {
            if (event.getMessage().toLowerCase().endsWith("duel with you.")) {
                Pattern p = Pattern.compile(".*?(?=\\s+wishes)");
                Matcher m = p.matcher(event.getMessage());
                if (m.find()) {
                    lookup(m.group(0));
                }
            }
        }
    }

    @Subscribe
    public void onMenuEntryClicked(MenuOptionClicked event) {
        if (event.getMenuOption().equals(CHALLENGE)) {
            lookup(Text.removeTags(event.getMenuTarget()).split(" ")[0]);
        }
    }

    private void lookup(String user) {
        Thread t = new Thread(() ->
        {
            theirSkillMap.clear();
            meleeOdds = 0.0;
            rangedOdds = 0.0;
            result = null;
            final String username = sanitize(user);

            if (Strings.isNullOrEmpty(username)) {
                return;
            }

            if (username.length() > 12) {
                return;
            }

            try {
                if(scoreMap.containsKey(username)) {
                    result = scoreMap.get(username);
                } else {
                    result = hiscoreClient.lookup(username, HiscoreEndpoint.NORMAL);
                    scoreMap.put(username, result);
                }

                if (result == null) {
                    return;
                }

                if (result.getPlayer() != null) {
                    theirSkillMap.put(Skill.ATTACK, result.getAttack().getLevel());
                    theirSkillMap.put(Skill.STRENGTH, result.getStrength().getLevel());
                    theirSkillMap.put(Skill.DEFENCE, result.getDefence().getLevel());
                    theirSkillMap.put(Skill.HITPOINTS, result.getHitpoints().getLevel());
                    theirSkillMap.put(Skill.RANGED, result.getRanged().getLevel());

                    meleeOdds = OddsCalculator.calculateMeleeOdds(new OddsPlayer(client.getRealSkillLevel(Skill.ATTACK),
                            client.getRealSkillLevel(Skill.STRENGTH),
                            client.getRealSkillLevel(Skill.DEFENCE),
                            client.getRealSkillLevel(Skill.HITPOINTS),
                            client.getRealSkillLevel(Skill.RANGED)), new OddsPlayer(getTheirSkillMap().get(Skill.ATTACK),
                            getTheirSkillMap().get(Skill.STRENGTH),
                            getTheirSkillMap().get(Skill.DEFENCE),
                            getTheirSkillMap().get(Skill.HITPOINTS),
                            getTheirSkillMap().get(Skill.RANGED)));
                    rangedOdds = OddsCalculator.calculateRangedOdds(new OddsPlayer(client.getRealSkillLevel(Skill.ATTACK),
                            client.getRealSkillLevel(Skill.STRENGTH),
                            client.getRealSkillLevel(Skill.DEFENCE),
                            client.getRealSkillLevel(Skill.HITPOINTS),
                            client.getRealSkillLevel(Skill.RANGED)), new OddsPlayer(getTheirSkillMap().get(Skill.ATTACK),
                            getTheirSkillMap().get(Skill.STRENGTH),
                            getTheirSkillMap().get(Skill.DEFENCE),
                            getTheirSkillMap().get(Skill.HITPOINTS),
                            getTheirSkillMap().get(Skill.RANGED)));

                }
            } catch (IOException ex) {
                log.warn("Error fetching Hiscore data " + ex.getMessage());
                return;
            }
        });
        t.start();
    }
}
