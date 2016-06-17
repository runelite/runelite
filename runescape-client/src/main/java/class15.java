import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("g")
   @Export("itemIds")
   int[] field216 = new int[]{-1};
   @ObfuscatedName("j")
   @Export("stackSizes")
   int[] field217 = new int[]{0};
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 266887535
   )
   public static int field219;
   @ObfuscatedName("b")
   @Export("itemContainers")
   static class196 field221 = new class196(32);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "19136995"
   )
   static final int method174(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "8"
   )
   static final void method175(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field91[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class5.field83[0][var5][var4] = class5.field83[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.field83[0][var5][var4] = class5.field83[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field83[0][var5][var4] = class5.field83[0][var5][var4 - 1];
               }

               if(var1 + var3 == var4 && var4 < 103) {
                  class5.field83[0][var5][var4] = class5.field83[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
