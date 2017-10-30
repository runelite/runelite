package net.runelite.client.plugins.grandexchange;

import javax.imageio.ImageIO;
import javax.swing.*;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

/**
 * @author Robbie, created on 29/10/2017 09:59 AM
 */
@PluginDescriptor(name = "Grand Exchange offer plugin")
public class GrandExchangePlugin extends Plugin
{

  private ImageIcon icon;
  private NavigationButton button;

  private RuneLite runelite;
  private ClientUI ui;

  @Override
  protected void startUp() throws Exception
  {
    runelite = RuneLite.getRunelite();
    ui = runelite.getGui();

    button = new NavigationButton("GE Offers", this::doPanel);
    icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("ge_icon.png")));
    button.getButton().setIcon(icon);

    ui.getPluginToolbar().addNavigation(button);
  }

  @Override
  protected void shutDown() throws Exception
  {

  }

  private GrandExchangePanel doPanel()
  {
    GrandExchangePanel panel = GrandExchangePanel.getInstance();
    panel.init();
    return panel;
  }


}
