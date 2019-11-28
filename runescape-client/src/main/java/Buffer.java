import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("Buffer")
public class Buffer extends Node {
	@ObfuscatedName("y")
	@Export("crc32Table")
	static int[] crc32Table;
	@ObfuscatedName("i")
	@Export("crc64Table")
	static long[] crc64Table;
	@ObfuscatedName("p")
	@Export("array")
	public byte[] array;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1187800467
	)
	@Export("offset")
	public int offset;

	static {
		crc32Table = new int[256];

		int var2;
		for (int var1 = 0; var1 < 256; ++var1) {
			int var0 = var1;

			for (var2 = 0; var2 < 8; ++var2) {
				if ((var0 & 1) == 1) {
					var0 = var0 >>> 1 ^ -306674912;
				} else {
					var0 >>>= 1;
				}
			}

			crc32Table[var1] = var0;
		}

		crc64Table = new long[256];

		for (var2 = 0; var2 < 256; ++var2) {
			long var4 = (long)var2;

			for (int var3 = 0; var3 < 8; ++var3) {
				if (1L == (var4 & 1L)) {
					var4 = var4 >>> 1 ^ -3932672073523589310L;
				} else {
					var4 >>>= 1;
				}
			}

			crc64Table[var2] = var4;
		}

	}

	public Buffer(int var1) {
		this.array = UserComparator9.ByteArrayPool_getArray(var1);
		this.offset = 0;
	}

	public Buffer(byte[] var1) {
		this.array = var1;
		this.offset = 0;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-46"
	)
	@Export("releaseArray")
	public void releaseArray() {
		if (this.array != null) {
			Skeleton.ByteArrayPool_release(this.array);
		}

		this.array = null;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2118821041"
	)
	@Export("writeByte")
	public void writeByte(int var1) {
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-1"
	)
	@Export("writeShort")
	public void writeShort(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("writeMedium")
	public void writeMedium(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "56"
	)
	@Export("writeInt")
	public void writeInt(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("au")
	@Export("writeLongMedium")
	public void writeLongMedium(long var1) {
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
		this.array[++this.offset - 1] = (byte)((int)var1);
	}

	@ObfuscatedName("as")
	@Export("writeLong")
	public void writeLong(long var1) {
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 56));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 48));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
		this.array[++this.offset - 1] = (byte)((int)var1);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "14"
	)
	@Export("writeBoolean")
	public void writeBoolean(boolean var1) {
		this.writeByte(var1 ? 1 : 0);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1755897392"
	)
	@Export("writeStringCp1252NullTerminated")
	public void writeStringCp1252NullTerminated(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.offset += BoundaryObject.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
			this.array[++this.offset - 1] = 0;
		}
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1903174229"
	)
	@Export("writeStringCp1252NullCircumfixed")
	public void writeStringCp1252NullCircumfixed(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.array[++this.offset - 1] = 0;
			this.offset += BoundaryObject.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
			this.array[++this.offset - 1] = 0;
		}
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)V",
		garbageValue = "124331679"
	)
	@Export("writeCESU8")
	public void writeCESU8(CharSequence var1) {
		int var2 = AbstractWorldMapData.method284(var1);
		this.array[++this.offset - 1] = 0;
		this.writeVarInt(var2);
		this.offset += ArchiveDiskAction.method4229(this.array, this.offset, var1);
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "21"
	)
	@Export("writeBytes")
	public void writeBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			this.array[++this.offset - 1] = var1[var4];
		}

	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "1"
	)
	@Export("writeLengthInt")
	public void writeLengthInt(int var1) {
		if (var1 < 0) {
			throw new IllegalArgumentException();
		} else {
			this.array[this.offset - var1 - 4] = (byte)(var1 >> 24);
			this.array[this.offset - var1 - 3] = (byte)(var1 >> 16);
			this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
			this.array[this.offset - var1 - 1] = (byte)var1;
		}
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1717604297"
	)
	@Export("writeLengthShort")
	public void writeLengthShort(int var1) {
		if (var1 >= 0 && var1 <= 65535) {
			this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
			this.array[this.offset - var1 - 1] = (byte)var1;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "67"
	)
	@Export("writeLengthByte")
	public void writeLengthByte(int var1) {
		if (var1 >= 0 && var1 <= 255) {
			this.array[this.offset - var1 - 1] = (byte)var1;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1696071523"
	)
	@Export("writeSmartByteShort")
	public void writeSmartByteShort(int var1) {
		if (var1 >= 0 && var1 < 128) {
			this.writeByte(var1);
		} else if (var1 >= 0 && var1 < 32768) {
			this.writeShort(var1 + 32768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-38"
	)
	@Export("writeVarInt")
	public void writeVarInt(int var1) {
		if ((var1 & -128) != 0) {
			if ((var1 & -16384) != 0) {
				if ((var1 & -2097152) != 0) {
					if ((var1 & -268435456) != 0) {
						this.writeByte(var1 >>> 28 | 128);
					}

					this.writeByte(var1 >>> 21 | 128);
				}

				this.writeByte(var1 >>> 14 | 128);
			}

			this.writeByte(var1 >>> 7 | 128);
		}

		this.writeByte(var1 & 127);
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "981075318"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() {
		return this.array[++this.offset - 1] & 255;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "(I)B",
		garbageValue = "2139724295"
	)
	@Export("readByte")
	public byte readByte() {
		return this.array[++this.offset - 1];
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1493264537"
	)
	@Export("readUnsignedShort")
	public int readUnsignedShort() {
		this.offset += 2;
		return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2064115104"
	)
	@Export("readShort")
	public int readShort() {
		this.offset += 2;
		int var1 = (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-142746027"
	)
	@Export("readMedium")
	public int readMedium() {
		this.offset += 3;
		return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1280310408"
	)
	@Export("readInt")
	public int readInt() {
		this.offset += 4;
		return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24);
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "-433708522"
	)
	@Export("readLong")
	public long readLong() {
		long var1 = (long)this.readInt() & 4294967295L;
		long var3 = (long)this.readInt() & 4294967295L;
		return (var1 << 32) + var3;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "128"
	)
	@Export("readBoolean")
	public boolean readBoolean() {
		return (this.readUnsignedByte() & 1) == 1;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "(S)Ljava/lang/String;",
		garbageValue = "383"
	)
	@Export("readStringCp1252NullTerminatedOrNull")
	public String readStringCp1252NullTerminatedOrNull() {
		if (this.array[this.offset] == 0) {
			++this.offset;
			return null;
		} else {
			return this.readStringCp1252NullTerminated();
		}
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-510997912"
	)
	@Export("readStringCp1252NullTerminated")
	public String readStringCp1252NullTerminated() {
		int var1 = this.offset;

		while (this.array[++this.offset - 1] != 0) {
		}

		int var2 = this.offset - var1 - 1;
		return var2 == 0 ? "" : NetCache.decodeStringCp1252(this.array, var1, var2);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1601573396"
	)
	@Export("readStringCp1252NullCircumfixed")
	public String readStringCp1252NullCircumfixed() {
		byte var1 = this.array[++this.offset - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		} else {
			int var2 = this.offset;

			while (this.array[++this.offset - 1] != 0) {
			}

			int var3 = this.offset - var2 - 1;
			return var3 == 0 ? "" : NetCache.decodeStringCp1252(this.array, var2, var3);
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-180311328"
	)
	@Export("readCESU8")
	public String readCESU8() {
		byte var1 = this.array[++this.offset - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		} else {
			int var2 = this.readVarInt();
			if (var2 + this.offset > this.array.length) {
				throw new IllegalStateException("");
			} else {
				byte[] var4 = this.array;
				int var5 = this.offset;
				char[] var6 = new char[var2];
				int var7 = 0;
				int var8 = var5;

				int var11;
				for (int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
					int var10 = var4[var8++] & 255;
					if (var10 < 128) {
						if (var10 == 0) {
							var11 = 65533;
						} else {
							var11 = var10;
						}
					} else if (var10 < 192) {
						var11 = 65533;
					} else if (var10 < 224) {
						if (var8 < var9 && (var4[var8] & 192) == 128) {
							var11 = (var10 & 31) << 6 | var4[var8++] & 63;
							if (var11 < 128) {
								var11 = 65533;
							}
						} else {
							var11 = 65533;
						}
					} else if (var10 < 240) {
						if (var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
							var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
							if (var11 < 2048) {
								var11 = 65533;
							}
						} else {
							var11 = 65533;
						}
					} else if (var10 < 248) {
						if (var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
							var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
							if (var11 >= 65536 && var11 <= 1114111) {
								var11 = 65533;
							} else {
								var11 = 65533;
							}
						} else {
							var11 = 65533;
						}
					} else {
						var11 = 65533;
					}
				}

				String var3 = new String(var6, 0, var7);
				this.offset += var2;
				return var3;
			}
		}
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "713077513"
	)
	@Export("readBytes")
	public void readBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = this.array[++this.offset - 1];
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "60"
	)
	@Export("readShortSmart")
	public int readShortSmart() {
		int var1 = this.array[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 49152;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "896603690"
	)
	@Export("readUShortSmart")
	public int readUShortSmart() {
		int var1 = this.array[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1915469336"
	)
	public int method5710() {
		int var1 = 0;

		int var2;
		for (var2 = this.readUShortSmart(); var2 == 32767; var2 = this.readUShortSmart()) {
			var1 += 32767;
		}

		var1 += var2;
		return var1;
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-109"
	)
	public int method5617() {
		return this.array[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1394561672"
	)
	public int method5618() {
		if (this.array[this.offset] < 0) {
			return this.readInt() & Integer.MAX_VALUE;
		} else {
			int var1 = this.readUnsignedShort();
			return var1 == 32767 ? -1 : var1;
		}
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-681860010"
	)
	@Export("readVarInt")
	public int readVarInt() {
		byte var1 = this.array[++this.offset - 1];

		int var2;
		for (var2 = 0; var1 < 0; var1 = this.array[++this.offset - 1]) {
			var2 = (var2 | var1 & 127) << 7;
		}

		return var2 | var1;
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "([II)V",
		garbageValue = "1250000974"
	)
	@Export("xteaEncryptAll")
	public void xteaEncryptAll(int[] var1) {
		int var2 = this.offset / 8;
		this.offset = 0;

		for (int var3 = 0; var3 < var2; ++var3) {
			int var4 = this.readInt();
			int var5 = this.readInt();
			int var6 = 0;
			int var7 = -1640531527;

			for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
				var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
				var6 += var7;
			}

			this.offset -= 8;
			this.writeInt(var4);
			this.writeInt(var5);
		}

	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "([II)V",
		garbageValue = "1827488017"
	)
	@Export("xteaDecryptAll")
	public void xteaDecryptAll(int[] var1) {
		int var2 = this.offset / 8;
		this.offset = 0;

		for (int var3 = 0; var3 < var2; ++var3) {
			int var4 = this.readInt();
			int var5 = this.readInt();
			int var6 = -957401312;
			int var7 = -1640531527;

			for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
				var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
				var6 -= var7;
			}

			this.offset -= 8;
			this.writeInt(var4);
			this.writeInt(var5);
		}

	}

	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		signature = "([IIII)V",
		garbageValue = "1249213138"
	)
	@Export("xteaEncrypt")
	public void xteaEncrypt(int[] var1, int var2, int var3) {
		int var4 = this.offset;
		this.offset = var2;
		int var5 = (var3 - var2) / 8;

		for (int var6 = 0; var6 < var5; ++var6) {
			int var7 = this.readInt();
			int var8 = this.readInt();
			int var9 = 0;
			int var10 = -1640531527;

			for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
				var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
				var9 += var10;
			}

			this.offset -= 8;
			this.writeInt(var7);
			this.writeInt(var8);
		}

		this.offset = var4;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		signature = "([IIIS)V",
		garbageValue = "22292"
	)
	@Export("xteaDecrypt")
	public void xteaDecrypt(int[] var1, int var2, int var3) {
		int var4 = this.offset;
		this.offset = var2;
		int var5 = (var3 - var2) / 8;

		for (int var6 = 0; var6 < var5; ++var6) {
			int var7 = this.readInt();
			int var8 = this.readInt();
			int var9 = -957401312;
			int var10 = -1640531527;

			for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
				var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
				var9 -= var10;
			}

			this.offset -= 8;
			this.writeInt(var7);
			this.writeInt(var8);
		}

		this.offset = var4;
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
		garbageValue = "161696795"
	)
	@Export("encryptRsa")
	public void encryptRsa(BigInteger var1, BigInteger var2) {
		int var3 = this.offset;
		this.offset = 0;
		byte[] var4 = new byte[var3];
		this.readBytes(var4, 0, var3);
		BigInteger var5 = new BigInteger(var4);
		BigInteger var6 = var5.modPow(var1, var2);
		byte[] var7 = var6.toByteArray();
		this.offset = 0;
		this.writeShort(var7.length);
		this.writeBytes(var7, 0, var7.length);
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-112"
	)
	@Export("writeCrc")
	public int writeCrc(int var1) {
		int var2 = UserComparator5.method3467(this.array, var1, this.offset);
		this.writeInt(var2);
		return var2;
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "13755"
	)
	@Export("checkCrc")
	public boolean checkCrc() {
		this.offset -= 4;
		int var1 = UserComparator5.method3467(this.array, 0, this.offset);
		int var2 = this.readInt();
		return var2 == var1;
	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2047890611"
	)
	public void method5598(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 + 128);
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1379722724"
	)
	public void method5628(int var1) {
		this.array[++this.offset - 1] = (byte)(0 - var1);
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "709584424"
	)
	@Export("writeIntME")
	public void writeIntME(int var1) {
		this.array[++this.offset - 1] = (byte)(128 - var1);
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "128"
	)
	public int method5728() {
		return this.array[++this.offset - 1] - 128 & 255;
	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1543854045"
	)
	public int method5631() {
		return 0 - this.array[++this.offset - 1] & 255;
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1082297230"
	)
	public int method5689() {
		return 128 - this.array[++this.offset - 1] & 255;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		signature = "(I)B",
		garbageValue = "1164121747"
	)
	public byte method5633() {
		return (byte)(this.array[++this.offset - 1] - 128);
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		signature = "(I)B",
		garbageValue = "-839452095"
	)
	public byte method5637() {
		return (byte)(0 - this.array[++this.offset - 1]);
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		signature = "(B)B",
		garbageValue = "-65"
	)
	public byte method5772() {
		return (byte)(128 - this.array[++this.offset - 1]);
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1799174836"
	)
	public void method5636(int var1) {
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-8"
	)
	public void method5613(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)(var1 + 128);
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "23275811"
	)
	@Export("writeShortLE")
	public void writeShortLE(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 + 128);
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "92"
	)
	public int method5719() {
		this.offset += 2;
		return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-699058931"
	)
	public int method5640() {
		this.offset += 2;
		return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2077720731"
	)
	public int method5641() {
		this.offset += 2;
		return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1939464839"
	)
	public int method5765() {
		this.offset += 2;
		int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1382531763"
	)
	public int method5643() {
		this.offset += 2;
		int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-163163988"
	)
	public void method5627(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1088416772"
	)
	public int method5645() {
		this.offset += 3;
		return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16);
	}

	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2035333434"
	)
	public void method5811(int var1) {
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
	}

	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "272743804"
	)
	public void method5647(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "476827595"
	)
	public void method5648(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
	}

	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1875662145"
	)
	public int method5649() {
		this.offset += 4;
		return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24);
	}

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-68"
	)
	public int method5650() {
		this.offset += 4;
		return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8) + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16);
	}

	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-163399300"
	)
	public int method5588() {
		this.offset += 4;
		return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16) + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "875536376"
	)
	@Export("SpriteBuffer_decode")
	static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class325.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		UrlRequester.SpriteBuffer_xOffsets = new int[class325.SpriteBuffer_spriteCount];
		class216.SpriteBuffer_yOffsets = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_spriteWidths = new int[class325.SpriteBuffer_spriteCount];
		VarcInt.SpriteBuffer_spriteHeights = new int[class325.SpriteBuffer_spriteCount];
		FillMode.SpriteBuffer_pixels = new byte[class325.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8;
		class325.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		UserComparator9.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			UrlRequester.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class216.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			VarcInt.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		class325.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class325.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (class325.SpriteBuffer_spritePalette[var3] == 0) {
				class325.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			int var4 = class325.SpriteBuffer_spriteWidths[var3];
			int var5 = VarcInt.SpriteBuffer_spriteHeights[var3];
			int var6 = var4 * var5;
			byte[] var7 = new byte[var6];
			FillMode.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var10 * var4] = var1.readByte();
					}
				}
			}
		}

	}
}
