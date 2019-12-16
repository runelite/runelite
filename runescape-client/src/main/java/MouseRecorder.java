import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1462457493
	)
	static int field564;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("ee")
	@ObfuscatedGetter(
		intValue = -365482057
	)
	@Export("port2")
	static int port2;
	@ObfuscatedName("f")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("i")
	@Export("lock")
	Object lock;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -134768521
	)
	@Export("index")
	int index;
	@ObfuscatedName("w")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("p")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("b")
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
		for (; this.isRunning; ServerBuild.method4111(50L)) {
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1809769909"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (Login.World_request == null) {
				Login.World_request = BufferedNetSocket.urlRequester.request(new URL(TextureProvider.field1510));
			} else if (Login.World_request.isDone()) {
				byte[] var0 = Login.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				class162.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = class162.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				class192.sortWorlds(class162.World_worlds, 0, class162.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				Login.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			Login.World_request = null;
		}

		return false;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "171278603"
	)
	static void method1187() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}
}
