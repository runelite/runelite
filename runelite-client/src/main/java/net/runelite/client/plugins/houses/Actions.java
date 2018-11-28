package net.runelite.client.plugins.houses;

import lombok.extern.slf4j.Slf4j;
import java.awt.event.*;

@Slf4j
public class Actions implements ActionListener, FocusListener, KeyListener
{
    private boolean controlDown;
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equalsIgnoreCase("clear")) {
        HousesPanel.RimmListModel.clear();
        HousesPanel.YanListModel.clear();
    } else if (e.getActionCommand().equalsIgnoreCase("refresh")) {
        new HousesPanel().updateHosts();
    }
}
@Override
public void focusGained(FocusEvent e) {
    if (e.getSource().equals(HousesPanel.YanList) && !controlDown) {
        HousesPanel.RimmList.clearSelection();
    } else if (e.getSource().equals(HousesPanel.RimmList) && !controlDown) {
        HousesPanel.YanList.clearSelection();
    }
}
@Override
    public void focusLost(FocusEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
            controlDown=e.isControlDown();
    }
    @Override
    public void keyReleased(KeyEvent e) {
            controlDown = e.isControlDown();
    }
}
