import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("qs")
	@ObfuscatedSignature(
		signature = "Ldd;"
	)
	@Export("pcmPlayer0")
	static PcmPlayer pcmPlayer0;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -694423597
	)
	@Export("ItemDefinition_fileCount")
	public static int ItemDefinition_fileCount;
	@ObfuscatedName("s")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("j")
	@Export("lock")
	Object lock;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -958051971
	)
	@Export("index")
	int index;
	@ObfuscatedName("k")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("u")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("n")
	@Export("millis")
	long[] millis;

	MouseRecorder() {
		this.isRunning = true;
		this.lock = new Object();
		this.index = 0;
		this.xs = new int[500];
		this.ys = new int[500];
		this.millis = new long[500];
	}

	public void run() {
		for (; this.isRunning; UserList.sleepMillis(50L)) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)[Lgj;",
		garbageValue = "58"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2102, ServerPacket.field2098, ServerPacket.field2099, ServerPacket.field2183, ServerPacket.field2101, ServerPacket.field2170, ServerPacket.field2100, ServerPacket.field2158, ServerPacket.field2105, ServerPacket.field2106, ServerPacket.field2107, ServerPacket.field2108, ServerPacket.field2161, ServerPacket.field2184, ServerPacket.field2178, ServerPacket.field2112, ServerPacket.field2137, ServerPacket.field2114, ServerPacket.field2104, ServerPacket.field2116, ServerPacket.field2115, ServerPacket.field2134, ServerPacket.field2119, ServerPacket.field2120, ServerPacket.field2121, ServerPacket.field2122, ServerPacket.field2123, ServerPacket.field2124, ServerPacket.field2159, ServerPacket.field2126, ServerPacket.field2136, ServerPacket.field2128, ServerPacket.field2163, ServerPacket.field2117, ServerPacket.field2131, ServerPacket.field2130, ServerPacket.field2133, ServerPacket.field2129, ServerPacket.field2135, ServerPacket.field2148, ServerPacket.field2175, ServerPacket.field2138, ServerPacket.field2139, ServerPacket.field2140, ServerPacket.field2141, ServerPacket.field2142, ServerPacket.field2143, ServerPacket.field2144, ServerPacket.field2145, ServerPacket.field2146, ServerPacket.field2147, ServerPacket.field2125, ServerPacket.field2149, ServerPacket.field2150, ServerPacket.field2151, ServerPacket.field2152, ServerPacket.field2162, ServerPacket.field2097, ServerPacket.field2155, ServerPacket.field2156, ServerPacket.field2118, ServerPacket.field2132, ServerPacket.field2110, ServerPacket.field2160, ServerPacket.field2103, ServerPacket.field2127, ServerPacket.field2154, ServerPacket.field2164, ServerPacket.field2165, ServerPacket.field2179, ServerPacket.field2167, ServerPacket.field2168, ServerPacket.field2169, ServerPacket.field2166, ServerPacket.field2171, ServerPacket.field2172, ServerPacket.field2173, ServerPacket.field2174, ServerPacket.field2153, ServerPacket.field2176, ServerPacket.field2177, ServerPacket.field2113, ServerPacket.field2157, ServerPacket.field2180, ServerPacket.field2181, ServerPacket.field2182};
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-5"
	)
	@Export("playSoundJingle")
	static void playSoundJingle(int var0, int var1) {
		if (Client.field856 != 0 && var0 != -1) {
			PacketBufferNode.method3574(WorldMapRectangle.archive11, var0, 0, Client.field856, false);
			Client.field858 = true;
		}

	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "-63"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Projectile.loadInterface(var0)) {
			Occluder.updateInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}
