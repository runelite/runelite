import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	static IndexedSprite field202;
	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive6")
	static Archive archive6;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1850288081
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -20995345
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 563692881
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(CI)C",
		garbageValue = "1722829704"
	)
	static char method302(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "([Lhy;II)V",
		garbageValue = "2021423451"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !NetCache.isComponentHidden(var3))) {
				int var5;
				if (var3.type == 0) {
					if (!var3.isIf3 && NetCache.isComponentHidden(var3) && var3 != class32.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						var5 = var4.group;
						if (TaskHandler.loadInterface(var5)) {
							drawModelComponents(class289.Widget_interfaceComponents[var5], -1);
						}
					}
				}

				if (var3.type == 6) {
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var7 = Tile.runCs1(var3);
						if (var7) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = class83.SequenceDefinition_get(var5);

							for (var3.modelFrameCycle += Client.field683; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; WorldMapID.invalidateWidget(var3)) {
								var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
								++var3.modelFrame;
								if (var3.modelFrame >= var6.frameIds.length) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame = 0;
									}
								}
							}
						}
					}

					if (var3.field2594 != 0 && !var3.isIf3) {
						int var8 = var3.field2594 >> 16;
						var5 = var3.field2594 << 16 >> 16;
						var8 *= Client.field683;
						var5 *= Client.field683;
						var3.modelAngleX = var8 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						WorldMapID.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
