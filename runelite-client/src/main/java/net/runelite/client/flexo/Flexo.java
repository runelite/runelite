/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

/*
Modified java.awt.Robot for use with RuneLitePlus. Hopefully we can make it stand far apart.
Uses
https://github.com/JoonasVali/NaturalMouseMotion
for mouse motion.
 */

package net.runelite.client.flexo;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import net.runelite.api.Client;
import net.runelite.client.ui.ClientUI;
import sun.awt.ComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.peer.RobotPeer;
import java.util.Random;
import java.util.logging.Logger;

public class Flexo extends Robot {
  public ThreadGroup flexoThreads = new ThreadGroup("flexo");
  public static boolean isActive;
  public static double scale;
  public static Client client;
  public static int fixedWidth = 765;
  public static int fixedHeight = 503;
  public static boolean isStretched;
  public static int minDelay = 45;
  public static MouseMotionFactory currentMouseMotionFactory;
  public boolean pausedIndefinitely = false;
  private Thread holdKeyThread;
  private RobotPeer peer;

  public Flexo() throws AWTException {
    if (GraphicsEnvironment.isHeadless()) {
      throw new AWTException("headless environment");
    }
    init(GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice());
  }

  private void init(GraphicsDevice screen) throws AWTException {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    if (toolkit instanceof ComponentFactory) {
      peer = ((ComponentFactory)toolkit).createRobot(this, screen);
        RobotDisposer disposer = new RobotDisposer(peer);
      sun.java2d.Disposer.addRecord(anchor, disposer);
    }
  }

  private transient Object anchor = new Object();

  static class RobotDisposer implements sun.java2d.DisposerRecord {
    private final RobotPeer peer;
    private RobotDisposer(RobotPeer peer) {
      this.peer = peer;
    }
    public void dispose() {
      if (peer != null) {
        peer.dispose();
      }
    }
  }

  private void pauseMS(int delayMS) {
    long initialMS = System.currentTimeMillis();
    while (System.currentTimeMillis()<initialMS+delayMS) {
      try {
        Thread.sleep(10);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    isActive = false;
  }

  @Override
  public synchronized void mouseMove(int x, int y) {
    try {
      //TODO: Must be better way to determine titlebar width
      currentMouseMotionFactory.build(ClientUI.frame.getX()+x, ClientUI.frame.getY()+y+20).move();
      this.delay(getMinDelay());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized void mouseMove(Point p) {
    Point p2 = p;
    mouseMove((int)p.getX(), (int)p.getY());
    try {
      Thread.sleep(150);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public synchronized void mousePress(int buttonID) {
    if (buttonID<1 || buttonID >5) {
      Logger.getAnonymousLogger().warning("Invalid mouse button ID. please use 1-5.");
      return;
    }
    peer.mousePress(InputEvent.getMaskForButton(buttonID));
    this.delay(getMinDelay());
  }

  public synchronized void mousePressAndRelease(int buttonID) {
    if (buttonID<1 || buttonID >5) {
      Logger.getAnonymousLogger().warning("Invalid mouse button ID. please use 1-5.");
      return;
    }
    peer.mousePress(InputEvent.getMaskForButton(buttonID));
    this.delay(getMinDelay());
    peer.mouseRelease(InputEvent.getMaskForButton(buttonID));
    this.delay(getMinDelay());
  }

  //TODO: Symbols are nut supported at this time
  public synchronized void typeMessage(String message) {

      Random r = new Random();
      char[] charArray = message.toCharArray();
      for (char c : charArray) {
          keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
          this.delay(93+r.nextInt(getMinDelay()));
      }
      keyPress(KeyEvent.VK_ENTER);
      this.delay(93+r.nextInt(getMinDelay()));
      ClientUI.allowInput = true;
  }



  @Override
  public synchronized void mouseRelease(int buttonID) {
    if (buttonID<1 || buttonID >5) {
      Logger.getAnonymousLogger().warning("Invalid mouse button ID. please use 1-5.");
      return;
    }
    peer.mouseRelease(InputEvent.getMaskForButton(buttonID));
    this.delay(getMinDelay());
  }

  private int getMinDelay() {
    Random random = new Random();
    int random1 = random.nextInt(minDelay);
    if (random1 < minDelay/2)
      random1 = random.nextInt(minDelay/2) + minDelay/2+random.nextInt(minDelay/2);
    return random1;
  }

  private int getWheelDelay() {
    Random random = new Random();
    int random1 = random.nextInt(minDelay);
    if (random1 < minDelay/2)
      random1 = random.nextInt(minDelay/2) + minDelay/2+random.nextInt(minDelay/2);
    return random1;
  }

  /**
   * Rotates the scroll wheel on wheel-equipped mice.
   *
   * @param wheelAmt  number of "notches" to move the mouse wheel
   *                  Negative values indicate movement up/away from the user,
   *                  positive values indicate movement down/towards the user.
   *
   * @since 1.4
   */
  @Override
  public synchronized void mouseWheel(int wheelAmt) {
    for (int i : new int[wheelAmt]) {
      peer.mouseWheel(wheelAmt);
      this.delay(getWheelDelay());
    }
  }

  /**
   * Presses a given key.  The key should be released using the
   * <code>keyRelease</code> method.
   * <p>
   * Key codes that have more than one physical key associated with them
   * (e.g. <code>KeyEvent.VK_SHIFT</code> could mean either the
   * left or right shift key) will map to the left key.
   *
   * @param   keycode Key to press (e.g. <code>KeyEvent.VK_A</code>)
   * @throws  IllegalArgumentException if <code>keycode</code> is not
   *          a valid key
   * @see     #keyRelease(int)
   * @see     java.awt.event.KeyEvent
   */
  @Override
  public synchronized void keyPress(int keycode) {
    peer.keyPress(keycode);
    this.delay(getMinDelay());
  }

  @Override
  public synchronized void keyRelease(int keycode) {
    peer.keyRelease(keycode);
    this.delay(getMinDelay());
  }

  public synchronized void holdKey(int keycode, int timeMS) {
    new Thread(() -> {
      peer.keyPress(keycode);
      long startTime = System.currentTimeMillis();
      while ((startTime + timeMS) > System.currentTimeMillis()) { }
      peer.keyRelease(keycode);
      this.delay(getMinDelay());
    }).start();
  }

  public synchronized void holdKeyIndefinitely(int keycode) {
    holdKeyThread = new Thread(() -> {
      pausedIndefinitely = true;
      peer.keyPress(keycode);
      while (pausedIndefinitely) {
        try {
          holdKeyThread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      peer.keyRelease(keycode);
      this.delay(getMinDelay());
    });
    holdKeyThread.start();

  }

  @Override
  public Color getPixelColor(int x, int y) {
    Color color = new Color(peer.getRGBPixel(x, y));
    return color;
  }

  @Override
  public void delay(int ms) {
    pauseMS(ms);
  }

}
