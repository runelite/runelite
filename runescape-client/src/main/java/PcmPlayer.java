import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("p")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
	@ObfuscatedName("y")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldc;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	static AbstractSocket field1413;
	@ObfuscatedName("e")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ldt;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 78939647
	)
	int field1396;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = -143263282379705379L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 519126893
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1108114601
	)
	int field1401;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1542098097
	)
	int field1402;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -5404263653312830565L
	)
	long field1405;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1907349045
	)
	int field1406;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 850216769
	)
	int field1404;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1870292623
	)
	int field1393;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 8086263838612894667L
	)
	long field1407;
	@ObfuscatedName("j")
	boolean field1398;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 657489915
	)
	int field1409;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "[Ldt;"
	)
	PcmStream[] field1410;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "[Ldt;"
	)
	PcmStream[] field1411;

	protected PcmPlayer() {
		this.field1396 = 32;
		this.timeMs = TaskHandler.currentTimeMillis();
		this.field1405 = 0L;
		this.field1406 = 0;
		this.field1404 = 0;
		this.field1393 = 0;
		this.field1407 = 0L;
		this.field1398 = true;
		this.field1409 = 0;
		this.field1410 = new PcmStream[8];
		this.field1411 = new PcmStream[8];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "347893346"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "25"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "80"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("g")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1441503616"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "45"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ldt;B)V",
		garbageValue = "-11"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "344107964"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = TaskHandler.currentTimeMillis();

			try {
				if (this.field1405 != 0L) {
					if (var1 < this.field1405) {
						return;
					}

					this.open(this.capacity);
					this.field1405 = 0L;
					this.field1398 = true;
				}

				int var3 = this.position();
				if (this.field1393 - var3 > this.field1406) {
					this.field1406 = this.field1393 - var3;
				}

				int var4 = this.field1401 + this.field1402;
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
					this.field1398 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1402 = var4 - this.field1401;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1407) {
					if (!this.field1398) {
						if (this.field1406 == 0 && this.field1404 == 0) {
							this.close();
							this.field1405 = var1 + 2000L;
							return;
						}

						this.field1402 = Math.min(this.field1404, this.field1406);
						this.field1404 = this.field1406;
					} else {
						this.field1398 = false;
					}

					this.field1406 = 0;
					this.field1407 = 2000L + var1;
				}

				this.field1393 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1405 = 2000L + var1;
			}

			try {
				if (var1 > 500000L + this.timeMs) {
					var1 = this.timeMs;
				}

				while (var1 > 5000L + this.timeMs) {
					this.skip(256);
					this.timeMs += (long)(256000 / Messages.PcmPlayer_sampleRate);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-4762"
	)
	public final void method2458() {
		this.field1398 = true;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1398 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1405 = TaskHandler.currentTimeMillis() + 2000L;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1132905799"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == soundSystem.players[var2]) {
					soundSystem.players[var2] = null;
				}

				if (soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				soundSystemExecutor.shutdownNow();
				soundSystemExecutor = null;
				soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "8"
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

	@ObfuscatedName("aa")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class300.clearIntArray(var1, 0, var3);
		this.field1409 -= var2;
		if (this.stream != null && this.field1409 <= 0) {
			this.field1409 += Messages.PcmPlayer_sampleRate >> 4;
			class1.PcmStream_disable(this.stream);
			this.method2452(this.stream, this.stream.vmethod2741());
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
									int var13 = var11.vmethod3963();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1396) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1483; var14 != null; var14 = var11.nextSubStream()) {
											this.method2452(var14, var15 * var14.vmethod2741() >> 8);
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

		this.timeMs = TaskHandler.currentTimeMillis();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ldt;II)V",
		garbageValue = "1065299389"
	)
	final void method2452(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1411[var3];
		if (var4 == null) {
			this.field1410[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1411[var3] = var1;
		var1.field1483 = var2;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "180"
	)
	static void method2510() {
		UrlRequester.SpriteBuffer_xOffsets = null;
		class216.SpriteBuffer_yOffsets = null;
		class325.SpriteBuffer_spriteWidths = null;
		VarcInt.SpriteBuffer_spriteHeights = null;
		class325.SpriteBuffer_spritePalette = null;
		FillMode.SpriteBuffer_pixels = null;
	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "264863950"
	)
	static final void method2509() {
		boolean var0 = false;

		while (!var0) {
			var0 = true;

			for (int var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
				if (Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
					String var2 = Client.menuTargets[var1];
					Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
					Client.menuTargets[var1 + 1] = var2;
					String var3 = Client.menuActions[var1];
					Client.menuActions[var1] = Client.menuActions[var1 + 1];
					Client.menuActions[var1 + 1] = var3;
					int var4 = Client.menuOpcodes[var1];
					Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
					Client.menuOpcodes[var1 + 1] = var4;
					var4 = Client.menuArguments1[var1];
					Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
					Client.menuArguments1[var1 + 1] = var4;
					var4 = Client.menuArguments2[var1];
					Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
					Client.menuArguments2[var1 + 1] = var4;
					var4 = Client.menuIdentifiers[var1];
					Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
					Client.menuIdentifiers[var1 + 1] = var4;
					boolean var5 = Client.menuShiftClick[var1];
					Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
					Client.menuShiftClick[var1 + 1] = var5;
					var0 = false;
				}
			}
		}

	}
}
