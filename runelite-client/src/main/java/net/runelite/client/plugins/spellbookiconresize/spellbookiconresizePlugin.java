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
                //   if (spellbookID == 2) {
                //        if (config.shouldModifyVengeance())
                ///           modifySpell(WidgetInfo.SPELL_VENGEANCE, config.getVengeancePositionX(), config.getVengeancePositionY(), config.getVengeanceSize());
                // }
                //  if (spellbookID == 0) {

                //      if (config.shouldModifyTeleBlock())
                //          modifySpell(WidgetInfo.SPELL_TELE_BLOCK, config.getTeleBlockPositionX(), config.getTeleBlockPositionY(), config.getTeleBlockSize());
//
                //       if (config.shouldModifyEntangle())
                //           modifySpell(WidgetInfo.SPELL_ENTANGLE, config.getEntanglePositionX(), config.getEntanglePositionY(), config.getEntangleSize());
                //   }


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
