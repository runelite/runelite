import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1318366785
   )
   int field694;
   @ObfuscatedName("ah")
   boolean field695;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 703904161
   )
   int field696;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 467004305
   )
   int field697;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2097018521
   )
   int field698;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1667177301
   )
   int field699;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 385109109
   )
   int field700;
   @ObfuscatedName("at")
   boolean field701;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1765017
   )
   int field702;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -817941105
   )
   int field703;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 30207059
   )
   int field704;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 890109053
   )
   int field705;
   @ObfuscatedName("az")
   String field706;
   @ObfuscatedName("au")
   String field707;
   @ObfuscatedName("ao")
   String field708;
   @ObfuscatedName("aa")
   String field709;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 871094255
   )
   int field710;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1955966365
   )
   int field711;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1196598207
   )
   int field712;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -170839105
   )
   int field713;
   @ObfuscatedName("bb")
   String field714;
   @ObfuscatedName("bs")
   String field715;
   @ObfuscatedName("bq")
   int[] field716;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1466207635
   )
   int field717;
   @ObfuscatedName("bk")
   String field718;

   PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
      this.field716 = new int[3];
      this.field694 = var1;
      this.field695 = var2;
      this.field696 = var3;
      this.field697 = var4;
      this.field698 = var5;
      this.field699 = var6;
      this.field700 = var7;
      this.field701 = var8;
      this.field702 = var9;
      this.field703 = var10;
      this.field704 = var11;
      this.field705 = var12;
      this.field706 = var13;
      this.field707 = var14;
      this.field708 = var15;
      this.field709 = var16;
      this.field710 = var17;
      this.field711 = var18;
      this.field712 = var19;
      this.field713 = var20;
      this.field714 = var21;
      this.field715 = var22;
      this.field716 = var23;
      this.field717 = var24;
      this.field718 = var25;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1518809220"
   )
   @Export("write")
   public void write(Buffer var1) {
      var1.writeByte(7);
      var1.writeByte(this.field694);
      var1.writeByte(this.field695 ? 1 : 0);
      var1.writeByte(this.field696);
      var1.writeByte(this.field697);
      var1.writeByte(this.field698);
      var1.writeByte(this.field699);
      var1.writeByte(this.field700);
      var1.writeByte(this.field701 ? 1 : 0);
      var1.writeShort(this.field702);
      var1.writeByte(this.field703);
      var1.writeMedium(this.field704);
      var1.writeShort(this.field705);
      var1.writeStringCp1252NullCircumfixed(this.field706);
      var1.writeStringCp1252NullCircumfixed(this.field707);
      var1.writeStringCp1252NullCircumfixed(this.field708);
      var1.writeStringCp1252NullCircumfixed(this.field709);
      var1.writeByte(this.field711);
      var1.writeShort(this.field710);
      var1.writeStringCp1252NullCircumfixed(this.field714);
      var1.writeStringCp1252NullCircumfixed(this.field715);
      var1.writeByte(this.field712);
      var1.writeByte(this.field713);

      for (int var2 = 0; var2 < this.field716.length; ++var2) {
         var1.writeInt(this.field716[var2]);
      }

      var1.writeInt(this.field717);
      var1.writeStringCp1252NullCircumfixed(this.field718);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2071624512"
   )
   @Export("size")
   public int size() {
      byte var1 = 38;
      int var2 = var1 + Client.method1692(this.field706);
      var2 += Client.method1692(this.field707);
      var2 += Client.method1692(this.field708);
      var2 += Client.method1692(this.field709);
      var2 += Client.method1692(this.field714);
      var2 += Client.method1692(this.field715);
      var2 += Client.method1692(this.field718);
      return var2;
   }
}
