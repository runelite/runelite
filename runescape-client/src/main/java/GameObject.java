import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -940773831
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 2132625949
	)
	@Export("height")
	int height;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -2072532473
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1479439291
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -638708115
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1848719161
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1367330545
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 170965517
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -281386629
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 459315211
	)
	int field1931;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1057625291
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = 3023307687483633369L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1037464563
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Liw;",
		garbageValue = "-1799291125"
	)
	@Export("getEnum")
	public static EnumDefinition getEnum(int var0) {
		EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = GrandExchangeOfferAgeComparator.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "(Lip;IIII)V",
		garbageValue = "-1299121306"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.areaSoundEffectVolume != 0) {
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

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "101"
	)
	static void method3360() {
		int var0;
		int var2;
		int var3;
		for (var0 = 0; var0 < Client.menuOptionsCount; ++var0) {
			var2 = Client.menuOpcodes[var0];
			boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
			if (var1) {
				if (var0 < Client.menuOptionsCount - 1) {
					for (var3 = var0; var3 < Client.menuOptionsCount - 1; ++var3) {
						Client.menuActions[var3] = Client.menuActions[var3 + 1];
						Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
						Client.menuOpcodes[var3] = Client.menuOpcodes[var3 + 1];
						Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
						Client.menuArguments1[var3] = Client.menuArguments1[var3 + 1];
						Client.menuArguments2[var3] = Client.menuArguments2[var3 + 1];
						Client.menuShiftClick[var3] = Client.menuShiftClick[var3 + 1];
					}
				}

				--var0;
				--Client.menuOptionsCount;
			}
		}

		var0 = InterfaceParent.menuWidth / 2 + ArchiveDiskAction.menuX;
		int var6 = SecureRandomCallable.menuY;
		var2 = class1.fontBold12.stringWidth("Choose Option");

		int var4;
		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			var4 = class1.fontBold12.stringWidth(VerticalAlignment.method4426(var3));
			if (var4 > var2) {
				var2 = var4;
			}
		}

		var2 += 8;
		var3 = Client.menuOptionsCount * 15 + 22;
		var4 = var0 - var2 / 2;
		if (var4 + var2 > Username.canvasWidth) {
			var4 = Username.canvasWidth - var2;
		}

		if (var4 < 0) {
			var4 = 0;
		}

		int var5 = var6;
		if (var3 + var6 > WorldMapData_1.canvasHeight) {
			var5 = WorldMapData_1.canvasHeight - var3;
		}

		if (var5 < 0) {
			var5 = 0;
		}

		ArchiveDiskAction.menuX = var4;
		SecureRandomCallable.menuY = var5;
		InterfaceParent.menuWidth = var2;
		Message.menuHeight = Client.menuOptionsCount * 15 + 22;
	}
}
