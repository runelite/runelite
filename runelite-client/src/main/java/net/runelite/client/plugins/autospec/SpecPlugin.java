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
 package net.runelite.client.plugins.autospec;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.PlayerComposition;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;


@PluginDescriptor(
        name="Auto Spec",
        description="Automatically enables special attack when supported weapons are equipped",
        tags={"special", "pvp", "attack"},
        type = PluginType.PVP,
        enabledByDefault=false
)
@Slf4j
@Singleton
public class SpecPlugin
  extends Plugin
{
  private static final ImmutableMap WEAPONS = ImmutableMap.builder().put(4153, 50).put(5698, 25).put(13652, 50).put(11802, 50).put(11806, 50).put(11804, 50).put(10887, 50).put(11235, 55).build();
  @Inject
  private Client client;
  @Inject
  private SpecConfig config;

  @Provides
  SpecConfig getConfig(ConfigManager configManager)
  {
    return (SpecConfig)configManager.getConfig(SpecConfig.class);
  }

  @Subscribe
  public void onGameTick(GameTick event)
  {
    if (this.client.getGameState() != GameState.LOGGED_IN) {
      return;
    }
    if (!this.config.continuousToggle()) {
      return;
    }
    PlayerComposition composition = this.client.getLocalPlayer().getPlayerComposition();
    Integer cost = (Integer)WEAPONS.get(Integer.valueOf(composition.getEquipmentId(KitType.WEAPON)));
    if ((cost != null) && (!specialEnabled()) && (this.client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) >= cost.intValue() * 10)) {
      enableSpecial();
    }
  }

  @Subscribe
  public void onMenuOptionClicked(MenuOptionClicked event)
  {
    if (this.client.getGameState() != GameState.LOGGED_IN) {
      return;
    }
    boolean equipped = event.getMenuOption().equals("Wield");
    if (!equipped) {
      return;
    }
    Integer cost = (Integer)WEAPONS.get(Integer.valueOf(event.getId()));
    if ((cost != null) && (!specialEnabled()) && (this.client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) >= cost.intValue() * 10)) {
      enableSpecial();
    }
  }

  private void enableSpecial()
  {
    //this.client.invokeMenuAction(-1, 38862883, MenuAction.WIDGET_DEFAULT.getId(), 1, "Use <col=00ff00>Special Attack</col>", "", 50, 50);
  }

  private boolean specialEnabled()
  {
    return this.client.getVar(VarPlayer.SPECIAL_ATTACK_ENABLED) == 1;
  }
}
