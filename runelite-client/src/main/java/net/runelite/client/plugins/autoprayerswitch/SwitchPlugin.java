/*
 * Copyright (c) 2018, https://runelitepl.us
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 package net.runelite.client.plugins.autoprayerswitch;

import net.runelite.client.plugins.PluginType;
import org.slf4j.LoggerFactory;
import net.runelite.api.MenuAction;
import net.runelite.api.Actor;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.kit.KitType;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.api.events.PlayerDespawned;
import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.Player;
import javax.inject.Inject;
import net.runelite.api.Client;
import org.slf4j.Logger;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.Plugin;

@PluginDescriptor(
        name="Switch Plugin",
        description="Automatically switches prayers based on opponents equipment",
        tags={"loudpacks", "prayer", "switches", "auto"},
        type = PluginType.PVP
)
public class SwitchPlugin
  extends Plugin
{
  private static final Logger log = LoggerFactory.getLogger(SwitchPlugin.class);
  @Inject
  private Client client;
  @Inject
  private SwitchConfig config;
  private Player opponent;
  private Prayer prayer;
  
  @Provides
  SwitchConfig provideConfig(ConfigManager configManager)
  {
    return (SwitchConfig)configManager.getConfig(SwitchConfig.class);
  }
  
  protected void startUp() {}
  
  protected void shutDown()
  {
    if (this.prayer != null) {
      deactivatePrayer(this.prayer);
    }
    this.opponent = null;
    this.prayer = null;
  }
  
  @Subscribe
  public void onPlayerDespawned(PlayerDespawned event)
  {
    if (this.opponent == null) {
      return;
    }
    Player player = event.getPlayer();
    if (player.equals(this.opponent))
    {
      this.opponent = null;
      if (this.prayer != null) {
        deactivatePrayer(this.prayer);
      }
    }
  }
  
  @Subscribe
  public void onGameTick(GameTick event)
  {
    if (this.opponent == null) {
      return;
    }
    int weapon = this.opponent.getPlayerComposition().getEquipmentId(KitType.WEAPON);
    Prayer counterPrayer = WeaponMap.getMappingForID(weapon);
    if (counterPrayer != null) {
      activatePrayer(counterPrayer);
    }
  }
  
  @Subscribe
  public void onInteractingChanged(InteractingChanged event)
  {
    boolean inPvp = false;
    for (String option : this.client.getPlayerOptions()) {
      if ((option != null) && ((option.equals("Attack")) || (option.equals("Fight")))) {
        inPvp = true;
      }
    }
    if (!inPvp) {
      return;
    }
    Actor source = event.getSource();
    if (!(source instanceof Player)) {
      return;
    }
    Actor target = event.getTarget();
    if (!(target instanceof Player)) {
      return;
    }
    if (target != this.client.getLocalPlayer()) {
      return;
    }
    this.opponent = ((Player)source);
  }
  
  private void activatePrayer(Prayer prayer)
  {
    if (!this.client.isPrayerActive(prayer.getPrayer()))
    {
     // client.invokeMenuAction(-1, prayer.getWidgetId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "Activate", "<col=ff9040>" + prayer.getName() + "</col>", 50, 50);
      this.prayer = prayer;
    }
  }
  
  private void deactivatePrayer(Prayer prayer)
  {
    if (this.client.isPrayerActive(prayer.getPrayer()))
    {
      //client.invokeMenuAction(-1, prayer.getWidgetId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "Deactivate", "<col=ff9040>" + prayer.getName() + "</col>", 50, 50);
      this.prayer = null;
    }
  }
}