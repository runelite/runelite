import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("u")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
	@ObfuscatedName("s")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -435360499
	)
	int field1375;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = 7049401177374305975L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1222696699
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1397135465
	)
	int field1377;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1389632987
	)
	int field1380;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -845340094878598137L
	)
	long field1379;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1393634127
	)
	int field1374;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1399548221
	)
	int field1381;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -485630085
	)
	int field1382;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		longValue = 8930241059901906729L
	)
	long field1383;
	@ObfuscatedName("b")
	boolean field1390;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 207614275
	)
	int field1387;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "[Ldg;"
	)
	PcmStream[] field1388;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "[Ldg;"
	)
	PcmStream[] field1373;

	protected PcmPlayer() {
		this.field1375 = 32;
		this.timeMs = SoundCache.method2480();
		this.field1379 = 0L;
		this.field1374 = 0;
		this.field1381 = 0;
		this.field1382 = 0;
		this.field1383 = 0L;
		this.field1390 = true;
		this.field1387 = 0;
		this.field1388 = new PcmStream[8];
		this.field1373 = new PcmStream[8];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1989780823"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "91"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1120986508"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("g")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1450874669"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-93486639"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Ldg;B)V",
		garbageValue = "10"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1445657271"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = SoundCache.method2480();

			try {
				if (this.field1379 != 0L) {
					if (var1 < this.field1379) {
						return;
					}

					this.open(this.capacity);
					this.field1379 = 0L;
					this.field1390 = true;
				}

				int var3 = this.position();
				if (this.field1382 - var3 > this.field1374) {
					this.field1374 = this.field1382 - var3;
				}

				int var4 = this.field1377 + this.field1380;
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
					this.field1390 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1380 = var4 - this.field1377;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1383) {
					if (!this.field1390) {
						if (this.field1374 == 0 && this.field1381 == 0) {
							this.close();
							this.field1379 = 2000L + var1;
							return;
						}

						this.field1380 = Math.min(this.field1381, this.field1374);
						this.field1381 = this.field1374;
					} else {
						this.field1390 = false;
					}

					this.field1374 = 0;
					this.field1383 = 2000L + var1;
				}

				this.field1382 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1379 = var1 + 2000L;
			}

			try {
				if (var1 > 500000L + this.timeMs) {
					var1 = this.timeMs;
				}

				while (var1 > this.timeMs + 5000L) {
					this.skip(256);
					this.timeMs += (long)(256000 / GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-50"
	)
	public final void method2389() {
		this.field1390 = true;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-1"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1390 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1379 = SoundCache.method2480() + 2000L;
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "114"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (FontName.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == FontName.soundSystem.players[var2]) {
					FontName.soundSystem.players[var2] = null;
				}

				if (FontName.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				SoundCache.soundSystemExecutor.shutdownNow();
				SoundCache.soundSystemExecutor = null;
				FontName.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1891020754"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1387 -= var1;
		if (this.field1387 < 0) {
			this.field1387 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("ap")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class300.clearIntArray(var1, 0, var3);
		this.field1387 -= var2;
		if (this.stream != null && this.field1387 <= 0) {
			this.field1387 += GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate >> 4;
			class227.PcmStream_disable(this.stream);
			this.method2394(this.stream, this.stream.vmethod2673());
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
						PcmStream var11 = this.field1388[var7];

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
									int var13 = var11.vmethod3881();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1375) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1459; var14 != null; var14 = var11.nextSubStream()) {
											this.method2394(var14, var15 * var14.vmethod2673() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1388[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1373[var7] = var10;
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
				PcmStream var16 = this.field1388[var6];
				PcmStream[] var17 = this.field1388;
				this.field1373[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1387 < 0) {
			this.field1387 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = SoundCache.method2480();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(Ldg;IB)V",
		garbageValue = "11"
	)
	final void method2394(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1373[var3];
		if (var4 == null) {
			this.field1388[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1373[var3] = var1;
		var1.field1459 = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;B)V",
		garbageValue = "46"
	)
	@Export("InvDefinition_setArchives")
	public static void InvDefinition_setArchives(AbstractArchive var0) {
		InvDefinition.InvDefinition_archive = var0;
	}
}
