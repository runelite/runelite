import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 565160271
	)
	public static int field1398;
	@ObfuscatedName("g")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lcx;"
	)
	@Export("pcmPlayerProvider")
	static class99 pcmPlayerProvider;
	@ObfuscatedName("n")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1255248085
	)
	int field1397;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -2367758414961315653L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1798201523
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1072458633
	)
	int field1401;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -247116181
	)
	int field1403;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = -3370414855018982157L
	)
	long field1396;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 3489373
	)
	int field1404;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -92983435
	)
	int field1405;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -658746403
	)
	int field1406;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		longValue = -227900645038569121L
	)
	long field1407;
	@ObfuscatedName("u")
	boolean field1408;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 858322217
	)
	int field1409;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "[Ldn;"
	)
	PcmStream[] field1410;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "[Ldn;"
	)
	PcmStream[] field1411;

	protected PcmPlayer() {
		this.field1397 = 32;
		this.timeMs = WorldMapIcon_0.currentTimeMillis();
		this.field1396 = 0L;
		this.field1404 = 0;
		this.field1405 = 0;
		this.field1406 = 0;
		this.field1407 = 0L;
		this.field1408 = true;
		this.field1409 = 0;
		this.field1410 = new PcmStream[8];
		this.field1411 = new PcmStream[8];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-111"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-871749312"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-164846701"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("e")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1942741652"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2088617942"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ldn;I)V",
		garbageValue = "1817340933"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1301441901"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = WorldMapIcon_0.currentTimeMillis();

			try {
				if (0L != this.field1396) {
					if (var1 < this.field1396) {
						return;
					}

					this.open(this.capacity);
					this.field1396 = 0L;
					this.field1408 = true;
				}

				int var3 = this.position();
				if (this.field1406 - var3 > this.field1404) {
					this.field1404 = this.field1406 - var3;
				}

				int var4 = this.field1401 + this.field1403;
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
					this.field1408 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1403 = var4 - this.field1401;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1407) {
					if (!this.field1408) {
						if (this.field1404 == 0 && this.field1405 == 0) {
							this.close();
							this.field1396 = 2000L + var1;
							return;
						}

						this.field1403 = Math.min(this.field1405, this.field1404);
						this.field1405 = this.field1404;
					} else {
						this.field1408 = false;
					}

					this.field1404 = 0;
					this.field1407 = 2000L + var1;
				}

				this.field1406 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1396 = var1 + 2000L;
			}

			try {
				if (var1 > this.timeMs + 500000L) {
					var1 = this.timeMs;
				}

				while (var1 > 5000L + this.timeMs) {
					this.skip(256);
					this.timeMs += (long)(256000 / field1398);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-569274041"
	)
	public final void method2489() {
		this.field1408 = true;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2064649037"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1408 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1396 = WorldMapIcon_0.currentTimeMillis() + 2000L;
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1437480002"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (UserComparator2.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == UserComparator2.soundSystem.players[var2]) {
					UserComparator2.soundSystem.players[var2] = null;
				}

				if (UserComparator2.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				Frames.soundSystemExecutor.shutdownNow();
				Frames.soundSystemExecutor = null;
				UserComparator2.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "6"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1409 -= var1;
		if (this.field1409 < 0) {
			this.field1409 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("as")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class301.clearIntArray(var1, 0, var3);
		this.field1409 -= var2;
		if (this.stream != null && this.field1409 <= 0) {
			this.field1409 += field1398 >> 4;
			class65.PcmStream_disable(this.stream);
			this.method2494(this.stream, this.stream.vmethod2777());
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
						PcmStream var11 = this.field1410[var7];

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
									int var13 = var11.vmethod3965();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1397) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1478; var14 != null; var14 = var11.nextSubStream()) {
											this.method2494(var14, var15 * var14.vmethod2777() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1410[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1411[var7] = var10;
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
				PcmStream var16 = this.field1410[var6];
				PcmStream[] var17 = this.field1410;
				this.field1411[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1409 < 0) {
			this.field1409 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = WorldMapIcon_0.currentTimeMillis();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(Ldn;II)V",
		garbageValue = "-1216223626"
	)
	final void method2494(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1411[var3];
		if (var4 == null) {
			this.field1410[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1411[var3] = var1;
		var1.field1478 = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-526155431"
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
		Interpreter.sortWorlds(class96.World_worlds, 0, class96.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "(Lhn;I)Ljava/lang/String;",
		garbageValue = "-1826088891"
	)
	static String method2542(Widget var0) {
		if (class83.method2108(WorldMapIcon_0.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
