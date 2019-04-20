package net.runelite.client.plugins.whalewatchers;


import org.jetbrains.annotations.*;
import net.runelite.client.plugins.*;
import net.runelite.client.game.*;
import net.runelite.client.config.*;
import com.google.inject.*;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.eventbus.*;
import net.runelite.api.kit.*;
import org.apache.commons.lang3.*;
import net.runelite.api.*;
import net.runelite.api.events.*;
import java.util.*;

@PluginDescriptor(name = "<font color=\"aqua\">!Whale Watchers</font>", description = "A Plugin to save help whales in the wild", tags = { "whale watchers", "whale", "protect item", "warning", "pklite" }, enabledByDefault = true, hidden = false, developerPlugin = false, loadWhenOutdated = false)
public class WhaleWatchersPlugin extends Plugin
{
    @Inject
    private Client client;
    @Inject
    private WhaleWatchersConfig config;
    @Inject
    private WhaleWatchersOverlay overlay;
    @Inject
    private WhaleWatchersProtOverlay whaleWatchersProtOverlay;
    @Inject
    private WhaleWatchersSmiteableOverlay whaleWatchersSmiteableOverlay;
    @Inject
    private WhaleWatchersGloryOverlay whaleWatchersGloryOverlay;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private ItemManager itemManager;
    public boolean enableOverlay;
    private int lastXP;
    public int damageDone;
    public int damageTaken;
    public boolean inCombat;
    private int tickCountdown;
    private boolean displaySmiteOverlay;
    private boolean displayGloryOverlay;
    
    public WhaleWatchersPlugin() {
        this.enableOverlay = false;
        this.lastXP = 0;
        this.damageDone = 0;
        this.damageTaken = 0;
        this.inCombat = false;
        this.tickCountdown = 0;
    }
    
    @Provides
    WhaleWatchersConfig getConfig(final ConfigManager configManager) {
        return configManager.getConfig(WhaleWatchersConfig.class);
    }
    
    @Override
    protected void startUp() throws Exception {
        this.overlayManager.add(this.overlay);
        this.overlayManager.add(this.whaleWatchersProtOverlay);
        this.overlayManager.add(this.whaleWatchersSmiteableOverlay);
        this.overlayManager.add(this.whaleWatchersGloryOverlay);
    }
    
    @Override
    protected void shutDown() throws Exception {
        this.overlayManager.remove(this.overlay);
        this.overlayManager.remove(this.whaleWatchersProtOverlay);
        this.overlayManager.remove(this.whaleWatchersSmiteableOverlay);
        this.overlayManager.remove(this.whaleWatchersGloryOverlay);
    }
    
    @Subscribe
    public void onHitsplatApplied(final HitsplatApplied event) {
        if (this.config.showDamageCounter()) {
            if (!(event.getActor() == this.client.getLocalPlayer() | event.getActor() == this.client.getLocalPlayer().getInteracting())) {
                return;
            }
            if (this.isAttackingPlayer(this.client) || this.inCombat) {
                this.inCombat = true;
                if (event.getActor() == this.client.getLocalPlayer()) {
                    this.damageTaken += event.getHitsplat().getAmount();
                }
                if (event.getActor() == this.client.getLocalPlayer().getInteracting()) {
                    this.damageDone += event.getHitsplat().getAmount();
                }
            }
        }
    }
    
    @Subscribe
    public void onItemContainerChanged(final ItemContainerChanged event) {
        if (this.config.gloryWarning() && event.getItemContainer().equals(InventoryID.EQUIPMENT)) {
            final int amuletID = ObjectUtils.defaultIfNull(this.client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.AMULET), 0);
            if (amuletID == 1704) {
                this.displayGloryOverlay = true;
            }
            else {
                this.displayGloryOverlay = false;
            }
        }
        else {
            this.displayGloryOverlay = false;
        }
    }
    
    @Subscribe
    public void onExperienceChanged(final ExperienceChanged event) {
        final Skill skill = event.getSkill();
        final Player player = this.client.getLocalPlayer();
        if (skill.equals(Skill.HITPOINTS) && player.getInteracting() instanceof Player) {
            this.lastXP = this.client.getSkillExperience(skill);
        }
    }
    
    @Subscribe
    public void onMenuOptionClicked(final MenuOptionClicked event) {
        if (this.config.showDamageCounter() && event.getMenuAction().equals(MenuAction.SPELL_CAST_ON_PLAYER)) {
            this.inCombat = true;
        }
    }
    
    @Subscribe
    public void onVarbitChanged(final VarbitChanged event) {
        if (this.config.showDamageCounter() && this.client.getVar(VarPlayer.ATTACKING_PLAYER) == -1 && this.inCombat) {
            this.tickCountdown = 10;
        }
        if (this.config.protectItemWarning()) {
            try {
                if (this.client.getLocalPlayer().getSkullIcon() == SkullIcon.SKULL) {
                    if ((this.client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 0 && this.client.getVar(Varbits.IN_WILDERNESS) == 1) || this.client.getWorldType().contains(WorldType.PVP)) {
                        this.enableOverlay = true;
                    }
                    if (this.client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 1 || this.client.getVar(Varbits.IN_WILDERNESS) == 0 || this.client.getWorldType().contains(WorldType.PVP_HIGH_RISK) || this.client.getWorld() == 365) {
                        this.enableOverlay = false;
                    }
                }
                else {
                    this.enableOverlay = false;
                }
            }
            catch (NullPointerException ex) {}
        }
    }
    
    @Subscribe
    public void onGameTick(final GameTick event) {
        if (this.tickCountdown > 0 && this.tickCountdown < 11) {
            --this.tickCountdown;
            if (this.tickCountdown == 1 && !this.isAttackingPlayer(this.client)) {
                this.inCombat = false;
                this.damageDone = 0;
                this.damageTaken = 0;
                return;
            }
        }
        if (this.config.smiteableWarning() && (this.client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isPvpWorld(this.client.getWorldType()))) {
            if (this.client.getLocalPlayer().getSkullIcon() != null && this.client.getLocalPlayer().getSkullIcon().equals(SkullIcon.SKULL)) {
                final int currentHealth = this.client.getLocalPlayer().getHealth();
                final int currentPrayer = this.client.getBoostedSkillLevel(Skill.PRAYER);
                if (currentPrayer <= Math.ceil(currentHealth / 4)) {
                    this.displaySmiteOverlay = true;
                }
                else {
                    this.displaySmiteOverlay = false;
                }
            }
            else {
                this.displaySmiteOverlay = false;
            }
        }
        else {
            this.displaySmiteOverlay = false;
        }
    }

    public boolean isAttackingPlayer(@NotNull final Client c) {
        if (this.client.getVar(Varbits.IN_WILDERNESS) == 1 && this.client.getLocalPlayer().getInteracting() != null) {
            return true;
        }
        final int varp = c.getVar(VarPlayer.ATTACKING_PLAYER);
        return varp != -1;
    }

    public boolean isDisplaySmiteOverlay() {
        return this.displaySmiteOverlay;
    }

    public boolean isDisplayGloryOverlay() {
        return this.displayGloryOverlay;
    }
}
