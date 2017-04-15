/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.inject.callbacks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.client.RuneLite;
import net.runelite.client.events.ExperienceChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.hiscore.Hiscore;
import net.runelite.client.events.MapRegionChanged;
import net.runelite.client.events.PlayerMenuOptionsChanged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks
{
	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	private static final RuneLite runelite = RuneLite.getRunelite();

	public static void callHook(String name, int idx, Object object)
	{
		if (RuneLite.getClient() == null)
		{
			logger.warn("Event {} triggered prior to client being ready", name);
			return;
		}

		switch (name)
		{
			case "experienceChanged":
			{
				ExperienceChanged experienceChanged = new ExperienceChanged();
				experienceChanged.setIndex(idx);
				runelite.getEventBus().post(experienceChanged);
				break;
			}
			case "mapRegionsChanged":
			{
				MapRegionChanged regionChanged = new MapRegionChanged();
				regionChanged.setIndex(idx);
				runelite.getEventBus().post(regionChanged);
				break;
			}
                        case "playerMenuOptionsChanged":
                        {
                                PlayerMenuOptionsChanged optionsChanged = new PlayerMenuOptionsChanged();
                                optionsChanged.setIndex(idx);
                                runelite.getEventBus().post(optionsChanged);
                                break;
                        }
			default:
				logger.warn("Unknown event {} triggered on {}", name, object);
				return;
		}

		if (object != null)
			logger.trace("Event {} (idx {}) triggered on {}", name, idx, object);
		else
			logger.trace("Event {} (idx {}) triggered", name, idx);
	}
        
        public static void menuActionHook(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7){
                if(var2 >= 2000) 
                {
                        var2 -= 2000;
                }
                
                if(var2 == Hiscore.lookupMenuType)
                {
                        for(Plugin plugin : runelite.getPluginManager().getPlugins())
                        {
                                if(plugin instanceof Hiscore)
                                {
                                        String username = var5.split(">")[1].split("<")[0];
                                        System.out.println(username);
                                        // lookup is synchronous, so in order not to stall the client, I've put it in a seperatie thread.
                                        new Thread(){ 
                                            public void run(){
                                                ((Hiscore)plugin).lookup(username);
                                            }
                                        }.start();
                                }
                        }
                }
        }
}
