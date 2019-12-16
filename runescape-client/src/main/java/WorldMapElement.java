import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMapElement_archive")
	static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Lit;"
	)
	@Export("WorldMapElement_cached")
	static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("WorldMapElement_cachedSprites")
	public static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -38759309
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1854966479
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2114919513
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("x")
	@Export("name")
	public String name;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1045588681
	)
	public int field3195;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1328245247
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("o")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("v")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("k")
	int[] field3193;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1400114557
	)
	int field3194;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1081967223
	)
	int field3196;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1335511975
	)
	int field3185;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -512378151
	)
	int field3191;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("z")
	int[] field3200;
	@ObfuscatedName("h")
	byte[] field3198;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1672409627
	)
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.menuActions = new String[5];
		this.field3194 = Integer.MAX_VALUE;
		this.field3196 = Integer.MAX_VALUE;
		this.field3185 = Integer.MIN_VALUE;
		this.field3191 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-354454893"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkq;IB)V",
		garbageValue = "-19"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5560();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5560();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3195 = var1.readMedium();
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
				this.field3193 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3193[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3200 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3200.length; ++var5) {
					this.field3200[var5] = var1.readInt();
				}

				this.field3198 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3198[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5560();
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
					var1.method5560();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)DynamicObject.findEnumerated(UserComparator8.method3329(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					VerticalAlignment[] var6 = new VerticalAlignment[]{VerticalAlignment.field3170, VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3169};
					this.verticalAlignment = (VerticalAlignment)DynamicObject.findEnumerated(var6, var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-37"
	)
	void method4360() {
		if (this.field3193 != null) {
			for (int var1 = 0; var1 < this.field3193.length; var1 += 2) {
				if (this.field3193[var1] < this.field3194) {
					this.field3194 = this.field3193[var1];
				} else if (this.field3193[var1] > this.field3185) {
					this.field3185 = this.field3193[var1];
				}

				if (this.field3193[var1 + 1] < this.field3196) {
					this.field3196 = this.field3193[var1 + 1];
				} else if (this.field3193[var1 + 1] > this.field3191) {
					this.field3191 = this.field3193[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ZI)Lls;",
		garbageValue = "-899007822"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)Lls;",
		garbageValue = "-12"
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
				var2 = FloorUnderlayDefinition.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-837340912"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-61660598"
	)
	static void method4381(String var0) {
		UserComparator10.field1943 = var0;

		try {
			String var1 = class206.client.getParameter(Integer.toString(18));
			String var2 = class206.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				var3 = var3 + "; Expires=" + class48.method864(WorldMapID.currentTimeMillis() + 94608000000L) + "; Max-Age=" + 94608000L;
			}

			class46.method846(class206.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var4) {
		}

	}
}
