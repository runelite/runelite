import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class3 implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lp;"
	)
	public static final class3 field7;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lp;"
	)
	public static final class3 field9;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lp;"
	)
	public static final class3 field14;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1932767747
	)
	final int field10;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -498462899
	)
	public final int field11;
	@ObfuscatedName("l")
	public final Class field12;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	final class0 field13;

	static {
		field7 = new class3(2, 0, Integer.class, new class1());
		field9 = new class3(1, 1, Long.class, new class2());
		field14 = new class3(0, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lq;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field10 = var1;
		this.field11 = var2;
		this.field12 = var3;
		this.field13 = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field11;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkf;I)Ljava/lang/Object;",
		garbageValue = "-25501823"
	)
	public Object method34(Buffer var1) {
		return this.field13.vmethod42(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkf;B)V",
		garbageValue = "1"
	)
	public static void method30(Object var0, Buffer var1) {
		class0 var2 = method31(var0.getClass());
		var2.vmethod43(var0, var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Lq;",
		garbageValue = "-961366401"
	)
	static class0 method31(Class var0) {
		class3[] var2 = new class3[]{field9, field14, field7};
		class3[] var3 = var2;
		int var4 = 0;

		class3 var1;
		while (true) {
			if (var4 >= var3.length) {
				var1 = null;
				break;
			}

			class3 var5 = var3[var4];
			if (var5.field12 == var0) {
				var1 = var5;
				break;
			}

			++var4;
		}

		if (var1 == null) {
			throw new IllegalArgumentException();
		} else {
			return var1.field13;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)I",
		garbageValue = "0"
	)
	@Export("parseInt")
	public static int parseInt(CharSequence var0) {
		return WorldMapSection1.parseIntCustomRadix(var0, 10, true);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-12"
	)
	public static int method33(int var0) {
		return WorldMapLabel.method420(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-890922875"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = GrandExchangeOfferWorldComparator.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var14;
		int var26;
		if (0L != var5) {
			var7 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			boolean var12 = 0L != var5;
			if (var12) {
				boolean var13 = (int)(var5 >>> 16 & 1L) == 1;
				var12 = !var13;
			}

			if (var12) {
				var10 = var4;
			}

			int[] var19 = RouteStrategy.sceneMinimapSprite.pixels;
			var26 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var14 = class43.method770(var5);
			ObjectDefinition var15 = ViewportMouse.getObjectDefinition(var14);
			if (var15.mapSceneId != -1) {
				IndexedSprite var16 = ClanChat.mapSceneSprites[var15.mapSceneId];
				if (var16 != null) {
					int var17 = (var15.sizeX * 4 - var16.subWidth) / 2;
					int var18 = (var15.sizeY * 4 - var16.subHeight) / 2;
					var16.drawAt(var17 + var1 * 4 + 48, (104 - var2 - var15.sizeY) * 4 + var18 + 48);
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

		var5 = GrandExchangeOfferWorldComparator.scene.getGameObjectTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = class43.method770(var5);
			ObjectDefinition var20 = ViewportMouse.getObjectDefinition(var10);
			if (var20.mapSceneId != -1) {
				IndexedSprite var28 = ClanChat.mapSceneSprites[var20.mapSceneId];
				if (var28 != null) {
					var26 = (var20.sizeX * 4 - var28.subWidth) / 2;
					var14 = (var20.sizeY * 4 - var28.subHeight) / 2;
					var28.drawAt(var26 + var1 * 4 + 48, var14 + (104 - var2 - var20.sizeY) * 4 + 48);
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

				int[] var24 = RouteStrategy.sceneMinimapSprite.pixels;
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

		var5 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = class43.method770(var5);
			ObjectDefinition var21 = ViewportMouse.getObjectDefinition(var7);
			if (var21.mapSceneId != -1) {
				IndexedSprite var22 = ClanChat.mapSceneSprites[var21.mapSceneId];
				if (var22 != null) {
					var10 = (var21.sizeX * 4 - var22.subWidth) / 2;
					int var11 = (var21.sizeY * 4 - var22.subHeight) / 2;
					var22.drawAt(var10 + var1 * 4 + 48, var11 + (104 - var2 - var21.sizeY) * 4 + 48);
				}
			}
		}

	}
}
