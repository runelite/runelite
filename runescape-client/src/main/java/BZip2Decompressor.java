import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("BZip2Decompressor")
public final class BZip2Decompressor {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lki;"
	)
	@Export("BZip2Decompressor_state")
	static BZip2State BZip2Decompressor_state;

	static {
		BZip2Decompressor_state = new BZip2State();
	}

	@ObfuscatedName("q")
	@Export("BZip2Decompressor_decompress")
	public static int BZip2Decompressor_decompress(byte[] var0, int var1, byte[] var2, int var3, int var4) {
		synchronized(BZip2Decompressor_state) {
			BZip2Decompressor_state.inputArray = var2;
			BZip2Decompressor_state.nextByte = var4;
			BZip2Decompressor_state.outputArray = var0;
			BZip2Decompressor_state.next_out = 0;
			BZip2Decompressor_state.outputLength = var1;
			BZip2Decompressor_state.bsLive = 0;
			BZip2Decompressor_state.bsBuff = 0;
			BZip2Decompressor_state.nextBit_unused = 0;
			BZip2Decompressor_state.field3753 = 0;
			BZip2Decompressor_decompress(BZip2Decompressor_state);
			var1 -= BZip2Decompressor_state.outputLength;
			BZip2Decompressor_state.inputArray = null;
			BZip2Decompressor_state.outputArray = null;
			return var1;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lki;)V"
	)
	static void method5773(BZip2State var0) {
		byte var2 = var0.out_char;
		int var3 = var0.su_rNToGo;
		int var4 = var0.nblocks_used;
		int var5 = var0.su_ch2;
		int[] var6 = VarbitDefinition.BZip2Decompressor_block;
		int var7 = var0.field3760;
		byte[] var8 = var0.outputArray;
		int var9 = var0.next_out;
		int var10 = var0.outputLength;
		int var12 = var0.field3776 + 1;

		label61:
		while (true) {
			if (var3 > 0) {
				while (true) {
					if (var10 == 0) {
						break label61;
					}

					if (var3 == 1) {
						if (var10 == 0) {
							var3 = 1;
							break label61;
						}

						var8[var9] = var2;
						++var9;
						--var10;
						break;
					}

					var8[var9] = var2;
					--var3;
					++var9;
					--var10;
				}
			}

			while (var4 != var12) {
				var2 = (byte)var5;
				var7 = var6[var7];
				byte var1 = (byte)var7;
				var7 >>= 8;
				++var4;
				if (var1 != var5) {
					var5 = var1;
					if (var10 == 0) {
						var3 = 1;
						break label61;
					}

					var8[var9] = var2;
					++var9;
					--var10;
				} else {
					if (var4 != var12) {
						var3 = 2;
						var7 = var6[var7];
						var1 = (byte)var7;
						var7 >>= 8;
						++var4;
						if (var4 != var12) {
							if (var1 != var5) {
								var5 = var1;
							} else {
								var3 = 3;
								var7 = var6[var7];
								var1 = (byte)var7;
								var7 >>= 8;
								++var4;
								if (var4 != var12) {
									if (var1 != var5) {
										var5 = var1;
									} else {
										var7 = var6[var7];
										var1 = (byte)var7;
										var7 >>= 8;
										++var4;
										var3 = (var1 & 255) + 4;
										var7 = var6[var7];
										var5 = (byte)var7;
										var7 >>= 8;
										++var4;
									}
								}
							}
						}
						continue label61;
					}

					if (var10 == 0) {
						var3 = 1;
						break label61;
					}

					var8[var9] = var2;
					++var9;
					--var10;
				}
			}

			var3 = 0;
			break;
		}

		int var13 = var0.field3753;
		var0.field3753 += var10 - var10;
		if (var0.field3753 < var13) {
		}

		var0.out_char = var2;
		var0.su_rNToGo = var3;
		var0.nblocks_used = var4;
		var0.su_ch2 = var5;
		VarbitDefinition.BZip2Decompressor_block = var6;
		var0.field3760 = var7;
		var0.outputArray = var8;
		var0.next_out = var9;
		var0.outputLength = var10;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lki;)V"
	)
	@Export("BZip2Decompressor_decompress")
	static void BZip2Decompressor_decompress(BZip2State var0) {
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		boolean var8 = false;
		boolean var9 = false;
		boolean var10 = false;
		boolean var11 = false;
		boolean var12 = false;
		boolean var13 = false;
		boolean var14 = false;
		boolean var15 = false;
		boolean var16 = false;
		boolean var17 = false;
		boolean var18 = false;
		boolean var19 = false;
		boolean var20 = false;
		boolean var21 = false;
		int var22 = 0;
		int[] var23 = null;
		int[] var24 = null;
		int[] var25 = null;
		var0.blockSize100k = 1410065408;
		if (VarbitDefinition.BZip2Decompressor_block == null) {
			VarbitDefinition.BZip2Decompressor_block = new int[var0.blockSize100k * 100000];
		}

		boolean var26 = true;

		while (true) {
			while (var26) {
				byte var1 = BZip2Decompressor_readNextByte(var0);
				if (var1 == 23) {
					return;
				}

				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextByte(var0);
				var1 = BZip2Decompressor_readNextBit(var0);
				if (var1 != 0) {
				}

				var0.originalPointer = 0;
				var1 = BZip2Decompressor_readNextByte(var0);
				var0.originalPointer = var0.originalPointer << 8 | var1 & 255;
				var1 = BZip2Decompressor_readNextByte(var0);
				var0.originalPointer = var0.originalPointer << 8 | var1 & 255;
				var1 = BZip2Decompressor_readNextByte(var0);
				var0.originalPointer = var0.originalPointer << 8 | var1 & 255;

				int var36;
				for (var36 = 0; var36 < 16; ++var36) {
					var1 = BZip2Decompressor_readNextBit(var0);
					if (var1 == 1) {
						var0.inUse16[var36] = true;
					} else {
						var0.inUse16[var36] = false;
					}
				}

				for (var36 = 0; var36 < 256; ++var36) {
					var0.inUse[var36] = false;
				}

				int var37;
				for (var36 = 0; var36 < 16; ++var36) {
					if (var0.inUse16[var36]) {
						for (var37 = 0; var37 < 16; ++var37) {
							var1 = BZip2Decompressor_readNextBit(var0);
							if (var1 == 1) {
								var0.inUse[var37 + var36 * 16] = true;
							}
						}
					}
				}

				makeMaps(var0);
				int var39 = var0.nInUse + 2;
				int var40 = BZip2Decompressor_readBits(3, var0);
				int var41 = BZip2Decompressor_readBits(15, var0);

				for (var36 = 0; var36 < var41; ++var36) {
					var37 = 0;

					while (true) {
						var1 = BZip2Decompressor_readNextBit(var0);
						if (var1 == 0) {
							var0.selectorMtf[var36] = (byte)var37;
							break;
						}

						++var37;
					}
				}

				byte[] var27 = new byte[6];

				byte var29;
				for (var29 = 0; var29 < var40; var27[var29] = var29++) {
				}

				for (var36 = 0; var36 < var41; ++var36) {
					var29 = var0.selectorMtf[var36];

					byte var28;
					for (var28 = var27[var29]; var29 > 0; --var29) {
						var27[var29] = var27[var29 - 1];
					}

					var27[0] = var28;
					var0.selector[var36] = var28;
				}

				int var38;
				for (var38 = 0; var38 < var40; ++var38) {
					int var50 = BZip2Decompressor_readBits(5, var0);

					for (var36 = 0; var36 < var39; ++var36) {
						while (true) {
							var1 = BZip2Decompressor_readNextBit(var0);
							if (var1 == 0) {
								var0.temp_charArray2d[var38][var36] = (byte)var50;
								break;
							}

							var1 = BZip2Decompressor_readNextBit(var0);
							if (var1 == 0) {
								++var50;
							} else {
								--var50;
							}
						}
					}
				}

				for (var38 = 0; var38 < var40; ++var38) {
					byte var2 = 32;
					byte var3 = 0;

					for (var36 = 0; var36 < var39; ++var36) {
						if (var0.temp_charArray2d[var38][var36] > var3) {
							var3 = var0.temp_charArray2d[var38][var36];
						}

						if (var0.temp_charArray2d[var38][var36] < var2) {
							var2 = var0.temp_charArray2d[var38][var36];
						}
					}

					BZip2Decompressor_createHuffmanTables(var0.limit[var38], var0.base[var38], var0.perm[var38], var0.temp_charArray2d[var38], var2, var3, var39);
					var0.minLens[var38] = var2;
				}

				int var42 = var0.nInUse + 1;
				int var43 = -1;
				byte var44 = 0;

				for (var36 = 0; var36 <= 255; ++var36) {
					var0.unzftab[var36] = 0;
				}

				int var56 = 4095;

				int var35;
				int var55;
				for (var35 = 15; var35 >= 0; --var35) {
					for (var55 = 15; var55 >= 0; --var55) {
						var0.ll8[var56] = (byte)(var55 + var35 * 16);
						--var56;
					}

					var0.getAndMoveToFrontDecode_yy[var35] = var56 + 1;
				}

				int var47 = 0;
				byte var54;
				if (var44 == 0) {
					++var43;
					var44 = 50;
					var54 = var0.selector[var43];
					var22 = var0.minLens[var54];
					var23 = var0.limit[var54];
					var25 = var0.perm[var54];
					var24 = var0.base[var54];
				}

				int var45 = var44 - 1;
				int var51 = var22;

				int var52;
				byte var53;
				for (var52 = BZip2Decompressor_readBits(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
					++var51;
					var53 = BZip2Decompressor_readNextBit(var0);
				}

				int var46 = var25[var52 - var24[var51]];

				while (true) {
					int[] var10000;
					int var10002;
					while (var46 != var42) {
						if (var46 != 0 && var46 != 1) {
							int var33 = var46 - 1;
							int var30;
							if (var33 < 16) {
								var30 = var0.getAndMoveToFrontDecode_yy[0];

								for (var1 = var0.ll8[var30 + var33]; var33 > 3; var33 -= 4) {
									int var34 = var30 + var33;
									var0.ll8[var34] = var0.ll8[var34 - 1];
									var0.ll8[var34 - 1] = var0.ll8[var34 - 2];
									var0.ll8[var34 - 2] = var0.ll8[var34 - 3];
									var0.ll8[var34 - 3] = var0.ll8[var34 - 4];
								}

								while (var33 > 0) {
									var0.ll8[var30 + var33] = var0.ll8[var30 + var33 - 1];
									--var33;
								}

								var0.ll8[var30] = var1;
							} else {
								int var31 = var33 / 16;
								int var32 = var33 % 16;
								var30 = var0.getAndMoveToFrontDecode_yy[var31] + var32;

								for (var1 = var0.ll8[var30]; var30 > var0.getAndMoveToFrontDecode_yy[var31]; --var30) {
									var0.ll8[var30] = var0.ll8[var30 - 1];
								}

								for (var10002 = var0.getAndMoveToFrontDecode_yy[var31]++; var31 > 0; --var31) {
									var10002 = var0.getAndMoveToFrontDecode_yy[var31]--;
									var0.ll8[var0.getAndMoveToFrontDecode_yy[var31]] = var0.ll8[var0.getAndMoveToFrontDecode_yy[var31 - 1] + 16 - 1];
								}

								var10002 = var0.getAndMoveToFrontDecode_yy[0]--;
								var0.ll8[var0.getAndMoveToFrontDecode_yy[0]] = var1;
								if (var0.getAndMoveToFrontDecode_yy[0] == 0) {
									var56 = 4095;

									for (var35 = 15; var35 >= 0; --var35) {
										for (var55 = 15; var55 >= 0; --var55) {
											var0.ll8[var56] = var0.ll8[var0.getAndMoveToFrontDecode_yy[var35] + var55];
											--var56;
										}

										var0.getAndMoveToFrontDecode_yy[var35] = var56 + 1;
									}
								}
							}

							var10002 = var0.unzftab[var0.seqToUnseq[var1 & 255] & 255]++;
							VarbitDefinition.BZip2Decompressor_block[var47] = var0.seqToUnseq[var1 & 255] & 255;
							++var47;
							if (var45 == 0) {
								++var43;
								var45 = 50;
								var54 = var0.selector[var43];
								var22 = var0.minLens[var54];
								var23 = var0.limit[var54];
								var25 = var0.perm[var54];
								var24 = var0.base[var54];
							}

							--var45;
							var51 = var22;

							for (var52 = BZip2Decompressor_readBits(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
								++var51;
								var53 = BZip2Decompressor_readNextBit(var0);
							}

							var46 = var25[var52 - var24[var51]];
						} else {
							int var48 = -1;
							int var49 = 1;

							do {
								if (var46 == 0) {
									var48 += var49;
								} else if (var46 == 1) {
									var48 += var49 * 2;
								}

								var49 *= 2;
								if (var45 == 0) {
									++var43;
									var45 = 50;
									var54 = var0.selector[var43];
									var22 = var0.minLens[var54];
									var23 = var0.limit[var54];
									var25 = var0.perm[var54];
									var24 = var0.base[var54];
								}

								--var45;
								var51 = var22;

								for (var52 = BZip2Decompressor_readBits(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
									++var51;
									var53 = BZip2Decompressor_readNextBit(var0);
								}

								var46 = var25[var52 - var24[var51]];
							} while(var46 == 0 || var46 == 1);

							++var48;
							var1 = var0.seqToUnseq[var0.ll8[var0.getAndMoveToFrontDecode_yy[0]] & 255];
							var10000 = var0.unzftab;

							for (var10000[var1 & 255] += var48; var48 > 0; --var48) {
								VarbitDefinition.BZip2Decompressor_block[var47] = var1 & 255;
								++var47;
							}
						}
					}

					var0.su_rNToGo = 0;
					var0.out_char = 0;
					var0.cftab[0] = 0;

					for (var36 = 1; var36 <= 256; ++var36) {
						var0.cftab[var36] = var0.unzftab[var36 - 1];
					}

					for (var36 = 1; var36 <= 256; ++var36) {
						var10000 = var0.cftab;
						var10000[var36] += var0.cftab[var36 - 1];
					}

					for (var36 = 0; var36 < var47; ++var36) {
						var1 = (byte)(VarbitDefinition.BZip2Decompressor_block[var36] & 255);
						var10000 = VarbitDefinition.BZip2Decompressor_block;
						int var10001 = var0.cftab[var1 & 255];
						var10000[var10001] |= var36 << 8;
						var10002 = var0.cftab[var1 & 255]++;
					}

					var0.field3760 = VarbitDefinition.BZip2Decompressor_block[var0.originalPointer] >> 8;
					var0.nblocks_used = 0;
					var0.field3760 = VarbitDefinition.BZip2Decompressor_block[var0.field3760];
					var0.su_ch2 = (byte)(var0.field3760 & 255);
					var0.field3760 >>= 8;
					++var0.nblocks_used;
					var0.field3776 = var47;
					method5773(var0);
					if (var0.field3776 + 1 == var0.nblocks_used && var0.su_rNToGo == 0) {
						var26 = true;
						break;
					}

					var26 = false;
					break;
				}
			}

			return;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lki;)B"
	)
	@Export("BZip2Decompressor_readNextByte")
	static byte BZip2Decompressor_readNextByte(BZip2State var0) {
		return (byte)BZip2Decompressor_readBits(8, var0);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lki;)B"
	)
	@Export("BZip2Decompressor_readNextBit")
	static byte BZip2Decompressor_readNextBit(BZip2State var0) {
		return (byte)BZip2Decompressor_readBits(1, var0);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ILki;)I"
	)
	@Export("BZip2Decompressor_readBits")
	static int BZip2Decompressor_readBits(int var0, BZip2State var1) {
		while (var1.bsLive < var0) {
			var1.bsBuff = var1.bsBuff << 8 | var1.inputArray[var1.nextByte] & 255;
			var1.bsLive += 8;
			++var1.nextByte;
			++var1.nextBit_unused;
			if (var1.nextBit_unused == 0) {
			}
		}

		int var2 = var1.bsBuff >> var1.bsLive - var0 & (1 << var0) - 1;
		var1.bsLive -= var0;
		return var2;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lki;)V"
	)
	@Export("makeMaps")
	static void makeMaps(BZip2State var0) {
		var0.nInUse = 0;

		for (int var1 = 0; var1 < 256; ++var1) {
			if (var0.inUse[var1]) {
				var0.seqToUnseq[var0.nInUse] = (byte)var1;
				++var0.nInUse;
			}
		}

	}

	@ObfuscatedName("i")
	@Export("BZip2Decompressor_createHuffmanTables")
	static void BZip2Decompressor_createHuffmanTables(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
		int var7 = 0;

		int var8;
		for (var8 = var4; var8 <= var5; ++var8) {
			for (int var9 = 0; var9 < var6; ++var9) {
				if (var8 == var3[var9]) {
					var2[var7] = var9;
					++var7;
				}
			}
		}

		for (var8 = 0; var8 < 23; ++var8) {
			var1[var8] = 0;
		}

		for (var8 = 0; var8 < var6; ++var8) {
			++var1[var3[var8] + 1];
		}

		for (var8 = 1; var8 < 23; ++var8) {
			var1[var8] += var1[var8 - 1];
		}

		for (var8 = 0; var8 < 23; ++var8) {
			var0[var8] = 0;
		}

		int var10 = 0;

		for (var8 = var4; var8 <= var5; ++var8) {
			var10 += var1[var8 + 1] - var1[var8];
			var0[var8] = var10 - 1;
			var10 <<= 1;
		}

		for (var8 = var4 + 1; var8 <= var5; ++var8) {
			var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
		}

	}
}
