import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[Lij;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1558298053
	)
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("WorldMapElement_cachedSprites")
	public static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1924770341
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1840035745
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1186818379
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("m")
	@Export("name")
	public String name;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1029556521
	)
	public int field3195;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1307651093
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("b")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("o")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("a")
	int[] field3189;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 404495527
	)
	int field3200;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1206163627
	)
	int field3198;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1982173019
	)
	int field3202;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1981308333
	)
	int field3203;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lim;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("s")
	int[] field3194;
	@ObfuscatedName("f")
	byte[] field3207;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1937119401
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
		this.field3200 = Integer.MAX_VALUE;
		this.field3198 = Integer.MAX_VALUE;
		this.field3202 = Integer.MIN_VALUE;
		this.field3203 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-1143859499"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-195345385"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5453();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5453();
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
				this.field3189 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3189[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3194 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3194.length; ++var5) {
					this.field3194[var5] = var1.readInt();
				}

				this.field3207 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3207[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5453();
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
					var1.method5453();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)NetSocket.findEnumerated(PlayerAppearance.method4012(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					VerticalAlignment[] var6 = new VerticalAlignment[]{VerticalAlignment.field3172, VerticalAlignment.field3170, VerticalAlignment.VerticalAlignment_centered};
					this.verticalAlignment = (VerticalAlignment)NetSocket.findEnumerated(var6, var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "9"
	)
	public void method4350() {
		if (this.field3189 != null) {
			for (int var1 = 0; var1 < this.field3189.length; var1 += 2) {
				if (this.field3189[var1] < this.field3200) {
					this.field3200 = this.field3189[var1];
				} else if (this.field3189[var1] > this.field3202) {
					this.field3202 = this.field3189[var1];
				}

				if (this.field3189[var1 + 1] < this.field3198) {
					this.field3198 = this.field3189[var1 + 1];
				} else if (this.field3189[var1 + 1] > this.field3203) {
					this.field3203 = this.field3189[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ZB)Llf;",
		garbageValue = "-63"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Llf;",
		garbageValue = "-444494070"
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
				var2 = NPCDefinition.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1309666771"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1979971580"
	)
	public static void method4360(int var0, int var1) {
		VarbitDefinition var3 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var8 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var3 = new VarbitDefinition();
			if (var8 != null) {
				var3.decode(new Buffer(var8));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var3, (long)var0);
			var2 = var3;
		}

		int var4 = var2.baseVar;
		int var5 = var2.startBit;
		int var6 = var2.endBit;
		int var7 = Varps.Varps_masks[var6 - var5];
		if (var1 < 0 || var1 > var7) {
			var1 = 0;
		}

		var7 <<= var5;
		Varps.Varps_main[var4] = Varps.Varps_main[var4] & ~var7 | var1 << var5 & var7;
	}
}
