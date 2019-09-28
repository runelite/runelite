import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("z")
	int field1445;
	@ObfuscatedName("n")
	int field1435;
	@ObfuscatedName("v")
	int field1436;
	@ObfuscatedName("u")
	int field1443;
	@ObfuscatedName("r")
	int field1447;
	@ObfuscatedName("p")
	int field1439;
	@ObfuscatedName("q")
	int field1440;
	@ObfuscatedName("m")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("y")
	@Export("start")
	int start;
	@ObfuscatedName("i")
	@Export("end")
	int end;
	@ObfuscatedName("c")
	boolean field1444;
	@ObfuscatedName("b")
	int field1442;
	@ObfuscatedName("o")
	int field1434;
	@ObfuscatedName("a")
	int field1437;
	@ObfuscatedName("e")
	int field1448;

	@ObfuscatedSignature(
		signature = "(Lch;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1444 = var1.field1369;
		this.field1435 = var2;
		this.field1436 = var3;
		this.field1443 = var4;
		this.field1445 = 0;
		this.method2580();
	}

	@ObfuscatedSignature(
		signature = "(Lch;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1444 = var1.field1369;
		this.field1435 = var2;
		this.field1436 = var3;
		this.field1443 = 8192;
		this.field1445 = 0;
		this.method2580();
	}

	@ObfuscatedName("r")
	void method2580() {
		this.field1447 = this.field1436;
		this.field1439 = method2606(this.field1436, this.field1443);
		this.field1440 = method2512(this.field1436, this.field1443);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("m")
	protected int vmethod3882() {
		return this.field1436 == 0 && this.field1442 == 0 ? 0 : 1;
	}

	@ObfuscatedName("y")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1436 == 0 && this.field1442 == 0) {
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
			if (this.field1445 < 0) {
				if (this.field1435 <= 0) {
					this.method2641();
					this.remove();
					return;
				}

				this.field1445 = 0;
			}

			if (this.field1445 >= var7) {
				if (this.field1435 >= 0) {
					this.method2641();
					this.remove();
					return;
				}

				this.field1445 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1444) {
					if (this.field1435 < 0) {
						var9 = this.method2571(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1445 >= var5) {
							return;
						}

						this.field1445 = var5 + var5 - 1 - this.field1445;
						this.field1435 = -this.field1435;
					}

					while (true) {
						var9 = this.method2539(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1445 < var6) {
							return;
						}

						this.field1445 = var6 + var6 - 1 - this.field1445;
						this.field1435 = -this.field1435;
						var9 = this.method2571(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1445 >= var5) {
							return;
						}

						this.field1445 = var5 + var5 - 1 - this.field1445;
						this.field1435 = -this.field1435;
					}
				} else if (this.field1435 < 0) {
					while (true) {
						var9 = this.method2571(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1445 >= var5) {
							return;
						}

						this.field1445 = var6 - 1 - (var6 - 1 - this.field1445) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2539(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1445 < var6) {
							return;
						}

						this.field1445 = var5 + (this.field1445 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1444) {
						label129: {
							if (this.field1435 < 0) {
								var9 = this.method2571(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1445 >= var5) {
									return;
								}

								this.field1445 = var5 + var5 - 1 - this.field1445;
								this.field1435 = -this.field1435;
								if (--this.numLoops == 0) {
									break label129;
								}
							}

							do {
								var9 = this.method2539(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1445 < var6) {
									return;
								}

								this.field1445 = var6 + var6 - 1 - this.field1445;
								this.field1435 = -this.field1435;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2571(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1445 >= var5) {
									return;
								}

								this.field1445 = var5 + var5 - 1 - this.field1445;
								this.field1435 = -this.field1435;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1435 < 0) {
							while (true) {
								var9 = this.method2571(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1445 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1445) / var8;
								if (var10 >= this.numLoops) {
									this.field1445 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1445 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2539(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1445 < var6) {
									return;
								}

								var10 = (this.field1445 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1445 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1445 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1435 < 0) {
					this.method2571(var1, var9, 0, var3, 0);
					if (this.field1445 < 0) {
						this.field1445 = -1;
						this.method2641();
						this.remove();
					}
				} else {
					this.method2539(var1, var9, var7, var3, 0);
					if (this.field1445 >= var7) {
						this.field1445 = var7;
						this.method2641();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("i")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("c")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1442 > 0) {
			if (var1 >= this.field1442) {
				if (this.field1436 == Integer.MIN_VALUE) {
					this.field1436 = 0;
					this.field1440 = 0;
					this.field1439 = 0;
					this.field1447 = 0;
					this.remove();
					var1 = this.field1442;
				}

				this.field1442 = 0;
				this.method2580();
			} else {
				this.field1447 += this.field1434 * var1;
				this.field1439 += this.field1437 * var1;
				this.field1440 += this.field1448 * var1;
				this.field1442 -= var1;
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

		if (this.field1445 < 0) {
			if (this.field1435 <= 0) {
				this.method2641();
				this.remove();
				return;
			}

			this.field1445 = 0;
		}

		if (this.field1445 >= var5) {
			if (this.field1435 >= 0) {
				this.method2641();
				this.remove();
				return;
			}

			this.field1445 = var5 - 1;
		}

		this.field1445 += this.field1435 * var1;
		if (this.numLoops < 0) {
			if (!this.field1444) {
				if (this.field1435 < 0) {
					if (this.field1445 >= var3) {
						return;
					}

					this.field1445 = var4 - 1 - (var4 - 1 - this.field1445) % var6;
				} else {
					if (this.field1445 < var4) {
						return;
					}

					this.field1445 = var3 + (this.field1445 - var3) % var6;
				}

			} else {
				if (this.field1435 < 0) {
					if (this.field1445 >= var3) {
						return;
					}

					this.field1445 = var3 + var3 - 1 - this.field1445;
					this.field1435 = -this.field1435;
				}

				while (this.field1445 >= var4) {
					this.field1445 = var4 + var4 - 1 - this.field1445;
					this.field1435 = -this.field1435;
					if (this.field1445 >= var3) {
						return;
					}

					this.field1445 = var3 + var3 - 1 - this.field1445;
					this.field1435 = -this.field1435;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1444) {
					label126: {
						if (this.field1435 < 0) {
							if (this.field1445 >= var3) {
								return;
							}

							this.field1445 = var3 + var3 - 1 - this.field1445;
							this.field1435 = -this.field1435;
							if (--this.numLoops == 0) {
								break label126;
							}
						}

						do {
							if (this.field1445 < var4) {
								return;
							}

							this.field1445 = var4 + var4 - 1 - this.field1445;
							this.field1435 = -this.field1435;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1445 >= var3) {
								return;
							}

							this.field1445 = var3 + var3 - 1 - this.field1445;
							this.field1435 = -this.field1435;
						} while(--this.numLoops != 0);
					}
				} else {
					int var7;
					if (this.field1435 < 0) {
						if (this.field1445 >= var3) {
							return;
						}

						var7 = (var4 - 1 - this.field1445) / var6;
						if (var7 < this.numLoops) {
							this.field1445 += var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1445 += var6 * this.numLoops;
						this.numLoops = 0;
					} else {
						if (this.field1445 < var4) {
							return;
						}

						var7 = (this.field1445 - var3) / var6;
						if (var7 < this.numLoops) {
							this.field1445 -= var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1445 -= var6 * this.numLoops;
						this.numLoops = 0;
					}
				}
			}

			if (this.field1435 < 0) {
				if (this.field1445 < 0) {
					this.field1445 = -1;
					this.method2641();
					this.remove();
				}
			} else if (this.field1445 >= var5) {
				this.field1445 = var5;
				this.method2641();
				this.remove();
			}

		}
	}

	@ObfuscatedName("b")
	public synchronized void method2519(int var1) {
		this.method2521(var1 << 6, this.method2523());
	}

	@ObfuscatedName("o")
	synchronized void method2520(int var1) {
		this.method2521(var1, this.method2523());
	}

	@ObfuscatedName("a")
	synchronized void method2521(int var1, int var2) {
		this.field1436 = var1;
		this.field1443 = var2;
		this.field1442 = 0;
		this.method2580();
	}

	@ObfuscatedName("e")
	public synchronized int method2522() {
		return this.field1436 == Integer.MIN_VALUE ? 0 : this.field1436;
	}

	@ObfuscatedName("x")
	public synchronized int method2523() {
		return this.field1443 < 0 ? -1 : this.field1443;
	}

	@ObfuscatedName("h")
	public synchronized void method2581(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1445 = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2525() {
		this.field1435 = (this.field1435 ^ this.field1435 >> 31) + (this.field1435 >>> 31);
		this.field1435 = -this.field1435;
	}

	@ObfuscatedName("f")
	void method2641() {
		if (this.field1442 != 0) {
			if (this.field1436 == Integer.MIN_VALUE) {
				this.field1436 = 0;
			}

			this.field1442 = 0;
			this.method2580();
		}

	}

	@ObfuscatedName("j")
	public synchronized void method2527(int var1, int var2) {
		this.method2528(var1, var2, this.method2523());
	}

	@ObfuscatedName("d")
	public synchronized void method2528(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2521(var2, var3);
		} else {
			int var4 = method2606(var2, var3);
			int var5 = method2512(var2, var3);
			if (var4 == this.field1439 && var5 == this.field1440) {
				this.field1442 = 0;
			} else {
				int var6 = var2 - this.field1447;
				if (this.field1447 - var2 > var6) {
					var6 = this.field1447 - var2;
				}

				if (var4 - this.field1439 > var6) {
					var6 = var4 - this.field1439;
				}

				if (this.field1439 - var4 > var6) {
					var6 = this.field1439 - var4;
				}

				if (var5 - this.field1440 > var6) {
					var6 = var5 - this.field1440;
				}

				if (this.field1440 - var5 > var6) {
					var6 = this.field1440 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1442 = var1;
				this.field1436 = var2;
				this.field1443 = var3;
				this.field1434 = (var2 - this.field1447) / var1;
				this.field1437 = (var4 - this.field1439) / var1;
				this.field1448 = (var5 - this.field1440) / var1;
			}
		}
	}

	@ObfuscatedName("l")
	public synchronized void method2529(int var1) {
		if (var1 == 0) {
			this.method2520(0);
			this.remove();
		} else if (this.field1439 == 0 && this.field1440 == 0) {
			this.field1442 = 0;
			this.field1436 = 0;
			this.field1447 = 0;
			this.remove();
		} else {
			int var2 = -this.field1447;
			if (this.field1447 > var2) {
				var2 = this.field1447;
			}

			if (-this.field1439 > var2) {
				var2 = -this.field1439;
			}

			if (this.field1439 > var2) {
				var2 = this.field1439;
			}

			if (-this.field1440 > var2) {
				var2 = -this.field1440;
			}

			if (this.field1440 > var2) {
				var2 = this.field1440;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1442 = var1;
			this.field1436 = Integer.MIN_VALUE;
			this.field1434 = -this.field1447 / var1;
			this.field1437 = -this.field1439 / var1;
			this.field1448 = -this.field1440 / var1;
		}
	}

	@ObfuscatedName("k")
	public synchronized void method2530(int var1) {
		if (this.field1435 < 0) {
			this.field1435 = -var1;
		} else {
			this.field1435 = var1;
		}

	}

	@ObfuscatedName("ai")
	public synchronized int method2531() {
		return this.field1435 < 0 ? -this.field1435 : this.field1435;
	}

	@ObfuscatedName("ak")
	public boolean method2532() {
		return this.field1445 < 0 || this.field1445 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ae")
	public boolean method2533() {
		return this.field1442 != 0;
	}

	@ObfuscatedName("av")
	int method2539(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1442 > 0) {
				int var6 = var2 + this.field1442;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1442 += var2;
				if (this.field1435 == 256 && (this.field1445 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2551(0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, this.field1437, this.field1448, 0, var6, var3, this);
					} else {
						var2 = method2550(((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, this.field1434, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2584(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, this.field1437, this.field1448, 0, var6, var3, this, this.field1435, var5);
				} else {
					var2 = method2621(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, this.field1434, 0, var6, var3, this, this.field1435, var5);
				}

				this.field1442 -= var2;
				if (this.field1442 != 0) {
					return var2;
				}

				if (!this.method2541()) {
					continue;
				}

				return var4;
			}

			if (this.field1435 == 256 && (this.field1445 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2543(0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, 0, var4, var3, this);
				}

				return method2542(((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2547(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, 0, var4, var3, this, this.field1435, var5);
			}

			return method2546(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, 0, var4, var3, this, this.field1435, var5);
		}
	}

	@ObfuscatedName("ah")
	int vmethod2691() {
		int var1 = this.field1447 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1445 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("ag")
	int method2571(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1442 > 0) {
				int var6 = var2 + this.field1442;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1442 += var2;
				if (this.field1435 == -256 && (this.field1445 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2511(0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, this.field1437, this.field1448, 0, var6, var3, this);
					} else {
						var2 = method2552(((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, this.field1434, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2586(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, this.field1437, this.field1448, 0, var6, var3, this, this.field1435, var5);
				} else {
					var2 = method2556(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, this.field1434, 0, var6, var3, this, this.field1435, var5);
				}

				this.field1442 -= var2;
				if (this.field1442 != 0) {
					return var2;
				}

				if (!this.method2541()) {
					continue;
				}

				return var4;
			}

			if (this.field1435 == -256 && (this.field1445 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2545(0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, 0, var4, var3, this);
				}

				return method2544(((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2568(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1439, this.field1440, 0, var4, var3, this, this.field1435, var5);
			}

			return method2582(0, 0, ((RawSound)super.sound).samples, var1, this.field1445, var2, this.field1447, 0, var4, var3, this, this.field1435, var5);
		}
	}

	@ObfuscatedName("aj")
	boolean method2541() {
		int var1 = this.field1436;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2606(var1, this.field1443);
			var3 = method2512(var1, this.field1443);
		}

		if (var1 == this.field1447 && var2 == this.field1439 && var3 == this.field1440) {
			if (this.field1436 == Integer.MIN_VALUE) {
				this.field1436 = 0;
				this.field1440 = 0;
				this.field1439 = 0;
				this.field1447 = 0;
				this.remove();
				return true;
			} else {
				this.method2580();
				return false;
			}
		} else {
			if (this.field1447 < var1) {
				this.field1434 = 1;
				this.field1442 = var1 - this.field1447;
			} else if (this.field1447 > var1) {
				this.field1434 = -1;
				this.field1442 = this.field1447 - var1;
			} else {
				this.field1434 = 0;
			}

			if (this.field1439 < var2) {
				this.field1437 = 1;
				if (this.field1442 == 0 || this.field1442 > var2 - this.field1439) {
					this.field1442 = var2 - this.field1439;
				}
			} else if (this.field1439 > var2) {
				this.field1437 = -1;
				if (this.field1442 == 0 || this.field1442 > this.field1439 - var2) {
					this.field1442 = this.field1439 - var2;
				}
			} else {
				this.field1437 = 0;
			}

			if (this.field1440 < var3) {
				this.field1448 = 1;
				if (this.field1442 == 0 || this.field1442 > var3 - this.field1440) {
					this.field1442 = var3 - this.field1440;
				}
			} else if (this.field1440 > var3) {
				this.field1448 = -1;
				if (this.field1442 == 0 || this.field1442 > this.field1440 - var3) {
					this.field1442 = this.field1440 - var3;
				}
			} else {
				this.field1448 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("z")
	static int method2606(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("n")
	static int method2512(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lch;II)Ldu;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(UrlRequest.PcmPlayer_sampleRate * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lch;III)Ldu;"
	)
	public static RawPcmStream method2548(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdu;)I"
	)
	static int method2542(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1445 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdu;)I"
	)
	static int method2543(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1445 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdu;)I"
	)
	static int method2544(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1445 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdu;)I"
	)
	static int method2545(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1445 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdu;II)I"
	)
	static int method2546(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1445 = var4;
		return var5;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdu;II)I"
	)
	static int method2547(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1445 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdu;II)I"
	)
	static int method2582(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1445 = var4;
		return var5;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdu;II)I"
	)
	static int method2568(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1445 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdu;)I"
	)
	static int method2550(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1439 += var9.field1437 * (var6 - var3);
		var9.field1440 += var9.field1448 * (var6 - var3);

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

		var9.field1447 = var4 >> 2;
		var9.field1445 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdu;)I"
	)
	static int method2551(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1447 += var12.field1434 * (var9 - var4);
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

		var12.field1439 = var5 >> 2;
		var12.field1440 = var6 >> 2;
		var12.field1445 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdu;)I"
	)
	static int method2552(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1439 += var9.field1437 * (var6 - var3);
		var9.field1440 += var9.field1448 * (var6 - var3);

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

		var9.field1447 = var4 >> 2;
		var9.field1445 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdu;)I"
	)
	static int method2511(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1447 += var12.field1434 * (var9 - var4);
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

		var12.field1439 = var5 >> 2;
		var12.field1440 = var6 >> 2;
		var12.field1445 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdu;II)I"
	)
	static int method2621(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1439 -= var11.field1437 * var5;
		var11.field1440 -= var11.field1448 * var5;
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

		var11.field1439 += var11.field1437 * var5;
		var11.field1440 += var11.field1448 * var5;
		var11.field1447 = var6;
		var11.field1445 = var4;
		return var5;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdu;II)I"
	)
	static int method2584(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1447 -= var5 * var13.field1434;
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
		var13.field1447 += var13.field1434 * var5;
		var13.field1439 = var6;
		var13.field1440 = var7;
		var13.field1445 = var4;
		return var5;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdu;II)I"
	)
	static int method2556(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1439 -= var11.field1437 * var5;
		var11.field1440 -= var11.field1448 * var5;
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

		var11.field1439 += var11.field1437 * var5;
		var11.field1440 += var11.field1448 * var5;
		var11.field1447 = var6;
		var11.field1445 = var4;
		return var5;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdu;II)I"
	)
	static int method2586(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1447 -= var5 * var13.field1434;
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
		var13.field1447 += var13.field1434 * var5;
		var13.field1439 = var6;
		var13.field1440 = var7;
		var13.field1445 = var4;
		return var5;
	}
}
