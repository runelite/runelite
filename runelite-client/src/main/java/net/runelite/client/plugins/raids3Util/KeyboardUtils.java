package net.runelite.client.plugins.raids3Util;

import com.google.inject.Inject;
import java.awt.event.KeyEvent;
import javax.inject.Singleton;
import net.runelite.api.Client;

@Singleton
public class KeyboardUtils {
  @Inject
  private Client client;

  public void typeString(String string) {
    assert !this.client.isClientThread();

    char[] var2 = string.toCharArray();
    int var3 = var2.length;

    for(int var4 = 0; var4 < var3; ++var4) {
      char c = var2[var4];
      this.pressKey(c);
    }

  }

  public void pressKey(char key) {
    this.keyEvent(401, (char)key);
    this.keyEvent(402, (char)key);
    this.keyEvent(400, (char)key);
  }

  public void pressKey(int key) {
    this.keyEvent(401, (int)key);
    this.keyEvent(402, (int)key);
  }

  private void keyEvent(int id, char key) {
    KeyEvent e = new KeyEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, 0, key);
    this.client.getCanvas().dispatchEvent(e);
  }

  private void keyEvent(int id, int key) {
    KeyEvent e = new KeyEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, key, '\uffff');
    this.client.getCanvas().dispatchEvent(e);
  }
}