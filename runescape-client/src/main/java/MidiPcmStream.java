import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1432283379
	)
	int field2393;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 621704105
	)
	int field2394;
	@ObfuscatedName("u")
	int[] field2409;
	@ObfuscatedName("r")
	int[] field2405;
	@ObfuscatedName("p")
	int[] field2407;
	@ObfuscatedName("q")
	int[] field2398;
	@ObfuscatedName("m")
	int[] field2395;
	@ObfuscatedName("y")
	int[] field2400;
	@ObfuscatedName("i")
	int[] field2399;
	@ObfuscatedName("c")
	int[] field2402;
	@ObfuscatedName("b")
	int[] field2403;
	@ObfuscatedName("h")
	int[] field2404;
	@ObfuscatedName("s")
	int[] field2392;
	@ObfuscatedName("f")
	int[] field2418;
	@ObfuscatedName("j")
	int[] field2408;
	@ObfuscatedName("d")
	int[] field2406;
	@ObfuscatedName("l")
	int[] field2401;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "[[Lgu;"
	)
	MusicPatchNode[][] field2410;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "[[Lgu;"
	)
	MusicPatchNode[][] field2411;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("aw")
	boolean field2413;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 442651773
	)
	@Export("track")
	int track;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -532588397
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		longValue = -7808892689914607303L
	)
	long field2416;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		longValue = -2211095128418699139L
	)
	long field2417;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2393 = 256;
		this.field2394 = 1000000;
		this.field2409 = new int[16];
		this.field2405 = new int[16];
		this.field2407 = new int[16];
		this.field2398 = new int[16];
		this.field2395 = new int[16];
		this.field2400 = new int[16];
		this.field2399 = new int[16];
		this.field2402 = new int[16];
		this.field2403 = new int[16];
		this.field2404 = new int[16];
		this.field2392 = new int[16];
		this.field2418 = new int[16];
		this.field2408 = new int[16];
		this.field2406 = new int[16];
		this.field2401 = new int[16];
		this.field2410 = new MusicPatchNode[16][128];
		this.field2411 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3690();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1812413582"
	)
	public synchronized void method3760(int var1) {
		this.field2393 = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1892008992"
	)
	public int method3745() {
		return this.field2393;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lgh;Lhp;Ldq;II)Z",
		garbageValue = "-1805357835"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3895();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				var9 = WorldMapRegion.method519(var2, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var9, (long)var8);
			}

			if (!var9.method3856(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1194981634"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1548831069"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("m")
	protected synchronized int vmethod3882() {
		return 0;
	}

	@ObfuscatedName("y")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2394 * -727379968 / UrlRequest.PcmPlayer_sampleRate;

			do {
				long var5 = this.field2416 + (long)var4 * (long)var3;
				if (this.field2417 - var5 >= 0L) {
					this.field2416 = var5;
					break;
				}

				int var7 = (int)((this.field2417 - this.field2416 + (long)var4 - 1L) / (long)var4);
				this.field2416 += (long)var7 * (long)var4;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3740();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lgh;ZI)V",
		garbageValue = "1917268302"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2413 = var2;
		this.field2416 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2417 = this.midiFile.method3813(this.trackLength);
	}

	@ObfuscatedName("c")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2394 * -727379968 / UrlRequest.PcmPlayer_sampleRate;

			do {
				long var3 = this.field2416 + (long)var2 * (long)var1;
				if (this.field2417 - var3 >= 0L) {
					this.field2416 = var3;
					break;
				}

				int var5 = (int)((this.field2417 - this.field2416 + (long)var2 - 1L) / (long)var2);
				this.field2416 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3740();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-36"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3690();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-842698736"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-50"
	)
	public synchronized void method3746(int var1, int var2) {
		this.method3747(var1, var2);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "14"
	)
	void method3747(int var1, int var2) {
		this.field2398[var1] = var2;
		this.field2400[var1] = var2 & -128;
		this.method3680(var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1745754026"
	)
	void method3680(int var1, int var2) {
		if (var2 != this.field2395[var1]) {
			this.field2395[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2411[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "828963250"
	)
	void method3738(int var1, int var2, int var3) {
		this.method3683(var1, var2, 64);
		if ((this.field2404[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2420 == var1 && var4.field2433 < 0) {
					this.field2410[var1][var4.field2424] = null;
					this.field2410[var1][var2] = var4;
					int var5 = (var4.field2429 * var4.field2441 >> 12) + var4.field2427;
					var4.field2427 += var2 - var4.field2424 << 8;
					var4.field2441 = var5 - var4.field2427;
					var4.field2429 = 4096;
					var4.field2424 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2395[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2420 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2435 = var9.field2462[var2];
				var6.field2423 = var9.field2460[var2];
				var6.field2424 = var2;
				var6.field2425 = var3 * var3 * var9.field2459[var2] * var9.field2458 + 1024 >> 11;
				var6.field2426 = var9.field2456[var2] & 255;
				var6.field2427 = (var2 << 8) - (var9.field2457[var2] & 32767);
				var6.field2428 = 0;
				var6.field2431 = 0;
				var6.field2432 = 0;
				var6.field2433 = -1;
				var6.field2434 = 0;
				if (this.field2408[var1] == 0) {
					var6.stream = RawPcmStream.method2548(var8, this.method3695(var6), this.method3696(var6), this.method3751(var6));
				} else {
					var6.stream = RawPcmStream.method2548(var8, this.method3695(var6), 0, this.method3751(var6));
					this.method3682(var6, var9.field2457[var2] < 0);
				}

				if (var9.field2457[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2423 >= 0) {
					MusicPatchNode var7 = this.field2411[var1][var6.field2423];
					if (var7 != null && var7.field2433 < 0) {
						this.field2410[var1][var7.field2424] = null;
						var7.field2433 = 0;
					}

					this.field2411[var1][var6.field2423] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2410[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lgu;ZB)V",
		garbageValue = "-87"
	)
	void method3682(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1369) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2408[var1.field2420] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2525();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2408[var1.field2420] >> 6);
		}

		var1.stream.method2581(var4);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "97221829"
	)
	void method3683(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2410[var1][var2];
		if (var4 != null) {
			this.field2410[var1][var2] = null;
			if ((this.field2404[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var4.field2420 == var5.field2420 && var5.field2433 < 0 && var4 != var5) {
						var4.field2433 = 0;
						break;
					}
				}
			} else {
				var4.field2433 = 0;
			}

		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1518043222"
	)
	void method3684(int var1, int var2, int var3) {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-752934894"
	)
	void method3788(int var1, int var2) {
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "896514567"
	)
	void method3686(int var1, int var2) {
		this.field2399[var1] = var2;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1124863656"
	)
	void method3687(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2420 == var1) {
				if (var2.stream != null) {
					var2.stream.method2529(UrlRequest.PcmPlayer_sampleRate / 100);
					if (var2.stream.method2533()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3794();
				}

				if (var2.field2433 < 0) {
					this.field2410[var2.field2420][var2.field2424] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-61"
	)
	void method3688(int var1) {
		if (var1 >= 0) {
			this.field2409[var1] = 12800;
			this.field2405[var1] = 8192;
			this.field2407[var1] = 16383;
			this.field2399[var1] = 8192;
			this.field2402[var1] = 0;
			this.field2403[var1] = 8192;
			this.method3691(var1);
			this.method3692(var1);
			this.field2404[var1] = 0;
			this.field2392[var1] = 32767;
			this.field2418[var1] = 256;
			this.field2408[var1] = 0;
			this.method3744(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3688(var1);
			}

		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-91"
	)
	void method3785(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2420 == var1) && var2.field2433 < 0) {
				this.field2410[var2.field2420][var2.field2424] = null;
				var2.field2433 = 0;
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "997152444"
	)
	void method3690() {
		this.method3687(-1);
		this.method3688(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2395[var1] = this.field2398[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2400[var1] = this.field2398[var1] & -128;
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "91"
	)
	void method3691(int var1) {
		if ((this.field2404[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2420 == var1 && this.field2410[var1][var2.field2424] == null && var2.field2433 < 0) {
					var2.field2433 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1884831875"
	)
	void method3692(int var1) {
		if ((this.field2404[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2420 == var1) {
					var2.field2419 = 0;
				}
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1837545367"
	)
	void method3768(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3683(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3738(var3, var4, var5);
			} else {
				this.method3683(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3684(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2400[var3] = (var5 << 14) + (this.field2400[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2400[var3] = (var5 << 7) + (this.field2400[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2402[var3] = (var5 << 7) + (this.field2402[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2402[var3] = var5 + (this.field2402[var3] & -128);
			}

			if (var4 == 5) {
				this.field2403[var3] = (var5 << 7) + (this.field2403[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2403[var3] = var5 + (this.field2403[var3] & -128);
			}

			if (var4 == 7) {
				this.field2409[var3] = (var5 << 7) + (this.field2409[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2409[var3] = var5 + (this.field2409[var3] & -128);
			}

			if (var4 == 10) {
				this.field2405[var3] = (var5 << 7) + (this.field2405[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2405[var3] = var5 + (this.field2405[var3] & -128);
			}

			if (var4 == 11) {
				this.field2407[var3] = (var5 << 7) + (this.field2407[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2407[var3] = var5 + (this.field2407[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2404;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2404;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2404;
					var10000[var3] |= 2;
				} else {
					this.method3691(var3);
					var10000 = this.field2404;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2392[var3] = (var5 << 7) + (this.field2392[var3] & 127);
			}

			if (var4 == 98) {
				this.field2392[var3] = (this.field2392[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2392[var3] = (var5 << 7) + (this.field2392[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2392[var3] = (this.field2392[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3687(var3);
			}

			if (var4 == 121) {
				this.method3688(var3);
			}

			if (var4 == 123) {
				this.method3785(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2392[var3];
				if (var6 == 16384) {
					this.field2418[var3] = (var5 << 7) + (this.field2418[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2392[var3];
				if (var6 == 16384) {
					this.field2418[var3] = var5 + (this.field2418[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2408[var3] = (var5 << 7) + (this.field2408[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2408[var3] = var5 + (this.field2408[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2404;
					var10000[var3] |= 4;
				} else {
					this.method3692(var3);
					var10000 = this.field2404;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3744(var3, (var5 << 7) + (this.field2406[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3744(var3, var5 + (this.field2406[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3680(var3, var4 + this.field2400[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3788(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3686(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3690();
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1166869867"
	)
	void method3744(int var1, int var2) {
		this.field2406[var1] = var2;
		this.field2401[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Lgu;I)I",
		garbageValue = "-1249853166"
	)
	int method3695(MusicPatchNode var1) {
		int var2 = (var1.field2441 * var1.field2429 >> 12) + var1.field2427;
		var2 += (this.field2399[var1.field2420] - 8192) * this.field2418[var1.field2420] >> 12;
		MusicPatchNode2 var3 = var1.field2435;
		int var4;
		if (var3.field2380 > 0 && (var3.field2379 > 0 || this.field2402[var1.field2420] > 0)) {
			var4 = var3.field2379 << 2;
			int var5 = var3.field2381 << 1;
			if (var1.field2439 < var5) {
				var4 = var4 * var1.field2439 / var5;
			}

			var4 += this.field2402[var1.field2420] >> 7;
			double var6 = Math.sin((double)(var1.field2436 & 511) * 0.01227184630308513D);
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)UrlRequest.PcmPlayer_sampleRate + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Lgu;I)I",
		garbageValue = "8582462"
	)
	int method3696(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2435;
		int var3 = this.field2409[var1.field2420] * this.field2407[var1.field2420] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2425 + 16384 >> 15;
		var3 = var3 * this.field2393 + 128 >> 8;
		if (var2.field2375 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2428 * 1.953125E-5D * (double)var2.field2375) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2376 != null) {
			var4 = var1.field2431;
			var5 = var2.field2376[var1.field2432 * 2 + 1];
			if (var1.field2432 * 2 < var2.field2376.length - 2) {
				var6 = (var2.field2376[var1.field2432 * 2] & 255) << 8;
				var7 = (var2.field2376[var1.field2432 * 2 + 2] & 255) << 8;
				var5 += (var2.field2376[var1.field2432 * 2 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2433 > 0 && var2.field2374 != null) {
			var4 = var1.field2433;
			var5 = var2.field2374[var1.field2434 * 4 + 1];
			if (var1.field2434 * 4 < var2.field2374.length - 2) {
				var6 = (var2.field2374[var1.field2434 * 4] & 255) << 8;
				var7 = (var2.field2374[var1.field2434 * 4 + 2] & 255) << 8;
				var5 += (var2.field2374[var1.field2434 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(Lgu;I)I",
		garbageValue = "19850751"
	)
	int method3751(MusicPatchNode var1) {
		int var2 = this.field2405[var1.field2420];
		return var2 < 8192 ? var2 * var1.field2426 + 32 >> 6 : 16384 - ((128 - var1.field2426) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1542890504"
	)
	void method3740() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2417; var2 == this.trackLength; var3 = this.midiFile.method3813(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2413 || var2 == 0) {
							this.method3690();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3768(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2417 = var3;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(Lgu;I)Z",
		garbageValue = "1629954628"
	)
	boolean method3704(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2433 >= 0) {
				var1.remove();
				if (var1.field2423 > 0 && var1 == this.field2411[var1.field2420][var1.field2423]) {
					this.field2411[var1.field2420][var1.field2423] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(Lgu;[IIII)Z",
		garbageValue = "-1178188591"
	)
	boolean method3705(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2438 = UrlRequest.PcmPlayer_sampleRate / 100;
		if (var1.field2433 < 0 || var1.stream != null && !var1.stream.method2532()) {
			int var5 = var1.field2429;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2403[var1.field2420]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2429 = var5;
			}

			var1.stream.method2530(this.method3695(var1));
			MusicPatchNode2 var6 = var1.field2435;
			boolean var7 = false;
			++var1.field2439;
			var1.field2436 += var6.field2380;
			double var8 = 5.086263020833333E-6D * (double)((var1.field2424 - 60 << 8) + (var1.field2441 * var1.field2429 >> 12));
			if (var6.field2375 > 0) {
				if (var6.field2378 > 0) {
					var1.field2428 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2378 * var8) + 0.5D);
				} else {
					var1.field2428 += 128;
				}
			}

			if (var6.field2376 != null) {
				if (var6.field2373 > 0) {
					var1.field2431 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2373 * var8) + 0.5D);
				} else {
					var1.field2431 += 128;
				}

				while (var1.field2432 * 2 < var6.field2376.length - 2 && var1.field2431 > (var6.field2376[var1.field2432 * 2 + 2] & 255) << 8) {
					var1.field2432 = var1.field2432 * 4 + 4;
				}

				if (var1.field2432 * 2 == var6.field2376.length - 2 && var6.field2376[var1.field2432 * 2 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2433 >= 0 && var6.field2374 != null && (this.field2404[var1.field2420] & 1) == 0 && (var1.field2423 < 0 || var1 != this.field2411[var1.field2420][var1.field2423])) {
				if (var6.field2377 > 0) {
					var1.field2433 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2377 * var8) + 0.5D);
				} else {
					var1.field2433 += 128;
				}

				while (var1.field2434 * 4 < var6.field2374.length - 2 && var1.field2433 > (var6.field2374[var1.field2434 * 4 + 2] & 255) << 8) {
					var1.field2434 = var1.field2434 * 4 + 2;
				}

				if (var1.field2434 * 4 == var6.field2374.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2529(var1.field2438);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2533()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3794();
				if (var1.field2433 >= 0) {
					var1.remove();
					if (var1.field2423 > 0 && var1 == this.field2411[var1.field2420][var1.field2423]) {
						this.field2411[var1.field2420][var1.field2423] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2528(var1.field2438, this.method3696(var1), this.method3751(var1));
				return false;
			}
		} else {
			var1.method3794();
			var1.remove();
			if (var1.field2423 > 0 && var1 == this.field2411[var1.field2420][var1.field2423]) {
				this.field2411[var1.field2420][var1.field2423] = null;
			}

			return true;
		}
	}
}
