import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1113181625
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1234847171
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 373180553
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("o")
	@Export("name")
	public String name;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1365135053
	)
	public int field3202;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -587387743
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("p")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("h")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("k")
	int[] field3206;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1273880721
	)
	int field3207;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1661547227
	)
	int field3208;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 805541175
	)
	int field3210;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1594590229
	)
	int field3209;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("z")
	int[] field3213;
	@ObfuscatedName("f")
	byte[] field3214;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1671485553
	)
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	public WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.menuActions = new String[5];
		this.field3207 = Integer.MAX_VALUE;
		this.field3208 = Integer.MAX_VALUE;
		this.field3210 = Integer.MIN_VALUE;
		this.field3209 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkc;B)V",
		garbageValue = "-120"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "-1243496491"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5638();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5638();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3202 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
				}

				if ((var3 & 2) == 2) {
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field3206 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3206[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3213 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3213.length; ++var5) {
					this.field3213[var5] = var1.readInt();
				}

				this.field3214 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3214[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5638();
				} else if (var2 == 19) {
					this.category = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method5638();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.field3449, HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field3447};
					this.horizontalAlignment = (HorizontalAlignment)WorldMapIcon_1.findEnumerated(var6, var1.readUnsignedByte());
				} else if (var2 == 30) {
					VerticalAlignment[] var7 = new VerticalAlignment[]{VerticalAlignment.field3182, VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3183};
					this.verticalAlignment = (VerticalAlignment)WorldMapIcon_1.findEnumerated(var7, var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-92"
	)
	public void method4533() {
		if (this.field3206 != null) {
			for (int var1 = 0; var1 < this.field3206.length; var1 += 2) {
				if (this.field3206[var1] < this.field3207) {
					this.field3207 = this.field3206[var1];
				} else if (this.field3206[var1] > this.field3210) {
					this.field3210 = this.field3206[var1];
				}

				if (this.field3206[var1 + 1] < this.field3208) {
					this.field3208 = this.field3206[var1 + 1];
				} else if (this.field3206[var1 + 1] > this.field3209) {
					this.field3209 = this.field3206[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ZI)Llx;",
		garbageValue = "-1029203839"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Llx;",
		garbageValue = "-2136514636"
	)
	@Export("getSprite")
	Sprite getSprite(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			Sprite var2 = (Sprite)WorldMapElement_cachedSprites.get((long)var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = MenuAction.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2112265635"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1603440113"
	)
	@Export("isCharPrintable")
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') {
			return true;
		} else if (var0 >= 160 && var0 <= 255) {
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
		}
	}

	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
		garbageValue = "46"
	)
	static String method4547(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (MilliClock.field1994 != null) {
			var3 = "/p=" + MilliClock.field1994;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + WorldMapSection1.clientLanguage + "/a=" + class339.field4041 + var3 + "/";
	}
}
