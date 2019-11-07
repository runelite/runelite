import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("TextureProvider")
public class TextureProvider implements TextureLoader {
	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("crossSprites")
	static Sprite[] crossSprites;
	@ObfuscatedName("kt")
	@ObfuscatedGetter(
		intValue = 831989681
	)
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "[Ldt;"
	)
	@Export("textures")
	Texture[] textures;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("deque")
	NodeDeque deque;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1515025837
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -684430177
	)
	@Export("remaining")
	int remaining;
	@ObfuscatedName("v")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -113629701
	)
	@Export("textureSize")
	int textureSize;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("archive")
	AbstractArchive archive;

	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;IDI)V"
	)
	public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
		this.deque = new NodeDeque();
		this.remaining = 0;
		this.brightness = 1.0D;
		this.textureSize = 128;
		this.archive = var2;
		this.capacity = var3;
		this.remaining = this.capacity;
		this.brightness = var4;
		this.textureSize = var6;
		int[] var7 = var1.getGroupFileIds(0);
		int var8 = var7.length;
		this.textures = new Texture[var1.getGroupFileCount(0)];

		for (int var9 = 0; var9 < var8; ++var9) {
			Buffer var10 = new Buffer(var1.takeFile(0, var7[var9]));
			this.textures[var7[var9]] = new Texture(var10);
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-723881921"
	)
	@Export("getLoadedPercentage")
	public int getLoadedPercentage() {
		int var1 = 0;
		int var2 = 0;
		Texture[] var3 = this.textures;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			Texture var5 = var3[var4];
			if (var5 != null && var5.fileIds != null) {
				var1 += var5.fileIds.length;
				int[] var6 = var5.fileIds;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					int var8 = var6[var7];
					if (this.archive.method4327(var8)) {
						++var2;
					}
				}
			}
		}

		if (var1 == 0) {
			return 0;
		} else {
			return var2 * 100 / var1;
		}
	}

	@ObfuscatedName("t")
	@Export("setBrightness")
	public void setBrightness(double var1) {
		this.brightness = var1;
		this.clear();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-1956127937"
	)
	@Export("getTexturePixels")
	public int[] getTexturePixels(int var1) {
		Texture var2 = this.textures[var1];
		if (var2 != null) {
			if (var2.pixels != null) {
				this.deque.addLast(var2);
				var2.isLoaded = true;
				return var2.pixels;
			}

			boolean var3 = var2.load(this.brightness, this.textureSize, this.archive);
			if (var3) {
				if (this.remaining == 0) {
					Texture var4 = (Texture)this.deque.removeFirst();
					var4.reset();
				} else {
					--this.remaining;
				}

				this.deque.addLast(var2);
				var2.isLoaded = true;
				return var2.pixels;
			}
		}

		return null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-57"
	)
	@Export("getAverageTextureRGB")
	public int getAverageTextureRGB(int var1) {
		return this.textures[var1] != null ? this.textures[var1].averageRGB : 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1875777180"
	)
	public boolean vmethod3403(int var1) {
		return this.textures[var1].field1593;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1105399782"
	)
	@Export("isLowDetail")
	public boolean isLowDetail(int var1) {
		return this.textureSize == 64;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-519543522"
	)
	@Export("clear")
	public void clear() {
		for (int var1 = 0; var1 < this.textures.length; ++var1) {
			if (this.textures[var1] != null) {
				this.textures[var1].reset();
			}
		}

		this.deque = new NodeDeque();
		this.remaining = this.capacity;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "456735268"
	)
	@Export("animate")
	public void animate(int var1) {
		for (int var2 = 0; var2 < this.textures.length; ++var2) {
			Texture var3 = this.textures[var2];
			if (var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
				var3.animate(var1);
				var3.isLoaded = false;
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1911421748"
	)
	public static boolean method2931(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "828807862"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (class215.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!Coord.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = Coord.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				class215.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (Widget.Widget_interfaceComponents[var0] == null) {
					Widget.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (Widget.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = Coord.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							Widget.Widget_interfaceComponents[var0][var2] = new Widget();
							Widget.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								Widget.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								Widget.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				class215.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("lh")
	@ObfuscatedSignature(
		signature = "(Lhi;B)Lhi;",
		garbageValue = "7"
	)
	static Widget method2909(Widget var0) {
		int var2 = class195.getWidgetClickMask(var0);
		int var1 = var2 >> 17 & 7;
		int var3 = var1;
		if (var1 == 0) {
			return null;
		} else {
			for (int var4 = 0; var4 < var3; ++var4) {
				var0 = PacketBufferNode.getWidget(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}
