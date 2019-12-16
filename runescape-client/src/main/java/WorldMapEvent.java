import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("modIconSprites")
	static IndexedSprite[] modIconSprites;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -458237055
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILht;Lht;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "111"
	)
	static final void method764() {
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
			int var10 = Rasterizer3D.method3019(var7, var4, var1, var0);
			int var11 = Rasterizer3D.method3020(var7, var4, var1, var0);
			var7 = var10;
			var10 = Rasterizer3D.method3019(var9, var5, var1, var0);
			int var12 = Rasterizer3D.method3020(var9, var5, var1, var0);
			var9 = var10;
			var10 = Rasterizer3D.method3017(var6, var11, var3, var2);
			var11 = Rasterizer3D.method3083(var6, var11, var3, var2);
			var6 = var10;
			var10 = Rasterizer3D.method3017(var8, var12, var3, var2);
			var12 = Rasterizer3D.method3083(var8, var12, var3, var2);
			ViewportMouse.field1717 = (var10 + var6) / 2;
			class30.field245 = (var9 + var7) / 2;
			ViewportMouse.field1718 = (var12 + var11) / 2;
			ViewportMouse.field1719 = (var10 - var6) / 2;
			WorldMapCacheName.field293 = (var9 - var7) / 2;
			class40.field336 = (var12 - var11) / 2;
			ViewportMouse.field1720 = Math.abs(ViewportMouse.field1719);
			class247.field3261 = Math.abs(WorldMapCacheName.field293);
			MusicPatch.field2472 = Math.abs(class40.field336);
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Lfl;IIS)Lcw;",
		garbageValue = "14902"
	)
	public static final PcmPlayer method763(TaskHandler var0, int var1, int var2) {
		if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = ChatChannel.pcmPlayerProvider.player();
				var3.samples = new int[(SoundCache.PcmPlayer_stereo ? 2 : 1) * 256];
				var3.field1373 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (NPC.field1103 > 0 && HealthBar.soundSystem == null) {
					HealthBar.soundSystem = new SoundSystem();
					FriendSystem.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					FriendSystem.soundSystemExecutor.scheduleAtFixedRate(HealthBar.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (HealthBar.soundSystem != null) {
					if (HealthBar.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					HealthBar.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
