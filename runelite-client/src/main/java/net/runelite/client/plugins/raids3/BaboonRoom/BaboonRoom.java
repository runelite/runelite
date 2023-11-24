package net.runelite.client.plugins.raids3.BaboonRoom;

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Timer;

public class BaboonRoom {
  Client client;
  Raids3Plugin raids3Plugin;
  public int redSkullGameTick = -1;
  int ventOrPillar = -1;
  final int VENT = 0;
  final int PILLAR = 1;
  private Timer prayerTimer = new Timer(150, 450);

  public BaboonRoom(Client client, Raids3Plugin raids3Plugin) {
    this.client = client;
    this.raids3Plugin = raids3Plugin;
  }

  public void HandleBaboonRedSkull(Point point) {
    this.redSkullGameTick = 0;
    if (point.getX() != 56 && point.getX() != 72 || point.getY() != 44 && point.getY() != 52) {
      this.ventOrPillar = 1;
    } else {
      this.ventOrPillar = 0;
    }

  }

  public void onGameTick() {
    if (this.redSkullGameTick != -1) {
      ++this.redSkullGameTick;
    }

  }

  public void onChatMessage(String message) {
    if (message.contains("You repair the damaged roof support.")) {
      this.redSkullGameTick = -1;
    } else if (message.contains("issue with with roof support.")) {
      this.redSkullGameTick = 0;
    } else if (message.contains("sense some strange fumes")) {
      this.redSkullGameTick = 0;
    } else if (message.contains("neutralise the fumes")) {
      this.redSkullGameTick = -1;
    } else if (message.contains("fumes filling the room")) {
      this.redSkullGameTick = -1;
    } else if (message.contains("debris to fall on you")) {
      this.redSkullGameTick = -1;
    }

  }
}