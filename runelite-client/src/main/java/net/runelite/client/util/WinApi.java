package net.runelite.client.util;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

interface Kernel32 extends StdCallLibrary {
    public int getTimeFormatEx(
            WString lpLocaleName, WinDef.DWORD dwFlags, WinBase.SYSTEMTIME.ByReference lpTime,
            WString lpFormat, char[] lpTimeStr, int cchTime);

    public int getLastError();
}

public class WinApi {
    static Kernel32 kernel32 = Native.loadLibrary("kernel32", Kernel32.class);

    public static String getTimeFormatString(LocalDateTime localDateTime) {
        char[] lpTimeStr = new char[80];
        WString lpLocaleName = new WString(Locale.getDefault().toString());
        WinDef.DWORD dwFlags = new WinDef.DWORD(0);

        WinBase.SYSTEMTIME time = new WinBase.SYSTEMTIME();
        time.wHour = (short)localDateTime.getHour();
        time.wMinute = (short)localDateTime.getMinute();
        time.wSecond = (short)localDateTime.getSecond();

        kernel32.getTimeFormatEx(lpLocaleName, dwFlags, (WinBase.SYSTEMTIME.ByReference)time.getPointer(), null, lpTimeStr, 80);

        return lpTimeStr.toString();
    }
}
