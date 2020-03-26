import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("ai")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -523982811
	)
	@Export("index")
	int index;
	@ObfuscatedName("f")
	volatile boolean field3154;
	@ObfuscatedName("ae")
	boolean field3156;
	@ObfuscatedName("an")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 379652259
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1679567941
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 843484953
	)
	int field3161;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Llq;Llq;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3154 = false;
		this.field3156 = false;
		this.field3161 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3156 = var6;
		class3.method58(this, this.index);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-11"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		int var2 = this.index;
		long var3 = (long)((var2 << 16) + var1);
		NetFileRequest var5 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var3);
		if (var5 != null) {
			NetCache.NetCache_pendingWritesQueue.addLast(var5);
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "9"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else {
			return this.validGroups[var1] ? 100 : class3.method59(this.index, var1);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-42"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			DynamicObject.method2342(var1, this.archiveDisk, this);
		} else {
			Frames.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1875788056"
	)
	public boolean method4343() {
		return this.field3154;
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1046602653"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3154) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var1 = class3.method59(255, this.index);
			if (var1 >= 100) {
				var1 = 99;
			}

			return var1;
		}
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "60"
	)
	@Export("loadIndex")
	public void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			DynamicObject.method2342(this.index, this.masterDisk, this);
		} else {
			Frames.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "(I[BZZI)V",
		garbageValue = "-1921982231"
	)
	@Export("write")
	public void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3154) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				int var5 = this.index;
				ArchiveDisk var6 = this.masterDisk;
				ArchiveDiskAction var7 = new ArchiveDiskAction();
				var7.type = 0;
				var7.key = (long)var5;
				var7.data = var2;
				var7.archiveDisk = var6;
				synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var7);
				}

				synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
					if (ArchiveDiskActionHandler.field3151 == 0) {
						class197.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
						class197.ArchiveDiskActionHandler_thread.setDaemon(true);
						class197.ArchiveDiskActionHandler_thread.start();
						class197.ArchiveDiskActionHandler_thread.setPriority(5);
					}

					ArchiveDiskActionHandler.field3151 = 600;
				}
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				WallDecoration.method3402(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				Object[] var11 = super.groups;
				Object var15;
				if (var2 == null) {
					var15 = null;
				} else if (var2.length > 136) {
					DirectByteArrayCopier var8 = new DirectByteArrayCopier();
					var8.set(var2);
					var15 = var8;
				} else {
					var15 = var2;
				}

				var11[var1] = var15;
			}
		}

	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		signature = "(Llq;I[BZI)V",
		garbageValue = "246844871"
	)
	@Export("load")
	public void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3154) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				Frames.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				Frames.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var11 = new Buffer(class217.decompressBytes(var3));
			int var12 = var11.readUnsignedByte();
			if (var12 != 5 && var12 != 6) {
				throw new RuntimeException(var12 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var12 >= 6) {
				var8 = var11.readInt();
			}

			if (var8 != this.indexVersion) {
				Frames.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3161) {
				this.field3154 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3156 || var4) {
					Frames.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3156 || var4) {
					Frames.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			this.validGroups[var2] = true;
			if (var4) {
				Object[] var7 = super.groups;
				Object var9;
				if (var3 == null) {
					var9 = null;
				} else if (var3.length > 136) {
					DirectByteArrayCopier var10 = new DirectByteArrayCopier();
					var10.set(var3);
					var9 = var10;
				} else {
					var9 = var3;
				}

				var7[var2] = var9;
			}
		}

	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-539943157"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3154 = true;
		} else {
			this.field3161 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					class228.method4204(var1, this.archiveDisk, this);
					this.field3161 = var1;
				}
			}

			if (this.field3161 == -1) {
				this.field3154 = true;
			}

		}
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "18"
	)
	public boolean method4352(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "2030059947"
	)
	public boolean method4353(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "110"
	)
	@Export("loadPercent")
	public int loadPercent() {
		int var1 = 0;
		int var2 = 0;

		int var3;
		for (var3 = 0; var3 < super.groups.length; ++var3) {
			if (super.fileCounts[var3] > 0) {
				var1 += 100;
				var2 += this.groupLoadPercent(var3);
			}
		}

		if (var1 == 0) {
			return 100;
		} else {
			var3 = var2 * 100 / var1;
			return var3;
		}
	}
}
