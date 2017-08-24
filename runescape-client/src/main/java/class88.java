import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class88 {
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -139685009
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static SpritePixels field1405;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1602063119
   )
   int field1404;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1391881777
   )
   int field1409;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -97661947
   )
   int field1406;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 254788401
   )
   int field1407;
   @ObfuscatedName("o")
   String field1408;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lfe;II)Lfe;",
      garbageValue = "1843559619"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   static final void method1716(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               VertexNormal.field2018[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-249290890"
   )
   static int method1715(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}
