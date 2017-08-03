import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class18 implements Comparator {
   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field307;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   static IndexedSprite[] field306;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;B)I",
      garbageValue = "-36"
   )
   int method126(class14 var1, class14 var2) {
      return var1.method79().compareTo(var2.method79());
   }

   public int compare(Object var1, Object var2) {
      return this.method126((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-592121588"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class62.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class62.tileHeights[var5][var3][var4] + var6 * class62.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) + class62.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1411209594"
   )
   static boolean method133(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
