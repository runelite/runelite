/*
 * Copyright (c) 2017, Lyzrds
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
package net.runelite.client.plugins.instancereloadhelper;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

public class InstanceReloadHelperPanel extends PluginPanel{
    @Inject
    private Client client;

    private JButton reloadButton = new JButton("Reload Instance");
    private JLabel reloadMessage = new JLabel("<html><center><h3>Instance Reload Helper </h3>Reloading an instance will cause your client to disconnect temporarily.<br></center></html>");
    void init(InstanceReloadHelperConfig config)
    {

        // this may or may not qualify as a hack
        // but this lets the editor pane expand to fill the whole parent panel
        getParent().setLayout(new BorderLayout());
        getParent().add(this, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        JPanel reloadContainer = new JPanel();
        reloadContainer.setLayout(new BorderLayout());
        reloadContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        JPanel reloadFrame = new JPanel();
        reloadButton.addActionListener(e ->
        {
            if((client.getGameState() == GameState.LOGGED_IN) && config.doReload())
            {
                try
                {
                    Method m = client.getClass().getClassLoader().loadClass("t").getDeclaredMethod("fp", int.class);
                    m.setAccessible(true);
                    m.invoke(null, -904767418);
                    config.doReload(false);
                    while(client.getGameState() != GameState.CONNECTION_LOST)
                    {
                        //probably not the best way to do this...
                    }
                    config.doReload(true);
                    //TODO: Since this is mainly for raids i'd like to reload the raids scouting plugin after the dc is finished

                } catch (ReflectiveOperationException f)
                {
                    throw new RuntimeException(f);
                }

            }else
                {
                //TODO: User is still in a dc, or not logged in. Possibly provide a meaningful message somewhere.
                }
        });
        reloadFrame.add(reloadButton);
        reloadContainer.add(reloadFrame, BorderLayout.CENTER);
        add(reloadMessage, BorderLayout.PAGE_START);
        add(reloadContainer, BorderLayout.CENTER);
    }
}
