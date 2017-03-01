import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class25 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 383037067
   )
   int field575 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1600407965
   )
   int field576;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1345983627
   )
   int field577;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1465429481
   )
   int field578;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -412917267
   )
   int field579;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1029425695
   )
   int field580;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -842743425
   )
   int field581;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1488522101
   )
   int field582;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1245416563
   )
   int field583;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2082732937
   )
   int field584;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1280906469
   )
   int field585;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -682181497
   )
   int field586 = 0;
   @ObfuscatedName("f")
   static boolean field587;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lclass179;",
      garbageValue = "-1961140333"
   )
   public static class179[] method613() {
      return new class179[]{class179.field2688, class179.field2682, class179.field2686, class179.field2684, class179.field2683, class179.field2685};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1661684797"
   )
   public static int method614(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "307056089"
   )
   static final int method615(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class10.tileHeights[var5][var3 + 1][var4] * var6 + class10.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = class10.tileHeights[var5][var3][1 + var4] * (128 - var6) + class10.tileHeights[var5][var3 + 1][1 + var4] * var6 >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}
