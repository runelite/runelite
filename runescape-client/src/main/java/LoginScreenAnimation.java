import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("b")
	int[] field1042;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1717008553
	)
	int field1058;
	@ObfuscatedName("c")
	int[] field1044;
	@ObfuscatedName("f")
	int[] field1045;
	@ObfuscatedName("m")
	int[] field1046;
	@ObfuscatedName("u")
	int[] field1047;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2128952243
	)
	int field1048;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1545183041
	)
	int field1049;
	@ObfuscatedName("v")
	int[] field1039;
	@ObfuscatedName("y")
	int[] field1043;
	@ObfuscatedName("g")
	int[] field1041;
	@ObfuscatedName("a")
	int[] field1053;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1480925265
	)
	int field1054;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 826478180
	)
	int field1055;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1956845489
	)
	int field1056;

	@ObfuscatedSignature(
		signature = "([Llx;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1042 = new int[256];
		this.field1058 = 0;
		this.field1048 = 0;
		this.field1049 = 0;
		this.field1054 = 0;
		this.field1055 = 0;
		this.field1056 = 0;
		this.sprites = var1;
		this.method1721();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1195148401"
	)
	void method1721() {
		this.field1045 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1045[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1045[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1045[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1045[var1 + 192] = 16777215;
		}

		this.field1046 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1046[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1046[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1046[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1046[var1 + 192] = 16777215;
		}

		this.field1047 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1 + 192] = 16777215;
		}

		this.field1044 = new int[256];
		this.field1054 = 0;
		this.field1041 = new int[32768];
		this.field1053 = new int[32768];
		this.method1723((IndexedSprite)null);
		this.field1039 = new int[32768];
		this.field1043 = new int[32768];
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	void method1720() {
		this.field1045 = null;
		this.field1046 = null;
		this.field1047 = null;
		this.field1044 = null;
		this.field1041 = null;
		this.field1053 = null;
		this.field1039 = null;
		this.field1043 = null;
		this.field1054 = 0;
		this.field1055 = 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-86"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1039 == null) {
			this.method1721();
		}

		if (this.field1056 == 0) {
			this.field1056 = var2;
		}

		int var3 = var2 - this.field1056;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1056 = var2;
		if (var3 > 0) {
			this.method1722(var3);
		}

		this.method1726(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2053204142"
	)
	final void method1722(int var1) {
		this.field1054 += 128 * var1;
		int var2;
		if (this.field1054 > this.field1041.length) {
			this.field1054 -= this.field1041.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1723(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1039[var3 + var2] - this.field1041[var2 + this.field1054 & this.field1041.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1039[var2++] = var6;
		}

		byte var15 = 10;
		var6 = 128 - var15;

		int var7;
		int var10;
		for (var7 = 256 - var1; var7 < 256; ++var7) {
			int var8 = var7 * 128;

			for (int var9 = 0; var9 < 128; ++var9) {
				var10 = (int)(Math.random() * 100.0D);
				if (var10 < 50 && var9 > var15 && var9 < var6) {
					this.field1039[var9 + var8] = 255;
				} else {
					this.field1039[var9 + var8] = 0;
				}
			}
		}

		if (this.field1048 * 16 > 0) {
			this.field1048 = this.field1048 * 16 - var1 * 4;
		}

		if (this.field1049 * 16 > 0) {
			this.field1049 = this.field1049 * 16 - var1 * 4;
		}

		if (this.field1048 * 16 == 0 && this.field1049 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1048 = 1024;
			}

			if (var7 == 1) {
				this.field1049 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1042[var7] = this.field1042[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1042[var7] = (int)(Math.sin((double)this.field1058 / 14.0D) * 16.0D + Math.sin((double)this.field1058 / 15.0D) * 14.0D + Math.sin((double)this.field1058 / 16.0D) * 12.0D);
			++this.field1058;
		}

		this.field1055 = this.field1055 * 10000 + var1 * 100;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1055 * 10000; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1039[var12 + (var13 << 7)] = 192;
			}

			this.field1055 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var7 + var14 < 128) {
						var12 += this.field1039[var13 + var14 + var7];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1039[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1043[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1043[var14 + var11 + var7 * 128];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1043[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1039[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1694024652"
	)
	final int method1725(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) + (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) >> 8;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1640931413"
	)
	final void method1726(int var1) {
		int var2 = this.field1044.length;
		if (this.field1048 * 16 > 0) {
			this.method1727(this.field1048 * 16, this.field1046);
		} else if (this.field1049 * 16 > 0) {
			this.method1727(this.field1049 * 16, this.field1047);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1044[var3] = this.field1045[var3];
			}
		}

		this.method1728(var1);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I[IB)V",
		garbageValue = "117"
	)
	final void method1727(int var1, int[] var2) {
		int var3 = this.field1044.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1044[var4] = this.method1725(this.field1045[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1044[var4] = var2[var4];
			} else {
				this.field1044[var4] = this.method1725(var2[var4], this.field1045[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "379301456"
	)
	final void method1728(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1042[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= MusicPatchPcmStream.rasterProvider.width) {
				var7 = MusicPatchPcmStream.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * MusicPatchPcmStream.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1039[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1044[var10];
					int var14 = MusicPatchPcmStream.rasterProvider.pixels[var8];
					MusicPatchPcmStream.rasterProvider.pixels[var8++] = -16777216 | (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) + ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Llx;I)V",
		garbageValue = "956004569"
	)
	final void method1723(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1041.length; ++var2) {
			this.field1041[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1041[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1053[var5] = (this.field1041[var5 + 128] + this.field1041[var5 - 128] + this.field1041[var5 + 1] + this.field1041[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1041;
			this.field1041 = this.field1053;
			this.field1053 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1041[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1877742024"
	)
	static int method1744(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "806808180"
	)
	static final void method1724(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var8 = var6 - 334;
		if (var8 < 0) {
			var8 = 0;
		} else if (var8 > 100) {
			var8 = 100;
		}

		int var9 = (Client.field908 - Client.field906) * var8 / 100 + Client.field906;
		int var7 = var5 * var9 / 256;
		var8 = 2048 - var3 & 2047;
		var9 = 2048 - var4 & 2047;
		int var10 = 0;
		int var11 = 0;
		int var12 = var7;
		int var13;
		int var14;
		int var15;
		if (var8 != 0) {
			var13 = Rasterizer3D.Rasterizer3D_sine[var8];
			var14 = Rasterizer3D.Rasterizer3D_cosine[var8];
			var15 = var11 * var14 - var13 * var7 >> 16;
			var12 = var11 * var13 + var14 * var7 >> 16;
			var11 = var15;
		}

		if (var9 != 0) {
			var13 = Rasterizer3D.Rasterizer3D_sine[var9];
			var14 = Rasterizer3D.Rasterizer3D_cosine[var9];
			var15 = var13 * var12 + var14 * var10 >> 16;
			var12 = var14 * var12 - var13 * var10 >> 16;
			var10 = var15;
		}

		PacketBuffer.cameraX = var0 - var10;
		class43.cameraY = var1 - var11;
		class1.cameraZ = var2 - var12;
		GrandExchangeOfferNameComparator.cameraPitch = var3;
		Interpreter.cameraYaw = var4;
		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (MouseHandler.oculusOrbFocalPointX >> 7 != Client.localPlayer.x >> 7 || WorldMapArea.oculusOrbFocalPointY >> 7 != Client.localPlayer.y >> 7)) {
			var13 = Client.localPlayer.plane;
			var14 = MusicPatchNode2.baseX * 64 + (MouseHandler.oculusOrbFocalPointX >> 7);
			var15 = class1.baseY * 64 + (WorldMapArea.oculusOrbFocalPointY >> 7);
			WorldMapLabel.method418(var14, var15, var13, true);
		}

	}
}
