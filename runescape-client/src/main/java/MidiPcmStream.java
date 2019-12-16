import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gm")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1491011005
	)
	int field2401;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1592176192
	)
	int field2402;
	@ObfuscatedName("p")
	int[] field2405;
	@ObfuscatedName("b")
	int[] field2404;
	@ObfuscatedName("e")
	int[] field2408;
	@ObfuscatedName("x")
	int[] field2406;
	@ObfuscatedName("a")
	int[] field2407;
	@ObfuscatedName("d")
	int[] field2414;
	@ObfuscatedName("c")
	int[] field2410;
	@ObfuscatedName("o")
	int[] field2426;
	@ObfuscatedName("v")
	int[] field2411;
	@ObfuscatedName("u")
	int[] field2412;
	@ObfuscatedName("z")
	int[] field2413;
	@ObfuscatedName("h")
	int[] field2417;
	@ObfuscatedName("m")
	int[] field2415;
	@ObfuscatedName("g")
	int[] field2416;
	@ObfuscatedName("r")
	int[] field2425;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[[Lgl;"
	)
	MusicPatchNode[][] field2418;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "[[Lgl;"
	)
	MusicPatchNode[][] field2419;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("aw")
	boolean field2403;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1794419739
	)
	@Export("track")
	int track;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 198679967
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		longValue = 2302108536441075195L
	)
	long field2409;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		longValue = 307933058588373345L
	)
	long field2400;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2401 = 256;
		this.field2402 = -727379968;
		this.field2405 = new int[16];
		this.field2404 = new int[16];
		this.field2408 = new int[16];
		this.field2406 = new int[16];
		this.field2407 = new int[16];
		this.field2414 = new int[16];
		this.field2410 = new int[16];
		this.field2426 = new int[16];
		this.field2411 = new int[16];
		this.field2412 = new int[16];
		this.field2413 = new int[16];
		this.field2417 = new int[16];
		this.field2415 = new int[16];
		this.field2416 = new int[16];
		this.field2425 = new int[16];
		this.field2418 = new MusicPatchNode[16][128];
		this.field2419 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3713();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-114"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2401 = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-493640241"
	)
	public int method3692() {
		return this.field2401;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lgh;Lhz;Ldx;IB)Z",
		garbageValue = "-70"
	)
	@Export("loadMusicTrack")
	synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3909();
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

			if (!var9.method3868(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2127021512"
	)
	@Export("clearAll")
	synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1176927011"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("x")
	protected synchronized int vmethod3889() {
		return 0;
	}

	@ObfuscatedName("a")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2402 * 1000000 / (DirectByteArrayCopier.field2490 * -168449264);

			do {
				long var5 = this.field2409 + (long)var4 * (long)var3;
				if (this.field2400 - var5 >= 0L) {
					this.field2409 = var5;
					break;
				}

				int var7 = (int)((this.field2400 - this.field2409 + (long)var4 - 1L) / (long)var4);
				this.field2409 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3726();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lgh;ZI)V",
		garbageValue = "-1969795469"
	)
	@Export("setMusicTrack")
	synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2403 = var2;
		this.field2409 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2400 = this.midiFile.method3829(this.trackLength);
	}

	@ObfuscatedName("c")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2402 * 1000000 / (DirectByteArrayCopier.field2490 * -168449264);

			do {
				long var3 = (long)var2 * (long)var1 + this.field2409;
				if (this.field2400 - var3 >= 0L) {
					this.field2409 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2400 - this.field2409) - 1L) / (long)var2);
				this.field2409 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3726();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1463582858"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3713();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1439399631"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1663251439"
	)
	public synchronized void method3765(int var1, int var2) {
		this.method3784(var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "44"
	)
	void method3784(int var1, int var2) {
		this.field2406[var1] = var2;
		this.field2414[var1] = var2 & -128;
		this.method3703(var1, var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1182045133"
	)
	void method3703(int var1, int var2) {
		if (var2 != this.field2407[var1]) {
			this.field2407[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2419[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1071625485"
	)
	void method3704(int var1, int var2, int var3) {
		this.method3735(var1, var2, 64);
		if ((this.field2412[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2444 == var1 && var4.field2441 < 0) {
					this.field2418[var1][var4.field2432] = null;
					this.field2418[var1][var2] = var4;
					int var5 = (var4.field2434 * var4.field2437 >> 12) + var4.field2435;
					var4.field2435 += var2 - var4.field2432 << 8;
					var4.field2434 = var5 - var4.field2435;
					var4.field2437 = 4096;
					var4.field2432 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2407[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2444 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2430 = var9.field2462[var2];
				var6.field2436 = var9.field2468[var2];
				var6.field2432 = var2;
				var6.field2433 = var3 * var3 * var9.field2466[var2] * var9.field2467 + 1024 >> 11;
				var6.field2442 = var9.field2470[var2] & 255;
				var6.field2435 = (var2 << 8) - (var9.field2464[var2] & 32767);
				var6.field2446 = 0;
				var6.field2439 = 0;
				var6.field2440 = 0;
				var6.field2441 = -1;
				var6.field2438 = 0;
				if (this.field2415[var1] == 0) {
					var6.stream = RawPcmStream.method2582(var8, this.method3736(var6), this.method3719(var6), this.method3720(var6));
				} else {
					var6.stream = RawPcmStream.method2582(var8, this.method3736(var6), 0, this.method3720(var6));
					this.method3764(var6, var9.field2464[var2] < 0);
				}

				if (var9.field2464[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2436 >= 0) {
					MusicPatchNode var7 = this.field2419[var1][var6.field2436];
					if (var7 != null && var7.field2441 < 0) {
						this.field2418[var1][var7.field2432] = null;
						var7.field2441 = 0;
					}

					this.field2419[var1][var6.field2436] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2418[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lgl;ZI)V",
		garbageValue = "-1980997647"
	)
	void method3764(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1352) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field2415[var1.field2444] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2555();
			}
		} else {
			var4 = (int)((long)this.field2415[var1.field2444] * (long)var3 >> 6);
		}

		var1.stream.method2554(var4);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-717323373"
	)
	void method3735(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2418[var1][var2];
		if (var4 != null) {
			this.field2418[var1][var2] = null;
			if ((this.field2412[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2444 == var4.field2444 && var5.field2441 < 0 && var5 != var4) {
						var4.field2441 = 0;
						break;
					}
				}
			} else {
				var4.field2441 = 0;
			}

		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1882331860"
	)
	void method3707(int var1, int var2, int var3) {
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "14904"
	)
	void method3729(int var1, int var2) {
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1757965931"
	)
	void method3709(int var1, int var2) {
		this.field2410[var1] = var2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	void method3794(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2444 == var1) {
				if (var2.stream != null) {
					var2.stream.method2559(DirectByteArrayCopier.field2490 * -168449264 / 100);
					if (var2.stream.method2563()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3809();
				}

				if (var2.field2441 < 0) {
					this.field2418[var2.field2444][var2.field2432] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "80676363"
	)
	void method3711(int var1) {
		if (var1 >= 0) {
			this.field2405[var1] = 12800;
			this.field2404[var1] = 8192;
			this.field2408[var1] = 16383;
			this.field2410[var1] = 8192;
			this.field2426[var1] = 0;
			this.field2411[var1] = 8192;
			this.method3714(var1);
			this.method3806(var1);
			this.field2412[var1] = 0;
			this.field2413[var1] = 32767;
			this.field2417[var1] = 256;
			this.field2415[var1] = 0;
			this.method3717(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3711(var1);
			}

		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "89058460"
	)
	void method3712(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2444 == var1) && var2.field2441 < 0) {
				this.field2418[var2.field2444][var2.field2432] = null;
				var2.field2441 = 0;
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "140896410"
	)
	void method3713() {
		this.method3794(-1);
		this.method3711(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2407[var1] = this.field2406[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2414[var1] = this.field2406[var1] & -128;
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2012572160"
	)
	void method3714(int var1) {
		if ((this.field2412[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2444 == var1 && this.field2418[var1][var2.field2432] == null && var2.field2441 < 0) {
					var2.field2441 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-4452190"
	)
	void method3806(int var1) {
		if ((this.field2412[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2444 == var1) {
					var2.field2447 = 0;
				}
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1796286061"
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
			this.method3735(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3704(var3, var4, var5);
			} else {
				this.method3735(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3707(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2414[var3] = (var5 << 14) + (this.field2414[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2414[var3] = (var5 << 7) + (this.field2414[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2426[var3] = (var5 << 7) + (this.field2426[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2426[var3] = var5 + (this.field2426[var3] & -128);
			}

			if (var4 == 5) {
				this.field2411[var3] = (var5 << 7) + (this.field2411[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2411[var3] = var5 + (this.field2411[var3] & -128);
			}

			if (var4 == 7) {
				this.field2405[var3] = (var5 << 7) + (this.field2405[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2405[var3] = var5 + (this.field2405[var3] & -128);
			}

			if (var4 == 10) {
				this.field2404[var3] = (var5 << 7) + (this.field2404[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2404[var3] = var5 + (this.field2404[var3] & -128);
			}

			if (var4 == 11) {
				this.field2408[var3] = (var5 << 7) + (this.field2408[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2408[var3] = var5 + (this.field2408[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2412;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2412;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2412;
					var10000[var3] |= 2;
				} else {
					this.method3714(var3);
					var10000 = this.field2412;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2413[var3] = (var5 << 7) + (this.field2413[var3] & 127);
			}

			if (var4 == 98) {
				this.field2413[var3] = (this.field2413[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2413[var3] = (var5 << 7) + (this.field2413[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2413[var3] = (this.field2413[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3794(var3);
			}

			if (var4 == 121) {
				this.method3711(var3);
			}

			if (var4 == 123) {
				this.method3712(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2413[var3];
				if (var6 == 16384) {
					this.field2417[var3] = (var5 << 7) + (this.field2417[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2413[var3];
				if (var6 == 16384) {
					this.field2417[var3] = var5 + (this.field2417[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2415[var3] = (var5 << 7) + (this.field2415[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2415[var3] = var5 + (this.field2415[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2412;
					var10000[var3] |= 4;
				} else {
					this.method3806(var3);
					var10000 = this.field2412;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3717(var3, (var5 << 7) + (this.field2416[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3717(var3, var5 + (this.field2416[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3703(var3, var4 + this.field2414[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3729(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3709(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3713();
			}
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1984762268"
	)
	void method3717(int var1, int var2) {
		this.field2416[var1] = var2;
		this.field2425[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Lgl;S)I",
		garbageValue = "-5445"
	)
	int method3736(MusicPatchNode var1) {
		int var2 = (var1.field2437 * var1.field2434 >> 12) + var1.field2435;
		var2 += (this.field2410[var1.field2444] - 8192) * this.field2417[var1.field2444] >> 12;
		MusicPatchNode2 var3 = var1.field2430;
		int var4;
		if (var3.field2383 > 0 && (var3.field2382 > 0 || this.field2426[var1.field2444] > 0)) {
			var4 = var3.field2382 << 2;
			int var5 = var3.field2380 << 1;
			if (var1.field2443 < var5) {
				var4 = var4 * var1.field2443 / var5;
			}

			var4 += this.field2426[var1.field2444] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2427 & 511));
			var2 += (int)(var6 * (double)var4);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)(DirectByteArrayCopier.field2490 * -168449264) + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Lgl;I)I",
		garbageValue = "623001818"
	)
	int method3719(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2430;
		int var3 = this.field2405[var1.field2444] * this.field2408[var1.field2444] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2433 + 16384 >> 15;
		var3 = var3 * this.field2401 + 128 >> 8;
		if (var2.field2378 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2378 * 1.953125E-5D * (double)(var1.field2446 * 128)) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2385 != null) {
			var4 = var1.field2439;
			var5 = var2.field2385[var1.field2440 * 4 + 1];
			if (var1.field2440 * 4 < var2.field2385.length - 2) {
				var6 = (var2.field2385[var1.field2440 * 4] & 255) << 8;
				var7 = (var2.field2385[var1.field2440 * 4 + 2] & 255) << 8;
				var5 += (var2.field2385[var1.field2440 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2441 > 0 && var2.field2377 != null) {
			var4 = var1.field2441;
			var5 = var2.field2377[var1.field2438 * 4 + 1];
			if (var1.field2438 * 4 < var2.field2377.length - 2) {
				var6 = (var2.field2377[var1.field2438 * 4] & 255) << 8;
				var7 = (var2.field2377[var1.field2438 * 4 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2377[var1.field2438 * 4 + 3] - var5) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Lgl;I)I",
		garbageValue = "1450694998"
	)
	int method3720(MusicPatchNode var1) {
		int var2 = this.field2404[var1.field2444];
		return var2 < 8192 ? var2 * var1.field2442 + 32 >> 6 : 16384 - ((128 - var1.field2442) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-796746518"
	)
	void method3726() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2400; var2 == this.trackLength; var3 = this.midiFile.method3829(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2403 || var2 == 0) {
							this.method3713();
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
		this.field2400 = var3;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(Lgl;B)Z",
		garbageValue = "26"
	)
	boolean method3767(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2441 >= 0) {
				var1.remove();
				if (var1.field2436 > 0 && var1 == this.field2419[var1.field2444][var1.field2436]) {
					this.field2419[var1.field2444][var1.field2436] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(Lgl;[IIII)Z",
		garbageValue = "1744795521"
	)
	boolean method3728(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2431 = DirectByteArrayCopier.field2490 * -168449264 / 100;
		if (var1.field2441 < 0 || var1.stream != null && !var1.stream.method2653()) {
			int var5 = var1.field2437;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2411[var1.field2444] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2437 = var5;
			}

			var1.stream.method2615(this.method3736(var1));
			MusicPatchNode2 var6 = var1.field2430;
			boolean var7 = false;
			++var1.field2443;
			var1.field2427 += var6.field2383;
			double var8 = 5.086263020833333E-6D * (double)((var1.field2432 - 60 << 8) + (var1.field2434 * var1.field2437 >> 12));
			if (var6.field2378 > 0) {
				if (var6.field2384 > 0) {
					var1.field2446 = var1.field2446 * 29114368 + (int)(128.0D * Math.pow(2.0D, (double)var6.field2384 * var8) + 0.5D) * 1845721216;
				} else {
					var1.field2446 = var1.field2446 * 29114368 + 29114368;
				}
			}

			if (var6.field2385 != null) {
				if (var6.field2387 > 0) {
					var1.field2439 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2387 * var8) + 0.5D);
				} else {
					var1.field2439 += 128;
				}

				while (var1.field2440 * 4 < var6.field2385.length - 2 && var1.field2439 > (var6.field2385[var1.field2440 * 4 + 2] & 255) << 8) {
					var1.field2440 = var1.field2440 * 4 + 2;
				}

				if (var1.field2440 * 4 == var6.field2385.length - 2 && var6.field2385[var1.field2440 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2441 >= 0 && var6.field2377 != null && (this.field2412[var1.field2444] & 1) == 0 && (var1.field2436 < 0 || var1 != this.field2419[var1.field2444][var1.field2436])) {
				if (var6.field2376 > 0) {
					var1.field2441 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2376) + 0.5D);
				} else {
					var1.field2441 += 128;
				}

				while (var1.field2438 * 4 < var6.field2377.length - 2 && var1.field2441 > (var6.field2377[var1.field2438 * 4 + 2] & 255) << 8) {
					var1.field2438 = var1.field2438 * 4 + 2;
				}

				if (var1.field2438 * 4 == var6.field2377.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2559(var1.field2431);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2563()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3809();
				if (var1.field2441 >= 0) {
					var1.remove();
					if (var1.field2436 > 0 && var1 == this.field2419[var1.field2444][var1.field2436]) {
						this.field2419[var1.field2444][var1.field2436] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2668(var1.field2431, this.method3719(var1), this.method3720(var1));
				return false;
			}
		} else {
			var1.method3809();
			var1.remove();
			if (var1.field2436 > 0 && var1 == this.field2419[var1.field2444][var1.field2436]) {
				this.field2419[var1.field2444][var1.field2436] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "-120"
	)
	static int method3737(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			var3 = Tile.getWidget(var4);
		} else {
			var3 = var2 ? UserComparator7.field1946 : class197.field2398;
		}

		if (var0 == ScriptOpcodes.CC_SETSCROLLPOS) {
			class188.Interpreter_intStackSize -= 2;
			var3.scrollX = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			if (var3.scrollX > var3.scrollWidth - var3.width) {
				var3.scrollX = var3.scrollWidth - var3.width;
			}

			if (var3.scrollX < 0) {
				var3.scrollX = 0;
			}

			var3.scrollY = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			if (var3.scrollY > var3.scrollHeight - var3.height) {
				var3.scrollY = var3.scrollHeight - var3.height;
			}

			if (var3.scrollY < 0) {
				var3.scrollY = 0;
			}

			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var3.color = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var3.fill = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var3.lineWid = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			class188.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 5];
			LoginPacket.invalidateWidget(var3);
			return 1;
		} else {
			int var8;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var8 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					LoginPacket.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var7 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					LoginPacket.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var3.fontId = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				class188.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var3.outline = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				class188.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				LoginPacket.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					Messages.revalidateWidgetScroll(UserComparator7.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				WorldMapRectangle.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var3.color2 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				LoginPacket.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var8 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				FillMode var6 = (FillMode)DynamicObject.findEnumerated(ModelData0.FillMode_values(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					LoginPacket.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var5 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
					var3.field2676 = var5;
					return 1;
				} else if (var0 == ScriptOpcodes.CC_SETMODELTRANSPARENT) {
					var5 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lko;Lko;Lko;I)V",
		garbageValue = "702202184"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (GrandExchangeOfferTotalQuantityComparator.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		Script.loginBoxCenter = Login.loginBoxX + 180;
		if (Login.worldSelectOpen) {
			class42.method781(var0, var1);
		} else {
			UrlRequest.leftTitleSprite.drawAt(Login.xPadding, 0);
			ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
			int var4;
			if (Client.gameState == 0 || Client.gameState == 5) {
				byte var3 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var3, 16777215, -1);
				var4 = 253 - var3;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var4, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var4 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var4 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var4 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var3, 16777215, -1);
			}

			String var6;
			String var7;
			String var8;
			short var27;
			int var28;
			short var29;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var27 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var27, 16776960, 0);
				var28 = var27 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var28, 16776960, 0);
				var28 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var28, 16776960, 0);
				var28 += 15;
				var28 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var28, 16777215, 0);
					var29 = 200;
					if (Interpreter.clientPreferences.hideUsername) {
						var8 = Login.Login_username;
						var7 = UserComparator6.method3370('*', var8.length());
						var6 = var7;
					} else {
						var6 = Login.Login_username;
					}

					for (var6 = var6; var0.stringWidth(var6) > var29; var6 = var6.substring(0, var6.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var6), Login.loginBoxX + 180 - 70, var28, 16777215, 0);
					var28 += 15;
					var8 = Login.Login_password;
					var7 = UserComparator6.method3370('*', var8.length());

					String var9;
					for (var9 = var7; var0.stringWidth(var9) > var29; var9 = var9.substring(1)) {
					}

					var0.draw("Password: " + var9, Login.loginBoxX + 180 - 108, var28, 16777215, 0);
					var28 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var18;
				if (Login.loginIndex == 0) {
					var27 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var27, 16776960, 0);
					var28 = var27 + 30;
					var4 = Login.loginBoxX + 180 - 80;
					var18 = 291;
					Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
					var0.drawLines("New User", var4 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var4 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
					var0.drawLines("Existing User", var4 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var27 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var27, 16777215, 0);
					var28 = var27 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var28, 16777215, 0);
					var28 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var28, 16777215, 0);
					var28 += 15;
					var4 = Login.loginBoxX + 180 - 80;
					var18 = 321;
					Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
					var0.drawCentered("Continue", var4, var18 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
					var0.drawCentered("Cancel", var4, var18 + 5, 16777215, 0);
				} else {
					String var5;
					int var21;
					if (Login.loginIndex == 2) {
						var27 = 201;
						var0.drawCentered(Login.Login_response1, Script.loginBoxCenter, var27, 16776960, 0);
						var28 = var27 + 15;
						var0.drawCentered(Login.Login_response2, Script.loginBoxCenter, var28, 16776960, 0);
						var28 += 15;
						var0.drawCentered(Login.Login_response3, Script.loginBoxCenter, var28, 16776960, 0);
						var28 += 15;
						var28 += 7;
						var0.draw("Login: ", Script.loginBoxCenter - 110, var28, 16777215, 0);
						var29 = 200;
						var5 = Interpreter.clientPreferences.hideUsername ? StructDefinition.method4551(Login.Login_username) : Login.Login_username;

						for (var6 = var5; var0.stringWidth(var6) > var29; var6 = var6.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var6) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? NPC.colorStartTag(16776960) + "|" : ""), Script.loginBoxCenter - 70, var28, 16777215, 0);
						var28 += 15;

						for (var7 = StructDefinition.method4551(Login.Login_password); var0.stringWidth(var7) > var29; var7 = var7.substring(1)) {
						}

						var0.draw("Password: " + var7 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? NPC.colorStartTag(16776960) + "|" : ""), Script.loginBoxCenter - 108, var28, 16777215, 0);
						var28 += 15;
						var27 = 277;
						var21 = Script.loginBoxCenter + -117;
						boolean var10 = Client.Login_isUsernameRemembered;
						boolean var11 = Login.field1186;
						IndexedSprite var30 = var10 ? (var11 ? Login.field1162 : Login.options_buttons_2Sprite) : (var11 ? GrandExchangeOffer.field64 : class218.options_buttons_0Sprite);
						var30.drawAt(var21, var27);
						var21 = var21 + var30.subWidth + 5;
						var1.draw("Remember username", var21, var27 + 13, 16776960, 0);
						var21 = Script.loginBoxCenter + 24;
						boolean var14 = Interpreter.clientPreferences.hideUsername;
						boolean var15 = Login.field1182;
						IndexedSprite var13 = var14 ? (var15 ? Login.field1162 : Login.options_buttons_2Sprite) : (var15 ? GrandExchangeOffer.field64 : class218.options_buttons_0Sprite);
						var13.drawAt(var21, var27);
						var21 = var21 + var13.subWidth + 5;
						var1.draw("Hide username", var21, var27 + 13, 16776960, 0);
						var28 = var27 + 15;
						int var16 = Script.loginBoxCenter - 80;
						short var17 = 321;
						Login.titlebuttonSprite.drawAt(var16 - 73, var17 - 20);
						var0.drawCentered("Login", var16, var17 + 5, 16777215, 0);
						var16 = Script.loginBoxCenter + 80;
						Login.titlebuttonSprite.drawAt(var16 - 73, var17 - 20);
						var0.drawCentered("Cancel", var16, var17 + 5, 16777215, 0);
						var27 = 357;
						switch(Login.field1181) {
						case 2:
							DevicePcmPlayerProvider.field391 = "Having trouble logging in?";
							break;
						default:
							DevicePcmPlayerProvider.field391 = "Can't login? Click here.";
						}

						class267.field3521 = new Bounds(Script.loginBoxCenter, var27, var1.stringWidth(DevicePcmPlayerProvider.field391), 11);
						class197.field2397 = new Bounds(Script.loginBoxCenter, var27, var1.stringWidth("Still having trouble logging in?"), 11);
						var1.drawCentered(DevicePcmPlayerProvider.field391, Script.loginBoxCenter, var27, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var27 = 201;
						var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var27, 16776960, 0);
						var28 = var27 + 20;
						var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var28, 16776960, 0);
						var28 += 15;
						var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var28, 16776960, 0);
						var28 += 15;
						var4 = Login.loginBoxX + 180;
						var18 = 276;
						Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
						var2.drawCentered("Try again", var4, var18 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180;
						var18 = 326;
						Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
						var2.drawCentered("Forgotten password?", var4, var18 + 5, 16777215, 0);
					} else if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var27 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var27, 16777215, 0);
						var28 = var27 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var28, 16777215, 0);
						var28 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var28, 16777215, 0);
						var28 += 15;
						var5 = "PIN: ";
						var7 = class80.otp;
						var6 = UserComparator6.method3370('*', var7.length());
						var0.draw(var5 + var6 + (Client.cycle % 40 < 20 ? NPC.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var28, 16777215, 0);
						var28 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var28, 16776960, 0);
						var28 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var28, 16776960, 0);
						var21 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
						int var23 = var28 - var0.ascent;
						IndexedSprite var24;
						if (Login.field1178) {
							var24 = Login.options_buttons_2Sprite;
						} else {
							var24 = class218.options_buttons_0Sprite;
						}

						var24.drawAt(var21, var23);
						var28 += 15;
						int var31 = Login.loginBoxX + 180 - 80;
						short var25 = 321;
						Login.titlebuttonSprite.drawAt(var31 - 73, var25 - 20);
						var0.drawCentered("Continue", var31, var25 + 5, 16777215, 0);
						var31 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var31 - 73, var25 - 20);
						var0.drawCentered("Cancel", var31, var25 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var25 + 36, 255, 0);
					} else {
						int var26;
						short var33;
						if (Login.loginIndex == 5) {
							var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
							var27 = 221;
							var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var27, 16776960, 0);
							var28 = var27 + 15;
							var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var28 += 14;
							var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var28, 16777215, 0);
							var29 = 174;
							if (Interpreter.clientPreferences.hideUsername) {
								var8 = Login.Login_username;
								var7 = UserComparator6.method3370('*', var8.length());
								var6 = var7;
							} else {
								var6 = Login.Login_username;
							}

							for (var6 = var6; var0.stringWidth(var6) > var29; var6 = var6.substring(1)) {
							}

							var0.draw(AbstractFont.escapeBrackets(var6) + (Client.cycle % 40 < 20 ? NPC.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var28, 16777215, 0);
							var28 += 15;
							var26 = Login.loginBoxX + 180 - 80;
							var33 = 321;
							Login.titlebuttonSprite.drawAt(var26 - 73, var33 - 20);
							var0.drawCentered("Recover", var26, var33 + 5, 16777215, 0);
							var26 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var26 - 73, var33 - 20);
							var0.drawCentered("Back", var26, var33 + 5, 16777215, 0);
							var33 = 356;
							var1.drawCentered("Still having trouble logging in?", Script.loginBoxCenter, var33, 268435455, 0);
						} else if (Login.loginIndex == 6) {
							var27 = 201;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var27, 16776960, 0);
							var28 = var27 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var4 = Login.loginBoxX + 180;
							var18 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
							var0.drawCentered("Back", var4, var18 + 5, 16777215, 0);
						} else if (Login.loginIndex == 7) {
							var27 = 216;
							var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var27, 16776960, 0);
							var28 = var27 + 15;
							var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var18 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
							var0.drawCentered("Set Date of Birth", var4, var18 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
							var0.drawCentered("Back", var4, var18 + 5, 16777215, 0);
						} else if (Login.loginIndex == 8) {
							var27 = 216;
							var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var27, 16776960, 0);
							var28 = var27 + 15;
							var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var18 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
							var0.drawCentered("Privacy Policy", var4, var18 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
							var0.drawCentered("Back", var4, var18 + 5, 16777215, 0);
						} else if (Login.loginIndex == 12) {
							var27 = 201;
							String var22 = "";
							var5 = "";
							var6 = "";
							switch(Login.field1167) {
							case 0:
								var22 = "Your account has been disabled.";
								var5 = Strings.field2798;
								var6 = "";
								break;
							case 1:
								var22 = "Account locked as we suspect it has been stolen.";
								var5 = Strings.field2837;
								var6 = "";
								break;
							default:
								ItemDefinition.Login_promptCredentials(false);
							}

							var0.drawCentered(var22, Login.loginBoxX + 180, var27, 16776960, 0);
							var28 = var27 + 15;
							var2.drawCentered(var5, Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var2.drawCentered(var6, Login.loginBoxX + 180, var28, 16776960, 0);
							var28 += 15;
							var26 = Login.loginBoxX + 180;
							var33 = 276;
							Login.titlebuttonSprite.drawAt(var26 - 73, var33 - 20);
							var0.drawCentered("Support Page", var26, var33 + 5, 16777215, 0);
							var26 = Login.loginBoxX + 180;
							var33 = 326;
							Login.titlebuttonSprite.drawAt(var26 - 73, var33 - 20);
							var0.drawCentered("Back", var26, var33 + 5, 16777215, 0);
						} else if (Login.loginIndex == 24) {
							var27 = 221;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var27, 16777215, 0);
							var28 = var27 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var28, 16777215, 0);
							var28 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var28, 16777215, 0);
							var28 += 15;
							var4 = Login.loginBoxX + 180;
							var18 = 301;
							Login.titlebuttonSprite.drawAt(var4 - 73, var18 - 20);
							var0.drawCentered("Ok", var4, var18 + 5, 16777215, 0);
						}
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var19 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var19);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, AttackOption.canvasHeight);
				StructDefinition.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				StructDefinition.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var19);
			}

			class30.title_muteSprite[Interpreter.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Varps.clientLanguage == Language.Language_EN) {
				if (class54.field483 != null) {
					var28 = Login.xPadding + 5;
					var29 = 463;
					byte var32 = 100;
					byte var20 = 35;
					class54.field483.drawAt(var28, var29);
					var0.drawCentered("World" + " " + Client.worldId, var32 / 2 + var28, var20 / 2 + var29 - 2, 16777215, 0);
					if (Login.World_request != null) {
						var1.drawCentered("Loading...", var32 / 2 + var28, var20 / 2 + var29 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var32 / 2 + var28, var20 / 2 + var29 + 12, 16777215, 0);
					}
				} else {
					class54.field483 = Canvas.SpriteBuffer_getIndexedSpriteByName(class3.archive8, "sl_button", "");
				}
			}

		}
	}
}
