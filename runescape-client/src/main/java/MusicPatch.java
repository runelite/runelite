import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("MusicPatch")
public class MusicPatch extends Node {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1055401795
	)
	int field2459;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "[Lco;"
	)
	@Export("rawSounds")
	RawSound[] rawSounds;
	@ObfuscatedName("i")
	short[] field2457;
	@ObfuscatedName("k")
	byte[] field2462;
	@ObfuscatedName("u")
	byte[] field2463;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[Lgf;"
	)
	MusicPatchNode2[] field2460;
	@ObfuscatedName("t")
	byte[] field2461;
	@ObfuscatedName("q")
	int[] field2455;

	MusicPatch(byte[] var1) {
		this.rawSounds = new RawSound[128];
		this.field2457 = new short[128];
		this.field2462 = new byte[128];
		this.field2463 = new byte[128];
		this.field2460 = new MusicPatchNode2[128];
		this.field2461 = new byte[128];
		this.field2455 = new int[128];
		Buffer var2 = new Buffer(var1);

		int var3;
		for (var3 = 0; var2.array[var3 + var2.offset] != 0; ++var3) {
		}

		byte[] var4 = new byte[var3];

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			var4[var5] = var2.readByte();
		}

		++var2.offset;
		++var3;
		var5 = var2.offset;
		var2.offset += var3;

		int var6;
		for (var6 = 0; var2.array[var6 + var2.offset] != 0; ++var6) {
		}

		byte[] var7 = new byte[var6];

		int var8;
		for (var8 = 0; var8 < var6; ++var8) {
			var7[var8] = var2.readByte();
		}

		++var2.offset;
		++var6;
		var8 = var2.offset;
		var2.offset += var6;

		int var9;
		for (var9 = 0; var2.array[var9 + var2.offset] != 0; ++var9) {
		}

		byte[] var10 = new byte[var9];

		for (int var11 = 0; var11 < var9; ++var11) {
			var10[var11] = var2.readByte();
		}

		++var2.offset;
		++var9;
		byte[] var36 = new byte[var9];
		int var12;
		int var14;
		if (var9 > 1) {
			var36[1] = 1;
			int var13 = 1;
			var12 = 2;

			for (var14 = 2; var14 < var9; ++var14) {
				int var15 = var2.readUnsignedByte();
				if (var15 == 0) {
					var13 = var12++;
				} else {
					if (var15 <= var13) {
						--var15;
					}

					var13 = var15;
				}

				var36[var14] = (byte)var13;
			}
		} else {
			var12 = var9;
		}

		MusicPatchNode2[] var37 = new MusicPatchNode2[var12];

		MusicPatchNode2 var38;
		for (var14 = 0; var14 < var37.length; ++var14) {
			var38 = var37[var14] = new MusicPatchNode2();
			int var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var38.field2369 = new byte[var16 * 2];
			}

			var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var38.field2370 = new byte[var16 * 2 + 2];
				var38.field2370[1] = 64;
			}
		}

		var14 = var2.readUnsignedByte();
		byte[] var45 = var14 > 0 ? new byte[var14 * 2] : null;
		var14 = var2.readUnsignedByte();
		byte[] var39 = var14 > 0 ? new byte[var14 * 2] : null;

		int var17;
		for (var17 = 0; var2.array[var17 + var2.offset] != 0; ++var17) {
		}

		byte[] var18 = new byte[var17];

		int var19;
		for (var19 = 0; var19 < var17; ++var19) {
			var18[var19] = var2.readByte();
		}

		++var2.offset;
		++var17;
		var19 = 0;

		int var20;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			this.field2457[var20] = (short)var19;
		}

		var19 = 0;

		short[] var48;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			var48 = this.field2457;
			var48[var20] = (short)(var48[var20] + (var19 << 8));
		}

		var20 = 0;
		int var21 = 0;
		int var22 = 0;

		int var23;
		for (var23 = 0; var23 < 128; ++var23) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				var22 = var2.readVarInt();
			}

			var48 = this.field2457;
			var48[var23] = (short)(var48[var23] + ((var22 - 1 & 2) << 14));
			this.field2455[var23] = var22;
			--var20;
		}

		var20 = 0;
		var21 = 0;
		var23 = 0;

		int var24;
		for (var24 = 0; var24 < 128; ++var24) {
			if (this.field2455[var24] != 0) {
				if (var20 == 0) {
					if (var21 < var4.length) {
						var20 = var4[var21++];
					} else {
						var20 = -1;
					}

					var23 = var2.array[var5++] - 1;
				}

				this.field2461[var24] = (byte)var23;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var24 = 0;

		for (int var25 = 0; var25 < 128; ++var25) {
			if (this.field2455[var25] != 0) {
				if (var20 == 0) {
					if (var21 < var7.length) {
						var20 = var7[var21++];
					} else {
						var20 = -1;
					}

					var24 = var2.array[var8++] + 16 << 2;
				}

				this.field2463[var25] = (byte)var24;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		MusicPatchNode2 var40 = null;

		int var26;
		for (var26 = 0; var26 < 128; ++var26) {
			if (this.field2455[var26] != 0) {
				if (var20 == 0) {
					var40 = var37[var36[var21]];
					if (var21 < var10.length) {
						var20 = var10[var21++];
					} else {
						var20 = -1;
					}
				}

				this.field2460[var26] = var40;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var26 = 0;

		int var27;
		for (var27 = 0; var27 < 128; ++var27) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				if (this.field2455[var27] > 0) {
					var26 = var2.readUnsignedByte() + 1;
				}
			}

			this.field2462[var27] = (byte)var26;
			--var20;
		}

		this.field2459 = var2.readUnsignedByte() + 1;

		MusicPatchNode2 var28;
		int var29;
		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2369 != null) {
				for (var29 = 1; var29 < var28.field2369.length; var29 += 2) {
					var28.field2369[var29] = var2.readByte();
				}
			}

			if (var28.field2370 != null) {
				for (var29 = 3; var29 < var28.field2370.length - 2; var29 += 2) {
					var28.field2370[var29] = var2.readByte();
				}
			}
		}

		if (var45 != null) {
			for (var27 = 1; var27 < var45.length; var27 += 2) {
				var45[var27] = var2.readByte();
			}
		}

		if (var39 != null) {
			for (var27 = 1; var27 < var39.length; var27 += 2) {
				var39[var27] = var2.readByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2370 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var28.field2370.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var28.field2370[var29] = (byte)var19;
				}
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2369 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var28.field2369.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var28.field2369[var29] = (byte)var19;
				}
			}
		}

		byte var30;
		int var32;
		int var33;
		int var34;
		int var42;
		byte var44;
		if (var45 != null) {
			var19 = var2.readUnsignedByte();
			var45[0] = (byte)var19;

			for (var27 = 2; var27 < var45.length; var27 += 2) {
				var19 = var19 + 1 + var2.readUnsignedByte();
				var45[var27] = (byte)var19;
			}

			var44 = var45[0];
			byte var41 = var45[1];

			for (var29 = 0; var29 < var44; ++var29) {
				this.field2462[var29] = (byte)(var41 * this.field2462[var29] + 32 >> 6);
			}

			for (var29 = 2; var29 < var45.length; var29 += 2) {
				var30 = var45[var29];
				byte var31 = var45[var29 + 1];
				var32 = var41 * (var30 - var44) + (var30 - var44) / 2;

				for (var33 = var44; var33 < var30; ++var33) {
					var34 = TaskHandler.method3411(var32, var30 - var44);
					this.field2462[var33] = (byte)(var34 * this.field2462[var33] + 32 >> 6);
					var32 += var31 - var41;
				}

				var44 = var30;
				var41 = var31;
			}

			for (var42 = var44; var42 < 128; ++var42) {
				this.field2462[var42] = (byte)(var41 * this.field2462[var42] + 32 >> 6);
			}

			var38 = null;
		}

		if (var39 != null) {
			var19 = var2.readUnsignedByte();
			var39[0] = (byte)var19;

			for (var27 = 2; var27 < var39.length; var27 += 2) {
				var19 = 1 + var19 + var2.readUnsignedByte();
				var39[var27] = (byte)var19;
			}

			var44 = var39[0];
			int var47 = var39[1] << 1;

			for (var29 = 0; var29 < var44; ++var29) {
				var42 = var47 + (this.field2463[var29] & 255);
				if (var42 < 0) {
					var42 = 0;
				}

				if (var42 > 128) {
					var42 = 128;
				}

				this.field2463[var29] = (byte)var42;
			}

			int var43;
			for (var29 = 2; var29 < var39.length; var29 += 2) {
				var30 = var39[var29];
				var43 = var39[var29 + 1] << 1;
				var32 = var47 * (var30 - var44) + (var30 - var44) / 2;

				for (var33 = var44; var33 < var30; ++var33) {
					var34 = TaskHandler.method3411(var32, var30 - var44);
					int var35 = var34 + (this.field2463[var33] & 255);
					if (var35 < 0) {
						var35 = 0;
					}

					if (var35 > 128) {
						var35 = 128;
					}

					this.field2463[var33] = (byte)var35;
					var32 += var43 - var47;
				}

				var44 = var30;
				var47 = var43;
			}

			for (var42 = var44; var42 < 128; ++var42) {
				var43 = var47 + (this.field2463[var42] & 255);
				if (var43 < 0) {
					var43 = 0;
				}

				if (var43 > 128) {
					var43 = 128;
				}

				this.field2463[var42] = (byte)var43;
			}

			Object var46 = null;
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field2372 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2369 != null) {
				var28.field2371 = var2.readUnsignedByte();
			}

			if (var28.field2370 != null) {
				var28.field2373 = var2.readUnsignedByte();
			}

			if (var28.field2372 > 0) {
				var28.field2374 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field2376 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2376 > 0) {
				var28.field2375 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2375 > 0) {
				var28.field2377 = var2.readUnsignedByte();
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ldh;[B[II)Z",
		garbageValue = "-291456557"
	)
	boolean method3825(SoundCache var1, byte[] var2, int[] var3) {
		boolean var4 = true;
		int var5 = 0;
		RawSound var6 = null;

		for (int var7 = 0; var7 < 128; ++var7) {
			if (var2 == null || var2[var7] != 0) {
				int var8 = this.field2455[var7];
				if (var8 != 0) {
					if (var8 != var5) {
						var5 = var8--;
						if ((var8 & 1) == 0) {
							var6 = var1.getSoundEffect(var8 >> 2, var3);
						} else {
							var6 = var1.getMusicSample(var8 >> 2, var3);
						}

						if (var6 == null) {
							var4 = false;
						}
					}

					if (var6 != null) {
						this.rawSounds[var7] = var6;
						this.field2455[var7] = 0;
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1724066088"
	)
	@Export("clear")
	void clear() {
		this.field2455 = null;
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)V",
		garbageValue = "0"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = ClientPacket.fontPlain12.lineWidth(var0, 250);
			int var6 = ClientPacket.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
			ClientPacket.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			FloorDecoration.method2786(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
			if (var1) {
				SpotAnimationDefinition.rasterProvider.drawFull(0, 0);
			} else {
				FriendsList.method5102(var3, var4, var5, var6);
			}

		}
	}
}
