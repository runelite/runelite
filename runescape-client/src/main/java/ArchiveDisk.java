import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("ArchiveDisk")
public final class ArchiveDisk {
	@ObfuscatedName("q")
	@Export("ArchiveDisk_buffer")
	static byte[] ArchiveDisk_buffer;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("datFile")
	BufferedFile datFile;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("idxFile")
	BufferedFile idxFile;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -2081269841
	)
	@Export("archive")
	int archive;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -609307423
	)
	@Export("maxEntrySize")
	int maxEntrySize;

	static {
		ArchiveDisk_buffer = new byte[520];
	}

	@ObfuscatedSignature(
		signature = "(ILmn;Lmn;I)V"
	)
	public ArchiveDisk(int var1, BufferedFile var2, BufferedFile var3, int var4) {
		this.datFile = null;
		this.idxFile = null;
		this.maxEntrySize = 65000;
		this.archive = var1;
		this.datFile = var2;
		this.idxFile = var3;
		this.maxEntrySize = var4;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "-8739933"
	)
	@Export("read")
	public byte[] read(int var1) {
		synchronized(this.datFile) {
			try {
				Object var10000;
				if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
					var10000 = null;
					return (byte[])var10000;
				} else {
					this.idxFile.seek((long)(var1 * 6));
					this.idxFile.read(ArchiveDisk_buffer, 0, 6);
					int var3 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
					int var4 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
					if (var3 < 0 || var3 > this.maxEntrySize) {
						var10000 = null;
						return (byte[])var10000;
					} else if (var4 <= 0 || (long)var4 > this.datFile.length() / 520L) {
						var10000 = null;
						return (byte[])var10000;
					} else {
						byte[] var5 = new byte[var3];
						int var6 = 0;

						for (int var7 = 0; var6 < var3; ++var7) {
							if (var4 == 0) {
								var10000 = null;
								return (byte[])var10000;
							}

							this.datFile.seek(520L * (long)var4);
							int var8 = var3 - var6;
							int var9;
							int var10;
							int var11;
							int var12;
							byte var13;
							if (var1 > 65535) {
								if (var8 > 510) {
									var8 = 510;
								}

								var13 = 10;
								this.datFile.read(ArchiveDisk_buffer, 0, var8 + var13);
								var9 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
								var10 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
								var11 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
								var12 = ArchiveDisk_buffer[9] & 255;
							} else {
								if (var8 > 512) {
									var8 = 512;
								}

								var13 = 8;
								this.datFile.read(ArchiveDisk_buffer, 0, var13 + var8);
								var9 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
								var10 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
								var11 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
								var12 = ArchiveDisk_buffer[7] & 255;
							}

							if (var9 != var1 || var7 != var10 || var12 != this.archive) {
								var10000 = null;
								return (byte[])var10000;
							}

							if (var11 < 0 || (long)var11 > this.datFile.length() / 520L) {
								var10000 = null;
								return (byte[])var10000;
							}

							int var14 = var8 + var13;

							for (int var15 = var13; var15 < var14; ++var15) {
								var5[var6++] = ArchiveDisk_buffer[var15];
							}

							var4 = var11;
						}

						byte[] var20 = var5;
						return var20;
					}
				}
			} catch (IOException var18) {
				return null;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I[BII)Z",
		garbageValue = "-1155409189"
	)
	@Export("write")
	public boolean write(int var1, byte[] var2, int var3) {
		synchronized(this.datFile) {
			if (var3 >= 0 && var3 <= this.maxEntrySize) {
				boolean var5 = this.write0(var1, var2, var3, true);
				if (!var5) {
					var5 = this.write0(var1, var2, var3, false);
				}

				return var5;
			} else {
				throw new IllegalArgumentException("" + this.archive + ',' + var1 + ',' + var3);
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I[BIZB)Z",
		garbageValue = "64"
	)
	@Export("write0")
	boolean write0(int var1, byte[] var2, int var3, boolean var4) {
		synchronized(this.datFile) {
			try {
				int var6;
				boolean var10000;
				if (var4) {
					if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
						var10000 = false;
						return var10000;
					}

					this.idxFile.seek((long)(var1 * 6));
					this.idxFile.read(ArchiveDisk_buffer, 0, 6);
					var6 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
					if (var6 <= 0 || (long)var6 > this.datFile.length() / 520L) {
						var10000 = false;
						return var10000;
					}
				} else {
					var6 = (int)((this.datFile.length() + 519L) / 520L);
					if (var6 == 0) {
						var6 = 1;
					}
				}

				ArchiveDisk_buffer[0] = (byte)(var3 >> 16);
				ArchiveDisk_buffer[1] = (byte)(var3 >> 8);
				ArchiveDisk_buffer[2] = (byte)var3;
				ArchiveDisk_buffer[3] = (byte)(var6 >> 16);
				ArchiveDisk_buffer[4] = (byte)(var6 >> 8);
				ArchiveDisk_buffer[5] = (byte)var6;
				this.idxFile.seek((long)(var1 * 6));
				this.idxFile.write(ArchiveDisk_buffer, 0, 6);
				int var7 = 0;
				int var8 = 0;

				while (true) {
					if (var7 < var3) {
						label171: {
							int var9 = 0;
							int var10;
							if (var4) {
								this.datFile.seek((long)var6 * 520L);
								int var11;
								int var12;
								if (var1 > 65535) {
									try {
										this.datFile.read(ArchiveDisk_buffer, 0, 10);
									} catch (EOFException var17) {
										break label171;
									}

									var10 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
									var11 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
									var9 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
									var12 = ArchiveDisk_buffer[9] & 255;
								} else {
									try {
										this.datFile.read(ArchiveDisk_buffer, 0, 8);
									} catch (EOFException var16) {
										break label171;
									}

									var10 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
									var11 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
									var9 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
									var12 = ArchiveDisk_buffer[7] & 255;
								}

								if (var10 != var1 || var8 != var11 || var12 != this.archive) {
									var10000 = false;
									return var10000;
								}

								if (var9 < 0 || (long)var9 > this.datFile.length() / 520L) {
									var10000 = false;
									return var10000;
								}
							}

							if (var9 == 0) {
								var4 = false;
								var9 = (int)((this.datFile.length() + 519L) / 520L);
								if (var9 == 0) {
									++var9;
								}

								if (var6 == var9) {
									++var9;
								}
							}

							if (var1 > 65535) {
								if (var3 - var7 <= 510) {
									var9 = 0;
								}

								ArchiveDisk_buffer[0] = (byte)(var1 >> 24);
								ArchiveDisk_buffer[1] = (byte)(var1 >> 16);
								ArchiveDisk_buffer[2] = (byte)(var1 >> 8);
								ArchiveDisk_buffer[3] = (byte)var1;
								ArchiveDisk_buffer[4] = (byte)(var8 >> 8);
								ArchiveDisk_buffer[5] = (byte)var8;
								ArchiveDisk_buffer[6] = (byte)(var9 >> 16);
								ArchiveDisk_buffer[7] = (byte)(var9 >> 8);
								ArchiveDisk_buffer[8] = (byte)var9;
								ArchiveDisk_buffer[9] = (byte)this.archive;
								this.datFile.seek((long)var6 * 520L);
								this.datFile.write(ArchiveDisk_buffer, 0, 10);
								var10 = var3 - var7;
								if (var10 > 510) {
									var10 = 510;
								}

								this.datFile.write(var2, var7, var10);
								var7 += var10;
							} else {
								if (var3 - var7 <= 512) {
									var9 = 0;
								}

								ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
								ArchiveDisk_buffer[1] = (byte)var1;
								ArchiveDisk_buffer[2] = (byte)(var8 >> 8);
								ArchiveDisk_buffer[3] = (byte)var8;
								ArchiveDisk_buffer[4] = (byte)(var9 >> 16);
								ArchiveDisk_buffer[5] = (byte)(var9 >> 8);
								ArchiveDisk_buffer[6] = (byte)var9;
								ArchiveDisk_buffer[7] = (byte)this.archive;
								this.datFile.seek(520L * (long)var6);
								this.datFile.write(ArchiveDisk_buffer, 0, 8);
								var10 = var3 - var7;
								if (var10 > 512) {
									var10 = 512;
								}

								this.datFile.write(var2, var7, var10);
								var7 += var10;
							}

							var6 = var9;
							++var8;
							continue;
						}
					}

					var10000 = true;
					return var10000;
				}
			} catch (IOException var18) {
				return false;
			}
		}
	}

	public String toString() {
		return "" + this.archive;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;ZI)[B",
		garbageValue = "991854443"
	)
	@Export("byteArrayFromObject")
	public static byte[] byteArrayFromObject(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			if (var1) {
				int var4 = var6.length;
				byte[] var5 = new byte[var4];
				System.arraycopy(var6, 0, var5, 0, var4);
				return var5;
			} else {
				return var6;
			}
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}
}
