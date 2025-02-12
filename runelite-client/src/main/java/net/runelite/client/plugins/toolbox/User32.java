package net.runelite.client.plugins.toolbox;

import com.sun.jna.*;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

import java.util.concurrent.*;

public interface User32 extends StdCallLibrary {
    User32 INSTANCE = Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

    HWND FindWindow(String lpClassName, String lpWindowName);
    boolean GetCursorPos(POINT lpPoint);
    HWND WindowFromPoint(POINT Point);
    boolean PeekMessage(WinUser.MSG lpMsg, HWND hWnd, int wMsgFilterMin, int wMsgFilterMax, int wRemoveMsg);
}
