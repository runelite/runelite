import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("p")
	@Export("PcmPlayer_stereo")
	public static boolean PcmPlayer_stereo;
	@ObfuscatedName("m")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("pcmPlayerProvider")
	static PcmPlayerProvider pcmPlayerProvider;
	@ObfuscatedName("a")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldc;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 529397433
	)
	int field1388;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -9085441602565192727L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 937182747
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1375539879
	)
	int field1391;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -383494247
	)
	int field1392;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		longValue = 2578589966919390689L
	)
	long field1393;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -709133773
	)
	int field1383;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1808057975
	)
	int field1397;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -236130375
	)
	int field1396;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = -2782522933298206297L
	)
	long field1382;
	@ObfuscatedName("k")
	boolean field1394;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 1371288149
	)
	int field1399;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "[Ldc;"
	)
	PcmStream[] field1400;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "[Ldc;"
	)
	PcmStream[] field1401;

	protected PcmPlayer() {
		this.field1388 = 32;
		this.timeMs = class30.currentTimeMillis();
		this.field1393 = 0L;
		this.field1383 = 0;
		this.field1397 = 0;
		this.field1396 = 0;
		this.field1382 = 0L;
		this.field1394 = true;
		this.field1399 = 0;
		this.field1400 = new PcmStream[8];
		this.field1401 = new PcmStream[8];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "8"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "2148"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("u")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "90832052"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1875138754"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(Ldc;I)V",
		garbageValue = "1280132594"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "17"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = class30.currentTimeMillis();

			try {
				if (this.field1393 != 0L) {
					if (var1 < this.field1393) {
						return;
					}

					this.open(this.capacity);
					this.field1393 = 0L;
					this.field1394 = true;
				}

				int var3 = this.position();
				if (this.field1396 - var3 > this.field1383) {
					this.field1383 = this.field1396 - var3;
				}

				int var4 = this.field1391 + this.field1392;
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
					this.field1394 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1392 = var4 - this.field1391;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1382) {
					if (!this.field1394) {
						if (this.field1383 == 0 && this.field1397 == 0) {
							this.close();
							this.field1393 = var1 + 2000L;
							return;
						}

						this.field1392 = Math.min(this.field1397, this.field1383);
						this.field1397 = this.field1383;
					} else {
						this.field1394 = false;
					}

					this.field1383 = 0;
					this.field1382 = var1 + 2000L;
				}

				this.field1396 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1393 = var1 + 2000L;
			}

			try {
				if (var1 > this.timeMs + 500000L) {
					var1 = this.timeMs;
				}

				while (var1 > this.timeMs + 5000L) {
					this.skip(256);
					this.timeMs += (long)(256000 / UrlRequest.PcmPlayer_sampleRate);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "580966872"
	)
	public final void method2397() {
		this.field1394 = true;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-601426802"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1394 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1393 = class30.currentTimeMillis() + 2000L;
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1026437845"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (RunException.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == RunException.soundSystem.players[var2]) {
					RunException.soundSystem.players[var2] = null;
				}

				if (RunException.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				soundSystemExecutor.shutdownNow();
				soundSystemExecutor = null;
				RunException.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "629535464"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1399 -= var1;
		if (this.field1399 < 0) {
			this.field1399 = 0;
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

		class300.clearIntArray(var1, 0, var3);
		this.field1399 -= var2;
		if (this.stream != null && this.field1399 <= 0) {
			this.field1399 += UrlRequest.PcmPlayer_sampleRate >> 4;
			DynamicObject.PcmStream_disable(this.stream);
			this.method2402(this.stream, this.stream.vmethod2691());
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
						PcmStream var11 = this.field1400[var7];

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
									int var13 = var11.vmethod3882();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1388) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1462; var14 != null; var14 = var11.nextSubStream()) {
											this.method2402(var14, var15 * var14.vmethod2691() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1400[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1401[var7] = var10;
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
				PcmStream var16 = this.field1400[var6];
				PcmStream[] var17 = this.field1400;
				this.field1401[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1399 < 0) {
			this.field1399 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = class30.currentTimeMillis();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Ldc;II)V",
		garbageValue = "1373941757"
	)
	final void method2402(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1401[var3];
		if (var4 == null) {
			this.field1400[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1401[var3] = var1;
		var1.field1462 = var2;
	}
}
