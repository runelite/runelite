import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 37588435
	)
	int field3915;
	@ObfuscatedName("at")
	boolean field3930;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1883484511
	)
	int field3917;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -2081208413
	)
	int field3918;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 999773569
	)
	int field3913;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 516607859
	)
	int field3919;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1900568439
	)
	int field3921;
	@ObfuscatedName("au")
	boolean field3922;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -1778909967
	)
	int field3923;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1710231033
	)
	int field3924;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -468207561
	)
	int field3925;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1974137013
	)
	int field3926;
	@ObfuscatedName("ay")
	String field3927;
	@ObfuscatedName("ad")
	String field3928;
	@ObfuscatedName("al")
	String field3938;
	@ObfuscatedName("ah")
	String field3932;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -144799921
	)
	int field3931;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 363262683
	)
	int field3936;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 529470443
	)
	int field3933;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -1264069707
	)
	int field3934;
	@ObfuscatedName("bw")
	String field3935;
	@ObfuscatedName("bo")
	String field3907;
	@ObfuscatedName("bn")
	int[] field3937;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -1729489163
	)
	int field3905;
	@ObfuscatedName("bz")
	String field3939;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3937 = new int[3];
		this.field3915 = var1;
		this.field3930 = var2;
		this.field3917 = var3;
		this.field3918 = var4;
		this.field3913 = var5;
		this.field3919 = var6;
		this.field3921 = var7;
		this.field3922 = var8;
		this.field3923 = var9;
		this.field3924 = var10;
		this.field3925 = var11;
		this.field3926 = var12;
		this.field3927 = var13;
		this.field3928 = var14;
		this.field3938 = var15;
		this.field3932 = var16;
		this.field3931 = var17;
		this.field3936 = var18;
		this.field3933 = var19;
		this.field3934 = var20;
		this.field3935 = var21;
		this.field3907 = var22;
		this.field3937 = var23;
		this.field3905 = var24;
		this.field3939 = var25;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-766634357"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3915);
		var1.writeByte(this.field3930 ? 1 : 0);
		var1.writeShort(this.field3917);
		var1.writeByte(this.field3918);
		var1.writeByte(this.field3913);
		var1.writeByte(this.field3919);
		var1.writeByte(this.field3921);
		var1.writeByte(this.field3922 ? 1 : 0);
		var1.writeShort(this.field3923);
		var1.writeByte(this.field3924);
		var1.writeMedium(this.field3925);
		var1.writeShort(this.field3926);
		var1.writeStringCp1252NullCircumfixed(this.field3927);
		var1.writeStringCp1252NullCircumfixed(this.field3928);
		var1.writeStringCp1252NullCircumfixed(this.field3938);
		var1.writeStringCp1252NullCircumfixed(this.field3932);
		var1.writeByte(this.field3936);
		var1.writeShort(this.field3931);
		var1.writeStringCp1252NullCircumfixed(this.field3935);
		var1.writeStringCp1252NullCircumfixed(this.field3907);
		var1.writeByte(this.field3933);
		var1.writeByte(this.field3934);

		for (int var2 = 0; var2 < this.field3937.length; ++var2) {
			var1.writeInt(this.field3937[var2]);
		}

		var1.writeInt(this.field3905);
		var1.writeStringCp1252NullCircumfixed(this.field3939);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1869130367"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var5 = var1 + GrandExchangeOfferWorldComparator.method80(this.field3927);
		var5 += GrandExchangeOfferWorldComparator.method80(this.field3928);
		var5 += GrandExchangeOfferWorldComparator.method80(this.field3938);
		var5 += GrandExchangeOfferWorldComparator.method80(this.field3932);
		var5 += GrandExchangeOfferWorldComparator.method80(this.field3935);
		String var4 = this.field3907;
		int var3 = var4.length() + 2;
		var5 += var3;
		var5 += GrandExchangeOfferWorldComparator.method80(this.field3939);
		return var5;
	}
}
