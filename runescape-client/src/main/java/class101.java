import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("GameObject")
public final class class101 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1286703391
   )
   @Export("flags")
   int field1727 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2041139321
   )
   @Export("height")
   int field1728;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1730519133
   )
   @Export("y")
   int field1729;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -670629819
   )
   @Export("plane")
   int field1730;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1638743575
   )
   int field1731;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -825959625
   )
   @Export("relativeX")
   int field1733;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -628708561
   )
   @Export("offsetX")
   int field1734;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1041323303
   )
   @Export("relativeY")
   int field1735;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1712556413
   )
   @Export("offsetY")
   int field1736;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 108356319
   )
   @Export("x")
   int field1737;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -531164911
   )
   int field1738;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1233026863
   )
   @Export("hash")
   public int field1739 = 0;
   @ObfuscatedName("l")
   @Export("renderable")
   public class88 field1740;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -511899255
   )
   @Export("orientation")
   int field1741;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILclass42;IB)V",
      garbageValue = "21"
   )
   static void method2279(int var0, int var1, int var2, class42 var3, int var4) {
      class24 var5 = new class24();
      var5.field602 = var0;
      var5.field607 = var1 * 128;
      var5.field617 = var2 * 128;
      int var6 = var3.field976;
      int var7 = var3.field980;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field980;
         var7 = var3.field976;
      }

      var5.field605 = (var1 + var6) * 128;
      var5.field606 = (var7 + var2) * 128;
      var5.field621 = var3.field986;
      var5.field601 = var3.field987 * 128;
      var5.field610 = var3.field965;
      var5.field611 = var3.field989;
      var5.field612 = var3.field990;
      if(var3.field983 != null) {
         var5.field615 = var3;
         var5.method582();
      }

      class24.field624.method3877(var5);
      if(null != var5.field612) {
         var5.field613 = var5.field610 + (int)(Math.random() * (double)(var5.field611 - var5.field610));
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "950015368"
   )
   static final void method2280(int var0, int var1, int var2, int var3) {
      if(client.field383 == 1) {
         class11.field161[client.field423 / 100].method1800(client.field380 - 8, client.field351 - 8);
      }

      if(client.field383 == 2) {
         class11.field161[client.field423 / 100 + 4].method1800(client.field380 - 8, client.field351 - 8);
      }

      class1.method10();
   }
}
