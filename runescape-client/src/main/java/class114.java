import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class114 {
   @ObfuscatedName("z")
   static int[] field1974;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   static final void method2496(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class216.field3159[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field99[0][var5][var4] = class5.field99[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class5.field99[0][var5][var4] = class5.field99[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field99[0][var5][var4] = class5.field99[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class5.field99[0][var5][var4] = class5.field99[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
