import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Liw;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -846582449
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 248724911
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 473638347
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("i")
	@Export("name")
	public String name;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1731213053
	)
	public int field3217;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1939800195
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("u")
	@Export("strings")
	public String[] strings;
	@ObfuscatedName("x")
	@Export("string1")
	public String string1;
	@ObfuscatedName("r")
	int[] field3221;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 584750185
	)
	int field3222;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 908052841
	)
	int field3223;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -310968273
	)
	int field3224;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 961137775
	)
	int field3231;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("h")
	int[] field3228;
	@ObfuscatedName("o")
	byte[] field3214;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -880485155
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
		this.strings = new String[5];
		this.field3222 = Integer.MAX_VALUE;
		this.field3223 = Integer.MAX_VALUE;
		this.field3224 = Integer.MIN_VALUE;
		this.field3231 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-2108629289"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "-1385963725"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5511();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5511();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3217 = var1.readMedium();
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
				this.strings[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field3221 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3221[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3228 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3228.length; ++var5) {
					this.field3228[var5] = var1.readInt();
				}

				this.field3214 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3214[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.string1 = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5511();
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
					var1.method5511();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.field3461, HorizontalAlignment.field3460, HorizontalAlignment.HorizontalAlignment_centered};
					this.horizontalAlignment = (HorizontalAlignment)SoundSystem.findEnumerated(var6, var1.readUnsignedByte());
				} else if (var2 == 30) {
					VerticalAlignment[] var7 = new VerticalAlignment[]{VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3195, VerticalAlignment.field3194};
					this.verticalAlignment = (VerticalAlignment)SoundSystem.findEnumerated(var7, var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2017602837"
	)
	public void method4370() {
		if (this.field3221 != null) {
			for (int var1 = 0; var1 < this.field3221.length; var1 += 2) {
				if (this.field3221[var1] < this.field3222) {
					this.field3222 = this.field3221[var1];
				} else if (this.field3221[var1] > this.field3224) {
					this.field3224 = this.field3221[var1];
				}

				if (this.field3221[var1 + 1] < this.field3223) {
					this.field3223 = this.field3221[var1 + 1];
				} else if (this.field3221[var1 + 1] > this.field3231) {
					this.field3231 = this.field3221[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ZI)Lly;",
		garbageValue = "1310169716"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Lly;",
		garbageValue = "-517237521"
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
				var2 = class65.loadSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "95"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "426729441"
	)
	static final void method4368(boolean var0) {
		class186.playPcmPlayers();
		++Client.packetWriter.field1319;
		if (Client.packetWriter.field1319 >= 50 || var0) {
			Client.packetWriter.field1319 = 0;
			if (!Client.field701 && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = Archive.method4265(ClientPacket.field2225, Client.packetWriter.isaacCipher);
				Client.packetWriter.method2219(var1);

				try {
					Client.packetWriter.method2234();
				} catch (IOException var3) {
					Client.field701 = true;
				}
			}

		}
	}
}
