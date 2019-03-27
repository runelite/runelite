package net.runelite.client.plugins.nexthitnotifier;

import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Next Hit Notifier",
        description = "Shows estimated next hit based on xp drop.",
        tags = { "experience", "damage", "overlay", "pking", "bogla" },
        enabledByDefault = false
)
public class NextHitNotifierPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private NextHitNotifierOverlay overlay;

    private int lastHpXp = 0;
    int lastHit = 0;
    int showTime = 0;

    @Provides
    NextHitNotifierConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(NextHitNotifierConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOGGED_IN)
        {
            lastHpXp = client.getSkillExperience(Skill.HITPOINTS);
            lastHit = 0;
            showTime = 0;
        }
        else
        {
            lastHpXp = 0;
            lastHit = 0;
            showTime = 0;
        }
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (showTime > 0)
            showTime--;
        else
            lastHit = 0;
    }

    @Subscribe
    public void onExperienceChanged(ExperienceChanged event)
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            lastHpXp = 0;
            lastHit = 0;
            showTime = 0;
            return;
        }

        final Skill skill = event.getSkill();

        if (skill != Skill.HITPOINTS)
            return;

        final int currentXp = client.getSkillExperience(skill);

        int gainedXp = currentXp - lastHpXp;

        //filter out big xp drops (such as login)
        if (gainedXp > 1000)
        {
            lastHpXp = client.getSkillExperience(skill);
            return;
        }

        lastHit = (int)Math.rint(gainedXp / 1.33f);
        lastHpXp = currentXp;
        showTime = 3;
    }


}
