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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

    private GridLayout stats;

    private final HiscoreClient client = new HiscoreClient();

    public HiscorePanel(RuneLite runelite)
    {
        this.runelite = runelite;

        setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setVisible(true);

        input = new JTextField(11);
        add(input);

        input.addActionListener((ActionEvent e) ->
        {
            ScheduledExecutorService executor = runelite.getExecutor();
            executor.execute(this::lookup);
        });

        lookupButton = new JButton("Lookup");
        add(lookupButton);

        lookupButton.addActionListener((ActionEvent e) ->
        {
            ScheduledExecutorService executor = runelite.getExecutor();
            executor.execute(this::lookup);
        });

        JPanel statsPanel = new JPanel();
        stats = new GridLayout(8, 3);
        statsPanel.setLayout(stats);

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
            statsPanel.add(makeSkillPanel(Skill.OVERALL, overallLabel));
        }
        catch (IOException ex)
        {
            logger.warn(null, ex);
        }

        add(statsPanel);
    }

    private JPanel makeSkillPanel(Skill skill, JLabel levelLabel) throws IOException
    {
        JPanel iconLevel = new JPanel();

        String skillIcon = "/skill_icons/" + skill.getName().toLowerCase() + ".png";
        logger.debug("Loading skill icon from {}", skillIcon);

        JLabel icon = new JLabel(new ImageIcon(ImageIO.read(HiscorePanel.class.getResourceAsStream(skillIcon))));
        iconLevel.add(icon);

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

        HiscoreResult result;
        try
        {
            result = client.lookup(lookup);
        }
        catch (IOException ex)
        {
            logger.warn(null, ex);
            return;
        }

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
