import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lio;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1778455375
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1839539911
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1328409781
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("z")
	@Export("name")
	public String name;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -66498181
	)
	public int field3216;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1404661325
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("p")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("n")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("u")
	int[] field3220;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 244845295
	)
	int field3221;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1082888487
	)
	int field3222;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 677837161
	)
	int field3223;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 639685945
	)
	int field3210;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("r")
	int[] field3229;
	@ObfuscatedName("o")
	byte[] field3218;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1088538707
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
		this.field3221 = Integer.MAX_VALUE;
		this.field3222 = Integer.MAX_VALUE;
		this.field3223 = Integer.MIN_VALUE;
		this.field3210 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-115"
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "2055926497"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5591();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5591();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3216 = var1.readMedium();
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
				this.field3220 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3220[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3229 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3229.length; ++var5) {
					this.field3229[var5] = var1.readInt();
				}

				this.field3218 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3218[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5591();
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
					var1.method5591();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)GrandExchangeEvent.findEnumerated(NetFileRequest.method4244(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)GrandExchangeEvent.findEnumerated(Coord.method4084(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1026224709"
	)
	public void method4466() {
		if (this.field3220 != null) {
			for (int var1 = 0; var1 < this.field3220.length; var1 += 2) {
				if (this.field3220[var1] < this.field3221) {
					this.field3221 = this.field3220[var1];
				} else if (this.field3220[var1] > this.field3223) {
					this.field3223 = this.field3220[var1];
				}

				if (this.field3220[var1 + 1] < this.field3222) {
					this.field3222 = this.field3220[var1 + 1];
				} else if (this.field3220[var1 + 1] > this.field3210) {
					this.field3210 = this.field3220[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ZI)Lla;",
		garbageValue = "2050095285"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Lla;",
		garbageValue = "122291326"
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
				var2 = MusicPatchNode2.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
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
		garbageValue = "1436204675"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)Lib;",
		garbageValue = "-973838819"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
