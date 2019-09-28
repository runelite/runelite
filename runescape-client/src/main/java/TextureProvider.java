import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("dz")
@Implements("TextureProvider")
public class TextureProvider implements TextureLoader {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Ldg;"
	)
	@Export("textures")
	Texture[] textures;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("deque")
	NodeDeque deque;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 707785193
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -55735149
	)
	@Export("remaining")
	int remaining;
	@ObfuscatedName("r")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 678440487
	)
	@Export("textureSize")
	int textureSize;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("archive")
	AbstractArchive archive;

	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;IDI)V"
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2135448801"
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
					if (this.archive.method4127(var8)) {
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

	@ObfuscatedName("n")
	@Export("setBrightness")
	public void setBrightness(double var1) {
		this.brightness = var1;
		this.clear();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IB)[I",
		garbageValue = "2"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1942090144"
	)
	@Export("getAverageTextureRGB")
	public int getAverageTextureRGB(int var1) {
		return this.textures[var1] != null ? this.textures[var1].averageRGB : 0;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1238853491"
	)
	public boolean vmethod3236(int var1) {
		return this.textures[var1].field1587;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-818075958"
	)
	@Export("isLowDetail")
	public boolean isLowDetail(int var1) {
		return this.textureSize == 64;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "170454088"
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "60"
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1068033058"
	)
	static void method2757() {
		Tiles.Tiles_minPlane = 99;
		Tiles.field501 = new byte[4][104][104];
		Tiles.field483 = new byte[4][104][104];
		DevicePcmPlayerProvider.field393 = new byte[4][104][104];
		class287.field3634 = new byte[4][104][104];
		Tiles.field488 = new int[4][105][105];
		Tiles.field486 = new byte[4][105][105];
		DevicePcmPlayerProvider.field386 = new int[105][105];
		Tiles.Tiles_hue = new int[104];
		ArchiveLoader.Tiles_saturation = new int[104];
		Tiles.Tiles_lightness = new int[104];
		FontName.Tiles_hueMultiplier = new int[104];
		Tiles.field487 = new int[104];
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
		garbageValue = "-14"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-114"
	)
	public static void method2746() {
		ParamDefinition.ParamDefinition_cached.clear();
	}
}
