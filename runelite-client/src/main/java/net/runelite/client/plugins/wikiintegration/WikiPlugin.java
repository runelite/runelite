/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Dalton <delps1001@gmail.com>
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
package net.runelite.client.plugins.wikiintegration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.LinkBrowser;
import javax.inject.Inject;


@Slf4j
@PluginDescriptor(
        name = "OSRS Wiki Integration",
        description = "Search OSRS Wiki for selected NPC",
        tags = {"actions", "wiki"}
)
public class WikiPlugin extends Plugin {

    @Inject
    private MenuManager menuManager;

    private static final String WIKI = "Wiki";

    @Inject
    private Client client;

    @Override
    protected void startUp()
    {
        menuManager.addNpcMenuOption(WIKI);
    }

    @Override
    protected void shutDown() throws Exception
    {
        menuManager.removeNpcMenuOption(WIKI);
    }

    private String buildWikiURL(String gameObject) {

        String baseURL = "http://oldschoolrunescape.wikia.com/wiki/Special:Search?query=";

        try
        {
            return baseURL + URLEncoder.encode(gameObject, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            log.debug(e.getMessage());
            return baseURL + gameObject;
        }
    }


    @Subscribe
    public void onWikiMenuClicked(MenuOptionClicked event)
    {
        if (event.getMenuOption().equals(WIKI))
        {
            LinkBrowser.browse(buildWikiURL(event.getMenuTarget()));
        }
    }

}
