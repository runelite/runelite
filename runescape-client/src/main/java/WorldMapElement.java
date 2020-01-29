import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		intValue = -137008991
	)
	static int field3230;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("WorldMapElement_archive")
	static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lim;"
	)
	@Export("WorldMapElement_cached")
	static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1867958927
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1771257793
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 2048947883
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("l")
	@Export("name")
	public String name;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1188038203
	)
	public int field3215;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1641997247
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("h")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("v")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("n")
	int[] field3220;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1973467605
	)
	int field3217;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1618776483
	)
	int field3222;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 249158163
	)
	int field3223;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1378552349
	)
	int field3224;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lic;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("f")
	int[] field3227;
	@ObfuscatedName("b")
	byte[] field3228;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 689795533
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
		this.field3217 = Integer.MAX_VALUE;
		this.field3222 = Integer.MAX_VALUE;
		this.field3223 = Integer.MIN_VALUE;
		this.field3224 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "1991794864"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;IS)V",
		garbageValue = "32767"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5593();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5593();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3215 = var1.readMedium();
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
				this.field3227 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3227.length; ++var5) {
					this.field3227[var5] = var1.readInt();
				}

				this.field3228 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3228[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5593();
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
					var1.method5593();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)WorldMapSection0.findEnumerated(GraphicsObject.method2064(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)WorldMapSection0.findEnumerated(Message.method1229(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1639524352"
	)
	void method4449() {
		if (this.field3220 != null) {
			for (int var1 = 0; var1 < this.field3220.length; var1 += 2) {
				if (this.field3220[var1] < this.field3217) {
					this.field3217 = this.field3220[var1];
				} else if (this.field3220[var1] > this.field3223) {
					this.field3223 = this.field3220[var1];
				}

				if (this.field3220[var1 + 1] < this.field3222) {
					this.field3222 = this.field3220[var1 + 1];
				} else if (this.field3220[var1 + 1] > this.field3224) {
					this.field3224 = this.field3220[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ZB)Llt;",
		garbageValue = "33"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Llt;",
		garbageValue = "-1731622138"
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
				var2 = WorldMapSection1.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1106641241"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	public static void method4470() {
		if (NetCache.NetCache_socket != null) {
			NetCache.NetCache_socket.close();
		}

	}
}
