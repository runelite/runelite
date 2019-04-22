/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.profiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ProfilePanel
extends JPanel {
    private static final Logger log = LoggerFactory.getLogger(ProfilePanel.class);
    private static final ImageIcon DELETE_ICON;
    private static final ImageIcon DELETE_HOVER_ICON;
    private final String loginText;
    private String password = null;

    ProfilePanel(final Client client, final String data, final ProfilesConfig config) {
        String[] parts = data.split(":");
        this.loginText = parts[1];
        if (parts.length == 3) {
            this.password = parts[2];
        }
        final ProfilePanel panel = this;
        this.setLayout(new BorderLayout());
        this.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        JPanel labelWrapper = new JPanel(new BorderLayout());
        labelWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        labelWrapper.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR), BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR)));
        JPanel panelActions = new JPanel(new BorderLayout(3, 0));
        panelActions.setBorder(new EmptyBorder(0, 0, 0, 8));
        panelActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        final JLabel delete = new JLabel();
        delete.setIcon(DELETE_ICON);
        delete.setToolTipText("Delete account profile");
        delete.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                panel.getParent().remove(panel);
                ProfilesPanel.removeProfile(data);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                delete.setIcon(DELETE_HOVER_ICON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                delete.setIcon(DELETE_ICON);
            }
        });
        panelActions.add((Component)delete, "East");
        JLabel label = new JLabel();
        label.setText(parts[0]);
        label.setBorder(null);
        label.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        label.setPreferredSize(new Dimension(0, 24));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0, 8, 0, 0));
        labelWrapper.add((Component)label, "Center");
        labelWrapper.add((Component)panelActions, "East");
        label.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && client.getGameState() == GameState.LOGIN_SCREEN) {
                    client.setUsername(ProfilePanel.this.loginText);
                    if (config.rememberPassword() && ProfilePanel.this.password != null) {
                        client.setPassword(ProfilePanel.this.password);
                    }
                }
            }
        });
        JPanel bottomContainer = new JPanel(new BorderLayout());
        bottomContainer.setBorder(new EmptyBorder(8, 0, 8, 0));
        bottomContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        bottomContainer.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && client.getGameState() == GameState.LOGIN_SCREEN) {
                    client.setUsername(ProfilePanel.this.loginText);
                }
            }
        });
        JLabel login = new JLabel();
        login.setText(config.isStreamerMode() ? "Hidden email" : this.loginText);
        login.setBorder(null);
        login.setPreferredSize(new Dimension(0, 24));
        login.setForeground(Color.WHITE);
        login.setBorder(new EmptyBorder(0, 8, 0, 0));
        bottomContainer.add((Component)login, "Center");
        this.add((Component)labelWrapper, "North");
        this.add((Component)bottomContainer, "Center");
    }

    static {
        BufferedImage deleteImg = ImageUtil.getResourceStreamFromClass(ProfilesPlugin.class, "net/runelite/client/plugins/profiles/delete_icon.png");
        DELETE_ICON = new ImageIcon(deleteImg);
        DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteImg, -100));
    }

}

