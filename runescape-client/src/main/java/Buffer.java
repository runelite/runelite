import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
@Implements("Buffer")
public class Buffer extends Node {
	@ObfuscatedName("v")
	@Export("crc32Table")
	public static int[] crc32Table;
	@ObfuscatedName("z")
	@Export("crc64Table")
	static long[] crc64Table;
	@ObfuscatedName("u")
	@Export("array")
	public byte[] array;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1189972175
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
				if ((var4 & 1L) == 1L) {
					var4 = var4 >>> 1 ^ -3932672073523589310L;
				} else {
					var4 >>>= 1;
				}
			}

			crc64Table[var2] = var4;
		}

	}

	public Buffer(int var1) {
		this.array = class30.ByteArrayPool_getArray(var1);
		this.offset = 0;
	}

	public Buffer(byte[] var1) {
		this.array = var1;
		this.offset = 0;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "38"
	)
	@Export("releaseArray")
	public void releaseArray() {
		if (this.array != null) {
			UserComparator5.ByteArrayPool_release(this.array);
		}

		this.array = null;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1260587251"
	)
	@Export("writeByte")
	public void writeByte(int var1) {
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "618943248"
	)
	@Export("writeShort")
	public void writeShort(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1756344108"
	)
	@Export("writeMedium")
	public void writeMedium(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2107422926"
	)
	@Export("writeInt")
	public void writeInt(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("ar")
	@Export("writeLongMedium")
	public void writeLongMedium(long var1) {
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
		this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
		this.array[++this.offset - 1] = (byte)((int)var1);
	}

	@ObfuscatedName("ac")
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(ZS)V",
		garbageValue = "1337"
	)
	@Export("writeBoolean")
	public void writeBoolean(boolean var1) {
		this.writeByte(var1 ? 1 : 0);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-838686798"
	)
	@Export("writeStringCp1252NullTerminated")
	public void writeStringCp1252NullTerminated(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.offset += class210.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
			this.array[++this.offset - 1] = 0;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-103316861"
	)
	@Export("writeStringCp1252NullCircumfixed")
	public void writeStringCp1252NullCircumfixed(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.array[++this.offset - 1] = 0;
			this.offset += class210.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
			this.array[++this.offset - 1] = 0;
		}
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)V",
		garbageValue = "-64"
	)
	@Export("writeCESU8")
	public void writeCESU8(CharSequence var1) {
		int var3 = var1.length();
		int var4 = 0;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var1.charAt(var5);
			if (var6 <= 127) {
				++var4;
			} else if (var6 <= 2047) {
				var4 += 2;
			} else {
				var4 += 3;
			}
		}

		this.array[++this.offset - 1] = 0;
		this.writeVarInt(var4);
		this.offset += ViewportMouse.method2956(this.array, this.offset, var1);
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "99753612"
	)
	@Export("writeBytes")
	public void writeBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			this.array[++this.offset - 1] = var1[var4];
		}

	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-557514726"
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

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "72"
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

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "44"
	)
	@Export("writeLengthByte")
	public void writeLengthByte(int var1) {
		if (var1 >= 0 && var1 <= 255) {
			this.array[this.offset - var1 - 1] = (byte)var1;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "970899408"
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

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1902392454"
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

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1728300707"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() {
		return this.array[++this.offset - 1] & 255;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(B)B",
		garbageValue = "114"
	)
	@Export("readByte")
	public byte readByte() {
		return this.array[++this.offset - 1];
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1980740859"
	)
	@Export("readUnsignedShort")
	public int readUnsignedShort() {
		this.offset += 2;
		return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1980960820"
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

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1938085544"
	)
	@Export("readMedium")
	public int readMedium() {
		this.offset += 3;
		return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "98"
	)
	@Export("readInt")
	public int readInt() {
		this.offset += 4;
		return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24);
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "2079336469"
	)
	@Export("readLong")
	public long readLong() {
		long var1 = (long)this.readInt() & 4294967295L;
		long var3 = (long)this.readInt() & 4294967295L;
		return (var1 << 32) + var3;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1896103883"
	)
	@Export("readBoolean")
	public boolean readBoolean() {
		return (this.readUnsignedByte() & 1) == 1;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "425843067"
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

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1577831456"
	)
	@Export("readStringCp1252NullTerminated")
	public String readStringCp1252NullTerminated() {
		int var1 = this.offset;

		while (this.array[++this.offset - 1] != 0) {
		}

		int var2 = this.offset - var1 - 1;
		return var2 == 0 ? "" : class51.decodeStringCp1252(this.array, var1, var2);
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "65"
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
			return var3 == 0 ? "" : class51.decodeStringCp1252(this.array, var2, var3);
		}
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-161524074"
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
				String var3 = ArchiveDiskAction.method4132(this.array, this.offset, var2);
				this.offset += var2;
				return var3;
			}
		}
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "-190296870"
	)
	@Export("readBytes")
	public void readBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = this.array[++this.offset - 1];
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "912699635"
	)
	@Export("readShortSmart")
	public int readShortSmart() {
		int var1 = this.array[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 49152;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "109"
	)
	@Export("readUShortSmart")
	public int readUShortSmart() {
		int var1 = this.array[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-389889422"
	)
	public int method5480() {
		int var1 = 0;

		int var2;
		for (var2 = this.readUShortSmart(); var2 == 32767; var2 = this.readUShortSmart()) {
			var1 += 32767;
		}

		var1 += var2;
		return var1;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1759456747"
	)
	public int method5481() {
		return this.array[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1828581894"
	)
	public int method5623() {
		if (this.array[this.offset] < 0) {
			return this.readInt() & Integer.MAX_VALUE;
		} else {
			int var1 = this.readUnsignedShort();
			return var1 == 32767 ? -1 : var1;
		}
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-322424913"
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

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "([IB)V",
		garbageValue = "36"
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

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "([II)V",
		garbageValue = "-2128070091"
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
		garbageValue = "1296681906"
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

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		signature = "([IIIB)V",
		garbageValue = "25"
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

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
		garbageValue = "1840777170"
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

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1830139064"
	)
	@Export("writeCrc")
	public int writeCrc(int var1) {
		byte[] var3 = this.array;
		int var4 = this.offset;
		int var5 = -1;

		for (int var6 = var1; var6 < var4; ++var6) {
			var5 = var5 >>> 8 ^ crc32Table[(var5 ^ var3[var6]) & 255];
		}

		var5 = ~var5;
		this.writeInt(var5);
		return var5;
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-829786051"
	)
	@Export("checkCrc")
	public boolean checkCrc() {
		this.offset -= 4;
		byte[] var2 = this.array;
		int var3 = this.offset;
		int var4 = -1;

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			var4 = var4 >>> 8 ^ crc32Table[(var4 ^ var2[var5]) & 255];
		}

		var4 = ~var4;
		var5 = this.readInt();
		return var5 == var4;
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2063150013"
	)
	public void method5491(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 + 128);
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1477946417"
	)
	public void method5566(int var1) {
		this.array[++this.offset - 1] = (byte)(0 - var1);
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2116757158"
	)
	public void method5493(int var1) {
		this.array[++this.offset - 1] = (byte)(128 - var1);
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	public int method5494() {
		return this.array[++this.offset - 1] - 128 & 255;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-331739438"
	)
	public int method5547() {
		return 0 - this.array[++this.offset - 1] & 255;
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1776957173"
	)
	@Export("readUnsignedByteNegate")
	public int readUnsignedByteNegate() {
		return 128 - this.array[++this.offset - 1] & 255;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "(I)B",
		garbageValue = "-2103641384"
	)
	public byte method5497() {
		return (byte)(this.array[++this.offset - 1] - 128);
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		signature = "(I)B",
		garbageValue = "-753316852"
	)
	public byte method5498() {
		return (byte)(0 - this.array[++this.offset - 1]);
	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		signature = "(I)B",
		garbageValue = "2121675336"
	)
	public byte method5634() {
		return (byte)(128 - this.array[++this.offset - 1]);
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-6"
	)
	public void method5500(int var1) {
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-2"
	)
	@Export("writeIntME")
	public void writeIntME(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)(var1 + 128);
	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1695551709"
	)
	public void method5502(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 + 128);
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-64"
	)
	public int method5503() {
		this.offset += 2;
		return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2105428724"
	)
	public int method5459() {
		this.offset += 2;
		return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "7305"
	)
	public int method5514() {
		this.offset += 2;
		return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "18379"
	)
	public int method5506() {
		this.offset += 2;
		int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1861264070"
	)
	public int method5584() {
		this.offset += 2;
		int var1 = (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-32"
	)
	public void method5466(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)var1;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1460382327"
	)
	public int method5508() {
		this.offset += 3;
		return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 2] & 255);
	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-45"
	)
	@Export("writeIntLE")
	public void writeIntLE(int var1) {
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
	}

	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1216853295"
	)
	@Export("writeIntLE16")
	public void writeIntLE16(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
	}

	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "-10712"
	)
	@Export("writeShortLE")
	public void writeShortLE(int var1) {
		this.array[++this.offset - 1] = (byte)(var1 >> 16);
		this.array[++this.offset - 1] = (byte)(var1 >> 24);
		this.array[++this.offset - 1] = (byte)var1;
		this.array[++this.offset - 1] = (byte)(var1 >> 8);
	}

	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "101"
	)
	public int method5587() {
		this.offset += 4;
		return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24);
	}

	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-121"
	)
	public int method5580() {
		this.offset += 4;
		return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8) + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16);
	}

	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1549007830"
	)
	public int method5515() {
		this.offset += 4;
		return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16) + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lli;IIIB)V",
		garbageValue = "15"
	)
	static void method5703(Sprite var0, int var1, int var2, int var3) {
		DemotingHashTable var4 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var6 = (long)(var3 << 16 | var1 << 8 | var2);
		var4.put(var0, var6, var0.pixels.length * 4);
	}
}
