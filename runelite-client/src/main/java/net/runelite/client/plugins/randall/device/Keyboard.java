package net.runelite.client.plugins.randall.device;


import net.runelite.client.plugins.randall.Utils;
import net.runelite.client.plugins.randall.event.EventHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Keyboard extends BaseDevice {
    private final Set<int[]> keysHeld = Collections.synchronizedSet(new HashSet<int[]>());
    private final KeySender keySender = new KeySender("java-key-thread");
    private boolean shiftDown = false;

    public Keyboard(Canvas canvas) {
        super(canvas);
        keySender.start();
    }

    public static char toChar(int code, boolean shift) {
        return shift ? Character.toUpperCase((char) code) : Character.toLowerCase((char) code);
    }

    @Override
    public void reset() {
        super.reset();

        for (int[] dat : keysHeld) {
            releaseKey(dat[0]);
        }
    }

    private boolean isShiftChar(char c) {
        String special = "~!@#$%^&*()_+|{}:\"<>?";
        return special.indexOf(c) != -1 || (c - 'A' >= 0 && c - 'A' <= 25);
    }

    private boolean isArrowKey(int vk) {
        return vk >= 1000 && vk <= 1003;
    }

    private boolean isTypableCode(int vk) {
        return vk < 0xff;
    }

    private int toArrowKey(int code) {
        if (code == 1000) {
            return KeyEvent.VK_UP;
        } else if (code == 1001) {
            return KeyEvent.VK_DOWN;
        } else if (code == 1002) {
            return KeyEvent.VK_LEFT;
        } else if (code == 1003) {
            return KeyEvent.VK_RIGHT;
        }
        return 0;
    }

    public synchronized void holdKey(int code) {
        getFocus();

        long startTime = System.currentTimeMillis();
        int[] dat = new int[]{code, (int) (startTime)};

        if (!isKeyHeld(dat)) {
            if (KeyEvent.VK_SHIFT == code) {
                shiftDown = true;
            }

            boolean arrowKey = false;
            if (isArrowKey(code)) {
                code = toArrowKey(code);
                arrowKey = true;
            }

            EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_PRESSED, startTime, shiftDown ? KeyEvent.SHIFT_DOWN_MASK : 0, code, KeyEvent.CHAR_UNDEFINED, KeyEvent.KEY_LOCATION_STANDARD));
            if (isTypableCode(code) && !arrowKey) {
                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_TYPED, startTime, shiftDown ? KeyEvent.SHIFT_DOWN_MASK : 0, 0, toChar(code, shiftDown), KeyEvent.KEY_LOCATION_UNKNOWN));
            }

            setKeyHeld(dat, true);
        }
    }

    public synchronized void releaseKey(int code) {
        getFocus();

        int[] dat = new int[]{code};
        if (isKeyHeld(dat)) {
            setKeyHeld(dat, false);

            if (isArrowKey(code)) {
                code = toArrowKey(code);
            }

            EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, code, KeyEvent.CHAR_UNDEFINED, KeyEvent.KEY_LOCATION_STANDARD));
            if (KeyEvent.VK_SHIFT == code) {
                shiftDown = false;
            }
        }
    }

    public boolean isKeyDown(int code) {
        int[] dat = new int[]{code};
        return isKeyHeld(dat);
    }

    public synchronized void sendKeys(String text, int keywait, int keymodwait) {
        char[] chars = text.toCharArray();
        getFocus();

        for (char c : chars) {
            int code = c;
            int keyLoc = Character.isDigit(c) ? Math.random() > 0.5D ? KeyEvent.KEY_LOCATION_NUMPAD : KeyEvent.KEY_LOCATION_STANDARD : KeyEvent.KEY_LOCATION_STANDARD;

            if (isShiftChar(c)) {
                int shiftLoc = Math.random() > 0.5D ? KeyEvent.KEY_LOCATION_RIGHT : KeyEvent.KEY_LOCATION_LEFT;
                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), KeyEvent.SHIFT_MASK, KeyEvent.VK_SHIFT, KeyEvent.CHAR_UNDEFINED, shiftLoc));
                wait((int) ((Math.random() * 0.1 + 1) * keymodwait));

                long time = System.currentTimeMillis();
                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_PRESSED, time, KeyEvent.SHIFT_MASK, code, c, keyLoc));
                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_TYPED, time, KeyEvent.SHIFT_MASK, 0, c, KeyEvent.KEY_LOCATION_UNKNOWN));
                wait((int) ((Math.random() * 0.1 + 1) * keymodwait));

                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), KeyEvent.SHIFT_MASK, code, c, keyLoc));
                wait((int) ((Math.random() * 0.1 + 1) * keymodwait));

                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_SHIFT, KeyEvent.CHAR_UNDEFINED, shiftLoc));

            } else {
                long time = System.currentTimeMillis();
                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_PRESSED, time, 0, code, c, keyLoc));
                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_TYPED, time, 0, 0, c, KeyEvent.KEY_LOCATION_UNKNOWN));
                wait((int) ((Math.random() * 0.1 + 1) * keymodwait));

                EventHandler.PostEvent(new KeyEvent(this.canvas, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, code, c, keyLoc));
            }
        }
    }

    private synchronized void setKeyHeld(int[] dat, boolean held) {
        synchronized (keysHeld) {
            if (held) {
                keysHeld.add(dat);
            } else {
                HashSet<int[]> remove = new HashSet<>();
                for (int[] entry : keysHeld) {
                    if (entry[0] == dat[0]) {
                        remove.add(entry);
                    }
                }
                keysHeld.removeAll(remove);
            }
        }
    }

    private synchronized boolean isKeyHeld(int[] dat) {
        synchronized (keysHeld) {
            for (int[] entry : keysHeld) {
                if (entry[0] == dat[0]) {
                    return true;
                }
            }
            return false;
        }
    }

    private class KeySender extends Thread {

        public KeySender(String name) {
            super(name);
            this.setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                Utils.sleep(30 + (int) (Math.random() * 5));

                int minTime = (int) (System.currentTimeMillis()) - 1000;

                synchronized (keysHeld) {
                    for (int[] dat : keysHeld) {
                        if (dat[1] < minTime) {

                            int code = dat[0];
                            boolean arrowKey = false;
                            if (isArrowKey(dat[0])) {
                                code = toArrowKey(dat[0]);
                                arrowKey = true;
                            }

                            EventHandler.PostEvent(new KeyEvent(canvas, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), shiftDown ? KeyEvent.SHIFT_DOWN_MASK : 0, code, KeyEvent.CHAR_UNDEFINED, KeyEvent.KEY_LOCATION_STANDARD));
                            if (isTypableCode(dat[0]) && !arrowKey) {
                                EventHandler.PostEvent(new KeyEvent(canvas, KeyEvent.KEY_TYPED, System.currentTimeMillis(), shiftDown ? KeyEvent.SHIFT_DOWN_MASK : 0, 0, toChar(code, shiftDown), KeyEvent.KEY_LOCATION_UNKNOWN));
                            }
                        }
                    }
                }
                yield();
            }
        }
    }
}
