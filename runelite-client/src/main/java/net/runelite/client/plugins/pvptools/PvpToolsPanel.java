/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.pvptools;

import com.google.common.base.MoreObjects;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.inject.Inject;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.plugins.info.JRichTextPane;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PvpToolsPanel
extends PluginPanel {
    private static final Logger log = LoggerFactory.getLogger(PvpToolsPanel.class);
    private final JLabel loggedLabel = new JLabel();
    private final JRichTextPane emailLabel = new JRichTextPane();
    public JLabel numCC = new JLabel();
    public JLabel numOther = new JLabel();
    public JLabel numMageJLabel = new JLabel(" ");
    public JLabel numRangeJLabel = new JLabel(" ");
    public JLabel numMeleeJLabel = new JLabel(" ");
    public JLabel totalRiskLabel = new JLabel(" ");
    public JLabel riskProtectingItem = new JLabel(" ");
    public JLabel biggestItemLabel = new JLabel("Protected Item: ");
    public JButton missingPlayers = new JButton("Show missing CC members");
    public JButton currentPlayers = new JButton("Show current CC members");
    public JLabel numBrews = new JLabel();
    @Inject
    private JPanel pvpToolsPanel = new JPanel(new GridLayout(11, 1));
    private JPanel missingPlayersPanel = new JPanel();
    private JPanel currentPlayersPanel = new JPanel();

    public static String htmlLabel(String key, String value) {
        return "<html><body style = 'color:#a5a5a5'>" + key + "<span style = 'color:white'>" + value + "</span></body></html>";
    }

    void init() {
        this.setLayout(new BorderLayout());
        this.setBackground(ColorScheme.DARK_GRAY_COLOR);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel versionPanel = new JPanel();
        versionPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        versionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        versionPanel.setLayout(new GridLayout(0, 1));
        JPanel riskPanel = new JPanel();
        riskPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        riskPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        riskPanel.setLayout(new GridLayout(0, 1));
        Font smallFont = FontManager.getRunescapeSmallFont();
        this.numCC.setText(PvpToolsPanel.htmlLabel("Friendly Player Count: ", "0"));
        this.numOther.setText(PvpToolsPanel.htmlLabel("Other Player Count: ", "0"));
        this.numBrews.setText(PvpToolsPanel.htmlLabel("Player brew count: ", "0"));
        this.numMageJLabel.setText(PvpToolsPanel.htmlLabel("Enemies Praying Mage: ", "0"));
        this.numMageJLabel.setFont(FontManager.getRunescapeFont());
        this.numRangeJLabel.setText(PvpToolsPanel.htmlLabel("Enemies Praying Range: ", "0"));
        this.numRangeJLabel.setFont(FontManager.getRunescapeFont());
        this.numMeleeJLabel.setText(PvpToolsPanel.htmlLabel("Enemies Praying Melee: ", "0"));
        this.numMeleeJLabel.setFont(FontManager.getRunescapeFont());
        this.totalRiskLabel.setText(PvpToolsPanel.htmlLabel("Total risk: ", "0"));
        this.totalRiskLabel.setFont(FontManager.getRunescapeFont());
        this.riskProtectingItem.setText(PvpToolsPanel.htmlLabel("Risk Protecting Item: ", "0"));
        this.riskProtectingItem.setFont(FontManager.getRunescapeFont());
        this.biggestItemLabel.setText("Most Valuable Item: ");
        JLabel revision = new JLabel();
        revision.setFont(smallFont);
        revision.setText("Oldschool revision: ");
        JLabel launcher = new JLabel(PvpToolsPanel.htmlLabel("Launcher version: ", MoreObjects.firstNonNull(RuneLiteProperties.getLauncherVersion(), "Unknown")));
        launcher.setFont(smallFont);
        this.loggedLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        this.loggedLabel.setFont(smallFont);
        this.emailLabel.setForeground(Color.WHITE);
        this.emailLabel.setFont(smallFont);
        versionPanel.add(this.numCC);
        versionPanel.add(this.numOther);
        versionPanel.add(this.numBrews);
        versionPanel.add(this.numMageJLabel);
        versionPanel.add(this.numRangeJLabel);
        versionPanel.add(this.numMeleeJLabel);
        versionPanel.add(Box.createGlue());
        versionPanel.add(this.loggedLabel);
        versionPanel.add(this.emailLabel);
        riskPanel.add(this.totalRiskLabel);
        riskPanel.add(this.riskProtectingItem);
        riskPanel.add(this.biggestItemLabel);
        this.add((Component)versionPanel, "North");
        this.add((Component)riskPanel, "Center");
        this.currentPlayers.setVisible(false);
        this.missingPlayers.setVisible(false);
        this.missingPlayersPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        this.missingPlayersPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.missingPlayersPanel.setLayout(new GridLayout(0, 1));
        this.missingPlayersPanel.add((Component)this.missingPlayers, "Last");
        this.missingPlayersPanel.add((Component)this.currentPlayers, "Last");
        this.add((Component)this.missingPlayersPanel, "Last");
    }

    public void disablePlayerCount() {
        this.numOther.setText("Disabled");
        this.numCC.setText("Disabled");
        this.numCC.repaint();
        this.numOther.repaint();
    }

    public void disablePrayerCount() {
        this.numMageJLabel.setText("disabled");
        this.numRangeJLabel.setText("disabled");
        this.numMeleeJLabel.setText("disabled");
        this.numMageJLabel.repaint();
        this.numRangeJLabel.repaint();
        this.numMeleeJLabel.repaint();
    }

    public void disableRiskCalculator() {
        this.totalRiskLabel.setText("disabled");
        this.riskProtectingItem.setText("disabled");
        this.biggestItemLabel.setText("disabled");
        this.totalRiskLabel.repaint();
        this.riskProtectingItem.repaint();
        this.biggestItemLabel.repaint();
    }
}

