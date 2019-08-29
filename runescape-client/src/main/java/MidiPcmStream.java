import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 185095361
	)
	int field2390;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1841466363
	)
	int field2391;
	@ObfuscatedName("k")
	int[] field2406;
	@ObfuscatedName("u")
	int[] field2393;
	@ObfuscatedName("n")
	int[] field2394;
	@ObfuscatedName("t")
	int[] field2395;
	@ObfuscatedName("q")
	int[] field2413;
	@ObfuscatedName("x")
	int[] field2397;
	@ObfuscatedName("d")
	int[] field2398;
	@ObfuscatedName("f")
	int[] field2399;
	@ObfuscatedName("c")
	int[] field2400;
	@ObfuscatedName("a")
	int[] field2414;
	@ObfuscatedName("w")
	int[] field2403;
	@ObfuscatedName("l")
	int[] field2408;
	@ObfuscatedName("h")
	int[] field2389;
	@ObfuscatedName("v")
	int[] field2409;
	@ObfuscatedName("m")
	int[] field2415;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "[[Lgd;"
	)
	MusicPatchNode[][] field2405;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "[[Lgd;"
	)
	MusicPatchNode[][] field2402;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("ai")
	boolean field2411;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -2055331589
	)
	@Export("track")
	int track;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -554202803
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		longValue = 3749824554300054537L
	)
	long field2396;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		longValue = -6758315928508632083L
	)
	long field2407;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2390 = 256;
		this.field2391 = 1000000;
		this.field2406 = new int[16];
		this.field2393 = new int[16];
		this.field2394 = new int[16];
		this.field2395 = new int[16];
		this.field2413 = new int[16];
		this.field2397 = new int[16];
		this.field2398 = new int[16];
		this.field2399 = new int[16];
		this.field2400 = new int[16];
		this.field2414 = new int[16];
		this.field2403 = new int[16];
		this.field2408 = new int[16];
		this.field2389 = new int[16];
		this.field2409 = new int[16];
		this.field2415 = new int[16];
		this.field2405 = new MusicPatchNode[16][128];
		this.field2402 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3746();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "111893823"
	)
	public synchronized void method3670(int var1) {
		this.field2390 = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "150252238"
	)
	public int method3648() {
		return this.field2390;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lgy;Lhz;Ldh;II)Z",
		garbageValue = "2084569814"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3853();
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

			if (!var9.method3825(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1428915424"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-65"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("q")
	protected synchronized int vmethod3834() {
		return 0;
	}

	@ObfuscatedName("x")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2391 * -727379968 / PcmPlayer.PcmPlayer_sampleRate;

			do {
				long var5 = this.field2396 + (long)var3 * (long)var4;
				if (this.field2407 - var5 >= 0L) {
					this.field2396 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2407 - this.field2396) - 1L) / (long)var4);
				this.field2396 += (long)var7 * (long)var4;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3679();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lgy;ZB)V",
		garbageValue = "69"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2411 = var2;
		this.field2396 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2407 = this.midiFile.method3786(this.trackLength);
	}

	@ObfuscatedName("f")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2391 * -727379968 / PcmPlayer.PcmPlayer_sampleRate;

			do {
				long var3 = (long)var2 * (long)var1 + this.field2396;
				if (this.field2407 - var3 >= 0L) {
					this.field2396 = var3;
					break;
				}

				int var5 = (int)((this.field2407 - this.field2396 + (long)var2 - 1L) / (long)var2);
				this.field2396 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3679();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "17"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3746();
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "52176988"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-847662861"
	)
	public synchronized void method3655(int var1, int var2) {
		this.method3739(var1, var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-34"
	)
	void method3739(int var1, int var2) {
		this.field2395[var1] = var2;
		this.field2397[var1] = var2 & -128;
		this.method3657(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-958579239"
	)
	void method3657(int var1, int var2) {
		if (var2 != this.field2413[var1]) {
			this.field2413[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2402[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1813896856"
	)
	void method3658(int var1, int var2, int var3) {
		this.method3752(var1, var2, 64);
		if ((this.field2414[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2437 == var1 && var4.field2433 < 0) {
					this.field2405[var1][var4.field2424] = null;
					this.field2405[var1][var2] = var4;
					int var5 = (var4.field2428 * var4.field2440 >> 12) + var4.field2426;
					var4.field2426 += var2 - var4.field2424 << 8;
					var4.field2428 = var5 - var4.field2426;
					var4.field2440 = 4096;
					var4.field2424 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2413[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2437 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2422 = var9.field2460[var2];
				var6.field2423 = var9.field2461[var2];
				var6.field2424 = var2;
				var6.field2425 = var3 * var3 * var9.field2462[var2] * var9.field2459 + 1024 >> 11;
				var6.field2429 = var9.field2463[var2] & 255;
				var6.field2426 = (var2 << 8) - (var9.field2457[var2] & 32767);
				var6.field2430 = 0;
				var6.field2431 = 0;
				var6.field2432 = 0;
				var6.field2433 = -1;
				var6.field2434 = 0;
				if (this.field2389[var1] == 0) {
					var6.stream = RawPcmStream.method2460(var8, this.method3660(var6), this.method3704(var6), this.method3673(var6));
				} else {
					var6.stream = RawPcmStream.method2460(var8, this.method3660(var6), 0, this.method3673(var6));
					this.method3731(var6, var9.field2457[var2] < 0);
				}

				if (var9.field2457[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2423 >= 0) {
					MusicPatchNode var7 = this.field2402[var1][var6.field2423];
					if (var7 != null && var7.field2433 < 0) {
						this.field2405[var1][var7.field2424] = null;
						var7.field2433 = 0;
					}

					this.field2402[var1][var6.field2423] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2405[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lgd;ZI)V",
		garbageValue = "942908769"
	)
	void method3731(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1362) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2389[var1.field2437] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2469();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2389[var1.field2437] >> 6);
		}

		var1.stream.method2468(var4);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "19"
	)
	void method3752(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2405[var1][var2];
		if (var4 != null) {
			this.field2405[var1][var2] = null;
			if ((this.field2414[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2437 == var4.field2437 && var5.field2433 < 0 && var4 != var5) {
						var4.field2433 = 0;
						break;
					}
				}
			} else {
				var4.field2433 = 0;
			}

		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-942200921"
	)
	void method3661(int var1, int var2, int var3) {
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-12366119"
	)
	void method3662(int var1, int var2) {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1514841200"
	)
	void method3663(int var1, int var2) {
		this.field2398[var1] = var2;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1503846449"
	)
	void method3736(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2437 == var1) {
				if (var2.stream != null) {
					var2.stream.method2473(PcmPlayer.PcmPlayer_sampleRate / 100);
					if (var2.stream.method2457()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3767();
				}

				if (var2.field2433 < 0) {
					this.field2405[var2.field2437][var2.field2424] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1795083748"
	)
	void method3737(int var1) {
		if (var1 >= 0) {
			this.field2406[var1] = 12800;
			this.field2393[var1] = 8192;
			this.field2394[var1] = 16383;
			this.field2398[var1] = 8192;
			this.field2399[var1] = 0;
			this.field2400[var1] = 8192;
			this.method3659(var1);
			this.method3765(var1);
			this.field2414[var1] = 0;
			this.field2403[var1] = 32767;
			this.field2408[var1] = 256;
			this.field2389[var1] = 0;
			this.method3671(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3737(var1);
			}

		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2085170598"
	)
	void method3685(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2437 == var1) && var2.field2433 < 0) {
				this.field2405[var2.field2437][var2.field2424] = null;
				var2.field2433 = 0;
			}
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "541615354"
	)
	void method3746() {
		this.method3736(-1);
		this.method3737(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2413[var1] = this.field2395[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2397[var1] = this.field2395[var1] & -128;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "955617478"
	)
	void method3659(int var1) {
		if ((this.field2414[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2437 == var1 && this.field2405[var1][var2.field2424] == null && var2.field2433 < 0) {
					var2.field2433 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "127764810"
	)
	void method3765(int var1) {
		if ((this.field2414[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2437 == var1) {
					var2.field2439 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2066346211"
	)
	void method3697(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3752(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3658(var3, var4, var5);
			} else {
				this.method3752(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3661(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2397[var3] = (var5 << 14) + (this.field2397[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2397[var3] = (var5 << 7) + (this.field2397[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2399[var3] = (var5 << 7) + (this.field2399[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2399[var3] = var5 + (this.field2399[var3] & -128);
			}

			if (var4 == 5) {
				this.field2400[var3] = (var5 << 7) + (this.field2400[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2400[var3] = var5 + (this.field2400[var3] & -128);
			}

			if (var4 == 7) {
				this.field2406[var3] = (var5 << 7) + (this.field2406[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2406[var3] = var5 + (this.field2406[var3] & -128);
			}

			if (var4 == 10) {
				this.field2393[var3] = (var5 << 7) + (this.field2393[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2393[var3] = var5 + (this.field2393[var3] & -128);
			}

			if (var4 == 11) {
				this.field2394[var3] = (var5 << 7) + (this.field2394[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2394[var3] = var5 + (this.field2394[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2414;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2414;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2414;
					var10000[var3] |= 2;
				} else {
					this.method3659(var3);
					var10000 = this.field2414;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2403[var3] = (var5 << 7) + (this.field2403[var3] & 127);
			}

			if (var4 == 98) {
				this.field2403[var3] = (this.field2403[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2403[var3] = (var5 << 7) + (this.field2403[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2403[var3] = (this.field2403[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3736(var3);
			}

			if (var4 == 121) {
				this.method3737(var3);
			}

			if (var4 == 123) {
				this.method3685(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2403[var3];
				if (var6 == 16384) {
					this.field2408[var3] = (var5 << 7) + (this.field2408[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2403[var3];
				if (var6 == 16384) {
					this.field2408[var3] = var5 + (this.field2408[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2389[var3] = (var5 << 7) + (this.field2389[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2389[var3] = var5 + (this.field2389[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2414;
					var10000[var3] |= 4;
				} else {
					this.method3765(var3);
					var10000 = this.field2414;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3671(var3, (var5 << 7) + (this.field2409[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3671(var3, var5 + (this.field2409[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3657(var3, var4 + this.field2397[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3662(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3663(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3746();
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1884051216"
	)
	void method3671(int var1, int var2) {
		this.field2409[var1] = var2;
		this.field2415[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Lgd;I)I",
		garbageValue = "1407355408"
	)
	int method3660(MusicPatchNode var1) {
		int var2 = (var1.field2428 * var1.field2440 >> 12) + var1.field2426;
		var2 += (this.field2398[var1.field2437] - 8192) * this.field2408[var1.field2437] >> 12;
		MusicPatchNode2 var3 = var1.field2422;
		int var4;
		if (var3.field2376 > 0 && (var3.field2375 > 0 || this.field2399[var1.field2437] > 0)) {
			var4 = var3.field2375 << 2;
			int var5 = var3.field2377 << 1;
			if (var1.field2435 < var5) {
				var4 = var4 * var1.field2435 / var5;
			}

			var4 += this.field2399[var1.field2437] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2436 & 511));
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)PcmPlayer.PcmPlayer_sampleRate + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Lgd;B)I",
		garbageValue = "114"
	)
	int method3704(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2422;
		int var3 = this.field2394[var1.field2437] * this.field2406[var1.field2437] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2425 + 16384 >> 15;
		var3 = var3 * this.field2390 + 128 >> 8;
		if (var2.field2372 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2372 * 1.953125E-5D * (double)var1.field2430) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2369 != null) {
			var4 = var1.field2431;
			var5 = var2.field2369[var1.field2432 * 4 + 1];
			if (var1.field2432 * 4 < var2.field2369.length - 2) {
				var6 = (var2.field2369[var1.field2432 * 4] & 255) << 8;
				var7 = (var2.field2369[var1.field2432 * 4 + 2] & 255) << 8;
				var5 += (var2.field2369[var1.field2432 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		if (var1.field2433 > 0 && var2.field2370 != null) {
			var4 = var1.field2433;
			var5 = var2.field2370[var1.field2434 * 2 + 1];
			if (var1.field2434 * 2 < var2.field2370.length - 2) {
				var6 = (var2.field2370[var1.field2434 * 2] & 255) << 8;
				var7 = (var2.field2370[var1.field2434 * 2 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2370[var1.field2434 * 2 + 3] - var5) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Lgd;B)I",
		garbageValue = "0"
	)
	int method3673(MusicPatchNode var1) {
		int var2 = this.field2393[var1.field2437];
		return var2 < 8192 ? var2 * var1.field2429 + 32 >> 6 : 16384 - ((128 - var1.field2429) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1618427490"
	)
	void method3679() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2407; var2 == this.trackLength; var3 = this.midiFile.method3786(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2411 || var2 == 0) {
							this.method3746();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3697(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2407 = var3;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Lgd;B)Z",
		garbageValue = "0"
	)
	boolean method3680(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2433 >= 0) {
				var1.remove();
				if (var1.field2423 > 0 && var1 == this.field2402[var1.field2437][var1.field2423]) {
					this.field2402[var1.field2437][var1.field2423] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Lgd;[IIIB)Z",
		garbageValue = "96"
	)
	boolean method3665(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2438 = PcmPlayer.PcmPlayer_sampleRate / 100;
		if (var1.field2433 < 0 || var1.stream != null && !var1.stream.method2476()) {
			int var5 = var1.field2440;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2400[var1.field2437]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2440 = var5;
			}

			var1.stream.method2474(this.method3660(var1));
			MusicPatchNode2 var6 = var1.field2422;
			boolean var7 = false;
			++var1.field2435;
			var1.field2436 += var6.field2376;
			double var8 = (double)((var1.field2424 - 60 << 8) + (var1.field2428 * var1.field2440 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2372 > 0) {
				if (var6.field2374 > 0) {
					var1.field2430 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2374 * var8) + 0.5D);
				} else {
					var1.field2430 += 128;
				}
			}

			if (var6.field2369 != null) {
				if (var6.field2371 > 0) {
					var1.field2431 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2371 * var8) + 0.5D);
				} else {
					var1.field2431 += 128;
				}

				while (var1.field2432 * 4 < var6.field2369.length - 2 && var1.field2431 > (var6.field2369[var1.field2432 * 4 + 2] & 255) << 8) {
					var1.field2432 = var1.field2432 * 4 + 2;
				}

				if (var1.field2432 * 4 == var6.field2369.length - 2 && var6.field2369[var1.field2432 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2433 >= 0 && var6.field2370 != null && (this.field2414[var1.field2437] & 1) == 0 && (var1.field2423 < 0 || var1 != this.field2402[var1.field2437][var1.field2423])) {
				if (var6.field2373 > 0) {
					var1.field2433 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2373) + 0.5D);
				} else {
					var1.field2433 += 128;
				}

				while (var1.field2434 * 2 < var6.field2370.length - 2 && var1.field2433 > (var6.field2370[var1.field2434 * 2 + 2] & 255) << 8) {
					var1.field2434 = var1.field2434 * 4 + 4;
				}

				if (var1.field2434 * 2 == var6.field2370.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2473(var1.field2438);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2457()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3767();
				if (var1.field2433 >= 0) {
					var1.remove();
					if (var1.field2423 > 0 && var1 == this.field2402[var1.field2437][var1.field2423]) {
						this.field2402[var1.field2437][var1.field2423] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2472(var1.field2438, this.method3704(var1), this.method3673(var1));
				return false;
			}
		} else {
			var1.method3767();
			var1.remove();
			if (var1.field2423 > 0 && var1 == this.field2402[var1.field2437][var1.field2423]) {
				this.field2402[var1.field2437][var1.field2423] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(Lhp;III)V",
		garbageValue = "-799494099"
	)
	@Export("checkIfMinimapClicked")
	static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
		if (Client.minimapState == 0 || Client.minimapState == 3) {
			if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) {
				SpriteMask var3 = var0.getSpriteMask(true);
				if (var3 == null) {
					return;
				}

				int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
				int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
				if (var3.contains(var4, var5)) {
					var4 -= var3.width / 2;
					var5 -= var3.height / 2;
					int var6 = Client.camAngleY & 2047;
					int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
					int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
					int var9 = var4 * var8 + var5 * var7 >> 11;
					int var10 = var8 * var5 - var7 * var4 >> 11;
					int var11 = var9 + WorldMapIcon_1.localPlayer.x >> 7;
					int var12 = WorldMapIcon_1.localPlayer.y - var10 >> 7;
					PacketBufferNode var13 = MenuAction.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
					var13.packetBuffer.writeByte(18);
					var13.packetBuffer.method5443(RouteStrategy.baseY * 64 + var12);
					var13.packetBuffer.method5443(PacketWriter.baseX * 64 + var11);
					var13.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
					var13.packetBuffer.writeByte(var4);
					var13.packetBuffer.writeByte(var5);
					var13.packetBuffer.writeShort(Client.camAngleY);
					var13.packetBuffer.writeByte(57);
					var13.packetBuffer.writeByte(0);
					var13.packetBuffer.writeByte(0);
					var13.packetBuffer.writeByte(89);
					var13.packetBuffer.writeShort(WorldMapIcon_1.localPlayer.x);
					var13.packetBuffer.writeShort(WorldMapIcon_1.localPlayer.y);
					var13.packetBuffer.writeByte(63);
					Client.packetWriter.addNode(var13);
					Client.destinationX = var11;
					Client.destinationY = var12;
				}
			}

		}
	}
}
