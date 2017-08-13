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
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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

    private List<JLabel> skillLabels = new LinkedList<>();

    private final JPanel statsPanel = new JPanel();
    private final JTextArea details = new JTextArea();

    private final HiscoreClient client = new HiscoreClient();
    private HiscoreResult result;
    private CombatLevel combatLevel;

    public HiscorePanel(RuneLite runelite)
    {
        this.runelite = runelite;

        // Panel "constants"
        // This was an EtchedBorder, but the style would change when the window was maximized.
        Border subPanelBorder = BorderFactory.createLineBorder(this.getBackground().brighter(), 2);
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
        GridLayout stats = new GridLayout(8, 3);
        statsPanel.setLayout(stats);
        statsPanel.setBorder(subPanelBorder);

        // For each skill in the Skill enum, create a Label and add it to the UI
        for (Skill skill : Skill.values())
        {
            // We'll create the Total Level label below since it goes in a different subpanel
            if (!(skill == Skill.OVERALL))
            {
                statsPanel.add(makeSkillPanel(skill.getName()));
            }
        }

        c.gridx = 0;
        c.gridy = 1;
        gridBag.setConstraints(statsPanel, c);
        add(statsPanel);

        JPanel totalPanel = new JPanel();
        totalPanel.setBorder(subPanelBorder);
        totalPanel.setLayout(new GridLayout(1, 2));

        totalPanel.add(makeSkillPanel(Skill.OVERALL.getName()));
        totalPanel.add(makeSkillPanel("Combat"));

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

    private void changeDetail(String skillName)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        net.runelite.http.api.hiscore.Skill requestedSkill = result.getSkill(skillName);

        String text;
        switch (skillName)
        {
            case "Overall":
                text = "Total Level" + System.lineSeparator() +
                        "Rank: " + formatter.format(requestedSkill.getRank()) + System.lineSeparator() +
                        "Total Experience: " + formatter.format(requestedSkill.getExperience());
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
                        "Rank: " + formatter.format(requestedSkill.getRank()) + System.lineSeparator() +
                        "Experience: " + formatter.format(requestedSkill.getExperience());
                break;
        }

        details.setText(text);
    }

    private JPanel makeSkillPanel(String skillName)
    {
        JLabel label = new JLabel();
        label.setText("--");
        // Store the skill that the label displays so we can tell them apart
        label.putClientProperty("skillName", skillName);

        String skillIcon = "/skill_icons/" + skillName.toLowerCase() + ".png";
        logger.debug("Loading skill icon from {}", skillIcon);

        try
        {
            label.setIcon(new ImageIcon(ImageIO.read(HiscorePanel.class.getResourceAsStream(skillIcon))));
        }
        catch (IOException ex)
        {
            logger.warn(null, ex);
        }

        // Show skill details on click
        label.addMouseListener(new MouseInputAdapter()
        {
            // mouseReleased feels better than mouseClick UX-wise
            @Override
            public void mouseReleased(MouseEvent e)
            {
                JLabel source = (JLabel) e.getSource();
                String skillName = (String) source.getClientProperty("skillName");
                changeDetail(skillName);
            }
        });
        skillLabels.add(label);

        JPanel skillPanel = new JPanel();
        skillPanel.add(skillLabels.get(skillLabels.size() - 1));
        return skillPanel;
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

        for (JLabel label : skillLabels)
        {
            String skillName = (String) label.getClientProperty("skillName");

            if (skillName.equals("Combat"))
            {
                label.setText(Integer.toString(combatLevel.getCombatLevel()));
            }
            else
            {
                label.setText(Integer.toString(result.getSkill(skillName).getLevel()));
            }
        }

        // Clear details panel
        details.setText("");
    }

    private void setLabel(Skill skillName, net.runelite.http.api.hiscore.Skill skill)
    {
        for (JLabel label : skillLabels)
        {
            if (label.getClientProperty("skillName").equals(skillName.getName()))
            {
                label.setText("" + skill.getLevel());
                break;
            }
        }
    }

    private static String sanitize(String lookup)
    {
        return lookup.replace('\u00A0', ' ');
    }
}
