import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class228 implements class178 {
   @ObfuscatedName("x")
   public static final class228 field3146;
   @ObfuscatedName("c")
   public static final class228 field3147;
   @ObfuscatedName("h")
   public static final class228 field3148;
   @ObfuscatedName("v")
   public static final class228 field3149;
   @ObfuscatedName("b")
   public static final class228 field3150;
   @ObfuscatedName("y")
   public static final class228 field3151;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1143653283
   )
   final int field3152;
   @ObfuscatedName("e")
   public static final class228 field3153;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1689740313
   )
   public final int field3154;
   @ObfuscatedName("i")
   public static final class228 field3155;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var1, int var2) {
      this.field3154 = var1;
      this.field3152 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field3152;
   }

   static {
      field3155 = new class228(6, 0);
      field3147 = new class228(2, 1);
      field3153 = new class228(3, 2);
      field3149 = new class228(1, 3);
      field3150 = new class228(4, 4);
      field3151 = new class228(7, 5);
      field3148 = new class228(5, 6);
      field3146 = new class228(0, 7);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModel;IIII)Z",
      garbageValue = "630960146"
   )
   public static final boolean method4085(Model var0, int var1, int var2, int var3) {
      boolean var4 = class134.field2018;
      if(!var4) {
         return false;
      } else {
         class172.method3124();
         int var5 = var0.field1969 + var1;
         int var6 = var0.field1937 + var2;
         int var7 = var3 + var0.field1980;
         int var8 = var0.field1972;
         int var9 = var0.field1973;
         int var10 = var0.field1981;
         int var11 = class134.field2011 - var5;
         int var12 = class134.field2010 - var6;
         int var13 = WidgetNode.field842 - var7;
         return Math.abs(var11) > class24.field353 + var8?false:(Math.abs(var12) > var9 + XGrandExchangeOffer.field304?false:(Math.abs(var13) > var10 + DecorativeObject.field2195?false:(Math.abs(class227.field3140 * var13 - class89.field1429 * var12) > var9 * DecorativeObject.field2195 + XGrandExchangeOffer.field304 * var10?false:(Math.abs(var11 * class89.field1429 - class152.field2239 * var13) > var8 * DecorativeObject.field2195 + class24.field353 * var10?false:Math.abs(var12 * class152.field2239 - class227.field3140 * var11) <= XGrandExchangeOffer.field304 * var8 + var9 * class24.field353))));
      }
   }
}
