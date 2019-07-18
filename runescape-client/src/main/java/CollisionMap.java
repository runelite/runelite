import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("CollisionMap")
public class CollisionMap {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1785681501
	)
	@Export("PcmPlayer_sampleRate")
	public static int PcmPlayer_sampleRate;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -1007844033
	)
	@Export("xInset")
	public int xInset;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 97844873
	)
	@Export("yInset")
	public int yInset;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1249565113
	)
	@Export("xSize")
	int xSize;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1188758843
	)
	@Export("ySize")
	int ySize;
	@ObfuscatedName("aj")
	@Export("flags")
	public int[][] flags;

	public CollisionMap(int var1, int var2) {
		this.xInset = 0;
		this.yInset = 0;
		this.xSize = var1;
		this.ySize = var2;
		this.flags = new int[this.xSize][this.ySize];
		this.clear();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1772918444"
	)
	@Export("clear")
	public void clear() {
		for (int var1 = 0; var1 < this.xSize; ++var1) {
			for (int var2 = 0; var2 < this.ySize; ++var2) {
				if (var1 != 0 && var2 != 0 && var1 < this.xSize - 5 && var2 < this.ySize - 5) {
					this.flags[var1][var2] = 16777216;
				} else {
					this.flags[var1][var2] = 16777215;
				}
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIIZB)V",
		garbageValue = "91"
	)
	public void method3559(int var1, int var2, int var3, int var4, boolean var5) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		if (var3 == 0) {
			if (var4 == 0) {
				this.method3568(var1, var2, 128);
				this.method3568(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.method3568(var1, var2, 2);
				this.method3568(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.method3568(var1, var2, 8);
				this.method3568(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.method3568(var1, var2, 32);
				this.method3568(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.method3568(var1, var2, 1);
				this.method3568(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.method3568(var1, var2, 4);
				this.method3568(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.method3568(var1, var2, 16);
				this.method3568(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.method3568(var1, var2, 64);
				this.method3568(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.method3568(var1, var2, 130);
				this.method3568(var1 - 1, var2, 8);
				this.method3568(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.method3568(var1, var2, 10);
				this.method3568(var1, var2 + 1, 32);
				this.method3568(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.method3568(var1, var2, 40);
				this.method3568(var1 + 1, var2, 128);
				this.method3568(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.method3568(var1, var2, 160);
				this.method3568(var1, var2 - 1, 2);
				this.method3568(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.method3568(var1, var2, 65536);
					this.method3568(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.method3568(var1, var2, 1024);
					this.method3568(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.method3568(var1, var2, 4096);
					this.method3568(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.method3568(var1, var2, 16384);
					this.method3568(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.method3568(var1, var2, 512);
					this.method3568(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.method3568(var1, var2, 2048);
					this.method3568(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.method3568(var1, var2, 8192);
					this.method3568(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.method3568(var1, var2, 32768);
					this.method3568(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.method3568(var1, var2, 66560);
					this.method3568(var1 - 1, var2, 4096);
					this.method3568(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.method3568(var1, var2, 5120);
					this.method3568(var1, var2 + 1, 16384);
					this.method3568(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.method3568(var1, var2, 20480);
					this.method3568(var1 + 1, var2, 65536);
					this.method3568(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.method3568(var1, var2, 81920);
					this.method3568(var1, var2 - 1, 1024);
					this.method3568(var1 - 1, var2, 4096);
				}
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "-1502680936"
	)
	public void method3560(int var1, int var2, int var3, int var4, boolean var5) {
		int var6 = 256;
		if (var5) {
			var6 += 131072;
		}

		var1 -= this.xInset;
		var2 -= this.yInset;

		for (int var7 = var1; var7 < var3 + var1; ++var7) {
			if (var7 >= 0 && var7 < this.xSize) {
				for (int var8 = var2; var8 < var2 + var4; ++var8) {
					if (var8 >= 0 && var8 < this.ySize) {
						this.method3568(var7, var8, var6);
					}
				}
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2087203619"
	)
	public void method3561(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		int[] var10000 = this.flags[var1];
		var10000[var2] |= 2097152;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-363679248"
	)
	public void method3562(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		int[] var10000 = this.flags[var1];
		var10000[var2] |= 262144;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-883048141"
	)
	void method3568(int var1, int var2, int var3) {
		int[] var10000 = this.flags[var1];
		var10000[var2] |= var3;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "-1166825819"
	)
	public void method3564(int var1, int var2, int var3, int var4, boolean var5) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		if (var3 == 0) {
			if (var4 == 0) {
				this.method3566(var1, var2, 128);
				this.method3566(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.method3566(var1, var2, 2);
				this.method3566(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.method3566(var1, var2, 8);
				this.method3566(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.method3566(var1, var2, 32);
				this.method3566(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.method3566(var1, var2, 1);
				this.method3566(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.method3566(var1, var2, 4);
				this.method3566(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.method3566(var1, var2, 16);
				this.method3566(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.method3566(var1, var2, 64);
				this.method3566(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.method3566(var1, var2, 130);
				this.method3566(var1 - 1, var2, 8);
				this.method3566(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.method3566(var1, var2, 10);
				this.method3566(var1, var2 + 1, 32);
				this.method3566(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.method3566(var1, var2, 40);
				this.method3566(var1 + 1, var2, 128);
				this.method3566(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.method3566(var1, var2, 160);
				this.method3566(var1, var2 - 1, 2);
				this.method3566(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.method3566(var1, var2, 65536);
					this.method3566(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.method3566(var1, var2, 1024);
					this.method3566(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.method3566(var1, var2, 4096);
					this.method3566(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.method3566(var1, var2, 16384);
					this.method3566(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.method3566(var1, var2, 512);
					this.method3566(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.method3566(var1, var2, 2048);
					this.method3566(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.method3566(var1, var2, 8192);
					this.method3566(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.method3566(var1, var2, 32768);
					this.method3566(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.method3566(var1, var2, 66560);
					this.method3566(var1 - 1, var2, 4096);
					this.method3566(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.method3566(var1, var2, 5120);
					this.method3566(var1, var2 + 1, 16384);
					this.method3566(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.method3566(var1, var2, 20480);
					this.method3566(var1 + 1, var2, 65536);
					this.method3566(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.method3566(var1, var2, 81920);
					this.method3566(var1, var2 - 1, 1024);
					this.method3566(var1 - 1, var2, 4096);
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIIIIZB)V",
		garbageValue = "-77"
	)
	public void method3565(int var1, int var2, int var3, int var4, int var5, boolean var6) {
		int var7 = 256;
		if (var6) {
			var7 += 131072;
		}

		var1 -= this.xInset;
		var2 -= this.yInset;
		int var8;
		if (var5 == 1 || var5 == 3) {
			var8 = var3;
			var3 = var4;
			var4 = var8;
		}

		for (var8 = var1; var8 < var3 + var1; ++var8) {
			if (var8 >= 0 && var8 < this.xSize) {
				for (int var9 = var2; var9 < var2 + var4; ++var9) {
					if (var9 >= 0 && var9 < this.ySize) {
						this.method3566(var8, var9, var7);
					}
				}
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1617846942"
	)
	void method3566(int var1, int var2, int var3) {
		int[] var10000 = this.flags[var1];
		var10000[var2] &= ~var3;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-34"
	)
	public void method3567(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		int[] var10000 = this.flags[var1];
		var10000[var2] &= -262145;
	}
}
