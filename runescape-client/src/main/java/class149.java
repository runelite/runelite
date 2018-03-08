import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class149 implements Comparator {
   @ObfuscatedName("t")
   final boolean field2098;

   public class149(boolean var1) {
      this.field2098 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)I",
      garbageValue = "-130846951"
   )
   int method3099(ChatPlayer var1, ChatPlayer var2) {
      return this.field2098?var1.field3842 - var2.field3842:var2.field3842 - var1.field3842;
   }

   public int compare(Object var1, Object var2) {
      return this.method3099((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2071453556"
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
         int var9 = var6 * class62.tileHeights[var5][var3 + 1][var4 + 1] + class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
