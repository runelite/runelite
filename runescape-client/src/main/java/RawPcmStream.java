import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("f")
	int field1428;
	@ObfuscatedName("i")
	int field1426;
	@ObfuscatedName("y")
	int field1427;
	@ObfuscatedName("p")
	int field1432;
	@ObfuscatedName("b")
	int field1429;
	@ObfuscatedName("e")
	int field1430;
	@ObfuscatedName("x")
	int field1431;
	@ObfuscatedName("a")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("d")
	@Export("start")
	int start;
	@ObfuscatedName("c")
	@Export("end")
	int end;
	@ObfuscatedName("o")
	boolean field1435;
	@ObfuscatedName("v")
	int field1437;
	@ObfuscatedName("k")
	int field1436;
	@ObfuscatedName("s")
	int field1438;
	@ObfuscatedName("l")
	int field1439;

	@ObfuscatedSignature(
		signature = "(Lcc;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1435 = var1.field1352;
		this.field1426 = var2;
		this.field1427 = var3;
		this.field1432 = var4;
		this.field1428 = 0;
		this.method2543();
	}

	@ObfuscatedSignature(
		signature = "(Lcc;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1435 = var1.field1352;
		this.field1426 = var2;
		this.field1427 = var3;
		this.field1432 = 8192;
		this.field1428 = 0;
		this.method2543();
	}

	@ObfuscatedName("p")
	void method2543() {
		this.field1429 = this.field1427;
		this.field1430 = method2552(this.field1427, this.field1432);
		this.field1431 = method2693(this.field1427, this.field1432);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("x")
	protected int vmethod3889() {
		return this.field1427 == 0 && this.field1437 == 0 ? 0 : 1;
	}

	@ObfuscatedName("a")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field1427 == 0 && this.field1437 == 0) {
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
			if (this.field1428 < 0) {
				if (this.field1426 <= 0) {
					this.method2679();
					this.remove();
					return;
				}

				this.field1428 = 0;
			}

			if (this.field1428 >= var7) {
				if (this.field1426 >= 0) {
					this.method2679();
					this.remove();
					return;
				}

				this.field1428 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1435) {
					if (this.field1426 < 0) {
						var9 = this.method2570(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1428 >= var5) {
							return;
						}

						this.field1428 = var5 + var5 - 1 - this.field1428;
						this.field1426 = -this.field1426;
					}

					while (true) {
						var9 = this.method2569(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1428 < var6) {
							return;
						}

						this.field1428 = var6 + var6 - 1 - this.field1428;
						this.field1426 = -this.field1426;
						var9 = this.method2570(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1428 >= var5) {
							return;
						}

						this.field1428 = var5 + var5 - 1 - this.field1428;
						this.field1426 = -this.field1426;
					}
				} else if (this.field1426 < 0) {
					while (true) {
						var9 = this.method2570(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1428 >= var5) {
							return;
						}

						this.field1428 = var6 - 1 - (var6 - 1 - this.field1428) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2569(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1428 < var6) {
							return;
						}

						this.field1428 = var5 + (this.field1428 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1435) {
						label122: {
							if (this.field1426 < 0) {
								var9 = this.method2570(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1428 >= var5) {
									return;
								}

								this.field1428 = var5 + var5 - 1 - this.field1428;
								this.field1426 = -this.field1426;
								if (--this.numLoops == 0) {
									break label122;
								}
							}

							do {
								var9 = this.method2569(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1428 < var6) {
									return;
								}

								this.field1428 = var6 + var6 - 1 - this.field1428;
								this.field1426 = -this.field1426;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2570(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1428 >= var5) {
									return;
								}

								this.field1428 = var5 + var5 - 1 - this.field1428;
								this.field1426 = -this.field1426;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1426 < 0) {
							while (true) {
								var9 = this.method2570(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1428 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1428) / var8;
								if (var10 >= this.numLoops) {
									this.field1428 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1428 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2569(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1428 < var6) {
									return;
								}

								var10 = (this.field1428 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1428 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1428 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1426 < 0) {
					this.method2570(var1, var9, 0, var3, 0);
					if (this.field1428 < 0) {
						this.field1428 = -1;
						this.method2679();
						this.remove();
					}
				} else {
					this.method2569(var1, var9, var7, var3, 0);
					if (this.field1428 >= var7) {
						this.field1428 = var7;
						this.method2679();
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

	@ObfuscatedName("c")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field1437 > 0) {
			if (var1 >= this.field1437) {
				if (this.field1427 == Integer.MIN_VALUE) {
					this.field1427 = 0;
					this.field1431 = 0;
					this.field1430 = 0;
					this.field1429 = 0;
					this.remove();
					var1 = this.field1437;
				}

				this.field1437 = 0;
				this.method2543();
			} else {
				this.field1429 += this.field1436 * var1;
				this.field1430 += this.field1438 * var1;
				this.field1431 += this.field1439 * var1;
				this.field1437 -= var1;
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

		if (this.field1428 < 0) {
			if (this.field1426 <= 0) {
				this.method2679();
				this.remove();
				return;
			}

			this.field1428 = 0;
		}

		if (this.field1428 >= var5) {
			if (this.field1426 >= 0) {
				this.method2679();
				this.remove();
				return;
			}

			this.field1428 = var5 - 1;
		}

		this.field1428 += this.field1426 * var1;
		if (this.numLoops < 0) {
			if (!this.field1435) {
				if (this.field1426 < 0) {
					if (this.field1428 >= var3) {
						return;
					}

					this.field1428 = var4 - 1 - (var4 - 1 - this.field1428) % var6;
				} else {
					if (this.field1428 < var4) {
						return;
					}

					this.field1428 = var3 + (this.field1428 - var3) % var6;
				}

			} else {
				if (this.field1426 < 0) {
					if (this.field1428 >= var3) {
						return;
					}

					this.field1428 = var3 + var3 - 1 - this.field1428;
					this.field1426 = -this.field1426;
				}

				while (this.field1428 >= var4) {
					this.field1428 = var4 + var4 - 1 - this.field1428;
					this.field1426 = -this.field1426;
					if (this.field1428 >= var3) {
						return;
					}

					this.field1428 = var3 + var3 - 1 - this.field1428;
					this.field1426 = -this.field1426;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1435) {
					label124: {
						if (this.field1426 < 0) {
							if (this.field1428 >= var3) {
								return;
							}

							this.field1428 = var3 + var3 - 1 - this.field1428;
							this.field1426 = -this.field1426;
							if (--this.numLoops == 0) {
								break label124;
							}
						}

						do {
							if (this.field1428 < var4) {
								return;
							}

							this.field1428 = var4 + var4 - 1 - this.field1428;
							this.field1426 = -this.field1426;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1428 >= var3) {
								return;
							}

							this.field1428 = var3 + var3 - 1 - this.field1428;
							this.field1426 = -this.field1426;
						} while(--this.numLoops != 0);
					}
				} else {
					label156: {
						int var7;
						if (this.field1426 < 0) {
							if (this.field1428 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field1428) / var6;
							if (var7 >= this.numLoops) {
								this.field1428 += var6 * this.numLoops;
								this.numLoops = 0;
								break label156;
							}

							this.field1428 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field1428 < var4) {
								return;
							}

							var7 = (this.field1428 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field1428 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label156;
							}

							this.field1428 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field1426 < 0) {
				if (this.field1428 < 0) {
					this.field1428 = -1;
					this.method2679();
					this.remove();
				}
			} else if (this.field1428 >= var5) {
				this.field1428 = var5;
				this.method2679();
				this.remove();
			}

		}
	}

	@ObfuscatedName("o")
	public synchronized void method2578(int var1) {
		this.method2551(var1 << 6, this.method2553());
	}

	@ObfuscatedName("l")
	synchronized void method2550(int var1) {
		this.method2551(var1, this.method2553());
	}

	@ObfuscatedName("t")
	synchronized void method2551(int var1, int var2) {
		this.field1427 = var1;
		this.field1432 = var2;
		this.field1437 = 0;
		this.method2543();
	}

	@ObfuscatedName("j")
	public synchronized int method2609() {
		return this.field1427 == Integer.MIN_VALUE ? 0 : this.field1427;
	}

	@ObfuscatedName("n")
	public synchronized int method2553() {
		return this.field1432 < 0 ? -1 : this.field1432;
	}

	@ObfuscatedName("u")
	public synchronized void method2554(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1428 = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2555() {
		this.field1426 = (this.field1426 ^ this.field1426 >> 31) + (this.field1426 >>> 31);
		this.field1426 = -this.field1426;
	}

	@ObfuscatedName("h")
	void method2679() {
		if (this.field1437 != 0) {
			if (this.field1427 == Integer.MIN_VALUE) {
				this.field1427 = 0;
			}

			this.field1437 = 0;
			this.method2543();
		}

	}

	@ObfuscatedName("m")
	public synchronized void method2557(int var1, int var2) {
		this.method2668(var1, var2, this.method2553());
	}

	@ObfuscatedName("aa")
	public synchronized void method2668(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2551(var2, var3);
		} else {
			int var4 = method2552(var2, var3);
			int var5 = method2693(var2, var3);
			if (var4 == this.field1430 && var5 == this.field1431) {
				this.field1437 = 0;
			} else {
				int var6 = var2 - this.field1429;
				if (this.field1429 - var2 > var6) {
					var6 = this.field1429 - var2;
				}

				if (var4 - this.field1430 > var6) {
					var6 = var4 - this.field1430;
				}

				if (this.field1430 - var4 > var6) {
					var6 = this.field1430 - var4;
				}

				if (var5 - this.field1431 > var6) {
					var6 = var5 - this.field1431;
				}

				if (this.field1431 - var5 > var6) {
					var6 = this.field1431 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1437 = var1;
				this.field1427 = var2;
				this.field1432 = var3;
				this.field1436 = (var2 - this.field1429) / var1;
				this.field1438 = (var4 - this.field1430) / var1;
				this.field1439 = (var5 - this.field1431) / var1;
			}
		}
	}

	@ObfuscatedName("av")
	public synchronized void method2559(int var1) {
		if (var1 == 0) {
			this.method2550(0);
			this.remove();
		} else if (this.field1430 == 0 && this.field1431 == 0) {
			this.field1437 = 0;
			this.field1427 = 0;
			this.field1429 = 0;
			this.remove();
		} else {
			int var2 = -this.field1429;
			if (this.field1429 > var2) {
				var2 = this.field1429;
			}

			if (-this.field1430 > var2) {
				var2 = -this.field1430;
			}

			if (this.field1430 > var2) {
				var2 = this.field1430;
			}

			if (-this.field1431 > var2) {
				var2 = -this.field1431;
			}

			if (this.field1431 > var2) {
				var2 = this.field1431;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1437 = var1;
			this.field1427 = Integer.MIN_VALUE;
			this.field1436 = -this.field1429 / var1;
			this.field1438 = -this.field1430 / var1;
			this.field1439 = -this.field1431 / var1;
		}
	}

	@ObfuscatedName("ay")
	public synchronized void method2615(int var1) {
		if (this.field1426 < 0) {
			this.field1426 = -var1;
		} else {
			this.field1426 = var1;
		}

	}

	@ObfuscatedName("ag")
	public synchronized int method2561() {
		return this.field1426 < 0 ? -this.field1426 : this.field1426;
	}

	@ObfuscatedName("ae")
	public boolean method2653() {
		return this.field1428 < 0 || this.field1428 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ad")
	public boolean method2563() {
		return this.field1437 != 0;
	}

	@ObfuscatedName("aj")
	int method2569(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1437 > 0) {
				int var6 = var2 + this.field1437;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1437 += var2;
				if (this.field1426 == 256 && (this.field1428 & 255) == 0) {
					if (SoundCache.PcmPlayer_stereo) {
						var2 = method2581(0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, this.field1438, this.field1439, 0, var6, var3, this);
					} else {
						var2 = method2614(((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, this.field1436, 0, var6, var3, this);
					}
				} else if (SoundCache.PcmPlayer_stereo) {
					var2 = method2585(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, this.field1438, this.field1439, 0, var6, var3, this, this.field1426, var5);
				} else {
					var2 = method2584(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, this.field1436, 0, var6, var3, this, this.field1426, var5);
				}

				this.field1437 -= var2;
				if (this.field1437 != 0) {
					return var2;
				}

				if (!this.method2571()) {
					continue;
				}

				return var4;
			}

			if (this.field1426 == 256 && (this.field1428 & 255) == 0) {
				if (SoundCache.PcmPlayer_stereo) {
					return method2573(0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, 0, var4, var3, this);
				}

				return method2572(((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, 0, var4, var3, this);
			}

			if (SoundCache.PcmPlayer_stereo) {
				return method2577(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, 0, var4, var3, this, this.field1426, var5);
			}

			return method2576(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, 0, var4, var3, this, this.field1426, var5);
		}
	}

	@ObfuscatedName("ax")
	int method2570(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1437 > 0) {
				int var6 = var2 + this.field1437;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1437 += var2;
				if (this.field1426 == -256 && (this.field1428 & 255) == 0) {
					if (SoundCache.PcmPlayer_stereo) {
						var2 = method2556(0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, this.field1438, this.field1439, 0, var6, var3, this);
					} else {
						var2 = method2542(((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, this.field1436, 0, var6, var3, this);
					}
				} else if (SoundCache.PcmPlayer_stereo) {
					var2 = method2587(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, this.field1438, this.field1439, 0, var6, var3, this, this.field1426, var5);
				} else {
					var2 = method2568(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, this.field1436, 0, var6, var3, this, this.field1426, var5);
				}

				this.field1437 -= var2;
				if (this.field1437 != 0) {
					return var2;
				}

				if (!this.method2571()) {
					continue;
				}

				return var4;
			}

			if (this.field1426 == -256 && (this.field1428 & 255) == 0) {
				if (SoundCache.PcmPlayer_stereo) {
					return method2575(0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, 0, var4, var3, this);
				}

				return method2689(((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, 0, var4, var3, this);
			}

			if (SoundCache.PcmPlayer_stereo) {
				return method2579(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1430, this.field1431, 0, var4, var3, this, this.field1426, var5);
			}

			return method2629(0, 0, ((RawSound)super.sound).samples, var1, this.field1428, var2, this.field1429, 0, var4, var3, this, this.field1426, var5);
		}
	}

	@ObfuscatedName("at")
	int vmethod2716() {
		int var1 = this.field1429 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1428 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("af")
	boolean method2571() {
		int var1 = this.field1427;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2552(var1, this.field1432);
			var3 = method2693(var1, this.field1432);
		}

		if (var1 == this.field1429 && var2 == this.field1430 && var3 == this.field1431) {
			if (this.field1427 == Integer.MIN_VALUE) {
				this.field1427 = 0;
				this.field1431 = 0;
				this.field1430 = 0;
				this.field1429 = 0;
				this.remove();
				return true;
			} else {
				this.method2543();
				return false;
			}
		} else {
			if (this.field1429 < var1) {
				this.field1436 = 1;
				this.field1437 = var1 - this.field1429;
			} else if (this.field1429 > var1) {
				this.field1436 = -1;
				this.field1437 = this.field1429 - var1;
			} else {
				this.field1436 = 0;
			}

			if (this.field1430 < var2) {
				this.field1438 = 1;
				if (this.field1437 == 0 || this.field1437 > var2 - this.field1430) {
					this.field1437 = var2 - this.field1430;
				}
			} else if (this.field1430 > var2) {
				this.field1438 = -1;
				if (this.field1437 == 0 || this.field1437 > this.field1430 - var2) {
					this.field1437 = this.field1430 - var2;
				}
			} else {
				this.field1438 = 0;
			}

			if (this.field1431 < var3) {
				this.field1439 = 1;
				if (this.field1437 == 0 || this.field1437 > var3 - this.field1431) {
					this.field1437 = var3 - this.field1431;
				}
			} else if (this.field1431 > var3) {
				this.field1439 = -1;
				if (this.field1437 == 0 || this.field1437 > this.field1431 - var3) {
					this.field1437 = this.field1431 - var3;
				}
			} else {
				this.field1439 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("f")
	static int method2552(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("i")
	static int method2693(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lcc;II)Ldg;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(DirectByteArrayCopier.field2490 * 334942784)), var2 << 6) : null;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lcc;III)Ldg;"
	)
	public static RawPcmStream method2582(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdg;)I"
	)
	static int method2572(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1428 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdg;)I"
	)
	static int method2573(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1428 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdg;)I"
	)
	static int method2689(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field1428 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdg;)I"
	)
	static int method2575(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field1428 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdg;II)I"
	)
	static int method2576(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1428 = var4;
		return var5;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdg;II)I"
	)
	static int method2577(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1428 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdg;II)I"
	)
	static int method2629(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field1428 = var4;
		return var5;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdg;II)I"
	)
	static int method2579(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field1428 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdg;)I"
	)
	static int method2614(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1430 += var9.field1438 * (var6 - var3);
		var9.field1431 += var9.field1439 * (var6 - var3);

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

		var9.field1429 = var4 >> 2;
		var9.field1428 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdg;)I"
	)
	static int method2581(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1429 += var12.field1436 * (var9 - var4);
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

		var12.field1430 = var5 >> 2;
		var12.field1431 = var6 >> 2;
		var12.field1428 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdg;)I"
	)
	static int method2542(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1430 += var9.field1438 * (var6 - var3);
		var9.field1431 += var9.field1439 * (var6 - var3);

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

		var9.field1429 = var4 >> 2;
		var9.field1428 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdg;)I"
	)
	static int method2556(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1429 += var12.field1436 * (var9 - var4);
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

		var12.field1430 = var5 >> 2;
		var12.field1431 = var6 >> 2;
		var12.field1428 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdg;II)I"
	)
	static int method2584(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1430 -= var11.field1438 * var5;
		var11.field1431 -= var11.field1439 * var5;
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

		var11.field1430 += var11.field1438 * var5;
		var11.field1431 += var11.field1439 * var5;
		var11.field1429 = var6;
		var11.field1428 = var4;
		return var5;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdg;II)I"
	)
	static int method2585(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1429 -= var5 * var13.field1436;
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
		var13.field1429 += var13.field1436 * var5;
		var13.field1430 = var6;
		var13.field1431 = var7;
		var13.field1428 = var4;
		return var5;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdg;II)I"
	)
	static int method2568(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1430 -= var11.field1438 * var5;
		var11.field1431 -= var11.field1439 * var5;
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

		var11.field1430 += var11.field1438 * var5;
		var11.field1431 += var11.field1439 * var5;
		var11.field1429 = var6;
		var11.field1428 = var4;
		return var5;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdg;II)I"
	)
	static int method2587(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1429 -= var5 * var13.field1436;
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
		var13.field1429 += var13.field1436 * var5;
		var13.field1430 = var6;
		var13.field1431 = var7;
		var13.field1428 = var4;
		return var5;
	}
}
