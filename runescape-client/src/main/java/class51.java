import java.applet.Applet;
import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class51 {
	@ObfuscatedName("rp")
	@ObfuscatedGetter(
		intValue = -101053789
	)
	static int field435;
	@ObfuscatedName("c")
	@Export("applet")
	public static Applet applet;
	@ObfuscatedName("t")
	public static String field431;
	@ObfuscatedName("cm")
	public static char field432;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = 1911186179
	)
	@Export("cameraY")
	static int cameraY;

	static {
		applet = null;
		field431 = "";
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "848753494"
	)
	static SecureRandom method896() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "827233636"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(IZZZI)Lia;",
		garbageValue = "-987500203"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, MilliClock.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, TileItem.masterDisk, var0, var1, var2, var3);
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(Lba;ZI)V",
		garbageValue = "-504714497"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.movementSequence == var0.readySequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = GameShell.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = WorldMapSectionType.getTileHeight(var0.x, var0.y, Clock.Client_plane);
					var0.playerCycle = Client.cycle;
					ServerBuild.scene.addNullableObject(Clock.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field626, var0.field627, var0.field628, var0.field629);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = WorldMapSectionType.getTileHeight(var0.x, var0.y, Clock.Client_plane);
					var0.playerCycle = Client.cycle;
					ServerBuild.scene.drawEntity(Clock.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2078000833"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (ScriptFrame.loadInterface(var0)) {
			Widget[] var1 = WorldMapLabel.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}
}
