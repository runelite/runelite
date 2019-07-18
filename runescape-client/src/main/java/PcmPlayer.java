import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1278180609
	)
	@Export("pcmPlayerCount")
	static int pcmPlayerCount;
	@ObfuscatedName("r")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1475444063
	)
	int field1406;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = -1948698164081779065L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1789796573
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1737413085
	)
	int field1414;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1691943703
	)
	int field1413;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		longValue = -7968110108619228373L
	)
	long field1416;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 2131398703
	)
	int field1417;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 586161719
	)
	int field1418;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1508308009
	)
	int field1419;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		longValue = -2950449123303085351L
	)
	long field1420;
	@ObfuscatedName("z")
	boolean field1421;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 550758429
	)
	int field1423;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "[Ldx;"
	)
	PcmStream[] field1426;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "[Ldx;"
	)
	PcmStream[] field1425;

	protected PcmPlayer() {
		this.field1406 = 32;
		this.timeMs = DirectByteArrayCopier.currentTimeMs();
		this.field1416 = 0L;
		this.field1417 = 0;
		this.field1418 = 0;
		this.field1419 = 0;
		this.field1420 = 0L;
		this.field1421 = true;
		this.field1423 = 0;
		this.field1426 = new PcmStream[8];
		this.field1425 = new PcmStream[8];
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1518489339"
	)
	protected void init() throws Exception {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "2"
	)
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "97"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("p")
	protected void write() throws Exception {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "57"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-313753219"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Ldx;I)V",
		garbageValue = "750974673"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1453359051"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = DirectByteArrayCopier.currentTimeMs();

			try {
				if (0L != this.field1416) {
					if (var1 < this.field1416) {
						return;
					}

					this.open(this.capacity);
					this.field1416 = 0L;
					this.field1421 = true;
				}

				int var3 = this.position();
				if (this.field1419 - var3 > this.field1417) {
					this.field1417 = this.field1419 - var3;
				}

				int var4 = this.field1413 + this.field1414;
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
					this.field1421 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field1413 = var4 - this.field1414;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field1420) {
					if (!this.field1421) {
						if (this.field1417 == 0 && this.field1418 == 0) {
							this.close();
							this.field1416 = 2000L + var1;
							return;
						}

						this.field1413 = Math.min(this.field1418, this.field1417);
						this.field1418 = this.field1417;
					} else {
						this.field1421 = false;
					}

					this.field1417 = 0;
					this.field1420 = 2000L + var1;
				}

				this.field1419 = var3;
			} catch (Exception var7) {
				this.close();
				this.field1416 = var1 + 2000L;
			}

			try {
				if (var1 > 500000L + this.timeMs) {
					var1 = this.timeMs;
				}

				while (var1 > 5000L + this.timeMs) {
					this.skip(256);
					this.timeMs += (long)(256000 / CollisionMap.PcmPlayer_sampleRate);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-42"
	)
	public final void method2407() {
		this.field1421 = true;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1267599868"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field1421 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field1416 = DirectByteArrayCopier.currentTimeMs() + 2000L;
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (SecureRandomFuture.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == SecureRandomFuture.soundSystem.players[var2]) {
					SecureRandomFuture.soundSystem.players[var2] = null;
				}

				if (SecureRandomFuture.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				class14.soundSystemExecutor.shutdownNow();
				class14.soundSystemExecutor = null;
				SecureRandomFuture.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1268557925"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field1423 -= var1;
		if (this.field1423 < 0) {
			this.field1423 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("ax")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (class169.isStereo) {
			var3 = var2 << 1;
		}

		class301.clearIntArray(var1, 0, var3);
		this.field1423 -= var2;
		if (this.stream != null && this.field1423 <= 0) {
			this.field1423 += CollisionMap.PcmPlayer_sampleRate >> 4;
			GraphicsObject.PcmStream_disable(this.stream);
			this.method2456(this.stream, this.stream.vmethod2689());
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
						PcmStream var11 = this.field1426[var7];

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
									int var13 = var11.vmethod3892();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field1406) {
										break label104;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field1496; var14 != null; var14 = var11.nextSubStream()) {
											this.method2456(var14, var15 * var14.vmethod2689() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field1426[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field1425[var7] = var10;
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
				PcmStream var16 = this.field1426[var6];
				PcmStream[] var17 = this.field1426;
				this.field1425[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field1423 < 0) {
			this.field1423 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = DirectByteArrayCopier.currentTimeMs();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Ldx;II)V",
		garbageValue = "2049205678"
	)
	final void method2456(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field1425[var3];
		if (var4 == null) {
			this.field1426[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field1425[var3] = var1;
		var1.field1496 = var2;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)[Lll;",
		garbageValue = "69"
	)
	public static class323[] method2405() {
		return new class323[]{class323.field3887, class323.SOLID, class323.field3885};
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(Lhj;IIB)V",
		garbageValue = "-55"
	)
	@Export("alignWidgetPosition")
	static void alignWidgetPosition(Widget var0, int var1, int var2) {
		if (var0.xAlignment == 0) {
			var0.x = var0.rawX;
		} else if (var0.xAlignment == 1) {
			var0.x = var0.rawX + (var1 - var0.width) / 2;
		} else if (var0.xAlignment == 2) {
			var0.x = var1 - var0.width - var0.rawX;
		} else if (var0.xAlignment == 3) {
			var0.x = var0.rawX * var1 >> 14;
		} else if (var0.xAlignment == 4) {
			var0.x = (var0.rawX * var1 >> 14) + (var1 - var0.width) / 2;
		} else {
			var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
		}

		if (var0.yAlignment == 0) {
			var0.y = var0.rawY;
		} else if (var0.yAlignment == 1) {
			var0.y = (var2 - var0.height) / 2 + var0.rawY;
		} else if (var0.yAlignment == 2) {
			var0.y = var2 - var0.height - var0.rawY;
		} else if (var0.yAlignment == 3) {
			var0.y = var2 * var0.rawY >> 14;
		} else if (var0.yAlignment == 4) {
			var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
		} else {
			var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
		}

	}
}
