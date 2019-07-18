import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -520728357
	)
	int field2409;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 740980141
	)
	int field2426;
	@ObfuscatedName("k")
	int[] field2411;
	@ObfuscatedName("l")
	int[] field2412;
	@ObfuscatedName("b")
	int[] field2422;
	@ObfuscatedName("i")
	int[] field2414;
	@ObfuscatedName("c")
	int[] field2413;
	@ObfuscatedName("f")
	int[] field2415;
	@ObfuscatedName("m")
	int[] field2429;
	@ObfuscatedName("u")
	int[] field2418;
	@ObfuscatedName("x")
	int[] field2419;
	@ObfuscatedName("t")
	int[] field2421;
	@ObfuscatedName("h")
	int[] field2424;
	@ObfuscatedName("o")
	int[] field2423;
	@ObfuscatedName("n")
	int[] field2410;
	@ObfuscatedName("d")
	int[] field2425;
	@ObfuscatedName("s")
	int[] field2408;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[[Lgi;"
	)
	MusicPatchNode[][] field2427;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "[[Lgi;"
	)
	MusicPatchNode[][] field2428;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("as")
	boolean field2430;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 56317899
	)
	@Export("track")
	int track;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1379550315
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		longValue = -8333505041211180397L
	)
	long field2433;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		longValue = -1344180019540033721L
	)
	long field2434;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "Lgq;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2409 = 256;
		this.field2426 = 1000000;
		this.field2411 = new int[16];
		this.field2412 = new int[16];
		this.field2422 = new int[16];
		this.field2414 = new int[16];
		this.field2413 = new int[16];
		this.field2415 = new int[16];
		this.field2429 = new int[16];
		this.field2418 = new int[16];
		this.field2419 = new int[16];
		this.field2421 = new int[16];
		this.field2424 = new int[16];
		this.field2423 = new int[16];
		this.field2410 = new int[16];
		this.field2425 = new int[16];
		this.field2408 = new int[16];
		this.field2427 = new MusicPatchNode[16][128];
		this.field2428 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3726();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "985423372"
	)
	public synchronized void method3706(int var1) {
		this.field2409 = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "911615124"
	)
	public int method3707() {
		return this.field2409;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lgl;Lhp;Ldf;II)Z",
		garbageValue = "-2127323557"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3925();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				byte[] var11 = var2.takeFileFlat(var8);
				MusicPatch var10;
				if (var11 == null) {
					var10 = null;
				} else {
					var10 = new MusicPatch(var11);
				}

				var9 = var10;
				if (var10 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var10, (long)var8);
			}

			if (!var9.method3883(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-444816783"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "535953816"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("i")
	protected synchronized int vmethod3892() {
		return 0;
	}

	@ObfuscatedName("c")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2426 * -727379968 / CollisionMap.PcmPlayer_sampleRate;

			do {
				long var5 = this.field2433 + (long)var3 * (long)var4;
				if (this.field2434 - var5 >= 0L) {
					this.field2433 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2434 - this.field2433) - 1L) / (long)var4);
				this.field2433 += (long)var7 * (long)var4;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3738();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lgl;ZI)V",
		garbageValue = "-2040319753"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2430 = var2;
		this.field2433 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2434 = this.midiFile.method3861(this.trackLength);
	}

	@ObfuscatedName("x")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2426 * -727379968 / CollisionMap.PcmPlayer_sampleRate;

			do {
				long var3 = this.field2433 + (long)var2 * (long)var1;
				if (this.field2434 - var3 >= 0L) {
					this.field2433 = var3;
					break;
				}

				int var5 = (int)((this.field2434 - this.field2433 + (long)var2 - 1L) / (long)var2);
				this.field2433 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3738();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1239536546"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3726();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "529284444"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1686884768"
	)
	public synchronized void method3720(int var1, int var2) {
		this.method3824(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2040435181"
	)
	void method3824(int var1, int var2) {
		this.field2414[var1] = var2;
		this.field2415[var1] = var2 & -128;
		this.method3716(var1, var2);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "5"
	)
	void method3716(int var1, int var2) {
		if (var2 != this.field2413[var1]) {
			this.field2413[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2428[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "659813426"
	)
	void method3717(int var1, int var2, int var3) {
		this.method3729(var1, var2, 64);
		if ((this.field2421[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2440 == var1 && var4.field2436 < 0) {
					this.field2427[var1][var4.field2450] = null;
					this.field2427[var1][var2] = var4;
					int var5 = (var4.field2445 * var4.field2446 >> 12) + var4.field2441;
					var4.field2441 += var2 - var4.field2450 << 8;
					var4.field2445 = var5 - var4.field2441;
					var4.field2446 = 4096;
					var4.field2450 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2413[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2440 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2452 = var9.field2481[var2];
				var6.field2438 = var9.field2479[var2];
				var6.field2450 = var2;
				var6.field2442 = var3 * var3 * var9.field2476[var2] * var9.field2475 + 1024 >> 11;
				var6.field2443 = var9.field2477[var2] & 255;
				var6.field2441 = (var2 << 8) - (var9.field2482[var2] & 32767);
				var6.field2447 = 0;
				var6.field2448 = 0;
				var6.field2449 = 0;
				var6.field2436 = -1;
				var6.field2451 = 0;
				if (this.field2410[var1] == 0) {
					var6.stream = RawPcmStream.method2524(var8, this.method3730(var6), this.method3731(var6), this.method3732(var6));
				} else {
					var6.stream = RawPcmStream.method2524(var8, this.method3730(var6), 0, this.method3732(var6));
					this.method3767(var6, var9.field2482[var2] < 0);
				}

				if (var9.field2482[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2438 >= 0) {
					MusicPatchNode var7 = this.field2428[var1][var6.field2438];
					if (var7 != null && var7.field2436 < 0) {
						this.field2427[var1][var7.field2450] = null;
						var7.field2436 = 0;
					}

					this.field2428[var1][var6.field2438] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2427[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lgi;ZB)V",
		garbageValue = "-58"
	)
	void method3767(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1393) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field2410[var1.field2440] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2614();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2410[var1.field2440] >> 6);
		}

		var1.stream.method2596(var4);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1579005533"
	)
	void method3729(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2427[var1][var2];
		if (var4 != null) {
			this.field2427[var1][var2] = null;
			if ((this.field2421[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2440 == var4.field2440 && var5.field2436 < 0 && var4 != var5) {
						var4.field2436 = 0;
						break;
					}
				}
			} else {
				var4.field2436 = 0;
			}

		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "2105784371"
	)
	void method3788(int var1, int var2, int var3) {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "8"
	)
	void method3793(int var1, int var2) {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1785966044"
	)
	void method3722(int var1, int var2) {
		this.field2429[var1] = var2;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "889719076"
	)
	void method3723(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2440 == var1) {
				if (var2.stream != null) {
					var2.stream.method2540(CollisionMap.PcmPlayer_sampleRate / 100);
					if (var2.stream.method2585()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3826();
				}

				if (var2.field2436 < 0) {
					this.field2427[var2.field2440][var2.field2450] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "112"
	)
	void method3724(int var1) {
		if (var1 >= 0) {
			this.field2411[var1] = 12800;
			this.field2412[var1] = 8192;
			this.field2422[var1] = 16383;
			this.field2429[var1] = 8192;
			this.field2418[var1] = 0;
			this.field2419[var1] = 8192;
			this.method3715(var1);
			this.method3784(var1);
			this.field2421[var1] = 0;
			this.field2424[var1] = 32767;
			this.field2423[var1] = 256;
			this.field2410[var1] = 0;
			this.method3754(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3724(var1);
			}

		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "786188119"
	)
	void method3714(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2440 == var1) && var2.field2436 < 0) {
				this.field2427[var2.field2440][var2.field2450] = null;
				var2.field2436 = 0;
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "23201"
	)
	void method3726() {
		this.method3723(-1);
		this.method3724(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2413[var1] = this.field2414[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2415[var1] = this.field2414[var1] & -128;
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-117878160"
	)
	void method3715(int var1) {
		if ((this.field2421[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2440 == var1 && this.field2427[var1][var2.field2450] == null && var2.field2436 < 0) {
					var2.field2436 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1541338262"
	)
	void method3784(int var1) {
		if ((this.field2421[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2440 == var1) {
					var2.field2444 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "946217459"
	)
	void method3728(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3729(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3717(var3, var4, var5);
			} else {
				this.method3729(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3788(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2415[var3] = (var5 << 14) + (this.field2415[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2415[var3] = (var5 << 7) + (this.field2415[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2418[var3] = (var5 << 7) + (this.field2418[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2418[var3] = var5 + (this.field2418[var3] & -128);
			}

			if (var4 == 5) {
				this.field2419[var3] = (var5 << 7) + (this.field2419[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2419[var3] = var5 + (this.field2419[var3] & -128);
			}

			if (var4 == 7) {
				this.field2411[var3] = (var5 << 7) + (this.field2411[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2411[var3] = var5 + (this.field2411[var3] & -128);
			}

			if (var4 == 10) {
				this.field2412[var3] = (var5 << 7) + (this.field2412[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2412[var3] = var5 + (this.field2412[var3] & -128);
			}

			if (var4 == 11) {
				this.field2422[var3] = (var5 << 7) + (this.field2422[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2422[var3] = var5 + (this.field2422[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2421;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2421;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2421;
					var10000[var3] |= 2;
				} else {
					this.method3715(var3);
					var10000 = this.field2421;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2424[var3] = (var5 << 7) + (this.field2424[var3] & 127);
			}

			if (var4 == 98) {
				this.field2424[var3] = (this.field2424[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2424[var3] = (var5 << 7) + (this.field2424[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2424[var3] = (this.field2424[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3723(var3);
			}

			if (var4 == 121) {
				this.method3724(var3);
			}

			if (var4 == 123) {
				this.method3714(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2424[var3];
				if (var6 == 16384) {
					this.field2423[var3] = (var5 << 7) + (this.field2423[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2424[var3];
				if (var6 == 16384) {
					this.field2423[var3] = var5 + (this.field2423[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2410[var3] = (var5 << 7) + (this.field2410[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2410[var3] = var5 + (this.field2410[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2421;
					var10000[var3] |= 4;
				} else {
					this.method3784(var3);
					var10000 = this.field2421;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3754(var3, (var5 << 7) + (this.field2425[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3754(var3, var5 + (this.field2425[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3716(var3, var4 + this.field2415[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3793(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3722(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3726();
			}
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "14"
	)
	void method3754(int var1, int var2) {
		this.field2425[var1] = var2;
		this.field2408[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Lgi;I)I",
		garbageValue = "-1889826116"
	)
	int method3730(MusicPatchNode var1) {
		int var2 = (var1.field2445 * var1.field2446 >> 12) + var1.field2441;
		var2 += (this.field2429[var1.field2440] - 8192) * this.field2423[var1.field2440] >> 12;
		MusicPatchNode2 var3 = var1.field2452;
		int var4;
		if (var3.field2394 > 0 && (var3.field2393 > 0 || this.field2418[var1.field2440] > 0)) {
			var4 = var3.field2393 << 2;
			int var5 = var3.field2395 << 1;
			if (var1.field2458 < var5) {
				var4 = var4 * var1.field2458 / var5;
			}

			var4 += this.field2418[var1.field2440] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2453 & 511));
			var2 += (int)(var6 * (double)var4);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)CollisionMap.PcmPlayer_sampleRate + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Lgi;B)I",
		garbageValue = "-94"
	)
	int method3731(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2452;
		int var3 = this.field2422[var1.field2440] * this.field2411[var1.field2440] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2442 + 16384 >> 15;
		var3 = var3 * this.field2409 + 128 >> 8;
		if (var2.field2392 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2447 * (double)var2.field2392) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2387 != null) {
			var4 = var1.field2448;
			var5 = var2.field2387[var1.field2449 * 4 + 1];
			if (var1.field2449 * 4 < var2.field2387.length - 2) {
				var6 = (var2.field2387[var1.field2449 * 4] & 255) << 8;
				var7 = (var2.field2387[var1.field2449 * 4 + 2] & 255) << 8;
				var5 += (var2.field2387[var1.field2449 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2436 > 0 && var2.field2388 != null) {
			var4 = var1.field2436;
			var5 = var2.field2388[var1.field2451 * 4 + 1];
			if (var1.field2451 * 4 < var2.field2388.length - 2) {
				var6 = (var2.field2388[var1.field2451 * 4] & 255) << 8;
				var7 = (var2.field2388[var1.field2451 * 4 + 2] & 255) << 8;
				var5 += (var2.field2388[var1.field2451 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Lgi;I)I",
		garbageValue = "-1266735092"
	)
	int method3732(MusicPatchNode var1) {
		int var2 = this.field2412[var1.field2440];
		return var2 < 8192 ? var2 * var1.field2443 + 32 >> 6 : 16384 - ((128 - var1.field2443) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1310291586"
	)
	void method3738() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2434; var2 == this.trackLength; var3 = this.midiFile.method3861(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2430 || var2 == 0) {
							this.method3726();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3728(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2434 = var3;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Lgi;I)Z",
		garbageValue = "2116286373"
	)
	boolean method3739(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2436 >= 0) {
				var1.remove();
				if (var1.field2438 > 0 && var1 == this.field2428[var1.field2440][var1.field2438]) {
					this.field2428[var1.field2440][var1.field2438] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(Lgi;[IIII)Z",
		garbageValue = "-176973860"
	)
	boolean method3740(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2455 = CollisionMap.PcmPlayer_sampleRate / 100;
		if (var1.field2436 < 0 || var1.stream != null && !var1.stream.method2558()) {
			int var5 = var1.field2446;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2419[var1.field2440]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2446 = var5;
			}

			var1.stream.method2538(this.method3730(var1));
			MusicPatchNode2 var6 = var1.field2452;
			boolean var7 = false;
			++var1.field2458;
			var1.field2453 += var6.field2394;
			double var8 = 5.086263020833333E-6D * (double)((var1.field2450 - 60 << 8) + (var1.field2445 * var1.field2446 >> 12));
			if (var6.field2392 > 0) {
				if (var6.field2391 > 0) {
					var1.field2447 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2391) + 0.5D);
				} else {
					var1.field2447 += 128;
				}
			}

			if (var6.field2387 != null) {
				if (var6.field2390 > 0) {
					var1.field2448 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2390 * var8) + 0.5D);
				} else {
					var1.field2448 += 128;
				}

				while (var1.field2449 * 4 < var6.field2387.length - 2 && var1.field2448 > (var6.field2387[var1.field2449 * 4 + 2] & 255) << 8) {
					var1.field2449 = var1.field2449 * 4 + 2;
				}

				if (var1.field2449 * 4 == var6.field2387.length - 2 && var6.field2387[var1.field2449 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2436 >= 0 && var6.field2388 != null && (this.field2421[var1.field2440] & 1) == 0 && (var1.field2438 < 0 || var1 != this.field2428[var1.field2440][var1.field2438])) {
				if (var6.field2398 > 0) {
					var1.field2436 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2398 * var8) + 0.5D);
				} else {
					var1.field2436 += 128;
				}

				while (var1.field2451 * 4 < var6.field2388.length - 2 && var1.field2436 > (var6.field2388[var1.field2451 * 4 + 2] & 255) << 8) {
					var1.field2451 = var1.field2451 * 4 + 2;
				}

				if (var1.field2451 * 4 == var6.field2388.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2540(var1.field2455);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2585()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3826();
				if (var1.field2436 >= 0) {
					var1.remove();
					if (var1.field2438 > 0 && var1 == this.field2428[var1.field2440][var1.field2438]) {
						this.field2428[var1.field2440][var1.field2438] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2536(var1.field2455, this.method3731(var1), this.method3732(var1));
				return false;
			}
		} else {
			var1.method3826();
			var1.remove();
			if (var1.field2438 > 0 && var1 == this.field2428[var1.field2440][var1.field2438]) {
				this.field2428[var1.field2440][var1.field2438] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1881799127"
	)
	public static boolean method3811() {
		ReflectionCheck var0 = (ReflectionCheck)class96.reflectionChecks.last();
		return var0 != null;
	}
}
