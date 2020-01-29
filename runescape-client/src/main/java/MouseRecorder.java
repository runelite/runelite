import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("c")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("t")
	@Export("lock")
	Object lock;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 114290231
	)
	@Export("index")
	int index;
	@ObfuscatedName("e")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("i")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("g")
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
		for (; this.isRunning; FriendLoginUpdate.method5325(50L)) {
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
		signature = "(Lkp;Llp;B)Llp;",
		garbageValue = "-44"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			var3 = DynamicObject.method2293(var2);
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var4 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var4) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;Lii;Lgw;I)Z",
		garbageValue = "1360847882"
	)
	public static boolean method1208(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
		class197.musicPatchesArchive = var0;
		class197.musicSamplesArchive = var1;
		UserComparator10.soundEffectsArchive = var2;
		class197.midiPcmStream = var3;
		return true;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-64"
	)
	static final void method1209() {
		if (!ViewportMouse.ViewportMouse_false0) {
			int var0 = Scene.Scene_cameraPitchSine;
			int var1 = Scene.Scene_cameraPitchCosine;
			int var2 = Scene.Scene_cameraYawSine;
			int var3 = Scene.Scene_cameraYawCosine;
			byte var4 = 50;
			short var5 = 3500;
			int var6 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var4 / Rasterizer3D.Rasterizer3D_zoom;
			int var7 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var4 / Rasterizer3D.Rasterizer3D_zoom;
			int var8 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var5 / Rasterizer3D.Rasterizer3D_zoom;
			int var9 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var5 / Rasterizer3D.Rasterizer3D_zoom;
			int var10 = Rasterizer3D.method3087(var7, var4, var1, var0);
			int var11 = Rasterizer3D.method3088(var7, var4, var1, var0);
			var7 = var10;
			var10 = Rasterizer3D.method3087(var9, var5, var1, var0);
			int var12 = Rasterizer3D.method3088(var9, var5, var1, var0);
			var9 = var10;
			var10 = Rasterizer3D.method3112(var6, var11, var3, var2);
			var11 = Rasterizer3D.method3086(var6, var11, var3, var2);
			var6 = var10;
			var10 = Rasterizer3D.method3112(var8, var12, var3, var2);
			var12 = Rasterizer3D.method3086(var8, var12, var3, var2);
			ViewportMouse.field1729 = (var10 + var6) / 2;
			ViewportMouse.field1731 = (var9 + var7) / 2;
			ViewportMouse.field1736 = (var11 + var12) / 2;
			TextureProvider.field1512 = (var10 - var6) / 2;
			ViewportMouse.field1733 = (var9 - var7) / 2;
			ViewportMouse.field1742 = (var12 - var11) / 2;
			UserComparator7.field1978 = Math.abs(TextureProvider.field1512);
			class4.field26 = Math.abs(ViewportMouse.field1733);
			class43.field381 = Math.abs(ViewportMouse.field1742);
		}
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1367330545"
	)
	static boolean method1210() {
		return (Client.drawPlayerNames & 4) != 0;
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "5"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = WorldMapSectionType.getTileHeight(var0, var1, Clock.Client_plane) - var2;
			var0 -= HitSplatDefinition.cameraX;
			var3 -= class51.cameraY;
			var1 -= Actor.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[GrandExchangeOffer.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[GrandExchangeOffer.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[FriendSystem.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[FriendSystem.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var5 * var3 - var4 * var1 >> 16;
			var1 = var3 * var4 + var5 * var1 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("lr")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1867958927"
	)
	static String method1207(String var0) {
		PlayerType[] var1 = SecureRandomFuture.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon != -1 && var0.startsWith(Language.method3728(var3.modIcon))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
				break;
			}
		}

		return var0;
	}
}
