package net.runelite.client.plugins.fancyflip.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.runelite.client.ui.PluginPanel;

public class FancyFlipPanel extends PluginPanel
{
    private final JLabel profit = new JLabel("Profit: 0 gp");
    private final JLabel roi = new JLabel("ROI: 0.00%");
    private final JLabel flips = new JLabel("Flips made: 0");
    private final JLabel tax = new JLabel("Tax paid: 0 gp");
    private final JLabel sessionTime = new JLabel("Session time: 00:00:00");
    private final JLabel hourly = new JLabel("Hourly profit: 0 gp/hr");

    private final JLabel currentWealth = new JLabel("Current wealth: 0 gp");

    private final JLabel avgWealth = new JLabel("Avg wealth: 0 gp");

    private final JCheckBox sellOnly = new JCheckBox("Sell only");
    private final JCheckBox f2pOnly = new JCheckBox("F2P only");
    private final JTextField blocklist = new JTextField();

    private final JButton copyPrice = new JButton("Copy Price");
    private final JButton resetSession = new JButton("Reset Session");

    public FancyFlipPanel()
    {
        setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(0, 1));

        top.add(profit);
        top.add(roi);
        top.add(flips);
        top.add(tax);
        top.add(sessionTime);
        top.add(hourly);
        top.add(currentWealth);
        top.add(avgWealth);
        top.add(sellOnly);
        top.add(f2pOnly);
        top.add(new JLabel("Blocklist CSV:"));
        top.add(blocklist);
        top.add(resetSession);
        top.add(copyPrice);

        add(top, BorderLayout.NORTH);
    }

    // KPI setters
    public void setProfit(long gp)      { profit.setText("Profit: " + gp + " gp"); }
    public void setRoi(double pct)      { roi.setText(String.format("ROI: %.2f%%", pct)); }
    public void setFlips(int n)         { flips.setText("Flips made: " + n); }
    public void setTax(long gp)         { tax.setText("Tax paid: " + gp + " gp"); }
    public void setSessionTime(String t){ sessionTime.setText("Session time: " + t); }
    public void setHourly(long gpHr)    { hourly.setText("Hourly profit: " + gpHr + " gp/hr"); }
    public void setCurrentWealth(long gp) { currentWealth.setText("Current wealth: " + gp + " gp"); }
    public void setAvgWealth(long gp)   { avgWealth.setText("Avg wealth: " + gp + " gp"); }

    // Toggle and blocklist accessors
    public boolean isSellOnly() { return sellOnly.isSelected(); }
    public void setSellOnly(boolean v) { sellOnly.setSelected(v); }
    public void addSellOnlyListener(ActionListener l) { sellOnly.addActionListener(l); }

    public boolean isF2pOnly() { return f2pOnly.isSelected(); }
    public void setF2pOnly(boolean v) { f2pOnly.setSelected(v); }
    public void addF2pOnlyListener(ActionListener l) { f2pOnly.addActionListener(l); }

    public String getBlocklistCsv() { return blocklist.getText(); }
    public void setBlocklistCsv(String csv) { blocklist.setText(csv); }
    public void addBlocklistListener(Runnable r)
    {
        DocumentListener dl = new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) { r.run(); }
            @Override
            public void removeUpdate(DocumentEvent e) { r.run(); }
            @Override
            public void changedUpdate(DocumentEvent e) { r.run(); }
        };
        blocklist.getDocument().addDocumentListener(dl);
    }

    public void addResetListener(Runnable r) { resetSession.addActionListener(e -> r.run()); }
}

