import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1262166811
	)
	int field3910;
	@ObfuscatedName("ad")
	boolean field3918;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -233370459
	)
	int field3912;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -643959755
	)
	int field3913;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 368561611
	)
	int field3914;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1553931981
	)
	int field3915;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 401263417
	)
	int field3903;
	@ObfuscatedName("ak")
	boolean field3917;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -569350389
	)
	int field3908;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 337511837
	)
	int field3925;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1464874395
	)
	int field3916;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1301497237
	)
	int field3922;
	@ObfuscatedName("ar")
	String field3923;
	@ObfuscatedName("ac")
	String field3921;
	@ObfuscatedName("az")
	String field3904;
	@ObfuscatedName("ai")
	String field3926;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1840491471
	)
	int field3927;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1377986557
	)
	int field3928;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1434416475
	)
	int field3929;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 549391923
	)
	int field3931;
	@ObfuscatedName("bn")
	String field3911;
	@ObfuscatedName("bk")
	String field3932;
	@ObfuscatedName("bp")
	int[] field3933;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -419981447
	)
	int field3934;
	@ObfuscatedName("bi")
	String field3935;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3933 = new int[3];
		this.field3910 = var1;
		this.field3918 = var2;
		this.field3912 = var3;
		this.field3913 = var4;
		this.field3914 = var5;
		this.field3915 = var6;
		this.field3903 = var7;
		this.field3917 = var8;
		this.field3908 = var9;
		this.field3925 = var10;
		this.field3916 = var11;
		this.field3922 = var12;
		this.field3923 = var13;
		this.field3921 = var14;
		this.field3904 = var15;
		this.field3926 = var16;
		this.field3927 = var17;
		this.field3928 = var18;
		this.field3929 = var19;
		this.field3931 = var20;
		this.field3911 = var21;
		this.field3932 = var22;
		this.field3933 = var23;
		this.field3934 = var24;
		this.field3935 = var25;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-712263030"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3910);
		var1.writeByte(this.field3918 ? 1 : 0);
		var1.writeShort(this.field3912);
		var1.writeByte(this.field3913);
		var1.writeByte(this.field3914);
		var1.writeByte(this.field3915);
		var1.writeByte(this.field3903);
		var1.writeByte(this.field3917 ? 1 : 0);
		var1.writeShort(this.field3908);
		var1.writeByte(this.field3925);
		var1.writeMedium(this.field3916);
		var1.writeShort(this.field3922);
		var1.writeStringCp1252NullCircumfixed(this.field3923);
		var1.writeStringCp1252NullCircumfixed(this.field3921);
		var1.writeStringCp1252NullCircumfixed(this.field3904);
		var1.writeStringCp1252NullCircumfixed(this.field3926);
		var1.writeByte(this.field3928);
		var1.writeShort(this.field3927);
		var1.writeStringCp1252NullCircumfixed(this.field3911);
		var1.writeStringCp1252NullCircumfixed(this.field3932);
		var1.writeByte(this.field3929);
		var1.writeByte(this.field3931);

		for (int var2 = 0; var2 < this.field3933.length; ++var2) {
			var1.writeInt(this.field3933[var2]);
		}

		var1.writeInt(this.field3934);
		var1.writeStringCp1252NullCircumfixed(this.field3935);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "-16149"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + GrandExchangeOfferOwnWorldComparator.method1245(this.field3923);
		var2 += GrandExchangeOfferOwnWorldComparator.method1245(this.field3921);
		var2 += GrandExchangeOfferOwnWorldComparator.method1245(this.field3904);
		var2 += GrandExchangeOfferOwnWorldComparator.method1245(this.field3926);
		var2 += GrandExchangeOfferOwnWorldComparator.method1245(this.field3911);
		var2 += GrandExchangeOfferOwnWorldComparator.method1245(this.field3932);
		var2 += GrandExchangeOfferOwnWorldComparator.method1245(this.field3935);
		return var2;
	}
}
