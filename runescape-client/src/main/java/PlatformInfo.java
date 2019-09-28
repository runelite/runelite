import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -760772209
	)
	int field3903;
	@ObfuscatedName("ax")
	boolean field3913;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -68737307
	)
	int field3914;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1228924445
	)
	int field3915;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1993401909
	)
	int field3926;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1530437153
	)
	int field3917;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1258615957
	)
	int field3918;
	@ObfuscatedName("ai")
	boolean field3919;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1358828589
	)
	int field3920;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -931926903
	)
	int field3921;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1834478057
	)
	int field3922;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 400152439
	)
	int field3907;
	@ObfuscatedName("ah")
	String field3924;
	@ObfuscatedName("ag")
	String field3925;
	@ObfuscatedName("aj")
	String field3934;
	@ObfuscatedName("ay")
	String field3932;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 118098315
	)
	int field3928;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 246544057
	)
	int field3923;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 84742935
	)
	int field3930;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 1315916991
	)
	int field3910;
	@ObfuscatedName("bh")
	String field3927;
	@ObfuscatedName("bd")
	String field3906;
	@ObfuscatedName("bm")
	int[] field3912;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 1280064129
	)
	int field3935;
	@ObfuscatedName("bj")
	String field3936;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3912 = new int[3];
		this.field3903 = var1;
		this.field3913 = var2;
		this.field3914 = var3;
		this.field3915 = var4;
		this.field3926 = var5;
		this.field3917 = var6;
		this.field3918 = var7;
		this.field3919 = var8;
		this.field3920 = var9;
		this.field3921 = var10;
		this.field3922 = var11;
		this.field3907 = var12;
		this.field3924 = var13;
		this.field3925 = var14;
		this.field3934 = var15;
		this.field3932 = var16;
		this.field3928 = var17;
		this.field3923 = var18;
		this.field3930 = var19;
		this.field3910 = var20;
		this.field3927 = var21;
		this.field3906 = var22;
		this.field3912 = var23;
		this.field3935 = var24;
		this.field3936 = var25;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "1592227856"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3903);
		var1.writeByte(this.field3913 ? 1 : 0);
		var1.writeShort(this.field3914);
		var1.writeByte(this.field3915);
		var1.writeByte(this.field3926);
		var1.writeByte(this.field3917);
		var1.writeByte(this.field3918);
		var1.writeByte(this.field3919 ? 1 : 0);
		var1.writeShort(this.field3920);
		var1.writeByte(this.field3921);
		var1.writeMedium(this.field3922);
		var1.writeShort(this.field3907);
		var1.writeStringCp1252NullCircumfixed(this.field3924);
		var1.writeStringCp1252NullCircumfixed(this.field3925);
		var1.writeStringCp1252NullCircumfixed(this.field3934);
		var1.writeStringCp1252NullCircumfixed(this.field3932);
		var1.writeByte(this.field3923);
		var1.writeShort(this.field3928);
		var1.writeStringCp1252NullCircumfixed(this.field3927);
		var1.writeStringCp1252NullCircumfixed(this.field3906);
		var1.writeByte(this.field3930);
		var1.writeByte(this.field3910);

		for (int var2 = 0; var2 < this.field3912.length; ++var2) {
			var1.writeInt(this.field3912[var2]);
		}

		var1.writeInt(this.field3935);
		var1.writeStringCp1252NullCircumfixed(this.field3936);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "3"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + UserComparator5.method3387(this.field3924);
		var2 += UserComparator5.method3387(this.field3925);
		var2 += UserComparator5.method3387(this.field3934);
		var2 += UserComparator5.method3387(this.field3932);
		var2 += UserComparator5.method3387(this.field3927);
		var2 += UserComparator5.method3387(this.field3906);
		var2 += UserComparator5.method3387(this.field3936);
		return var2;
	}
}
