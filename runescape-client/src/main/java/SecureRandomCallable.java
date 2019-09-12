import java.security.SecureRandom;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("rc")
	@ObfuscatedGetter(
		intValue = 52067712
	)
	static int field499;
	@ObfuscatedName("l")
	@Export("SpriteBuffer_yOffsets")
	public static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("modIconSprites")
	static IndexedSprite[] modIconSprites;

	SecureRandomCallable() {
	}

	public Object call() {
		SecureRandom var2 = new SecureRandom();
		var2.nextInt();
		return var2;
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "373014156"
	)
	@Export("playSoundJingle")
	static void playSoundJingle(int var0, int var1) {
		if (Client.field638 != 0 && var0 != -1) {
			class49.method826(ArchiveDisk.archive11, var0, 0, Client.field638, false);
			Client.field746 = true;
		}

	}

	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1333341579"
	)
	@Export("getHighestVisiblePlane")
	static final int getHighestVisiblePlane() {
		if (Actor.clientPreferences.roofsHidden) {
			return MouseRecorder.plane;
		} else {
			int var0 = WorldMapAreaData.getTileHeight(ScriptFrame.cameraX, class14.cameraZ, MouseRecorder.plane);
			return var0 - GrandExchangeOfferTotalQuantityComparator.cameraY < 800 && (Tiles.Tiles_renderFlags[MouseRecorder.plane][ScriptFrame.cameraX >> 7][class14.cameraZ >> 7] & 4) != 0 ? MouseRecorder.plane : 3;
		}
	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "18257266"
	)
	public static boolean method1092() {
		return Client.staffModLevel >= 2;
	}
}
