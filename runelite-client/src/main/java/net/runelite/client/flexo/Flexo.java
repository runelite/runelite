/*
 * Copyright (c) 1999, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
Modified java.awt.Robot for use with RuneLit. Hopefully we can make it stand far apart.
Uses
https://github.com/JoonasVali/NaturalMouseMotion
for mouse motion.
 */

package net.runelite.client.flexo;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.DirectColorModel;
import java.awt.peer.RobotPeer;
import java.util.Random;
import java.util.logging.Logger;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import sun.awt.ComponentFactory;
import sun.awt.SunToolkit;

/**
 * This class is used to generate native system input events
 * for the purposes of test automation, self-running demos, and
 * other applications where control of the mouse and keyboard
 * is needed. The primary purpose of Robot is to facilitate
 * automated testing of Java platform implementations.
 * <p>
 * Using the class to generate input events differs from posting
 * events to the AWT event queue or AWT components in that the
 * events are generated in the platform's native input
 * queue. For example, <code>Robot.mouseMove</code> will actually move
 * the mouse cursor instead of just generating mouse move events.
 * <p>
 * Note that some platforms require special privileges or extensions
 * to access low-level input control. If the current platform configuration
 * does not allow input control, an <code>AWTException</code> will be thrown
 * when trying to construct Robot objects. For example, X-Window systems
 * will throw the exception if the XTEST 2.2 standard extension is not supported
 * (or not enabled) by the X server.
 * <p>
 * Applications that use Robot for purposes other than self-testing should
 * handle these error conditions gracefully.
 *
 * @author      Robi Khan
 * @since       1.3
 */
public class Flexo extends java.awt.Robot{
  public static int minDelay = 45;
  public static MouseMotionFactory currentMouseMotionFactory;
  private static final int MAX_DELAY = 60000;
  private RobotPeer peer;
  private boolean isAutoWaitForIdle = false;
  private int autoDelay = 0;
  private static int LEGAL_BUTTON_MASK = 0;

  private DirectColorModel screenCapCM = null;

  /**
   * Constructs a Robot object in the coordinate system of the primary screen.
   * <p>
   *
   * @throws  AWTException if the platform configuration does not allow
   * low-level input control.  This exception is always thrown when
   * GraphicsEnvironment.isHeadless() returns true
   * @throws  SecurityException if <code>createRobot</code> permission is not granted
   * @see     java.awt.GraphicsEnvironment#isHeadless
   * @see     SecurityManager#checkPermission
   * @see     AWTPermission
   */

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
      disposer = new RobotDisposer(peer);
      sun.java2d.Disposer.addRecord(anchor, disposer);
    }
    initLegalButtonMask();
  }

  private static synchronized void initLegalButtonMask() {
    if (LEGAL_BUTTON_MASK != 0) return;

    int tmpMask = 0;
    if (Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled()){
      if (Toolkit.getDefaultToolkit() instanceof SunToolkit) {
        final int buttonsNumber = ((SunToolkit)(Toolkit.getDefaultToolkit())).getNumberOfButtons();
        for (int i = 0; i < buttonsNumber; i++){
          tmpMask |= InputEvent.getMaskForButton(i+1);
        }
      }
    }
    tmpMask |= InputEvent.BUTTON1_MASK|
            InputEvent.BUTTON2_MASK|
            InputEvent.BUTTON3_MASK|
            InputEvent.BUTTON1_DOWN_MASK|
            InputEvent.BUTTON2_DOWN_MASK|
            InputEvent.BUTTON3_DOWN_MASK;
    LEGAL_BUTTON_MASK = tmpMask;
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

  private RobotDisposer disposer;

  /**
   * Moves mouse pointer to given screen coordinates.
   * @param x         X position
   * @param y         Y position
   */
  public synchronized void mouseMove(int x, int y) {
    try {
      currentMouseMotionFactory.build(x, y).move();
      this.delay(getMinDelay());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

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
    //TODO: implement random timer.
    return 40;
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
  public synchronized void keyPress(int keycode) {
    peer.keyPress(keycode);
    this.delay(getMinDelay());
  }


  public synchronized void keyRelease(int keycode) {
    peer.keyRelease(keycode);
    this.delay(getMinDelay());
  }

  public synchronized Color getPixelColor(int x, int y) {
    Color color = new Color(peer.getRGBPixel(x, y));
    return color;
  }

  /**
   * Sleeps for the specified time.
   * To catch any <code>InterruptedException</code>s that occur,
   * <code>Thread.sleep()</code> may be used instead.
   * @param   ms      time to sleep in milliseconds
   * @throws  IllegalArgumentException if <code>ms</code> is not between 0 and 60,000 milliseconds inclusive
   * @see     java.lang.Thread#sleep
   */
  public synchronized void delay(int ms) {
    checkDelayArgument(ms);
    try {
      Thread.sleep(ms);
    } catch(InterruptedException ite) {
      ite.printStackTrace();
    }
  }

  private void checkDelayArgument(int ms) {
    if (ms < 0 || ms > MAX_DELAY) {
      throw new IllegalArgumentException("Delay must be to 0 to 60,000ms");
    }
  }
}
