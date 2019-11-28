import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -319995609
	)
	int field3917;
	@ObfuscatedName("ak")
	boolean field3909;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 689449567
	)
	int field3904;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 508729537
	)
	int field3911;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -42607037
	)
	int field3912;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -624534927
	)
	int field3907;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1257010089
	)
	int field3914;
	@ObfuscatedName("ac")
	boolean field3915;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 1031009357
	)
	int field3916;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 1719417791
	)
	int field3910;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -62226837
	)
	int field3930;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 364104521
	)
	int field3906;
	@ObfuscatedName("an")
	String field3920;
	@ObfuscatedName("al")
	String field3921;
	@ObfuscatedName("ay")
	String field3913;
	@ObfuscatedName("ax")
	String field3923;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1064226031
	)
	int field3924;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1565693073
	)
	int field3925;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1111257325
	)
	int field3919;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1835106139
	)
	int field3927;
	@ObfuscatedName("bo")
	String field3928;
	@ObfuscatedName("bx")
	String field3929;
	@ObfuscatedName("bu")
	int[] field3902;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -1505377963
	)
	int field3931;
	@ObfuscatedName("bn")
	String field3932;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3902 = new int[3];
		this.field3917 = var1;
		this.field3909 = var2;
		this.field3904 = var3;
		this.field3911 = var4;
		this.field3912 = var5;
		this.field3907 = var6;
		this.field3914 = var7;
		this.field3915 = var8;
		this.field3916 = var9;
		this.field3910 = var10;
		this.field3930 = var11;
		this.field3906 = var12;
		this.field3920 = var13;
		this.field3921 = var14;
		this.field3913 = var15;
		this.field3923 = var16;
		this.field3924 = var17;
		this.field3925 = var18;
		this.field3919 = var19;
		this.field3927 = var20;
		this.field3928 = var21;
		this.field3929 = var22;
		this.field3902 = var23;
		this.field3931 = var24;
		this.field3932 = var25;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "0"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3917);
		var1.writeByte(this.field3909 ? 1 : 0);
		var1.writeShort(this.field3904);
		var1.writeByte(this.field3911);
		var1.writeByte(this.field3912);
		var1.writeByte(this.field3907);
		var1.writeByte(this.field3914);
		var1.writeByte(this.field3915 ? 1 : 0);
		var1.writeShort(this.field3916);
		var1.writeByte(this.field3910);
		var1.writeMedium(this.field3930);
		var1.writeShort(this.field3906);
		var1.writeStringCp1252NullCircumfixed(this.field3920);
		var1.writeStringCp1252NullCircumfixed(this.field3921);
		var1.writeStringCp1252NullCircumfixed(this.field3913);
		var1.writeStringCp1252NullCircumfixed(this.field3923);
		var1.writeByte(this.field3925);
		var1.writeShort(this.field3924);
		var1.writeStringCp1252NullCircumfixed(this.field3928);
		var1.writeStringCp1252NullCircumfixed(this.field3929);
		var1.writeByte(this.field3919);
		var1.writeByte(this.field3927);

		for (int var2 = 0; var2 < this.field3902.length; ++var2) {
			var1.writeInt(this.field3902[var2]);
		}

		var1.writeInt(this.field3931);
		var1.writeStringCp1252NullCircumfixed(this.field3932);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1694197282"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		String var4 = this.field3920;
		int var3 = var4.length() + 2;
		int var23 = var3 + var1;
		String var7 = this.field3921;
		int var6 = var7.length() + 2;
		var23 += var6;
		String var10 = this.field3913;
		int var9 = var10.length() + 2;
		var23 += var9;
		String var13 = this.field3923;
		int var12 = var13.length() + 2;
		var23 += var12;
		String var16 = this.field3928;
		int var15 = var16.length() + 2;
		var23 += var15;
		String var19 = this.field3929;
		int var18 = var19.length() + 2;
		var23 += var18;
		String var22 = this.field3932;
		int var21 = var22.length() + 2;
		var23 += var21;
		return var23;
	}
}
