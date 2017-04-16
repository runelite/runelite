/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.client.plugins.idlenotifier;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import static net.runelite.api.AnimationID.*;
import net.runelite.client.RuneLite;

import java.awt.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class IdleOverlay extends Overlay
{
   Client client = RuneLite.getClient();
   ScheduledExecutorService animationListener = null;

   public IdleOverlay()
   {
      super(OverlayPosition.TOP_RIGHT, OverlayPriority.LOW);
   }

   public Dimension render(Graphics2D graphics)
   {

      if (client.getGameState() != GameState.LOGGED_IN)
         return null;

      switch(client.getLocalPlayer().getAnimation())
      {
         //these values from from net.runelite.api.AnimationID
         case WOODCUTTING:
         case COOKING_FIRE:
         case COOKING_RANGE:
         case FLETCHING_BOW_CUTTING:
         case FLETCHING_BOW_STRINGING:
         case CRAFTING_GEM_CUTTING:
         case CRAFTING_LEATHER:
         case SMITHING_ANVIL:
         case SMITHING_SMELTING:
         case FISHING_NET:
         case FISHING_HARPOON:
         case FISHING_CAGE:
         case FISHING_POLE_CAST:
         case MINING_NORMAL_VEIN:
         case MINING_MOTHERLODE_VEIN:
         case HERBLORE_POTIONMAKING:
         case MAGIC_CHARGING_ORBS:
            this.animationListener();
      }

      if (client.getGameState() != GameState.LOGGED_IN)
         animationListener.shutdown();
      return null;
   }

   private Runnable checkIdle()
   {
      return new Runnable()
      {
         @Override
         public void run()
         {
            if(client.getLocalPlayer().getAnimation() == IDLE)
            {
               RuneLite.getRunelite().getIcon().displayMessage("RuneLite", "You are now idle.", TrayIcon.MessageType.NONE);
               animationListener.shutdown();
            }
         }
      };
   }

   private synchronized void animationListener()
   {
      if(animationListener == null)
      {
         animationListener = Executors.newSingleThreadScheduledExecutor();
         animationListener.scheduleWithFixedDelay(checkIdle(), 0, 2, TimeUnit.SECONDS);
      }
   }

}
