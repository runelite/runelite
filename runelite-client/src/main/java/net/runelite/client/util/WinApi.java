package net.runelite.client.util;

import com.sun.jna.Native;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import java.time.LocalDateTime;

interface Kernel32 extends StdCallLibrary
{
	int TIME_NOSECONDS = 0x00000002;

	int GetTimeFormatEx(
			WString lpLocaleName, WinDef.DWORD dwFlags, WinBase.SYSTEMTIME lpTime,
			WString lpFormat, char[] lpTimeStr, int cchTime);

}

public class WinApi
{
	static Kernel32 kernel32 = Native.loadLibrary("kernel32", Kernel32.class);

	public static String getTimeFormatString(LocalDateTime localDateTime)
	{
		char[] lpTimeStr = new char[80];
		WinDef.DWORD dwFlags = new WinDef.DWORD(Kernel32.TIME_NOSECONDS);

		WinBase.SYSTEMTIME time = new WinBase.SYSTEMTIME();
		time.wHour = (short) localDateTime.getHour();
		time.wMinute = (short) localDateTime.getMinute();
		time.wSecond = (short) localDateTime.getSecond();
		time.wMilliseconds = 0;

		kernel32.GetTimeFormatEx(null, dwFlags, time, null, lpTimeStr, 80);
		return new String(lpTimeStr);
	}
}
