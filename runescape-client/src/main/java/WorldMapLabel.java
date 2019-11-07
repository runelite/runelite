import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("qz")
	@ObfuscatedGetter(
		intValue = 1433449733
	)
	static int field231;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	static Bounds field225;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -678092669
	)
	public static int field229;
	@ObfuscatedName("a")
	@Export("text")
	String text;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1265907977
	)
	@Export("width")
	int width;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -860920669
	)
	@Export("height")
	int height;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILe;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1730606936"
	)
	public static int method479() {
		return ViewportMouse.ViewportMouse_entityCount;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "880731151"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1804340309"
	)
	static final void method475(int var0, int var1) {
		if (Client.hintArrowType == 2) {
			WorldMapCacheName.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - UserComparator8.baseX * 64 << 7), Client.hintArrowSubY * 64 + (Client.hintArrowY - HealthBar.baseY * 64 << 7), Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				class14.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}

		}
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "668780509"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = WorldMapArea.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var14;
		int var26;
		if (0L != var5) {
			var7 = WorldMapArea.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			boolean var12 = var5 != 0L;
			if (var12) {
				boolean var13 = (int)(var5 >>> 16 & 1L) == 1;
				var12 = !var13;
			}

			if (var12) {
				var10 = var4;
			}

			int[] var19 = FloorDecoration.sceneMinimapSprite.pixels;
			var26 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var14 = UserComparator8.Entity_unpackID(var5);
			ObjectDefinition var15 = WorldMapDecorationType.getObjectDefinition(var14);
			if (var15.mapSceneId != -1) {
				IndexedSprite var16 = GrandExchangeOfferWorldComparator.mapSceneSprites[var15.mapSceneId];
				if (var16 != null) {
					int var17 = (var15.sizeX * 4 - var16.subWidth) / 2;
					int var18 = (var15.sizeY * 4 - var16.subHeight) / 2;
					var16.drawAt(var1 * 4 + var17 + 48, var18 + (104 - var2 - var15.sizeY) * 4 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var19[var26] = var10;
						var19[var26 + 512] = var10;
						var19[var26 + 1024] = var10;
						var19[var26 + 1536] = var10;
					} else if (var8 == 1) {
						var19[var26] = var10;
						var19[var26 + 1] = var10;
						var19[var26 + 2] = var10;
						var19[var26 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 3] = var10;
						var19[var26 + 512 + 3] = var10;
						var19[var26 + 1024 + 3] = var10;
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var19[var26 + 1536] = var10;
						var19[var26 + 1536 + 1] = var10;
						var19[var26 + 1536 + 2] = var10;
						var19[var26 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var19[var26] = var10;
					} else if (var8 == 1) {
						var19[var26 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var19[var26 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var19[var26] = var10;
						var19[var26 + 512] = var10;
						var19[var26 + 1024] = var10;
						var19[var26 + 1536] = var10;
					} else if (var8 == 0) {
						var19[var26] = var10;
						var19[var26 + 1] = var10;
						var19[var26 + 2] = var10;
						var19[var26 + 3] = var10;
					} else if (var8 == 1) {
						var19[var26 + 3] = var10;
						var19[var26 + 512 + 3] = var10;
						var19[var26 + 1024 + 3] = var10;
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 1536] = var10;
						var19[var26 + 1536 + 1] = var10;
						var19[var26 + 1536 + 2] = var10;
						var19[var26 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = WorldMapArea.scene.getGameObjectTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = WorldMapArea.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = UserComparator8.Entity_unpackID(var5);
			ObjectDefinition var20 = WorldMapDecorationType.getObjectDefinition(var10);
			if (var20.mapSceneId != -1) {
				IndexedSprite var28 = GrandExchangeOfferWorldComparator.mapSceneSprites[var20.mapSceneId];
				if (var28 != null) {
					var26 = (var20.sizeX * 4 - var28.subWidth) / 2;
					var14 = (var20.sizeY * 4 - var28.subHeight) / 2;
					var28.drawAt(var26 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + var14 + 48);
				}
			} else if (var9 == 9) {
				int var25 = 15658734;
				boolean var27 = var5 != 0L;
				if (var27) {
					boolean var23 = (int)(var5 >>> 16 & 1L) == 1;
					var27 = !var23;
				}

				if (var27) {
					var25 = 15597568;
				}

				int[] var24 = FloorDecoration.sceneMinimapSprite.pixels;
				int var29 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var24[var29] = var25;
					var24[var29 + 1 + 512] = var25;
					var24[var29 + 1024 + 2] = var25;
					var24[var29 + 1536 + 3] = var25;
				} else {
					var24[var29 + 1536] = var25;
					var24[var29 + 1 + 1024] = var25;
					var24[var29 + 512 + 2] = var25;
					var24[var29 + 3] = var25;
				}
			}
		}

		var5 = WorldMapArea.scene.getFloorDecorationTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = UserComparator8.Entity_unpackID(var5);
			ObjectDefinition var21 = WorldMapDecorationType.getObjectDefinition(var7);
			if (var21.mapSceneId != -1) {
				IndexedSprite var22 = GrandExchangeOfferWorldComparator.mapSceneSprites[var21.mapSceneId];
				if (var22 != null) {
					var10 = (var21.sizeX * 4 - var22.subWidth) / 2;
					int var11 = (var21.sizeY * 4 - var22.subHeight) / 2;
					var22.drawAt(var1 * 4 + var10 + 48, (104 - var2 - var21.sizeY) * 4 + var11 + 48);
				}
			}
		}

	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "13"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (TextureProvider.loadInterface(var0)) {
			Widget[] var1 = Widget.Widget_interfaceComponents[var0];

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
