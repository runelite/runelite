import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mq")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("gd")
	@ObfuscatedGetter(
		intValue = -610946691
	)
	static int field3959;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 47209177
	)
	int field3934;
	@ObfuscatedName("at")
	boolean field3947;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1154854303
	)
	int field3938;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -1112820969
	)
	int field3937;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -655667677
	)
	int field3928;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 518978981
	)
	int field3942;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 2071386103
	)
	int field3940;
	@ObfuscatedName("aq")
	boolean field3941;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1697334687
	)
	int field3951;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1122579007
	)
	int field3939;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -807185627
	)
	int field3944;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1858381727
	)
	int field3945;
	@ObfuscatedName("aj")
	String field3946;
	@ObfuscatedName("ay")
	String field3927;
	@ObfuscatedName("ad")
	String field3948;
	@ObfuscatedName("ac")
	String field3949;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -100344441
	)
	int field3950;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -932660889
	)
	int field3957;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 472073959
	)
	int field3929;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -1521683725
	)
	int field3953;
	@ObfuscatedName("bc")
	String field3954;
	@ObfuscatedName("bo")
	String field3955;
	@ObfuscatedName("bd")
	int[] field3956;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 912496001
	)
	int field3943;
	@ObfuscatedName("bu")
	String field3952;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3956 = new int[3];
		this.field3934 = var1;
		this.field3947 = var2;
		this.field3938 = var3;
		this.field3937 = var4;
		this.field3928 = var5;
		this.field3942 = var6;
		this.field3940 = var7;
		this.field3941 = var8;
		this.field3951 = var9;
		this.field3939 = var10;
		this.field3944 = var11;
		this.field3945 = var12;
		this.field3946 = var13;
		this.field3927 = var14;
		this.field3948 = var15;
		this.field3949 = var16;
		this.field3950 = var17;
		this.field3957 = var18;
		this.field3929 = var19;
		this.field3953 = var20;
		this.field3954 = var21;
		this.field3955 = var22;
		this.field3956 = var23;
		this.field3943 = var24;
		this.field3952 = var25;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1274635079"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3934);
		var1.writeByte(this.field3947 ? 1 : 0);
		var1.writeShort(this.field3938);
		var1.writeByte(this.field3937);
		var1.writeByte(this.field3928);
		var1.writeByte(this.field3942);
		var1.writeByte(this.field3940);
		var1.writeByte(this.field3941 ? 1 : 0);
		var1.writeShort(this.field3951);
		var1.writeByte(this.field3939);
		var1.writeMedium(this.field3944);
		var1.writeShort(this.field3945);
		var1.writeStringCp1252NullCircumfixed(this.field3946);
		var1.writeStringCp1252NullCircumfixed(this.field3927);
		var1.writeStringCp1252NullCircumfixed(this.field3948);
		var1.writeStringCp1252NullCircumfixed(this.field3949);
		var1.writeByte(this.field3957);
		var1.writeShort(this.field3950);
		var1.writeStringCp1252NullCircumfixed(this.field3954);
		var1.writeStringCp1252NullCircumfixed(this.field3955);
		var1.writeByte(this.field3929);
		var1.writeByte(this.field3953);

		for (int var2 = 0; var2 < this.field3956.length; ++var2) {
			var1.writeInt(this.field3956[var2]);
		}

		var1.writeInt(this.field3943);
		var1.writeStringCp1252NullCircumfixed(this.field3952);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-86"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + ArchiveDiskActionHandler.method4340(this.field3946);
		var2 += ArchiveDiskActionHandler.method4340(this.field3927);
		var2 += ArchiveDiskActionHandler.method4340(this.field3948);
		var2 += ArchiveDiskActionHandler.method4340(this.field3949);
		var2 += ArchiveDiskActionHandler.method4340(this.field3954);
		var2 += ArchiveDiskActionHandler.method4340(this.field3955);
		var2 += ArchiveDiskActionHandler.method4340(this.field3952);
		return var2;
	}
}
