import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("q")
	int field1471;
	@ObfuscatedName("e")
	int field1469;
	@ObfuscatedName("p")
	int field1470;
	@ObfuscatedName("k")
	int field1475;
	@ObfuscatedName("l")
	int field1472;
	@ObfuscatedName("b")
	int field1482;
	@ObfuscatedName("i")
	int field1474;
	@ObfuscatedName("c")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("f")
	@Export("start")
	int start;
	@ObfuscatedName("m")
	@Export("end")
	int end;
	@ObfuscatedName("u")
	boolean field1478;
	@ObfuscatedName("x")
	int field1479;
	@ObfuscatedName("r")
	int field1480;
	@ObfuscatedName("v")
	int field1481;
	@ObfuscatedName("y")
	int field1468;

	@ObfuscatedSignature(
		signature = "(Lcd;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1478 = var1.field1393;
		this.field1469 = var2;
		this.field1470 = var3;
		this.field1475 = var4;
		this.field1471 = 0;
		this.method2525();
	}

	@ObfuscatedSignature(
		signature = "(Lcd;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1478 = var1.field1393;
		this.field1469 = var2;
		this.field1470 = var3;
		this.field1475 = 8192;
		this.field1471 = 0;
		this.method2525();
	}

	@ObfuscatedName("k")
	void method2525() {
		this.field1472 = this.field1470;
		this.field1482 = method2526(this.field1470, this.field1475);
		this.field1474 = method2519(this.field1470, this.field1475);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("i")
	protected int vmethod3892() {
		return this.field1470 == 0 && this.field1479 == 0 ? 0 : 1;
	}

	@ObfuscatedName("c")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1470 == 0 && this.field1479 == 0) {
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
			if (this.field1471 < 0) {
				if (this.field1469 <= 0) {
					this.method2647();
					this.remove();
					return;
				}

				this.field1471 = 0;
			}

			if (this.field1471 >= var7) {
				if (this.field1469 >= 0) {
					this.method2647();
					this.remove();
					return;
				}

				this.field1471 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1478) {
					if (this.field1469 < 0) {
						var9 = this.method2641(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1471 >= var5) {
							return;
						}

						this.field1471 = var5 + var5 - 1 - this.field1471;
						this.field1469 = -this.field1469;
					}

					while (true) {
						var9 = this.method2543(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1471 < var6) {
							return;
						}

						this.field1471 = var6 + var6 - 1 - this.field1471;
						this.field1469 = -this.field1469;
						var9 = this.method2641(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1471 >= var5) {
							return;
						}

						this.field1471 = var5 + var5 - 1 - this.field1471;
						this.field1469 = -this.field1469;
					}
				} else if (this.field1469 < 0) {
					while (true) {
						var9 = this.method2641(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1471 >= var5) {
							return;
						}

						this.field1471 = var6 - 1 - (var6 - 1 - this.field1471) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2543(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1471 < var6) {
							return;
						}

						this.field1471 = var5 + (this.field1471 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1478) {
						label119: {
							if (this.field1469 < 0) {
								var9 = this.method2641(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1471 >= var5) {
									return;
								}

								this.field1471 = var5 + var5 - 1 - this.field1471;
								this.field1469 = -this.field1469;
								if (--this.numLoops == 0) {
									break label119;
								}
							}

							do {
								var9 = this.method2543(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1471 < var6) {
									return;
								}

								this.field1471 = var6 + var6 - 1 - this.field1471;
								this.field1469 = -this.field1469;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2641(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1471 >= var5) {
									return;
								}

								this.field1471 = var5 + var5 - 1 - this.field1471;
								this.field1469 = -this.field1469;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1469 < 0) {
							while (true) {
								var9 = this.method2641(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1471 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1471) / var8;
								if (var10 >= this.numLoops) {
									this.field1471 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1471 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2543(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1471 < var6) {
									return;
								}

								var10 = (this.field1471 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1471 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1471 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1469 < 0) {
					this.method2641(var1, var9, 0, var3, 0);
					if (this.field1471 < 0) {
						this.field1471 = -1;
						this.method2647();
						this.remove();
					}
				} else {
					this.method2543(var1, var9, var7, var3, 0);
					if (this.field1471 >= var7) {
						this.field1471 = var7;
						this.method2647();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("u")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("x")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1479 > 0) {
			if (var1 >= this.field1479) {
				if (this.field1470 == Integer.MIN_VALUE) {
					this.field1470 = 0;
					this.field1474 = 0;
					this.field1482 = 0;
					this.field1472 = 0;
					this.remove();
					var1 = this.field1479;
				}

				this.field1479 = 0;
				this.method2525();
			} else {
				this.field1472 += this.field1480 * var1;
				this.field1482 += this.field1481 * var1;
				this.field1474 += this.field1468 * var1;
				this.field1479 -= var1;
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

		if (this.field1471 < 0) {
			if (this.field1469 <= 0) {
				this.method2647();
				this.remove();
				return;
			}

			this.field1471 = 0;
		}

		if (this.field1471 >= var5) {
			if (this.field1469 >= 0) {
				this.method2647();
				this.remove();
				return;
			}

			this.field1471 = var5 - 1;
		}

		this.field1471 += this.field1469 * var1;
		if (this.numLoops < 0) {
			if (!this.field1478) {
				if (this.field1469 < 0) {
					if (this.field1471 >= var3) {
						return;
					}

					this.field1471 = var4 - 1 - (var4 - 1 - this.field1471) % var6;
				} else {
					if (this.field1471 < var4) {
						return;
					}

					this.field1471 = var3 + (this.field1471 - var3) % var6;
				}

			} else {
				if (this.field1469 < 0) {
					if (this.field1471 >= var3) {
						return;
					}

					this.field1471 = var3 + var3 - 1 - this.field1471;
					this.field1469 = -this.field1469;
				}

				while (this.field1471 >= var4) {
					this.field1471 = var4 + var4 - 1 - this.field1471;
					this.field1469 = -this.field1469;
					if (this.field1471 >= var3) {
						return;
					}

					this.field1471 = var3 + var3 - 1 - this.field1471;
					this.field1469 = -this.field1469;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1478) {
					label127: {
						if (this.field1469 < 0) {
							if (this.field1471 >= var3) {
								return;
							}

							this.field1471 = var3 + var3 - 1 - this.field1471;
							this.field1469 = -this.field1469;
							if (--this.numLoops == 0) {
								break label127;
							}
						}

						do {
							if (this.field1471 < var4) {
								return;
							}

							this.field1471 = var4 + var4 - 1 - this.field1471;
							this.field1469 = -this.field1469;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1471 >= var3) {
								return;
							}

							this.field1471 = var3 + var3 - 1 - this.field1471;
							this.field1469 = -this.field1469;
						} while(--this.numLoops != 0);
					}
				} else {
					int var7;
					if (this.field1469 < 0) {
						if (this.field1471 >= var3) {
							return;
						}

						var7 = (var4 - 1 - this.field1471) / var6;
						if (var7 < this.numLoops) {
							this.field1471 += var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1471 += var6 * this.numLoops;
						this.numLoops = 0;
					} else {
						if (this.field1471 < var4) {
							return;
						}

						var7 = (this.field1471 - var3) / var6;
						if (var7 < this.numLoops) {
							this.field1471 -= var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1471 -= var6 * this.numLoops;
						this.numLoops = 0;
					}
				}
			}

			if (this.field1469 < 0) {
				if (this.field1471 < 0) {
					this.field1471 = -1;
					this.method2647();
					this.remove();
				}
			} else if (this.field1471 >= var5) {
				this.field1471 = var5;
				this.method2647();
				this.remove();
			}

		}
	}

	@ObfuscatedName("r")
	public synchronized void method2527(int var1) {
		this.method2600(var1 << 6, this.method2541());
	}

	@ObfuscatedName("v")
	synchronized void method2607(int var1) {
		this.method2600(var1, this.method2541());
	}

	@ObfuscatedName("y")
	synchronized void method2600(int var1, int var2) {
		this.field1470 = var1;
		this.field1475 = var2;
		this.field1479 = 0;
		this.method2525();
	}

	@ObfuscatedName("g")
	public synchronized int method2531() {
		return this.field1470 == Integer.MIN_VALUE ? 0 : this.field1470;
	}

	@ObfuscatedName("a")
	public synchronized int method2541() {
		return this.field1475 < 0 ? -1 : this.field1475;
	}

	@ObfuscatedName("j")
	public synchronized void method2596(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1471 = var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2614() {
		this.field1469 = (this.field1469 ^ this.field1469 >> 31) + (this.field1469 >>> 31);
		this.field1469 = -this.field1469;
	}

	@ObfuscatedName("d")
	void method2647() {
		if (this.field1479 != 0) {
			if (this.field1470 == Integer.MIN_VALUE) {
				this.field1470 = 0;
			}

			this.field1479 = 0;
			this.method2525();
		}

	}

	@ObfuscatedName("s")
	public synchronized void method2535(int var1, int var2) {
		this.method2536(var1, var2, this.method2541());
	}

	@ObfuscatedName("z")
	public synchronized void method2536(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2600(var2, var3);
		} else {
			int var4 = method2526(var2, var3);
			int var5 = method2519(var2, var3);
			if (var4 == this.field1482 && var5 == this.field1474) {
				this.field1479 = 0;
			} else {
				int var6 = var2 - this.field1472;
				if (this.field1472 - var2 > var6) {
					var6 = this.field1472 - var2;
				}

				if (var4 - this.field1482 > var6) {
					var6 = var4 - this.field1482;
				}

				if (this.field1482 - var4 > var6) {
					var6 = this.field1482 - var4;
				}

				if (var5 - this.field1474 > var6) {
					var6 = var5 - this.field1474;
				}

				if (this.field1474 - var5 > var6) {
					var6 = this.field1474 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1479 = var1;
				this.field1470 = var2;
				this.field1475 = var3;
				this.field1480 = (var2 - this.field1472) / var1;
				this.field1481 = (var4 - this.field1482) / var1;
				this.field1468 = (var5 - this.field1474) / var1;
			}
		}
	}

	@ObfuscatedName("al")
	public synchronized void method2540(int var1) {
		if (var1 == 0) {
			this.method2607(0);
			this.remove();
		} else if (this.field1482 == 0 && this.field1474 == 0) {
			this.field1479 = 0;
			this.field1470 = 0;
			this.field1472 = 0;
			this.remove();
		} else {
			int var2 = -this.field1472;
			if (this.field1472 > var2) {
				var2 = this.field1472;
			}

			if (-this.field1482 > var2) {
				var2 = -this.field1482;
			}

			if (this.field1482 > var2) {
				var2 = this.field1482;
			}

			if (-this.field1474 > var2) {
				var2 = -this.field1474;
			}

			if (this.field1474 > var2) {
				var2 = this.field1474;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1479 = var1;
			this.field1470 = Integer.MIN_VALUE;
			this.field1480 = -this.field1472 / var1;
			this.field1481 = -this.field1482 / var1;
			this.field1468 = -this.field1474 / var1;
		}
	}

	@ObfuscatedName("av")
	public synchronized void method2538(int var1) {
		if (this.field1469 < 0) {
			this.field1469 = -var1;
		} else {
			this.field1469 = var1;
		}

	}

	@ObfuscatedName("as")
	public synchronized int method2539() {
		return this.field1469 < 0 ? -this.field1469 : this.field1469;
	}

	@ObfuscatedName("aw")
	public boolean method2558() {
		return this.field1471 < 0 || this.field1471 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ad")
	public boolean method2585() {
		return this.field1479 != 0;
	}

	@ObfuscatedName("ag")
	int method2543(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1479 > 0) {
				int var6 = var2 + this.field1479;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1479 += var2;
				if (this.field1469 == 256 && (this.field1471 & 255) == 0) {
					if (class169.isStereo) {
						var2 = method2559(0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, this.field1481, this.field1468, 0, var6, var3, this);
					} else {
						var2 = method2586(((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, this.field1480, 0, var6, var3, this);
					}
				} else if (class169.isStereo) {
					var2 = method2627(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, this.field1481, this.field1468, 0, var6, var3, this, this.field1469, var5);
				} else {
					var2 = method2633(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, this.field1480, 0, var6, var3, this, this.field1469, var5);
				}

				this.field1479 -= var2;
				if (this.field1479 != 0) {
					return var2;
				}

				if (!this.method2530()) {
					continue;
				}

				return var4;
			}

			if (this.field1469 == 256 && (this.field1471 & 255) == 0) {
				if (class169.isStereo) {
					return method2551(0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, 0, var4, var3, this);
				}

				return method2550(((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, 0, var4, var3, this);
			}

			if (class169.isStereo) {
				return method2555(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, 0, var4, var3, this, this.field1469, var5);
			}

			return method2554(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, 0, var4, var3, this, this.field1469, var5);
		}
	}

	@ObfuscatedName("ar")
	int method2641(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1479 > 0) {
				int var6 = var2 + this.field1479;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1479 += var2;
				if (this.field1469 == -256 && (this.field1471 & 255) == 0) {
					if (class169.isStereo) {
						var2 = method2561(0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, this.field1481, this.field1468, 0, var6, var3, this);
					} else {
						var2 = method2560(((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, this.field1480, 0, var6, var3, this);
					}
				} else if (class169.isStereo) {
					var2 = method2605(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, this.field1481, this.field1468, 0, var6, var3, this, this.field1469, var5);
				} else {
					var2 = method2569(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, this.field1480, 0, var6, var3, this, this.field1469, var5);
				}

				this.field1479 -= var2;
				if (this.field1479 != 0) {
					return var2;
				}

				if (!this.method2530()) {
					continue;
				}

				return var4;
			}

			if (this.field1469 == -256 && (this.field1471 & 255) == 0) {
				if (class169.isStereo) {
					return method2553(0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, 0, var4, var3, this);
				}

				return method2594(((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, 0, var4, var3, this);
			}

			if (class169.isStereo) {
				return method2557(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1482, this.field1474, 0, var4, var3, this, this.field1469, var5);
			}

			return method2556(0, 0, ((RawSound)super.sound).samples, var1, this.field1471, var2, this.field1472, 0, var4, var3, this, this.field1469, var5);
		}
	}

	@ObfuscatedName("ax")
	boolean method2530() {
		int var1 = this.field1470;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2526(var1, this.field1475);
			var3 = method2519(var1, this.field1475);
		}

		if (var1 == this.field1472 && var2 == this.field1482 && var3 == this.field1474) {
			if (this.field1470 == Integer.MIN_VALUE) {
				this.field1470 = 0;
				this.field1474 = 0;
				this.field1482 = 0;
				this.field1472 = 0;
				this.remove();
				return true;
			} else {
				this.method2525();
				return false;
			}
		} else {
			if (this.field1472 < var1) {
				this.field1480 = 1;
				this.field1479 = var1 - this.field1472;
			} else if (this.field1472 > var1) {
				this.field1480 = -1;
				this.field1479 = this.field1472 - var1;
			} else {
				this.field1480 = 0;
			}

			if (this.field1482 < var2) {
				this.field1481 = 1;
				if (this.field1479 == 0 || this.field1479 > var2 - this.field1482) {
					this.field1479 = var2 - this.field1482;
				}
			} else if (this.field1482 > var2) {
				this.field1481 = -1;
				if (this.field1479 == 0 || this.field1479 > this.field1482 - var2) {
					this.field1479 = this.field1482 - var2;
				}
			} else {
				this.field1481 = 0;
			}

			if (this.field1474 < var3) {
				this.field1468 = 1;
				if (this.field1479 == 0 || this.field1479 > var3 - this.field1474) {
					this.field1479 = var3 - this.field1474;
				}
			} else if (this.field1474 > var3) {
				this.field1468 = -1;
				if (this.field1479 == 0 || this.field1479 > this.field1474 - var3) {
					this.field1479 = this.field1474 - var3;
				}
			} else {
				this.field1468 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("ay")
	int vmethod2689() {
		int var1 = this.field1472 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1471 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("q")
	static int method2526(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("w")
	static int method2519(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lcd;II)Ldh;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(CollisionMap.PcmPlayer_sampleRate * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lcd;III)Ldh;"
	)
	public static RawPcmStream method2524(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdh;)I"
	)
	static int method2550(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1471 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdh;)I"
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

		var10.field1471 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdh;)I"
	)
	static int method2594(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1471 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdh;)I"
	)
	static int method2553(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1471 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdh;II)I"
	)
	static int method2554(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1471 = var4;
		return var5;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdh;II)I"
	)
	static int method2555(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1471 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdh;II)I"
	)
	static int method2556(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1471 = var4;
		return var5;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdh;II)I"
	)
	static int method2557(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1471 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdh;)I"
	)
	static int method2586(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1482 += var9.field1481 * (var6 - var3);
		var9.field1474 += var9.field1468 * (var6 - var3);

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

		var9.field1472 = var4 >> 2;
		var9.field1471 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdh;)I"
	)
	static int method2559(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1472 += var12.field1480 * (var9 - var4);
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

		var12.field1482 = var5 >> 2;
		var12.field1474 = var6 >> 2;
		var12.field1471 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdh;)I"
	)
	static int method2560(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1482 += var9.field1481 * (var6 - var3);
		var9.field1474 += var9.field1468 * (var6 - var3);

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

		var9.field1472 = var4 >> 2;
		var9.field1471 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdh;)I"
	)
	static int method2561(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1472 += var12.field1480 * (var9 - var4);
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

		var12.field1482 = var5 >> 2;
		var12.field1474 = var6 >> 2;
		var12.field1471 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdh;II)I"
	)
	static int method2633(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1482 -= var11.field1481 * var5;
		var11.field1474 -= var11.field1468 * var5;
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

		var11.field1482 += var11.field1481 * var5;
		var11.field1474 += var11.field1468 * var5;
		var11.field1472 = var6;
		var11.field1471 = var4;
		return var5;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdh;II)I"
	)
	static int method2627(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1472 -= var5 * var13.field1480;
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
		var13.field1472 += var13.field1480 * var5;
		var13.field1482 = var6;
		var13.field1474 = var7;
		var13.field1471 = var4;
		return var5;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdh;II)I"
	)
	static int method2569(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1482 -= var11.field1481 * var5;
		var11.field1474 -= var11.field1468 * var5;
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

		var11.field1482 += var11.field1481 * var5;
		var11.field1474 += var11.field1468 * var5;
		var11.field1472 = var6;
		var11.field1471 = var4;
		return var5;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdh;II)I"
	)
	static int method2605(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1472 -= var5 * var13.field1480;
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
		var13.field1472 += var13.field1480 * var5;
		var13.field1482 = var6;
		var13.field1474 = var7;
		var13.field1471 = var4;
		return var5;
	}
}
