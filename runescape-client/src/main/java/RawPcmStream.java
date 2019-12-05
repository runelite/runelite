import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("u")
	int field1467;
	@ObfuscatedName("f")
	int field1457;
	@ObfuscatedName("b")
	int field1458;
	@ObfuscatedName("g")
	int field1459;
	@ObfuscatedName("z")
	int field1460;
	@ObfuscatedName("p")
	int field1470;
	@ObfuscatedName("h")
	int field1462;
	@ObfuscatedName("y")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("i")
	@Export("start")
	int start;
	@ObfuscatedName("k")
	@Export("end")
	int end;
	@ObfuscatedName("x")
	boolean field1466;
	@ObfuscatedName("o")
	int field1465;
	@ObfuscatedName("e")
	int field1456;
	@ObfuscatedName("n")
	int field1469;
	@ObfuscatedName("r")
	int field1468;

	@ObfuscatedSignature(
		signature = "(Lcw;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1466 = var1.field1378;
		this.field1457 = var2;
		this.field1458 = var3;
		this.field1459 = var4;
		this.field1467 = 0;
		this.method2569();
	}

	@ObfuscatedSignature(
		signature = "(Lcw;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1466 = var1.field1378;
		this.field1457 = var2;
		this.field1458 = var3;
		this.field1459 = 8192;
		this.field1467 = 0;
		this.method2569();
	}

	@ObfuscatedName("z")
	void method2569() {
		this.field1460 = this.field1458;
		this.field1470 = method2692(this.field1458, this.field1459);
		this.field1462 = method2566(this.field1458, this.field1459);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("y")
	protected int vmethod3963() {
		return this.field1458 == 0 && this.field1465 == 0 ? 0 : 1;
	}

	@ObfuscatedName("w")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1458 == 0 && this.field1465 == 0) {
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
			if (this.field1467 < 0) {
				if (this.field1457 <= 0) {
					this.method2579();
					this.remove();
					return;
				}

				this.field1467 = 0;
			}

			if (this.field1467 >= var7) {
				if (this.field1457 >= 0) {
					this.method2579();
					this.remove();
					return;
				}

				this.field1467 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1466) {
					if (this.field1457 < 0) {
						var9 = this.method2598(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1467 >= var5) {
							return;
						}

						this.field1467 = var5 + var5 - 1 - this.field1467;
						this.field1457 = -this.field1457;
					}

					while (true) {
						var9 = this.method2592(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1467 < var6) {
							return;
						}

						this.field1467 = var6 + var6 - 1 - this.field1467;
						this.field1457 = -this.field1457;
						var9 = this.method2598(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1467 >= var5) {
							return;
						}

						this.field1467 = var5 + var5 - 1 - this.field1467;
						this.field1457 = -this.field1457;
					}
				} else if (this.field1457 < 0) {
					while (true) {
						var9 = this.method2598(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1467 >= var5) {
							return;
						}

						this.field1467 = var6 - 1 - (var6 - 1 - this.field1467) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2592(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1467 < var6) {
							return;
						}

						this.field1467 = var5 + (this.field1467 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1466) {
						label130: {
							if (this.field1457 < 0) {
								var9 = this.method2598(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1467 >= var5) {
									return;
								}

								this.field1467 = var5 + var5 - 1 - this.field1467;
								this.field1457 = -this.field1457;
								if (--this.numLoops == 0) {
									break label130;
								}
							}

							do {
								var9 = this.method2592(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1467 < var6) {
									return;
								}

								this.field1467 = var6 + var6 - 1 - this.field1467;
								this.field1457 = -this.field1457;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2598(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1467 >= var5) {
									return;
								}

								this.field1467 = var5 + var5 - 1 - this.field1467;
								this.field1457 = -this.field1457;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1457 < 0) {
							while (true) {
								var9 = this.method2598(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1467 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1467) / var8;
								if (var10 >= this.numLoops) {
									this.field1467 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1467 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2592(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1467 < var6) {
									return;
								}

								var10 = (this.field1467 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1467 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1467 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1457 < 0) {
					this.method2598(var1, var9, 0, var3, 0);
					if (this.field1467 < 0) {
						this.field1467 = -1;
						this.method2579();
						this.remove();
					}
				} else {
					this.method2592(var1, var9, var7, var3, 0);
					if (this.field1467 >= var7) {
						this.field1467 = var7;
						this.method2579();
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

	@ObfuscatedName("k")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1465 > 0) {
			if (var1 >= this.field1465) {
				if (this.field1458 == Integer.MIN_VALUE) {
					this.field1458 = 0;
					this.field1462 = 0;
					this.field1470 = 0;
					this.field1460 = 0;
					this.remove();
					var1 = this.field1465;
				}

				this.field1465 = 0;
				this.method2569();
			} else {
				this.field1460 += this.field1456 * var1;
				this.field1470 += this.field1469 * var1;
				this.field1462 += this.field1468 * var1;
				this.field1465 -= var1;
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

		if (this.field1467 < 0) {
			if (this.field1457 <= 0) {
				this.method2579();
				this.remove();
				return;
			}

			this.field1467 = 0;
		}

		if (this.field1467 >= var5) {
			if (this.field1457 >= 0) {
				this.method2579();
				this.remove();
				return;
			}

			this.field1467 = var5 - 1;
		}

		this.field1467 += this.field1457 * var1;
		if (this.numLoops < 0) {
			if (!this.field1466) {
				if (this.field1457 < 0) {
					if (this.field1467 >= var3) {
						return;
					}

					this.field1467 = var4 - 1 - (var4 - 1 - this.field1467) % var6;
				} else {
					if (this.field1467 < var4) {
						return;
					}

					this.field1467 = var3 + (this.field1467 - var3) % var6;
				}

			} else {
				if (this.field1457 < 0) {
					if (this.field1467 >= var3) {
						return;
					}

					this.field1467 = var3 + var3 - 1 - this.field1467;
					this.field1457 = -this.field1457;
				}

				while (this.field1467 >= var4) {
					this.field1467 = var4 + var4 - 1 - this.field1467;
					this.field1457 = -this.field1457;
					if (this.field1467 >= var3) {
						return;
					}

					this.field1467 = var3 + var3 - 1 - this.field1467;
					this.field1457 = -this.field1457;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1466) {
					label125: {
						if (this.field1457 < 0) {
							if (this.field1467 >= var3) {
								return;
							}

							this.field1467 = var3 + var3 - 1 - this.field1467;
							this.field1457 = -this.field1457;
							if (--this.numLoops == 0) {
								break label125;
							}
						}

						do {
							if (this.field1467 < var4) {
								return;
							}

							this.field1467 = var4 + var4 - 1 - this.field1467;
							this.field1457 = -this.field1457;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1467 >= var3) {
								return;
							}

							this.field1467 = var3 + var3 - 1 - this.field1467;
							this.field1457 = -this.field1457;
						} while(--this.numLoops != 0);
					}
				} else {
					int var7;
					if (this.field1457 < 0) {
						if (this.field1467 >= var3) {
							return;
						}

						var7 = (var4 - 1 - this.field1467) / var6;
						if (var7 < this.numLoops) {
							this.field1467 += var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1467 += var6 * this.numLoops;
						this.numLoops = 0;
					} else {
						if (this.field1467 < var4) {
							return;
						}

						var7 = (this.field1467 - var3) / var6;
						if (var7 < this.numLoops) {
							this.field1467 -= var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1467 -= var6 * this.numLoops;
						this.numLoops = 0;
					}
				}
			}

			if (this.field1457 < 0) {
				if (this.field1467 < 0) {
					this.field1467 = -1;
					this.method2579();
					this.remove();
				}
			} else if (this.field1467 >= var5) {
				this.field1467 = var5;
				this.method2579();
				this.remove();
			}

		}
	}

	@ObfuscatedName("x")
	public synchronized void method2572(int var1) {
		this.method2574(var1 << 6, this.method2576());
	}

	@ObfuscatedName("o")
	synchronized void method2573(int var1) {
		this.method2574(var1, this.method2576());
	}

	@ObfuscatedName("e")
	synchronized void method2574(int var1, int var2) {
		this.field1458 = var1;
		this.field1459 = var2;
		this.field1465 = 0;
		this.method2569();
	}

	@ObfuscatedName("n")
	public synchronized int method2575() {
		return this.field1458 == Integer.MIN_VALUE ? 0 : this.field1458;
	}

	@ObfuscatedName("c")
	public synchronized int method2576() {
		return this.field1459 < 0 ? -1 : this.field1459;
	}

	@ObfuscatedName("s")
	public synchronized void method2722(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1467 = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2578() {
		this.field1457 = (this.field1457 ^ this.field1457 >> 31) + (this.field1457 >>> 31);
		this.field1457 = -this.field1457;
	}

	@ObfuscatedName("m")
	void method2579() {
		if (this.field1465 != 0) {
			if (this.field1458 == Integer.MIN_VALUE) {
				this.field1458 = 0;
			}

			this.field1465 = 0;
			this.method2569();
		}

	}

	@ObfuscatedName("v")
	public synchronized void method2580(int var1, int var2) {
		this.method2581(var1, var2, this.method2576());
	}

	@ObfuscatedName("q")
	public synchronized void method2581(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2574(var2, var3);
		} else {
			int var4 = method2692(var2, var3);
			int var5 = method2566(var2, var3);
			if (var4 == this.field1470 && var5 == this.field1462) {
				this.field1465 = 0;
			} else {
				int var6 = var2 - this.field1460;
				if (this.field1460 - var2 > var6) {
					var6 = this.field1460 - var2;
				}

				if (var4 - this.field1470 > var6) {
					var6 = var4 - this.field1470;
				}

				if (this.field1470 - var4 > var6) {
					var6 = this.field1470 - var4;
				}

				if (var5 - this.field1462 > var6) {
					var6 = var5 - this.field1462;
				}

				if (this.field1462 - var5 > var6) {
					var6 = this.field1462 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1465 = var1;
				this.field1458 = var2;
				this.field1459 = var3;
				this.field1456 = (var2 - this.field1460) / var1;
				this.field1469 = (var4 - this.field1470) / var1;
				this.field1468 = (var5 - this.field1462) / var1;
			}
		}
	}

	@ObfuscatedName("l")
	public synchronized void method2582(int var1) {
		if (var1 == 0) {
			this.method2573(0);
			this.remove();
		} else if (this.field1470 == 0 && this.field1462 == 0) {
			this.field1465 = 0;
			this.field1458 = 0;
			this.field1460 = 0;
			this.remove();
		} else {
			int var2 = -this.field1460;
			if (this.field1460 > var2) {
				var2 = this.field1460;
			}

			if (-this.field1470 > var2) {
				var2 = -this.field1470;
			}

			if (this.field1470 > var2) {
				var2 = this.field1470;
			}

			if (-this.field1462 > var2) {
				var2 = -this.field1462;
			}

			if (this.field1462 > var2) {
				var2 = this.field1462;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1465 = var1;
			this.field1458 = Integer.MIN_VALUE;
			this.field1456 = -this.field1460 / var1;
			this.field1469 = -this.field1470 / var1;
			this.field1468 = -this.field1462 / var1;
		}
	}

	@ObfuscatedName("aa")
	public synchronized void method2679(int var1) {
		if (this.field1457 < 0) {
			this.field1457 = -var1;
		} else {
			this.field1457 = var1;
		}

	}

	@ObfuscatedName("ab")
	public synchronized int method2701() {
		return this.field1457 < 0 ? -this.field1457 : this.field1457;
	}

	@ObfuscatedName("ar")
	public boolean method2585() {
		return this.field1467 < 0 || this.field1467 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ac")
	public boolean method2686() {
		return this.field1465 != 0;
	}

	@ObfuscatedName("az")
	int method2592(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1465 > 0) {
				int var6 = var2 + this.field1465;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1465 += var2;
				if (this.field1457 == 256 && (this.field1467 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2673(0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, this.field1469, this.field1468, 0, var6, var3, this);
					} else {
						var2 = method2603(((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, this.field1456, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2604(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, this.field1469, this.field1468, 0, var6, var3, this, this.field1457, var5);
				} else {
					var2 = method2607(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, this.field1456, 0, var6, var3, this, this.field1457, var5);
				}

				this.field1465 -= var2;
				if (this.field1465 != 0) {
					return var2;
				}

				if (!this.method2594()) {
					continue;
				}

				return var4;
			}

			if (this.field1457 == 256 && (this.field1467 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2596(0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, 0, var4, var3, this);
				}

				return method2640(((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2600(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, 0, var4, var3, this, this.field1457, var5);
			}

			return method2599(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, 0, var4, var3, this, this.field1457, var5);
		}
	}

	@ObfuscatedName("at")
	int vmethod2741() {
		int var1 = this.field1460 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1467 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("ae")
	int method2598(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1465 > 0) {
				int var6 = var2 + this.field1465;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1465 += var2;
				if (this.field1457 == -256 && (this.field1467 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2606(0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, this.field1469, this.field1468, 0, var6, var3, this);
					} else {
						var2 = method2605(((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, this.field1456, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2610(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, this.field1469, this.field1468, 0, var6, var3, this, this.field1457, var5);
				} else {
					var2 = method2705(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, this.field1456, 0, var6, var3, this, this.field1457, var5);
				}

				this.field1465 -= var2;
				if (this.field1465 != 0) {
					return var2;
				}

				if (!this.method2594()) {
					continue;
				}

				return var4;
			}

			if (this.field1457 == -256 && (this.field1467 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2624(0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, 0, var4, var3, this);
				}

				return method2597(((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2650(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1470, this.field1462, 0, var4, var3, this, this.field1457, var5);
			}

			return method2612(0, 0, ((RawSound)super.sound).samples, var1, this.field1467, var2, this.field1460, 0, var4, var3, this, this.field1457, var5);
		}
	}

	@ObfuscatedName("aj")
	boolean method2594() {
		int var1 = this.field1458;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2692(var1, this.field1459);
			var3 = method2566(var1, this.field1459);
		}

		if (var1 == this.field1460 && var2 == this.field1470 && var3 == this.field1462) {
			if (this.field1458 == Integer.MIN_VALUE) {
				this.field1458 = 0;
				this.field1462 = 0;
				this.field1470 = 0;
				this.field1460 = 0;
				this.remove();
				return true;
			} else {
				this.method2569();
				return false;
			}
		} else {
			if (this.field1460 < var1) {
				this.field1456 = 1;
				this.field1465 = var1 - this.field1460;
			} else if (this.field1460 > var1) {
				this.field1456 = -1;
				this.field1465 = this.field1460 - var1;
			} else {
				this.field1456 = 0;
			}

			if (this.field1470 < var2) {
				this.field1469 = 1;
				if (this.field1465 == 0 || this.field1465 > var2 - this.field1470) {
					this.field1465 = var2 - this.field1470;
				}
			} else if (this.field1470 > var2) {
				this.field1469 = -1;
				if (this.field1465 == 0 || this.field1465 > this.field1470 - var2) {
					this.field1465 = this.field1470 - var2;
				}
			} else {
				this.field1469 = 0;
			}

			if (this.field1462 < var3) {
				this.field1468 = 1;
				if (this.field1465 == 0 || this.field1465 > var3 - this.field1462) {
					this.field1465 = var3 - this.field1462;
				}
			} else if (this.field1462 > var3) {
				this.field1468 = -1;
				if (this.field1465 == 0 || this.field1465 > this.field1462 - var3) {
					this.field1465 = this.field1462 - var3;
				}
			} else {
				this.field1468 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("u")
	static int method2692(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("f")
	static int method2566(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lcw;II)Lds;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(Messages.PcmPlayer_sampleRate * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lcw;III)Lds;"
	)
	public static RawPcmStream method2568(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILds;)I"
	)
	static int method2640(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1467 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILds;)I"
	)
	static int method2596(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1467 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILds;)I"
	)
	static int method2597(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1467 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILds;)I"
	)
	static int method2624(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1467 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILds;II)I"
	)
	static int method2599(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1467 = var4;
		return var5;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2600(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1467 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILds;II)I"
	)
	static int method2612(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1467 = var4;
		return var5;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2650(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1467 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILds;)I"
	)
	static int method2603(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1470 += var9.field1469 * (var6 - var3);
		var9.field1462 += var9.field1468 * (var6 - var3);

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

		var9.field1460 = var4 >> 2;
		var9.field1467 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILds;)I"
	)
	static int method2673(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1460 += var12.field1456 * (var9 - var4);
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

		var12.field1470 = var5 >> 2;
		var12.field1462 = var6 >> 2;
		var12.field1467 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILds;)I"
	)
	static int method2605(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1470 += var9.field1469 * (var6 - var3);
		var9.field1462 += var9.field1468 * (var6 - var3);

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

		var9.field1460 = var4 >> 2;
		var9.field1467 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILds;)I"
	)
	static int method2606(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1460 += var12.field1456 * (var9 - var4);
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

		var12.field1470 = var5 >> 2;
		var12.field1462 = var6 >> 2;
		var12.field1467 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2607(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1470 -= var11.field1469 * var5;
		var11.field1462 -= var11.field1468 * var5;
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

		var11.field1470 += var11.field1469 * var5;
		var11.field1462 += var11.field1468 * var5;
		var11.field1460 = var6;
		var11.field1467 = var4;
		return var5;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILds;II)I"
	)
	static int method2604(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1460 -= var5 * var13.field1456;
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
		var13.field1460 += var13.field1456 * var5;
		var13.field1470 = var6;
		var13.field1462 = var7;
		var13.field1467 = var4;
		return var5;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILds;II)I"
	)
	static int method2705(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1470 -= var11.field1469 * var5;
		var11.field1462 -= var11.field1468 * var5;
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

		var11.field1470 += var11.field1469 * var5;
		var11.field1462 += var11.field1468 * var5;
		var11.field1460 = var6;
		var11.field1467 = var4;
		return var5;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILds;II)I"
	)
	static int method2610(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1460 -= var5 * var13.field1456;
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
		var13.field1460 += var13.field1456 * var5;
		var13.field1470 = var6;
		var13.field1462 = var7;
		var13.field1467 = var4;
		return var5;
	}
}
