import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("n")
	@Export("musicTrackBoolean")
	public static boolean musicTrackBoolean;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -2032808157
	)
	static int field565;
	@ObfuscatedName("jx")
	@ObfuscatedGetter(
		intValue = -1873727163
	)
	@Export("plane")
	static int plane;
	@ObfuscatedName("c")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("x")
	@Export("lock")
	Object lock;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 675918873
	)
	@Export("index")
	int index;
	@ObfuscatedName("g")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("l")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("u")
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
		for (; this.isRunning; FriendsList.sleepMillis(50L)) {
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "-1211827795"
	)
	@Export("isValidURL")
	static boolean isValidURL(String var0) {
		if (var0 == null) {
			return false;
		} else {
			try {
				new URL(var0);
				return true;
			} catch (MalformedURLException var2) {
				return false;
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1986117019"
	)
	public static void method1139() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1208312235"
	)
	static void method1145() {
		PacketBufferNode var0 = MenuAction.getPacketBufferNode(ClientPacket.field2270, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(class43.getWindowedMode());
		var0.packetBuffer.writeShort(GraphicsDefaults.canvasWidth);
		var0.packetBuffer.writeShort(GameShell.canvasHeight);
		Client.packetWriter.addNode(var0);
	}
}
