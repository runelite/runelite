import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	static Widget field2444;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -758577325
	)
	int field2434;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1685666624
	)
	int field2419;
	@ObfuscatedName("e")
	int[] field2417;
	@ObfuscatedName("i")
	int[] field2421;
	@ObfuscatedName("g")
	int[] field2440;
	@ObfuscatedName("d")
	int[] field2423;
	@ObfuscatedName("l")
	int[] field2443;
	@ObfuscatedName("j")
	int[] field2418;
	@ObfuscatedName("m")
	int[] field2426;
	@ObfuscatedName("p")
	int[] field2420;
	@ObfuscatedName("h")
	int[] field2428;
	@ObfuscatedName("y")
	int[] field2429;
	@ObfuscatedName("f")
	int[] field2437;
	@ObfuscatedName("b")
	int[] field2431;
	@ObfuscatedName("r")
	int[] field2432;
	@ObfuscatedName("s")
	int[] field2433;
	@ObfuscatedName("a")
	int[] field2422;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[[Lgu;"
	)
	MusicPatchNode[][] field2435;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "[[Lgu;"
	)
	MusicPatchNode[][] field2436;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("az")
	boolean field2438;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -2133377523
	)
	@Export("track")
	int track;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 2127527165
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		longValue = -7268027990425382261L
	)
	long field2441;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		longValue = 1615665924720735765L
	)
	long field2442;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2434 = 256;
		this.field2419 = -727379968;
		this.field2417 = new int[16];
		this.field2421 = new int[16];
		this.field2440 = new int[16];
		this.field2423 = new int[16];
		this.field2443 = new int[16];
		this.field2418 = new int[16];
		this.field2426 = new int[16];
		this.field2420 = new int[16];
		this.field2428 = new int[16];
		this.field2429 = new int[16];
		this.field2437 = new int[16];
		this.field2431 = new int[16];
		this.field2432 = new int[16];
		this.field2433 = new int[16];
		this.field2422 = new int[16];
		this.field2435 = new MusicPatchNode[16][128];
		this.field2436 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3878();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2434 = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-102"
	)
	public int method3764() {
		return this.field2434;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lgk;Lii;Ldv;II)Z",
		garbageValue = "1923256640"
	)
	@Export("loadMusicTrack")
	synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3993();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				var9 = GameShell.method1067(var2, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var9, (long)var8);
			}

			if (!var9.method3952(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("clearAll")
	synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-457364523"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("l")
	protected synchronized int vmethod3965() {
		return 0;
	}

	@ObfuscatedName("j")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2419 * 1000000 / PcmPlayer.field1398;

			do {
				long var5 = this.field2441 + (long)var3 * (long)var4;
				if (this.field2442 - var5 >= 0L) {
					this.field2441 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2442 - this.field2441) - 1L) / (long)var4);
				this.field2441 += (long)var7 * (long)var4;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3796();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lgk;ZI)V",
		garbageValue = "1689083592"
	)
	@Export("setMusicTrack")
	synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2438 = var2;
		this.field2441 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2442 = this.midiFile.method3917(this.trackLength);
	}

	@ObfuscatedName("p")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2419 * 1000000 / PcmPlayer.field1398;

			do {
				long var3 = this.field2441 + (long)var1 * (long)var2;
				if (this.field2442 - var3 >= 0L) {
					this.field2441 = var3;
					break;
				}

				int var5 = (int)((this.field2442 - this.field2441 + (long)var2 - 1L) / (long)var2);
				this.field2441 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3796();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-18"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3878();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-261574167"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "89"
	)
	public synchronized void method3819(int var1, int var2) {
		this.method3772(var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "101"
	)
	void method3772(int var1, int var2) {
		this.field2423[var1] = var2;
		this.field2418[var1] = var2 & -128;
		this.method3773(var1, var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "29980"
	)
	void method3773(int var1, int var2) {
		if (var2 != this.field2443[var1]) {
			this.field2443[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2436[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "547070105"
	)
	void method3774(int var1, int var2, int var3) {
		this.method3887(var1, var2, 64);
		if ((this.field2429[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2447 == var1 && var4.field2459 < 0) {
					this.field2435[var1][var4.field2450] = null;
					this.field2435[var1][var2] = var4;
					int var5 = (var4.field2454 * var4.field2455 >> 12) + var4.field2446;
					var4.field2446 += var2 - var4.field2450 << 8;
					var4.field2454 = var5 - var4.field2446;
					var4.field2455 = 4096;
					var4.field2450 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2443[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2447 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2445 = var9.field2487[var2];
				var6.field2449 = var9.field2485[var2];
				var6.field2450 = var2;
				var6.field2451 = var3 * var3 * var9.field2486[var2] * var9.field2488 + 1024 >> 11;
				var6.field2457 = var9.field2482[var2] & 255;
				var6.field2446 = (var2 << 8) - (var9.field2483[var2] & 32767);
				var6.field2456 = 0;
				var6.field2448 = 0;
				var6.field2458 = 0;
				var6.field2459 = -1;
				var6.field2460 = 0;
				if (this.field2432[var1] == 0) {
					var6.stream = RawPcmStream.method2673(var8, this.method3788(var6), this.method3789(var6), this.method3790(var6));
				} else {
					var6.stream = RawPcmStream.method2673(var8, this.method3788(var6), 0, this.method3790(var6));
					this.method3775(var6, var9.field2483[var2] < 0);
				}

				if (var9.field2483[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2449 >= 0) {
					MusicPatchNode var7 = this.field2436[var1][var6.field2449];
					if (var7 != null && var7.field2459 < 0) {
						this.field2435[var1][var7.field2450] = null;
						var7.field2459 = 0;
					}

					this.field2436[var1][var6.field2449] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2435[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lgu;ZI)V",
		garbageValue = "-1328035462"
	)
	void method3775(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1379) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field2432[var1.field2447] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2710();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2432[var1.field2447] >> 6);
		}

		var1.stream.method2622(var4);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-128"
	)
	void method3887(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2435[var1][var2];
		if (var4 != null) {
			this.field2435[var1][var2] = null;
			if ((this.field2429[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2447 == var4.field2447 && var5.field2459 < 0 && var4 != var5) {
						var4.field2459 = 0;
						break;
					}
				}
			} else {
				var4.field2459 = 0;
			}

		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-666904173"
	)
	void method3777(int var1, int var2, int var3) {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-700125854"
	)
	void method3778(int var1, int var2) {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1537654694"
	)
	void method3779(int var1, int var2) {
		this.field2426[var1] = var2;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1595965237"
	)
	void method3780(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2447 == var1) {
				if (var2.stream != null) {
					var2.stream.method2619(PcmPlayer.field1398 / 100);
					if (var2.stream.method2712()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3896();
				}

				if (var2.field2459 < 0) {
					this.field2435[var2.field2447][var2.field2450] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1470820319"
	)
	void method3787(int var1) {
		if (var1 >= 0) {
			this.field2417[var1] = 12800;
			this.field2421[var1] = 8192;
			this.field2440[var1] = 16383;
			this.field2426[var1] = 8192;
			this.field2420[var1] = 0;
			this.field2428[var1] = 8192;
			this.method3784(var1);
			this.method3785(var1);
			this.field2429[var1] = 0;
			this.field2437[var1] = 32767;
			this.field2431[var1] = 256;
			this.field2432[var1] = 0;
			this.method3771(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3787(var1);
			}

		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "112"
	)
	void method3795(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2447 == var1) && var2.field2459 < 0) {
				this.field2435[var2.field2447][var2.field2450] = null;
				var2.field2459 = 0;
			}
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1072017255"
	)
	void method3878() {
		this.method3780(-1);
		this.method3787(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2443[var1] = this.field2423[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2418[var1] = this.field2423[var1] & -128;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "131749797"
	)
	void method3784(int var1) {
		if ((this.field2429[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2447 == var1 && this.field2435[var1][var2.field2450] == null && var2.field2459 < 0) {
					var2.field2459 = 0;
				}
			}
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2050872328"
	)
	void method3785(int var1) {
		if ((this.field2429[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2447 == var1) {
					var2.field2465 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1369588293"
	)
	void method3786(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3887(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3774(var3, var4, var5);
			} else {
				this.method3887(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3777(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2418[var3] = (var5 << 14) + (this.field2418[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2418[var3] = (var5 << 7) + (this.field2418[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2420[var3] = (var5 << 7) + (this.field2420[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2420[var3] = var5 + (this.field2420[var3] & -128);
			}

			if (var4 == 5) {
				this.field2428[var3] = (var5 << 7) + (this.field2428[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2428[var3] = var5 + (this.field2428[var3] & -128);
			}

			if (var4 == 7) {
				this.field2417[var3] = (var5 << 7) + (this.field2417[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2417[var3] = var5 + (this.field2417[var3] & -128);
			}

			if (var4 == 10) {
				this.field2421[var3] = (var5 << 7) + (this.field2421[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2421[var3] = var5 + (this.field2421[var3] & -128);
			}

			if (var4 == 11) {
				this.field2440[var3] = (var5 << 7) + (this.field2440[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2440[var3] = var5 + (this.field2440[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2429;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2429;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2429;
					var10000[var3] |= 2;
				} else {
					this.method3784(var3);
					var10000 = this.field2429;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2437[var3] = (var5 << 7) + (this.field2437[var3] & 127);
			}

			if (var4 == 98) {
				this.field2437[var3] = (this.field2437[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2437[var3] = (var5 << 7) + (this.field2437[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2437[var3] = (this.field2437[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3780(var3);
			}

			if (var4 == 121) {
				this.method3787(var3);
			}

			if (var4 == 123) {
				this.method3795(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2437[var3];
				if (var6 == 16384) {
					this.field2431[var3] = (var5 << 7) + (this.field2431[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2437[var3];
				if (var6 == 16384) {
					this.field2431[var3] = var5 + (this.field2431[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2432[var3] = (var5 << 7) + (this.field2432[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2432[var3] = var5 + (this.field2432[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2429;
					var10000[var3] |= 4;
				} else {
					this.method3785(var3);
					var10000 = this.field2429;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3771(var3, (var5 << 7) + (this.field2433[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3771(var3, var5 + (this.field2433[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3773(var3, var4 + this.field2418[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3778(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3779(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3878();
			}
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "-26086"
	)
	void method3771(int var1, int var2) {
		this.field2433[var1] = var2;
		this.field2422[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Lgu;I)I",
		garbageValue = "-1438350668"
	)
	int method3788(MusicPatchNode var1) {
		int var2 = (var1.field2455 * var1.field2454 >> 12) + var1.field2446;
		var2 += (this.field2426[var1.field2447] - 8192) * this.field2431[var1.field2447] >> 12;
		MusicPatchNode2 var3 = var1.field2445;
		int var4;
		if (var3.field2405 > 0 && (var3.field2398 > 0 || this.field2420[var1.field2447] > 0)) {
			var4 = var3.field2398 << 2;
			int var5 = var3.field2406 << 1;
			if (var1.field2461 < var5) {
				var4 = var4 * var1.field2461 / var5;
			}

			var4 += this.field2420[var1.field2447] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2453 & 511));
			var2 += (int)(var6 * (double)var4);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)PcmPlayer.field1398 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Lgu;I)I",
		garbageValue = "-1402395014"
	)
	int method3789(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2445;
		int var3 = this.field2440[var1.field2447] * this.field2417[var1.field2447] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2451 + 16384 >> 15;
		var3 = var3 * this.field2434 + 128 >> 8;
		if (var2.field2404 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2404 * (double)(var1.field2456 * 128) * 1.953125E-5D) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2402 != null) {
			var4 = var1.field2448;
			var5 = var2.field2402[var1.field2458 * 4 + 1];
			if (var1.field2458 * 4 < var2.field2402.length - 2) {
				var6 = (var2.field2402[var1.field2458 * 4] & 255) << 8;
				var7 = (var2.field2402[var1.field2458 * 4 + 2] & 255) << 8;
				var5 += (var2.field2402[var1.field2458 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2459 > 0 && var2.field2399 != null) {
			var4 = var1.field2459;
			var5 = var2.field2399[var1.field2460 * 2 + 1];
			if (var1.field2460 * 2 < var2.field2399.length - 2) {
				var6 = (var2.field2399[var1.field2460 * 2] & 255) << 8;
				var7 = (var2.field2399[var1.field2460 * 2 + 2] & 255) << 8;
				var5 += (var2.field2399[var1.field2460 * 2 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(Lgu;I)I",
		garbageValue = "1626929968"
	)
	int method3790(MusicPatchNode var1) {
		int var2 = this.field2421[var1.field2447];
		return var2 < 8192 ? var2 * var1.field2457 + 32 >> 6 : 16384 - ((128 - var1.field2457) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1319413335"
	)
	void method3796() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2442; var2 == this.trackLength; var3 = this.midiFile.method3917(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2438 || var2 == 0) {
							this.method3878();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3786(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2442 = var3;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(Lgu;B)Z",
		garbageValue = "-27"
	)
	boolean method3822(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2459 >= 0) {
				var1.remove();
				if (var1.field2449 > 0 && var1 == this.field2436[var1.field2447][var1.field2449]) {
					this.field2436[var1.field2447][var1.field2449] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(Lgu;[IIIB)Z",
		garbageValue = "12"
	)
	boolean method3848(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2464 = PcmPlayer.field1398 / 100;
		if (var1.field2459 < 0 || var1.stream != null && !var1.stream.method2674()) {
			int var5 = var1.field2455;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2428[var1.field2447]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2455 = var5;
			}

			var1.stream.method2660(this.method3788(var1));
			MusicPatchNode2 var6 = var1.field2445;
			boolean var7 = false;
			++var1.field2461;
			var1.field2453 += var6.field2405;
			double var8 = (double)((var1.field2450 - 60 << 8) + (var1.field2455 * var1.field2454 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2404 > 0) {
				if (var6.field2403 > 0) {
					var1.field2456 = var1.field2456 * -1540341760 + (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2403) + 0.5D) * 457728128;
				} else {
					var1.field2456 = var1.field2456 * -1540341760 + -1540341760;
				}
			}

			if (var6.field2402 != null) {
				if (var6.field2401 > 0) {
					var1.field2448 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2401) + 0.5D);
				} else {
					var1.field2448 += 128;
				}

				while (var1.field2458 * 4 < var6.field2402.length - 2 && var1.field2448 > (var6.field2402[var1.field2458 * 4 + 2] & 255) << 8) {
					var1.field2458 = var1.field2458 * 4 + 2;
				}

				if (var1.field2458 * 4 == var6.field2402.length - 2 && var6.field2402[var1.field2458 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2459 >= 0 && var6.field2399 != null && (this.field2429[var1.field2447] & 1) == 0 && (var1.field2449 < 0 || var1 != this.field2436[var1.field2447][var1.field2449])) {
				if (var6.field2400 > 0) {
					var1.field2459 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2400 * var8) + 0.5D);
				} else {
					var1.field2459 += 128;
				}

				while (var1.field2460 * 2 < var6.field2399.length - 2 && var1.field2459 > (var6.field2399[var1.field2460 * 2 + 2] & 255) << 8) {
					var1.field2460 = var1.field2460 * 4 + 4;
				}

				if (var1.field2460 * 2 == var6.field2399.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2619(var1.field2464);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2712()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3896();
				if (var1.field2459 >= 0) {
					var1.remove();
					if (var1.field2449 > 0 && var1 == this.field2436[var1.field2447][var1.field2449]) {
						this.field2436[var1.field2447][var1.field2449] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2618(var1.field2464, this.method3789(var1), this.method3790(var1));
				return false;
			}
		} else {
			var1.method3896();
			var1.remove();
			if (var1.field2449 > 0 && var1 == this.field2436[var1.field2447][var1.field2449]) {
				this.field2436[var1.field2447][var1.field2449] = null;
			}

			return true;
		}
	}
}
