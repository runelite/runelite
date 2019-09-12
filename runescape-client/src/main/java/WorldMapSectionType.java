import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	@Export("WORLDMAPSECTIONTYPE0")
	WORLDMAPSECTIONTYPE0(2, (byte)0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	@Export("WORLDMAPSECTIONTYPE1")
	WORLDMAPSECTIONTYPE1(0, (byte)1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	@Export("WORLDMAPSECTIONTYPE2")
	WORLDMAPSECTIONTYPE2(3, (byte)2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	@Export("WORLDMAPSECTIONTYPE3")
	WORLDMAPSECTIONTYPE3(1, (byte)3);

	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1030094683
	)
	@Export("type")
	final int type;
	@ObfuscatedName("u")
	@Export("id")
	final byte id;

	WorldMapSectionType(int var3, byte var4) {
		this.type = var3;
		this.id = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "53"
	)
	public static void method220() {
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field381 = KeyHandler.field383;
			KeyHandler.field380 = 0;
			int var1;
			if (KeyHandler.field366 < 0) {
				for (var1 = 0; var1 < 112; ++var1) {
					KeyHandler.KeyHandler_pressedKeys[var1] = false;
				}

				KeyHandler.field366 = KeyHandler.field375;
			} else {
				while (KeyHandler.field375 != KeyHandler.field366) {
					var1 = KeyHandler.field369[KeyHandler.field375];
					KeyHandler.field375 = KeyHandler.field375 + 1 & 127;
					if (var1 < 0) {
						KeyHandler.KeyHandler_pressedKeys[~var1] = false;
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var1] && KeyHandler.field380 < KeyHandler.field379.length - 1) {
							KeyHandler.field379[++KeyHandler.field380 - 1] = var1;
						}

						KeyHandler.KeyHandler_pressedKeys[var1] = true;
					}
				}
			}

			if (KeyHandler.field380 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field383 = KeyHandler.field382;
		}
	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(Liw;IIIB)V",
		garbageValue = "3"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.field860 != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
				}
			}
		}
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "1024"
	)
	static void method224(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.first(); var1 != null; var1 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((long)var0 == (var1.key >> 48 & 65535L)) {
				var1.remove();
			}
		}

	}
}
