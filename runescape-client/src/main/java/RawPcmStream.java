import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("c")
	int field1462;
	@ObfuscatedName("t")
	int field1463;
	@ObfuscatedName("o")
	int field1452;
	@ObfuscatedName("e")
	int field1464;
	@ObfuscatedName("i")
	int field1454;
	@ObfuscatedName("g")
	int field1455;
	@ObfuscatedName("d")
	int field1456;
	@ObfuscatedName("l")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("j")
	@Export("start")
	int start;
	@ObfuscatedName("m")
	@Export("end")
	int end;
	@ObfuscatedName("p")
	boolean field1450;
	@ObfuscatedName("h")
	int field1461;
	@ObfuscatedName("v")
	int field1460;
	@ObfuscatedName("n")
	int field1453;
	@ObfuscatedName("x")
	int field1451;

	@ObfuscatedSignature(
		signature = "(Lcv;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1450 = var1.field1379;
		this.field1463 = var2;
		this.field1452 = var3;
		this.field1464 = var4;
		this.field1462 = 0;
		this.method2607();
	}

	@ObfuscatedSignature(
		signature = "(Lcv;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1450 = var1.field1379;
		this.field1463 = var2;
		this.field1452 = var3;
		this.field1464 = 8192;
		this.field1462 = 0;
		this.method2607();
	}

	@ObfuscatedName("i")
	void method2607() {
		this.field1454 = this.field1452;
		this.field1455 = method2728(this.field1452, this.field1464);
		this.field1456 = method2603(this.field1452, this.field1464);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("l")
	protected int vmethod3965() {
		return this.field1452 == 0 && this.field1461 == 0 ? 0 : 1;
	}

	@ObfuscatedName("j")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1452 == 0 && this.field1461 == 0) {
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
			if (this.field1462 < 0) {
				if (this.field1463 <= 0) {
					this.method2616();
					this.remove();
					return;
				}

				this.field1462 = 0;
			}

			if (this.field1462 >= var7) {
				if (this.field1463 >= 0) {
					this.method2616();
					this.remove();
					return;
				}

				this.field1462 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1450) {
					if (this.field1463 < 0) {
						var9 = this.method2630(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1462 >= var5) {
							return;
						}

						this.field1462 = var5 + var5 - 1 - this.field1462;
						this.field1463 = -this.field1463;
					}

					while (true) {
						var9 = this.method2608(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1462 < var6) {
							return;
						}

						this.field1462 = var6 + var6 - 1 - this.field1462;
						this.field1463 = -this.field1463;
						var9 = this.method2630(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1462 >= var5) {
							return;
						}

						this.field1462 = var5 + var5 - 1 - this.field1462;
						this.field1463 = -this.field1463;
					}
				} else if (this.field1463 < 0) {
					while (true) {
						var9 = this.method2630(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1462 >= var5) {
							return;
						}

						this.field1462 = var6 - 1 - (var6 - 1 - this.field1462) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2608(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1462 < var6) {
							return;
						}

						this.field1462 = var5 + (this.field1462 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1450) {
						label146: {
							if (this.field1463 < 0) {
								var9 = this.method2630(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1462 >= var5) {
									return;
								}

								this.field1462 = var5 + var5 - 1 - this.field1462;
								this.field1463 = -this.field1463;
								if (--this.numLoops == 0) {
									break label146;
								}
							}

							do {
								var9 = this.method2608(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1462 < var6) {
									return;
								}

								this.field1462 = var6 + var6 - 1 - this.field1462;
								this.field1463 = -this.field1463;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2630(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1462 >= var5) {
									return;
								}

								this.field1462 = var5 + var5 - 1 - this.field1462;
								this.field1463 = -this.field1463;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1463 < 0) {
							while (true) {
								var9 = this.method2630(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1462 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1462) / var8;
								if (var10 >= this.numLoops) {
									this.field1462 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1462 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2608(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1462 < var6) {
									return;
								}

								var10 = (this.field1462 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1462 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1462 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1463 < 0) {
					this.method2630(var1, var9, 0, var3, 0);
					if (this.field1462 < 0) {
						this.field1462 = -1;
						this.method2616();
						this.remove();
					}
				} else {
					this.method2608(var1, var9, var7, var3, 0);
					if (this.field1462 >= var7) {
						this.field1462 = var7;
						this.method2616();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("m")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("p")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1461 > 0) {
			if (var1 >= this.field1461) {
				if (this.field1452 == Integer.MIN_VALUE) {
					this.field1452 = 0;
					this.field1456 = 0;
					this.field1455 = 0;
					this.field1454 = 0;
					this.remove();
					var1 = this.field1461;
				}

				this.field1461 = 0;
				this.method2607();
			} else {
				this.field1454 += this.field1460 * var1;
				this.field1455 += this.field1453 * var1;
				this.field1456 += this.field1451 * var1;
				this.field1461 -= var1;
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

		if (this.field1462 < 0) {
			if (this.field1463 <= 0) {
				this.method2616();
				this.remove();
				return;
			}

			this.field1462 = 0;
		}

		if (this.field1462 >= var5) {
			if (this.field1463 >= 0) {
				this.method2616();
				this.remove();
				return;
			}

			this.field1462 = var5 - 1;
		}

		this.field1462 += this.field1463 * var1;
		if (this.numLoops < 0) {
			if (!this.field1450) {
				if (this.field1463 < 0) {
					if (this.field1462 >= var3) {
						return;
					}

					this.field1462 = var4 - 1 - (var4 - 1 - this.field1462) % var6;
				} else {
					if (this.field1462 < var4) {
						return;
					}

					this.field1462 = var3 + (this.field1462 - var3) % var6;
				}

			} else {
				if (this.field1463 < 0) {
					if (this.field1462 >= var3) {
						return;
					}

					this.field1462 = var3 + var3 - 1 - this.field1462;
					this.field1463 = -this.field1463;
				}

				while (this.field1462 >= var4) {
					this.field1462 = var4 + var4 - 1 - this.field1462;
					this.field1463 = -this.field1463;
					if (this.field1462 >= var3) {
						return;
					}

					this.field1462 = var3 + var3 - 1 - this.field1462;
					this.field1463 = -this.field1463;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1450) {
					label125: {
						if (this.field1463 < 0) {
							if (this.field1462 >= var3) {
								return;
							}

							this.field1462 = var3 + var3 - 1 - this.field1462;
							this.field1463 = -this.field1463;
							if (--this.numLoops == 0) {
								break label125;
							}
						}

						do {
							if (this.field1462 < var4) {
								return;
							}

							this.field1462 = var4 + var4 - 1 - this.field1462;
							this.field1463 = -this.field1463;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1462 >= var3) {
								return;
							}

							this.field1462 = var3 + var3 - 1 - this.field1462;
							this.field1463 = -this.field1463;
						} while(--this.numLoops != 0);
					}
				} else {
					label157: {
						int var7;
						if (this.field1463 < 0) {
							if (this.field1462 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field1462) / var6;
							if (var7 >= this.numLoops) {
								this.field1462 += var6 * this.numLoops;
								this.numLoops = 0;
								break label157;
							}

							this.field1462 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field1462 < var4) {
								return;
							}

							var7 = (this.field1462 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field1462 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label157;
							}

							this.field1462 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field1463 < 0) {
				if (this.field1462 < 0) {
					this.field1462 = -1;
					this.method2616();
					this.remove();
				}
			} else if (this.field1462 >= var5) {
				this.field1462 = var5;
				this.method2616();
				this.remove();
			}

		}
	}

	@ObfuscatedName("h")
	public synchronized void method2665(int var1) {
		this.method2629(var1 << 6, this.method2613());
	}

	@ObfuscatedName("v")
	synchronized void method2610(int var1) {
		this.method2629(var1, this.method2613());
	}

	@ObfuscatedName("n")
	synchronized void method2629(int var1, int var2) {
		this.field1452 = var1;
		this.field1464 = var2;
		this.field1461 = 0;
		this.method2607();
	}

	@ObfuscatedName("x")
	public synchronized int method2612() {
		return this.field1452 == Integer.MIN_VALUE ? 0 : this.field1452;
	}

	@ObfuscatedName("w")
	public synchronized int method2613() {
		return this.field1464 < 0 ? -1 : this.field1464;
	}

	@ObfuscatedName("q")
	public synchronized void method2622(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1462 = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2710() {
		this.field1463 = (this.field1463 ^ this.field1463 >> 31) + (this.field1463 >>> 31);
		this.field1463 = -this.field1463;
	}

	@ObfuscatedName("y")
	void method2616() {
		if (this.field1461 != 0) {
			if (this.field1452 == Integer.MIN_VALUE) {
				this.field1452 = 0;
			}

			this.field1461 = 0;
			this.method2607();
		}

	}

	@ObfuscatedName("f")
	public synchronized void method2614(int var1, int var2) {
		this.method2618(var1, var2, this.method2613());
	}

	@ObfuscatedName("a")
	public synchronized void method2618(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2629(var2, var3);
		} else {
			int var4 = method2728(var2, var3);
			int var5 = method2603(var2, var3);
			if (var4 == this.field1455 && var5 == this.field1456) {
				this.field1461 = 0;
			} else {
				int var6 = var2 - this.field1454;
				if (this.field1454 - var2 > var6) {
					var6 = this.field1454 - var2;
				}

				if (var4 - this.field1455 > var6) {
					var6 = var4 - this.field1455;
				}

				if (this.field1455 - var4 > var6) {
					var6 = this.field1455 - var4;
				}

				if (var5 - this.field1456 > var6) {
					var6 = var5 - this.field1456;
				}

				if (this.field1456 - var5 > var6) {
					var6 = this.field1456 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1461 = var1;
				this.field1452 = var2;
				this.field1464 = var3;
				this.field1460 = (var2 - this.field1454) / var1;
				this.field1453 = (var4 - this.field1455) / var1;
				this.field1451 = (var5 - this.field1456) / var1;
			}
		}
	}

	@ObfuscatedName("u")
	public synchronized void method2619(int var1) {
		if (var1 == 0) {
			this.method2610(0);
			this.remove();
		} else if (this.field1455 == 0 && this.field1456 == 0) {
			this.field1461 = 0;
			this.field1452 = 0;
			this.field1454 = 0;
			this.remove();
		} else {
			int var2 = -this.field1454;
			if (this.field1454 > var2) {
				var2 = this.field1454;
			}

			if (-this.field1455 > var2) {
				var2 = -this.field1455;
			}

			if (this.field1455 > var2) {
				var2 = this.field1455;
			}

			if (-this.field1456 > var2) {
				var2 = -this.field1456;
			}

			if (this.field1456 > var2) {
				var2 = this.field1456;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1461 = var1;
			this.field1452 = Integer.MIN_VALUE;
			this.field1460 = -this.field1454 / var1;
			this.field1453 = -this.field1455 / var1;
			this.field1451 = -this.field1456 / var1;
		}
	}

	@ObfuscatedName("ae")
	public synchronized void method2660(int var1) {
		if (this.field1463 < 0) {
			this.field1463 = -var1;
		} else {
			this.field1463 = var1;
		}

	}

	@ObfuscatedName("af")
	public synchronized int method2621() {
		return this.field1463 < 0 ? -this.field1463 : this.field1463;
	}

	@ObfuscatedName("av")
	public boolean method2674() {
		return this.field1462 < 0 || this.field1462 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("al")
	public boolean method2712() {
		return this.field1461 != 0;
	}

	@ObfuscatedName("at")
	int method2608(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1461 > 0) {
				int var6 = var2 + this.field1461;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1461 += var2;
				if (this.field1463 == 256 && (this.field1462 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2641(0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, this.field1453, this.field1451, 0, var6, var3, this);
					} else {
						var2 = method2640(((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, this.field1460, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2738(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, this.field1453, this.field1451, 0, var6, var3, this, this.field1463, var5);
				} else {
					var2 = method2644(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, this.field1460, 0, var6, var3, this, this.field1463, var5);
				}

				this.field1461 -= var2;
				if (this.field1461 != 0) {
					return var2;
				}

				if (!this.method2631()) {
					continue;
				}

				return var4;
			}

			if (this.field1463 == 256 && (this.field1462 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2638(0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, 0, var4, var3, this);
				}

				return method2681(((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2688(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, 0, var4, var3, this, this.field1463, var5);
			}

			return method2636(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, 0, var4, var3, this, this.field1463, var5);
		}
	}

	@ObfuscatedName("an")
	int method2630(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1461 > 0) {
				int var6 = var2 + this.field1461;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1461 += var2;
				if (this.field1463 == -256 && (this.field1462 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2747(0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, this.field1453, this.field1451, 0, var6, var3, this);
					} else {
						var2 = method2642(((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, this.field1460, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2647(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, this.field1453, this.field1451, 0, var6, var3, this, this.field1463, var5);
				} else {
					var2 = method2646(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, this.field1460, 0, var6, var3, this, this.field1463, var5);
				}

				this.field1461 -= var2;
				if (this.field1461 != 0) {
					return var2;
				}

				if (!this.method2631()) {
					continue;
				}

				return var4;
			}

			if (this.field1463 == -256 && (this.field1462 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2635(0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, 0, var4, var3, this);
				}

				return method2743(((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2639(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1455, this.field1456, 0, var4, var3, this, this.field1463, var5);
			}

			return method2708(0, 0, ((RawSound)super.sound).samples, var1, this.field1462, var2, this.field1454, 0, var4, var3, this, this.field1463, var5);
		}
	}

	@ObfuscatedName("ag")
	int vmethod2777() {
		int var1 = this.field1454 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1462 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("ai")
	boolean method2631() {
		int var1 = this.field1452;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2728(var1, this.field1464);
			var3 = method2603(var1, this.field1464);
		}

		if (var1 == this.field1454 && var2 == this.field1455 && var3 == this.field1456) {
			if (this.field1452 == Integer.MIN_VALUE) {
				this.field1452 = 0;
				this.field1456 = 0;
				this.field1455 = 0;
				this.field1454 = 0;
				this.remove();
				return true;
			} else {
				this.method2607();
				return false;
			}
		} else {
			if (this.field1454 < var1) {
				this.field1460 = 1;
				this.field1461 = var1 - this.field1454;
			} else if (this.field1454 > var1) {
				this.field1460 = -1;
				this.field1461 = this.field1454 - var1;
			} else {
				this.field1460 = 0;
			}

			if (this.field1455 < var2) {
				this.field1453 = 1;
				if (this.field1461 == 0 || this.field1461 > var2 - this.field1455) {
					this.field1461 = var2 - this.field1455;
				}
			} else if (this.field1455 > var2) {
				this.field1453 = -1;
				if (this.field1461 == 0 || this.field1461 > this.field1455 - var2) {
					this.field1461 = this.field1455 - var2;
				}
			} else {
				this.field1453 = 0;
			}

			if (this.field1456 < var3) {
				this.field1451 = 1;
				if (this.field1461 == 0 || this.field1461 > var3 - this.field1456) {
					this.field1461 = var3 - this.field1456;
				}
			} else if (this.field1456 > var3) {
				this.field1451 = -1;
				if (this.field1461 == 0 || this.field1461 > this.field1456 - var3) {
					this.field1461 = this.field1456 - var3;
				}
			} else {
				this.field1451 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("c")
	static int method2728(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("t")
	static int method2603(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lcv;II)Lde;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field1398 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lcv;III)Lde;"
	)
	public static RawPcmStream method2673(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILde;)I"
	)
	static int method2681(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1462 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILde;)I"
	)
	static int method2638(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1462 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILde;)I"
	)
	static int method2743(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1462 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILde;)I"
	)
	static int method2635(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1462 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILde;II)I"
	)
	static int method2636(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1462 = var4;
		return var5;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILde;II)I"
	)
	static int method2688(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1462 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILde;II)I"
	)
	static int method2708(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1462 = var4;
		return var5;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILde;II)I"
	)
	static int method2639(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1462 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILde;)I"
	)
	static int method2640(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1455 += var9.field1453 * (var6 - var3);
		var9.field1456 += var9.field1451 * (var6 - var3);

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

		var9.field1454 = var4 >> 2;
		var9.field1462 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILde;)I"
	)
	static int method2641(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1454 += var12.field1460 * (var9 - var4);
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
		var12.field1456 = var6 >> 2;
		var12.field1462 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILde;)I"
	)
	static int method2642(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1455 += var9.field1453 * (var6 - var3);
		var9.field1456 += var9.field1451 * (var6 - var3);

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

		var9.field1454 = var4 >> 2;
		var9.field1462 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILde;)I"
	)
	static int method2747(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1454 += var12.field1460 * (var9 - var4);
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
		var12.field1456 = var6 >> 2;
		var12.field1462 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILde;II)I"
	)
	static int method2644(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1455 -= var11.field1453 * var5;
		var11.field1456 -= var11.field1451 * var5;
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

		var11.field1455 += var11.field1453 * var5;
		var11.field1456 += var11.field1451 * var5;
		var11.field1454 = var6;
		var11.field1462 = var4;
		return var5;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILde;II)I"
	)
	static int method2738(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1454 -= var5 * var13.field1460;
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
		var13.field1454 += var13.field1460 * var5;
		var13.field1455 = var6;
		var13.field1456 = var7;
		var13.field1462 = var4;
		return var5;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILde;II)I"
	)
	static int method2646(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1455 -= var11.field1453 * var5;
		var11.field1456 -= var11.field1451 * var5;
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

		var11.field1455 += var11.field1453 * var5;
		var11.field1456 += var11.field1451 * var5;
		var11.field1454 = var6;
		var11.field1462 = var4;
		return var5;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILde;II)I"
	)
	static int method2647(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1454 -= var5 * var13.field1460;
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
		var13.field1454 += var13.field1460 * var5;
		var13.field1455 = var6;
		var13.field1456 = var7;
		var13.field1462 = var4;
		return var5;
	}
}
