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

package net.runelite.client.plugins.spellbookiconresize;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import javax.inject.Inject;


@PluginDescriptor(
        name = "Spellbook IconResizer",
        description = "Resize and filter spellbook for PKing",
        tags = {"resize", "spellbook", "magic", "spell", "pk", "book", "filter"},
		type = PluginType.PVP
)
@Slf4j
public class spellbookiconresizePlugin extends Plugin {
    public int spellbookID = -1;
    //0 = standard
    //1 = ancients
    //2 = lunars
    //3 = arrceus
    @Inject
    private Client client;
    @Inject
    private ClientThread clientThread;
    @Inject
    spellbookiconresizeConfig config;

    @Provides
    spellbookiconresizeConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(spellbookiconresizeConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        if(client.getGameState()!= GameState.LOGGED_IN){
            return;
        }

        clientThread.invoke(()->{
            spellbookID = client.getVar(Varbits.SPELLBOOK_ID);
        });

         adjustSpellbook();
    }

    @Override
    protected void shutDown() throws Exception {
        resetSpellbook();
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event) {
        if (event.getGameState() == GameState.LOGGED_IN) {
            spellbookID = client.getVar(Varbits.SPELLBOOK_ID);
            adjustSpellbook();
        }
    }
    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (event.getGroup().equals("spellbookfixer"))
        {
                adjustSpellbook();
        }
    }
    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event) {
        if (client.getGameState() == GameState.LOGGED_IN) {
            if (event.getGroupId() == WidgetID.SPELLBOOK_GROUP_ID)
            {
                spellbookID = client.getVar(Varbits.SPELLBOOK_ID );
                adjustSpellbook();
            }

        }
    }

    @Subscribe
    public void onWidgetHiddenChanged(WidgetHiddenChanged event) {
        if (client.getGameState() == GameState.LOGGED_IN) {
                spellbookID = client.getVar(Varbits.SPELLBOOK_ID );
                adjustSpellbook();
        }
    }

    @Subscribe
    public void onVarbitChanged(VarbitChanged event) {
        int oldid = spellbookID;
        spellbookID = client.getVar(Varbits.SPELLBOOK_ID);
        if (oldid != spellbookID) {
            adjustSpellbook();
        }
    }

    private void adjustSpellbook() {
        clientThread.invoke(()-> {
            if (client.getGameState() != GameState.LOGGED_IN) {
                return;
            }
            try {
                if (spellbookID == 1) {
                    if (config.shouldModifyIceBarrage()) {
                        modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, config.getBarragePositionX()-20, config.getBarragePositionY(), config.getBarrageSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, 0, 168, 24);
                        } else if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 0) {
                            modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, 0, 216, 24);
                        }
                    }
                    if (config.shouldModifyBloodBarrage()) {
                        modifySpell(WidgetInfo.SPELL_BLOOD_BARRAGE, config.getBloodPositionX()-20, config.getBloodPositionY(), config.getBloodSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_BLOOD_BARRAGE, 132, 140, 24);
                        } else {
                            modifySpell(WidgetInfo.SPELL_BLOOD_BARRAGE, 144, 180, 24);
                        }
                    }

                    if (config.shouldModifyIceBlitz()) {
                        modifySpell(WidgetInfo.SPELL_ICE_BLITZ, config.getBlitzPositionX()-20, config.getBlitzPositionY(), config.getBlitzSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_ICE_BLITZ, 44, 112, 24);
                        } else {
                            modifySpell(WidgetInfo.SPELL_ICE_BLITZ, 48, 144, 24);
                        }
                    }

                    if (config.shouldModifyBloodBlitz()) {
                        modifySpell(WidgetInfo.SPELL_BLOOD_BLITZ, config.getBloodBlitzPositionX()-20, config.getBloodBlitzPositionY(), config.getBloodBlitzSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_BLOOD_BLITZ, 0, 112, 24);
                        } else {
                            modifySpell(WidgetInfo.SPELL_BLOOD_BLITZ, 0, 144, 24);
                        }
                    }

                    setSpellHidden(WidgetInfo.SPELL_BLOOD_BARRAGE, config.shouldHideBloodBarrage());
                    setSpellHidden(WidgetInfo.SPELL_ICE_BARRAGE, config.shouldHideIceBarrage());
                    setSpellHidden(WidgetInfo.SPELL_ICE_BLITZ, config.shouldHideIceBlitz());
                    setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, config.shouldHideBloodBlitz());
                    setSpellHidden(WidgetInfo.SPELL_ICE_BURST, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_ICE_RUSH, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_BLOOD_RUSH, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_BLOOD_BURST, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_RUSH, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_BLITZ, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_BURST, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_BARRAGE, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_RUSH, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_BLITZ, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_BURST, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_BARRAGE, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_PADDEWWA_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_SENNTISTEN_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_KHARYRLL_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_LASSAR_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_DAREEYAK_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_CARRALLANGER_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_ANNAKARL_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_GHORROCK_TELEPORT, config.shouldHideOthers());
                    setSpellHidden(WidgetInfo.SPELL_EDGEVILLE_HOME_TELEPORT, config.shouldHideOthers());


                }
				
/*
				if (spellbookID == 2) {
                    if (config.shouldModifyVengeance()) {
                        modifySpell(WidgetInfo.SPELL_VENGEANCE, config.getVengeancePositionX(), config.getVengeancePositionY(), config.getVengeanceSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_VENGEANCE, 0, 0, 0);
                        } else if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 0) {
                            modifySpell(WidgetInfo.SPELL_VENGEANCE, 0, 0, 0);
                        }
                    }
					
					 setSpellHidden(WidgetInfo.SPELL_LUNAR_HOME_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_VENGEANCE_OTHER, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_VENGEANCE, config.shouldHideVengeance());
					 setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT3, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_BAKE_PIE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CURE_PLANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_MONSTER_EXAMINE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_NPC_CONTACT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CURE_OTHER, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_HUMIDIFY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_MOONCLAN_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_MOONCLAN, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CURE_ME, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_HUNTER_KIT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATERBIRTH_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_WATERBIRTH, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CURE_GROUP, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_STAT_SPY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_BARBARIAN_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_BARBARIAN, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_SUPERGLASS_MAKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TAN_LEATHER, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_KHAZARD_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_KHAZARD, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_DREAM, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_STRING_JEWELLERY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_STAT_RESTORE_POT_SHARE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_MAGIC_IMBUE(, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FERTILE_SOIL, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_BOOST_POTION_SHARE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FISHING_GUILD_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_FISHING_GUILD, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_PLANK_MAKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CATHERBY_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_CATHERBY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_RECHARGE_DRAGONSTONE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_ICE_PLATEAU_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_ICE_PLATEAU, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_ENERGY_TRANSFER, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_HEAL_OTHER, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_HEAL_GROUP, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_SPELLBOOK_SWAP, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_GEOMANCY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_SPIN_FLAX, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_OURANIA_TELEPORT, config.shouldHideOthers());
				}

				if (spellbookID == 0) {
                    if (config.shouldModifyTeleBlock()) {
                        modifySpell(WidgetInfo.SPELL_TELE_BLOCK, config.getTeleBlockPositionX() -20, config.getTeleBlockPositionY(), config.getTeleBlockSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_TELE_BLOCK, 0, 0, 0);
                        } else if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 0) {
                            modifySpell(WidgetInfo.SPELL_TELE_BLOCK, 0, 0, 0);
                        }
                    }
                    if (config.shouldModifyFireSurge()) {
                        modifySpell(WidgetInfo.SPELL_FIRE_SURGE, config.getFireSurgePositionX() -20, config.getFireSurgePositionY(), config.getFireSurgeSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_FIRE_SURGE, 0, 0, 0);
                        } else if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 0) {
                            modifySpell(WidgetInfo.SPELL_FIRE_SURGE, 0, 0, 0);
                        }
                    }

                    if (config.shouldModifyEntangle()) {
                        modifySpell(WidgetInfo.SPELL_ENTANGLE, config.getEntanglePositionX() -20, config.getEntanglePositionY(), config.getEntangleSize());
                    } else {
                        if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                            modifySpell(WidgetInfo.SPELL_ENTANGLE, 0, 0, 0);
                        } else if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 0) {
                            modifySpell(WidgetInfo.SPELL_ENTANGLE, 0, 0, 0);
                        }
                    }
					
					 setSpellHidden(WidgetInfo.SPELL_LUMBRIDGE_HOME_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WIND_STRIKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CONFUSE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_ENCHANT_CROSSBOW_BOLT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATER_STRIKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LVL_1_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_EARTH_STRIKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WEAKEN, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FIRE_STRIKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_BONES_TO_BANANAS, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WIND_BOLT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CURSE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_BIND, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LOW_LEVEL_ALCHEMY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATER_BOLT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_VARROCK_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LVL_2_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_EARTH_BOLT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LUMBRIDGE_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELEKINETIC_GRAB, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FIRE_BOLT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FALADOR_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CRUMBLE_UNDEAD, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELEPORT_TO_HOUSE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WIND_BLAST, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_SUPERHEAT_ITEM, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CAMELOT_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATER_BLAST, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LVL_3_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_IBAN_BLAST, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_SNARE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_MAGIC_DART, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_ARDOUGNE_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_EARTH_BLAST, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_HIGH_LEVEL_ALCHEMY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_WATER_ORB, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LVL_4_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATCHTOWER_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FIRE_BLAST, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_EARTH_ORB, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_BONES_TO_PEACHES, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_SARADOMIN_STRIKE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CLAWS_OF_GUTHIX, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FLAMES_OF_ZAMORAK, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TROLLHEIM_TELEPORT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WIND_WAVE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_FIRE_ORB, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELEPORT_TO_APE_ATOLL, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATER_WAVE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_AIR_ORB, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_VULNERABILITY, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LVL_5_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELEPORT_TO_KOUREND, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_EARTH_WAVE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_ENFEEBLE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FIRE_WAVE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_ENTANGLE, config.shouldHideEntangle());
					 setSpellHidden(WidgetInfo.SPELL_TELEOTHER_LUMBRIDGE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_STUN, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_CHARGE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WIND_SURGE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELEOTHER_FALADOR, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_WATER_SURGE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELE_BLOCK, config.shouldHideTeleBlock());
					 setSpellHidden(WidgetInfo.SPELL_LVL_6_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_TELEOTHER_CAMELOT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_EARTH_SURGE, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_LVL_7_ENCHANT, config.shouldHideOthers());
					 setSpellHidden(WidgetInfo.SPELL_FIRE_SURGE, config.shouldHideFireSurge());
					 setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT2, config.shouldHideOthers());
				}
*/
				
            } catch (Exception e) {
                //swallow
            }

        });
    }


    private void resetSpellbook() {
        clientThread.invoke(()-> {
            if (client.getGameState() != GameState.LOGGED_IN)
                return;

            try {
                if (spellbookID == 1) {

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, 0, 168, 24);
                    } else {
                        modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, 0, 216, 24);
                    }

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_BLOOD_BARRAGE, 132, 140, 24);
                    } else {
                        modifySpell(WidgetInfo.SPELL_BLOOD_BARRAGE, 144, 180, 24);
                    }

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_ICE_BLITZ, 44, 112, 24);
                    } else {
                        modifySpell(WidgetInfo.SPELL_ICE_BLITZ, 48, 144, 24);
                    }

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_BLOOD_BLITZ, 0, 112, 24);
                    } else {
                        modifySpell(WidgetInfo.SPELL_BLOOD_BLITZ, 0, 144, 24);
                    }

                    if (config.shouldHideBloodBarrage()) {
                        setSpellHidden(WidgetInfo.SPELL_BLOOD_BARRAGE, false);
                    }
                    if (config.shouldHideIceBarrage()) {
                        setSpellHidden(WidgetInfo.SPELL_ICE_BARRAGE, false);
                    }
                    if (config.shouldHideIceBlitz()) {
                        setSpellHidden(WidgetInfo.SPELL_ICE_BLITZ, false);
                    }
                    if (config.shouldHideBloodBlitz()) {
                        setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, false);
                    }
                    setSpellHidden(WidgetInfo.SPELL_ICE_BURST, false);
                    setSpellHidden(WidgetInfo.SPELL_ICE_BURST, false);
                    setSpellHidden(WidgetInfo.SPELL_ICE_RUSH, false);
                    setSpellHidden(WidgetInfo.SPELL_BLOOD_RUSH, false);
                    setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, false);
                    setSpellHidden(WidgetInfo.SPELL_BLOOD_BURST, false);
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_RUSH, false);
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_BLITZ, false);
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_BURST, false);
                    setSpellHidden(WidgetInfo.SPELL_SMOKE_BARRAGE, false);
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_RUSH, false);
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_BLITZ, false);
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_BURST, false);
                    setSpellHidden(WidgetInfo.SPELL_SHADOW_BARRAGE, false);
                    setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_PADDEWWA_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_SENNTISTEN_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_KHARYRLL_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_LASSAR_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_DAREEYAK_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_CARRALLANGER_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_ANNAKARL_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_GHORROCK_TELEPORT, false);
                    setSpellHidden(WidgetInfo.SPELL_EDGEVILLE_HOME_TELEPORT, false);
                }
/*				
				if (spellbookID == 0) {

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_ENTANGLE, 0, 0, 0);
                    } else {
                        modifySpell(WidgetInfo.SPELL_ENTANGLE, 0, 0, 0);
                    }

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_TELE_BLOCK, 0, 0, 0);
                    } else {
                        modifySpell(WidgetInfo.SPELL_TELE_BLOCK, 0, 0, 0);
                    }

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_FIRE_SURGE, 0, 0, 0);
                    } else {
                        modifySpell(WidgetInfo.SPELL_FIRE_SURGE, 0, 0, 0);
                    }

                    if (config.shouldHideTeleBlock()) {
                        setSpellHidden(WidgetInfo.SPELL_TELE_BLOCK, false);
                    }
                    if (config.shouldHideEntangle()) {
                        setSpellHidden(WidgetInfo.SPELL_ENTANGLE, false);
                    }
                    if (config.shouldHideFireSurge()) {
                        setSpellHidden(WidgetInfo.SPELL_FIRE_SURGE, false);
                    }

                     setSpellHidden(WidgetInfo.SPELL_LUMBRIDGE_HOME_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_WIND_STRIKE, false);
					 setSpellHidden(WidgetInfo.SPELL_CONFUSE, false);
					 setSpellHidden(WidgetInfo.SPELL_ENCHANT_CROSSBOW_BOLT, false);
					 setSpellHidden(WidgetInfo.SPELL_WATER_STRIKE, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_1_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_EARTH_STRIKE, false);
					 setSpellHidden(WidgetInfo.SPELL_WEAKEN, false);
					 setSpellHidden(WidgetInfo.SPELL_FIRE_STRIKE, false);
					 setSpellHidden(WidgetInfo.SPELL_BONES_TO_BANANAS, false);
					 setSpellHidden(WidgetInfo.SPELL_WIND_BOLT, false);
					 setSpellHidden(WidgetInfo.SPELL_CURSE, false);
					 setSpellHidden(WidgetInfo.SPELL_BIND, false);
					 setSpellHidden(WidgetInfo.SPELL_LOW_LEVEL_ALCHEMY, false);
					 setSpellHidden(WidgetInfo.SPELL_WATER_BOLT, false);
					 setSpellHidden(WidgetInfo.SPELL_VARROCK_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_2_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_EARTH_BOLT, false);
					 setSpellHidden(WidgetInfo.SPELL_LUMBRIDGE_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEKINETIC_GRAB, false);
					 setSpellHidden(WidgetInfo.SPELL_FIRE_BOLT, false);
					 setSpellHidden(WidgetInfo.SPELL_FALADOR_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_CRUMBLE_UNDEAD, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEPORT_TO_HOUSE, false);
					 setSpellHidden(WidgetInfo.SPELL_WIND_BLAST, false);
					 setSpellHidden(WidgetInfo.SPELL_SUPERHEAT_ITEM, false);
					 setSpellHidden(WidgetInfo.SPELL_CAMELOT_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_WATER_BLAST, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_3_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_IBAN_BLAST, false);
					 setSpellHidden(WidgetInfo.SPELL_SNARE, false);
					 setSpellHidden(WidgetInfo.SPELL_MAGIC_DART, false);
					 setSpellHidden(WidgetInfo.SPELL_ARDOUGNE_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_EARTH_BLAST, false);
					 setSpellHidden(WidgetInfo.SPELL_HIGH_LEVEL_ALCHEMY, false);
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_WATER_ORB, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_4_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_WATCHTOWER_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_FIRE_BLAST, false);
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_EARTH_ORB, false);
					 setSpellHidden(WidgetInfo.SPELL_BONES_TO_PEACHES, false);
					 setSpellHidden(WidgetInfo.SPELL_SARADOMIN_STRIKE, false);
					 setSpellHidden(WidgetInfo.SPELL_CLAWS_OF_GUTHIX, false);
					 setSpellHidden(WidgetInfo.SPELL_FLAMES_OF_ZAMORAK, false);
					 setSpellHidden(WidgetInfo.SPELL_TROLLHEIM_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_WIND_WAVE, false);
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_FIRE_ORB, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEPORT_TO_APE_ATOLL, false);
					 setSpellHidden(WidgetInfo.SPELL_WATER_WAVE, false);
					 setSpellHidden(WidgetInfo.SPELL_CHARGE_AIR_ORB, false);
					 setSpellHidden(WidgetInfo.SPELL_VULNERABILITY, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_5_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEPORT_TO_KOUREND, false);
					 setSpellHidden(WidgetInfo.SPELL_EARTH_WAVE, false);
					 setSpellHidden(WidgetInfo.SPELL_ENFEEBLE, false);
					 setSpellHidden(WidgetInfo.SPELL_FIRE_WAVE, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEOTHER_LUMBRIDGE, false);
					 setSpellHidden(WidgetInfo.SPELL_STUN, false);
					 setSpellHidden(WidgetInfo.SPELL_CHARGE, false);
					 setSpellHidden(WidgetInfo.SPELL_WIND_SURGE, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEOTHER_FALADOR, false);
					 setSpellHidden(WidgetInfo.SPELL_WATER_SURGE, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_6_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELEOTHER_CAMELOT, false);
					 setSpellHidden(WidgetInfo.SPELL_EARTH_SURGE, false);
					 setSpellHidden(WidgetInfo.SPELL_LVL_7_ENCHANT, false);
					 setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT2, false);
                }
				
				if (spellbookID == 2) {

                    if (client.getVar(Varbits.SPELLBOOK_HIDDEN) == 1) {
                        modifySpell(WidgetInfo.SPELL_VENGEANCE, 0, 0, 0);
                    } else {
                        modifySpell(WidgetInfo.SPELL_VENGEANCE, 0, 0, 0);
                    }
                  
                    if (config.shouldHideVengeance()) {
                        setSpellHidden(WidgetInfo.SPELL_VENGEANCE, false);
                    }

					 setSpellHidden(WidgetInfo.SPELL_LUNAR_HOME_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_VENGEANCE_OTHER, false);
					 setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT3, false);
					 setSpellHidden(WidgetInfo.SPELL_BAKE_PIE, false);
					 setSpellHidden(WidgetInfo.SPELL_CURE_PLANT, false);
					 setSpellHidden(WidgetInfo.SPELL_MONSTER_EXAMINE, false);
					 setSpellHidden(WidgetInfo.SPELL_NPC_CONTACT, false);
					 setSpellHidden(WidgetInfo.SPELL_CURE_OTHER, false);
					 setSpellHidden(WidgetInfo.SPELL_HUMIDIFY, false);
					 setSpellHidden(WidgetInfo.SPELL_MOONCLAN_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_MOONCLAN, false);
					 setSpellHidden(WidgetInfo.SPELL_CURE_ME, false);
					 setSpellHidden(WidgetInfo.SPELL_HUNTER_KIT, false);
					 setSpellHidden(WidgetInfo.SPELL_WATERBIRTH_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_WATERBIRTH, false);
					 setSpellHidden(WidgetInfo.SPELL_CURE_GROUP, false);
					 setSpellHidden(WidgetInfo.SPELL_STAT_SPY, false);
					 setSpellHidden(WidgetInfo.SPELL_BARBARIAN_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_BARBARIAN, false);
					 setSpellHidden(WidgetInfo.SPELL_SUPERGLASS_MAKE, false);
					 setSpellHidden(WidgetInfo.SPELL_TAN_LEATHER, false);
					 setSpellHidden(WidgetInfo.SPELL_KHAZARD_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_KHAZARD, false);
					 setSpellHidden(WidgetInfo.SPELL_DREAM, false);
					 setSpellHidden(WidgetInfo.SPELL_STRING_JEWELLERY, false);
					 setSpellHidden(WidgetInfo.SPELL_STAT_RESTORE_POT_SHARE, false);
					 setSpellHidden(WidgetInfo.SPELL_MAGIC_IMBUE(, false);
					 setSpellHidden(WidgetInfo.SPELL_FERTILE_SOIL, false);
					 setSpellHidden(WidgetInfo.SPELL_BOOST_POTION_SHARE, false);
					 setSpellHidden(WidgetInfo.SPELL_FISHING_GUILD_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_FISHING_GUILD, false);
					 setSpellHidden(WidgetInfo.SPELL_PLANK_MAKE, false);
					 setSpellHidden(WidgetInfo.SPELL_CATHERBY_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_CATHERBY, false);
					 setSpellHidden(WidgetInfo.SPELL_RECHARGE_DRAGONSTONE, false);
					 setSpellHidden(WidgetInfo.SPELL_ICE_PLATEAU_TELEPORT, false);
					 setSpellHidden(WidgetInfo.SPELL_TELE_GROUP_ICE_PLATEAU, false);
					 setSpellHidden(WidgetInfo.SPELL_ENERGY_TRANSFER, false);
					 setSpellHidden(WidgetInfo.SPELL_HEAL_OTHER, false);
					 setSpellHidden(WidgetInfo.SPELL_HEAL_GROUP, false);
					 setSpellHidden(WidgetInfo.SPELL_SPELLBOOK_SWAP, false);
					 setSpellHidden(WidgetInfo.SPELL_GEOMANCY, false);
					 setSpellHidden(WidgetInfo.SPELL_SPIN_FLAX, false);
					 setSpellHidden(WidgetInfo.SPELL_OURANIA_TELEPORT, false);
                }
*/
            } catch (Exception e) {
                //swallow
            }
        });
    }

    private void modifySpell(WidgetInfo widgetInfo, int x, int y, int size) {
        Widget widget = client.getWidget(widgetInfo);

        if (widget == null)
            return;

        try {
            boolean update = false;
            //if (widget.getSpriteId() != icon) {

            //update = true;
            // }
            if (widget.getOriginalX() != x) {
                widget.setOriginalX(x);

                update = true;
            }
            if (widget.getOriginalY() != y) {
                widget.setOriginalY(y);
                update = true;
            }
            //if (widget.getOriginalWidth() != size) {
                widget.setOriginalWidth(size);
             //   update = true;
           // }
            //if (widget.getOriginalHeight() != size) {
                widget.setOriginalHeight(size);
              //  update = true;
           // }
            //if (update) {
                widget.revalidate();
            clientThread.invoke(widget::revalidate);
           //}
        } catch (Exception e) {
            //swallow
        }

    }

    private void setSpellHidden(WidgetInfo widgetInfo, boolean hidden) {
        Widget widget = client.getWidget(widgetInfo);

        if (widget == null)
            return;

        widget.setHidden(hidden);
    }

}
