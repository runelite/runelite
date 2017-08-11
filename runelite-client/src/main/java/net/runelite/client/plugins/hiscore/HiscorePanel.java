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
package net.runelite.client.plugins.hiscore;

import com.google.common.base.Strings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.MouseInputAdapter;

import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.PluginPanel;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiscorePanel extends PluginPanel
{
    private static final Logger logger = LoggerFactory.getLogger(HiscorePanel.class);

    private final RuneLite runelite;

    private JTextField input;
    private JButton lookupButton;

    //these are inlaid left to right, wrapping to a new line after 3
    private final JLabel attackLabel = new JLabel("--");
    private final JLabel hitpointsLabel = new JLabel("--");
    private final JLabel miningLabel = new JLabel("--");
    private final JLabel strengthLabel = new JLabel("--");
    private final JLabel agilityLabel = new JLabel("--");
    private final JLabel smithingLabel = new JLabel("--");
    private final JLabel defenceLabel = new JLabel("--");
    private final JLabel herbloreLabel = new JLabel("--");
    private final JLabel fishingLabel = new JLabel("--");
    private final JLabel rangedLabel = new JLabel("--");
    private final JLabel thievingLabel = new JLabel("--");
    private final JLabel cookingLabel = new JLabel("--");
    private final JLabel prayerLabel = new JLabel("--");
    private final JLabel craftingLabel = new JLabel("--");
    private final JLabel firemakingLabel = new JLabel("--");
    private final JLabel magicLabel = new JLabel("--");
    private final JLabel fletchingLabel = new JLabel("--");
    private final JLabel woodcuttingLabel = new JLabel("--");
    private final JLabel runecraftLabel = new JLabel("--");
    private final JLabel slayerLabel = new JLabel("--");
    private final JLabel farmingLabel = new JLabel("--");
    private final JLabel constructionLabel = new JLabel("--");
    private final JLabel hunterLabel = new JLabel("--");
    private final JLabel overallLabel = new JLabel("--");
    private final JLabel combatLabel = new JLabel("--");

    private final JTextArea details = new JTextArea();

    private final HiscoreClient client = new HiscoreClient();
    private HiscoreResult result;
    private CombatLevel combatLevel;

    public HiscorePanel(RuneLite runelite)
    {
        this.runelite = runelite;

        // Panel "constants"
        Border subPanelBorder = new EtchedBorder(EtchedBorder.LOWERED);
        Insets subPanelInsets = new Insets(2, 4, 2, 4);

        // Setting base panel size
        Dimension panelSize = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setMinimumSize(panelSize);
        setPreferredSize(panelSize);
        setSize(panelSize);
        setVisible(true);

        // Create GBL to arrange sub items
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        // Expand sub items to fit width of panel, align to top of panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;

        // Text box and submit button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(7, 7));
        inputPanel.setBorder(subPanelBorder);
        input = new JTextField();
        input.addActionListener((ActionEvent e) ->
        {
            ScheduledExecutorService executor = runelite.getExecutor();
            executor.execute(this::lookup);
        });
        inputPanel.add(input, BorderLayout.CENTER);

        lookupButton = new JButton("Lookup");
        inputPanel.add(lookupButton, BorderLayout.LINE_END);

        lookupButton.addActionListener((ActionEvent e) ->
        {
            ScheduledExecutorService executor = runelite.getExecutor();
            executor.execute(this::lookup);
        });

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        c.insets = subPanelInsets;
        gridBag.setConstraints(inputPanel, c);
        add(inputPanel);

        // Panel that holds skill icons
        JPanel statsPanel = new JPanel();
        GridLayout stats = new GridLayout(8, 3);
        statsPanel.setLayout(stats);
        statsPanel.setBorder(subPanelBorder);

        try
        {
            //these are inlaid left to right, wrapping to a new line after 3
            statsPanel.add(makeSkillPanel(Skill.ATTACK, attackLabel));
            statsPanel.add(makeSkillPanel(Skill.HITPOINTS, hitpointsLabel));
            statsPanel.add(makeSkillPanel(Skill.MINING, miningLabel));
            statsPanel.add(makeSkillPanel(Skill.STRENGTH, strengthLabel));
            statsPanel.add(makeSkillPanel(Skill.AGILITY, agilityLabel));
            statsPanel.add(makeSkillPanel(Skill.SMITHING, smithingLabel));
            statsPanel.add(makeSkillPanel(Skill.DEFENCE, defenceLabel));
            statsPanel.add(makeSkillPanel(Skill.HERBLORE, herbloreLabel));
            statsPanel.add(makeSkillPanel(Skill.FISHING, fishingLabel));
            statsPanel.add(makeSkillPanel(Skill.RANGED, rangedLabel));
            statsPanel.add(makeSkillPanel(Skill.THIEVING, thievingLabel));
            statsPanel.add(makeSkillPanel(Skill.COOKING, cookingLabel));
            statsPanel.add(makeSkillPanel(Skill.PRAYER, prayerLabel));
            statsPanel.add(makeSkillPanel(Skill.CRAFTING, craftingLabel));
            statsPanel.add(makeSkillPanel(Skill.FIREMAKING, firemakingLabel));
            statsPanel.add(makeSkillPanel(Skill.MAGIC, magicLabel));
            statsPanel.add(makeSkillPanel(Skill.FLETCHING, fletchingLabel));
            statsPanel.add(makeSkillPanel(Skill.WOODCUTTING, woodcuttingLabel));
            statsPanel.add(makeSkillPanel(Skill.RUNECRAFT, runecraftLabel));
            statsPanel.add(makeSkillPanel(Skill.SLAYER, slayerLabel));
            statsPanel.add(makeSkillPanel(Skill.FARMING, farmingLabel));
            statsPanel.add(makeSkillPanel(Skill.CONSTRUCTION, constructionLabel));
            statsPanel.add(makeSkillPanel(Skill.HUNTER, hunterLabel));
        }
        catch (IOException ex)
        {
            logger.warn(null, ex);
        }

        c.gridx = 0;
        c.gridy = 1;
        gridBag.setConstraints(statsPanel, c);
        add(statsPanel);

        JPanel totalPanel = new JPanel();
        totalPanel.setBorder(subPanelBorder);
        totalPanel.setLayout(new GridLayout(1, 2));
        try
        {
            totalPanel.add(makeSkillPanel(Skill.OVERALL, overallLabel));
            totalPanel.add(makeSkillPanel("Combat", combatLabel));
        }
        catch (IOException ex)
        {
            logger.warn(null, ex);
        }

        c.gridx = 0;
        c.gridy = 2;
        gridBag.setConstraints(totalPanel, c);
        add(totalPanel);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setBorder(subPanelBorder);
        detailsPanel.setLayout(new BorderLayout());

        // Rather than using one JLabel for each line, make a JTextArea look and act like a JLabel
        details.setEditable(false);
        details.setCursor(null);
        details.setOpaque(false);
        details.setFocusable(false);
        details.setFont(UIManager.getFont("Label.font"));
        details.setWrapStyleWord(true);
        details.setLineWrap(true);
        details.setMargin(new Insets(2, 4, 4, 4));
        details.setRows(4);
        details.setText("");

        detailsPanel.add(details, BorderLayout.CENTER);

        c.gridx = 0;
        c.gridy = 3;
        // Last item has a nonzero weighty so it will expand to fill vertical space
        c.weighty = 1;
        gridBag.setConstraints(detailsPanel, c);
        add(detailsPanel);
    }

    private void changeDetail(String skillName, net.runelite.http.api.hiscore.Skill skill)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        String text;
        switch (skillName)
        {
            case "Overall":
                text = "Total Level" + System.lineSeparator() +
                        "Rank: " + formatter.format(skill.getRank()) + System.lineSeparator() +
                        "Total Experience: " + formatter.format(skill.getExperience());
                break;
            case "Combat":
                text = "Exact Combat Level: " + formatter.format(combatLevel.getPreciseCombatLevel()) + System.lineSeparator() +
                        "Experience: " + formatter.format(result.getAttack().getExperience() +
                        result.getStrength().getExperience() + result.getDefence().getExperience() +
                        result.getHitpoints().getExperience() + result.getMagic().getExperience() +
                        result.getRanged().getExperience() + result.getPrayer().getExperience());
                break;
            default:
                text = "Skill: " + skillName + System.lineSeparator() +
                        "Rank: " + formatter.format(skill.getRank()) + System.lineSeparator() +
                        "Experience: " + formatter.format(skill.getExperience());
                break;
        }

        details.setText(text);
    }

    private JPanel makeSkillPanel(Skill skill, JLabel levelLabel) throws IOException
    {
        return makeSkillPanel(skill.getName(), levelLabel);
    }

    private JPanel makeSkillPanel(String skillName, JLabel levelLabel) throws IOException
    {
        JPanel iconLevel = new JPanel();

        String skillIcon = "/skill_icons/" + skillName.toLowerCase() + ".png";
        logger.debug("Loading skill icon from {}", skillIcon);

        levelLabel.setIcon(new ImageIcon(ImageIO.read(HiscorePanel.class.getResourceAsStream(skillIcon))));
        levelLabel.addMouseListener(new MouseInputAdapter()
        {
            // mouseReleased feels better than mouseClick UX-wise
            @Override
            public void mouseReleased(MouseEvent e)
            {
                JLabel source = (JLabel) e.getSource();
                String skillName = (String) source.getClientProperty("skillName");
                showSkillDetail(skillName);
            }
        });
        levelLabel.putClientProperty("skillName", skillName);
        iconLevel.add(levelLabel);

        return iconLevel;
    }

    public void lookup(String username)
    {
        input.setText(username);
        lookup();
    }

    private void lookup()
    {
        String lookup = input.getText();

        lookup = sanitize(lookup);

        if (Strings.isNullOrEmpty(lookup))
        {
            return;
        }

        try
        {
            result = client.lookup(lookup);
        }
        catch (IOException ex)
        {
            logger.warn(null, ex);
            return;
        }

        combatLevel = new CombatLevel(result);

        setLabel(attackLabel, result.getAttack());
        setLabel(defenceLabel, result.getDefence());
        setLabel(strengthLabel, result.getStrength());
        setLabel(hitpointsLabel, result.getHitpoints());
        setLabel(rangedLabel, result.getRanged());
        setLabel(prayerLabel, result.getPrayer());
        setLabel(magicLabel, result.getMagic());
        setLabel(cookingLabel, result.getCooking());
        setLabel(woodcuttingLabel, result.getWoodcutting());
        setLabel(fletchingLabel, result.getFletching());
        setLabel(fishingLabel, result.getFishing());
        setLabel(firemakingLabel, result.getFiremaking());
        setLabel(craftingLabel, result.getCrafting());
        setLabel(smithingLabel, result.getSmithing());
        setLabel(miningLabel, result.getMining());
        setLabel(herbloreLabel, result.getHerblore());
        setLabel(agilityLabel, result.getAgility());
        setLabel(thievingLabel, result.getThieving());
        setLabel(slayerLabel, result.getSlayer());
        setLabel(farmingLabel, result.getFarming());
        setLabel(runecraftLabel, result.getRunecraft());
        setLabel(hunterLabel, result.getHunter());
        setLabel(constructionLabel, result.getConstruction());
        setLabel(overallLabel, result.getOverall());

        // Special case for combat label, for now
        combatLabel.setText(Integer.toString(combatLevel.getCombatLevel()));

        // Clear details panel
        details.setText("");
    }

    private void showSkillDetail(String skillName)
    {
        if (result == null)
            return;

        // This SUCKS. Hope to refactor after implementing combat level display
        switch (skillName)
        {
            case "Attack":
                changeDetail(skillName, result.getAttack());
                break;
            case "Defense":
                changeDetail(skillName, result.getDefence());
                break;
            case "Strength":
                changeDetail(skillName, result.getStrength());
                break;
            case "Hitpoints":
                changeDetail(skillName, result.getHitpoints());
                break;
            case "Ranged":
                changeDetail(skillName, result.getRanged());
                break;
            case "Prayer":
                changeDetail(skillName, result.getPrayer());
                break;
            case "Magic":
                changeDetail(skillName, result.getMagic());
                break;
            case "Cooking":
                changeDetail(skillName, result.getCooking());
                break;
            case "Woodcutting":
                changeDetail(skillName, result.getWoodcutting());
                break;
            case "Fletching":
                changeDetail(skillName, result.getFletching());
                break;
            case "Fishing":
                changeDetail(skillName, result.getFishing());
                break;
            case "Firemaking":
                changeDetail(skillName, result.getFiremaking());
                break;
            case "Crafting":
                changeDetail(skillName, result.getCrafting());
                break;
            case "Smithing":
                changeDetail(skillName, result.getSmithing());
                break;
            case "Herblore":
                changeDetail(skillName, result.getMining());
                break;
            case "Agility":
                changeDetail(skillName, result.getAgility());
                break;
            case "Thieving":
                changeDetail(skillName, result.getThieving());
                break;
            case "Slayer":
                changeDetail(skillName, result.getSlayer());
                break;
            case "Farming":
                changeDetail(skillName, result.getFarming());
                break;
            case "Runecraft":
                changeDetail(skillName, result.getRunecraft());
                break;
            case "Hunter":
                changeDetail(skillName, result.getHunter());
                break;
            case "Construction":
                changeDetail(skillName, result.getConstruction());
                break;
            case "Overall":
                changeDetail(skillName, result.getOverall());
                break;
            case "Combat":
                changeDetail("Combat", null);
                break;
        }
    }

    private void setLabel(JLabel label, net.runelite.http.api.hiscore.Skill skill)
    {
        label.setText("" + skill.getLevel());
    }

    private static String sanitize(String lookup)
    {
        return lookup.replace('\u00A0', ' ');
    }
}
