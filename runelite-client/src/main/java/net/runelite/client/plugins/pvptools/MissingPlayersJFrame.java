/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.pvptools;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.runelite.api.Client;
import net.runelite.client.plugins.pvptools.PvpToolsPlugin;
import net.runelite.client.ui.FontManager;

public class MissingPlayersJFrame
extends JFrame {
    public JList missingPlayersJList;

    MissingPlayersJFrame(Client client, PvpToolsPlugin pvpToolsPlugin, List<String> list) {
        int x = client.getCanvas().getLocationOnScreen().x + client.getCanvas().getWidth();
        int y = client.getCanvas().getLocationOnScreen().y;
        JPanel scrollConatiner = new JPanel(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(scrollConatiner);
        JButton refreshJButton = new JButton("Refresh");
        refreshJButton.addActionListener(pvpToolsPlugin.playersButtonActionListener);
        JButton copyJButton = new JButton("Copy List");
        this.missingPlayersJList = new JList<Object>(list.toArray());
        ActionListener copyButtonActionListener = e -> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringBuilder stringBuilder = new StringBuilder();
            list.forEach(s -> {
                stringBuilder.append((String)s);
                stringBuilder.append(System.getProperty("line.separator"));
            });
            StringSelection stringSelection = new StringSelection(stringBuilder.toString());
            clipboard.setContents(stringSelection, stringSelection);
        };
        copyJButton.addActionListener(copyButtonActionListener);
        this.setTitle("Missing CC Members");
        this.setDefaultCloseOperation(2);
        JLabel titleLabel = new JLabel("Missing CC Members");
        titleLabel.setFont(FontManager.getRunescapeFont().deriveFont(1, 18.0f));
        this.missingPlayersJList.setFont(new Font("Arial", 0, 14));
        scrollConatiner.add((Component)refreshJButton, "North");
        scrollConatiner.add((Component)titleLabel, "Center");
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.add((Component)this.missingPlayersJList, "North");
        footerPanel.add((Component)copyJButton, "Center");
        scrollConatiner.add((Component)footerPanel, "South");
        this.add(jScrollPane);
        this.setLocation(x, y);
        this.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.pack();
        this.setVisible(true);
    }
}

