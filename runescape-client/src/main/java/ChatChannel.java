import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[Lbe;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -864101903
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbe;",
		garbageValue = "56"
	)
	@Export("addMessage")
	Message addMessage(int var1, String var2, String var3, String var4) {
		Message var5 = this.messages[99];

		for (int var6 = this.count; var6 > 0; --var6) {
			if (var6 != 100) {
				this.messages[var6] = this.messages[var6 - 1];
			}
		}

		if (var5 == null) {
			var5 = new Message(var1, var2, var4, var3);
		} else {
			var5.remove();
			var5.removeDual();
			var5.set(var1, var2, var4, var3);
		}

		this.messages[0] = var5;
		if (this.count < 100) {
			++this.count;
		}

		return var5;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)Lbe;",
		garbageValue = "601749225"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-135495526"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "247037730"
	)
	static final void method2237() {
		int var0 = class225.field3045 * 128 + 64;
		int var1 = Clock.field2039 * 16384 + 64;
		int var2 = MusicPatchPcmStream.getTileHeight(var0, var1, WorldMapRectangle.plane) - GrandExchangeOfferOwnWorldComparator.field627;
		if (GrandExchangeOfferOwnWorldComparator.cameraX < var0) {
			GrandExchangeOfferOwnWorldComparator.cameraX = (var0 - GrandExchangeOfferOwnWorldComparator.cameraX) * Messages.field1262 / 1000 + GrandExchangeOfferOwnWorldComparator.cameraX + MouseRecorder.field572;
			if (GrandExchangeOfferOwnWorldComparator.cameraX > var0) {
				GrandExchangeOfferOwnWorldComparator.cameraX = var0;
			}
		}

		if (GrandExchangeOfferOwnWorldComparator.cameraX > var0) {
			GrandExchangeOfferOwnWorldComparator.cameraX -= Messages.field1262 * (GrandExchangeOfferOwnWorldComparator.cameraX - var0) / 1000 + MouseRecorder.field572;
			if (GrandExchangeOfferOwnWorldComparator.cameraX < var0) {
				GrandExchangeOfferOwnWorldComparator.cameraX = var0;
			}
		}

		if (Varcs.cameraY < var2) {
			Varcs.cameraY = (var2 - Varcs.cameraY) * Messages.field1262 / 1000 + Varcs.cameraY + MouseRecorder.field572;
			if (Varcs.cameraY > var2) {
				Varcs.cameraY = var2;
			}
		}

		if (Varcs.cameraY > var2) {
			Varcs.cameraY -= Messages.field1262 * (Varcs.cameraY - var2) / 1000 + MouseRecorder.field572;
			if (Varcs.cameraY < var2) {
				Varcs.cameraY = var2;
			}
		}

		if (WorldMapIcon_1.cameraZ < var1) {
			WorldMapIcon_1.cameraZ = (var1 - WorldMapIcon_1.cameraZ) * Messages.field1262 / 1000 + WorldMapIcon_1.cameraZ + MouseRecorder.field572;
			if (WorldMapIcon_1.cameraZ > var1) {
				WorldMapIcon_1.cameraZ = var1;
			}
		}

		if (WorldMapIcon_1.cameraZ > var1) {
			WorldMapIcon_1.cameraZ -= Messages.field1262 * (WorldMapIcon_1.cameraZ - var1) / 1000 + MouseRecorder.field572;
			if (WorldMapIcon_1.cameraZ < var1) {
				WorldMapIcon_1.cameraZ = var1;
			}
		}

		var0 = GameShell.field455 * 16384 + 64;
		var1 = SecureRandomFuture.field1228 * 16384 + 64;
		var2 = MusicPatchPcmStream.getTileHeight(var0, var1, WorldMapRectangle.plane) - class14.field90;
		int var3 = var0 - GrandExchangeOfferOwnWorldComparator.cameraX;
		int var4 = var2 - Varcs.cameraY;
		int var5 = var1 - WorldMapIcon_1.cameraZ;
		int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
		int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
		int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
		if (var7 < 128) {
			var7 = 128;
		}

		if (var7 > 383) {
			var7 = 383;
		}

		if (IgnoreList.cameraPitch < var7) {
			IgnoreList.cameraPitch = (var7 - IgnoreList.cameraPitch) * ScriptEvent.field570 / 1000 + IgnoreList.cameraPitch + class80.field1126;
			if (IgnoreList.cameraPitch > var7) {
				IgnoreList.cameraPitch = var7;
			}
		}

		if (IgnoreList.cameraPitch > var7) {
			IgnoreList.cameraPitch -= ScriptEvent.field570 * (IgnoreList.cameraPitch - var7) / 1000 + class80.field1126;
			if (IgnoreList.cameraPitch < var7) {
				IgnoreList.cameraPitch = var7;
			}
		}

		int var9 = var8 - WorldMapSection2.cameraYaw;
		if (var9 > 1024) {
			var9 -= 2048;
		}

		if (var9 < -1024) {
			var9 += 2048;
		}

		if (var9 > 0) {
			WorldMapSection2.cameraYaw = WorldMapSection2.cameraYaw + class80.field1126 + var9 * ScriptEvent.field570 / 1000;
			WorldMapSection2.cameraYaw &= 2047;
		}

		if (var9 < 0) {
			WorldMapSection2.cameraYaw -= class80.field1126 + -var9 * ScriptEvent.field570 / 1000;
			WorldMapSection2.cameraYaw &= 2047;
		}

		int var10 = var8 - WorldMapSection2.cameraYaw;
		if (var10 > 1024) {
			var10 -= 2048;
		}

		if (var10 < -1024) {
			var10 += 2048;
		}

		if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
			WorldMapSection2.cameraYaw = var8;
		}

	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "73"
	)
	static void method2229(int var0) {
		ParamDefinition.tempMenuAction = new MenuAction();
		ParamDefinition.tempMenuAction.argument1 = Client.menuArguments1[var0];
		ParamDefinition.tempMenuAction.argument2 = Client.menuArguments2[var0];
		ParamDefinition.tempMenuAction.opcode = Client.menuOpcodes[var0];
		ParamDefinition.tempMenuAction.argument0 = Client.menuIdentifiers[var0];
		ParamDefinition.tempMenuAction.action = Client.menuActions[var0];
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "([Lho;II)V",
		garbageValue = "559815398"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !WorldMapSectionType.isComponentHidden(var3))) {
				int var5;
				if (var3.type == 0) {
					if (!var3.isIf3 && WorldMapSectionType.isComponentHidden(var3) && var3 != NetSocket.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var7 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var7 != null) {
						var5 = var7.group;
						if (WorldMapData_0.loadInterface(var5)) {
							drawModelComponents(UserComparator5.Widget_interfaceComponents[var5], -1);
						}
					}
				}

				if (var3.type == 6) {
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var4 = Projectile.runCs1(var3);
						if (var4) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var5);

							for (var3.modelFrameCycle += Client.field698; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; WorldMapSectionType.invalidateWidget(var3)) {
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

					if (var3.field2601 != 0 && !var3.isIf3) {
						int var8 = var3.field2601 >> 16;
						var5 = var3.field2601 << 16 >> 16;
						var8 *= Client.field698;
						var5 *= Client.field698;
						var3.modelAngleX = var8 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						WorldMapSectionType.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
