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
					this.flags[var1][var2] = 0x1000000;
				} else {
					this.flags[var1][var2] = 0xffffff;
				}
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIIZB)V",
		garbageValue = "91"
	)
	public void method3559(int x, int y, int objectType, int rotation, boolean var5) {
		x -= this.xInset;
		y -= this.yInset;
		if (objectType == 0) {
			if (rotation == 0) {
				this.setFlag(x, y, 0x80);
				this.setFlag(x - 1, y, 8);
			}

			if (rotation == 1) {
				this.setFlag(x, y, 2);
				this.setFlag(x, y + 1, 32);
			}

			if (rotation == 2) {
				this.setFlag(x, y, 8);
				this.setFlag(x + 1, y, 128);
			}

			if (rotation == 3) {
				this.setFlag(x, y, 32);
				this.setFlag(x, y - 1, 2);
			}
		}

		if (objectType == 1 || objectType == 3) {
			if (rotation == 0) {
				this.setFlag(x, y, 1);
				this.setFlag(x - 1, y + 1, 16);
			}

			if (rotation == 1) {
				this.setFlag(x, y, 4);
				this.setFlag(x + 1, y + 1, 64);
			}

			if (rotation == 2) {
				this.setFlag(x, y, 16);
				this.setFlag(x + 1, y - 1, 1);
			}

			if (rotation == 3) {
				this.setFlag(x, y, 64);
				this.setFlag(x - 1, y - 1, 4);
			}
		}

		if (objectType == 2) {
			if (rotation == 0) {
				this.setFlag(x, y, 130);
				this.setFlag(x - 1, y, 8);
				this.setFlag(x, y + 1, 32);
			}

			if (rotation == 1) {
				this.setFlag(x, y, 10);
				this.setFlag(x, y + 1, 32);
				this.setFlag(x + 1, y, 128);
			}

			if (rotation == 2) {
				this.setFlag(x, y, 40);
				this.setFlag(x + 1, y, 128);
				this.setFlag(x, y - 1, 2);
			}

			if (rotation == 3) {
				this.setFlag(x, y, 160);
				this.setFlag(x, y - 1, 2);
				this.setFlag(x - 1, y, 8);
			}
		}

		if (var5) {
			if (objectType == 0) {
				if (rotation == 0) {
					this.setFlag(x, y, 65536);
					this.setFlag(x - 1, y, 4096);
				}

				if (rotation == 1) {
					this.setFlag(x, y, 1024);
					this.setFlag(x, y + 1, 16384);
				}

				if (rotation == 2) {
					this.setFlag(x, y, 4096);
					this.setFlag(x + 1, y, 65536);
				}

				if (rotation == 3) {
					this.setFlag(x, y, 16384);
					this.setFlag(x, y - 1, 1024);
				}
			}

			if (objectType == 1 || objectType == 3) {
				if (rotation == 0) {
					this.setFlag(x, y, 512);
					this.setFlag(x - 1, y + 1, 8192);
				}

				if (rotation == 1) {
					this.setFlag(x, y, 2048);
					this.setFlag(x + 1, y + 1, 32768);
				}

				if (rotation == 2) {
					this.setFlag(x, y, 8192);
					this.setFlag(x + 1, y - 1, 512);
				}

				if (rotation == 3) {
					this.setFlag(x, y, 32768);
					this.setFlag(x - 1, y - 1, 2048);
				}
			}

			if (objectType == 2) {
				if (rotation == 0) {
					this.setFlag(x, y, 66560);
					this.setFlag(x - 1, y, 4096);
					this.setFlag(x, y + 1, 16384);
				}

				if (rotation == 1) {
					this.setFlag(x, y, 5120);
					this.setFlag(x, y + 1, 16384);
					this.setFlag(x + 1, y, 65536);
				}

				if (rotation == 2) {
					this.setFlag(x, y, 20480);
					this.setFlag(x + 1, y, 65536);
					this.setFlag(x, y - 1, 1024);
				}

				if (rotation == 3) {
					this.setFlag(x, y, 0x14000);
					this.setFlag(x, y - 1, 1024);
					this.setFlag(x - 1, y, 4096);
				}
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "-1502680936"
	)
	@Export("addGameObject")
	public void addGameObject(int x, int y, int w, int h, boolean blockSight) {
		int var6 = 0x100;
		if (blockSight) {
			var6 += 0x20000;
		}

		x -= this.xInset;
		y -= this.yInset;

		for (int var7 = x; var7 < w + x; ++var7) {
			if (var7 >= 0 && var7 < this.xSize) {
				for (int var8 = y; var8 < y + h; ++var8) {
					if (var8 >= 0 && var8 < this.ySize) {
						this.setFlag(var7, var8, var6);
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
	@Export("setBlockedByFloor")
	public void setBlockedByFloor(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		this.flags[var1][var2] |= 0x200000;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-363679248"
	)
	@Export("setBlockedByFloorDec")
	public void setBlockedByFloorDec(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		this.flags[var1][var2] |= 0x40000;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-883048141"
	)
	@Export("setFlag")
	void setFlag(int var1, int var2, int var3) {
		this.flags[var1][var2] |= var3;
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
				this.setFlagOff(var1, var2, 128);
				this.setFlagOff(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.setFlagOff(var1, var2, 2);
				this.setFlagOff(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.setFlagOff(var1, var2, 8);
				this.setFlagOff(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.setFlagOff(var1, var2, 32);
				this.setFlagOff(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.setFlagOff(var1, var2, 1);
				this.setFlagOff(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.setFlagOff(var1, var2, 4);
				this.setFlagOff(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.setFlagOff(var1, var2, 16);
				this.setFlagOff(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.setFlagOff(var1, var2, 64);
				this.setFlagOff(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.setFlagOff(var1, var2, 130);
				this.setFlagOff(var1 - 1, var2, 8);
				this.setFlagOff(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.setFlagOff(var1, var2, 10);
				this.setFlagOff(var1, var2 + 1, 32);
				this.setFlagOff(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.setFlagOff(var1, var2, 40);
				this.setFlagOff(var1 + 1, var2, 128);
				this.setFlagOff(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.setFlagOff(var1, var2, 160);
				this.setFlagOff(var1, var2 - 1, 2);
				this.setFlagOff(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.setFlagOff(var1, var2, 65536);
					this.setFlagOff(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.setFlagOff(var1, var2, 1024);
					this.setFlagOff(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.setFlagOff(var1, var2, 4096);
					this.setFlagOff(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.setFlagOff(var1, var2, 16384);
					this.setFlagOff(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.setFlagOff(var1, var2, 512);
					this.setFlagOff(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.setFlagOff(var1, var2, 2048);
					this.setFlagOff(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.setFlagOff(var1, var2, 8192);
					this.setFlagOff(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.setFlagOff(var1, var2, 32768);
					this.setFlagOff(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.setFlagOff(var1, var2, 66560);
					this.setFlagOff(var1 - 1, var2, 4096);
					this.setFlagOff(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.setFlagOff(var1, var2, 5120);
					this.setFlagOff(var1, var2 + 1, 16384);
					this.setFlagOff(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.setFlagOff(var1, var2, 20480);
					this.setFlagOff(var1 + 1, var2, 65536);
					this.setFlagOff(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.setFlagOff(var1, var2, 81920);
					this.setFlagOff(var1, var2 - 1, 1024);
					this.setFlagOff(var1 - 1, var2, 4096);
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIIIIZB)V",
		garbageValue = "-77"
	)
	@Export("setFlagOffNonSquare")
	public void setFlagOffNonSquare(int x, int y, int w, int h, int rotation, boolean var6) {
		int var7 = 0x100;
		if (var6) {
			var7 += 0x20000;
		}

		x -= this.xInset;
		y -= this.yInset;
		int var8;
		if (rotation == 1 || rotation == 3) {
			var8 = w;
			w = h;
			h = var8;
		}

		for (var8 = x; var8 < w + x; ++var8) {
			if (var8 >= 0 && var8 < this.xSize) {
				for (int var9 = y; var9 < y + h; ++var9) {
					if (var9 >= 0 && var9 < this.ySize) {
						this.setFlagOff(var8, var9, var7);
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
	@Export("setFlagOff")
	void setFlagOff(int var1, int var2, int var3) {
		this.flags[var1][var2] &= ~var3;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-34"
	)
	public void method3567(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		this.flags[var1][var2] &= 0xfffbffff;
	}
}
