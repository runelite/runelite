import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -156500797
	)
	int field3910;
	@ObfuscatedName("aq")
	boolean field3900;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -2023762537
	)
	int field3912;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1361201989
	)
	int field3928;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 582354969
	)
	int field3914;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1969903695
	)
	int field3916;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 885412383
	)
	int field3901;
	@ObfuscatedName("ag")
	boolean field3919;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -1571360447
	)
	int field3918;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1817663209
	)
	int field3929;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -855226187
	)
	int field3911;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -180398763
	)
	int field3921;
	@ObfuscatedName("ax")
	String field3904;
	@ObfuscatedName("at")
	String field3923;
	@ObfuscatedName("af")
	String field3924;
	@ObfuscatedName("ap")
	String field3917;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 35861657
	)
	int field3926;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1513302613
	)
	int field3927;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -225133915
	)
	int field3922;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -1211564883
	)
	int field3902;
	@ObfuscatedName("bg")
	String field3930;
	@ObfuscatedName("bw")
	String field3931;
	@ObfuscatedName("bk")
	int[] field3925;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -2107690227
	)
	int field3933;
	@ObfuscatedName("bq")
	String field3934;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
		this.field3925 = new int[3];
		this.field3910 = var1;
		this.field3900 = var2;
		this.field3912 = var3;
		this.field3928 = var4;
		this.field3914 = var5;
		this.field3916 = var6;
		this.field3901 = var7;
		this.field3919 = var8;
		this.field3918 = var9;
		this.field3929 = var10;
		this.field3911 = var11;
		this.field3921 = var12;
		this.field3904 = var13;
		this.field3923 = var14;
		this.field3924 = var15;
		this.field3917 = var16;
		this.field3926 = var17;
		this.field3927 = var18;
		this.field3922 = var19;
		this.field3902 = var20;
		this.field3930 = var21;
		this.field3931 = var22;
		this.field3925 = var23;
		this.field3933 = var24;
		this.field3934 = var25;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "273462814"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(8);
		var1.writeByte(this.field3910);
		var1.writeByte(this.field3900 ? 1 : 0);
		var1.writeShort(this.field3912);
		var1.writeByte(this.field3928);
		var1.writeByte(this.field3914);
		var1.writeByte(this.field3916);
		var1.writeByte(this.field3901);
		var1.writeByte(this.field3919 ? 1 : 0);
		var1.writeShort(this.field3918);
		var1.writeByte(this.field3929);
		var1.writeMedium(this.field3911);
		var1.writeShort(this.field3921);
		var1.writeStringCp1252NullCircumfixed(this.field3904);
		var1.writeStringCp1252NullCircumfixed(this.field3923);
		var1.writeStringCp1252NullCircumfixed(this.field3924);
		var1.writeStringCp1252NullCircumfixed(this.field3917);
		var1.writeByte(this.field3927);
		var1.writeShort(this.field3926);
		var1.writeStringCp1252NullCircumfixed(this.field3930);
		var1.writeStringCp1252NullCircumfixed(this.field3931);
		var1.writeByte(this.field3922);
		var1.writeByte(this.field3902);

		for (int var2 = 0; var2 < this.field3925.length; ++var2) {
			var1.writeInt(this.field3925[var2]);
		}

		var1.writeInt(this.field3933);
		var1.writeStringCp1252NullCircumfixed(this.field3934);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "19008325"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + class290.method5375(this.field3904);
		var2 += class290.method5375(this.field3923);
		var2 += class290.method5375(this.field3924);
		var2 += class290.method5375(this.field3917);
		var2 += class290.method5375(this.field3930);
		var2 += class290.method5375(this.field3931);
		var2 += class290.method5375(this.field3934);
		return var2;
	}
}
