package net.runelite.client.plugins.autoaccount;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.game.WorldService;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.defaultworld.DefaultWorldPlugin;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ENTER;

@PluginDescriptor(
    name = "Auto login",
    description = "Allows you to auto login via CLI args"
)
@Slf4j
public class AutoAccountPlugin extends Plugin implements KeyListener {

  @Inject
  @Named("username")
  private String username;

  @Inject
  @Named("password")
  private String password;

  @Inject
  @Named("world")
  private String world;

  @Inject
  private Client client;

  @Inject
  private WorldService worldService;

  @Inject
  private KeyManager keyManager;

  private boolean loggedIn;

  @Override
  protected void startUp() throws Exception
  {
    keyManager.registerKeyListener(this);
  }

  @Override
  protected void shutDown() throws Exception
  {
    keyManager.unregisterKeyListener(this);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public boolean isEnabledOnLoginScreen()
  {
    return true;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (client.getGameState() != GameState.LOGIN_SCREEN || e.getKeyCode() != VK_ENTER) {
      return;
    }

    if (StringUtils.isNotEmpty(username)) {
      client.setUsername(username);
    }

    if (StringUtils.isNotEmpty(password)) {
      client.setPassword(password);
    }

    if (StringUtils.isNotEmpty(world)) {
      int newWorld = Integer.parseInt(world);
      if (newWorld != client.getWorld()) {
        DefaultWorldPlugin.changeWorld(newWorld, client, worldService);
      }

    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
