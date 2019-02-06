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
    int TIME_NOSECONDS = 0x00000002;

    public int GetTimeFormatEx(
            WString lpLocaleName, WinDef.DWORD dwFlags, WinBase.SYSTEMTIME lpTime,
            WString lpFormat, char[] lpTimeStr, int cchTime);

    public int GetLastError();
}

public class WinApi {
    static Kernel32 kernel32 = Native.loadLibrary("kernel32", Kernel32.class);

    public static String getTimeFormatString(LocalDateTime localDateTime) {
        char[] lpTimeStr = new char[80];
        WinDef.DWORD dwFlags = new WinDef.DWORD(Kernel32.TIME_NOSECONDS);

        WinBase.SYSTEMTIME time = new WinBase.SYSTEMTIME();
        time.wHour = (short)localDateTime.getHour();
        time.wMinute = (short)localDateTime.getMinute();
        time.wSecond = (short)localDateTime.getSecond();
        time.wMilliseconds = 0;

        kernel32.GetTimeFormatEx(null, dwFlags, time, null, lpTimeStr, 80) == 0)

        int endIndex = 0;
        for (int i = 0; i < lpTimeStr.length; i++) {
            if (lpTimeStr[i] == '\u0000') {
                endIndex = i;
                break;
            }
        }
        return String.valueOf(lpTimeStr, 0, endIndex);
    }
}
