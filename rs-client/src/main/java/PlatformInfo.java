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
   @Export("__ay")
   int __ay;
   @ObfuscatedName("ah")
   @Export("__ah")
   boolean __ah;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 703904161
   )
   @Export("__ak")
   int __ak;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 467004305
   )
   @Export("__aw")
   int __aw;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2097018521
   )
   @Export("__al")
   int __al;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1667177301
   )
   @Export("__ab")
   int __ab;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 385109109
   )
   @Export("__ae")
   int __ae;
   @ObfuscatedName("at")
   @Export("__at")
   boolean __at;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1765017
   )
   @Export("__ad")
   int __ad;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -817941105
   )
   @Export("__ap")
   int __ap;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 30207059
   )
   @Export("__am")
   int __am;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 890109053
   )
   @Export("__an")
   int __an;
   @ObfuscatedName("az")
   @Export("__az")
   String __az;
   @ObfuscatedName("au")
   @Export("__au")
   String __au;
   @ObfuscatedName("ao")
   @Export("__ao")
   String __ao;
   @ObfuscatedName("aa")
   @Export("__aa")
   String __aa;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 871094255
   )
   @Export("__ax")
   int __ax;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1955966365
   )
   @Export("__af")
   int __af;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1196598207
   )
   @Export("__ai")
   int __ai;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -170839105
   )
   @Export("__ba")
   int __ba;
   @ObfuscatedName("bb")
   @Export("__bb")
   String __bb;
   @ObfuscatedName("bs")
   @Export("__bs")
   String __bs;
   @ObfuscatedName("bq")
   @Export("__bq")
   int[] __bq;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1466207635
   )
   @Export("__bn")
   int __bn;
   @ObfuscatedName("bk")
   @Export("__bk")
   String __bk;

   PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
      this.__bq = new int[3];
      this.__ay = var1;
      this.__ah = var2;
      this.__ak = var3;
      this.__aw = var4;
      this.__al = var5;
      this.__ab = var6;
      this.__ae = var7;
      this.__at = var8;
      this.__ad = var9;
      this.__ap = var10;
      this.__am = var11;
      this.__an = var12;
      this.__az = var13;
      this.__au = var14;
      this.__ao = var15;
      this.__aa = var16;
      this.__ax = var17;
      this.__af = var18;
      this.__ai = var19;
      this.__ba = var20;
      this.__bb = var21;
      this.__bs = var22;
      this.__bq = var23;
      this.__bn = var24;
      this.__bk = var25;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1518809220"
   )
   @Export("write")
   public void write(Buffer var1) {
      var1.writeByte(7);
      var1.writeByte(this.__ay);
      var1.writeByte(this.__ah?1:0);
      var1.writeByte(this.__ak);
      var1.writeByte(this.__aw);
      var1.writeByte(this.__al);
      var1.writeByte(this.__ab);
      var1.writeByte(this.__ae);
      var1.writeByte(this.__at?1:0);
      var1.writeShort(this.__ad);
      var1.writeByte(this.__ap);
      var1.writeMedium(this.__am);
      var1.writeShort(this.__an);
      var1.writeStringCp1252NullCircumfixed(this.__az);
      var1.writeStringCp1252NullCircumfixed(this.__au);
      var1.writeStringCp1252NullCircumfixed(this.__ao);
      var1.writeStringCp1252NullCircumfixed(this.__aa);
      var1.writeByte(this.__af);
      var1.writeShort(this.__ax);
      var1.writeStringCp1252NullCircumfixed(this.__bb);
      var1.writeStringCp1252NullCircumfixed(this.__bs);
      var1.writeByte(this.__ai);
      var1.writeByte(this.__ba);

      for(int var2 = 0; var2 < this.__bq.length; ++var2) {
         var1.writeInt(this.__bq[var2]);
      }

      var1.writeInt(this.__bn);
      var1.writeStringCp1252NullCircumfixed(this.__bk);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2071624512"
   )
   @Export("size")
   public int size() {
      byte var1 = 38;
      int var2 = var1 + Client.method1692(this.__az);
      var2 += Client.method1692(this.__au);
      var2 += Client.method1692(this.__ao);
      var2 += Client.method1692(this.__aa);
      var2 += Client.method1692(this.__bb);
      var2 += Client.method1692(this.__bs);
      var2 += Client.method1692(this.__bk);
      return var2;
   }
}
