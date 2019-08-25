import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 1707055259
	)
	int field3938;
	@ObfuscatedName("ax")
	boolean field3939;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -2001152495
	)
	int field3953;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -695975343
	)
	int field3941;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1607985897
	)
	int field3942;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 2094714279
	)
	int field3961;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -861639539
	)
	int field3944;
	@ObfuscatedName("ac")
	boolean field3945;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 2056129
	)
	int field3962;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1736431355
	)
	int field3943;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -233301775
	)
	int field3948;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 847094315
	)
	int field3949;
	@ObfuscatedName("ai")
	String field3934;
	@ObfuscatedName("ak")
	String field3951;
	@ObfuscatedName("ah")
	String field3952;
	@ObfuscatedName("am")
	String field3946;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1073737943
	)
	int field3936;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 1191319899
	)
	int field3955;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1715941693
	)
	int field3956;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1742476945
	)
	int field3957;
	@ObfuscatedName("bz")
	String field3947;
	@ObfuscatedName("bi")
	String field3959;
	@ObfuscatedName("bg")
	int[] field3960;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1399141483
	)
	int field3935;
	@ObfuscatedName("bm")
	String field3931;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3960 = new int[3];
		this.field3938 = var1;
		this.field3939 = var2;
		this.field3953 = var3;
		this.field3941 = var4;
		this.field3942 = var5;
		this.field3961 = var6;
		this.field3944 = var7;
		this.field3945 = var8;
		this.field3962 = var9;
		this.field3943 = var10;
		this.field3948 = var11;
		this.field3949 = var12;
		this.field3934 = var13;
		this.field3951 = var14;
		this.field3952 = var15;
		this.field3946 = var16;
		this.field3936 = var17;
		this.field3955 = var18;
		this.field3956 = var19;
		this.field3957 = var20;
		this.field3947 = var21;
		this.field3959 = var22;
		this.field3960 = var23;
		this.field3935 = var24;
		this.field3931 = var25;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-1667072289"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3938);
		var1.writeByte(this.field3939 ? 1 : 0);
		var1.writeShort(this.field3953);
		var1.writeByte(this.field3941);
		var1.writeByte(this.field3942);
		var1.writeByte(this.field3961);
		var1.writeByte(this.field3944);
		var1.writeByte(this.field3945 ? 1 : 0);
		var1.writeShort(this.field3962);
		var1.writeByte(this.field3943);
		var1.writeMedium(this.field3948);
		var1.writeShort(this.field3949);
		var1.writeStringCp1252NullCircumfixed(this.field3934);
		var1.writeStringCp1252NullCircumfixed(this.field3951);
		var1.writeStringCp1252NullCircumfixed(this.field3952);
		var1.writeStringCp1252NullCircumfixed(this.field3946);
		var1.writeByte(this.field3955);
		var1.writeShort(this.field3936);
		var1.writeStringCp1252NullCircumfixed(this.field3947);
		var1.writeStringCp1252NullCircumfixed(this.field3959);
		var1.writeByte(this.field3956);
		var1.writeByte(this.field3957);

		for (int var2 = 0; var2 < this.field3960.length; ++var2) {
			var1.writeInt(this.field3960[var2]);
		}

		var1.writeInt(this.field3935);
		var1.writeStringCp1252NullCircumfixed(this.field3931);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-5"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + class13.method152(this.field3934);
		var2 += class13.method152(this.field3951);
		var2 += class13.method152(this.field3952);
		var2 += class13.method152(this.field3946);
		var2 += class13.method152(this.field3947);
		var2 += class13.method152(this.field3959);
		var2 += class13.method152(this.field3931);
		return var2;
	}
}
