import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("c")
	int field1435;
	@ObfuscatedName("x")
	int field1433;
	@ObfuscatedName("t")
	int field1434;
	@ObfuscatedName("g")
	int field1438;
	@ObfuscatedName("l")
	int field1436;
	@ObfuscatedName("u")
	int field1437;
	@ObfuscatedName("j")
	int field1432;
	@ObfuscatedName("v")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("d")
	@Export("start")
	int start;
	@ObfuscatedName("z")
	@Export("end")
	int end;
	@ObfuscatedName("n")
	boolean field1442;
	@ObfuscatedName("h")
	int field1443;
	@ObfuscatedName("f")
	int field1444;
	@ObfuscatedName("s")
	int field1445;
	@ObfuscatedName("p")
	int field1446;

	@ObfuscatedSignature(
		signature = "(Lcg;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1442 = var1.field1358;
		this.field1433 = var2;
		this.field1434 = var3;
		this.field1438 = var4;
		this.field1435 = 0;
		this.method2512();
	}

	@ObfuscatedSignature(
		signature = "(Lcg;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1442 = var1.field1358;
		this.field1433 = var2;
		this.field1434 = var3;
		this.field1438 = 8192;
		this.field1435 = 0;
		this.method2512();
	}

	@ObfuscatedName("l")
	void method2512() {
		this.field1436 = this.field1434;
		this.field1437 = method2647(this.field1434, this.field1438);
		this.field1432 = method2508(this.field1434, this.field1438);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("v")
	protected int vmethod3881() {
		return this.field1434 == 0 && this.field1443 == 0 ? 0 : 1;
	}

	@ObfuscatedName("d")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1434 == 0 && this.field1443 == 0) {
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
			if (this.field1435 < 0) {
				if (this.field1433 <= 0) {
					this.method2521();
					this.remove();
					return;
				}

				this.field1435 = 0;
			}

			if (this.field1435 >= var7) {
				if (this.field1433 >= 0) {
					this.method2521();
					this.remove();
					return;
				}

				this.field1435 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1442) {
					if (this.field1433 < 0) {
						var9 = this.method2544(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1435 >= var5) {
							return;
						}

						this.field1435 = var5 + var5 - 1 - this.field1435;
						this.field1433 = -this.field1433;
					}

					while (true) {
						var9 = this.method2568(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1435 < var6) {
							return;
						}

						this.field1435 = var6 + var6 - 1 - this.field1435;
						this.field1433 = -this.field1433;
						var9 = this.method2544(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1435 >= var5) {
							return;
						}

						this.field1435 = var5 + var5 - 1 - this.field1435;
						this.field1433 = -this.field1433;
					}
				} else if (this.field1433 < 0) {
					while (true) {
						var9 = this.method2544(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1435 >= var5) {
							return;
						}

						this.field1435 = var6 - 1 - (var6 - 1 - this.field1435) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2568(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1435 < var6) {
							return;
						}

						this.field1435 = var5 + (this.field1435 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1442) {
						label139: {
							if (this.field1433 < 0) {
								var9 = this.method2544(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1435 >= var5) {
									return;
								}

								this.field1435 = var5 + var5 - 1 - this.field1435;
								this.field1433 = -this.field1433;
								if (--this.numLoops == 0) {
									break label139;
								}
							}

							do {
								var9 = this.method2568(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1435 < var6) {
									return;
								}

								this.field1435 = var6 + var6 - 1 - this.field1435;
								this.field1433 = -this.field1433;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2544(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1435 >= var5) {
									return;
								}

								this.field1435 = var5 + var5 - 1 - this.field1435;
								this.field1433 = -this.field1433;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1433 < 0) {
							while (true) {
								var9 = this.method2544(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1435 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1435) / var8;
								if (var10 >= this.numLoops) {
									this.field1435 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1435 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2568(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1435 < var6) {
									return;
								}

								var10 = (this.field1435 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1435 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1435 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1433 < 0) {
					this.method2544(var1, var9, 0, var3, 0);
					if (this.field1435 < 0) {
						this.field1435 = -1;
						this.method2521();
						this.remove();
					}
				} else {
					this.method2568(var1, var9, var7, var3, 0);
					if (this.field1435 >= var7) {
						this.field1435 = var7;
						this.method2521();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("z")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("s")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1443 > 0) {
			if (var1 >= this.field1443) {
				if (this.field1434 == Integer.MIN_VALUE) {
					this.field1434 = 0;
					this.field1432 = 0;
					this.field1437 = 0;
					this.field1436 = 0;
					this.remove();
					var1 = this.field1443;
				}

				this.field1443 = 0;
				this.method2512();
			} else {
				this.field1436 += this.field1444 * var1;
				this.field1437 += this.field1445 * var1;
				this.field1432 += this.field1446 * var1;
				this.field1443 -= var1;
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

		if (this.field1435 < 0) {
			if (this.field1433 <= 0) {
				this.method2521();
				this.remove();
				return;
			}

			this.field1435 = 0;
		}

		if (this.field1435 >= var5) {
			if (this.field1433 >= 0) {
				this.method2521();
				this.remove();
				return;
			}

			this.field1435 = var5 - 1;
		}

		this.field1435 += this.field1433 * var1;
		if (this.numLoops < 0) {
			if (!this.field1442) {
				if (this.field1433 < 0) {
					if (this.field1435 >= var3) {
						return;
					}

					this.field1435 = var4 - 1 - (var4 - 1 - this.field1435) % var6;
				} else {
					if (this.field1435 < var4) {
						return;
					}

					this.field1435 = var3 + (this.field1435 - var3) % var6;
				}

			} else {
				if (this.field1433 < 0) {
					if (this.field1435 >= var3) {
						return;
					}

					this.field1435 = var3 + var3 - 1 - this.field1435;
					this.field1433 = -this.field1433;
				}

				while (this.field1435 >= var4) {
					this.field1435 = var4 + var4 - 1 - this.field1435;
					this.field1433 = -this.field1433;
					if (this.field1435 >= var3) {
						return;
					}

					this.field1435 = var3 + var3 - 1 - this.field1435;
					this.field1433 = -this.field1433;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1442) {
					label126: {
						if (this.field1433 < 0) {
							if (this.field1435 >= var3) {
								return;
							}

							this.field1435 = var3 + var3 - 1 - this.field1435;
							this.field1433 = -this.field1433;
							if (--this.numLoops == 0) {
								break label126;
							}
						}

						do {
							if (this.field1435 < var4) {
								return;
							}

							this.field1435 = var4 + var4 - 1 - this.field1435;
							this.field1433 = -this.field1433;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1435 >= var3) {
								return;
							}

							this.field1435 = var3 + var3 - 1 - this.field1435;
							this.field1433 = -this.field1433;
						} while(--this.numLoops != 0);
					}
				} else {
					int var7;
					if (this.field1433 < 0) {
						if (this.field1435 >= var3) {
							return;
						}

						var7 = (var4 - 1 - this.field1435) / var6;
						if (var7 < this.numLoops) {
							this.field1435 += var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1435 += var6 * this.numLoops;
						this.numLoops = 0;
					} else {
						if (this.field1435 < var4) {
							return;
						}

						var7 = (this.field1435 - var3) / var6;
						if (var7 < this.numLoops) {
							this.field1435 -= var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1435 -= var6 * this.numLoops;
						this.numLoops = 0;
					}
				}
			}

			if (this.field1433 < 0) {
				if (this.field1435 < 0) {
					this.field1435 = -1;
					this.method2521();
					this.remove();
				}
			} else if (this.field1435 >= var5) {
				this.field1435 = var5;
				this.method2521();
				this.remove();
			}

		}
	}

	@ObfuscatedName("p")
	public synchronized void method2514(int var1) {
		this.method2532(var1 << 6, this.method2518());
	}

	@ObfuscatedName("e")
	synchronized void method2515(int var1) {
		this.method2532(var1, this.method2518());
	}

	@ObfuscatedName("i")
	synchronized void method2532(int var1, int var2) {
		this.field1434 = var1;
		this.field1438 = var2;
		this.field1443 = 0;
		this.method2512();
	}

	@ObfuscatedName("q")
	public synchronized int method2517() {
		return this.field1434 == Integer.MIN_VALUE ? 0 : this.field1434;
	}

	@ObfuscatedName("r")
	public synchronized int method2518() {
		return this.field1438 < 0 ? -1 : this.field1438;
	}

	@ObfuscatedName("k")
	public synchronized void method2569(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1435 = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2548() {
		this.field1433 = (this.field1433 ^ this.field1433 >> 31) + (this.field1433 >>> 31);
		this.field1433 = -this.field1433;
	}

	@ObfuscatedName("m")
	void method2521() {
		if (this.field1443 != 0) {
			if (this.field1434 == Integer.MIN_VALUE) {
				this.field1434 = 0;
			}

			this.field1443 = 0;
			this.method2512();
		}

	}

	@ObfuscatedName("o")
	public synchronized void method2522(int var1, int var2) {
		this.method2523(var1, var2, this.method2518());
	}

	@ObfuscatedName("a")
	public synchronized void method2523(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2532(var2, var3);
		} else {
			int var4 = method2647(var2, var3);
			int var5 = method2508(var2, var3);
			if (var4 == this.field1437 && var5 == this.field1432) {
				this.field1443 = 0;
			} else {
				int var6 = var2 - this.field1436;
				if (this.field1436 - var2 > var6) {
					var6 = this.field1436 - var2;
				}

				if (var4 - this.field1437 > var6) {
					var6 = var4 - this.field1437;
				}

				if (this.field1437 - var4 > var6) {
					var6 = this.field1437 - var4;
				}

				if (var5 - this.field1432 > var6) {
					var6 = var5 - this.field1432;
				}

				if (this.field1432 - var5 > var6) {
					var6 = this.field1432 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1443 = var1;
				this.field1434 = var2;
				this.field1438 = var3;
				this.field1444 = (var2 - this.field1436) / var1;
				this.field1445 = (var4 - this.field1437) / var1;
				this.field1446 = (var5 - this.field1432) / var1;
			}
		}
	}

	@ObfuscatedName("b")
	public synchronized void method2541(int var1) {
		if (var1 == 0) {
			this.method2515(0);
			this.remove();
		} else if (this.field1437 == 0 && this.field1432 == 0) {
			this.field1443 = 0;
			this.field1434 = 0;
			this.field1436 = 0;
			this.remove();
		} else {
			int var2 = -this.field1436;
			if (this.field1436 > var2) {
				var2 = this.field1436;
			}

			if (-this.field1437 > var2) {
				var2 = -this.field1437;
			}

			if (this.field1437 > var2) {
				var2 = this.field1437;
			}

			if (-this.field1432 > var2) {
				var2 = -this.field1432;
			}

			if (this.field1432 > var2) {
				var2 = this.field1432;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1443 = var1;
			this.field1434 = Integer.MIN_VALUE;
			this.field1444 = -this.field1436 / var1;
			this.field1445 = -this.field1437 / var1;
			this.field1446 = -this.field1432 / var1;
		}
	}

	@ObfuscatedName("ag")
	public synchronized void method2525(int var1) {
		if (this.field1433 < 0) {
			this.field1433 = -var1;
		} else {
			this.field1433 = var1;
		}

	}

	@ObfuscatedName("at")
	public synchronized int method2604() {
		return this.field1433 < 0 ? -this.field1433 : this.field1433;
	}

	@ObfuscatedName("ax")
	public boolean method2583() {
		return this.field1435 < 0 || this.field1435 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("aj")
	public boolean method2606() {
		return this.field1443 != 0;
	}

	@ObfuscatedName("ab")
	int method2568(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1443 > 0) {
				int var6 = var2 + this.field1443;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1443 += var2;
				if (this.field1433 == 256 && (this.field1435 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2546(0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, this.field1445, this.field1446, 0, var6, var3, this);
					} else {
						var2 = method2545(((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, this.field1444, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2550(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, this.field1445, this.field1446, 0, var6, var3, this, this.field1433, var5);
				} else {
					var2 = method2645(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, this.field1444, 0, var6, var3, this, this.field1433, var5);
				}

				this.field1443 -= var2;
				if (this.field1443 != 0) {
					return var2;
				}

				if (!this.method2526()) {
					continue;
				}

				return var4;
			}

			if (this.field1433 == 256 && (this.field1435 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2538(0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, 0, var4, var3, this);
				}

				return method2537(((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2623(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, 0, var4, var3, this, this.field1433, var5);
			}

			return method2631(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, 0, var4, var3, this, this.field1433, var5);
		}
	}

	@ObfuscatedName("ak")
	int method2544(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1443 > 0) {
				int var6 = var2 + this.field1443;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1443 += var2;
				if (this.field1433 == -256 && (this.field1435 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2535(0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, this.field1445, this.field1446, 0, var6, var3, this);
					} else {
						var2 = method2547(((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, this.field1444, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2552(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, this.field1445, this.field1446, 0, var6, var3, this, this.field1433, var5);
				} else {
					var2 = method2551(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, this.field1444, 0, var6, var3, this, this.field1433, var5);
				}

				this.field1443 -= var2;
				if (this.field1443 != 0) {
					return var2;
				}

				if (!this.method2526()) {
					continue;
				}

				return var4;
			}

			if (this.field1433 == -256 && (this.field1435 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2540(0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, 0, var4, var3, this);
				}

				return method2539(((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2564(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1437, this.field1432, 0, var4, var3, this, this.field1433, var5);
			}

			return method2543(0, 0, ((RawSound)super.sound).samples, var1, this.field1435, var2, this.field1436, 0, var4, var3, this, this.field1433, var5);
		}
	}

	@ObfuscatedName("ay")
	boolean method2526() {
		int var1 = this.field1434;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2647(var1, this.field1438);
			var3 = method2508(var1, this.field1438);
		}

		if (var1 == this.field1436 && var2 == this.field1437 && var3 == this.field1432) {
			if (this.field1434 == Integer.MIN_VALUE) {
				this.field1434 = 0;
				this.field1432 = 0;
				this.field1437 = 0;
				this.field1436 = 0;
				this.remove();
				return true;
			} else {
				this.method2512();
				return false;
			}
		} else {
			if (this.field1436 < var1) {
				this.field1444 = 1;
				this.field1443 = var1 - this.field1436;
			} else if (this.field1436 > var1) {
				this.field1444 = -1;
				this.field1443 = this.field1436 - var1;
			} else {
				this.field1444 = 0;
			}

			if (this.field1437 < var2) {
				this.field1445 = 1;
				if (this.field1443 == 0 || this.field1443 > var2 - this.field1437) {
					this.field1443 = var2 - this.field1437;
				}
			} else if (this.field1437 > var2) {
				this.field1445 = -1;
				if (this.field1443 == 0 || this.field1443 > this.field1437 - var2) {
					this.field1443 = this.field1437 - var2;
				}
			} else {
				this.field1445 = 0;
			}

			if (this.field1432 < var3) {
				this.field1446 = 1;
				if (this.field1443 == 0 || this.field1443 > var3 - this.field1432) {
					this.field1443 = var3 - this.field1432;
				}
			} else if (this.field1432 > var3) {
				this.field1446 = -1;
				if (this.field1443 == 0 || this.field1443 > this.field1432 - var3) {
					this.field1443 = this.field1432 - var3;
				}
			} else {
				this.field1446 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("ah")
	int vmethod2673() {
		int var1 = this.field1436 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1435 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("c")
	static int method2647(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("x")
	static int method2508(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lcg;II)Lda;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lcg;III)Lda;"
	)
	public static RawPcmStream method2511(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILda;)I"
	)
	static int method2537(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1435 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILda;)I"
	)
	static int method2538(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1435 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILda;)I"
	)
	static int method2539(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1435 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILda;)I"
	)
	static int method2540(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1435 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILda;II)I"
	)
	static int method2631(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1435 = var4;
		return var5;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILda;II)I"
	)
	static int method2623(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1435 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILda;II)I"
	)
	static int method2543(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1435 = var4;
		return var5;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILda;II)I"
	)
	static int method2564(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1435 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILda;)I"
	)
	static int method2545(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1437 += var9.field1445 * (var6 - var3);
		var9.field1432 += var9.field1446 * (var6 - var3);

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

		var9.field1436 = var4 >> 2;
		var9.field1435 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILda;)I"
	)
	static int method2546(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1436 += var12.field1444 * (var9 - var4);
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

		var12.field1437 = var5 >> 2;
		var12.field1432 = var6 >> 2;
		var12.field1435 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILda;)I"
	)
	static int method2547(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1437 += var9.field1445 * (var6 - var3);
		var9.field1432 += var9.field1446 * (var6 - var3);

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

		var9.field1436 = var4 >> 2;
		var9.field1435 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILda;)I"
	)
	static int method2535(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1436 += var12.field1444 * (var9 - var4);
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

		var12.field1437 = var5 >> 2;
		var12.field1432 = var6 >> 2;
		var12.field1435 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILda;II)I"
	)
	static int method2645(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1437 -= var11.field1445 * var5;
		var11.field1432 -= var11.field1446 * var5;
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

		var11.field1437 += var11.field1445 * var5;
		var11.field1432 += var11.field1446 * var5;
		var11.field1436 = var6;
		var11.field1435 = var4;
		return var5;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILda;II)I"
	)
	static int method2550(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1436 -= var5 * var13.field1444;
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
		var13.field1436 += var13.field1444 * var5;
		var13.field1437 = var6;
		var13.field1432 = var7;
		var13.field1435 = var4;
		return var5;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILda;II)I"
	)
	static int method2551(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1437 -= var11.field1445 * var5;
		var11.field1432 -= var11.field1446 * var5;
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

		var11.field1437 += var11.field1445 * var5;
		var11.field1432 += var11.field1446 * var5;
		var11.field1436 = var6;
		var11.field1435 = var4;
		return var5;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILda;II)I"
	)
	static int method2552(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1436 -= var5 * var13.field1444;
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
		var13.field1436 += var13.field1444 * var5;
		var13.field1437 = var6;
		var13.field1432 = var7;
		var13.field1435 = var4;
		return var5;
	}
}
