import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("h")
   static ModIcon field128;
   @ObfuscatedName("q")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("g")
   static int[] field130;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("ey")
   static ModIcon[] field132;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "953050773"
   )
   static final void method97(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class53.field1155[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }
}
