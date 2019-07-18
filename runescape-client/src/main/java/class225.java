import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class225 {
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "([Lhj;II)V",
		garbageValue = "-1666853879"
	)
	static final void method4122(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !ScriptEvent.isComponentHidden(var3))) {
				if (var3.type == 0) {
					if (!var3.isIf3 && ScriptEvent.isComponentHidden(var3) && var3 != LoginScreenAnimation.mousedOverWidgetIf1) {
						continue;
					}

					method4122(var0, var3.id);
					if (var3.children != null) {
						method4122(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						Archive.method4269(var4.group);
					}
				}

				if (var3.type == 6) {
					int var5;
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var7 = ChatChannel.runCs1(var3);
						if (var7) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = GrandExchangeEvent.getSequenceDefinition(var5);

							for (var3.modelFrameCycle += Client.field718; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; Strings.method4120(var3)) {
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

					if (var3.field2575 != 0 && !var3.isIf3) {
						int var8 = var3.field2575 >> 16;
						var5 = var3.field2575 << 16 >> 16;
						var8 *= Client.field718;
						var5 *= Client.field718;
						var3.modelAngleX = var8 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						Strings.method4120(var3);
					}
				}
			}
		}

	}
}
