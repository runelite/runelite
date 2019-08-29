import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("s")
	int field1452;
	@ObfuscatedName("j")
	int field1451;
	@ObfuscatedName("i")
	int field1454;
	@ObfuscatedName("k")
	int field1458;
	@ObfuscatedName("u")
	int field1456;
	@ObfuscatedName("n")
	int field1455;
	@ObfuscatedName("t")
	int field1461;
	@ObfuscatedName("q")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("x")
	@Export("start")
	int start;
	@ObfuscatedName("d")
	@Export("end")
	int end;
	@ObfuscatedName("f")
	boolean field1460;
	@ObfuscatedName("c")
	int field1453;
	@ObfuscatedName("r")
	int field1462;
	@ObfuscatedName("y")
	int field1463;
	@ObfuscatedName("p")
	int field1464;

	@ObfuscatedSignature(
		signature = "(Lco;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1460 = var1.field1362;
		this.field1451 = var2;
		this.field1454 = var3;
		this.field1458 = var4;
		this.field1452 = 0;
		this.method2609();
	}

	@ObfuscatedSignature(
		signature = "(Lco;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1460 = var1.field1362;
		this.field1451 = var2;
		this.field1454 = var3;
		this.field1458 = 8192;
		this.field1452 = 0;
		this.method2609();
	}

	@ObfuscatedName("u")
	void method2609() {
		this.field1456 = this.field1454;
		this.field1455 = method2558(this.field1454, this.field1458);
		this.field1461 = method2456(this.field1454, this.field1458);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("q")
	protected int vmethod3834() {
		return this.field1454 == 0 && this.field1453 == 0 ? 0 : 1;
	}

	@ObfuscatedName("x")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1454 == 0 && this.field1453 == 0) {
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
			if (this.field1452 < 0) {
				if (this.field1451 <= 0) {
					this.method2617();
					this.remove();
					return;
				}

				this.field1452 = 0;
			}

			if (this.field1452 >= var7) {
				if (this.field1451 >= 0) {
					this.method2617();
					this.remove();
					return;
				}

				this.field1452 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1460) {
					if (this.field1451 < 0) {
						var9 = this.method2618(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1452 >= var5) {
							return;
						}

						this.field1452 = var5 + var5 - 1 - this.field1452;
						this.field1451 = -this.field1451;
					}

					while (true) {
						var9 = this.method2477(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1452 < var6) {
							return;
						}

						this.field1452 = var6 + var6 - 1 - this.field1452;
						this.field1451 = -this.field1451;
						var9 = this.method2618(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1452 >= var5) {
							return;
						}

						this.field1452 = var5 + var5 - 1 - this.field1452;
						this.field1451 = -this.field1451;
					}
				} else if (this.field1451 < 0) {
					while (true) {
						var9 = this.method2618(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1452 >= var5) {
							return;
						}

						this.field1452 = var6 - 1 - (var6 - 1 - this.field1452) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2477(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1452 < var6) {
							return;
						}

						this.field1452 = var5 + (this.field1452 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1460) {
						label130: {
							if (this.field1451 < 0) {
								var9 = this.method2618(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1452 >= var5) {
									return;
								}

								this.field1452 = var5 + var5 - 1 - this.field1452;
								this.field1451 = -this.field1451;
								if (--this.numLoops == 0) {
									break label130;
								}
							}

							do {
								var9 = this.method2477(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1452 < var6) {
									return;
								}

								this.field1452 = var6 + var6 - 1 - this.field1452;
								this.field1451 = -this.field1451;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2618(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1452 >= var5) {
									return;
								}

								this.field1452 = var5 + var5 - 1 - this.field1452;
								this.field1451 = -this.field1451;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1451 < 0) {
							while (true) {
								var9 = this.method2618(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1452 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1452) / var8;
								if (var10 >= this.numLoops) {
									this.field1452 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1452 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2477(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1452 < var6) {
									return;
								}

								var10 = (this.field1452 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1452 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1452 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1451 < 0) {
					this.method2618(var1, var9, 0, var3, 0);
					if (this.field1452 < 0) {
						this.field1452 = -1;
						this.method2617();
						this.remove();
					}
				} else {
					this.method2477(var1, var9, var7, var3, 0);
					if (this.field1452 >= var7) {
						this.field1452 = var7;
						this.method2617();
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

	@ObfuscatedName("f")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1453 > 0) {
			if (var1 >= this.field1453) {
				if (this.field1454 == Integer.MIN_VALUE) {
					this.field1454 = 0;
					this.field1461 = 0;
					this.field1455 = 0;
					this.field1456 = 0;
					this.remove();
					var1 = this.field1453;
				}

				this.field1453 = 0;
				this.method2609();
			} else {
				this.field1456 += this.field1462 * var1;
				this.field1455 += this.field1463 * var1;
				this.field1461 += this.field1464 * var1;
				this.field1453 -= var1;
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

		if (this.field1452 < 0) {
			if (this.field1451 <= 0) {
				this.method2617();
				this.remove();
				return;
			}

			this.field1452 = 0;
		}

		if (this.field1452 >= var5) {
			if (this.field1451 >= 0) {
				this.method2617();
				this.remove();
				return;
			}

			this.field1452 = var5 - 1;
		}

		this.field1452 += this.field1451 * var1;
		if (this.numLoops < 0) {
			if (!this.field1460) {
				if (this.field1451 < 0) {
					if (this.field1452 >= var3) {
						return;
					}

					this.field1452 = var4 - 1 - (var4 - 1 - this.field1452) % var6;
				} else {
					if (this.field1452 < var4) {
						return;
					}

					this.field1452 = var3 + (this.field1452 - var3) % var6;
				}

			} else {
				if (this.field1451 < 0) {
					if (this.field1452 >= var3) {
						return;
					}

					this.field1452 = var3 + var3 - 1 - this.field1452;
					this.field1451 = -this.field1451;
				}

				while (this.field1452 >= var4) {
					this.field1452 = var4 + var4 - 1 - this.field1452;
					this.field1451 = -this.field1451;
					if (this.field1452 >= var3) {
						return;
					}

					this.field1452 = var3 + var3 - 1 - this.field1452;
					this.field1451 = -this.field1451;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1460) {
					label120: {
						if (this.field1451 < 0) {
							if (this.field1452 >= var3) {
								return;
							}

							this.field1452 = var3 + var3 - 1 - this.field1452;
							this.field1451 = -this.field1451;
							if (--this.numLoops == 0) {
								break label120;
							}
						}

						do {
							if (this.field1452 < var4) {
								return;
							}

							this.field1452 = var4 + var4 - 1 - this.field1452;
							this.field1451 = -this.field1451;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1452 >= var3) {
								return;
							}

							this.field1452 = var3 + var3 - 1 - this.field1452;
							this.field1451 = -this.field1451;
						} while(--this.numLoops != 0);
					}
				} else {
					label152: {
						int var7;
						if (this.field1451 < 0) {
							if (this.field1452 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field1452) / var6;
							if (var7 >= this.numLoops) {
								this.field1452 += var6 * this.numLoops;
								this.numLoops = 0;
								break label152;
							}

							this.field1452 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field1452 < var4) {
								return;
							}

							var7 = (this.field1452 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field1452 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label152;
							}

							this.field1452 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field1451 < 0) {
				if (this.field1452 < 0) {
					this.field1452 = -1;
					this.method2617();
					this.remove();
				}
			} else if (this.field1452 >= var5) {
				this.field1452 = var5;
				this.method2617();
				this.remove();
			}

		}
	}

	@ObfuscatedName("c")
	public synchronized void method2599(int var1) {
		this.method2465(var1 << 6, this.method2467());
	}

	@ObfuscatedName("r")
	synchronized void method2554(int var1) {
		this.method2465(var1, this.method2467());
	}

	@ObfuscatedName("y")
	synchronized void method2465(int var1, int var2) {
		this.field1454 = var1;
		this.field1458 = var2;
		this.field1453 = 0;
		this.method2609();
	}

	@ObfuscatedName("p")
	public synchronized int method2455() {
		return this.field1454 == Integer.MIN_VALUE ? 0 : this.field1454;
	}

	@ObfuscatedName("g")
	public synchronized int method2467() {
		return this.field1458 < 0 ? -1 : this.field1458;
	}

	@ObfuscatedName("e")
	public synchronized void method2468(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1452 = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2469() {
		this.field1451 = (this.field1451 ^ this.field1451 >> 31) + (this.field1451 >>> 31);
		this.field1451 = -this.field1451;
	}

	@ObfuscatedName("w")
	void method2617() {
		if (this.field1453 != 0) {
			if (this.field1454 == Integer.MIN_VALUE) {
				this.field1454 = 0;
			}

			this.field1453 = 0;
			this.method2609();
		}

	}

	@ObfuscatedName("l")
	public synchronized void method2470(int var1, int var2) {
		this.method2472(var1, var2, this.method2467());
	}

	@ObfuscatedName("az")
	public synchronized void method2472(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2465(var2, var3);
		} else {
			int var4 = method2558(var2, var3);
			int var5 = method2456(var2, var3);
			if (var4 == this.field1455 && var5 == this.field1461) {
				this.field1453 = 0;
			} else {
				int var6 = var2 - this.field1456;
				if (this.field1456 - var2 > var6) {
					var6 = this.field1456 - var2;
				}

				if (var4 - this.field1455 > var6) {
					var6 = var4 - this.field1455;
				}

				if (this.field1455 - var4 > var6) {
					var6 = this.field1455 - var4;
				}

				if (var5 - this.field1461 > var6) {
					var6 = var5 - this.field1461;
				}

				if (this.field1461 - var5 > var6) {
					var6 = this.field1461 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1453 = var1;
				this.field1454 = var2;
				this.field1458 = var3;
				this.field1462 = (var2 - this.field1456) / var1;
				this.field1463 = (var4 - this.field1455) / var1;
				this.field1464 = (var5 - this.field1461) / var1;
			}
		}
	}

	@ObfuscatedName("at")
	public synchronized void method2473(int var1) {
		if (var1 == 0) {
			this.method2554(0);
			this.remove();
		} else if (this.field1455 == 0 && this.field1461 == 0) {
			this.field1453 = 0;
			this.field1454 = 0;
			this.field1456 = 0;
			this.remove();
		} else {
			int var2 = -this.field1456;
			if (this.field1456 > var2) {
				var2 = this.field1456;
			}

			if (-this.field1455 > var2) {
				var2 = -this.field1455;
			}

			if (this.field1455 > var2) {
				var2 = this.field1455;
			}

			if (-this.field1461 > var2) {
				var2 = -this.field1461;
			}

			if (this.field1461 > var2) {
				var2 = this.field1461;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1453 = var1;
			this.field1454 = Integer.MIN_VALUE;
			this.field1462 = -this.field1456 / var1;
			this.field1463 = -this.field1455 / var1;
			this.field1464 = -this.field1461 / var1;
		}
	}

	@ObfuscatedName("as")
	public synchronized void method2474(int var1) {
		if (this.field1451 < 0) {
			this.field1451 = -var1;
		} else {
			this.field1451 = var1;
		}

	}

	@ObfuscatedName("ak")
	int vmethod2644() {
		int var1 = this.field1456 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1452 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("ao")
	public synchronized int method2603() {
		return this.field1451 < 0 ? -this.field1451 : this.field1451;
	}

	@ObfuscatedName("ac")
	public boolean method2476() {
		return this.field1452 < 0 || this.field1452 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ar")
	public boolean method2457() {
		return this.field1453 != 0;
	}

	@ObfuscatedName("au")
	int method2477(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1453 > 0) {
				int var6 = var2 + this.field1453;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1453 += var2;
				if (this.field1451 == 256 && (this.field1452 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2495(0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, this.field1463, this.field1464, 0, var6, var3, this);
					} else {
						var2 = method2494(((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, this.field1462, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2499(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, this.field1463, this.field1464, 0, var6, var3, this, this.field1451, var5);
				} else {
					var2 = method2498(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, this.field1462, 0, var6, var3, this, this.field1451, var5);
				}

				this.field1453 -= var2;
				if (this.field1453 != 0) {
					return var2;
				}

				if (!this.method2514()) {
					continue;
				}

				return var4;
			}

			if (this.field1451 == 256 && (this.field1452 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2551(0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, 0, var4, var3, this);
				}

				return method2546(((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2491(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, 0, var4, var3, this, this.field1451, var5);
			}

			return method2490(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, 0, var4, var3, this, this.field1451, var5);
		}
	}

	@ObfuscatedName("ax")
	int method2618(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1453 > 0) {
				int var6 = var2 + this.field1453;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1453 += var2;
				if (this.field1451 == -256 && (this.field1452 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2590(0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, this.field1463, this.field1464, 0, var6, var3, this);
					} else {
						var2 = method2496(((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, this.field1462, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2458(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, this.field1463, this.field1464, 0, var6, var3, this, this.field1451, var5);
				} else {
					var2 = method2500(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, this.field1462, 0, var6, var3, this, this.field1451, var5);
				}

				this.field1453 -= var2;
				if (this.field1453 != 0) {
					return var2;
				}

				if (!this.method2514()) {
					continue;
				}

				return var4;
			}

			if (this.field1451 == -256 && (this.field1452 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2489(0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, 0, var4, var3, this);
				}

				return method2488(((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2545(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1455, this.field1461, 0, var4, var3, this, this.field1451, var5);
			}

			return method2492(0, 0, ((RawSound)super.sound).samples, var1, this.field1452, var2, this.field1456, 0, var4, var3, this, this.field1451, var5);
		}
	}

	@ObfuscatedName("ag")
	boolean method2514() {
		int var1 = this.field1454;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2558(var1, this.field1458);
			var3 = method2456(var1, this.field1458);
		}

		if (var1 == this.field1456 && var2 == this.field1455 && var3 == this.field1461) {
			if (this.field1454 == Integer.MIN_VALUE) {
				this.field1454 = 0;
				this.field1461 = 0;
				this.field1455 = 0;
				this.field1456 = 0;
				this.remove();
				return true;
			} else {
				this.method2609();
				return false;
			}
		} else {
			if (this.field1456 < var1) {
				this.field1462 = 1;
				this.field1453 = var1 - this.field1456;
			} else if (this.field1456 > var1) {
				this.field1462 = -1;
				this.field1453 = this.field1456 - var1;
			} else {
				this.field1462 = 0;
			}

			if (this.field1455 < var2) {
				this.field1463 = 1;
				if (this.field1453 == 0 || this.field1453 > var2 - this.field1455) {
					this.field1453 = var2 - this.field1455;
				}
			} else if (this.field1455 > var2) {
				this.field1463 = -1;
				if (this.field1453 == 0 || this.field1453 > this.field1455 - var2) {
					this.field1453 = this.field1455 - var2;
				}
			} else {
				this.field1463 = 0;
			}

			if (this.field1461 < var3) {
				this.field1464 = 1;
				if (this.field1453 == 0 || this.field1453 > var3 - this.field1461) {
					this.field1453 = var3 - this.field1461;
				}
			} else if (this.field1461 > var3) {
				this.field1464 = -1;
				if (this.field1453 == 0 || this.field1453 > this.field1461 - var3) {
					this.field1453 = this.field1461 - var3;
				}
			} else {
				this.field1464 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("s")
	static int method2558(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("j")
	static int method2456(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lco;II)Ldx;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.PcmPlayer_sampleRate * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lco;III)Ldx;"
	)
	public static RawPcmStream method2460(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdx;)I"
	)
	static int method2546(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1452 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdx;)I"
	)
	static int method2551(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1452 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdx;)I"
	)
	static int method2488(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1452 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdx;)I"
	)
	static int method2489(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1452 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdx;II)I"
	)
	static int method2490(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1452 = var4;
		return var5;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdx;II)I"
	)
	static int method2491(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1452 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdx;II)I"
	)
	static int method2492(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1452 = var4;
		return var5;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdx;II)I"
	)
	static int method2545(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1452 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdx;)I"
	)
	static int method2494(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1455 += var9.field1463 * (var6 - var3);
		var9.field1461 += var9.field1464 * (var6 - var3);

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

		var9.field1456 = var4 >> 2;
		var9.field1452 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdx;)I"
	)
	static int method2495(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1456 += var12.field1462 * (var9 - var4);
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

		var12.field1455 = var5 >> 2;
		var12.field1461 = var6 >> 2;
		var12.field1452 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdx;)I"
	)
	static int method2496(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1455 += var9.field1463 * (var6 - var3);
		var9.field1461 += var9.field1464 * (var6 - var3);

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

		var9.field1456 = var4 >> 2;
		var9.field1452 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdx;)I"
	)
	static int method2590(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1456 += var12.field1462 * (var9 - var4);
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

		var12.field1455 = var5 >> 2;
		var12.field1461 = var6 >> 2;
		var12.field1452 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdx;II)I"
	)
	static int method2498(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1455 -= var11.field1463 * var5;
		var11.field1461 -= var11.field1464 * var5;
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

		var11.field1455 += var11.field1463 * var5;
		var11.field1461 += var11.field1464 * var5;
		var11.field1456 = var6;
		var11.field1452 = var4;
		return var5;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdx;II)I"
	)
	static int method2499(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1456 -= var5 * var13.field1462;
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
		var13.field1456 += var13.field1462 * var5;
		var13.field1455 = var6;
		var13.field1461 = var7;
		var13.field1452 = var4;
		return var5;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdx;II)I"
	)
	static int method2500(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1455 -= var11.field1463 * var5;
		var11.field1461 -= var11.field1464 * var5;
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

		var11.field1455 += var11.field1463 * var5;
		var11.field1461 += var11.field1464 * var5;
		var11.field1456 = var6;
		var11.field1452 = var4;
		return var5;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdx;II)I"
	)
	static int method2458(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1456 -= var5 * var13.field1462;
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
		var13.field1456 += var13.field1462 * var5;
		var13.field1455 = var6;
		var13.field1461 = var7;
		var13.field1452 = var4;
		return var5;
	}
}
