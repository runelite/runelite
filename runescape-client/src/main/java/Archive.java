import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("az")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1512012277
	)
	@Export("index")
	int index;
	@ObfuscatedName("u")
	volatile boolean field3159;
	@ObfuscatedName("ae")
	boolean field3165;
	@ObfuscatedName("af")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 291322429
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1082053615
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1711156023
	)
	int field3157;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lky;Lky;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3159 = false;
		this.field3165 = false;
		this.field3157 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3165 = var6;
		class83.method2110(this, this.index);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1758408707"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		class210.method4032(this.index, var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "27"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else if (this.validGroups[var1]) {
			return 100;
		} else {
			int var3 = this.index;
			long var4 = (long)((var3 << 16) + var1);
			int var2;
			if (GrandExchangeEvent.NetCache_currentResponse != null && GrandExchangeEvent.NetCache_currentResponse.key == var4) {
				var2 = VertexNormal.NetCache_responseArchiveBuffer.offset * 99 / (VertexNormal.NetCache_responseArchiveBuffer.array.length - GrandExchangeEvent.NetCache_currentResponse.padding) + 1;
			} else {
				var2 = 0;
			}

			return var2;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1179679189"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			NetSocket.method3613(var1, this.archiveDisk, this);
		} else {
			BuddyRankComparator.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-757168814"
	)
	public boolean method4372() {
		return this.field3159;
	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1215614912"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3159) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var2 = this.index;
			long var3 = (long)(var2 + 16711680);
			int var1;
			if (GrandExchangeEvent.NetCache_currentResponse != null && var3 == GrandExchangeEvent.NetCache_currentResponse.key) {
				var1 = VertexNormal.NetCache_responseArchiveBuffer.offset * 99 / (VertexNormal.NetCache_responseArchiveBuffer.array.length - GrandExchangeEvent.NetCache_currentResponse.padding) + 1;
			} else {
				var1 = 0;
			}

			int var5 = var1;
			if (var1 >= 100) {
				var5 = 99;
			}

			return var5;
		}
	}

	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "0"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			NetSocket.method3613(this.index, this.masterDisk, this);
		} else {
			BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "(I[BZZI)V",
		garbageValue = "1506082666"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3159) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				BuddyRankComparator.method3507(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				BuddyRankComparator.method3507(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				Object[] var5 = super.groups;
				Object var7;
				if (var2 == null) {
					var7 = null;
				} else if (var2.length > 136) {
					DirectByteArrayCopier var8 = new DirectByteArrayCopier();
					var8.set(var2);
					var7 = var8;
				} else {
					var7 = var2;
				}

				var5[var1] = var7;
			}
		}

	}

	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "(Lky;I[BZB)V",
		garbageValue = "-124"
	)
	@Export("load")
	void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3159) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var11 = new Buffer(class2.decompressBytes(var3));
			int var12 = var11.readUnsignedByte();
			if (var12 != 5 && var12 != 6) {
				throw new RuntimeException(var12 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var12 >= 6) {
				var8 = var11.readInt();
			}

			if (var8 != this.indexVersion) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3157) {
				this.field3159 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3165 || var4) {
					BuddyRankComparator.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3165 || var4) {
					BuddyRankComparator.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
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

	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-901365537"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3159 = true;
		} else {
			this.field3157 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					ArchiveDisk var2 = this.archiveDisk;
					ArchiveDiskAction var4 = new ArchiveDiskAction();
					var4.type = 1;
					var4.key = (long)var1;
					var4.archiveDisk = var2;
					var4.archive = this;
					synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
						ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var4);
					}

					NetSocket.method3595();
					this.field3157 = var1;
				}
			}

			if (this.field3157 == -1) {
				this.field3159 = true;
			}

		}
	}

	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1567701044"
	)
	public boolean method4347(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-507892306"
	)
	public boolean method4348(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1870889361"
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
