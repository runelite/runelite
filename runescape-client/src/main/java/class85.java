import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public final class class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -815589623
   )
   int field1455;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 269681899
   )
   int field1457;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 737270129
   )
   int field1458;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2124605517
   )
   int field1459;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1839325759
   )
   int field1460;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1503050581
   )
   int field1461;
   @ObfuscatedName("d")
   public static String field1462;
   @ObfuscatedName("n")
   boolean field1465 = true;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "754879417"
   )
   public static int method1685(int var0, int var1, int var2, int var3, int var4, int var5) {
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
      this.field1460 = var1;
      this.field1455 = var2;
      this.field1457 = var3;
      this.field1458 = var4;
      this.field1459 = var5;
      this.field1461 = var6;
      this.field1465 = var7;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-41"
   )
   static final int method1686(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class10.tileHeights[var5][var3][var4] * (128 - var6) + var6 * class10.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = class10.tileHeights[var5][var3][1 + var4] * (128 - var6) + class10.tileHeights[var5][var3 + 1][1 + var4] * var6 >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
