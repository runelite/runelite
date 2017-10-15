import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class54 {
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 261096063
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   static RSSocket field688;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexData field686;
   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   static SpritePixels[] field687;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1913001930"
   )
   static final boolean method813() {
      return class132.field1982;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-17"
   )
   static final void method812(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class174.field2411[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
