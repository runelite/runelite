import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public final class class85 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -448987337
   )
   int field1470;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1522748235
   )
   int field1471;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1368926825
   )
   int field1472;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1523123049
   )
   static int field1473;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1071756227
   )
   int field1474;
   @ObfuscatedName("u")
   static boolean field1475;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 760157977
   )
   int field1476;
   @ObfuscatedName("n")
   boolean field1477 = true;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 632760491
   )
   int field1479;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZS)I",
      garbageValue = "-17684"
   )
   static int method1744(int var0, class48 var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class179.method3296(class32.field747[--class103.field1686]);
      } else {
         var3 = var2?XGrandExchangeOffer.field58:class24.field297;
      }

      if(var0 == 1927) {
         if(class32.field754 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2211 == null) {
            return 0;
         } else {
            class18 var4 = new class18();
            var4.field198 = var3;
            var4.field209 = var3.field2211;
            var4.field197 = 1 + class32.field754;
            Client.field435.method2453(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-939491741"
   )
   public static int method1745(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1476 = var1;
      this.field1471 = var2;
      this.field1472 = var3;
      this.field1470 = var4;
      this.field1474 = var5;
      this.field1479 = var6;
      this.field1477 = var7;
   }
}
