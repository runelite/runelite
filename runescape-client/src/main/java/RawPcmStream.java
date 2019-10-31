import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("a")
	int field1448;
	@ObfuscatedName("t")
	int field1441;
	@ObfuscatedName("n")
	int field1440;
	@ObfuscatedName("q")
	int field1442;
	@ObfuscatedName("v")
	int field1444;
	@ObfuscatedName("l")
	int field1445;
	@ObfuscatedName("c")
	int field1446;
	@ObfuscatedName("o")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("i")
	@Export("start")
	int start;
	@ObfuscatedName("d")
	@Export("end")
	int end;
	@ObfuscatedName("m")
	boolean field1450;
	@ObfuscatedName("p")
	int field1451;
	@ObfuscatedName("h")
	int field1452;
	@ObfuscatedName("k")
	int field1454;
	@ObfuscatedName("x")
	int field1453;

	@ObfuscatedSignature(
		signature = "(Lca;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1450 = var1.field1363;
		this.field1441 = var2;
		this.field1440 = var3;
		this.field1442 = var4;
		this.field1448 = 0;
		this.method2700();
	}

	@ObfuscatedSignature(
		signature = "(Lca;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1450 = var1.field1363;
		this.field1441 = var2;
		this.field1440 = var3;
		this.field1442 = 8192;
		this.field1448 = 0;
		this.method2700();
	}

	@ObfuscatedName("v")
	void method2700() {
		this.field1444 = this.field1440;
		this.field1445 = method2745(this.field1440, this.field1442);
		this.field1446 = method2802(this.field1440, this.field1442);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("o")
	protected int vmethod4063() {
		return this.field1440 == 0 && this.field1451 == 0 ? 0 : 1;
	}

	@ObfuscatedName("i")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1440 == 0 && this.field1451 == 0) {
			this.skip(var3);
		} else {
			RawSound var4 = (RawSound)super.sound;
			int var5 = this.start << 8;
			int var6 = this.end << 8;
			int var7 = var4.samples.length << 8;
			int var8 = var6 - var5;
			if (var8 <= 0) {
				this.numLoops = 0;
			}

			int var9 = var2;
			var3 += var2;
			if (this.field1448 < 0) {
				if (this.field1441 <= 0) {
					this.method2695();
					this.remove();
					return;
				}

				this.field1448 = 0;
			}

			if (this.field1448 >= var7) {
				if (this.field1441 >= 0) {
					this.method2695();
					this.remove();
					return;
				}

				this.field1448 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1450) {
					if (this.field1441 < 0) {
						var9 = this.method2807(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1448 >= var5) {
							return;
						}

						this.field1448 = var5 + var5 - 1 - this.field1448;
						this.field1441 = -this.field1441;
					}

					while (true) {
						var9 = this.method2851(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1448 < var6) {
							return;
						}

						this.field1448 = var6 + var6 - 1 - this.field1448;
						this.field1441 = -this.field1441;
						var9 = this.method2807(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1448 >= var5) {
							return;
						}

						this.field1448 = var5 + var5 - 1 - this.field1448;
						this.field1441 = -this.field1441;
					}
				} else if (this.field1441 < 0) {
					while (true) {
						var9 = this.method2807(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1448 >= var5) {
							return;
						}

						this.field1448 = var6 - 1 - (var6 - 1 - this.field1448) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2851(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1448 < var6) {
							return;
						}

						this.field1448 = var5 + (this.field1448 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1450) {
						label141: {
							if (this.field1441 < 0) {
								var9 = this.method2807(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1448 >= var5) {
									return;
								}

								this.field1448 = var5 + var5 - 1 - this.field1448;
								this.field1441 = -this.field1441;
								if (--this.numLoops == 0) {
									break label141;
								}
							}

							do {
								var9 = this.method2851(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1448 < var6) {
									return;
								}

								this.field1448 = var6 + var6 - 1 - this.field1448;
								this.field1441 = -this.field1441;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2807(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1448 >= var5) {
									return;
								}

								this.field1448 = var5 + var5 - 1 - this.field1448;
								this.field1441 = -this.field1441;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1441 < 0) {
							while (true) {
								var9 = this.method2807(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1448 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1448) / var8;
								if (var10 >= this.numLoops) {
									this.field1448 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1448 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2851(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1448 < var6) {
									return;
								}

								var10 = (this.field1448 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1448 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1448 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1441 < 0) {
					this.method2807(var1, var9, 0, var3, 0);
					if (this.field1448 < 0) {
						this.field1448 = -1;
						this.method2695();
						this.remove();
					}
				} else {
					this.method2851(var1, var9, var7, var3, 0);
					if (this.field1448 >= var7) {
						this.field1448 = var7;
						this.method2695();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("d")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("m")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1451 > 0) {
			if (var1 >= this.field1451) {
				if (this.field1440 == Integer.MIN_VALUE) {
					this.field1440 = 0;
					this.field1446 = 0;
					this.field1445 = 0;
					this.field1444 = 0;
					this.remove();
					var1 = this.field1451;
				}

				this.field1451 = 0;
				this.method2700();
			} else {
				this.field1444 += this.field1452 * var1;
				this.field1445 += this.field1454 * var1;
				this.field1446 += this.field1453 * var1;
				this.field1451 -= var1;
			}
		}

		RawSound var2 = (RawSound)super.sound;
		int var3 = this.start << 8;
		int var4 = this.end << 8;
		int var5 = var2.samples.length << 8;
		int var6 = var4 - var3;
		if (var6 <= 0) {
			this.numLoops = 0;
		}

		if (this.field1448 < 0) {
			if (this.field1441 <= 0) {
				this.method2695();
				this.remove();
				return;
			}

			this.field1448 = 0;
		}

		if (this.field1448 >= var5) {
			if (this.field1441 >= 0) {
				this.method2695();
				this.remove();
				return;
			}

			this.field1448 = var5 - 1;
		}

		this.field1448 += this.field1441 * var1;
		if (this.numLoops < 0) {
			if (!this.field1450) {
				if (this.field1441 < 0) {
					if (this.field1448 >= var3) {
						return;
					}

					this.field1448 = var4 - 1 - (var4 - 1 - this.field1448) % var6;
				} else {
					if (this.field1448 < var4) {
						return;
					}

					this.field1448 = var3 + (this.field1448 - var3) % var6;
				}

			} else {
				if (this.field1441 < 0) {
					if (this.field1448 >= var3) {
						return;
					}

					this.field1448 = var3 + var3 - 1 - this.field1448;
					this.field1441 = -this.field1441;
				}

				while (this.field1448 >= var4) {
					this.field1448 = var4 + var4 - 1 - this.field1448;
					this.field1441 = -this.field1441;
					if (this.field1448 >= var3) {
						return;
					}

					this.field1448 = var3 + var3 - 1 - this.field1448;
					this.field1441 = -this.field1441;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1450) {
					label136: {
						if (this.field1441 < 0) {
							if (this.field1448 >= var3) {
								return;
							}

							this.field1448 = var3 + var3 - 1 - this.field1448;
							this.field1441 = -this.field1441;
							if (--this.numLoops == 0) {
								break label136;
							}
						}

						do {
							if (this.field1448 < var4) {
								return;
							}

							this.field1448 = var4 + var4 - 1 - this.field1448;
							this.field1441 = -this.field1441;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1448 >= var3) {
								return;
							}

							this.field1448 = var3 + var3 - 1 - this.field1448;
							this.field1441 = -this.field1441;
						} while(--this.numLoops != 0);
					}
				} else {
					label168: {
						int var7;
						if (this.field1441 < 0) {
							if (this.field1448 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field1448) / var6;
							if (var7 >= this.numLoops) {
								this.field1448 += var6 * this.numLoops;
								this.numLoops = 0;
								break label168;
							}

							this.field1448 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field1448 < var4) {
								return;
							}

							var7 = (this.field1448 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field1448 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label168;
							}

							this.field1448 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field1441 < 0) {
				if (this.field1448 < 0) {
					this.field1448 = -1;
					this.method2695();
					this.remove();
				}
			} else if (this.field1448 >= var5) {
				this.field1448 = var5;
				this.method2695();
				this.remove();
			}

		}
	}

	@ObfuscatedName("p")
	public synchronized void method2702(int var1) {
		this.method2704(var1 << 6, this.method2844());
	}

	@ObfuscatedName("h")
	synchronized void method2841(int var1) {
		this.method2704(var1, this.method2844());
	}

	@ObfuscatedName("k")
	synchronized void method2704(int var1, int var2) {
		this.field1440 = var1;
		this.field1442 = var2;
		this.field1451 = 0;
		this.method2700();
	}

	@ObfuscatedName("x")
	public synchronized int method2705() {
		return this.field1440 == Integer.MIN_VALUE ? 0 : this.field1440;
	}

	@ObfuscatedName("j")
	public synchronized int method2844() {
		return this.field1442 < 0 ? -1 : this.field1442;
	}

	@ObfuscatedName("r")
	public synchronized void method2707(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1448 = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2708() {
		this.field1441 = (this.field1441 ^ this.field1441 >> 31) + (this.field1441 >>> 31);
		this.field1441 = -this.field1441;
	}

	@ObfuscatedName("s")
	void method2695() {
		if (this.field1451 != 0) {
			if (this.field1440 == Integer.MIN_VALUE) {
				this.field1440 = 0;
			}

			this.field1451 = 0;
			this.method2700();
		}

	}

	@ObfuscatedName("b")
	public synchronized void method2706(int var1, int var2) {
		this.method2711(var1, var2, this.method2844());
	}

	@ObfuscatedName("w")
	public synchronized void method2711(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2704(var2, var3);
		} else {
			int var4 = method2745(var2, var3);
			int var5 = method2802(var2, var3);
			if (var4 == this.field1445 && var5 == this.field1446) {
				this.field1451 = 0;
			} else {
				int var6 = var2 - this.field1444;
				if (this.field1444 - var2 > var6) {
					var6 = this.field1444 - var2;
				}

				if (var4 - this.field1445 > var6) {
					var6 = var4 - this.field1445;
				}

				if (this.field1445 - var4 > var6) {
					var6 = this.field1445 - var4;
				}

				if (var5 - this.field1446 > var6) {
					var6 = var5 - this.field1446;
				}

				if (this.field1446 - var5 > var6) {
					var6 = this.field1446 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1451 = var1;
				this.field1440 = var2;
				this.field1442 = var3;
				this.field1452 = (var2 - this.field1444) / var1;
				this.field1454 = (var4 - this.field1445) / var1;
				this.field1453 = (var5 - this.field1446) / var1;
			}
		}
	}

	@ObfuscatedName("u")
	public synchronized void method2722(int var1) {
		if (var1 == 0) {
			this.method2841(0);
			this.remove();
		} else if (this.field1445 == 0 && this.field1446 == 0) {
			this.field1451 = 0;
			this.field1440 = 0;
			this.field1444 = 0;
			this.remove();
		} else {
			int var2 = -this.field1444;
			if (this.field1444 > var2) {
				var2 = this.field1444;
			}

			if (-this.field1445 > var2) {
				var2 = -this.field1445;
			}

			if (this.field1445 > var2) {
				var2 = this.field1445;
			}

			if (-this.field1446 > var2) {
				var2 = -this.field1446;
			}

			if (this.field1446 > var2) {
				var2 = this.field1446;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1451 = var1;
			this.field1440 = Integer.MIN_VALUE;
			this.field1452 = -this.field1444 / var1;
			this.field1454 = -this.field1445 / var1;
			this.field1453 = -this.field1446 / var1;
		}
	}

	@ObfuscatedName("ad")
	public synchronized void method2743(int var1) {
		if (this.field1441 < 0) {
			this.field1441 = -var1;
		} else {
			this.field1441 = var1;
		}

	}

	@ObfuscatedName("ah")
	public synchronized int method2714() {
		return this.field1441 < 0 ? -this.field1441 : this.field1441;
	}

	@ObfuscatedName("an")
	public boolean method2789() {
		return this.field1448 < 0 || this.field1448 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("af")
	public boolean method2716() {
		return this.field1451 != 0;
	}

	@ObfuscatedName("ai")
	int method2851(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1451 > 0) {
				int var6 = var2 + this.field1451;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1451 += var2;
				if (this.field1441 == 256 && (this.field1448 & 255) == 0) {
					if (InterfaceParent.PcmPlayer_stereo) {
						var2 = method2715(0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, this.field1454, this.field1453, 0, var6, var3, this);
					} else {
						var2 = method2733(((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, this.field1452, 0, var6, var3, this);
					}
				} else if (InterfaceParent.PcmPlayer_stereo) {
					var2 = method2738(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, this.field1454, this.field1453, 0, var6, var3, this, this.field1441, var5);
				} else {
					var2 = method2761(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, this.field1452, 0, var6, var3, this, this.field1441, var5);
				}

				this.field1451 -= var2;
				if (this.field1451 != 0) {
					return var2;
				}

				if (!this.method2726()) {
					continue;
				}

				return var4;
			}

			if (this.field1441 == 256 && (this.field1448 & 255) == 0) {
				if (InterfaceParent.PcmPlayer_stereo) {
					return method2739(0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, 0, var4, var3, this);
				}

				return method2806(((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, 0, var4, var3, this);
			}

			if (InterfaceParent.PcmPlayer_stereo) {
				return method2730(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, 0, var4, var3, this, this.field1441, var5);
			}

			return method2729(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, 0, var4, var3, this, this.field1441, var5);
		}
	}

	@ObfuscatedName("ac")
	int method2807(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1451 > 0) {
				int var6 = var2 + this.field1451;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1451 += var2;
				if (this.field1441 == -256 && (this.field1448 & 255) == 0) {
					if (InterfaceParent.PcmPlayer_stereo) {
						var2 = method2753(0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, this.field1454, this.field1453, 0, var6, var3, this);
					} else {
						var2 = method2842(((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, this.field1452, 0, var6, var3, this);
					}
				} else if (InterfaceParent.PcmPlayer_stereo) {
					var2 = method2826(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, this.field1454, this.field1453, 0, var6, var3, this, this.field1441, var5);
				} else {
					var2 = method2701(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, this.field1452, 0, var6, var3, this, this.field1441, var5);
				}

				this.field1451 -= var2;
				if (this.field1451 != 0) {
					return var2;
				}

				if (!this.method2726()) {
					continue;
				}

				return var4;
			}

			if (this.field1441 == -256 && (this.field1448 & 255) == 0) {
				if (InterfaceParent.PcmPlayer_stereo) {
					return method2728(0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, 0, var4, var3, this);
				}

				return method2727(((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, 0, var4, var3, this);
			}

			if (InterfaceParent.PcmPlayer_stereo) {
				return method2795(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1445, this.field1446, 0, var4, var3, this, this.field1441, var5);
			}

			return method2731(0, 0, ((RawSound)super.sound).samples, var1, this.field1448, var2, this.field1444, 0, var4, var3, this, this.field1441, var5);
		}
	}

	@ObfuscatedName("at")
	boolean method2726() {
		int var1 = this.field1440;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2745(var1, this.field1442);
			var3 = method2802(var1, this.field1442);
		}

		if (var1 == this.field1444 && var2 == this.field1445 && var3 == this.field1446) {
			if (this.field1440 == Integer.MIN_VALUE) {
				this.field1440 = 0;
				this.field1446 = 0;
				this.field1445 = 0;
				this.field1444 = 0;
				this.remove();
				return true;
			} else {
				this.method2700();
				return false;
			}
		} else {
			if (this.field1444 < var1) {
				this.field1452 = 1;
				this.field1451 = var1 - this.field1444;
			} else if (this.field1444 > var1) {
				this.field1452 = -1;
				this.field1451 = this.field1444 - var1;
			} else {
				this.field1452 = 0;
			}

			if (this.field1445 < var2) {
				this.field1454 = 1;
				if (this.field1451 == 0 || this.field1451 > var2 - this.field1445) {
					this.field1451 = var2 - this.field1445;
				}
			} else if (this.field1445 > var2) {
				this.field1454 = -1;
				if (this.field1451 == 0 || this.field1451 > this.field1445 - var2) {
					this.field1451 = this.field1445 - var2;
				}
			} else {
				this.field1454 = 0;
			}

			if (this.field1446 < var3) {
				this.field1453 = 1;
				if (this.field1451 == 0 || this.field1451 > var3 - this.field1446) {
					this.field1451 = var3 - this.field1446;
				}
			} else if (this.field1446 > var3) {
				this.field1453 = -1;
				if (this.field1451 == 0 || this.field1451 > this.field1446 - var3) {
					this.field1451 = this.field1446 - var3;
				}
			} else {
				this.field1453 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("as")
	int vmethod2868() {
		int var1 = this.field1444 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1448 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("a")
	static int method2745(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("t")
	static int method2802(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lca;II)Lds;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.PcmPlayer_sampleRate * 2205000)), var2 << 6) : null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lca;III)Lds;"
	)
	public static RawPcmStream method2767(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILds;)I"
	)
	static int method2806(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var7 - var2) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
		}

		var8.field1448 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILds;)I"
	)
	static int method2739(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var4 + var9 - var3) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field1448 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILds;)I"
	)
	static int method2727(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
		}

		var8.field1448 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILds;)I"
	)
	static int method2728(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field1448 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILds;II)I"
	)
	static int method2729(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
			var7 = var8;
		}

		byte var13;
		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			var13 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
			var7 = var8;
		}

		for (var1 = var12; var5 < var7; var4 += var11) {
			var13 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
		}

		var10.field1448 = var4;
		return var5;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2730(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		byte var14;
		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field1448 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILds;II)I"
	)
	static int method2731(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
			var7 = var8;
		}

		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			byte var13 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
			var7 = var8;
		}

		var0 = var12;

		for (var1 = var11; var5 < var7; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
		}

		var10.field1448 = var4;
		return var5;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2795(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field1448 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILds;)I"
	)
	static int method2733(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1445 += var9.field1454 * (var6 - var3);
		var9.field1446 += var9.field1453 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		var9.field1444 = var4 >> 2;
		var9.field1448 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILds;)I"
	)
	static int method2715(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1444 += var12.field1452 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field1445 = var5 >> 2;
		var12.field1446 = var6 >> 2;
		var12.field1448 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILds;)I"
	)
	static int method2842(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1445 += var9.field1454 * (var6 - var3);
		var9.field1446 += var9.field1453 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		var9.field1444 = var4 >> 2;
		var9.field1448 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILds;)I"
	)
	static int method2753(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1444 += var12.field1452 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field1445 = var5 >> 2;
		var12.field1446 = var6 >> 2;
		var12.field1448 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2761(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1445 -= var11.field1454 * var5;
		var11.field1446 -= var11.field1453 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		byte var14;
		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field1445 += var11.field1454 * var5;
		var11.field1446 += var11.field1453 * var5;
		var11.field1444 = var6;
		var11.field1448 = var4;
		return var5;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILds;II)I"
	)
	static int method2738(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1444 -= var5 * var13.field1452;
		if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		byte var16;
		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			var16 = var2[var1];
			var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var16 = var2[var4 >> 8];
			var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field1444 += var13.field1452 * var5;
		var13.field1445 = var6;
		var13.field1446 = var7;
		var13.field1448 = var4;
		return var5;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2701(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1445 -= var11.field1454 * var5;
		var11.field1446 -= var11.field1453 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var0 = var13;

		for (var1 = var12; var5 < var8; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field1445 += var11.field1454 * var5;
		var11.field1446 += var11.field1453 * var5;
		var11.field1444 = var6;
		var11.field1448 = var4;
		return var5;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILds;II)I"
	)
	static int method2826(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1444 -= var5 * var13.field1452;
		if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			byte var16 = var2[var1 - 1];
			var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field1444 += var13.field1452 * var5;
		var13.field1445 = var6;
		var13.field1446 = var7;
		var13.field1448 = var4;
		return var5;
	}
}
