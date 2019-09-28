import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mh")
@Implements("AccessFile")
public final class AccessFile {
	@ObfuscatedName("z")
	@Export("file")
	RandomAccessFile file;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = 4557235660739599375L
	)
	@Export("maxSize")
	final long maxSize;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = 2697348286360897637L
	)
	@Export("offset")
	long offset;

	public AccessFile(File var1, String var2, long var3) throws IOException {
		if (-1L == var3) {
			var3 = Long.MAX_VALUE;
		}

		if (var1.length() > var3) {
			var1.delete();
		}

		this.file = new RandomAccessFile(var1, var2);
		this.maxSize = var3;
		this.offset = 0L;
		int var5 = this.file.read();
		if (var5 != -1 && !var2.equals("r")) {
			this.file.seek(0L);
			this.file.write(var5);
		}

		this.file.seek(0L);
	}

	@ObfuscatedName("z")
	@Export("seek")
	final void seek(long var1) throws IOException {
		this.file.seek(var1);
		this.offset = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "988503907"
	)
	@Export("write")
	public final void write(byte[] var1, int var2, int var3) throws IOException {
		if ((long)var3 + this.offset > this.maxSize) {
			this.file.seek(this.maxSize);
			this.file.write(1);
			throw new EOFException();
		} else {
			this.file.write(var1, var2, var3);
			this.offset += (long)var3;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "546615303"
	)
	@Export("close")
	public final void close() throws IOException {
		this.closeSync(false);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1331216421"
	)
	@Export("closeSync")
	public final void closeSync(boolean var1) throws IOException {
		if (this.file != null) {
			if (var1) {
				try {
					this.file.getFD().sync();
				} catch (SyncFailedException var3) {
				}
			}

			this.file.close();
			this.file = null;
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "773958711"
	)
	@Export("length")
	public final long length() throws IOException {
		return this.file.length();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "-26512267"
	)
	@Export("read")
	public final int read(byte[] var1, int var2, int var3) throws IOException {
		int var4 = this.file.read(var1, var2, var3);
		if (var4 > 0) {
			this.offset += (long)var4;
		}

		return var4;
	}

	protected void finalize() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.close();
		}

	}
}
