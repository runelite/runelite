import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1353612323
	)
	int field3922;
	@ObfuscatedName("av")
	boolean field3911;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1724945833
	)
	int field3927;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1892503757
	)
	int field3913;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -769451899
	)
	int field3914;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -2046511239
	)
	int field3917;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1112004663
	)
	int field3916;
	@ObfuscatedName("aj")
	boolean field3912;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -864167753
	)
	int field3918;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1103652803
	)
	int field3929;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 43977127
	)
	int field3921;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 634727617
	)
	int field3915;
	@ObfuscatedName("ay")
	String field3923;
	@ObfuscatedName("az")
	String field3924;
	@ObfuscatedName("ao")
	String field3925;
	@ObfuscatedName("ai")
	String field3926;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -1691055317
	)
	int field3931;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 598634221
	)
	int field3933;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 953656517
	)
	int field3908;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1818308125
	)
	int field3930;
	@ObfuscatedName("bg")
	String field3928;
	@ObfuscatedName("bc")
	String field3932;
	@ObfuscatedName("bd")
	int[] field3905;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 2080789709
	)
	int field3934;
	@ObfuscatedName("bl")
	String field3901;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3905 = new int[3];
		this.field3922 = var1;
		this.field3911 = var2;
		this.field3927 = var3;
		this.field3913 = var4;
		this.field3914 = var5;
		this.field3917 = var6;
		this.field3916 = var7;
		this.field3912 = var8;
		this.field3918 = var9;
		this.field3929 = var10;
		this.field3921 = var11;
		this.field3915 = var12;
		this.field3923 = var13;
		this.field3924 = var14;
		this.field3925 = var15;
		this.field3926 = var16;
		this.field3931 = var17;
		this.field3933 = var18;
		this.field3908 = var19;
		this.field3930 = var20;
		this.field3928 = var21;
		this.field3932 = var22;
		this.field3905 = var23;
		this.field3934 = var24;
		this.field3901 = var25;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-2033458104"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3922);
		var1.writeByte(this.field3911 ? 1 : 0);
		var1.writeShort(this.field3927);
		var1.writeByte(this.field3913);
		var1.writeByte(this.field3914);
		var1.writeByte(this.field3917);
		var1.writeByte(this.field3916);
		var1.writeByte(this.field3912 ? 1 : 0);
		var1.writeShort(this.field3918);
		var1.writeByte(this.field3929);
		var1.writeMedium(this.field3921);
		var1.writeShort(this.field3915);
		var1.writeStringCp1252NullCircumfixed(this.field3923);
		var1.writeStringCp1252NullCircumfixed(this.field3924);
		var1.writeStringCp1252NullCircumfixed(this.field3925);
		var1.writeStringCp1252NullCircumfixed(this.field3926);
		var1.writeByte(this.field3933);
		var1.writeShort(this.field3931);
		var1.writeStringCp1252NullCircumfixed(this.field3928);
		var1.writeStringCp1252NullCircumfixed(this.field3932);
		var1.writeByte(this.field3908);
		var1.writeByte(this.field3930);

		for (int var2 = 0; var2 < this.field3905.length; ++var2) {
			var1.writeInt(this.field3905[var2]);
		}

		var1.writeInt(this.field3934);
		var1.writeStringCp1252NullCircumfixed(this.field3901);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-963267335"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + Buddy.method5297(this.field3923);
		var2 += Buddy.method5297(this.field3924);
		var2 += Buddy.method5297(this.field3925);
		var2 += Buddy.method5297(this.field3926);
		var2 += Buddy.method5297(this.field3928);
		var2 += Buddy.method5297(this.field3932);
		var2 += Buddy.method5297(this.field3901);
		return var2;
	}
}
