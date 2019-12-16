import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("k")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ldl;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 870880097
	)
	int field1372;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -2578951154982885373L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1002919953
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1574476853
	)
	int field1373;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -87074955
	)
	int field1376;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = 4761654115835358543L
	)
	long field1377;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 500699263
	)
	int field1371;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1630467439
	)
	int field1382;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1827156113
	)
	int field1380;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = -9078760105487350149L
	)
	long field1381;
	@ObfuscatedName("q")
	boolean field1378;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 199004789
	)
	int field1375;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "[Ldl;"
	)
	PcmStream[] field1384;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "[Ldl;"
	)
	PcmStream[] field1385;

	protected PcmPlayer() {
		this.field1372 = 32;
		this.timeMs = WorldMapID.currentTimeMillis();
		this.field1377 = 0L;
		this.field1371 = 0;
		this.field1382 = 0;
		this.field1380 = 0;
		this.field1381 = 0L;
		this.field1378 = true;
		this.field1375 = 0;
		this.field1384 = new PcmStream[8];
		this.field1385 = new PcmStream[8];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "15"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "797185937"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2013132005"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("w")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "390"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1127195595"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Ldl;I)V",
		garbageValue = "-126312603"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "23"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = WorldMapID.currentTimeMillis();

			try {
				if (this.field1377 != 0L) {
					if (var1 < this.field1377) {
						return;
					}

					this.open(this.capacity);
					this.field1377 = 0L;
					this.field1378 = true;
				}

				int var3 = this.position();
				if (this.field1380 - var3 > this.field1371) {
					this.field1371 = this.field1380 - var3;
				}

				int var4 = this.field1376 + this.field1373;
				if (var4 + 256 > 16384) {
					var4 = 16128;
				}

				if (var4 + 256 > this.capacity) {
					this.capacity += 1024;
					if (this.capacity > 16384) {
						this.capacity = 16384;
					}

					this.close();
					this.open(this.capacity);
					var3 = 0;
					this.field1378 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1376 = var4 - this.field1373;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1381) {
					if (!this.field1378) {
						if (this.field1371 == 0 && this.field1382 == 0) {
							this.close();
							this.field1377 = var1 + 2000L;
							return;
						}

						this.field1376 = Math.min(this.field1382, this.field1371);
						this.field1382 = this.field1371;
					} else {
						this.field1378 = false;
					}

					this.field1371 = 0;
					this.field1381 = 2000L + var1;
				}

				this.field1380 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1377 = 2000L + var1;
			}

			try {
				if (var1 > this.timeMs + 500000L) {
					var1 = this.timeMs;
				}

				while (var1 > this.timeMs + 5000L) {
					this.skip(256);
					this.timeMs += (long)(256000 / (DirectByteArrayCopier.field2490 * -168449264));
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "63"
	)
	public final void method2472() {
		this.field1378 = true;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-536403943"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1378 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1377 = WorldMapID.currentTimeMillis() + 2000L;
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-991727159"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (HealthBar.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == HealthBar.soundSystem.players[var2]) {
					HealthBar.soundSystem.players[var2] = null;
				}

				if (HealthBar.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				FriendSystem.soundSystemExecutor.shutdownNow();
				FriendSystem.soundSystemExecutor = null;
				HealthBar.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1228622505"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1375 -= var1;
		if (this.field1375 < 0) {
			this.field1375 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("ag")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (SoundCache.PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class300.clearIntArray(var1, 0, var3);
		this.field1375 -= var2;
		if (this.stream != null && this.field1375 <= 0) {
			this.field1375 += DirectByteArrayCopier.field2490 * -168449264 >> 4;
			ChatChannel.PcmStream_disable(this.stream);
			this.method2432(this.stream, this.stream.vmethod2716());
			int var4 = 0;
			int var5 = 255;

			int var6;
			PcmStream var10;
			label104:
			for (var6 = 7; var5 != 0; --var6) {
				int var7;
				int var8;
				if (var6 < 0) {
					var7 = var6 & 3;
					var8 = -(var6 >> 2);
				} else {
					var7 = var6;
					var8 = 0;
				}

				for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
					if ((var9 & 1) != 0) {
						var5 &= ~(1 << var7);
						var10 = null;
						PcmStream var11 = this.field1384[var7];

						label98:
						while (true) {
							while (true) {
								if (var11 == null) {
									break label98;
								}

								AbstractSound var12 = var11.sound;
								if (var12 != null && var12.position > var8) {
									var5 |= 1 << var7;
									var10 = var11;
									var11 = var11.after;
								} else {
									var11.active = true;
									int var13 = var11.vmethod3889();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1372) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1454; var14 != null; var14 = var11.nextSubStream()) {
											this.method2432(var14, var15 * var14.vmethod2716() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1384[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1385[var7] = var10;
									}

									var11 = var18;
								}
							}
						}
					}

					var7 += 4;
					++var8;
				}
			}

			for (var6 = 0; var6 < 8; ++var6) {
				PcmStream var16 = this.field1384[var6];
				PcmStream[] var17 = this.field1384;
				this.field1385[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1375 < 0) {
			this.field1375 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = WorldMapID.currentTimeMillis();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Ldl;II)V",
		garbageValue = "-919759733"
	)
	final void method2432(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1385[var3];
		if (var4 == null) {
			this.field1384[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1385[var3] = var1;
		var1.field1454 = var2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1686341177"
	)
	@Export("changeWorldSelectSorting")
	static void changeWorldSelectSorting(int var0, int var1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = var0;
		var3[0] = var1;
		int var4 = 1;

		for (int var5 = 0; var5 < 4; ++var5) {
			if (World.World_sortOption1[var5] != var0) {
				var2[var4] = World.World_sortOption1[var5];
				var3[var4] = World.World_sortOption2[var5];
				++var4;
			}
		}

		World.World_sortOption1 = var2;
		World.World_sortOption2 = var3;
		class192.sortWorlds(class162.World_worlds, 0, class162.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
	}
}
