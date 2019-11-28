import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Lis;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -960089161
	)
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1817892547
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -410650541
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 840325973
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("y")
	@Export("name")
	public String name;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1869859287
	)
	public int field3227;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1786922747
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("x")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("o")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("e")
	int[] field3228;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 6619485
	)
	int field3236;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 586150611
	)
	int field3230;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1667991799
	)
	int field3234;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 165335677
	)
	int field3226;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("t")
	int[] field3235;
	@ObfuscatedName("m")
	byte[] field3217;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -12980215
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
		this.field3236 = Integer.MAX_VALUE;
		this.field3230 = Integer.MAX_VALUE;
		this.field3234 = Integer.MIN_VALUE;
		this.field3226 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-1289247667"
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "946718360"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5618();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5618();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3227 = var1.readMedium();
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
				this.field3228 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3228[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3235 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3235.length; ++var5) {
					this.field3235[var5] = var1.readInt();
				}

				this.field3217 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3217[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5618();
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
					var1.method5618();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.field3458, HorizontalAlignment.field3462, HorizontalAlignment.HorizontalAlignment_centered};
					this.horizontalAlignment = (HorizontalAlignment)CollisionMap.findEnumerated(var6, var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)CollisionMap.findEnumerated(ArchiveLoader.method1177(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "147472747"
	)
	public void method4461() {
		if (this.field3228 != null) {
			for (int var1 = 0; var1 < this.field3228.length; var1 += 2) {
				if (this.field3228[var1] < this.field3236) {
					this.field3236 = this.field3228[var1];
				} else if (this.field3228[var1] > this.field3234) {
					this.field3234 = this.field3228[var1];
				}

				if (this.field3228[var1 + 1] < this.field3230) {
					this.field3230 = this.field3228[var1 + 1];
				} else if (this.field3228[var1 + 1] > this.field3226) {
					this.field3226 = this.field3228[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ZI)Lln;",
		garbageValue = "-39142083"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IB)Lln;",
		garbageValue = "-80"
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
				var2 = class288.SpriteBuffer_getSprite(class223.WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "2047"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(CI)C",
		garbageValue = "1312574148"
	)
	static char method4483(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "937254693"
	)
	@Export("formatItemStacks")
	static final String formatItemStacks(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + class222.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + class222.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + class222.colorStartTag(16776960) + var1 + "</col>";
		}
	}
}
