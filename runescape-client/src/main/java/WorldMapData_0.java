import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
	@ObfuscatedName("qb")
	@ObfuscatedGetter(
		intValue = -1984844597
	)
	static int field92;
	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;

	WorldMapData_0() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-2087111410"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field252.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 64;
			super.regionYLow = var1.readUnsignedShort() * 4096;
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			super.groupId = var1.method5560();
			super.fileId = var1.method5560();
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "1425420215"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field150 = new byte[super.planes][64][64];
		super.field149 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field246.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY) {
				for (int var5 = 0; var5 < 64; ++var5) {
					for (int var6 = 0; var6 < 64; ++var6) {
						this.readTile(var5, var6, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_0)) {
			return false;
		} else {
			WorldMapData_0 var2 = (WorldMapData_0)var1;
			return super.regionX == var2.regionX && super.regionY == var2.regionY;
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lls;IIII)V",
		garbageValue = "-1317915753"
	)
	static void method169(Sprite var0, int var1, int var2, int var3) {
		DemotingHashTable var4 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var6 = (long)(var3 << 16 | var1 << 8 | var2);
		var4.put(var0, var6, var0.pixels.length * 4);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-45"
	)
	public static int method164(int var0, int var1) {
		int var2 = var0 >>> 31;
		return (var0 + var2) / var1 - var2;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIZB)Ljava/lang/String;",
		garbageValue = "118"
	)
	static String method163(int var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			if (var2 && var0 >= 0) {
				int var3 = 2;

				for (int var4 = var0 / var1; var4 != 0; ++var3) {
					var4 /= var1;
				}

				char[] var5 = new char[var3];
				var5[0] = '+';

				for (int var6 = var3 - 1; var6 > 0; --var6) {
					int var7 = var0;
					var0 /= var1;
					int var8 = var7 - var0 * var1;
					if (var8 >= 10) {
						var5[var6] = (char)(var8 + 87);
					} else {
						var5[var6] = (char)(var8 + 48);
					}
				}

				return new String(var5);
			} else {
				return Integer.toString(var0, var1);
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-991747570"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		InterfaceParent.logOut();
		switch(var0) {
		case 1:
			Login.loginIndex = 24;
			AbstractWorldMapData.setLoginResponseString("", "You were disconnected from the server.", "");
			break;
		case 2:
			Login.loginIndex = 24;
			AbstractWorldMapData.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
		}

	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1702503786"
	)
	@Export("selectSpell")
	static void selectSpell(int var0, int var1, int var2, int var3) {
		Widget var4 = BZip2State.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			Client.runScriptEvent(var5);
		}

		Client.field785 = var3;
		Client.isSpellSelected = true;
		WorldMapDecoration.selectedSpellWidget = var0;
		Client.selectedSpellChildIndex = var1;
		ReflectionCheck.selectedSpellFlags = var2;
		LoginPacket.invalidateWidget(var4);
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(Lha;I)Z",
		garbageValue = "-2123617287"
	)
	@Export("runCs1")
	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) {
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
				int var2 = User.method5076(var0, var1);
				int var3 = var0.cs1ComparisonValues[var1];
				if (var0.cs1Comparisons[var1] == 2) {
					if (var2 >= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) {
					if (var2 <= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) {
					if (var3 == var2) {
						return false;
					}
				} else if (var3 != var2) {
					return false;
				}
			}

			return true;
		}
	}
}
