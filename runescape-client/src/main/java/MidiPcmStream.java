import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	static Widget field2410;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1414585865
	)
	int field2394;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1090700352
	)
	int field2401;
	@ObfuscatedName("g")
	int[] field2385;
	@ObfuscatedName("l")
	int[] field2386;
	@ObfuscatedName("u")
	int[] field2387;
	@ObfuscatedName("j")
	int[] field2388;
	@ObfuscatedName("v")
	int[] field2389;
	@ObfuscatedName("d")
	int[] field2390;
	@ObfuscatedName("z")
	int[] field2384;
	@ObfuscatedName("n")
	int[] field2392;
	@ObfuscatedName("h")
	int[] field2393;
	@ObfuscatedName("r")
	int[] field2395;
	@ObfuscatedName("k")
	int[] field2406;
	@ObfuscatedName("w")
	int[] field2405;
	@ObfuscatedName("m")
	int[] field2398;
	@ObfuscatedName("o")
	int[] field2383;
	@ObfuscatedName("a")
	int[] field2400;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "[[Lgs;"
	)
	MusicPatchNode[][] field2391;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "[[Lgs;"
	)
	MusicPatchNode[][] field2402;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("ao")
	boolean field2404;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1796077515
	)
	@Export("track")
	int track;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 376067527
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		longValue = 3263394730300168849L
	)
	long field2407;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		longValue = 3131582790426546053L
	)
	long field2408;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2394 = 256;
		this.field2401 = -727379968;
		this.field2385 = new int[16];
		this.field2386 = new int[16];
		this.field2387 = new int[16];
		this.field2388 = new int[16];
		this.field2389 = new int[16];
		this.field2390 = new int[16];
		this.field2384 = new int[16];
		this.field2392 = new int[16];
		this.field2393 = new int[16];
		this.field2395 = new int[16];
		this.field2406 = new int[16];
		this.field2405 = new int[16];
		this.field2398 = new int[16];
		this.field2383 = new int[16];
		this.field2400 = new int[16];
		this.field2391 = new MusicPatchNode[16][128];
		this.field2402 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3706();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "12"
	)
	public synchronized void method3686(int var1) {
		this.field2394 = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2102647071"
	)
	public int method3687() {
		return this.field2394;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lgy;Lhz;Ldy;IB)Z",
		garbageValue = "-18"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3902();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				var9 = class4.method47(var2, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var9, (long)var8);
			}

			if (!var9.method3868(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "114"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-1"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("v")
	protected synchronized int vmethod3881() {
		return 0;
	}

	@ObfuscatedName("d")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2401 * 1000000 / GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate;

			do {
				long var5 = this.field2407 + (long)var3 * (long)var4;
				if (this.field2408 - var5 >= 0L) {
					this.field2407 = var5;
					break;
				}

				int var7 = (int)((this.field2408 - this.field2407 + (long)var4 - 1L) / (long)var4);
				this.field2407 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3719();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lgy;ZI)V",
		garbageValue = "-1993702143"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2404 = var2;
		this.field2407 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2408 = this.midiFile.method3857(this.trackLength);
	}

	@ObfuscatedName("s")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2401 * 1000000 / GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate;

			do {
				long var3 = (long)var2 * (long)var1 + this.field2407;
				if (this.field2408 - var3 >= 0L) {
					this.field2407 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2408 - this.field2407) - 1L) / (long)var2);
				this.field2407 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3719();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "41"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3706();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1707602739"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-319046618"
	)
	public synchronized void method3732(int var1, int var2) {
		this.method3695(var1, var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "2"
	)
	void method3695(int var1, int var2) {
		this.field2388[var1] = var2;
		this.field2390[var1] = var2 & -128;
		this.method3709(var1, var2);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1562201672"
	)
	void method3709(int var1, int var2) {
		if (var2 != this.field2389[var1]) {
			this.field2389[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2402[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-37"
	)
	void method3697(int var1, int var2, int var3) {
		this.method3699(var1, var2, 64);
		if ((this.field2395[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2431 == var1 && var4.field2425 < 0) {
					this.field2391[var1][var4.field2413] = null;
					this.field2391[var1][var2] = var4;
					int var5 = (var4.field2420 * var4.field2433 >> 12) + var4.field2419;
					var4.field2419 += var2 - var4.field2413 << 8;
					var4.field2420 = var5 - var4.field2419;
					var4.field2433 = 4096;
					var4.field2413 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2389[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2431 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2415 = var9.field2449[var2];
				var6.field2426 = var9.field2454[var2];
				var6.field2413 = var2;
				var6.field2417 = var3 * var3 * var9.field2451[var2] * var9.field2453 + 1024 >> 11;
				var6.field2418 = var9.field2452[var2] & 255;
				var6.field2419 = (var2 << 8) - (var9.field2450[var2] & 32767);
				var6.field2414 = 0;
				var6.field2423 = 0;
				var6.field2424 = 0;
				var6.field2425 = -1;
				var6.field2416 = 0;
				if (this.field2398[var1] == 0) {
					var6.stream = RawPcmStream.method2511(var8, this.method3788(var6), this.method3786(var6), this.method3768(var6));
				} else {
					var6.stream = RawPcmStream.method2511(var8, this.method3788(var6), 0, this.method3768(var6));
					this.method3698(var6, var9.field2450[var2] < 0);
				}

				if (var9.field2450[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2426 >= 0) {
					MusicPatchNode var7 = this.field2402[var1][var6.field2426];
					if (var7 != null && var7.field2425 < 0) {
						this.field2391[var1][var7.field2413] = null;
						var7.field2425 = 0;
					}

					this.field2402[var1][var6.field2426] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2391[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lgs;ZI)V",
		garbageValue = "751548044"
	)
	void method3698(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1358) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field2398[var1.field2431] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2548();
			}
		} else {
			var4 = (int)((long)this.field2398[var1.field2431] * (long)var3 >> 6);
		}

		var1.stream.method2569(var4);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "722715254"
	)
	void method3699(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2391[var1][var2];
		if (var4 != null) {
			this.field2391[var1][var2] = null;
			if ((this.field2395[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var4.field2431 == var5.field2431 && var5.field2425 < 0 && var4 != var5) {
						var4.field2425 = 0;
						break;
					}
				}
			} else {
				var4.field2425 = 0;
			}

		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-17345247"
	)
	void method3700(int var1, int var2, int var3) {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "197246641"
	)
	void method3701(int var1, int var2) {
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1303532041"
	)
	void method3800(int var1, int var2) {
		this.field2384[var1] = var2;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-5696967"
	)
	void method3741(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2431 == var1) {
				if (var2.stream != null) {
					var2.stream.method2541(GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate / 100);
					if (var2.stream.method2606()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3810();
				}

				if (var2.field2425 < 0) {
					this.field2391[var2.field2431][var2.field2413] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "256"
	)
	void method3763(int var1) {
		if (var1 >= 0) {
			this.field2385[var1] = 12800;
			this.field2386[var1] = 8192;
			this.field2387[var1] = 16383;
			this.field2384[var1] = 8192;
			this.field2392[var1] = 0;
			this.field2393[var1] = 8192;
			this.method3707(var1);
			this.method3708(var1);
			this.field2395[var1] = 0;
			this.field2406[var1] = 32767;
			this.field2405[var1] = 256;
			this.field2398[var1] = 0;
			this.method3793(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3763(var1);
			}

		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "53"
	)
	void method3702(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2431 == var1) && var2.field2425 < 0) {
				this.field2391[var2.field2431][var2.field2413] = null;
				var2.field2425 = 0;
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-454562685"
	)
	void method3706() {
		this.method3741(-1);
		this.method3763(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2389[var1] = this.field2388[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2390[var1] = this.field2388[var1] & -128;
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-114"
	)
	void method3707(int var1) {
		if ((this.field2395[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2431 == var1 && this.field2391[var1][var2.field2413] == null && var2.field2425 < 0) {
					var2.field2425 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1016524602"
	)
	void method3708(int var1) {
		if ((this.field2395[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2431 == var1) {
					var2.field2422 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1496359636"
	)
	void method3735(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3699(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3697(var3, var4, var5);
			} else {
				this.method3699(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3700(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2390[var3] = (var5 << 14) + (this.field2390[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2390[var3] = (var5 << 7) + (this.field2390[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2392[var3] = (var5 << 7) + (this.field2392[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2392[var3] = var5 + (this.field2392[var3] & -128);
			}

			if (var4 == 5) {
				this.field2393[var3] = (var5 << 7) + (this.field2393[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2393[var3] = var5 + (this.field2393[var3] & -128);
			}

			if (var4 == 7) {
				this.field2385[var3] = (var5 << 7) + (this.field2385[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2385[var3] = var5 + (this.field2385[var3] & -128);
			}

			if (var4 == 10) {
				this.field2386[var3] = (var5 << 7) + (this.field2386[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2386[var3] = var5 + (this.field2386[var3] & -128);
			}

			if (var4 == 11) {
				this.field2387[var3] = (var5 << 7) + (this.field2387[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2387[var3] = var5 + (this.field2387[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2395;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2395;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2395;
					var10000[var3] |= 2;
				} else {
					this.method3707(var3);
					var10000 = this.field2395;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2406[var3] = (var5 << 7) + (this.field2406[var3] & 127);
			}

			if (var4 == 98) {
				this.field2406[var3] = (this.field2406[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2406[var3] = (var5 << 7) + (this.field2406[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2406[var3] = (this.field2406[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3741(var3);
			}

			if (var4 == 121) {
				this.method3763(var3);
			}

			if (var4 == 123) {
				this.method3702(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2406[var3];
				if (var6 == 16384) {
					this.field2405[var3] = (var5 << 7) + (this.field2405[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2406[var3];
				if (var6 == 16384) {
					this.field2405[var3] = var5 + (this.field2405[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2398[var3] = (var5 << 7) + (this.field2398[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2398[var3] = var5 + (this.field2398[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2395;
					var10000[var3] |= 4;
				} else {
					this.method3708(var3);
					var10000 = this.field2395;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3793(var3, (var5 << 7) + (this.field2383[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3793(var3, var5 + (this.field2383[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3709(var3, var4 + this.field2390[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3701(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3800(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3706();
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "631223088"
	)
	void method3793(int var1, int var2) {
		this.field2383[var1] = var2;
		this.field2400[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Lgs;B)I",
		garbageValue = "-78"
	)
	int method3788(MusicPatchNode var1) {
		int var2 = (var1.field2420 * var1.field2433 >> 12) + var1.field2419;
		var2 += (this.field2384[var1.field2431] - 8192) * this.field2405[var1.field2431] >> 12;
		MusicPatchNode2 var3 = var1.field2415;
		int var4;
		if (var3.field2367 > 0 && (var3.field2366 > 0 || this.field2392[var1.field2431] > 0)) {
			var4 = var3.field2366 << 2;
			int var5 = var3.field2370 << 1;
			if (var1.field2427 < var5) {
				var4 = var4 * var1.field2427 / var5;
			}

			var4 += this.field2392[var1.field2431] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2428 & 511));
			var2 += (int)(var6 * (double)var4);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Lgs;I)I",
		garbageValue = "1409927700"
	)
	int method3786(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2415;
		int var3 = this.field2385[var1.field2431] * this.field2387[var1.field2431] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2417 + 16384 >> 15;
		var3 = var3 * this.field2394 + 128 >> 8;
		if (var2.field2368 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2368 * 1.953125E-5D * (double)var1.field2414) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2365 != null) {
			var4 = var1.field2423;
			var5 = var2.field2365[var1.field2424 * 4 + 1];
			if (var1.field2424 * 4 < var2.field2365.length - 2) {
				var6 = (var2.field2365[var1.field2424 * 4] & 255) << 8;
				var7 = (var2.field2365[var1.field2424 * 4 + 2] & 255) << 8;
				var5 += (var2.field2365[var1.field2424 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		if (var1.field2425 > 0 && var2.field2361 != null) {
			var4 = var1.field2425;
			var5 = var2.field2361[var1.field2416 * 4 + 1];
			if (var1.field2416 * 4 < var2.field2361.length - 2) {
				var6 = (var2.field2361[var1.field2416 * 4] & 255) << 8;
				var7 = (var2.field2361[var1.field2416 * 4 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2361[var1.field2416 * 4 + 3] - var5) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Lgs;B)I",
		garbageValue = "-84"
	)
	int method3768(MusicPatchNode var1) {
		int var2 = this.field2386[var1.field2431];
		return var2 < 8192 ? var2 * var1.field2418 + 32 >> 6 : 16384 - ((128 - var1.field2418) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1899484159"
	)
	void method3719() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2408; var2 == this.trackLength; var3 = this.midiFile.method3857(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2404 || var2 == 0) {
							this.method3706();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3735(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2408 = var3;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Lgs;I)Z",
		garbageValue = "559345997"
	)
	boolean method3720(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2425 >= 0) {
				var1.remove();
				if (var1.field2426 > 0 && var1 == this.field2402[var1.field2431][var1.field2426]) {
					this.field2402[var1.field2431][var1.field2426] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Lgs;[IIII)Z",
		garbageValue = "-647308789"
	)
	boolean method3721(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2430 = GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate / 100;
		if (var1.field2425 < 0 || var1.stream != null && !var1.stream.method2583()) {
			int var5 = var1.field2433;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2393[var1.field2431] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2433 = var5;
			}

			var1.stream.method2525(this.method3788(var1));
			MusicPatchNode2 var6 = var1.field2415;
			boolean var7 = false;
			++var1.field2427;
			var1.field2428 += var6.field2367;
			double var8 = (double)((var1.field2413 - 60 << 8) + (var1.field2433 * var1.field2420 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2368 > 0) {
				if (var6.field2363 > 0) {
					var1.field2414 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2363 * var8) + 0.5D);
				} else {
					var1.field2414 += 128;
				}
			}

			if (var6.field2365 != null) {
				if (var6.field2360 > 0) {
					var1.field2423 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2360) + 0.5D);
				} else {
					var1.field2423 += 128;
				}

				while (var1.field2424 * 4 < var6.field2365.length - 2 && var1.field2423 > (var6.field2365[var1.field2424 * 4 + 2] & 255) << 8) {
					var1.field2424 = var1.field2424 * 4 + 2;
				}

				if (var1.field2424 * 4 == var6.field2365.length - 2 && var6.field2365[var1.field2424 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2425 >= 0 && var6.field2361 != null && (this.field2395[var1.field2431] & 1) == 0 && (var1.field2426 < 0 || var1 != this.field2402[var1.field2431][var1.field2426])) {
				if (var6.field2364 > 0) {
					var1.field2425 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2364) + 0.5D);
				} else {
					var1.field2425 += 128;
				}

				while (var1.field2416 * 4 < var6.field2361.length - 2 && var1.field2425 > (var6.field2361[var1.field2416 * 4 + 2] & 255) << 8) {
					var1.field2416 = var1.field2416 * 4 + 2;
				}

				if (var1.field2416 * 4 == var6.field2361.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2541(var1.field2430);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2606()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3810();
				if (var1.field2425 >= 0) {
					var1.remove();
					if (var1.field2426 > 0 && var1 == this.field2402[var1.field2431][var1.field2426]) {
						this.field2402[var1.field2431][var1.field2426] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2523(var1.field2430, this.method3786(var1), this.method3768(var1));
				return false;
			}
		} else {
			var1.method3810();
			var1.remove();
			if (var1.field2426 > 0 && var1 == this.field2402[var1.field2431][var1.field2426]) {
				this.field2402[var1.field2431][var1.field2426] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1312373259"
	)
	static void method3769() {
		GrandExchangeOffer.field67 = new int[2000];
		int var0 = 0;
		int var1 = 240;

		int var3;
		for (byte var2 = 12; var0 < 16; var1 -= var2) {
			var3 = FontName.method5287((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var0 / 16.0F + 0.075F));
			GrandExchangeOffer.field67[var0] = var3;
			++var0;
		}

		var1 = 48;

		for (int var5 = var1 / 6; var0 < GrandExchangeOffer.field67.length; var1 -= var5) {
			var3 = var0 * 2;

			for (int var4 = FontName.method5287((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < GrandExchangeOffer.field67.length; ++var0) {
				GrandExchangeOffer.field67[var0] = var4;
			}
		}

	}
}
