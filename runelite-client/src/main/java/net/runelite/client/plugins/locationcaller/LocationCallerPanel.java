/*
 * Copyright (c) 2018, Andrew EP| ElPinche256 <https://github.com/ElPinche256>
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
package net.runelite.client.plugins.locationcaller;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.account.SessionManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.RunnableExceptionLogger;

@Slf4j
@Singleton
public class LocationCallerPanel extends PluginPanel
{

    private static final ImageIcon ARROW_ICON;
    private static final ImageIcon LOCATION_CALLER_ICON;

    private final JLabel loggedLabel = new JLabel();

    @Inject
    @Nullable
    private Client client;


    @Inject
    private EventBus eventBus;

    static
    {
        try
        {
            synchronized (ImageIO.class)
            {
                ARROW_ICON = new ImageIcon(ImageIO.read(LocationCallerPanel.class.getResourceAsStream("location_caller_arrow.png")));
                LOCATION_CALLER_ICON = new ImageIcon(ImageIO.read(LocationCallerPanel.class.getResourceAsStream("location_caller_icon.png")));
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    void init()
    {
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setBorder(new EmptyBorder(10, 10, 5, 10));

        JPanel versionPanel = new JPanel();
        versionPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        versionPanel.setBorder(new EmptyBorder(10, 10, 5, 10));
        versionPanel.setLayout(new GridLayout(0, 1));

        final Font smallFont = FontManager.getRunescapeSmallFont();

        JLabel c_world = new JLabel(htmlLabel("Current World: ", "N/A"));
        c_world.setFont(smallFont);

        JLabel c_location = new JLabel(htmlLabel("Current Location: ", "N/A"));
        c_location.setFont(smallFont);

        JLabel hkey_tip = new JLabel(htmlLabel("Hotkey: ", "F6"));
        hkey_tip.setFont(smallFont);

        loggedLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        loggedLabel.setFont(smallFont);

        versionPanel.add(c_world);
        versionPanel.add(c_location);
        versionPanel.add(hkey_tip);
        versionPanel.add(Box.createGlue());
        versionPanel.add(loggedLabel);

        JPanel actionsContainer = new JPanel();
        actionsContainer.setBorder(new EmptyBorder(10, 0, 0, 0));
        actionsContainer.setLayout(new GridLayout(3, 1, 0, 10));

        actionsContainer.add(buildLinkPanel(LOCATION_CALLER_ICON, "Send Location", "To Clan Chat"));

        add(versionPanel, BorderLayout.NORTH);
        add(actionsContainer, BorderLayout.CENTER);

        eventBus.register(this);
    }

    /**
     * Builds a link panel with a given icon, text and url to redirect to.
     */
    private static JPanel buildLinkPanel(ImageIcon icon, String topText, String bottomText)
    {
        JPanel container = new JPanel();
        container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        container.setLayout(new BorderLayout());
        container.setBorder(new EmptyBorder(10, 10, 10, 10));

        final Color hoverColor = ColorScheme.DARKER_GRAY_HOVER_COLOR;
        final Color pressedColor = ColorScheme.DARKER_GRAY_COLOR.brighter();

        JLabel iconLabel = new JLabel(icon);
        container.add(iconLabel, BorderLayout.WEST);

        JPanel textContainer = new JPanel();
        textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        textContainer.setLayout(new GridLayout(2, 1));
        textContainer.setBorder(new EmptyBorder(5, 10, 5, 10));

        container.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {
                container.setBackground(pressedColor);
                textContainer.setBackground(pressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                container.setBackground(hoverColor);
                textContainer.setBackground(hoverColor);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                container.setBackground(hoverColor);
                textContainer.setBackground(hoverColor);
                container.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
                textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
                container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel topLine = new JLabel(topText);
        topLine.setForeground(Color.WHITE);
        topLine.setFont(FontManager.getRunescapeSmallFont());

        JLabel bottomLine = new JLabel(bottomText);
        bottomLine.setForeground(Color.WHITE);
        bottomLine.setFont(FontManager.getRunescapeSmallFont());

        textContainer.add(topLine);
        textContainer.add(bottomLine);

        container.add(textContainer, BorderLayout.CENTER);

        JLabel arrowLabel = new JLabel(ARROW_ICON);
        container.add(arrowLabel, BorderLayout.EAST);

        return container;
    }

    private static String htmlLabel(String key, String value)
    {
        return "<html><body style = 'color:#a5a5a5'>" + key + "<span style = 'color:white'>" + value + "</span></body></html>";
    }
}
