import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lv")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 673816071
	)
	int field3911;
	@ObfuscatedName("aa")
	boolean field3904;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1159209885
	)
	int field3913;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 2116751685
	)
	int field3914;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1612963129
	)
	int field3915;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -544797125
	)
	int field3916;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1024722961
	)
	int field3917;
	@ObfuscatedName("ar")
	boolean field3935;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1351692389
	)
	int field3919;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 2094154461
	)
	int field3920;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 555115055
	)
	int field3921;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -2000907591
	)
	int field3922;
	@ObfuscatedName("at")
	String field3934;
	@ObfuscatedName("an")
	String field3924;
	@ObfuscatedName("ag")
	String field3907;
	@ObfuscatedName("ai")
	String field3926;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -2099364457
	)
	int field3927;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1890356539
	)
	int field3928;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -1529496749
	)
	int field3929;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -735779413
	)
	int field3930;
	@ObfuscatedName("bf")
	String field3931;
	@ObfuscatedName("bc")
	String field3932;
	@ObfuscatedName("bk")
	int[] field3933;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -1285130001
	)
	int field3923;
	@ObfuscatedName("bi")
	String field3906;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3933 = new int[3];
		this.field3911 = var1;
		this.field3904 = var2;
		this.field3913 = var3;
		this.field3914 = var4;
		this.field3915 = var5;
		this.field3916 = var6;
		this.field3917 = var7;
		this.field3935 = var8;
		this.field3919 = var9;
		this.field3920 = var10;
		this.field3921 = var11;
		this.field3922 = var12;
		this.field3934 = var13;
		this.field3924 = var14;
		this.field3907 = var15;
		this.field3926 = var16;
		this.field3927 = var17;
		this.field3928 = var18;
		this.field3929 = var19;
		this.field3930 = var20;
		this.field3931 = var21;
		this.field3932 = var22;
		this.field3933 = var23;
		this.field3923 = var24;
		this.field3906 = var25;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-119977532"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3911);
		var1.writeByte(this.field3904 ? 1 : 0);
		var1.writeShort(this.field3913);
		var1.writeByte(this.field3914);
		var1.writeByte(this.field3915);
		var1.writeByte(this.field3916);
		var1.writeByte(this.field3917);
		var1.writeByte(this.field3935 ? 1 : 0);
		var1.writeShort(this.field3919);
		var1.writeByte(this.field3920);
		var1.writeMedium(this.field3921);
		var1.writeShort(this.field3922);
		var1.writeStringCp1252NullCircumfixed(this.field3934);
		var1.writeStringCp1252NullCircumfixed(this.field3924);
		var1.writeStringCp1252NullCircumfixed(this.field3907);
		var1.writeStringCp1252NullCircumfixed(this.field3926);
		var1.writeByte(this.field3928);
		var1.writeShort(this.field3927);
		var1.writeStringCp1252NullCircumfixed(this.field3931);
		var1.writeStringCp1252NullCircumfixed(this.field3932);
		var1.writeByte(this.field3929);
		var1.writeByte(this.field3930);

		for (int var2 = 0; var2 < this.field3933.length; ++var2) {
			var1.writeInt(this.field3933[var2]);
		}

		var1.writeInt(this.field3923);
		var1.writeStringCp1252NullCircumfixed(this.field3906);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + DirectByteArrayCopier.method4012(this.field3934);
		var2 += DirectByteArrayCopier.method4012(this.field3924);
		var2 += DirectByteArrayCopier.method4012(this.field3907);
		var2 += DirectByteArrayCopier.method4012(this.field3926);
		var2 += DirectByteArrayCopier.method4012(this.field3931);
		var2 += DirectByteArrayCopier.method4012(this.field3932);
		var2 += DirectByteArrayCopier.method4012(this.field3906);
		return var2;
	}
}
